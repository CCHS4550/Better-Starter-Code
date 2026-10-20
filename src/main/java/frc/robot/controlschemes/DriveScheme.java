package frc.robot.controlschemes;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drive.Drive;

public class DriveScheme {
    private static CommandXboxController controller;

    public void configure(Drive drive, int port)
    {
        controller = new CommandXboxController(port);

        configureButtons(drive);
    }

    private static void configureButtons(Drive drive)
    {
        RunCommand startDriving = new RunCommand(() -> {driveRobot(drive);});

        drive.setDefaultCommand(startDriving);
    }

    private static void driveRobot(Drive drive)
    {
        drive.drive(controller.getLeftY(), controller.getRightX());
    }
}
