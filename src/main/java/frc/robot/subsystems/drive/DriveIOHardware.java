package frc.robot.subsystems.drive;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import frc.robot.Constants;
import frc.robot.MotorController;

public class DriveIOHardware implements DriveIO {
    private MotorController frontLeftMotor = new MotorController("FrontLeftMotor",
            Constants.DriveConstants.FLdeviceID, MotorType.kBrushless, true, IdleMode.kBrake); 
    private MotorController frontRightMotor = new MotorController("FrontRightMotor",
            Constants.DriveConstants.FRdeviceID, MotorType.kBrushless, false, IdleMode.kBrake);
    private MotorController backLeftMotor = new MotorController("BackLeftMotor", Constants.DriveConstants.BLdeviceID,
            MotorType.kBrushless, true, IdleMode.kBrake);
    private MotorController backRightMotor = new MotorController("BackRightMotor",
            Constants.DriveConstants.BRdeviceID, MotorType.kBrushless, false, IdleMode.kBrake);

    private DifferentialDrive frontDifferentialDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
    private DifferentialDrive backDifferentialDrive = new DifferentialDrive(backLeftMotor, backRightMotor);

    @Override
    public void stopRobot() {
        frontLeftMotor.set(0);
        frontRightMotor.set(0);
        backLeftMotor.set(0);
        backRightMotor.set(0);
    }

    @Override
    public void differentialDrive(double forwardSpeed, double turnSpeed) {
        if (turnSpeed > 0.5 || turnSpeed < -0.5) {
            frontDifferentialDrive.arcadeDrive(forwardSpeed, turnSpeed);
            backDifferentialDrive.arcadeDrive(forwardSpeed, turnSpeed);
        } else {
            frontDifferentialDrive.arcadeDrive(forwardSpeed, 0);
            backDifferentialDrive.arcadeDrive(forwardSpeed, 0);
        }
    }

}