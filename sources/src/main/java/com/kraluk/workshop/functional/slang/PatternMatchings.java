package com.kraluk.workshop.functional.slang;

/**
 * Pattern Matching Playground
 *
 * @author lukasz
 */
public class PatternMatchings {

    public static String someGreatIfology(int index) {

        if (index < 100) {
            return "<100";
        } else if (index > 100 && index < 200) {
            return "> 100 & < 100";
        } else {
            return "default";
        }
    }
}
