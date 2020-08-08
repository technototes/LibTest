package com.technototes.library.command;


public class SequentialCommandGroup extends CommandGroup {
    private int currentCommandIndex = 0;
    @Override
    public void runCommands() {
        Command currentCommand = commands.get(currentCommandIndex);
        currentCommand.run();
        if(currentCommand.isFinished()){
            currentCommandIndex++;
        }
    }

    @Override
    public boolean isFinished() {
        for(Command c : commands) {
            if (c.commandState.state != State.FINISHED) {
                return false;
            }
        }
        return true;
    }
    public Command getCurrentCommand(){
        return commands.get(currentCommandIndex);
    }
}
