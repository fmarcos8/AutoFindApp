package com.example.franciscommarcos.autofind.App.Models;

/**
 * Created by francisco.mmarcos on 15/05/2018.
 */

public class RequestPlate {
    private String success;
    private CarModel data;

    public RequestPlate(String success, CarModel data) {
        this.success = success;
        this.data = data;
    }

    public CarModel getData() {
        return data;
    }

    public void setData(CarModel data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
