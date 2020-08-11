package com.technototes.library.subsystem;

public interface PID {
    void setPIDValues(double p, double i, double d);
    void setPositionPID(double ticks);
    void setPositionPID(double p, double i, double d, double ticks);
}
