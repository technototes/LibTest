package com.technototes.library.subsystem.motor;

import com.technototes.library.hardware.motor.EncodedMotor;
import com.technototes.library.hardware.motor.EncodedMotorGroup;
import com.technototes.library.hardware.servo.Servo;
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

    public boolean setPosition(double ticks){
        boolean b = true;
        for(EncodedMotor s : devices){
            s.setPosition(ticks);
            if(!s.isAtPosition(ticks))
                b = false;
        }
        return b;
    }

    @Override
    public void setPIDValues(double p, double i, double d) {
        for(EncodedMotor m : devices) {
            m.setPIDValues(p, i, d);
        }
    }

    @Override
    public boolean setPositionPID(double ticks) {
        boolean b = true;
        for(EncodedMotor s : devices){
            s.setPositionPID(ticks);
            if(!s.isAtPosition(ticks))
                b = false;
        }
        return b;
    }

    @Override
    public boolean setPositionPID(double p, double i, double d, double ticks) {
        setPIDValues(p, i, d);
        return setPositionPID(ticks);
    }
}
