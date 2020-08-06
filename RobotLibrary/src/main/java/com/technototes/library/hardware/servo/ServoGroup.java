package com.technototes.library.hardware.servo;

import com.technototes.library.hardware.HardwareDeviceGroup;

public class ServoGroup extends Servo implements HardwareDeviceGroup<Servo> {
    private Servo[] followers;
    public ServoGroup(Servo leader, Servo... f) {
        super(leader);
        followers = f;
        for(Servo s : f) {
            s.follow(leader);
        }
    }

    @Override
    public Servo[] getFollowers() {
        return followers;
    }
}