import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PigLatin {
    
    public void setup() {
        String[] lines = loadStrings("words.txt");
        System.out.println("there are " + lines.length + " lines");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(pigLatin(lines[i]));
        }
    }
    
    public void draw() {
        // not used
    }
    
    public int findFirstVowel(String sWord) {
        // precondition: sWord is a valid String of length greater than 0.
        // postcondition: returns the position of the first vowel in sWord. If there are no vowels, returns -1
        if (sWord.length() > 0) {
            for (int i = 0; i < sWord.length(); i++) {
                char c = sWord.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public String pigLatin(String sWord) {
        // precondition: sWord is a valid String of length greater than 0
        // postcondition: returns the pig latin equivalent of sWord
        if (findFirstVowel(sWord) == -1) {
            return sWord + "ay";
        } else if (findFirstVowel(sWord) == 0) {
            return sWord + "way";
        } else if (sWord.startsWith("qu")) {
            return sWord.substring(2) + "quay";
        } else {
            int firstVowelIndex = findFirstVowel(sWord);
            return sWord.substring(firstVowelIndex) + sWord.substring(0, firstVowelIndex) + "ay";
        }
    }

    // Load strings from a file (Assuming this method exists)
    public String[] loadStrings(String filename) {
        // Implement this method to load strings from a file
        return null;
    }
}
