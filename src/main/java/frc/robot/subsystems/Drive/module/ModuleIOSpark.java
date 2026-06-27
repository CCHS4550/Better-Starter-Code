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

    /*
     * set turn motor to a desire angle, while wrapping the setpoint to prevent invalid inputs and
     * account for the motor offset no feedforward because there is no velocity goal to achieve
     *
     * @param rotation desire module angle in radians
     */
    @Override
    public void setTurnPos(Rotation2d rotation) {
    double setPoint =
        MathUtil.inputModulus(
            rotation.plus(rotationOffset).getRadians(),
            Constants.DriveConstants.turnPIDMinInput,
            Constants.DriveConstants.turnPIDMaxInput);
    double volts =
        turnPID.calculate((Rotation2d.fromRotations(absoluteEncoder.get())).getRadians(), setPoint);
    setTurnOpenLoop(volts);
    }
}

