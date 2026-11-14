package org.firstinspires.ftc.teamcode.SubsystemBase;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSubsystem extends SubsystemBase {
    private final DcMotor intakeMotor;
    private final Servo intakeServo;
    private final Servo flowerServo;

    public IntakeSubsystem(HardwareMap hw) {
        intakeMotor = hw.get(DcMotor.class, "intakeMotor");
        intakeServo = hw.get(Servo.class, "intakeServo");
        flowerServo = hw.get(Servo.class, "flowerServo");

        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void turnIntakeServo() {
        intakeServo.setPosition(1);
    }

    public void stopIntakeServo(){
        intakeServo.setPosition(0);
    }

    public void lowerFlowerMechanicsm() {
        flowerServo.setPosition(1);
    }

    public void raiseFlowerMechanicsm() {
        flowerServo.setPosition(0);

    }

    public void startIntakeMotor() {
        intakeMotor.setPower(1);
    }

    public void stopIntakeMotor() {
        intakeMotor.setPower(0);
    }


}