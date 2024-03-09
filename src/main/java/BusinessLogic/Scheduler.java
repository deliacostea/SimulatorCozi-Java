package BusinessLogic;

import Model.Client;
import Model.Server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxTasksPerServer,int maxNoServers,SelectionPolicy sel)
    {


        this.maxNoServers=maxNoServers;
        this.maxTasksPerServer=maxTasksPerServer;

        servers= Collections.synchronizedList(new ArrayList<Server>());

        for(int i=0;i<maxNoServers;i++)
        {
            Server s1=new Server(i+1);
            servers.add(s1);
            Thread thread=new Thread(servers.get(i));
            thread.start();
        }
        changeStrategy(sel);
    }
    public void changeStrategy(SelectionPolicy policy)
    {

        if(policy == SelectionPolicy.SHORTEST_QUEUE)
        {
            strategy=new ShortestQueueStrategy();
        }
        if(policy==SelectionPolicy.SHORTEST_TIME)
        {
            strategy=new ConcreteStrategyTime();
        }
    }
    public void dispatchTask(Client t)
    {

        strategy.addTask(servers,t);
    }
    public List<Server>getServers()
    {
        return servers;
    }
}
