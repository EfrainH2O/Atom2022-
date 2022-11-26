package frc.robot.controlboard;

import frc.robot.Constants;

public class OperatorControlBoard implements IOperatorControlBoard {

    private static OperatorControlBoard mInstance = null;

    public static OperatorControlBoard getInstance() {
        if (mInstance == null) {
            mInstance = new OperatorControlBoard();
        }

        return mInstance;
    }

    private final XboxController mController;

    private OperatorControlBoard() {
        mController = new XboxController(Constants.kOperatorControlPort);
    }

    @Override
    public boolean getIntake() {
        return mController.getButtonReleased(XboxController.Button.X);
    }
    @Override
    public boolean getHopper() {
        return mController.getButtonReleased(XboxController.Button.B);
    }
    @Override
    public double getBox(){
        return mController.getTrigger(XboxController.Side.RIGHT);
    }
    @Override
    public double releaseBox(){
        return mController.getTrigger(XboxController.Side.LEFT);
    }
    public double armMove(){
        return getBox()- releaseBox();
    }
}