package bridges.benchmark;

import bridges.base.DataStruct;
import bridges.base.LineChart;
import edu.ithaca.dragon.datastructures.grabbag.GrabBag;

import java.util.ArrayList;
import java.util.List;

public class GrabBagRemovingItemsBenchmark extends Benchmark {

	/**
	 * 
	 * @param grabBagsToTest that have already been populated by GrabBagAddingItems BenchMark
	 */
	public GrabBagRemovingItemsBenchmark(List<? extends GrabBag<String>> grabBagsToTest, int rounds, int itemsPerRound) {
    	super(new LineChart());
    	plot.setTitle("GrabBag  Removing Items Runtime Comparison");
		plot.setXLabel("Amount of Data in grabBag");
		plot.setYLabel("Runtime (in ms)");
	
		for (int i=0; i< grabBagsToTest.size(); i++){
			GrabBag<String> grabBag = grabBagsToTest.get(i);
			generateTakeSomethingData(Integer.toString(i+1)+"-out", grabBag, plot, rounds, itemsPerRound);
		}

	}

	public static void generateTakeSomethingData(String grabBagName, GrabBag<String> grabBag, LineChart chartToAddTo, int rounds, int itemsPerRound){
		ArrayList<Double> xDataPoints = new ArrayList<>();
		ArrayList<Double> yDataPoints = new ArrayList<>();
		for (int i=1; i < rounds; i++){
			timeManyTakes(i, itemsPerRound, rounds*itemsPerRound, grabBagName, grabBag, xDataPoints, yDataPoints);
		}
		chartToAddTo.setXData(grabBagName, xDataPoints);
		chartToAddTo.setYData(grabBagName, yDataPoints);
	}

	public static void timeManyTakes(int roundNumber, int numPushes, int totalData, String grabBagName, GrabBag<String> grabBag, ArrayList<Double> xDataPoints, ArrayList<Double> yDataPoints ) {
		long start = System.nanoTime();
		for (int i=0; i<numPushes; i++){
			grabBag.takeSomethingOut();
		}
		long end = System.nanoTime();
		long runTime = (end - start)/ 1000; //runtime in microseconds
		//there is all data in the first runs, and less data each time
		int x = totalData-(roundNumber*numPushes);
		xDataPoints.add(Double.valueOf(x));
		yDataPoints.add(Double.valueOf(runTime));
	}

	public DataStruct getViewableModel(){
		return plot;
	}
}