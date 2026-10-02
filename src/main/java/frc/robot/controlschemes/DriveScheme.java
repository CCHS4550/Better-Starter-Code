package frc.robot.controlschemes;

import frc.robot.subsystems.drive.Drive;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class DriveScheme {
    private static CommandXboxController controller;
    private static DoubleSupplier driveSpeed = () -> 1.0;

    public void configure(Drive driveTrain, int port) {
        controller = new CommandXboxController(port);

        configureButtons(driveTrain, port);
    }

    private static void configureButtons(Drive drivetrain, int port) {
        RunCommand drive = new RunCommand(() -> {
            drivetrain.drive(controller.getLeftY() * driveSpeed.getAsDouble(), controller.getRightX() * driveSpeed.getAsDouble());
        }, drivetrain);

        drivetrain.setDefaultCommand(drive);
    }
}
