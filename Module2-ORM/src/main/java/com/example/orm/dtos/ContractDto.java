package com.example.orm.dtos;

import com.example.orm.models.AttachService;

public class ContractDto {

    private long id;
    private String name;
    private int[] attachServices;

    public ContractDto() {
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

    public int[] getAttachServices() {
        return attachServices;
    }

    public void setAttachServices(int[] attachServices) {
        this.attachServices = attachServices;
    }
}
