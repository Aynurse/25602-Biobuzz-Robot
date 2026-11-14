package org.firstinspires.ftc.teamcode.SubsystemBase;

import com.arcrobotics.ftclib.util.MathUtils;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Calculators.HoodCalculator;

public class HoodSubsystem {

    private final Servo hoodServo;
    private double MIN_ANGLE = 0;
    private double MAX_ANGLE = 100;
    private Double desiredAngle;
    private double desiredPosition;

    private HoodCalculator hoodCalculator;

    public HoodSubsystem(HardwareMap hw, HoodCalculator hoodCalculator) {
        hoodServo = hw.get(Servo.class, "hoodServo");
        this.hoodCalculator = hoodCalculator;

    }

    public void getTargetAngle(double distance) {

        desiredAngle = hoodCalculator.calculateAngle(distance);
        if (desiredAngle == null) {
            return;
        }

        desiredPosition = calculateDesiredPosition();

        desiredPosition = MathUtils.clamp(desiredPosition, 0,1 );

        hoodServo.setPosition(desiredPosition);


    }

    public double calculateDesiredPosition() {
        return desiredPosition = (desiredAngle - MIN_ANGLE) / (MAX_ANGLE - MIN_ANGLE);
    }




}
