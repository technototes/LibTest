package com.technototes.library.hardware.sensor.encoder;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.technototes.library.hardware.Sensored;

@RequiresApi(api = Build.VERSION_CODES.N)
public interface Encoder extends Sensored {

    void zeroEncoder();

}
