package database;

import java.util.HashMap;

public class Database {
    private static Database instance = null;
    private HashMap <String, Table> tables;
    private Database(){
        tables = new HashMap<>();
        tables.put("userdata", new Table("src/data/userdata.txt"));
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
