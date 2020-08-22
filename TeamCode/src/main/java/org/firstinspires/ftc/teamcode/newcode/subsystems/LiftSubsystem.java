package org.firstinspires.ftc.teamcode.newcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.technototes.library.hardware.motor.EncodedMotor;
import com.technototes.library.subsystem.motor.EncodedMotorSubsystem;

public class LiftSubsystem extends EncodedMotorSubsystem {
    public LiftSubsystem(EncodedMotor<DcMotor> lLiftMotor, EncodedMotor<DcMotor> rLiftMotor) {
        super(lLiftMotor, rLiftMotor);
        
    }
}
