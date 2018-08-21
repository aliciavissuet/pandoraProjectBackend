package hello.mock.repository;

import hello.models.Host;

import java.util.ArrayList;

public class Hosts {
    private ArrayList<Host> hosts;

    public Hosts() {
        this.hosts=new ArrayList<>();
    }

    public String addHost(Host host){
        hosts.add(host);
        return "host added successfully";
    }

    public ArrayList<Host> getHosts() {
        return hosts;
    }

}
