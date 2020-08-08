package com.technototes.library.control.gamepad;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.technototes.library.command.CommandScheduler;
import com.technototes.library.command.Command;
import com.technototes.library.control.Trigger;

import java.util.function.BooleanSupplier;

@RequiresApi(api = Build.VERSION_CODES.N)
public class ButtonGamepadComponent extends Trigger implements BooleanSupplier {
    private BooleanSupplier supplier;
    private CommandScheduler cs;
    private boolean pastState = false, normalToggle = false, inverseToggle = true;
    public ButtonGamepadComponent(BooleanSupplier b){
        supplier = b;
        cs = CommandScheduler.getInstance();
    }
    private boolean uponPress(){
        boolean b = supplier.getAsBoolean() && !pastState;
        pastState = supplier.getAsBoolean();
        return b;
    }
    private boolean uponRelease(){
        boolean b = !supplier.getAsBoolean() && pastState;
        pastState = supplier.getAsBoolean();
        return b;
    }
    public void whenActivated(Command c){
        cs.schedule(this::uponPress, c);
    }
    public void whenDeactivated(Command c){
        cs.schedule(this::uponRelease, c);
    }

    @Override
    public void whileActivated(Command c) {
        cs.schedule(() -> getAsBoolean(), c);
    }
    @Override
    public void whileDeactivated(Command c) {
        cs.schedule(() -> !getAsBoolean(), c);
    }

    public void toggleWhenActivated(Command c){
        cs.schedule(() -> (normalToggle = uponPress() ? !normalToggle : normalToggle) && uponPress(), c);
    }
    public void toggleWhenDeactivated(Command c){
        cs.schedule(() -> (inverseToggle = uponRelease() ? !inverseToggle : inverseToggle) && uponRelease(), c);
    }

    @Override
    public void toggleWhileActivated(Command c) {
        cs.schedule(() -> normalToggle = uponPress() ? !normalToggle : normalToggle, c);

    }
    @Override
    public void toggleWhileDeactivated(Command c) {
        cs.schedule(() -> inverseToggle = uponRelease() ? !inverseToggle : inverseToggle, c);
    }

    @Override
    public boolean getAsBoolean() {
        return supplier.getAsBoolean();
    }

}
