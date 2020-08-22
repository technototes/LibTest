package org.firstinspires.ftc.teamcode.newcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.technototes.library.structure.TeleOpCommandOpMode;

import org.firstinspires.ftc.teamcode.newcode.Hardware;
import org.firstinspires.ftc.teamcode.newcode.OI;
import org.firstinspires.ftc.teamcode.newcode.Robot;

@TeleOp(name = "test yay poggers")
public class TestOpMode extends TeleOpCommandOpMode {
    public OI oi;
    public Robot robot;
    @Override
    public void beginInit() {
        robot = new Robot(hardwareMap, telemetry);
        oi = new OI(driverGamepad, codriverGamepad, robot);
    }
}
