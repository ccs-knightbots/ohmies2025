package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.statemachines.SlidesSM;

public class Slides {

    public DcMotor linearExtender1;
    public DcMotor linearExtender2;

    public SlidesSM slidesSM;

    double targetPosition = 0;
    int tickPerRotation;

    public Slides(HardwareMap hwMap) {
        linearExtender1 = hwMap.get(DcMotor.class, "linearExtender1");
        linearExtender2 = hwMap.get(DcMotor.class, "linearExtender2");

        linearExtender1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        linearExtender2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        linearExtender1.setDirection(DcMotor.Direction.FORWARD);
        linearExtender2.setDirection(DcMotor.Direction.REVERSE);

        linearExtender1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearExtender2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        linearExtender1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        linearExtender2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        slidesSM = new SlidesSM(this);
//      By invoking the constructor SlidesSM(), we pass the SlidesSM object the specific slides we are using for that state machine.
//      We are giving it "this", which is a pointer that redirects to the constructor of the current file we are in (the Slides file.
//      Thereby, we are giving it the slides which we have just built.

        tickPerRotation = (int) linearExtender1.getMotorType().getTicksPerRev();
    }

    public void setTargetPosition(double targetPosition) {
        this.targetPosition = targetPosition;
        linearExtender1.setTargetPosition((int) targetPosition);
        linearExtender2.setTargetPosition((int) targetPosition);

    }

    public int getTargetPosition() {
        return (int) targetPosition;
    }

    public void setPower(double power) {
        linearExtender1.setPower(power);
        linearExtender2.setPower(power);
    }

    public void setManualPower(double power){
        linearExtender1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        linearExtender2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        linearExtender1.setPower(power);
        linearExtender2.setPower(power);
    }

    public void goUp(double location) {
        setPower(1);
        setTargetPosition((int) (location*(.5*tickPerRotation)));
    }

    public void goDown() {
        setPower(1);
        setTargetPosition(0);
    }

    public void cancelRunTo() {
        setPower(0);
    }

    public double getLinearExtenderPos1() {return linearExtender1.getCurrentPosition()/(.5*tickPerRotation);}
    public double getLinearExtender2() {return linearExtender2.getCurrentPosition()/(.5*tickPerRotation);}
//    For some reason, the FTC ticksPerRotation is 2x what it should be.
}