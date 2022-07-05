package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)) {
            List<String> p = phonebook.get(name);
            p.add(phoneNumber);
            phonebook.put(name, p);
            return;
        }
        List<String> p = new ArrayList<>();
        p.add(phoneNumber);
        phonebook.put(name, p);
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String phone : phoneNumbers) {
            add(name, phone);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return "";
    }

    public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>();
        names.addAll(phonebook.keySet());
        return names;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
