package com.technototes.library.hardware;

import com.technototes.library.hardware.motor.Motor;

import java.util.List;

public interface HardwareDeviceGroup<T extends HardwareDevice> {
    T[] getFollowers();
    T[] getAllDevices();
}
