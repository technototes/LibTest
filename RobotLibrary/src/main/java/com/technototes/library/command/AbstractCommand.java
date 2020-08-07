package com.technototes.library.command;


public abstract class AbstractCommand {
    public void init(){

    }
    public void execute(){

    }
    public boolean isFinished(){
        return true;
    }
    public void end(){

    }

    protected void run(CommandScheduler.CommandState s){
        switch (s.state){
            case NEW:
                init();
                s.state = CommandScheduler.State.INITIALIZED;
                return;
            case INITIALIZED:
                execute();
                s.state = isFinished() ? CommandScheduler.State.EXECUTED : CommandScheduler.State.INITIALIZED;
                return;
            case EXECUTED:
                end();
                s.state = CommandScheduler.State.FINISHED;
                return;
        }

    }
}
