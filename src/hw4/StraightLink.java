package hw4;

import api.Point;

/**
 * StraightLink is a concrete class that extends the AbstractLink class.
 * It represents a fixed link with three endpoints.
 * 
 * @author Abhay Prasanna Rao
 */
public class StraightLink extends AbstractLink {
    // Declare three Point instance variables to represent the endpoints of the link
    private Point PointA;
    private Point PointB;
    private Point PointC;

    /**
     * Constructor for the StraightLink class, taking three Point objects as arguments.
     * 
     * @param endpointA The first endpoint of the link.
     * @param endpointB The second endpoint of the link.
     * @param endpointC The third endpoint of the link.
     */
    public StraightLink(Point endpointA, Point endpointB, Point endpointC) {
        // Assign the passed arguments to the respective instance variables
        this.PointA = endpointA;
        this.PointB = endpointB;
        this.PointC = endpointC;
    }

    /**
     * getConnectedPoint method takes a Point object as an argument.
     * Returns the connected point of the input point if it exists.
     * 
     * @param inputPoint Input point to find the connected point.
     * @return The connected point if it exists, otherwise null.
     */
    public Point getConnectedPoint(Point inputPoint) {
        if (inputPoint.equals(PointA)) {
            return PointB;
        } else if (inputPoint.equals(PointB)) {
            return PointA;
        }
        return null;
    }
}
