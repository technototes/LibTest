package com.technototes.library.hardware;

import com.technototes.library.hardware.motor.Motor;

public interface HardwareDeviceGroup<T extends HardwareDevice> {
    T[] getFollowers();
}
