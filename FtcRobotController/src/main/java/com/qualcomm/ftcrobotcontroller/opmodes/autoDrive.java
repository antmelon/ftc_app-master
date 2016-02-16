package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode. OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.GyroSensor;
/**
 * Created by MatthewB on 10/30/15.
 */

public class autoDrive extends OpMode {

    DcMotor leftfrontMotor;
    DcMotor rightfrontMotor;
    DcMotor leftbackMotor;
    DcMotor rightbackMotor;
    final static int ENCODER_CPR = 1120;
    final static double GEAR_RATIO = 1;
    final static double Wheel_Diameter = 38.5;
    final static double distance = 250;

    final static double CIRCUMFERENCE = Math.PI * Wheel_Diameter;
    final static double ROTATIONS = distance / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR / ROTATIONS * GEAR_RATIO;

    @Override
    public void init(){
        //map variables to set hardware
        leftfrontMotor = hardwareMap.dcMotor.get("left_front");
        rightfrontMotor = hardwareMap.dcMotor.get("right_front");
        rightbackMotor = hardwareMap.dcMotor.get("right_back");
        leftbackMotor = hardwareMap.dcMotor.get("left_back");

        leftbackMotor.setDirection(DcMotor.Direction.REVERSE);
        leftfrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightfrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightbackMotor.setDirection(DcMotor.Direction.FORWARD);

        leftbackMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        leftfrontMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightbackMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightfrontMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

    }

    @Override
    public void start(){

        leftbackMotor.setTargetPosition((int)COUNTS);
        rightfrontMotor.setTargetPosition((int) COUNTS);
        leftfrontMotor.setTargetPosition((int)COUNTS);
        rightbackMotor.setTargetPosition((int)COUNTS);

        leftfrontMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightfrontMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        leftbackMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightbackMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

    }

    @Override
    public void loop() {
        //drive forward until encoders reach 8000 ticks
        while (leftbackMotor.getCurrentPosition() < 10000 && rightbackMotor.getCurrentPosition()< 8000 && leftfrontMotor.getCurrentPosition()< 10000 && rightfrontMotor.getCurrentPosition()< 8000)
        {
            start();
            leftbackMotor.setPower(.5);
            leftfrontMotor.setPower(.5);
            rightbackMotor.setPower(.5);
            rightfrontMotor.setPower(.5);
        }
        //turn until encoders reach 3000 ticks
         while (leftbackMotor.getCurrentPosition() > 20000 && rightbackMotor.getCurrentPosition()>20000 && leftfrontMotor.getCurrentPosition()>20000 && rightfrontMotor.getCurrentPosition()>20000)
        {

            leftbackMotor.setPower(-.5);
            leftfrontMotor.setPower(-.5);
            rightbackMotor.setPower(.5);
            rightfrontMotor.setPower(.5);



        }

        telemetry.addData("motor target", COUNTS);
        telemetry.addData("left front position", leftfrontMotor.getCurrentPosition());
        telemetry.addData("right front position", rightfrontMotor.getCurrentPosition());
        telemetry.addData("left back position", leftbackMotor.getCurrentPosition());
        telemetry.addData("right back position", rightbackMotor.getCurrentPosition());


    }


}
