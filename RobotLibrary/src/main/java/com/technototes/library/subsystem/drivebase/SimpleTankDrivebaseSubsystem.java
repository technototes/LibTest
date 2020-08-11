package com.technototes.library.subsystem.drivebase;

import com.technototes.library.hardware.motor.Motor;

public class SimpleTankDrivebaseSubsystem extends TankDrivebaseSubsystem<Motor> {
    public SimpleTankDrivebaseSubsystem(Motor l, Motor r) {
        super(l, r);
    }
}
