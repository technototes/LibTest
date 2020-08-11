package com.technototes.library.subsystem.drivebase;

import com.qualcomm.robotcore.util.Range;
import com.technototes.library.hardware.motor.Motor;

import java.util.function.DoubleSupplier;

public abstract class MecanumDrivebaseSubsystem<T extends Motor> extends OmnidirectionalDrivebaseSubsystem<T> {
    public T flMotor, frMotor, rlMotor, rrMotor;
    public MecanumDrivebaseSubsystem(T... d){
        super(d);
        flMotor = d[0];
        frMotor = d[1];
        rlMotor = d[2];
        rrMotor = d[3];
    }
    public MecanumDrivebaseSubsystem(DoubleSupplier gyro, T... d){
        super(gyro, d);

    }

    @Override
    public void drive(double speed, double angle) {
        angle+=gyroSupplier.getAsDouble();
        double angleRad = Math.toRadians(angle);
        speed = Range.clip(speed, 0.0, 1.0);
        double robotHeadingRad = Math.toRadians(angle);
        double powerCompY =
                speed
                        * (Math.cos(robotHeadingRad) * Math.cos(angleRad)
                        + Math.sin(robotHeadingRad) * Math.sin(angleRad));
        double powerCompX =
                speed
                        * (Math.cos(robotHeadingRad) * Math.sin(angleRad)
                        - Math.sin(robotHeadingRad) * Math.cos(angleRad));

        flMotor.setSpeed(powerCompY + powerCompX);
        flMotor.setSpeed(-powerCompY + powerCompX);
        flMotor.setSpeed(powerCompY - powerCompX);
        flMotor.setSpeed(-powerCompY - powerCompX);
    }
}
