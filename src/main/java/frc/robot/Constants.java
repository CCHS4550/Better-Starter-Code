// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;

    //Refresh rate in ms
    public static final int signalRefreshRate = 20;
  }

  public static class DriveConstants
  {
    // Device CAN IDs
    public static final int pigeonCanId = 9; // TODO: URGENT, switch to a nav x (edit i don't really know what this means but imma leave it)

    //Find!!!
    public static final int frontRightDriveCanId = 999;
    public static final int frontLeftDriveCanId = 999;
    public static final int backRightDriveCanId = 999;
    public static final int backLeftDriveCanId = 999;

    public static final int frontRightTurnCanId = 999;
    public static final int frontLeftTurnCanId = 999;
    public static final int backRightTurnCanId = 999;
    public static final int backLeftTurnCanId = 999;

    public static final boolean frontLeftTurnInverted = false;
    public static final boolean frontRightTurnInverted = false;
    public static final boolean backLeftTurnInverted = false;
    public static final boolean backRightTurnInverted = false;

    public static final boolean frontLeftDriveInverted = false;
    public static final boolean frontRightDriveInverted = false;
    public static final boolean backLeftDriveInverted = false;
    public static final boolean backRightDriveInverted = false;

    //Turn constants (find!!!)
    public static final double turnKp = 0.0;
    public static final double turnKi = 0.0;
    public static final double turnKd = 0.0;
    public static final double turnPIDMinInput = -Math.PI; // Radians
    public static final double turnPIDMaxInput =Math.PI; // Radians

    public static final int turnMotorCurrentLimit = 60; //no clue where ts came from
  }
}
