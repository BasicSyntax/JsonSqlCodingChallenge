package com.basic.syntax.json;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parameters {
    @Id
    private long id;

    private String name;
    private String peakPower;
    private String nominalPower;
    private String description;
    private String situation;
    private String panelDegradationCorrectionCoefficient;
    private String temperatureCorrectionCoefficient;

    public Parameters() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeakPower() {
        return peakPower;
    }

    public void setPeakPower(String peakPower) {
        this.peakPower = peakPower;
    }

    public String getNominalPower() {
        return nominalPower;
    }

    public void setNominalPower(String nominalPower) {
        this.nominalPower = nominalPower;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getPanelDegradationCorrectionCoefficient() {
        return panelDegradationCorrectionCoefficient;
    }

    public void setPanelDegradationCorrectionCoefficient(String panelDegradationCorrectionCoefficient) {
        this.panelDegradationCorrectionCoefficient = panelDegradationCorrectionCoefficient;
    }

    public String getTemperatureCorrectionCoefficient() {
        return temperatureCorrectionCoefficient;
    }

    public void setTemperatureCorrectionCoefficient(String temperatureCorrectionCoefficient) {
        this.temperatureCorrectionCoefficient = temperatureCorrectionCoefficient;
    }
}
