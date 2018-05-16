package com.example.franciscommarcos.autofind.App.Models;

/**
 * Created by francisco.mmarcos on 15/05/2018.
 */

public class RequestPlate {
    private String success;
    private Data data;

    public RequestPlate(String success, Data data) {
        this.success = success;
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
