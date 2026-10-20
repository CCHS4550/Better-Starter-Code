package frc.robot.subsystems.Drive;

public interface DriveIO {
    public default void stopRobot() {}

    public default void tankDrive(double forwardSpeed, double turnSpeed) {}
}
