package Model;

public class Client extends Thread {
    private final Integer arrivalTime;
    private int id;
    private Integer serviceTime;
    public Client(Integer a, int id, Integer s)
    {
        this.arrivalTime=a;
        this.id=id;
        this.serviceTime=s;

    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Integer getArrivalTime() {
        return arrivalTime;
    }

    public int getId2() {
        return id;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }
    public String toString()
    {
        String s="";
        s="("+id+","+arrivalTime+","+serviceTime+" )";
        return s;

    }
}
