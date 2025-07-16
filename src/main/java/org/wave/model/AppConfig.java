package org.wave.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="app_config")
public class AppConfig {

    @Id
    private String key;
    private String value;

    @Column(name = "description")
    private String desc;
    public AppConfig() {}
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }
}
