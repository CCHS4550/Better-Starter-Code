package frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase{
    public DriveIO hardware;

    public Drive(DriveIO hardware)
    {
        this.hardware = hardware;
    }

    public void stopRobot()
    {
        hardware.stopRobot();
    }

    public void drive(double forwardSpeed, double turnSpeed)
    {
        hardware.tankDrive(forwardSpeed, turnSpeed);
    }
}
