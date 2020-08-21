package com.technototes.library.structure;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.technototes.library.command.CommandScheduler;
import com.technototes.library.control.gamepad.CommandGamepad;

public abstract class CommandOpMode extends LinearOpMode {

    public OpModeState opModeState = OpModeState.INIT;
    public enum OpModeState{
        INIT, RUN, FINISHED
    }

    public OpModeState getOpModeState(){
        return opModeState;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        CommandScheduler.setCurrentInstance(opModeState);
        beginInit();
        while(!isStarted()) {
            initLoop();
            CommandScheduler.getInstance().run();
        }
        opModeState = OpModeState.RUN;
        waitForStart();
        CommandScheduler.setCurrentInstance(opModeState);
        runInit();
        while(opModeIsActive()) {
            runLoop();
            CommandScheduler.getInstance().run();
        }
        opModeState = OpModeState.FINISHED;
        CommandScheduler.setCurrentInstance(opModeState);
        end();
        CommandScheduler.getInstance().run();
    }
    //for registering commands to run when robot is in init
    public void beginInit(){

    }
    //for other things to do in init
    public void initLoop(){

    }
    //to schedule commands to be run
    public void runInit(){

    }
    public void runLoop(){

    }
    public void end(){

    }
}
