package com.technototes.library.hardware.motor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.technototes.library.hardware.Followable;
import com.technototes.library.hardware.HardwareDevice;
import com.technototes.library.hardware.Invertable;
import com.technototes.library.hardware.Proportional;
import com.technototes.library.util.UnsupportedFeatureException;

public class Motor<T extends DcMotorSimple> extends HardwareDevice<T> implements Proportional, Invertable, Followable<Motor> {
    public Motor(T d) {
        super(d);
    }
    @Override
    public void setInverted(boolean val) {
        device.setDirection(val ? DcMotorSimple.Direction.FORWARD : DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public boolean getInverted() {
        return device.getDirection() == DcMotorSimple.Direction.FORWARD;
    }

    @Override
    public void set(double val) {
        device.setPower(val);
    }

    public double get(){
        return device.getPower();
    }

    @Override
    public void follow(Motor d) {
        set(d.get());
    }
    public void setIdleBehavior(DcMotor.ZeroPowerBehavior b) throws UnsupportedFeatureException {
        if(device instanceof DcMotor){
            ((DcMotor)device).setZeroPowerBehavior(b);
        }else{
            throw new UnsupportedFeatureException("Idle behavior for CRServos", "in the SDK it does not exist");
        }
    }

}
