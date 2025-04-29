package org.firstinspires.ftc.teamcode.teleops;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.statemachines.SlidesSM;
import org.firstinspires.ftc.teamcode.utilities.*;


@TeleOp
public class XBot extends OpMode{

    XCore XCore;
    Structures structures;
    double axial, lateral, yaw;
    double slowDown = .5;
    boolean alreadyPressed;
    boolean finalStage;
    double slidesIn, slidesOut;


    @Override
    public void init() {
        XCore = new XCore(hardwareMap);
        structures = new Structures();
        XCore.slides.slidesSM.transition(SlidesSM.EVENT.ENABLE_MANUAL);

    }

    @Override
    public void loop() {
        if (structures.toggle_1(gamepad1.a)) {
            axial = gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            lateral = gamepad1.left_stick_x;
        } else {
            axial = gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            lateral = -gamepad1.left_stick_x;
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
        if (structures.toggle_2(gamepad2.x)) {
            XCore.finger.openFinger();
        }
        else {
            XCore.finger.closeFinger();
        }


//        XCore.cup.setCupServo((-gamepad2.left_stick_x + 1) / 4);
//        XCore.finger.setFingerServo((-gamepad2.right_stick_x + 1) / 4);
//        XCore.slides.setTargetPosition(gamepad2.);



        telemetry.addData("fingerRotation: ", XCore.finger.getFingerRotation());
        telemetry.addData("wristRotation: ", XCore.wrist.getWristRotation());
        telemetry.addData("cupRotation: ", XCore.cup.getCupRotation());
        telemetry.addData("slides pos: ", XCore.slides.getTargetPosition());
        telemetry.addData("slides mode: ", XCore.slides.slidesSM.getState());
        telemetry.addData("Tongue pos: ", XCore.tongue.getTargetPosition());
        telemetry.addData("Tongue mode: ", XCore.tongue.tongueSM.getState());


        XCore.wrist.setWristServo(gamepad2.left_stick_y);

        if (structures.toggle_3(gamepad2.y)) {
            XCore.cup.raiseCup();
        }
        else {
            XCore.cup.lowerCup();
        }


            XCore.wrist.setWristServo(-gamepad2.left_stick_y);




        //XCore.cup.setCupServo(gamepad2.left_stick_x);


        if (XCore.slides.getTargetPosition() > -35) {
            slidesIn = 0;
        } else {
            slidesIn = gamepad2.right_trigger;
        }
        XCore.slides.setManualPower(slidesIn-slidesOut);



    }
}
