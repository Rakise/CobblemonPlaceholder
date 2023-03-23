package ca.skynetcloud.cobblemonplaceholder.util.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Text {

    public static String capitalize(String inputString) {

        char firstLetter = inputString.charAt(0);

        char capitalFirstLetter = Character.toUpperCase(firstLetter);

        return inputString.replace(inputString.charAt(0), capitalFirstLetter);
    }
    public static String capitalizeWord(String str){
        String words[]=str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
    }

}
