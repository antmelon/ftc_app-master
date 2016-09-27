package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.hardware.ModernRoboticsNxtUltrasonicSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;
import com.qualcomm.robotcore.hardware.GyroSensor;



/**
 * Created by alongo on 12/18/15.
 */
public class Autonomous extends OpMode{

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;

    public enum possibleStates{
     findBeacon,
        strafe,
        centerRobot,
        findColor,
        pushButton
    }

    possibleStates state;

    @Override
    public void init(){

        rightBack = hardwareMap.dcMotor.get("right_back");
        rightFront = hardwareMap.dcMotor.get("right_front");
        leftBack = hardwareMap.dcMotor.get("left_back");
        leftFront = hardwareMap.dcMotor.get("left_front");

        state = possibleStates.findBeacon;




    }

    @Override
    public void loop(){

        switch (state){
            case findBeacon:


                break;

            case strafe:


                break;

            case centerRobot:


                break;

            case findColor:


                break;

            case pushButton:

                break;
        }


    }

  


}
