package utils;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Convertor {
    public static HashMap <String, String > stringToMap (String s) {
        String [] exprs = s.split(",,");
        HashMap <String, String> res = new HashMap<>();
        for (var expr : exprs) {
            int colon = expr.indexOf(':');
            String key = expr.substring(0, colon);
            String value = expr.substring(colon + 1);
            res.put(key, value);
        }
        return res;
    }
    public static ArrayList<String> stringToArray (String s) {
        String [] exprs = s.split("##");
        ArrayList <String> res = new ArrayList<>();
        res.addAll(Arrays.asList(exprs));
        return res;
    }
    public static String mapToString(HashMap <String, String> m) {
        try {

            StringBuilder res = new StringBuilder();
            for (Map.Entry<String, String> entry : m.entrySet()) {
                res.append(String.format("%s:%s,,", entry.getKey(), entry.getValue()));
            }
            res.deleteCharAt(res.length() - 1);
            res.deleteCharAt(res.length() - 1);
            return res.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public static String bookMapToString(HashMap <String, String> m) {
        try {
            StringBuilder res = new StringBuilder();
            for (Map.Entry<String, String> entry : m.entrySet()) {
                    res.append(String.format("%s:%s,,", entry.getKey(), entry.getValue()));
            }
            res.deleteCharAt(res.length() - 1);
            res.deleteCharAt(res.length() - 1);
            return res.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public static HashMap <String, HashMap <String, String>> userArrayToMap(ArrayList<HashMap <String, String>> list) {
        HashMap <String, HashMap <String, String>> res = new HashMap<>();
        for (var i : list)
            res.put(i.get("username"), i);
        return res;
    }
    public static HashMap <String, HashMap <String, String>> bookArrayToMap(ArrayList<HashMap <String, String>> list) {
        HashMap <String, HashMap <String, String>> res = new HashMap<>();
        for (var i : list)
            res.put(i.get("id"), i);
        return res;
    }
    public static String mapOfUsersToString(HashMap <String, HashMap <String, String>> m) {
        try {
            StringBuilder res = new StringBuilder();
            for (Map.Entry<String, HashMap <String, String>> entry : m.entrySet()) {
                for (Map.Entry<String, String> entry1 : entry.getValue().entrySet())
                   res.append(String.format("%s:%s,,", entry1.getKey(), entry1.getValue()));
                res.deleteCharAt(res.length() - 1);
                res.deleteCharAt(res.length() - 1);
                res.append('\n');
            }
            return res.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public static String mapOfBooksToString(HashMap <String, HashMap <String, String>> m) {
        try {
            StringBuilder res = new StringBuilder();
            for (Map.Entry<String, HashMap <String, String>> entry : m.entrySet()) {
                for (Map.Entry<String, String> entry1 : entry.getValue().entrySet())
                    res.append(String.format("%s:%s,,", entry1.getKey(), entry1.getValue()));
                res.deleteCharAt(res.length() - 1);
                res.deleteCharAt(res.length() - 1);
                res.append('\n');
            }
            return res.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
