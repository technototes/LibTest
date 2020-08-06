package com.technototes.library.hardware.motor;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.technototes.library.hardware.HardwareDevice;
import com.technototes.library.hardware.HardwareDeviceGroup;

public class MotorGroup<T extends Motor> extends Motor implements HardwareDeviceGroup {
    public MotorGroup(DcMotorSimple d) {
        super(d);
    }

    @Override
    public HardwareDevice[] getFollowers() {
        return new HardwareDevice[0];
    }


}
