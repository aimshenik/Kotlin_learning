package selfeducation.leetcode.javasolutions;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://leetcode.com/problems/longest-palindromic-substring/
public class App05 {


    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("eabcb"));
//        System.out.println(longestPalindrome("lbabbabl"));
//        System.out.println(longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int firstIndex = 0;
        int lastIndex = 0;
        String result = s.substring(firstIndex, lastIndex + 1);
        char[] chars = s.toCharArray();
        boolean insideSimmetry = false;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (chars[i] == chars[j] && !insideSimmetry) {
                    firstIndex = i;
                    lastIndex = j;
                    insideSimmetry = true;
                    int delta = 0;
                    while (true) {
                        boolean same = chars[firstIndex + delta] == chars[lastIndex - delta];
                        if (firstIndex + delta == lastIndex - delta) {
                            break;
                        }
                        if (firstIndex + delta + 1 == lastIndex - delta) {
                            if (same) {
                                break;
                            } else {
                                insideSimmetry = false;
                                break;
                            }
                        }
                        if (!same) {
                            insideSimmetry = false;
                            break;
                        }
                        delta++;
                    }
                    if (insideSimmetry) {
                        result = s.substring(firstIndex, lastIndex + 1).length() > result.length() ? s.substring(firstIndex, lastIndex + 1) : result;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static String longestPalindrome2(String s) {
        if (s.length() == 1) return s;
        byte maximumNotMatchedInARow = 2;
        byte notMatchedInARow = 0;
        short rightLettersCount = 2;
        String result = "";
        StringBuilder regexLeftPart = new StringBuilder("(\\w)");
        StringBuilder regexRightPart = new StringBuilder();
        StringBuilder regex;
        Pattern pattern;
        Matcher matcher;
        String nextAppendix = "\\1";
        while (true) {
            regex = new StringBuilder(regexLeftPart.toString() + regexRightPart);
            pattern = Pattern.compile(regex.toString());
            matcher = pattern.matcher(s);
            if (matcher.find()) {
                result = matcher.group(0);
                if (nextAppendix.startsWith("(")) {
                    regexLeftPart.append(nextAppendix);
                    nextAppendix = "\\" + rightLettersCount++;
                } else {
                    regexRightPart = new StringBuilder(nextAppendix).append(regexRightPart);
                    nextAppendix = "(\\w)";
                }
                notMatchedInARow = 0;
            } else {
                notMatchedInARow++;
                if (notMatchedInARow == maximumNotMatchedInARow) {
                    break;
                }
                if (nextAppendix.startsWith("(")) {
                    regexLeftPart.append(nextAppendix);
                    nextAppendix = "\\" + rightLettersCount++;
                } else {
                    regexRightPart = new StringBuilder(nextAppendix).append(regexRightPart);
                    nextAppendix = "(\\w)";
                }
            }
        }
        return result;
    }
}

