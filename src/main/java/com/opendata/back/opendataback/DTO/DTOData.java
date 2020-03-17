package com.opendata.back.opendataback.DTO;

public class DTOData {

    private Long DTOid;
    private String DTOname;
    private String DTOvalue;

    public DTOData (Long id, String name, String value) {
        this.DTOid = id;
        this.DTOname = name;
        this.DTOvalue = value;
    }

    public Long getDTOId () {
        return DTOid;
    }

    public void setDTOId (Long id) {
        this.DTOid = id;
    }

    public String getDTOName () {
        return DTOname;
    }

    public void setDTOName (String name) {
        this.DTOname = name;
    }

    public String getDTOValue () {
        return DTOvalue;
    }

    public void setDTOValue (String value) {
        this.DTOvalue = value;
    }
}
