package Model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
public class Server implements Runnable{
    private BlockingQueue<Client> clients;
    private AtomicInteger waitingPeriod;
    private Integer id;
    public Server(Integer id)
    {
        this.id=id;
        clients=new LinkedBlockingQueue<Client>();
        waitingPeriod=new AtomicInteger(0);

    }
    private synchronized void decrement()
    {
        waitingPeriod.decrementAndGet();
    }
    public int getSize()
    {
        return clients.size();
    }
    public void addClient(Client newClient)
    {

        clients.add(newClient);
        waitingPeriod.addAndGet(newClient.getServiceTime());

    }
    public void run()
    {
        while(true)
        {

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try
            {
                if(clients.size()>0) {
                    clients.element().setServiceTime(clients.element().getServiceTime() - 1);
                    decrement();
                    if(clients.element().getServiceTime()==0)
                        clients.take();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public BlockingQueue<Client> getClients() {
        return clients;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public Integer getId() {
        return id;
    }


}
