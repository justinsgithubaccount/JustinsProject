package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{
    private static DriveTrain drivetrain;
    public static DriveTrain getInstance(){
        if (drivetrain == null){
            drivetrain = new DriveTrain();
        }
        return drivetrain;
    }
    private CANSparkMax motor1Left, motor2Left, motor1Right, motor2Right;

    public DriveTrain(){
        motor1Left = new CANSparkMax(MotorIDs.LEFT_1, MotorType.kBrushless);
        motor2Left = new CANSparkMax(MotorIDs.LEFT_2, MotorType.kBrushless);
        motor2Left.follow(motor1Left);
        motor1Right = new CANSparkMax(MotorIDs.RIGHT_1, MotorType.kBrushless);
        motor2Right = new CANSparkMax(MotorIDs.RIGHT_2, MotorType.kBrushless);
        motor2Right.follow(motor1Right);

    }
    public void drive(double left, double right){
        motor1Left.set(left);
        motor1Right.set(right);
    }
}
