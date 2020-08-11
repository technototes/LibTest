package com.technototes.library.subsystem.motor;

import com.technototes.library.hardware.motor.EncodedMotor;
import com.technototes.library.hardware.motor.EncodedMotorGroup;
import com.technototes.library.subsystem.PID;

public class EncodedMotorSubsystem extends MotorSubsystem<EncodedMotor> implements PID {
    public double maxSpeed = 0.5;
    public EncodedMotorSubsystem(EncodedMotor... m){
        super(m);
    }
    public EncodedMotorSubsystem setMaxSpeed(double s){
        maxSpeed = s;
        return this;
    }

    public void setPosition(double ticks){
        for(EncodedMotor m : devices){
            m.setPosition(ticks, maxSpeed);
        }
    }

    @Override
    public void setPIDValues(double p, double i, double d) {
        for(EncodedMotor m : devices) {
            m.setPIDValues(p, i, d);
        }
    }

    @Override
    public void setPositionPID(double ticks) {
        for(EncodedMotor m : devices) {
            m.setPositionPID(ticks);
        }
    }

    @Override
    public void setPositionPID(double p, double i, double d, double ticks) {
        setPIDValues(p, i, d);
        setPositionPID(ticks);
    }
}
