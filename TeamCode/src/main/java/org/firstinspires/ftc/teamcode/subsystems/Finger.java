package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Finger {
    Servo fingerServo;
    public Finger(HardwareMap hwMap) {
        fingerServo = hwMap.get(Servo.class, "fingerServo");
    }

    public void closeFinger() {
        fingerServo.setPosition(0);
    }

    public void openFinger() {
        fingerServo.setPosition(.9);
    }

    public void raiseFinger(){ fingerServo.setPosition(.6);}

    public void setFingerServo(double gripperAngle) {fingerServo.setPosition(gripperAngle);}

    public double getFingerRotation() {return fingerServo.getPosition();}
}
