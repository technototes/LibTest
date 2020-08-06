package com.technototes.library.control.gamepad;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.technototes.library.control.Trigger;

import java.util.function.BooleanSupplier;

@RequiresApi(api = Build.VERSION_CODES.N)
public interface ButtonGamepadComponent extends BooleanSupplier, Trigger {

}
