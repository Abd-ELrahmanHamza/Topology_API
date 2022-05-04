package API;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Topologies {
    private final HashMap<String, Topology> topologiesJSON = new HashMap<>();

    private void addToTopologies(JSONObject json) {
        topologiesJSON.put((String) json.get("id"), new Topology(json, (List<JSONObject>) json.get("components")));
    }


    public void readJSON(String fileName) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName)) {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            addToTopologies(obj);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeJSON(String topologyID) {
        //Write JSON file
        try (FileWriter file = new FileWriter(topologyID + ".json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(topologiesJSON.get(topologyID).getJson().toJSONString());
            file.flush();

        } catch (IOException e) {
            System.out.println("Error in IO");
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Key not found");
            e.printStackTrace();
        }
    }

    public Set<String> getTopologies() {
        return topologiesJSON.keySet();
    }

    public boolean deleteTopology(String topologyID) {
        if (topologiesJSON.containsKey(topologyID)) {
            topologiesJSON.remove(topologyID);
            return true;
        }
        return false;
    }

    public List<Component> queryDevices(String topologyID) {
        return topologiesJSON.get(topologyID).getComponents();
    }

    public List<Component> queryDevicesWithNetlistNode(String topologyID, String node) {
        System.out.println(topologiesJSON.get(topologyID).getNodes());
        return topologiesJSON.get(topologyID).getNodes().get(node);
    }
}
