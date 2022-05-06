package API;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

    private static Topologies topo = new Topologies();

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);

            System.out.println("1) Read a JSON file: ");
            System.out.println("2) Write a JSON file: ");
            System.out.println("3) Query Topologies: ");
            System.out.println("4) Delete Topology: ");
            System.out.println("5) Query Devices: ");
            System.out.println("6) Query Devices With Netlist Node: ");
            System.out.println("7) To exit ");
            int choice = 0;
            try {
                choice = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            switch (choice) {
                case 1 -> readJSONChoice();
                case 2 -> writeJSONChoice();
                case 3 -> QueryTopologiesChoice();
                case 4 -> DeleteTopologyChoice();
                case 5 -> QueryDevicesChoice();
                case 6 -> QueryDevicesWithNetlistNodeChoice();
                case 7 -> {
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }

    private static void readJSONChoice() {
        System.out.printf("File Name: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.next();
        topo.readJSON(fileName);
    }

    private static void writeJSONChoice() {
        System.out.printf("Topology Name: ");
        Scanner in = new Scanner(System.in);
        String topologyName = in.next();
        System.out.println();
        topo.writeJSON(topologyName);
    }

    private static void QueryTopologiesChoice() {
        System.out.println("Existing topologies are :");
        System.out.println(topo.getTopologies());
    }

    private static void DeleteTopologyChoice() {
        System.out.printf("Topology Name: ");
        Scanner in = new Scanner(System.in);
        String topologyName = in.next();
        System.out.println();
        topo.deleteTopology(topologyName);
    }

    private static void QueryDevicesChoice() {
        System.out.printf("Topology Name: ");
        Scanner in = new Scanner(System.in);
        String topologyName = in.next();
        System.out.println();
        System.out.println(topo.queryDevices(topologyName));
    }

    private static void QueryDevicesWithNetlistNodeChoice() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Topology Name: ");
        String topologyName = in.next();
        System.out.printf("Node Name: ");
        String deviceName = in.next();
        System.out.println();
        System.out.println(topo.queryDevicesWithNetlistNode(topologyName, deviceName));
    }
}
