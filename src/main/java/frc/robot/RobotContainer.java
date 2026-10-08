// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * WPILib recommends putting most robot logic in here. Creek takes it 1 step further and abstracts it to seperate files
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...  


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new Command() {
      
    };
  }
}
