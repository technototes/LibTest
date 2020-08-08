package com.technototes.library.command;

public class ParallelRaceGroup extends CommandGroup {
    @Override
    public void run() {
        if(isFinished()) {
            commandState.state = State.FINISHED;
        } else {
            commands.forEach((command) -> run());
        }
    }

    @Override
    public boolean isFinished() {
        for(Command c : commands) {
            if (c.commandState.state == State.FINISHED) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void runCommands() {
        commands.forEach(command -> run());
    }
}
