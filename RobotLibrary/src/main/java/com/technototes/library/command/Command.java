package com.technototes.library.command;


import com.technototes.library.subsystem.Subsystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BooleanSupplier;

public class Command implements Runnable{
    public enum State {
        RESET, INITIALIZED, EXECUTED
    }
    @Deprecated
    public enum Type{
        ONE_USE, MULTI_USE
    }

    public static class CommandState{
        public State state;
        public Type type = Type.MULTI_USE;
        public CommandState(){
            state = State.RESET;
        }
        public CommandState(Type t){
            new CommandState();
            type = t;
        }

    }

    public CommandState commandState;
    protected Set<Subsystem> subsystems = new HashSet<>();

    public Command(){
        commandState = new CommandState();
    }

    public void addRequirements(Subsystem... requirements){
        subsystems.addAll(Arrays.asList(requirements));
    }
    public void init(){

    }
    public void execute(){

    }
    public boolean isFinished(){
        return true;
    }
    public void end(){

    }
    public Command andThen(Command c){
        CommandScheduler.getInstance().schedule(() -> this.isFinished(), c);
        return c;
    }
    public Command andThen(BooleanSupplier b, Command c){
        CommandScheduler.getInstance().schedule(() -> this.isFinished()&&b.getAsBoolean(), c);
        return c;
    }

    @Override
    public void run(){
        switch (commandState.state){
            case RESET:
                init();
                commandState.state = State.INITIALIZED;
                //THERE IS NO RETURN HERE SO IT FALLS THROUGH TO POST-INITIALIZATION
            case INITIALIZED:
                execute();
                commandState.state = isFinished() ? State.EXECUTED : State.INITIALIZED;
                return;
            case EXECUTED:
                end();
                commandState.state = State.RESET;
                return;
        }

    }
}
