package com.opendata.back.opendataback.entity;

import javax.persistence.*;

@Entity
public class Data {
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String name;
    @Column(columnDefinition = "TEXT")
    private String value;

    public Data (Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Data () {

    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getValue () {
        return value;
    }

    public void setValue (String value) {
        this.value = value;
    }
}
