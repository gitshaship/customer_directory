package com.example.piexchange.dto;

public class CustomerDTO {

    private String name;
    private String contactNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public CustomerDTO(String name, String contactNo) {
        this.name = name;
        this.contactNo = contactNo;
    }
}
