package com.shofee.behavioral;

import java.util.ArrayList;
import java.util.Iterator;

// Implemented by Cricket data to communicate
// with observers
interface Subject
{
    void registerObserver(ObserverInterface o);
    void unregisterObserver(ObserverInterface o);
    void notifyObservers();
}

class CricketData implements Subject
{
    int runs;
    int wickets;
    float overs;
    ArrayList<ObserverInterface> observerList;

    public CricketData() {
        observerList = new ArrayList<ObserverInterface>();
    }

    public void registerObserver(ObserverInterface o) {
        observerList.add(o);
    }

    public void unregisterObserver(ObserverInterface o) {
        observerList.remove(observerList.indexOf(o));
    }

    public void notifyObservers()
    {
        for (Iterator<ObserverInterface> it =
             observerList.iterator(); it.hasNext();)
        {
            ObserverInterface o = it.next();
            o.update(runs,wickets,overs);
        }
    }

    // get latest runs from stadium
    private int getLatestRuns()
    {
        // return 90 for simplicity
        return 90;
    }

    // get latest wickets from stadium
    private int getLatestWickets()
    {
        // return 2 for simplicity
        return 2;
    }

    // get latest overs from stadium
    private float getLatestOvers()
    {
        // return 90 for simplicity
        return (float)10.2;
    }

    // This method is used update displays
    // when data changes
    public void dataChanged()
    {
        //get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();

        notifyObservers();
    }
}

// This interface is implemented by all those
// classes that are to be updated whenever there
// is an update from CricketData
interface ObserverInterface
{
    public void update(int runs, int wickets,
                       float overs);
}

class AverageScoreDisplay implements ObserverInterface
{
    private float runRate;
    private int predictedScore;

    public void update(int runs, int wickets,
                       float overs)
    {
        this.runRate =(float)runs/overs;
        this.predictedScore = (int)(this.runRate * 50);
        display();
    }

    public void display()
    {
        System.out.println("\nAverage Score Display: \n"
                + "Run Rate: " + runRate +
                "\nPredictedScore: " +
                predictedScore);
    }
}

class CurrentScoreDisplay implements ObserverInterface
{
    private int runs, wickets;
    private float overs;

    public void update(int runs, int wickets,
                       float overs)
    {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }

    public void display()
    {
        System.out.println("\nCurrent Score Display:\n"
                + "Runs: " + runs +
                "\nWickets:" + wickets +
                "\nOvers: " + overs );
    }
}

// Driver Class
public class Observer {
    public static void main(String args[])
    {
        // create objects for testing
        AverageScoreDisplay averageScoreDisplay =
                new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay =
                new CurrentScoreDisplay();

        // pass the displays to Cricket data
        CricketData cricketData = new CricketData();

        // register display elements
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        // in real app you would have some logic to
        // call this function when data changes
        cricketData.dataChanged();

        //remove an observer
        cricketData.unregisterObserver(averageScoreDisplay);

        // now only currentScoreDisplay gets the
        // notification
        cricketData.dataChanged();
    }

}
