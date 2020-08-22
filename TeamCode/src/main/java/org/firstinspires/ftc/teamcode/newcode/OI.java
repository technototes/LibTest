package org.firstinspires.ftc.teamcode.newcode;

import com.technototes.library.command.InstantCommand;
import com.technototes.library.control.gamepad.CommandGamepad;
import com.technototes.library.structure.OIBase;

import org.firstinspires.ftc.teamcode.newcode.commands.claw.ClawRotateLeftCommand;
import org.firstinspires.ftc.teamcode.newcode.commands.claw.ClawRotateRightCommand;

public class OI extends OIBase {
    public Robot robot;
    public OI(CommandGamepad g1, CommandGamepad g2, Robot r) {
        super(g1, g2);
        robot = r;
    }

    @Override
    public void setDriverControls() {
        driverGamepad.dpad.up.whenActivated(new InstantCommand(() -> robot.blockFlipperSubsystem.setPosition(0)))
                .whenDeactivated(new InstantCommand(() -> robot.blockFlipperSubsystem.setPosition(1)));

        driverGamepad.dpad.left.whenActivated(new InstantCommand(() -> robot.capstonePusherSubsystem.setSpeed(-1)))
                .whenDeactivated(new InstantCommand(() -> robot.capstonePusherSubsystem.setSpeed(0)));
        driverGamepad.dpad.right.whenActivated(new InstantCommand(() -> robot.capstonePusherSubsystem.setSpeed(1)))
                .whenDeactivated(new InstantCommand(() -> robot.capstonePusherSubsystem.setSpeed(0)));
    }
    @Override
    public void setCodriverControls() {
        codriverGamepad.rtrigger.whenActivated(new InstantCommand(() -> robot.clawSubsystem.setPosition(1)));
        codriverGamepad.ltrigger.whenActivated(new InstantCommand(() -> robot.clawSubsystem.setPosition(0)));

        codriverGamepad.lbump.whenActivated(new ClawRotateLeftCommand(robot.clawRotateSubsystem));
        codriverGamepad.rbump.whenActivated(new ClawRotateRightCommand(robot.clawRotateSubsystem));

        codriverGamepad.dpad.left.whenActivated(new InstantCommand(() -> robot.slideSubsytem.setSpeed(0.5)))
                .whenDeactivated(new InstantCommand(() -> robot.slideSubsytem.setSpeed(0)));
        codriverGamepad.dpad.right.whenActivated(new InstantCommand(() -> robot.slideSubsytem.setSpeed(-0.5)))
                .whenDeactivated(new InstantCommand(() -> robot.slideSubsytem.setSpeed(0)));
        //TODO LIFT
    }

}
