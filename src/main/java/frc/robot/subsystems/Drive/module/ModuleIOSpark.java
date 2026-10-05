package frc.robot.subsystems.Drive.module;

import com.revrobotics.spark.SparkBase;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;

public class ModuleIOSpark implements ModuleIO{
    private final int module;

    private final SparkBase driveMotor;
    private final SparkBase turnMotor;

    public ModuleIOSpark(int module)
    {
        this.module = module;
    }

    /*
     * Simple open loop function
     * 
     * @param voltage to set turn motor to
     */
    @Override
    public void setTurnOpenLoop(double voltage)
    {

    }

}

