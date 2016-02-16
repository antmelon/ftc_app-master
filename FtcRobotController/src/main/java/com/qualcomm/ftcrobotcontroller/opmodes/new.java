package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.hardware.ModernRoboticsNxtUltrasonicSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class new() extends OpMode{



DcMotor leftFront;
DcMotor rightFront;
DcMotor leftBack;
DcMotor rightBack;
DcMotor arm;
DcMotor spool;

@Override
public void init(){

  leftFront = hardwareMap.dcMotor.get("left_front");
    rightFront = hardwareMap.dcMotor.get("right_front");
      leftBack = hardwareMap.dcMotor.get("left_back");
        rightBack = hardwareMap.dcMotor.get("right_back");

        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

}

@Override
public void loop(){


          //float leftY = -gamepad1.left_stick_y;
          float rightYValue = -gamepad1.right_stick_y;
          float rightXValue = -gamepad1.right_stick_x;
          float armValue = gamepad1.left_stick_y;

          float leftPower = rightYValue - rightXValue;
          float rightPower = rightYValue + rightXValue;
          float armPower = armValue;


          leftPower = Range.clip(leftPower, -1, 1);
          rightPower = Range.clip(rightPower, -1, 1);
          armPower = Range.clip(armPower, -1,1 );

          if(Math.abs(gamepad1.right_stick_y)>.09 || (Math.abs(gamepad1.right_stick_x)> .09)){
              leftfrontMotor.setPower(Math.pow(leftPower, 3));
              rightfrontMotor.setPower(Math.pow(rightPower, 3));
              leftbackMotor.setPower(Math.pow(leftPower, 3));
              rightbackMotor.setPower(Math.pow(rightPower, 3));
          } else {
              rightbackMotor.setPower(0);
              rightfrontMotor.setPower(0);
              leftbackMotor.setPower(0);
              leftfrontMotor.setPower(0);
          }
          //set power of motors with gamepad value


          if(gamepad2.x== true){
              rightServo.setPosition(1);

          }
          else{
              rightServo.setPosition(0);
          }

          if(gamepad2.b== true){
              leftServo.setPosition(0);

          }
          else{
              leftServo.setPosition(1);
          }

          if(gamepad2.right_trigger == 1){
              Arm.setPower(0.65);
          }
          else if(gamepad2.right_bumper == true){
              Arm.setPower(-0.65);
          }
          else{
              Arm.setPower(0);
          }

          if(gamepad2.left_trigger == 1){
              Spool.setPower(0.5);
          }
          else if(gamepad2.left_bumper == true){
              Spool.setPower(-1);
          }
          else{
              Spool.setPower(0);
          }

}

}
