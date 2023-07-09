package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map; //phonebook map is initialized with the provided argument map
    }

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> number = phonebook.getOrDefault(name, new ArrayList<>()); // gets value at key name, if it doesn't exist a new empty list is created
        number.add(phoneNumber); // adding phone number to the arraylist
        phonebook.put(name,number); //adding key/value name/list of phone numbers to the phonebook
    }

    public void addAll(String name, String... phoneNumbers) { // the ... is called varargs syntax. allows you to pass an arbitrary number of values of the specified type
        List<String> number = phonebook.getOrDefault(name, new ArrayList<>());
        for(String phoneNumber: phoneNumbers) { //iterate over arbitrary number of phone numbers and add to arraylist
            number.add(phoneNumber);
        }
        phonebook.put(name,number); // add name/list of phone numbers to phonebook
    }

    public void remove(String name) {
        phonebook.remove(name);
    }


    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }


    public Boolean hasEntry(String name, String phoneNumbers) {
        boolean entryExist = false;
        for(Map.Entry<String, List<String>> entry: phonebook.entrySet()) {
            if((entry.getValue().equals(phoneNumbers)) && (entry.getKey().equals(name))) {
                entryExist = true;
            }
        }
        return entryExist;
    }




    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String key = "";
        for(Map.Entry<String, List<String>> entry : phonebook.entrySet()) { //Map.Entry is the way to iterate through and obtain collection view of the map(entrySet)
            if(entry.getValue().equals(phoneNumber)) {
                key = entry.getKey();
            }
        }
        return key;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
