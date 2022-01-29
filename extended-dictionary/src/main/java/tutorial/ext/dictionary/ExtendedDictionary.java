package tutorial.ext.dictionary;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import tutorial.spi.api.Dictionary;

/**
 * Date: 29/01/22
 * Time: 8:31 pm
 * This file is project specific to spi-tutorial
 * Author: Pramod Khalkar
 */
public class ExtendedDictionary implements Dictionary {

    private static final Map<String, String> dictionaryMap = new TreeMap<>();

    static {
        dictionaryMap.put("good", "[ExtendedDictionary] to be desired or approved of");
        dictionaryMap.put("book",
                "[ExtendedDictionary] a written or printed work consisting of pages glued or sewn together along one side and bound in covers.");
    }

    @Override
    public String getDefinition(String s) {
        if (s != null) {
            return dictionaryMap.get(s.toLowerCase(Locale.ROOT));
        }
        return null;
    }
}
