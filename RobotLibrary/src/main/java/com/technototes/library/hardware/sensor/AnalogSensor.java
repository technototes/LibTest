package com.technototes.library.hardware.sensor;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.technototes.library.hardware.HardwareDevice;
import com.technototes.library.hardware.Sensored;

public class AnalogSensor extends Sensor<AnalogInput> {

    public AnalogSensor(AnalogInput d) {
        super(d);
    }

    @Override
    public double getSensorValue() {
        return device.getMaxVoltage();
    }

}
