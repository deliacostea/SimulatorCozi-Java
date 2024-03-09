package BusinessLogic;

import Model.Client;
import Model.Server;

import java.util.List;

public class ShortestQueueStrategy implements Strategy {
    @Override
    public void addTask(List<Server> servers, Client t) {
        servers.sort((t1, t2) -> Integer.compare(t1.getSize(), t2.getSize()));
        servers.get(0).addClient(t);
    }
}
