package BusinessLogic;

import Model.Client;
import Model.Server;

import java.util.List;

public interface Strategy {
    public void addTask(List<Server> servers, Client t);

}
