package org.firstinspires.ftc.teamcode.Legacy.subsystems;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class CrashProtect {
    public DistanceSensor distanceSensor;

    public double distance = distanceSensor.getDistance(DistanceUnit.CM);

    public CrashProtect(HardwareMap hwmap) {
        distanceSensor = hwmap.get(DistanceSensor.class, "distanceSensor1");
    }

}
