package hw4;

import api.*;

/**
  * @author Abhay Prasanna Rao
 * SwitchLink is a concrete class that extends the AbstractLink class.
 * It represents a switch link that connects a point to either of two other points.
 */
public class SwitchLink extends AbstractLink {
    private Point endpointA;
    private Point endpointB;
    private Point endpointC;
    private boolean isTurn; // Boolean flag to indicate if the switch link should turn or go straight
    private boolean trainInCrossing; // Boolean flag to indicate if a train is currently in the crossing

    /**
     * Constructor for the SwitchLink class.
     * @param endpointA The common point connected to both endpointB and endpointC.
     * @param endpointB The first possible connected point to endpointA.
     * @param endpointC The second possible connected point to endpointA.
     */
    public SwitchLink(Point endpointA, Point endpointB, Point endpointC) {
        this.endpointA = endpointA;
        this.endpointB = endpointB;
        this.endpointC = endpointC;
        this.isTurn = false; // Initially, set the switch link to not turn
        this.trainInCrossing = false; // Initially, set the trainInCrossing flag to false
    }

    /**
     * This method sets the value of the isTurn flag.
     * @param isTurn The new value for the isTurn flag.
     */
    public void setTurn(boolean isTurn) {
        if (!trainInCrossing) { // Only allow changing the turn if no train is in the crossing
            this.isTurn = isTurn;
        }
    }

    /**
     * This method returns the connected point of the input point if it exists.
     * @param point Input point to find the connected point.
     * @return The connected point if it exists, otherwise null.
     */
    @Override
    public Point getConnectedPoint(Point point) {
        if (point.equals(endpointA)) {
            if (isTurn) {
                return endpointC; // If the switch is turned, return the second point
            } else {
                return endpointB; // If the switch is straight, return the first point
            }
        } else if (point.equals(endpointB) || point.equals(endpointC)) {
            return endpointA; // If the input point is either of the connected points, return the common point
        } else {
            return null; // If the input point is not part of the link, return null
        }
    }

    /**
     * This method returns the number of paths in the SwitchLink.
     * @return The number of paths, which is 2 for SwitchLink.
     */
    @Override
    public int getNumPaths() {
        return 2;
    }

	@Override
	public void trainEnteredCrossing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trainExitedCrossing() {
		// TODO Auto-generated method stub
		
	}
}
