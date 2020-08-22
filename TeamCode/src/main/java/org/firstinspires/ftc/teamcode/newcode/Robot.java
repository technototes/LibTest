package org.firstinspires.ftc.teamcode.newcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.technototes.library.structure.RobotBase;
import com.technototes.library.subsystem.drivebase.SimpleMecanumDrivebaseSubsystem;
import com.technototes.library.subsystem.motor.EncodedMotorSubsystem;
import com.technototes.library.subsystem.motor.SimpleMotorSubsystem;
import com.technototes.library.subsystem.servo.SimpleServoSubsystem;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.newcode.subsystems.ClawRotateSubsystem;
import org.firstinspires.ftc.teamcode.newcode.subsystems.LiftSubsystem;

public class Robot extends RobotBase {
    public Hardware hardware;

    //drivebase
    public SimpleMecanumDrivebaseSubsystem drivebaseSubsystem;

    //lift
    public LiftSubsystem liftSubsystem;

    //slide
    public SimpleMotorSubsystem slideSubsytem;

    //claw
    public ClawRotateSubsystem clawRotateSubsystem;
    public SimpleServoSubsystem clawSubsystem;

    //capstone
    public SimpleMotorSubsystem capstonePusherSubsystem;

    //block flipper
    public SimpleServoSubsystem blockFlipperSubsystem;

    public Robot(HardwareMap map, Telemetry tel) {
        super(map, tel);
        hardware = new Hardware(map);

        drivebaseSubsystem = new SimpleMecanumDrivebaseSubsystem(
                hardware.flMotor, hardware.frMotor, hardware.rlMotor, hardware.rrMotor);

        liftSubsystem = new LiftSubsystem(hardware.lLiftMotor, hardware.rLiftMotor);

        slideSubsytem = new SimpleMotorSubsystem(hardware.slide);

        clawRotateSubsystem = new ClawRotateSubsystem(hardware.turn);

        clawSubsystem = new SimpleServoSubsystem(hardware.claw);

        capstonePusherSubsystem = new SimpleMotorSubsystem(hardware.cap);

        blockFlipperSubsystem = new SimpleServoSubsystem(hardware.blockFlipper);
    }


}
