package hw4;

import api.*;

/**
 *@author Abhay Prasanna Rao
 * MultiFixedLink is a concrete class that extends the AbstractLink class.
 * It represents a link with multiple fixed point pairs, each pair having two connected points.
 */
public class MultiFixedLink extends AbstractLink {
    
    // An array of PointPair objects that represent the connected points in the link.
    private PointPair[] pairs;

    /**
     * Constructor for the MultiFixedLink class.
     * @param pairs An array of PointPair objects representing the connected points in the link.
     */
    public MultiFixedLink(PointPair[] pairs) {
        this.pairs = pairs;
    }

    /**
     * This method returns the connected point for the given input point.
     * @param point The input point for which the connected point is to be determined.
     * @return The connected point for the input point, or null if not found.
     */
    @Override
    public Point getConnectedPoint(Point point) {
        for (PointPair pair : pairs) {
            if (point.equals(pair.getPointA())) {
                return pair.getPointB();
            } else if (point.equals(pair.getPointB())) {
                return pair.getPointA();
            }
        }
        return null;
    }

    /**
     * This method is called when a train enters the crossing.
     * No specific action is required for a MultiFixedLink when a train enters the crossing.
     */
    @Override
    public void trainEnteredCrossing() {
        // Do nothing
    }

    /**
     * This method is called when a train exits the crossing.
     * No specific action is required for a MultiFixedLink when a train exits the crossing.
     */
    @Override
    public void trainExitedCrossing() {
        // Do nothing
    }

    /**
     * This method returns the number of paths associated with the link.
     * @return The number of paths associated with the link, which is equal to the length of the pairs array.
     */
    @Override
    public int getNumPaths() {
        return pairs.length;
    }
    /**
     * This method sets the PointPair at the given index to a new PointPair.
     * @param index The index at which the new PointPair should be set.
     * @param newPair The new PointPair to be set at the specified index.
     */
    protected void setPairAt(int index, PointPair newPair) {
        if (index >= 0 && index < pairs.length) {
            pairs[index] = newPair;
        }
    }

    /**
     * This method shifts the points based on the position vector.
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
