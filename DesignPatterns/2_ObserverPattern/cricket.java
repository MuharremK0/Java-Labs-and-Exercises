package ObserverPattern;

import java.util.ArrayList;
import java.util.Iterator;

public class cricket {

	public static void main(String[] args) {
		AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
		CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();
		
		CricketData cricketData = new CricketData();
		
		cricketData.registerObserver(averageScoreDisplay);
		cricketData.registerObserver(currentScoreDisplay);
		
		cricketData.dataChangeed();
		
		cricketData.unregisterObserver(averageScoreDisplay);
		
		cricketData.dataChangeed();
	}

}

interface Subject1 {
	public void registerObserver(Observer1 o);
	public void unregisterObserver(Observer1 o);
	public void notifyObservers();
}

interface Observer1 {
	public void update(int runs,int wickets,float overs);
}

class CricketData implements Subject1 {
	int runs;
	int wickets;
	float overs;
	
	ArrayList<Observer1> observerList;
	
	public CricketData() {
		observerList = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer1 o) {
		observerList.add(o);
		
	}

	@Override
	public void unregisterObserver(Observer1 o) {
		observerList.remove(observerList.indexOf(o));
		
	}

	@Override
	public void notifyObservers() {
		for(Iterator<Observer1> it = observerList.iterator();it.hasNext();) {
			Observer1 observer1 = it.next();
			observer1.update(runs, wickets, overs);
		}
		
	}
	
	private int getLatestRuns() {
		return 90;
	}
	
	private int getLatestWickets() {
		return 2;
	}
	
	private float getLatestOvers() {
		return (float)10.2;
	}
	
	public void dataChangeed() {
		runs = getLatestRuns();
		wickets = getLatestWickets();
		overs = getLatestOvers();
		
		notifyObservers();
	}
}

class AverageScoreDisplay implements Observer1 {
	private float runRate;
	private int predictedScore;
	
	@Override
	public void update(int runs, int wickets, float overs) {
		this.runRate = (float)runs/overs;
		this.predictedScore = (int)(this.runRate*50);
		display();
	}
	
	public void display() {
		System.out.println("\nAverage Score Display: \n"+"Run Rate: "+runRate
				+ "\nPredictedScore: "+predictedScore);
	}
	
}

class CurrentScoreDisplay implements Observer1{
	private int runs,wickets;
	private float overs;
	
	public void update(int runs, int wickets, float overs) {
		this.runs = runs;
		this.wickets = wickets;
		this.overs = overs;
		display();
	}
	
	public void display() {
		System.out.println("\nCurrent Score Display:\n"
				+"Runs: "+runs
				+"\nWickets: "+wickets
				+"\nOvers: "+overs);
	}
	
}
