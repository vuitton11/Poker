/**
 * Created by veton on 11/12/2017.
 */
public class PigLatin {

    public static void main(String[] args) {

        String input;
        input = IO.readString();
        System.out.println(translate(input));
    }


    public static String translate(String original) {

        original = original.toLowerCase(); // Sets all the letters to lowercase -> easier to work with

        //Set variables
        String vowel = "ai";
        String consonant = "vai";

        //Empty Strings
        String output = "";
        String firstChar= "";

        //Checks to see if the string contains a vowel
        if ((original.charAt(0) == 'a') ||
                (original.charAt(0) == 'e') ||
                (original.charAt(0) == 'i') ||
                (original.charAt(0) == 'o') ||
                (original.charAt(0) == 'u')) {

            //Adds the avi to the end of the original string
            output = original + consonant;

            return output;

        } else {
            firstChar = original.substring(0,1);

            original = original.substring(1);

            output = original + firstChar + vowel;
            return output;
        }
    }
}