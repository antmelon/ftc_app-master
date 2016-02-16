package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by alongo on 2/7/16.
 */
public class ReallyBadLeftAutonomous extends LinearOpMode {

    /**
     * Created by alongo on 12/11/15.
     */


        DcMotor rightFrontMotor;
        DcMotor rightBackMotor;
        DcMotor leftFrontMotor;
        DcMotor leftBackMotor;
        DcMotor Arm;
        DcMotor Spool;

        @Override
        public void runOpMode() throws InterruptedException{

            leftBackMotor = hardwareMap.dcMotor.get("left_back");
            leftFrontMotor = hardwareMap.dcMotor.get("left_front");
            rightBackMotor = hardwareMap.dcMotor.get("right_back");
            rightFrontMotor = hardwareMap.dcMotor.get("right_front");
            Arm = hardwareMap.dcMotor.get("motor_arm");
            Spool = hardwareMap.dcMotor.get("motor_spool");

            leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
            leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
            rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
            rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
            waitForStart();

            leftFrontMotor.setPower(.2);
            leftBackMotor.setPower(.2);
            rightFrontMotor.setPower(.2);
            rightBackMotor.setPower(.2);

            sleep(6000);



            leftFrontMotor.setPower(-.5);
            leftBackMotor.setPower(-.5);
            rightFrontMotor.setPower(.5);
            rightBackMotor.setPower(.5);

            sleep(1800);

            leftFrontMotor.setPower(.3);
            leftBackMotor.setPower(.3);
            rightFrontMotor.setPower(.2);
            rightBackMotor.setPower(.3);

            sleep(10000);

            leftFrontMotor.setPower(0);
            leftBackMotor.setPower(0);
            rightFrontMotor.setPower(0);
            rightBackMotor.setPower(0);






        }
    }


