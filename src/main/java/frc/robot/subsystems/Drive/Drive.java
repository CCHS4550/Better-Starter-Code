package frc.robot.subsystems.Drive;

public class Drive {
    public DriveIOHardware hardware;

    public Drive(DriveIOHardware hardware)
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
