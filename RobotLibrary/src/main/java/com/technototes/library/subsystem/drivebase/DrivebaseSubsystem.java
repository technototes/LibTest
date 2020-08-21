package com.technototes.library.subsystem.drivebase;

import com.technototes.library.hardware.motor.Motor;
import com.technototes.library.subsystem.PID;
import com.technototes.library.subsystem.Subsystem;
import com.technototes.library.subsystem.servo.Scaleable;

import java.util.function.DoubleSupplier;

public abstract class DrivebaseSubsystem<T extends Motor> extends Subsystem<T> implements Scaleable {
    public double scale = 1;//DEFAULT
    public DrivebaseSubsystem(T... d) {
        super(d);
    }
    public DrivebaseSubsystem(double s, T... d) {
        super(d);
        scale = s;
    }
    public void stop(){
        for(Motor m : devices){
            m.setSpeed(0);
        }
    }

    @Override
    public void setScale(double s) {
        scale = s;
    }

    @Override
    public double getScale() {
        return scale;
    }
}
