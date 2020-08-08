package com.technototes.library.command;

import java.util.function.BooleanSupplier;

public class ConditionalCommand extends Command {
    private BooleanSupplier supplier;
    private Command command;
    public ConditionalCommand(BooleanSupplier b, Command c){
        supplier = b;
        command = c;
    }
    @Override
    public void execute() {
        CommandScheduler.getInstance().schedule(command);
    }

    @Override
    public void run() {
        switch (commandState.state) {
            case NEW:
                if (supplier.getAsBoolean()) {
                    init();
                    commandState.state = State.INITIALIZED;
                }
                return;
            case INITIALIZED:
                execute();
                commandState.state = isFinished() ? State.EXECUTED : State.INITIALIZED;
                return;
            case EXECUTED:
                end();
                commandState.state = State.NEW;
                return;
        }
    }
}
