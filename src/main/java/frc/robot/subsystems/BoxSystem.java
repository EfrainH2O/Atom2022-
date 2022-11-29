package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BoxSystem extends SubsystemBase{
    
    //Hardware ----------------------------------------------------------------->
    private TalonSRX armMotor = new TalonSRX(Constants.kArmsId);
    //INPUTS ------------------------------------------------------------------>
    boolean BoxState = false; 
    boolean ArmIn = false;

    public BoxSystem() {} //constructor del subsistema

    //------------------// Funciones del subsistema //-------------------------------//

    //Funcion para disparar
    public void TBoxSystem(boolean inArm){
        ArmIn = inArm;
        if (ArmIn==true){
            if(BoxState==false){
                BoxState=true;
            armMotor.set(ControlMode.PercentOutput, 1);
            //delay
            armMotor.set(ControlMode.PercentOutput, 0);
            }
            else if (BoxState==true){
                BoxState=false;
            armMotor.set(ControlMode.PercentOutput, -1);
            //delay
            armMotor.set(ControlMode.PercentOutput, 0);
            }
        }
    }

    //Funcion para poner salidas a SmartDashBoard 
    public void ShooterLogsOutput(){/*codigo para dar salidas a SmartDashBoard*/
        SmartDashboard.putBoolean("Shooter Active", BoxState);
    }
        
    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    }
}


