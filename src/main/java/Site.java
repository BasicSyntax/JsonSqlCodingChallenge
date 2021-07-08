import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Site {
    private String name;
    private long alarmColor;
    private int id;
    private Map<String, String> parameters;
    private int dataSourcesCount;
    private String alertIcon;
    private int elementCount;
    private String uniqueID;

    final private List<String> paramKeys = Arrays.asList(
            "Name",
            "Peak Power",
            "Nominal Power",
            "Description",
            "Situation",
            "Panel Degradation Correction Coefficient",
            "Temperature Correction Coefficient"
    );

    public Site() {

    }

    public Site(Object docs) {
        exportJson(docs);
    }

    private void exportJson(Object json) {
        JSONObject docs = (JSONObject) json;

        if (docs.containsKey("Name")) {
            this.name = (String) docs.get("Name");
        }
        if (docs.containsKey("AlarmColor")) {
            this.alarmColor = (long) docs.get("AlarmColor");
        }
        if (docs.containsKey("Id")) {
            this.id = (int) ((long) docs.get("Id"));
        }
        if (docs.containsKey("Parameters")) {
            JSONArray jsonParameters = (JSONArray) docs.get("Parameters");
            jsonParametersToMap(jsonParameters);
        }
        if (docs.containsKey("DatasourcesCount")) {
            this.dataSourcesCount = (int) ((long) docs.get("DatasourcesCount"));
        }
        if (docs.containsKey("_alertIcon")) {
            this.alertIcon = (String) docs.get("_alertIcon");
        }
        if (docs.containsKey("ElementCount")) {
            this.elementCount = (int) ((long) docs.get("ElementCount"));
        }
        if (docs.containsKey("UniqueID")) {
            this.uniqueID = (String) docs.get("UniqueID");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAlarmColor() {
        return alarmColor;
    }

    public void setAlarmColor(long alarmColor) {
        this.alarmColor = alarmColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void jsonParametersToMap(JSONArray jsonParameters) {
        JSONObject pObj;
        this.parameters = new HashMap<>();
        for (Object p : jsonParameters) {
            pObj = (JSONObject) p;
            this.parameters.put((String) pObj.get("Key"), (String) pObj.get("Value"));
        }
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public int getDataSourcesCount() {
        return dataSourcesCount;
    }

    public void setDataSourcesCount(int dataSourcesCount) {
        this.dataSourcesCount = dataSourcesCount;
    }

    public String getAlertIcon() {
        return alertIcon;
    }

    public void setAlertIcon(String alertIcon) {
        this.alertIcon = alertIcon;
    }

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String toString() {
        return "Site{" +
                "name='" + name + '\'' +
                ", alarmColor=" + alarmColor +
                ", id=" + id +
                ", parameters=" + parameters +
                ", dataSourcesCount=" + dataSourcesCount +
                ", alertIcon='" + alertIcon + '\'' +
                ", elementCount=" + elementCount +
                ", uniqueID='" + uniqueID + '\'' +
                '}';
    }
}
