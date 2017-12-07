package unice.miage.xml.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

public class Center implements Serializable{
    private int id;
    private String name;
    private String longitude;
    private String latitude;

    public Center(){
        this.id = 0;
        this.name = "Lab";
        this.latitude = "0.000000";
        this.longitude = "0.000000";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
