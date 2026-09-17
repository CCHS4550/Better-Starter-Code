package frc.robot.subsystems.drive;

public interface DriveIO {
    public default void stopRobot() {
    }
    
    public default void differentialDrive(double forwardSpeed, double turnSpeed) {
    }
}