package com.technototes.library.subsystem.drivebase;

import com.technototes.library.hardware.motor.Motor;
import com.technototes.library.subsystem.PID;
import com.technototes.library.subsystem.Subsystem;

import java.util.function.DoubleSupplier;

public abstract class DrivebaseSubsystem<T extends Motor> extends Subsystem<T> {
    public DrivebaseSubsystem(T... d) {
        super(d);
    }
    public void stop(){
        for(Motor m : devices){
            m.setSpeed(0);
        }
    }
}
