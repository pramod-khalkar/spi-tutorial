package tutorial.spi.api;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * Date: 29/01/22
 * Time: 8:45 pm
 * This file is project specific to spi-tutorial
 * Author: Pramod Khalkar
 */
public class DictionaryService {

    private static DictionaryService instance;
    private final ServiceLoader<Dictionary> loader;

    private DictionaryService() {
        loader = ServiceLoader.load(Dictionary.class);
    }

    public static synchronized DictionaryService getInstance() {
        if (instance == null) {
            instance = new DictionaryService();
        }
        return instance;
    }

    public String getDefinition(String word) {
        String definition = null;
        try {
            Iterator<Dictionary> iterator = loader.iterator();
            while (definition == null && iterator.hasNext()) {
                Dictionary dictionary = iterator.next();
                definition = dictionary.getDefinition(word);
            }
        } catch (ServiceConfigurationError e) {
            e.printStackTrace();
        }
        return definition;
    }
}
