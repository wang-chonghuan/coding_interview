package org.C_Hashing;

import java.util.HashSet;

/*
check if the sentence is pangram
solution
a pangram is a sentence where every letter of the english alphabet appears at least once
given a string sentence containing only lowercase english letters,
return true if sentence is a pangram or false otherwise
 */
public class CheckExistP1N1832 {
    public boolean checkPangram(String sentence) {
        var charSet = new HashSet<Character>();
        for(int i = 0; i < sentence.length(); i++) {
            charSet.add(sentence.charAt(i));
        }
        return charSet.size() == 26;
    }
}
