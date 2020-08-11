package com.technototes.library.subsystem.drivebase;

import com.technototes.library.control.gamepad.CommandGamepad;
import com.technototes.library.hardware.motor.Motor;

public abstract class TankDrivebaseSubsystem<T extends Motor> extends DrivebaseSubsystem<T> {
    private Motor leftSide, rightSide;
    public TankDrivebaseSubsystem(T l, T r) {
        super(l, r);
        leftSide = l;
        rightSide = r;
    }
    public void arcadeDrive(double x, double y){
        leftSide.setSpeed(y-2*x);
        rightSide.setSpeed(-y+2*x);
    }
    public void arcadeDrive(CommandGamepad.Stick s){
        arcadeDrive(s.getXAxis(), s.getYAxis());
    }
    public void tankDrive(double l, double r){
        leftSide.setSpeed(l);
        rightSide.setSpeed(-r);
    }
}
