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

    private Map<Command, Command.CommandState> scheduledCommands = new LinkedHashMap<>();

    public void schedule(Command c){
        scheduledCommands.putIfAbsent(c, c.commandState);
    }
    public void schedule(BooleanSupplier b, Command c){
        schedule(new ConditionalCommand(b, c));
    }

    @Override
    public void run() {
        scheduledCommands.forEach((command, state) ->{
            command.run();
        });
    }
}
