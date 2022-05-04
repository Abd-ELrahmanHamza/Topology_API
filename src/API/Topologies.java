package API;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Topologies {
    private static HashMap<String, Topology> topologiesJSON = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("hello");
        readJSON("topology.json");
        writeJSON("top1");
        System.out.println(getTopologies());
        System.out.println(deleteTopology("hello"));
        System.out.println(topologiesJSON);
//        System.out.println(deleteTopology("top1"));
//        System.out.println(topologiesJSON);
        System.out.println(topologiesJSON.get("top1"));
    }

    private static void addToTopologies(JSONObject json) {
        topologiesJSON.put((String) json.get("id"), new Topology(json, (List<JSONObject>) json.get("components")));
        System.out.println(topologiesJSON);

    }

    public static void readJSON(String fileName) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName)) {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            System.out.println(obj);
            addToTopologies(obj);

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJSON(String topologyID) {
        //Write JSON file
        try (FileWriter file = new FileWriter(topologyID + ".json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(topologiesJSON.get(topologyID).getJson().toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<String> getTopologies() {
        return topologiesJSON.keySet();
    }

    public static boolean deleteTopology(String topologyID) {
        if (topologiesJSON.containsKey(topologyID)) {
            topologiesJSON.remove(topologyID);
            return true;
        }
        return false;
    }

    public static List<Component> queryDevices(String topologyID) {
        return topologiesJSON.get(topologyID).getComponents();
    }
}
