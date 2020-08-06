package com.technototes.library.hardware;

public interface PID {

    void setPID(double p, double i, double d);
    void PIDControl(double val);

    @Deprecated
    enum ControlType{
        POSITION, VELOCITY;
    }
}
