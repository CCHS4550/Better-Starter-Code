package frc.robot.subsystems.Drive;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.MotorController;

public class DriveIOHardware {
    //MotorController for controlling the motors
    MotorController frontLeftMotor = new MotorController("jimothy", Constants.DriveConstants.FLdeviceID, MotorType.kBrushless, false, IdleMode.kBrake);
    MotorController frontRightMotor = new MotorController("timothy", Constants.DriveConstants.FRdeviceID, MotorType.kBrushless, false, IdleMode.kBrake);
    MotorController backLeftMotor = new MotorController("dimitri", Constants.DriveConstants.BLdeviceID, MotorType.kBrushless, false, IdleMode.kBrake);
    MotorController backRightMotor = new MotorController("tejas", Constants.DriveConstants.BRdeviceID, MotorType.kBrushless, false, IdleMode.kBrake);

    DifferentialDrive frontDifferentialDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
    DifferentialDrive backDifferentialDrive = new DifferentialDrive(backLeftMotor, backRightMotor);
    //function that connects the motors and makes them do something
    public void stopRobot()
    {
        frontLeftMotor.set(0);
        frontRightMotor.set(0);
        backLeftMotor.set(0);
        backRightMotor.set(0);
    }

    public void tankDrive(double forwardSpeed, double turnSpeed)
    {
        frontDifferentialDrive.arcadeDrive(forwardSpeed, turnSpeed);
        backDifferentialDrive.arcadeDrive(forwardSpeed, turnSpeed);
    }
}
