package com.technototes.library.subsystem.motor;

import com.technototes.library.hardware.motor.Motor;
import com.technototes.library.hardware.motor.MotorGroup;

public class SimpleMotorSubsystem extends MotorSubsystem<Motor> {
    public SimpleMotorSubsystem(Motor m1, Motor... m2){
        super(new MotorGroup(m1, m2));
    }
}
