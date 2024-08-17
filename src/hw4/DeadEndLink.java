package hw4;

import api.*;

/**
 *@author Abhay Prasanna Rao
 * DeadEndLink is a concrete class that extends the AbstractLink class.
 * It represents a link with a single point that leads to a dead-end.
 * There is no action required when shifting points, as it is a dead-end.
 */
public class DeadEndLink extends AbstractLink {

    /**
     * This method returns null for any input point, as there is no connected point
     * in a dead-end link.
     * @param point The input point for which the connected point is to be determined.
     * @return null, as there is no connected point in a dead-end link.
     */
    @Override
    public Point getConnectedPoint(Point point) {
        return null;
    }

    /**
     * This method is called when a train enters the crossing.
     * No specific action is required for a DeadEndLink when a train enters the crossing.
     */
    @Override
    public void trainEnteredCrossing() {
        // Do nothing
    }

    /**
     * This method is called when a train exits the crossing.
     * No specific action is required for a DeadEndLink when a train exits the crossing.
     */
    @Override
    public void trainExitedCrossing() {
        // Do nothing
    }

    /**
     * This method returns the number of paths associated with the link.
     * For a DeadEndLink, there is always one path: the path leading to the dead-end.
     * @return The number of paths associated with the link, which is always 1 for a DeadEndLink.
     */
    @Override
    public int getNumPaths() {
        return 1;
    }

    /**
     * This method does nothing, as there is no action required for shifting points
     * in a dead-end link.
     * @param positionVector The position vector used for shifting the points.
     */
    @Override
    public void shiftPoints(PositionVector positionVector) {
        // No action is required as this is a dead-end link.
    }
}
