package API;

import org.json.simple.JSONObject;

public class Component {
    private String id;
    private String type;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Component(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
