package API;

public class MainClass {
    public static void main(String[] args) {
        Topologies topo = new Topologies();
        topo.readJSON("topology.json");
        topo.readJSON("topology2.json");
        System.out.println(topo.getTopologies());
        System.out.println((topo.deleteTopology("top1")?"Deleted successfully":"Deleted unsuccessfully"));
        topo.writeJSON("top2");
        System.out.println(topo.getTopologies());
        topo.readJSON("topology.json");
        System.out.println(topo.queryDevices("top1"));
        System.out.println(topo.queryDevicesWithNetlistNode("top2","n1"));
    }
}
