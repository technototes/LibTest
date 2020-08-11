package com.technototes.library.command;

public class ParallelCommandGroup extends CommandGroup {
    @Override
    public void runCommands() {
        commands.forEach(command -> run());
    }

    @Override
    public boolean isFinished() {
        for(Command c : commands) {
            if (c.commandState.state != State.RESET) {
                return false;
            }
        }
        return true;
    }
}
