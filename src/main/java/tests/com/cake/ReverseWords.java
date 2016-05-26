package tests.com.cake;

import java.util.Arrays;

/**
 * Created by ishishov on 5/15/16.
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "werty dsfg dfasdfsadfasdf";

        System.out.println(s);
        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String message) {

        char[] messageChars = message.toCharArray();

        // first we reverse all the characters in the entire messageChars array
        reverseCharacters(messageChars, 0, messageChars.length - 1);
        // this gives us the right word order
        // but with each word backwards

        // now we'll make the words forward again
        // by reversing each word's characters

        // we hold the index of the /start/ of the current word
        // as we look for the /end/ of the current word
        int currentWordStartIndex = 0;
        for (int i = 0; i <= messageChars.length; i++) {

            // found the end of the current word!
            if (i == messageChars.length || messageChars[i] == ' ') {

                // if we haven't exhausted the string our
                // next word's start is one character ahead
                reverseCharacters(messageChars, currentWordStartIndex, i - 1);
                currentWordStartIndex = i + 1;
            }
        }

        return new String(messageChars);
    }

    public static void reverseCharacters(char[] messageChars, int startIndex, int endIndex) {

        // walk towards the middle, from both sides
        while (startIndex < endIndex) {

            // swap the front char and back char
            char temp = messageChars[startIndex];
            messageChars[startIndex] = messageChars[endIndex];
            messageChars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
