package com.example.franciscommarcos.autofind.App.Models;

import java.util.ArrayList;

/**
 * Created by francisco.mmarcos on 15/05/2018.
 */

public class RequestSearch {

    private String success;
    private ArrayList<SearchModel> data;

    public RequestSearch(String success, ArrayList<SearchModel> data) {
        this.success = success;
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ArrayList<SearchModel> getData() {
        return data;
    }

    public void setData(ArrayList<SearchModel> data) {
        this.data = data;
    }
}
