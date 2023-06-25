package utils;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

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
}
