package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
//import com.revrobotics.spark.SparkRelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.config.EncoderConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.MathUtil;

/**
     * @param deviceID The channel of the motor controller
     * @param controlMode Specify whether the motor controller is operating in Brushed or Brushless mode
     * @param idleMode Specify whether the motor controller is set to Coast or Brake mode
     * @param reverse Reverses the direction of the motor controller
     * @param positionFactor The ratio of encoder units to desired units (ie. units -> in)
*/

public class MotorController implements edu.wpi.first.wpilibj.motorcontrol.MotorController{
    private final SparkMax motor;
    public final SparkClosedLoopController pidController;
    private final RelativeEncoder encoder;
    private final String name;

    private final EncoderConfig encoderConfig;
    private final SparkMaxConfig sparkMaxConfig;

    public MotorController(String name, int deviceID, MotorType motorType, boolean inverted, IdleMode idleMode, double positionFactor){
        this.name = name;
        motor = new SparkMax(deviceID, motorType);
        pidController = motor.getClosedLoopController();

        //Encoder config
        encoderConfig = new EncoderConfig();
        encoderConfig.positionConversionFactor(positionFactor);

        //SparkMax config
        sparkMaxConfig = new SparkMaxConfig();
        sparkMaxConfig.inverted(inverted);
        sparkMaxConfig.idleMode(idleMode);
        sparkMaxConfig.apply(encoderConfig);

        motor.configure(sparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        encoder = motor.getEncoder();
    }

    public MotorController(String name, int deviceID, MotorType motorType, boolean inverted, IdleMode idleMode){
        this(name, deviceID, motorType, inverted, idleMode, 1.0);
    }

    //Speed from -1.0 to 1.0 based on motor's available power
    @Override
    public void set(double speed){
        motor.set(speed);
    }

    @Override
    public double get(){
        return motor.get();
    }

    @Override
    public void stopMotor(){
        motor.set(0);
    }

    public void setVoltage(double volts){
        double capped = MathUtil.clamp(volts, -12.0, 12.0);
        motor.setVoltage(capped);
    }

    @Override
    public boolean getInverted(){
        return motor.getInverted();
    }

    @Override
    public void setInverted(boolean inverted)
    {
        motor.setInverted(inverted);
    }

    //SparkMax specific
    public void resetEncoder(){
        encoder.setPosition(0);
    }

    public double getPosition(){
        return encoder.getPosition();
    }

    public void setPosition(double pos){
        encoder.setPosition(pos);
    }

    public double getVelocity(){
        return encoder.getVelocity();
    }

    public void setPID(double kP, double kI, double kD){
        sparkMaxConfig.closedLoop.p(kP).i(kI).d(kD).outputRange(-12, 12);
        motor.configure(sparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public void setPositionConversionFactor(double factor){
        encoderConfig.positionConversionFactor(factor);
        sparkMaxConfig.apply(encoderConfig);
        motor.configure(sparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public void setVelocityConversionFactor(double factor){
        encoderConfig.velocityConversionFactor(factor);
        sparkMaxConfig.apply(encoderConfig);
        motor.configure(sparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public String getName(){
        return name;
    }

    //don't plan on using this
    @Override
    public void disable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disable'");
    }
}
