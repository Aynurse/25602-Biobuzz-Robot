package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.SubsystemBase.DrivetrainSubsystem;
import org.firstinspires.ftc.teamcode.Commands.DrivetrainCommand;
import org.firstinspires.ftc.teamcode.SubsystemBase.IntakeSubsystem;

import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class TeleOpMode extends OpMode {


    private DrivetrainSubsystem drivetrainSubsystem;
    private DrivetrainCommand drivetrainCommand;
    private IntakeSubsystem intakeSubsystem;
    private int targetTicks = 200;
    private Gamepad previousGamepad1 = new Gamepad();
    private Gamepad currentGamepad1 = new Gamepad();


    @Override

    public void init() {
        drivetrainSubsystem = new DrivetrainSubsystem(hardwareMap);
        drivetrainCommand = new DrivetrainCommand(
                drivetrainSubsystem,
                () -> -gamepad1.left_stick_x,
                () -> -gamepad1.left_stick_y,
                () -> -gamepad1.right_stick_x);

        intakeSubsystem = new IntakeSubsystem(hardwareMap);
    }

    @Override

    public void start() {
        drivetrainCommand.schedule();

    }

    @Override
    public void loop() {

        previousGamepad1.copy(currentGamepad1);
        currentGamepad1.copy(gamepad1);


        if (currentGamepad1.y && !previousGamepad1.y) {

        }

        if (gamepad1.a) {
            intakeSubsystem.startIntakeMotor();
        }
        else {
            intakeSubsystem.stopIntakeMotor();
        }

        if (gamepad1.b) {
            intakeSubsystem.turnIntakeServo();
        }
        else {
            intakeSubsystem.stopIntakeServo();
        }

        if (gamepad1.x) {
            intakeSubsystem.lowerFlowerMechanicsm();
        }
        else {
            intakeSubsystem.raiseFlowerMechanicsm();
        }

        CommandScheduler.getInstance().run();
    }

    @Override
    public void stop() {

        CommandScheduler.getInstance().reset();
        intakeSubsystem.stopIntakeMotor();
        intakeSubsystem.stopIntakeServo();
    }

}