package database;

import utils.Convertor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Table {
    private String path;

    public Table(String path) {
        this.path = path;
    }
    public void insert(HashMap <String, String> row) {
        try {
            FileWriter fw = new FileWriter(path, true);
            System.out.println(Convertor.mapToString(row));
            fw.write(Convertor.mapToString(row) + '\n');
            fw.close();
        }
        catch (Exception e) {
            System.out.println("writing file failed");
        }
    }
    public ArrayList<HashMap <String, String>> get() {
        try {
            File f = new File(path);
            Scanner scn = new Scanner(f);
            ArrayList<HashMap <String, String>> res = new ArrayList<>();
            while (scn.hasNextLine())
                res.add(Convertor.stringToMap(scn.nextLine()));
            scn.close();
            return res;
        }
        catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
