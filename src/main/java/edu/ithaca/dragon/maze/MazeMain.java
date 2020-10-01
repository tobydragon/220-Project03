package edu.ithaca.dragon.maze;

import java.util.LinkedList;


import edu.ithaca.dragon.datastructures.queue.LeftEndListQueue;
import edu.ithaca.dragon.datastructures.stack.LeftTopListStack;
import edu.ithaca.dragon.datastructures.stack.RightTopListStack;
import edu.ithaca.dragon.maze.mazerunner.GrabBagMazeRunner;
import edu.ithaca.dragon.maze.mazerunner.HumanChoiceMazeRunner;
import edu.ithaca.dragon.maze.mazerunner.ManualMazeRunner;
import edu.ithaca.dragon.maze.mazerunner.MazeRunnerAPI;

public class MazeMain {

    public static void main(String args[]) {
        int gridColumns = 31;
        int gridRows = 31;
        MazeRunnerAPI runner = new ManualMazeRunner();
        // MazeRunnerAPI runner = new HumanChoiceMazeRunner();
        new Maze(runner, 1, "tdragon", "29315085544", gridColumns, gridRows);
      }
    
}
