package tutorial.spi.consumer;

import tutorial.spi.api.DictionaryService;

/**
 * Date: 29/01/22
 * Time: 8:56 pm
 * This file is project specific to spi-tutorial
 * Author: Pramod Khalkar
 */
public class DictionarySpiDemo {

    public static void main(String[] args) {
        String definition = DictionaryService.getInstance().getDefinition("good");
        System.out.println(definition);
    }
}
