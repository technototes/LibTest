package com.technototes.library.command;

public class InstantCommand extends Command {
    private Runnable runnable;

    public InstantCommand(Runnable r) {
    }

    @Override
    public void execute() {
        runnable.run();
    }
}
