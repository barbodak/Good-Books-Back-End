package database;

import utils.Convertor;

import java.util.HashMap;

public class Database {
    private static Database instance = null;
    private HashMap <String, Table> tables;
    private HashMap <String, HashMap <String, String>> userDataMap;

    public HashMap<String, HashMap<String, String>> getUserDataMap() {
        return userDataMap;
    }
    public void updateUserDataMap() {
        tables.get("userdata").insert(Convertor.mapOfUsersToString(userDataMap), false);
    }

    private Database(){
        tables = new HashMap<>();
        tables.put("userdata", new Table("src/data/userdata.txt"));
        userDataMap = Convertor.userArrayToMap(tables.get("userdata").get());
    }
    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }
    public Table getTable(String name) {
        return tables.get(name);
    }
}
