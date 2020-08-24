package com.technototes.library.control.gamepad;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.function.DoubleSupplier;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AxisGamepadComponent extends ButtonGamepadComponent implements DoubleSupplier {
    private DoubleSupplier doubleSupplier;

    public AxisGamepadComponent(DoubleSupplier b) {
        super(() -> b.getAsDouble() > 0.05);
        doubleSupplier = b;
    }

    public AxisGamepadComponent(DoubleSupplier b, double t) {
        super(() -> b.getAsDouble() > t);
        doubleSupplier = b;
    }

    public AxisGamepadComponent setThreshold(double t) {
        booleanSupplier = () -> doubleSupplier.getAsDouble() > t;
        return this;
    }

    @Override
    public double getAsDouble() {
        return doubleSupplier.getAsDouble();
    }
}
