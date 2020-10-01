package bridges.benchmark;

import bridges.base.DataStruct;
import bridges.base.LineChart;
import edu.ithaca.dragon.datastructures.grabbag.GrabBag;

import java.util.ArrayList;
import java.util.List;

public class GrabBagAddingItemsBenchmark extends Benchmark {

	public GrabBagAddingItemsBenchmark(List<? extends GrabBag<String>> grabBagsToTest, int rounds, int itemsPerRound) {
    	super(new LineChart());
    	plot.setTitle("GrabBag Adding items Runtime Comparison");
		plot.setXLabel("Amount of Data in grabBag");
		plot.setYLabel("Runtime (in ms)");
	
		for (int i=0; i< grabBagsToTest.size(); i++){
			GrabBag<String> grabBag = grabBagsToTest.get(i);
			generatePutSomethingData(Integer.toString(i+1)+"-in", grabBag, plot, rounds, itemsPerRound);
		}

	}

	public static void generatePutSomethingData(String grabBagName, GrabBag<String> grabBag, LineChart chartToAddTo, int rounds, int itemsPerRound){
		ArrayList<Double> xDataPoints = new ArrayList<>();
		ArrayList<Double> yDataPoints = new ArrayList<>();
		for (int i=1; i < rounds; i++){
			timeManyPuts(i, itemsPerRound, grabBagName, grabBag, xDataPoints, yDataPoints);
		}
		chartToAddTo.setXData(grabBagName, xDataPoints);
		chartToAddTo.setYData(grabBagName, yDataPoints);
	}

	public static void timeManyPuts(int roundNumber, int numPushes, String grabBagName, GrabBag<String> grabBag, ArrayList<Double> xDataPoints, ArrayList<Double> yDataPoints ) {
		long start = System.nanoTime();
		for (int i=0; i<numPushes; i++){
			grabBag.putSomethingIn("an example string");
		}
		long end = System.nanoTime();
		long runTime = (end - start)/ 1000; //runtime in microseconds
		xDataPoints.add(Double.valueOf(roundNumber*numPushes));
		yDataPoints.add(Double.valueOf(runTime));
	}

	public DataStruct getViewableModel(){
		return plot;
	}
}