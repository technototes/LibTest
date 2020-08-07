package com.technototes.library.command;

import java.util.function.BooleanSupplier;

public class ConditionalCommand extends AbstractCommand {
    private BooleanSupplier supplier;
    private AbstractCommand command;
    public ConditionalCommand(BooleanSupplier b, AbstractCommand c){
        supplier = b;
        command = c;
    }
    @Override
    public void execute() {
        if(supplier.getAsBoolean())
            CommandScheduler.getInstance().schedule(command);
    }
}
