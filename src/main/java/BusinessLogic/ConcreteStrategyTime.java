package BusinessLogic;

import Model.Client;
import Model.Server;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {

    @Override
    public void addTask(List<Server> servers, Client t)
    {
        int idServer = servers.get(0).getId();
        int totalTime = servers.get(0).getWaitingPeriod().get();
        for (Server a : servers) {
            if (totalTime > a.getWaitingPeriod().get()) {
                totalTime = a.getWaitingPeriod().get();
                idServer = a.getId();
            }
        }
        servers.get(idServer - 1).addClient(t);



    }
}
