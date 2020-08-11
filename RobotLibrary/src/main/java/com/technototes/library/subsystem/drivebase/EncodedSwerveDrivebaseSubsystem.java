package com.technototes.library.subsystem.drivebase;

import com.technototes.library.hardware.motor.EncodedMotor;
import com.technototes.library.hardware.motor.Motor;

public class EncodedSwerveDrivebaseSubsystem extends SwerveDrivebaseSubsystem<EncodedMotor> {
    public EncodedSwerveDrivebaseSubsystem(EncodedMotor... d) {
        super(d);
    }
}
