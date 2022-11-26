package frc.robot.controlboard;

public interface IOperatorControlBoard {

        boolean getIntake();

        boolean getHopper();
        
        double getBox();

        double releaseBox();
        
        double armMove();
    
}