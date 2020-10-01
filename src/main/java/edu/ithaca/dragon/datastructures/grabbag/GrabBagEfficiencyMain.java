package edu.ithaca.dragon.datastructures.grabbag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import bridges.benchmark.GrabBagAddingItemsBenchmark;
import bridges.benchmark.GrabBagRemovingItemsBenchmark;
import bridges.connect.Bridges;
import edu.ithaca.dragon.datastructures.queue.LeftEndListQueue;
import edu.ithaca.dragon.datastructures.queue.RightEndListQueue;
import edu.ithaca.dragon.datastructures.stack.LeftTopListStack;
import edu.ithaca.dragon.datastructures.stack.RightTopListStack;

public class GrabBagEfficiencyMain {
    public static void main(String[] args) throws Exception {
        Bridges bridges = new Bridges(3, "tdragon", "29315085544");
        bridges.setTitle("Benchmarking GrabBags");

        int numDataPoints = 50;
        int numActionsPerDataPoint = 3000;
        List<GrabBag<String>> bags = new ArrayList<>();
        //TODO: should be able to add GrabBags like comments below
        // once you have defined StackGrabBag and QueueGrabBag
        // bags.add(new StackGrabBag<String>(new LeftTopListStack<String>()));
        // bags.add(new StackGrabBag<String>(new RightTopListStack<String>()));
        // bags.add(new QueueGrabBag<String>(new RightEndListQueue<String>()));
        // bags.add(new QueueGrabBag<String>(new LeftEndListQueue<String>()));

        GrabBagAddingItemsBenchmark addItemsBenchmark = new GrabBagAddingItemsBenchmark(bags, numDataPoints, numActionsPerDataPoint);
        bridges.setDataStructure(addItemsBenchmark.getViewableModel());
        bridges.visualize();
        GrabBagRemovingItemsBenchmark removingItemsBenchmark = new GrabBagRemovingItemsBenchmark(bags, numDataPoints, numActionsPerDataPoint);
        bridges.setDataStructure(removingItemsBenchmark.getViewableModel());
        bridges.visualize();
    }
}
