package com.technototes.library.control.gamepad;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.technototes.library.command.CommandScheduler;
import com.technototes.library.command.AbstractCommand;
import com.technototes.library.control.Trigger;

import java.util.function.BooleanSupplier;

@RequiresApi(api = Build.VERSION_CODES.N)
public class ButtonGamepadComponent extends Trigger implements BooleanSupplier {
    private BooleanSupplier supplier;
    private CommandScheduler cs;
    private boolean pastState = false;
    public ButtonGamepadComponent(BooleanSupplier b){
        supplier = b;
        cs = CommandScheduler.getInstance();
    }

    public void whenActivated(AbstractCommand c){
        cs.schedule(() -> {
            boolean b = supplier.getAsBoolean() && !pastState;
            pastState = supplier.getAsBoolean();
            return b;
        }, c);
    }
    public void whenDeactivated(AbstractCommand c){
        cs.schedule(() -> {
            boolean b = !supplier.getAsBoolean() && pastState;
            pastState = supplier.getAsBoolean();
            return b;
        }, c);
    }

    @Override
    public void whileActivated(AbstractCommand c) {
        //cs.schedule(() -> supplier.getAsBoolean(), c, CommandScheduler.Type.CONTINUOUS);
    }
    @Override
    public void whileDeactivated(AbstractCommand c) {
        //cs.schedule(() -> !supplier.getAsBoolean(), c, CommandScheduler.Type.CONTINUOUS);
    }

    public void toggleWhenActivated(AbstractCommand c){
        //cs.schedule(() -> {

           // return supplier.getAsBoolean();
        //}, c, CommandScheduler.Type.NON_CONTINUOUS);
    }
    public void toggleWhenDeactivated(AbstractCommand c){

    }

    @Override
    public void toggleWhileActivated(AbstractCommand c) {

    }

    @Override
    public void toggleWhileDeactivated(AbstractCommand c) {

    }

    @Override
    public boolean getAsBoolean() {
        return supplier.getAsBoolean();
    }

}
