package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.robotcore.hardware.HardwareMap;

//import org.firstinspires.ftc.teamcode.roadrunner_otos.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.subsystems.*;
public class XCore {

    public ManualDrive manualDrive;

    public XCore(HardwareMap hwMap) {
        manualDrive = new ManualDrive(hwMap);
    }
}
