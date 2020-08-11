package com.technototes.library.subsystem.drivebase;

import com.technototes.library.hardware.motor.EncodedMotor;
import com.technototes.library.hardware.motor.Motor;

import java.util.function.DoubleSupplier;

public class EncodedMecanumDrivebaseSubsystem extends MecanumDrivebaseSubsystem<EncodedMotor> {
    public EncodedMecanumDrivebaseSubsystem(EncodedMotor... d) {
        super(d);
    }
    public EncodedMecanumDrivebaseSubsystem(DoubleSupplier sup, EncodedMotor... d) {
        super(sup, d);
    }

}
