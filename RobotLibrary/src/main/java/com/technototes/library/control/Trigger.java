package com.technototes.library.control;

import com.technototes.library.command.AbstractCommand;

public abstract class Trigger{
    public abstract void whenActivated(AbstractCommand c);
    public abstract void whenDeactivated(AbstractCommand c);

    public abstract void whileActivated(AbstractCommand c);
    public abstract void whileDeactivated(AbstractCommand c);

    public abstract void toggleWhenActivated(AbstractCommand c);
    public abstract void toggleWhenDeactivated(AbstractCommand c);

    public abstract void toggleWhileActivated(AbstractCommand c);
    public abstract void toggleWhileDeactivated(AbstractCommand c);

}
