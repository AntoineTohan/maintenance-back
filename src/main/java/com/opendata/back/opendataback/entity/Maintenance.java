package com.opendata.back.opendataback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Maintenance {
    @Id
    private Long id;
    @Column
    private Boolean status;

    public Maintenance (Long id, Boolean status) {
        this.id = id;
        this.status = status;
    }

    public Maintenance () {

    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Boolean getStatus () {
        return status;
    }

    public void setStatus (Boolean status) {
        this.status = status;
    }
}
