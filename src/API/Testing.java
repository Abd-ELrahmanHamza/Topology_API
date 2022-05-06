package API;

import java.io.File;
import java.util.List;
import java.util.Set;

public class Testing {
    private static Topologies topo = new Topologies();

    public static void main(String[] args) {
        testReadFile();
        testWriteFile();
        testGetTopologies();
        testQueryDevices();
        testQueryDevicesWithNetlistNode();
        testDeleteTopologies();
    }

    private static void testReadFile() {
        topo.readJSON("topology.json");

        if (topo.getTopologies().isEmpty()) {
            System.out.println("Testing ReadJSON Failed");
        } else {
            System.out.println("Testing ReadJSON Succeeded");
        }
    }

    private static void testWriteFile() {
        topo.writeJSON("top1");

        File file = new File("../Topology_API");
        List<String> filesNames = List.of(file.list());
        if (!filesNames.contains("top1.json")) {
            System.out.println("Testing WriteJSON Failed");
        } else {
            System.out.println("Testing WriteJSON Succeeded");
        }
    }

    private static void testGetTopologies() {
        Set<String> set = topo.getTopologies();
        if (!set.contains("top1")) {
            System.out.println("Testing getTopologies Failed");
        } else {
            System.out.println("Testing getTopologies Succeeded");
        }
    }

    private static void testDeleteTopologies() {
        topo.deleteTopology("top1");
        Set<String> set = topo.getTopologies();
        if (set.contains("top1")) {
            System.out.println("Testing deleteTopologies Failed");
        } else {
            System.out.println("Testing deleteTopologies Succeeded");
        }
    }

    private static void testQueryDevices() {
        List<Component> list = topo.queryDevices("top1");
        if (list.contains(new Component("res1","resistor"))&&list.contains(new Component("m1","nmos"))) {
            System.out.println("Testing queryDevices Succeeded");
        } else {
            System.out.println("Testing queryDevices Succeeded");
        }
    }

    private static void testQueryDevicesWithNetlistNode() {
        List<Component> list = topo.queryDevicesWithNetlistNode("top1","n1");
        if (list.contains(new Component("res1","resistor"))&&list.contains(new Component("m1","nmos"))) {
            System.out.println("Testing queryDevicesWithNetlistNode Succeeded");
        } else {
            System.out.println("Testing queryDevicesWithNetlistNode Succeeded");
        }
    }
}
