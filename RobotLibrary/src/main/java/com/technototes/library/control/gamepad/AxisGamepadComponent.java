package com.technototes.library.control.gamepad;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.function.DoubleSupplier;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AxisGamepadComponent extends ButtonGamepadComponent implements DoubleSupplier {
    private DoubleSupplier doubleSupplier;

    public AxisGamepadComponent(DoubleSupplier b){
        super(() -> b.getAsDouble() > CommandGamepad.STICK_THRESHOLD);
        doubleSupplier = b;
    }
    @Override
    public double getAsDouble() {
        return doubleSupplier.getAsDouble();
    }
}
