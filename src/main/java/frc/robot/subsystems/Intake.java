package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  private CANSparkMax intakeMotor = new CANSparkMax(Constants.kIntakeId, MotorType.kBrushless);

  //INPUTS ------------------------------------------------------------------>
  boolean intakeForward = false; 
  boolean intakeReverse = false;
  boolean statePiston1 = false;
  boolean statePiston2 = false;
  
  public Intake() {  } //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  public void takeIn(boolean inTakeIn){
    intakeForward = inTakeIn;
    if (intakeForward){
    intakeMotor.set(Constants.kIntakeDemand);
    }
    else{
      intakeMotor.set(0);
    }
}

//sacar pelotas
public void takeOut(boolean inTakeOut){
    intakeReverse = inTakeOut;
    if (intakeReverse){
      intakeMotor.set(-Constants.kIntakeDemand);
    }
    else{
      intakeMotor.set(0);
      }
  }
  //Funcion para poner salidas a SmartDashBoard 
  public void IntakeLogsOutput(){
    SmartDashboard.putBoolean("Piston1 State", statePiston1);
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
