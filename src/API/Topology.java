package API;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Topology {
    private final JSONObject json;

    private final List<Component> components = new ArrayList<>();

    private final HashMap<String, List<Component>> nodes = new HashMap<>();

    public HashMap<String, List<Component>> getNodes() {
        return nodes;
    }

    public JSONObject getJson() {
        return json;
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return "Topology{" +
                "json=" + json +
                ", components=" + components +
                '}';
    }

    public Topology(JSONObject json, List<JSONObject> components) {
        this.json = json;
        addToNodes(json);
        for (JSONObject obj : components) {
            this.components.add(new Component((String) obj.get("id"), (String) obj.get("type")));
        }
    }

    private  HashMap<String, List<Component>> addToNodes(JSONObject json) {
        for (JSONObject component : (List<JSONObject>) json.get("components")) {
            JSONObject netlist = (JSONObject) component.get("netlist");
            Set<String> keys = (Set<String>) netlist.keySet();

            for (String key : keys) {
                String value = (String) netlist.get((String) key);
                if (!nodes.containsKey(value)) {
                    List<Component> list = new ArrayList<>();
                    nodes.put(value, list);
                }
                nodes.get(value).add(new Component((String) component.get("id"), (String) component.get("type")));
            }
        }
        return nodes;
    }
}
