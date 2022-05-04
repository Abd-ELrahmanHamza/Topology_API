package API;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Topology {
    private JSONObject json;
    private List<Component> components = new ArrayList<>();

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
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
        for (JSONObject obj : components) {
            this.components.add(new Component((String) obj.get("id"), (String) obj.get("type")));
        }
    }


}
