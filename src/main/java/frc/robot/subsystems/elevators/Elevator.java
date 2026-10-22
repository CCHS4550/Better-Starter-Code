package frc.robot.subsystems.elevators;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    public ElevatorIO io;

    public Elevator(ElevatorIO io) {
        this.io = io;
    }

    public void stopElevator() {
        io.stopElevator();
    }

    public void setSpeed(double speed) {
        io.setSpeed(speed);
    }

    public void setVoltage(double volts) {
        io.setVoltage(volts);
    }

    public void setPosition(double position) {
        io.setPosition(position);
    }

    public double getPosition() {
        return io.getPosition();
    }

    public double getVelocity() {
        return io.getVelocity();
    }

    public void resetEncoder() {
        io.resetEncoder();
    }

    public Command runElevator(double speed) {
        return this.runEnd(
            () -> setSpeed(speed),
            this::stopElevator
        );
    }

    public Command moveToPosition(double position) {
        return this.runEnd(
            () -> setPosition(position),
            this::stopElevator
        );
    }
}
