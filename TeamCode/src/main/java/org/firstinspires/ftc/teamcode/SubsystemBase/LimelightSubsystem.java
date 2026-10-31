package org.firstinspires.ftc.teamcode.SubsystemBase;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.hardware.limelightvision.LLResult;
import java.util.List;
import com.qualcomm.hardware.limelightvision.LLFieldMap;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public class LimelightSubsystem {
    private Limelight3A limelight;
    private double tx; //yatay
    private double ty; //dikey
    private double ta; //alan

    public LimelightSubsystem(HardwareMap hw) {
        limelight = hw.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0);

    }

    public void startLimelight() {
        limelight.start();
    }

    public void stopLimelight() {
        limelight.stop();
    }

    public void latestResult() {
        LLResult limelightLatestResult = limelight.getLatestResult();

        if (limelightLatestResult != null && limelightLatestResult.isValid()) {
            tx = limelightLatestResult.getTx();
            ty = limelightLatestResult.getTy();
            ta = limelightLatestResult.getTa();
        }
    }

    public double getTx() {
        return tx;
    }

    public double getTy() {
        return ty;
    }

    public double getTa() {
        return ta;
    }

    public void findNearestApriltag() {
        LLResult limelightLatestResult = limelight.getLatestResult();

        if (limelightLatestResult != null && limelightLatestResult.isValid()) {
            List<LLResultTypes.FiducialResult> fiducials = limelightLatestResult.getFiducialResults();
            for (LLResultTypes.FiducialResult fiducial : fiducials) {
                int id = fiducial.getFiducialId(); // The ID number of the fiducial
                double x = fiducial.getTargetXDegrees(); // Where it is (left-right)
                double y = fiducial.getTargetYDegrees(); // Where it is (up-down)
                Pose3D cameraSpace = fiducial.getTargetPoseCameraSpace();

            }
        }

    }

}
