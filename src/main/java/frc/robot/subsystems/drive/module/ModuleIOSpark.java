package frc.robot.subsystems.Drive.module;

import frc.robot.Constants;
import frc.robot.MotorController;

public class ModuleIOSpark implements ModuleIO{
    private final int module;

    private final MotorController driveMotor;
    private final MotorController turnMotor;

    public ModuleIOSpark(int module){
        this.module = module;

        String name;
        int id;
        boolean inverted;
        
        //1: FL, 2: FR, 3: BL, 4: BR
        switch(module)
        {
            default: 
                case 1:
                    name = "FrontLeftDriveMotor";
                    id = Constants.DriveConstants.frontLeftDriveCanId;
                    inverted = Constants.DriveConstants.frontLeftDriveInverted;
                break;

            case 2:

            case 3:

            case 4:

        }


        driveMotor = new MotorController(null, id, null, false, null);
    }

    /*
     * Simple open loop function
     * 
     * @param voltage to set turn motor to
     */
    @Override
    public void setTurnOpenLoop(double voltage)
    {

    }

}

