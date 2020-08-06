package com.technototes.library.hardware.sensor.encoder;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.technototes.library.hardware.Sensored;

import java.util.function.IntSupplier;

@RequiresApi(api = Build.VERSION_CODES.N)
public interface Encoder extends Sensored {

    void zeroEncoder();
    
}
