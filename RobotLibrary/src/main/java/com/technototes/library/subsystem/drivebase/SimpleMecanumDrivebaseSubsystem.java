package com.technototes.library.subsystem.drivebase;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.technototes.library.hardware.motor.Motor;

public class SimpleMecanumDrivebaseSubsystem extends MecanumDrivebaseSubsystem<Motor> {
    public SimpleMecanumDrivebaseSubsystem(Motor<DcMotor> flMotor, Motor<DcMotor> frMotor, Motor<DcMotor> rlMotor, Motor<DcMotor> rrMotor) {
        super(flMotor, frMotor, rlMotor, rrMotor);
    }
}
