package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook; // key is a string, values is a list of strings

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map; //phonebook map is initialized with the provided argument map
    }

    public PhoneBook() {
        this(new LinkedHashMap<>()); //nullary constructor set this object to a LinkedHashMap when no parameters are provided
    } //LinkedHashMap orders in which elements were inserted

    public void add(String name, String phoneNumber) {
        if(phonebook.containsKey(name)) { //if name (key) exists in phonebook
            phonebook.get(name).add(phoneNumber);// get the existing name and add phone number to end of list
        } else {
            phonebook.put(name, new ArrayList<>()); // if name is not in phonebook, create new phone number list
            phonebook.get(name).add(phoneNumber); // get the name and add the phone number to the array list associated with that name
            // get the name (key) and gives you the value (empty array list/nothing) and you add the phoneNumber to the list
        }

    }

    public void addAll(String name, String... phoneNumbers) {
        for(String p : phoneNumbers) {
            add(name,p); // iterating through phoneNumbers, and adding name and each phonenumbers.
        }
    }

    public void remove(String name) {
        phonebook.remove(name); //remove name(key) from phonebook(map)
    }

    public Boolean hasEntry(String name, String phoneNumber) { // checking to see if name and phone number are in phonebook together
        if(phonebook.containsKey(name) && phonebook.get(name).contains(phoneNumber)) {
            return true; //if phonebook has name(key) and that name(key) has phonenumbers in its value list, return true
        }
        return false;
    }

    public Boolean hasEntry(String name) { // check to see if name is in phonebook
        return phonebook.containsKey(name); //.containsKey returns boolean so if name(key) is in map, it will return true
    }


    public List<String> lookup(String name) {
        return phonebook.get(name); //to return the list of phone numbers, get the name from phone book and list will be returned
    }

    public String reverseLookup(String phoneNumber)  {
        String reverse = ""; //declare and initialize a new string to return the key that contains the phone number
        for(String p: phonebook.keySet()) { //.keySet create a set of keys in a map
            if(phonebook.get(p).contains(phoneNumber)) { //check if a key contains the phone number argument
                reverse = p; //set the variable to that key
            }
        }
        return reverse;// return key
    }

    public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>(phonebook.keySet()); //Converting a set of keys to a list
        return names;
    }

    public Map<String, List<String>> getMap() {
        return phonebook; //get the map which is the phonebook
    }
}
