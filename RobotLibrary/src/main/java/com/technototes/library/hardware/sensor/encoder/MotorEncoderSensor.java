package com.technototes.library.hardware.sensor.encoder;


import android.os.Build;
import android.support.annotation.RequiresApi;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.technototes.library.hardware.sensor.Sensor;

import java.util.function.IntSupplier;

public class MotorEncoderSensor extends Sensor<DcMotor> implements Encoder {

    private int zero = 0;
    private IntSupplier supplier;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public MotorEncoderSensor(DcMotor d){
        super(d);
        supplier = () -> d.getCurrentPosition();
        zeroEncoder();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void zeroEncoder() {
        zero = (int)getSensorValue();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public double getSensorValue() {
        return supplier.getAsInt();
    }
}
