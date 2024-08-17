package hw4;

import api.*;

/**
* @author Abhay Prasanna Rao
 * TurnLink is a concrete class that extends the AbstractLink class.
 * It represents a fixed link with three paths, connecting points in a turn configuration.
 */
public class TurnLink extends AbstractLink {
    private Point endpointA;
    private Point endpointB;
    private Point endpointC;

    /**
     * Constructor for the TurnLink class.
     * @param endpointA The first point in the link.
     * @param endpointB The second point in the link.
     * @param endpointC The third point in the link.
     */
    public TurnLink(Point endpointA, Point endpointB, Point endpointC) {
        this.endpointA = endpointA;
        this.endpointB = endpointB;
        this.endpointC = endpointC;
    }

    /**
     * This method returns the connected point of the input point if it exists.
     * @param point Input point to find the connected point.
     * @return The connected point if it exists, otherwise null.
     */
    @Override
    public Point getConnectedPoint(Point point) {
        if (point.equals(endpointA)) {
            return endpointC;
        } else if (point.equals(endpointB)) {
            return endpointA;
        } else if (point.equals(endpointC)) {
            return endpointA;
        } else {
            return null;
        }
    }

    /**
     * This method returns the number of paths in the TurnLink.
     * @return The number of paths, which is 3 for TurnLink.
     */
    @Override
    public int getNumPaths() {
        return 3;
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
