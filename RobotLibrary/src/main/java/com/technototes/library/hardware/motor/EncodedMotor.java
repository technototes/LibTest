package com.technototes.library.hardware.motor;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.technototes.library.hardware.HardwareDevice;
import com.technototes.library.hardware.PID;
import com.technototes.library.hardware.Sensored;
import com.technototes.library.hardware.sensor.encoder.Encoder;
import com.technototes.library.hardware.sensor.encoder.MotorEncoderSensor;
import com.technototes.library.util.PIDUtils;
import com.technototes.library.util.UnsupportedFeatureException;
@RequiresApi(api = Build.VERSION_CODES.N)
public class EncodedMotor<T extends DcMotor> extends Motor<T> implements Sensored, PID {

    public double pid_p, pid_i, pid_d;
    private Encoder encoder;
    public double threshold = 5;

    public EncodedMotor(T d){
        super(d);
        encoder = new MotorEncoderSensor(d);
    }
    public EncodedMotor(HardwareDevice<T> m){
        super(m.getDevice());
    }

    @Override
    public double getSensorValue() {
        return encoder.getSensorValue();
    }

    @Override
    public void setPIDValues(double p, double i, double d) {
        pid_p = p;
        pid_i = i;
        pid_d = d;
    }

    @Override
    public void setPositionPID(double val) {
        device.setPower(PIDUtils.calculatePIDDouble(pid_p, pid_i, pid_d, encoder.getSensorValue(), val));
    }

    public void setPosition(double ticks){
        setPosition(ticks, 0.5);
    }
    public void setPosition(double ticks, double speed){
        setSpeed(Math.abs(ticks-encoder.getSensorValue()) > threshold ?
                (encoder.getSensorValue() < ticks ? speed : -speed) :
                0);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void resetEncoder() {
        encoder.zeroEncoder();
    }

}
