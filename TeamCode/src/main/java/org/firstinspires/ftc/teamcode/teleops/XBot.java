package org.firstinspires.ftc.teamcode.teleops;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.utilities.*;
//import org.firstinspires.ftc.teamcode.statemachines.SlidesSM;

@TeleOp
public class XBot extends OpMode{

    XCore XCore;
    Structures structures;
    double axial, lateral, yaw;
    double slowDown = .5;
    boolean alreadyPressed;
    boolean finalStage;

    @Override
    public void init() {
        XCore = new XCore(hardwareMap);
        structures = new Structures();

    }

    @Override
    public void loop() {
        if (structures.toggle_1(gamepad1.a)) {
            axial = gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            lateral = -gamepad1.left_stick_x;
        } else {
            axial = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            lateral = gamepad1.left_stick_x;
        }
//      Rotation doesn't change even if you invert it.
        yaw = gamepad1.right_stick_x;

//      This can be helpful for precise maneuvering.
        if (gamepad1.right_stick_button) {
            slowDown = 0.5;
        } else if (gamepad1.left_stick_button) {
            slowDown = 1;
        }

//      This function sends the game pad inputs to the Traction class.
        XCore.manualDrive.controllerDrive(axial * slowDown, lateral * slowDown, yaw * slowDown);
        if (structures.toggle_2(gamepad1.x)) {
            XCore.finger.openFinger();
        }
        else {
            XCore.finger.closeFinger();
        }

    }
}
