package com.technototes.library.control;

import com.technototes.library.command.Command;

public abstract class Trigger{
    public abstract void whenActivated(Command c);
    public abstract void whenDeactivated(Command c);

    public abstract void whileActivated(Command c);
    public abstract void whileDeactivated(Command c);

    public abstract void toggleWhenActivated(Command c);
    public abstract void toggleWhenDeactivated(Command c);

    public abstract void toggleWhileActivated(Command c);
    public abstract void toggleWhileDeactivated(Command c);

}
