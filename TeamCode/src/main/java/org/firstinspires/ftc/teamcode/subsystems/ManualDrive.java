package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ManualDrive {
    DcMotor leftFrontMotor_0;
    public DcMotor leftBackMotor_1;
    public DcMotor rightBackMotor_2;
    public DcMotor rightFrontMotor_3;

    public ManualDrive(HardwareMap hwMap) {
        leftFrontMotor_0 = hwMap.get(DcMotor.class, "leftFrontMotor_0");
        leftBackMotor_1 = hwMap.get(DcMotor.class, "leftBackMotor_1");
        rightBackMotor_2 = hwMap.get(DcMotor.class, "rightBackMotor_2");
        rightFrontMotor_3 = hwMap.get(DcMotor.class, "rightFrontMotor_3");
        // Maps motors.

        leftFrontMotor_0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackMotor_1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackMotor_2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontMotor_3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // Sets the mode. *See official FTC guide for more options.

        leftFrontMotor_0.setDirection(DcMotor.Direction.FORWARD);
        leftBackMotor_1.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor_2.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor_3.setDirection(DcMotor.Direction.REVERSE);

    }

    public void setDCMotorPower(double leftFrontPower, double leftBackPower, double rightFrontPower, double rightBackPower) {
        leftFrontMotor_0.setPower(leftFrontPower);
        leftBackMotor_1.setPower(leftBackPower);
        rightBackMotor_2.setPower(rightBackPower);
        rightFrontMotor_3.setPower(rightFrontPower);
    }

}
