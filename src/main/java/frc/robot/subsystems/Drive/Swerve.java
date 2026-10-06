package frc.robot.subsystems.Drive;

public class Swerve extends SubsystemBase {

    //4 moduleIO instantiations
    
    public enum WantedState
    {
        SYS_ID,
        TELEOP_DRIVE,
        //other wanted states
        IDLE
    }

    public enum SystemState
    {
        SYS_ID,
        TELEOP_DRIVE,
        //other system states
        IDLE
    }
    
    private SystemState systemState = SystemState.TELEOP_DRIVE;
    private WantedState wantedState = WantedState.TELEOP_DRIVE;

    final SwerveIOInputsAutoLogged swerveInputs = new SwerveIOInputsAutoLogged();

    public void periodic()
    {
        io.updateInputs(swerveInputs);
        Logger.processInputs("Subsystem/Drive", swerveInputs);

    }

    public SwerveModuleState getState()
    {
        //current swerve state
    }
    
    public SwerveModuleState getPosition()
    {
        //current swerve position
    }
    
    public void stop()
    {
        io.setTurnOpenLoop(0.0);
    }

    
}
