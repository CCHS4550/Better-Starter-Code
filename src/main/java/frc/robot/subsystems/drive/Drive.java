package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Drive extends SubsystemBase{
    public DriveIO io;

    public Drive(DriveIO io)
    {
        this.io = io;
    }

    public void stopRobot(){
        io.stopRobot();
    }

    public void driveStraight(double speed){
        io.differentialDrive(speed, 0);
    }

    public void drive(double speed, double turn)
    {
        io.differentialDrive(speed, turn);
    }

    //Autos---------------------------------------------------------------------------------------
    public Command basicDrive(double speed){ //Drive straight while executed by command scheduler
        return this.runEnd(
            () -> driveStraight(speed), 
            this::stopRobot);
    }

    public Command autoDriveForward(double speed, double time){
        return Commands.deadline(
            Commands.waitSeconds(time), 
            basicDrive(speed)
        ).withTimeout(time);
    }
}
