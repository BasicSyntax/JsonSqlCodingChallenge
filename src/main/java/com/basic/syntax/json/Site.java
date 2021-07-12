package com.basic.syntax.json;

import org.hibernate.annotations.GenericGenerator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Site {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    private String name;
    private long alarmColor;

    @Column(columnDefinition = "TEXT")
    private HashMap parameters;
    private int dataSourcesCount;
    private String alertIcon;
    private int elementCount;
    private String uniqueID;

    public Site() {

    }
    public Site(Object docs) {
        exportJson(docs);
    }
    public Site(Site site) {
        this.name = site.getName();
        this.id = site.getId();
        this.alarmColor = site.getAlarmColor();
        this.parameters = site.getParameters();
        this.dataSourcesCount = site.getDataSourcesCount();
        this.alertIcon = site.getAlertIcon();
        this.elementCount = site.getElementCount();
        this.uniqueID = site.getUniqueID();
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
            this.id = (long) docs.get("Id");
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
    private void jsonParametersToMap(JSONArray jsonParameters) {
        JSONObject pObj;
        this.parameters = new HashMap<>();
        for (Object p : jsonParameters) {
            pObj = (JSONObject) p;
            this.parameters.put( pObj.get("Key"), pObj.get("Value"));
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
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public HashMap getParameters() {
        return parameters;
    }
    public void setParameters(HashMap parameters) {
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
        return "com.basic.syntax.json.Site{" +
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
