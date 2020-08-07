package com.technototes.library.command;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class CommandScheduler implements Runnable{
    private static CommandScheduler instance;
    public static synchronized CommandScheduler getInstance() {
        if (instance == null) {
            instance = new CommandScheduler();
        }
        return instance;
    }
    public enum State {
        NEW, INITIALIZED, EXECUTED, FINISHED
    }
    public enum Type{
        ONE_USE, MULTI_USE
    }
    public static class CommandState{
        public State state;
        public Type type = Type.MULTI_USE;
        public CommandState(){
            state = State.NEW;
        }
        public CommandState(Type t){
            new CommandState();
            type = t;
        }
    }

    private Map<AbstractCommand, CommandState> scheduled = new LinkedHashMap<>();

    public void schedule(AbstractCommand c){
        scheduled.putIfAbsent(c, new CommandState(Type.MULTI_USE));
    }
    public void schedule(BooleanSupplier b, AbstractCommand c){
        schedule(new ConditionalCommand(b, c));
    }

    @Override
    public void run() {
        scheduled.forEach((command, state) ->{
            command.run(state);
            if(state.state == State.FINISHED && state.type.equals(Type.ONE_USE))
                scheduled.remove(command);
        });
    }
}
