package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Cup {
    Servo cupServo;
    public Cup(HardwareMap hwMap) {
        cupServo = hwMap.get(Servo.class, "cupServo");
    }

    public void raiseCup() {
        cupServo.setPosition(0);
    }

    public void lowerCup() {
        cupServo.setPosition(1);
    }

    public void setCupServo(double cupAngle) {cupServo.setPosition(cupAngle);}

    public double getCupRotation() {return cupServo.getPosition();}
    //does not return actual finger rotation, just target value


}
