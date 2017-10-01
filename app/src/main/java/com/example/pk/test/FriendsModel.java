package com.example.pk.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PK on 30.09.2017.
 */

public class FriendsModel {
    public FriendsModel() {
    }
    public String name;
    public String key;
    public int id;

    public FriendsModel(String name, int id, String key) {
        this.name = name;
        this.id = id;
        this.key = key;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("id", id);
        result.put("key", key);

        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}