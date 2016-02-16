package com.qualcomm.ftcrobotcontroller.opmodes;

        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.Servo;

        import java.util.LinkedList;
/**
 * Created by alongo on 2/7/16.
 */



    public class CommandAuto extends OpMode {
        DcMotor rightfrontMotor;
        DcMotor rightbackMotor;
        DcMotor leftfrontMotor;
        DcMotor leftbackMotor;
        Servo Servo2;
        Servo Servo3;
        LinkedList<Command> commands;
        double prevTime = 0;

        @Override
        public void init() {

            commands = new LinkedList<Command>();
            commands.add(new Command(0,0,0,0,0));
            commands.add(new Command(3,.5,.5,0,0));
            commands.add(new Command(1, .5,-.5, 0, 0 ));
            commands.add(new Command(3, .5, .5, 0, 0));
            rightfrontMotor = hardwareMap.dcMotor.get("left_front");
            rightbackMotor = hardwareMap.dcMotor.get("left_back");

            leftbackMotor = hardwareMap.dcMotor.get("right_front");
            leftfrontMotor = hardwareMap.dcMotor.get("right_back");

            rightfrontMotor.setDirection(DcMotor.Direction.FORWARD);
            rightbackMotor.setDirection(DcMotor.Direction.REVERSE);
            leftbackMotor.setDirection(DcMotor.Direction.FORWARD);
            leftfrontMotor.setDirection(DcMotor.Direction.FORWARD);

            Servo2 = hardwareMap.servo.get("servo_left");
            Servo3 = hardwareMap.servo.get("servo_right");

        }

        @Override
        public void loop() {
            double dt = time - prevTime;
            prevTime = time;

            Command c = commands.peek();

            if (c == null) {
                rightbackMotor.setPower(0);
                rightfrontMotor.setPower(0);
                leftbackMotor.setPower(0);
                leftfrontMotor.setPower(0);

                return;
            }

            c.time -= dt;
            if (c.time <= 0) {
                commands.pop();
                return;
            }

            rightbackMotor.setPower(c.lMotor);
            rightfrontMotor.setPower(c.lMotor);
            leftbackMotor.setPower(c.rMotor);
            leftfrontMotor.setPower(c.rMotor);

            Servo2.setPosition(c.Servo1);
            Servo3.setPosition(c.Servo2);
        }

        private class Command {
            double time;
            double lMotor;
            double rMotor;
            double Servo1;
            double Servo2;

            public Command(double time, double lMotor, double rMotor, double Servo1, double Servo2) {
                this.time = time;
                this.lMotor = lMotor;
                this.rMotor = rMotor;

                this.Servo1 = Servo1;
                this.Servo2 = Servo2;
            }
        }
    }

