package hw4;

import api.*;

/**
 * @author Abhay Prasanna Rao
 * AbstractLink is an abstract base class that implements both Crossable and Traversable interfaces.
 * This class is designed to serve as a common foundation for any specific link type.
 * It provides default implementation for some methods, while leaving the implementation of
 * other methods to its derived classes.
 */
public abstract class AbstractLink implements Crossable, Traversable {
	public AbstractLink() {
		
	}

    /**
     * This abstract method is called when a train enters the crossing.
     * The implementation of this method will be provided by the derived classes.
     */

    public void trainEnteredCrossing() {
    	
    }

    /**
     * This abstract method is called when a train exits the crossing.
     * The implementation of this method will be provided by the derived classes.
     */
    
    public void trainExitedCrossing() {
    	
    }

    /**
     * This abstract method returns the connected point for a given input point.
     * The implementation of this method will be provided by the derived classes.
     *
     * @param point The input point for which the connected point is to be determined.
     * @return The connected point for the input point.
     */
    
  
    public int getNumPaths() {
    	return 0;
    }

    /**
     * This method shifts the points of the link according to the given position vector.
     * The default implementation is provided here, but it can be overridden by the derived classes.
     *
     * @param positionVector The position vector used for shifting the points.
     */
    @Override
    public void shiftPoints(PositionVector positionVector) {
        Point connectedPoint = getConnectedPoint(positionVector.getPointB());
        if (connectedPoint != null) {
            positionVector.setPointA(connectedPoint);

            // Check if connectedPoint is the low or high endpoint of the path
            if (connectedPoint.equals(connectedPoint.getPath().getLowpoint())) {
                positionVector.setPointB(connectedPoint.getPath().getPointByIndex(1));
            } else if (connectedPoint.equals(connectedPoint.getPath().getHighpoint())) {
                positionVector.setPointB(connectedPoint.getPath().getPointByIndex(connectedPoint.getPointIndex() - 1));
            }
        }
    }

	
}
