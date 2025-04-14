package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ManualDrive {
    public DcMotor lf0;
    public DcMotor lb1;
    public DcMotor rb2;
    public DcMotor rf3;

    public ManualDrive(HardwareMap hwMap) {
        lf0 = hwMap.get(DcMotor.class, "lf0");
        lb1 = hwMap.get(DcMotor.class, "lb1");
        rb2 = hwMap.get(DcMotor.class, "rb3");
        rf3 = hwMap.get(DcMotor.class, "rf3");
        // Maps motors.

        lf0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lb1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rb2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rf3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // Sets the mode. *See official FTC guide for more options.

        lf0.setDirection(DcMotor.Direction.FORWARD);
        lb1.setDirection(DcMotor.Direction.REVERSE);
        rb2.setDirection(DcMotor.Direction.FORWARD);
        rf3.setDirection(DcMotor.Direction.REVERSE);

    }

    public void setDCMotorPower(double leftFrontPower, double leftBackPower, double rightFrontPower, double rightBackPower) {
        lf0.setPower(leftFrontPower);
        lb1.setPower(leftBackPower);
        rb2.setPower(rightBackPower);
        rf3.setPower(rightFrontPower);
    }

    public void controllerDrive(double axial, double lateral, double yaw) {
        // Function takes in desired directions as parameters.

        double leftFrontPower = axial + lateral + yaw;
        double leftBackPower = axial + lateral - yaw;
        double rightFrontPower = axial - lateral - yaw;
        double rightBackPower = axial - lateral + yaw;
        // Calculates necessary motor speeds.
        // These calculations are dependent on this orientation:      \ /
        // Look up a mecanum diagram to see how this works.           / \

        double max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(rightBackPower));
        max = Math.max(max, Math.abs(leftBackPower));
        // Finds max value.


        if (max > 1.0) {
            leftFrontPower /= max;
            rightFrontPower /= max;
            rightBackPower /= max;
            leftBackPower /= max;
        }
        // Readjusts for max value to preserve the intention of the controller.

        setDCMotorPower(leftFrontPower, rightBackPower, rightFrontPower, leftBackPower);
    }
}