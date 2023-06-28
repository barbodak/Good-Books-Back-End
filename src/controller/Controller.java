package controller;

import database.Database;
import utils.Convertor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private String login(HashMap <String, String> data) {
        try {
            HashMap<String, HashMap<String, String>> userDataMap = Database.getInstance().getUserDataMap();
            if (!userDataMap.containsKey(data.get("username")))
                return "user not found";
            if (userDataMap.get(data.get("username")).get("password").equals(data.get("password")))
                return "done";
            else
                return "wrong password";

        }
        catch (Exception e) {
            return "";
        }

    }
    private String signup(HashMap <String, String> data) {
        try {
            HashMap<String, HashMap<String, String>> userDataMap = Database.getInstance().getUserDataMap();
            if (userDataMap.containsKey(data.get("username")))
                return "username taken";
            userDataMap.put(data.get("username"), data);
            Database.getInstance().updateUserDataMap();
            return "done";
        }
        catch (Exception e) {
            return "went to shit";
        }
    }
    private String getUser(HashMap <String, String> data) {
        try {
            HashMap<String, HashMap<String, String>> userDataMap = Database.getInstance().getUserDataMap();
//            System.out.println(data.get("username"));
            return Convertor.mapToString(userDataMap.get(data.get("username")));
        }
        catch (Exception e) {
            return "went to shit";
        }
    }
    private String updateUser(HashMap <String, String> data) {
        try {
            HashMap<String, String> userDataMap = Database.getInstance().getUserDataMap().get(data.get("username"));
            userDataMap.putAll(data);
            Database.getInstance().updateUserDataMap();
            return "done";
        }
        catch (Exception e) {
            return "went to shit";
        }
    }
    public String run(String command, String data) {
        HashMap <String, String> dataMap = Convertor.stringToMap(data);
        switch (command) {
            case "login":
                return login(dataMap);
            case "signup":
                return signup(dataMap);
            case "getUser":
                return getUser(dataMap);
            case "updateUser":
                return updateUser(dataMap);
        }
        return "error";
    }
}
