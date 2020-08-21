package org.firstinspires.ftc.teamcode.newcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.technototes.library.hardware.motor.EncodedMotor;
import com.technototes.library.hardware.motor.Motor;
import com.technototes.library.hardware.sensor.RangeSensor;
import com.technototes.library.hardware.servo.Servo;
import com.technototes.library.structure.HardwareBase;


public class Hardware extends HardwareBase {

    public HardwareMap hardwareMap;


    //upper assembly
    public Motor<CRServo> slide;
    public Servo turn;
    public Servo claw;

    //capstone pusher
    public Motor<CRServo> cap;

    //rear flipper
    public Servo blockFlipper;

    //color sensor
    public ColorSensor sensorColorBottom;

    //range sensors
    public RangeSensor sensorRangeFront;
    public RangeSensor sensorRangeRear;
    public RangeSensor sensorRangeLeft;
    public RangeSensor sensorRangeRight;

    //lift
    public EncodedMotor<DcMotor> lLiftMotor;
    public EncodedMotor<DcMotor> rLiftMotor;

    //drivebase
    public Motor<DcMotor> flMotor;
    public Motor<DcMotor> frMotor;
    public Motor<DcMotor> rlMotor;
    public Motor<DcMotor> rrMotor;

    public Hardware(HardwareMap map){
        hardwareMap = map;

        slide = new Motor<CRServo>(hardwareMap.get(CRServo.class, "slide"));
        turn = new Servo(hardwareMap.get(com.qualcomm.robotcore.hardware.Servo.class, "grabTurn"));
        claw = new Servo(hardwareMap.get(com.qualcomm.robotcore.hardware.Servo.class, "claw"));

        cap = new Motor<CRServo>(hardwareMap.get(CRServo.class, "cap"));

        blockFlipper = new Servo(hardwareMap.get(com.qualcomm.robotcore.hardware.Servo.class, "blockFlipper"));

        sensorColorBottom = hardwareMap.get(ColorSensor.class, "sensorColorBottom");

        sensorRangeFront = new RangeSensor(hardwareMap.get(DistanceSensor.class, "sensorRangeFront"));
        sensorRangeRear = new RangeSensor(hardwareMap.get(DistanceSensor.class, "sensorRangeRear"));
        sensorRangeLeft = new RangeSensor(hardwareMap.get(DistanceSensor.class, "sensorRangeLeft"));
        sensorRangeRight = new RangeSensor(hardwareMap.get(DistanceSensor.class, "sensorRangeRight"));

        lLiftMotor = new EncodedMotor<DcMotor>(hardwareMap.get(DcMotor.class, "motorLiftLeft")).setInverted(false);
        rLiftMotor = new EncodedMotor<DcMotor>(hardwareMap.get(DcMotor.class, "motorLiftRight")).setInverted(true);

        flMotor = new Motor<DcMotor>(hardwareMap.get(DcMotor.class, "motorFrontLeft"));
        frMotor = new Motor<DcMotor>(hardwareMap.get(DcMotor.class, "motorFrontRight"));
        rlMotor = new Motor<DcMotor>(hardwareMap.get(DcMotor.class, "motorRearLeft"));
        rrMotor = new Motor<DcMotor>(hardwareMap.get(DcMotor.class, "motorRearRight"));
    }

}
