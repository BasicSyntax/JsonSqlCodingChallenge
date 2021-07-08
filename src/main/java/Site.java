import java.util.Arrays;
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

    final private List<String> paramKeys = Arrays.asList("Name",
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

    private void exportJson(Object docs) {

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
