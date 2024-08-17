package hw4;

import api.*;

/**
* @author Abhay Prasanna Rao
 * MultiSwitchLink is a concrete class that extends the MultiFixedLink class.
 * It represents a link with multiple switchable point pairs, allowing the connections to be changed.
 */
public class MultiSwitchLink extends MultiFixedLink {

    // A boolean flag indicating whether a train is currently in the crossing
    private boolean trainInCrossing = false;

    /**
     * Constructor for the MultiSwitchLink class.
     * @param pairs An array of PointPair objects representing the connected points in the link.
     */
    public MultiSwitchLink(PointPair[] pairs) {
        super(pairs);
    }

    /**
     * This method is called when a train enters the crossing.
     * Sets the trainInCrossing flag to true.
     */
    @Override
    public void trainEnteredCrossing() {
        trainInCrossing = true;
    }

    /**
     * This method is called when a train exits the crossing.
     * Sets the trainInCrossing flag to false.
     */
    @Override
    public void trainExitedCrossing() {
        trainInCrossing = false;
    }

    /**
     * This method switches the connection of the PointPair at the specified index to a new PointPair.
     * The connection cannot be modified (method does nothing) when the train is currently in the crossing.
     * @param newPair The new PointPair that will replace the current connection at the specified index.
     * @param index The index at which the connection should be switched.
     */
    public void switchConnection(PointPair newPair, int index) {
        if (!trainInCrossing) {
            setPairAt(index, newPair);
        }
    }
}
