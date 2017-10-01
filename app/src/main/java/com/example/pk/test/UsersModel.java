package com.example.pk.test;

import android.content.Intent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PK on 29.09.2017.
 */

public class UsersModel implements Serializable {

    public String name;
    public String company;
    public String gender;
    public String about;
    public String address;
    public String email;
    public String eyeColor;
    public String favoriteFruit;
    public String phone;
    public String registered;
    public String balance;
    public String picture;
    public String key;
    int age;
    boolean isActive;

    public UsersModel() {
    }

    public UsersModel(String name, String company, String gender, String about, String address, String email, String eyeColor, String favoriteFruit, String phone,
                      String registered, String balance, int age, boolean isActive, String picture, String key) {
        this.name = name;
        this.company = company;
        this.gender = gender;
        this.about = about;
        this.address = address;
        this.email = email;
        this.eyeColor = eyeColor;
        this.favoriteFruit = favoriteFruit;
        this.phone = phone;
        this.registered = registered;
        this.balance = balance;
        this.age = age;
        this.isActive = isActive;
        this.picture = picture;
        this.key = key;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("gender", gender);
        result.put("company", company);
        result.put("key", key);
        result.put("about", about);
        result.put("address", address);
        result.put("email", email);
        result.put("eyeColor", eyeColor);
        result.put("favoriteFruit", favoriteFruit);
        result.put("phone", phone);
        result.put("registered", registered);
        result.put("balance", balance);
        result.put("age", age);
        result.put("isActive", isActive);
        result.put("picture", picture);

        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
