package edu.ithaca.dragon.maze.mazerunner;

import java.util.List;

import edu.ithaca.dragon.datastructures.grabbag.GrabBag;
import edu.ithaca.dragon.maze.KeyPress;
import edu.ithaca.dragon.maze.Location;

public class GrabBagMazeRunner implements MazeRunnerAPI {

    private GrabBag<Location> myBag;
    private MazeRunnerVisionAPI myVision;

    public GrabBagMazeRunner(GrabBag<Location> emptyGrabBagToUse) {
        myBag = emptyGrabBagToUse;
        myVision = null;
    }

    @Override
    public void initialize(MazeRunnerVisionAPI mazeRunnerVision) {
        myVision = mazeRunnerVision;
        myBag.makeEmpty();
    }

    @Override
    public Location chooseNewLocation(KeyPress keyPress) {
        //TODO: replace the following with your prior definition here
        return myVision.getCurrentLocation();
    }


}
