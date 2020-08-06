package com.technototes.library.hardware.servo;

import com.qualcomm.robotcore.util.Range;
import com.technototes.library.hardware.Followable;
import com.technototes.library.hardware.HardwareDevice;
import com.technototes.library.hardware.Invertable;
import com.technototes.library.hardware.PID;
import com.technototes.library.hardware.Proportional;
import com.technototes.library.hardware.Sensored;
import com.technototes.library.util.PIDUtils;

public class Servo<T extends com.qualcomm.robotcore.hardware.Servo> extends HardwareDevice<T> implements Sensored, Proportional, Invertable, Followable<Servo>, PID {

    public double pid_p, pid_i, pid_d;

    public Servo(HardwareDevice<T> d) {
        super(d);
    }
    public Servo(T d) {
        super(d);
    }

    @Override
    public void setInverted(boolean val) {
        device.setDirection(val ? com.qualcomm.robotcore.hardware.Servo.Direction.FORWARD : com.qualcomm.robotcore.hardware.Servo.Direction.REVERSE);
    }

    @Override
    public boolean getInverted() {
        return device.getDirection() == com.qualcomm.robotcore.hardware.Servo.Direction.FORWARD;
    }

    @Override
    public void set(double val) {
        device.setPosition(val);
    }

    @Override
    public double getSensorValue() {
        return device.getPosition();
    }

    public void setRange(double min, double max){
        device.scaleRange(min, max);
    }

    @Override
    public void follow(Servo d) {
        //TODO make this call constantly because it wont
        device.setPosition(d.getSensorValue());
    }

    @Override
    public void setPID(double p, double i, double d) {
        pid_p = p;
        pid_i = i;
        pid_d = d;
    }

    @Override
    public void PIDControl(double val) {
        device.setPosition(PIDUtils.calculatePIDDouble(pid_p, pid_i, pid_d, device.getPosition(), val));
    }

}
