package com.technototes.library.subsystem.drivebase;

import com.technototes.library.hardware.motor.EncodedMotor;
import com.technototes.library.hardware.motor.Motor;

public class EncodedTankDrivebaseSubsystem extends TankDrivebaseSubsystem<EncodedMotor> {
    public EncodedTankDrivebaseSubsystem(EncodedMotor l, EncodedMotor r) {
        super(l, r);
    }
}
