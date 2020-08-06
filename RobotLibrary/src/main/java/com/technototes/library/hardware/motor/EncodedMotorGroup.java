package com.technototes.library.hardware.motor;

import com.technototes.library.hardware.HardwareDeviceGroup;
import com.technototes.library.hardware.motor.EncodedMotor;
import com.technototes.library.hardware.motor.Motor;

public class EncodedMotorGroup extends EncodedMotor implements HardwareDeviceGroup<Motor> {
    private Motor[] followers;
    public EncodedMotorGroup(EncodedMotor leader, Motor... f) {
        super(leader);
        followers = f;
        for(Motor s : f) {
            s.follow(leader);
        }
    }

    @Override
    public Motor[] getFollowers() {
        return followers;
    }
}
