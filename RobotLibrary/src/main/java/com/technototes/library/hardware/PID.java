package com.technototes.library.hardware;

public interface PID {

    void setPIDValues(double p, double i, double d);
    void setPositionPID(double val);

    @Deprecated
    enum ControlType{
        POSITION, VELOCITY;
    }
}
