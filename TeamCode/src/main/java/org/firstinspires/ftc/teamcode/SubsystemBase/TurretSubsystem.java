package org.firstinspires.ftc.teamcode.SubsystemBase;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TurretSubsystem {

    private DcMotor turretMotor;
    private int targetAngle;

    public TurretSubsystem (HardwareMap hw) {

        turretMotor = hw.get(DcMotor.class, "turretMotor");
        turretMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        turretMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        turretMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        turretMotor.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    public double getCurrentAngle() {
        return turretMotor.getCurrentPosition();
    }

    public void setTurretDesiredAngle(int angle) {
        angle = targetAngle;
        turretMotor.setTargetPosition(targetAngle);
    }

    public void stopTurret() {
        turretMotor.setPower(0);
    }

    public boolean isAtTarget() {
       double currentAngle = getCurrentAngle();
        if (abs(targetAngle - currentAngle) < 5 ) {
            return true;
        }
        return false;
    }
}
