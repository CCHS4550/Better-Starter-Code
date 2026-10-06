package frc.robot.subsystems.Drive.module;

public class Module {
    private final ModuleIOInputsAutoLogged inputs = new ModuleIOInputsAutoLogged();
    
    public ModuleIO io;

    public Module(ModuleIO io)
    {
        this.io = io;
    }

    public enum WantedState
    {
        SYS_ID,
        TELEOP_DRIVE, //other desired states
        IDLE
    }

    public enum SystemState
    {
        SYS_ID,
        TELEOP_DRIVE, //other "current" states
        IDLE
    }

    public void periodic()
    {
        io.updateInputs(inputs);
    }


}
