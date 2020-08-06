package com.technototes.library.control.gamepad;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.qualcomm.robotcore.hardware.Gamepad;

@RequiresApi(api = Build.VERSION_CODES.N)
public class CommandGamepad {

    public class Stick{
        private AxisGamepadComponent x, y;
        //supplier
        public ButtonGamepadComponent press;
        public Stick(AxisGamepadComponent d1, AxisGamepadComponent d2, ButtonGamepadComponent b){
            x=d1;
            y=d2;
            press = b;
        }

        public double getX(){
            return x.getAsDouble();
        }
        public double getY(){
            return y.getAsDouble();
        }
        public boolean getPress(){
            return press.getAsBoolean();
        }
    }
    public class Dpad{

        //suppliers
        public ButtonGamepadComponent up, down, left, right;
        public Dpad(ButtonGamepadComponent u, ButtonGamepadComponent d, ButtonGamepadComponent l, ButtonGamepadComponent r){
            up = u;
            down = d;
            left = l;
            right = r;
        }
        public Stick getAsStick(){
            return new Stick(() -> (up.getAsBoolean() ? 1 : 0) - (down.getAsBoolean() ? 1 : 0), () -> (right.getAsBoolean() ? 1 : 0) - (left.getAsBoolean() ? 1 : 0), () -> false);
        }
        public boolean getUp(){
            return up.getAsBoolean();
        }
        public boolean getDown(){
            return down.getAsBoolean();
        }
        public boolean getLeft(){
            return left.getAsBoolean();
        }
        public boolean getRight(){
            return right.getAsBoolean();
        }
    }
    private Gamepad gamepad;
    public Stick lstick, rstick;
    public Dpad dpad;

    //suppliers
    private AxisGamepadComponent ltrigger, rtrigger;
    public ButtonGamepadComponent a,b,x,y,start,back,lbump,rbump;

    public CommandGamepad(Gamepad g){
        gamepad = g;
        setStickSuppliers(gamepad);
        setTriggerSuppliers(gamepad);
        setButtonSuppliers(gamepad);
        setDpadSupplier(gamepad);

    }

    private void setDpadSupplier(Gamepad g) {
        dpad = new Dpad(() -> g.dpad_up,() -> g.dpad_down,() -> g.dpad_left,() -> g.dpad_right);
    }

    private void setButtonSuppliers(Gamepad g) {
        a = () -> g.a;
        b = () -> g.b;
        x = () -> g.x;
        y = () -> g.y;
        start = () -> g.start;
        back = () -> g.back;
        lbump = () -> g.left_bumper;
        rbump = () -> g.right_bumper;
    }

    private void setTriggerSuppliers(Gamepad g) {
        ltrigger = () -> g.left_trigger;
        rtrigger = () -> g.right_trigger;
    }

    private void setStickSuppliers(Gamepad g) {
        lstick = new Stick(() -> g.left_stick_x, () -> g.left_stick_y, () -> g.left_stick_button);
        rstick = new Stick(() -> g.right_stick_x, () -> g.right_stick_y, () -> g.right_stick_button);
    }
    public boolean getA(){
        return a.getAsBoolean();
    }
    public boolean getB(){
        return b.getAsBoolean();
    }
    public boolean getX(){
        return x.getAsBoolean();
    }
    public boolean getY(){
        return y.getAsBoolean();
    }
    public boolean getStart(){
        return start.getAsBoolean();
    }
    public boolean getBack(){
        return back.getAsBoolean();
    }
}
