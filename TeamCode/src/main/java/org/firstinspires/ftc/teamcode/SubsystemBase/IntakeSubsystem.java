package org.firstinspires.ftc.teamcode.SubsystemBase;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSubsystem {
    private DcMotor intakeMotor;
    private Servo intakeServo;

    public IntakeSubsystem(HardwareMap hw) {
        intakeMotor = hw.get(DcMotor.class, "intakeMotor");
        intakeServo = hw.get(Servo.class, "intakeServo");

    }

    public void turnIntakeServo() {
        intakeServo.setPosition(1);
    }

    public void stopIntakeServo(){
        intakeServo.setPosition(0.5);
    }

    public void startIntakeMotor() {
        intakeMotor.setPower(1);
    }

    public void stopIntakeMotor() {
        intakeMotor.setPower(0);
    }


}