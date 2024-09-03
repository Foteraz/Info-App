package com.example.wmp_finalproject;

public class Participants {
    private String name;
    private String batch;
    private String email;
    private String phone;
    private String selectedEvent;

    public Participants(String name, String batch, String email, String phone, String selectedEvent) {
        this.name = name;
        this.batch = batch;
        this.email = email;
        this.phone = phone;
        this.selectedEvent = selectedEvent;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getBatch() {
        return batch;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSelectedEvent() {
        return selectedEvent;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSelectedEvent(String selectedEvent) {
        this.selectedEvent = selectedEvent;
    }
}
