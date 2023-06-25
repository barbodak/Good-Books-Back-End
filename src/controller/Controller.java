package controller;

import database.Database;
import utils.Convertor;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private String login(HashMap <String, String> data) {
        try {
            ArrayList<HashMap <String, String>> userdata = Database.getInstance().getTable("userdata").get();
            for (var user : userdata)
                if (user.get("username").equals(data.get("username"))) {
                    if (user.get("password").equals(data.get("password")))
                        return "login done";
                    else
                        return "wrong password";
                }
            return "user not found";
        }
        catch (Exception e) {
            return "";
        }

    }
    private String signup(HashMap <String, String> data) {
        try {
            Database.getInstance().getTable("userdata").insert(data);
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
        }
        return "error";
    }
}
