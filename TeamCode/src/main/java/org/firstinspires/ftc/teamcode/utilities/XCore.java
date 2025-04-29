package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.robotcore.hardware.HardwareMap;

//import org.firstinspires.ftc.teamcode.roadrunner_otos.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.subsystems.*;
public class XCore {

    public ManualDrive manualDrive;
    public Finger finger;
    public Wrist wrist;
    public Slides slides;
    public Cup cup;
    public Tongue tongue;

    public XCore(HardwareMap hwMap) {
        manualDrive = new ManualDrive(hwMap);
        finger = new Finger(hwMap);
        wrist = new Wrist(hwMap);
        slides = new Slides(hwMap);
        cup = new Cup(hwMap);
        tongue = new Tongue(hwMap);
    }
}
