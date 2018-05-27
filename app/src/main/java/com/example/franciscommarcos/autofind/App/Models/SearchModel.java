package com.example.franciscommarcos.autofind.App.Models;

/**
 * Created by franc on 25/05/2018.
 */

public class SearchModel {
    private String id_product;
    private String title;
    private String description;
    private String fantasy_name;
    private String phone;
    private String cell_phone;
    private String email;
    private String latitude;
    private String longitude;
    private String city;
    private String state;
    private String distance;

    public SearchModel(String id_product, String title, String description, String fantasy_name, String phone, String cell_phone, String email, String latitude, String longitude, String city, String state, String distance) {
        this.id_product = id_product;
        this.title = title;
        this.description = description;
        this.fantasy_name = fantasy_name;
        this.phone = phone;
        this.cell_phone = cell_phone;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.distance = distance;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFantasy_name() {
        return fantasy_name;
    }

    public void setFantasy_name(String fantasy_name) {
        this.fantasy_name = fantasy_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
