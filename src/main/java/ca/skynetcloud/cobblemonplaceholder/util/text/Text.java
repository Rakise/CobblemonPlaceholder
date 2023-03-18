package ca.skynetcloud.cobblemonplaceholder.util.text;

public class Text {

    public static String capitalize(String inputString) {

        char firstLetter = inputString.charAt(0);

        char capitalFirstLetter = Character.toUpperCase(firstLetter);

        return inputString.replace(inputString.charAt(0), capitalFirstLetter);
    }

}
