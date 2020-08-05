package org.firstinspires.ftc.testcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

// I've used this with the Smart Servo, but SetPower simply sets a *position* in
// about a 200 degree range :(

@TeleOp(name = "CRServo Test", group = "Sensor")
@Disabled
public class TestServo extends LinearOpMode {

  static final double INCREMENT = 0.5; // amount to slew servo each CYCLE_MS cycle
  static final int CYCLE_MS = 500; // period of each cycle
  static final double MAX_POS = 1.49; // Maximum rotational position
  static final double MIN_POS = -1.49; // Minimum rotational position

  // Define class members
  CRServo servo;
  double position = MIN_POS; // (MAX_POS - MIN_POS) / 2; // Start at halfway position
  boolean rampUp = true;

  @Override
  public void runOpMode() {

    // Connect to servo (Assume PushBot Left Hand)
    // Change the text in quotes to match any servo name on your robot.
    servo = hardwareMap.get(CRServo.class, "push");

    // Wait for the start button
    telemetry.addData(">", "Press Start to scan Servo.");
    telemetry.addData("cur", "%5.2f", servo.getPower());
    telemetry.update();
    waitForStart();

    // Scan servo till stop pressed.
    while (opModeIsActive()) {

      // slew the servo, according to the rampUp (direction) variable.
      if (rampUp) {
        // Keep stepping up until we hit the max value.
        position += INCREMENT;
        if (position >= MAX_POS) {
          position = MAX_POS;
          rampUp = !rampUp; // Switch ramp direction
        }
      } else {
        // Keep stepping down until we hit the min value.
        position -= INCREMENT;
        if (position <= MIN_POS) {
          position = MIN_POS;
          rampUp = !rampUp; // Switch ramp direction
        }
      }

      // Display the current value
      telemetry.addData("Servo Position", "%5.2f", position);
      telemetry.addData(">", "Press Stop to end test.");
      telemetry.update();

      // Set the servo to the new position and pause;
      servo.setPower(position);
      sleep(CYCLE_MS);
      idle();
    }

    // Signal done;
    telemetry.addData(">", "Done");
    telemetry.update();
  }
}
