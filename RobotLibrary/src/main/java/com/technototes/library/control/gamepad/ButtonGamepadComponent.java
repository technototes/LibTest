package com.technototes.library.control.gamepad;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.technototes.library.command.CommandScheduler;
import com.technototes.library.command.Command;
import com.technototes.library.control.Trigger;

import java.util.function.BooleanSupplier;

@RequiresApi(api = Build.VERSION_CODES.N)
public class ButtonGamepadComponent extends Trigger implements BooleanSupplier {
    private BooleanSupplier booleanSupplier;
    private CommandScheduler commandScheduler;
    private boolean pastState = false, normalToggle = false, inverseToggle = true;
    public ButtonGamepadComponent(BooleanSupplier b){
        booleanSupplier = b;
        commandScheduler = CommandScheduler.getInstance();
    }
    private boolean uponPress(){
        boolean b = booleanSupplier.getAsBoolean() && !pastState;
        pastState = booleanSupplier.getAsBoolean();
        return b;
    }
    private boolean uponRelease(){
        boolean b = !booleanSupplier.getAsBoolean() && pastState;
        pastState = booleanSupplier.getAsBoolean();
        return b;
    }
    public void whenActivated(Command c){
        commandScheduler.schedule(this::uponPress, c);
    }
    public void whenDeactivated(Command c){
        commandScheduler.schedule(this::uponRelease, c);
    }

    @Override
    public void whileActivated(Command c) {
        commandScheduler.schedule(() -> getAsBoolean(), c);
    }
    @Override
    public void whileDeactivated(Command c) {
        commandScheduler.schedule(() -> !getAsBoolean(), c);
    }

    public void toggleWhenActivated(Command c){
        commandScheduler.schedule(() -> (normalToggle = uponPress() ? !normalToggle : normalToggle) && uponPress(), c);
    }
    public void toggleWhenDeactivated(Command c){
        commandScheduler.schedule(() -> (inverseToggle = uponRelease() ? !inverseToggle : inverseToggle) && uponRelease(), c);
    }

    @Override
    public void toggleWhileActivated(Command c) {
        commandScheduler.schedule(() -> normalToggle = uponPress() ? !normalToggle : normalToggle, c);

    }
    @Override
    public void toggleWhileDeactivated(Command c) {
        commandScheduler.schedule(() -> inverseToggle = uponRelease() ? !inverseToggle : inverseToggle, c);
    }

    @Override
    public boolean getAsBoolean() {
        return booleanSupplier.getAsBoolean();
    }

}
