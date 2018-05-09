package com.example.franciscommarcos.autofind.Activities.Models;


public class Plate {
    String code;
    String message;
    String date;
    String hour;
    String revision;
    String server;

    public Plate(String code, String message, String date, String hour, String revision, String server) {
        this.code = code;
        this.message = message;
        this.date = date;
        this.hour = hour;
        this.revision = revision;
        this.server = server;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
