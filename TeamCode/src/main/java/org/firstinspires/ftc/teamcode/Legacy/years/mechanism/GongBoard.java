package org.firstinspires.ftc.teamcode.Legacy.years.mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GongBoard extends AbstractBoard{
    private static DcMotor leftFrontMotor_0;
    private static DcMotor leftBackMotor_1;
    private static DcMotor rightBackMotor_2;
    private static DcMotor rightFrontMotor_3;

    private static DcMotor armMotor;

    //private static Servo intakeServo;


    public void init(HardwareMap hwmap) {
        leftFrontMotor_0 = hwmap.get(DcMotor.class, "leftFrontMotor_0");
        leftBackMotor_1 = hwmap.get(DcMotor.class, "leftBackMotor_1");
        rightBackMotor_2 = hwmap.get(DcMotor.class, "rightBackMotor_2");
        rightFrontMotor_3 = hwmap.get(DcMotor.class, "rightFrontMotor_3");

        leftFrontMotor_0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackMotor_1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackMotor_2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontMotor_3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftFrontMotor_0.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor_1.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor_2.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor_3.setDirection(DcMotor.Direction.FORWARD);

        armMotor = hwmap.get(DcMotor.class, "armMotor");

        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

       // intakeServo = hwmap.get(Servo.class, "intakeServo");
    }
    public void setArmMotor(double armPower){
        armMotor.setPower(armPower);
    }
    public void setDCMotorPower(double leftFrontPower, double leftBackPower, double rightFrontPower, double rightBackPower) {
        leftFrontMotor_0.setPower(leftFrontPower);
        leftBackMotor_1.setPower(leftBackPower);
        rightBackMotor_2.setPower(rightBackPower);
        rightFrontMotor_3.setPower(rightFrontPower);
    }
   // public void setIntakeServo(double intakeAngle) {intakeServo.setPosition(intakeAngle/270);}
   // public double getIntakeRotation() {return intakeServo.getPosition()*270;}
}


