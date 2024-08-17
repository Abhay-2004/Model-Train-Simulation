package hw4;

import api.*;

/**
 * @author Abhay Prasanna Rao
 * CouplingLink is a concrete class that extends the AbstractLink class.
 * It represents a link with two points, pointA and pointB.
 * These two points are directly connected, simulating a coupling between them.
 */
public class CouplingLink extends AbstractLink {
    // Two points that are part of the coupling link.
    private Point pointA;
    private Point pointB;

    /**
     * Constructor that initializes the two points of the coupling link.
     * @param pointA The first point of the coupling link.
     * @param pointB The second point of the coupling link.
     */
    public CouplingLink(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    /**
     * This method returns the connected point for a given input point.
     * If the input point is pointA, it returns pointB, and vice versa.
     * If the input point is not part of the link, it returns null.
     * @param inputPoint The point for which the connected point is to be determined.
     * @return The connected point for the input point, or null if the input point is not part of the link.
     */
    @Override
    public Point getConnectedPoint(Point inputPoint) {
        if (inputPoint.equals(pointA)) {
            return pointB;
        } else if (inputPoint.equals(pointB)) {
            return pointA;
        }
        return null;
    }

    /**
     * This method is called when a train enters the crossing.
     * No specific action is required for a CouplingLink when a train enters the crossing.
     */
    @Override
    public void trainEnteredCrossing() {
        // Do nothing
    }

    /**
     * This method is called when a train exits the crossing.
     * No specific action is required for a CouplingLink when a train exits the crossing.
     */
    @Override
    public void trainExitedCrossing() {
        // Do nothing
    }

    /**
     * This method returns the number of paths associated with the link.
     * For a CouplingLink, there are always two paths: one from pointA to pointB, and one from pointB to pointA.
     * @return The number of paths associated with the link, which is always 2 for a CouplingLink.
     */
    @Override
    public int getNumPaths() {
        return 2;
    }
}
