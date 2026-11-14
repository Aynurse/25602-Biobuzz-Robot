package org.firstinspires.ftc.teamcode.Calculators;

import java.util.ArrayList;
import java.util.List;

public class HoodCalculator {

    private double targetAngle;
    private final List<Integer> distances = new ArrayList<>(
            List.of(30, 60, 90, 120)
    );

    private final List<Integer> angles = new ArrayList<>(
            List.of(20, 35, 50, 65)
    );



    public Double calculateAngle(double targetDistance) {

        for (int i = 0; i < distances.size() - 1; i++) {

            if (targetDistance >= distances.get(i) && targetDistance < distances.get(i + 1)) {

                double firstDistance = distances.get(i);
                double secondDistance = distances.get(i + 1);
                double firstAngle = angles.get(i);
                double secondAngle = angles.get(i + 1);

                targetAngle = firstAngle +
                        ((targetDistance - firstDistance) / (secondDistance - firstDistance)) *
                                (secondAngle - firstAngle);

                return targetAngle;
            }

        }

        if (targetDistance == distances.get(distances.size() - 1) ) {
            return Double.valueOf(angles.get(angles.size()-1));
        }

        return null;


    }
}



