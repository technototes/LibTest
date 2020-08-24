package com.technototes.library.hardware.motor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.technototes.library.hardware.HardwareDevice;
import com.technototes.library.hardware.PID;
import com.technototes.library.hardware.Sensored;
import com.technototes.library.hardware.sensor.encoder.Encoder;
import com.technototes.library.hardware.sensor.encoder.MotorEncoderSensor;
import com.technototes.library.util.PIDUtils;

public class EncodedMotor<T extends DcMotor> extends Motor<T> implements Sensored, PID {

    public double pid_p, pid_i, pid_d;
    public double threshold = 5;
    private Encoder encoder;

    public EncodedMotor(T d) {
        super(d);
        encoder = new MotorEncoderSensor(d);
    }

    public EncodedMotor(HardwareDevice<T> m) {
        super(m.getDevice());
    }

    @Override
    public EncodedMotor setInverted(boolean val) {
        device.setDirection(val ? DcMotorSimple.Direction.FORWARD : DcMotorSimple.Direction.REVERSE);
        return this;
    }

    @Override
    public double getSensorValue() {
        return (device.getDirection() == DcMotorSimple.Direction.FORWARD) ? encoder.getSensorValue() : -encoder.getSensorValue();
    }

    @Override
    public void setPIDValues(double p, double i, double d) {
        pid_p = p;
        pid_i = i;
        pid_d = d;
    }

    @Override
    public boolean setPositionPID(double val) {
        if (!isAtPosition(val))
            device.setPower(PIDUtils.calculatePIDDouble(pid_p, pid_i, pid_d, getSensorValue(), val));
        else
            device.setPower(0);
        return isAtPosition(val);
    }

    public boolean setPosition(double ticks) {
        return setPosition(ticks, 0.5);
    }

    public boolean setPosition(double ticks, double speed) {
        if (!isAtPosition(ticks))
            setSpeed(getSensorValue() < ticks ? speed : -speed);
        else
            setSpeed(0);
        return isAtPosition(ticks);
    }

    public boolean isAtPosition(double ticks) {
        return ticks - getSensorValue() > threshold;
    }

    public void resetEncoder() {
        encoder.zeroEncoder();
    }

}
