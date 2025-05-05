package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ManualDrive {
    public DcMotor fr0;
    public DcMotor br1;
    public DcMotor bl2;
    public DcMotor fl3;

    public ManualDrive(HardwareMap hwMap) {
        fr0 = hwMap.get(DcMotor.class, "fr0");
        br1 = hwMap.get(DcMotor.class, "br1");
        bl2 = hwMap.get(DcMotor.class, "bl2");
        fl3 = hwMap.get(DcMotor.class, "fl3");
        // Maps motors.

        fr0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        br1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bl2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fl3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // Sets the mode. *See official FTC guide for more options.

        fr0.setDirection(DcMotor.Direction.REVERSE);
        br1.setDirection(DcMotor.Direction.REVERSE);
        bl2.setDirection(DcMotor.Direction.FORWARD);
        fl3.setDirection(DcMotor.Direction.REVERSE);

    }

    public void setDCMotorPower(double leftFrontPower, double leftBackPower, double rightFrontPower, double rightBackPower) {
        fr0.setPower(rightFrontPower);
        br1.setPower(rightBackPower);
        bl2.setPower(leftBackPower);
        fl3.setPower(leftFrontPower);
    }

    public void controllerDrive(double axial, double lateral, double yaw) {
        // Function takes in desired directions as parameters.

        double leftFrontPower = axial - yaw - lateral;
        double leftBackPower = axial + yaw - lateral;
        double rightFrontPower = axial + yaw + lateral;
        double rightBackPower = axial - yaw + lateral;
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