package BusinessLogic;

import GUI.GUI;
import Model.Client;
import Model.Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SimulationManager implements Runnable{

    public static int timeLimit=60;
    public static int currentTime;
    public static int maxProcessingTime=4;
    public static int minProcessingTime=2;
    public static int numberOfServers=2;
    public static int numberOfClients=4;
    public SelectionPolicy selectionPolicy=SelectionPolicy.SHORTEST_TIME;
    private Scheduler scheduler;

    private List<Client> generatedTasks;
    public static int minArrivalTime=2;
    public static int maxArrivalTime=30;
    public String text;


    public SimulationManager()
    {

        currentTime=0;
        text="";
        generatedTasks= Collections.synchronizedList(new ArrayList<Client>());
        scheduler=new Scheduler(numberOfClients,numberOfServers,selectionPolicy);
        generateNRandomTasks();

    }



private void generateNRandomTasks()
{
    Random r=new Random();
    int processingTime;
    int arrivalTime;

    for(int i=0;i<numberOfClients;i++)
    {
        processingTime=r.nextInt(maxProcessingTime-minProcessingTime)+minProcessingTime;
        arrivalTime=r.nextInt(maxArrivalTime-minArrivalTime)+minArrivalTime;
        Client c=new Client(arrivalTime,i+1,processingTime);
        generatedTasks.add(c);
    }
    generatedTasks.sort((t1, t2) -> Integer.compare(t1.getArrivalTime(), t2.getArrivalTime()));

}
private void setText()
{
    System.out.println(currentTime);
    text+=("Time: "+currentTime +"\n");
    text+=("Waiting clients: ");
    for(Client a:generatedTasks)
    {
        text+=a.toString();
    }
    text+="\n";
    for(Server b:scheduler.getServers())
    {
        text+=("Queue: "+ b.getId() +":");
        if(b.getSize()==0)
            text+="Closed";
        else
            for(Client c:b.getClients())
            {
                text+=c.toString();
            }
            text+="\n";
    }
    text+="\n";
}
public void run()
{

    while(currentTime<timeLimit)
    {

        boolean k=true;
        while(k)
        {
            if(generatedTasks.size()>0)
            {
                Client c=generatedTasks.get(0);
                if(c.getArrivalTime()==currentTime)
                {
                    scheduler.dispatchTask(c);
                    generatedTasks.remove(c);
                }
                else
                {
                    if(c.getArrivalTime()>currentTime)
                        k=false;
                }
            }
            if(generatedTasks.size()==0)
                k=false;

        }

        setText();
        currentTime++;
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try
        {
            FileWriter fis =new FileWriter("Fisier.txt");
            fis.write(text);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
    public static void main(String[] args) {
        GUI g=new GUI();
        g.getButon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    timeLimit= Integer.parseInt(g.getTimeLimit().getText());
                    minArrivalTime=Integer.parseInt(g.getMinAr().getText());
                    maxArrivalTime=Integer.parseInt(g.getMaxAr().getText());
                    minProcessingTime=Integer.parseInt(g.getMinProc().getText());
                    maxProcessingTime=Integer.parseInt(g.getMaxProc().getText());
                    numberOfClients=Integer.parseInt(g.getNrCl().getText());
                    numberOfServers=Integer.parseInt(g.getNrSer().getText());
                    g.getButon().removeActionListener(this::actionPerformed);
                    SimulationManager sim = new SimulationManager();
                    Thread t = new Thread(sim);
                    t.start();
                } catch (NumberFormatException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

    }
}


