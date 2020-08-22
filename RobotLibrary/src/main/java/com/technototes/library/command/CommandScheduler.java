package com.technototes.library.command;


import com.technototes.library.structure.CommandOpMode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class CommandScheduler implements Runnable{
    private static CommandScheduler instance, initInstance, runInstance, endInstance;
    public static synchronized CommandScheduler getInstance(){
        return getSelectedInstance(instance);
    }
    public static synchronized CommandScheduler getSelectedInstance(CommandScheduler c){
        if (c == null) {
            c = new CommandScheduler();
        }
        return c;
    }
    public static synchronized CommandScheduler setCurrentInstance(CommandOpMode.OpModeState s){
        instance.runLastTime();
        switch (s){
            case INIT:
                instance = getSelectedInstance(initInstance);
                break;
            case RUN:
                instance = getSelectedInstance(runInstance);
                break;
            case FINISHED:
                instance = getSelectedInstance(endInstance);
                break;
        }
        return instance;
    }

    public Map<Command, Command.CommandState> scheduledCommands = new LinkedHashMap<>();

    public void schedule(Command c){
        scheduledCommands.putIfAbsent(c, c.commandState);
    }
    public void schedule(BooleanSupplier b, Command c){
        schedule(new ConditionalCommand(b, c));
    }

    //for finalizing all commands
    public void runLastTime(){
        scheduledCommands.forEach((command, state) ->{
            command.run();
            if(!command.isFinished()) {
                command.end();
                command.commandState.state = Command.State.RESET;
            }
        });
    }
    @Override
    public void run() {
        scheduledCommands.forEach((command, state) ->{
            command.run();
        });
    }
}
