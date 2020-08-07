package com.technototes.library.control.gamepad;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.technototes.library.command.Command;
import com.technototes.library.control.Trigger;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AxisGamepadComponent extends ButtonGamepadComponent implements DoubleSupplier {
    private DoubleSupplier supplier2;

    public AxisGamepadComponent(DoubleSupplier b){
        super(() -> b.getAsDouble() > CommandGamepad.STICK_THRESHOLD);
        supplier2 = b;
    }
    @Override
    public double getAsDouble() {
        return supplier2.getAsDouble();
    }
}
