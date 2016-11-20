package com.company;

/**
 * Created by Ксения on 14.11.2016.
 */
public class Count {

    public static int count(String s) {

        char text[] = s.toCharArray();
        String temp = "";
        Token token[] = new Token[s.length()];
        for (int i = 0; i < token.length; i++) {
            token[i] = new Token();
        }
        int k = 0;

        for (int i = 0; i < text.length; i++) {
            if (i < s.length() && Character.isLetter(text[i])) {
                while (i < s.length() && Character.isLetter(text[i])) {
                    temp += text[i];
                    i++;
                }
                i--;
                //System.out.println(temp);
                temp = "";
            } else if (i < s.length() && Character.isDigit(text[i])) {
                while (i < s.length() && Character.isDigit(text[i])) {
                    temp += text[i];
                    i++;
                }
                i--;
                //System.out.println(temp);
                temp = "";
            } else if (i < s.length() && Character.isSpaceChar(text[i])) {
                while (i < s.length() && Character.isSpaceChar(text[i])) {
                    temp += text[i];
                    i++;
                }
                i--;
                //System.out.println(temp);
                temp = "";
            } else if (i < s.length() && (!Character.isLetter(text[i]) & !Character.isDigit(text[i]) & !Character.isSpaceChar(text[i]))) {
                while (i < s.length() && (!Character.isLetter(text[i]) & !Character.isDigit(text[i]) & !Character.isSpaceChar(text[i]))) {
                    temp += text[i];
                    i++;
                }
                i--;
                //System.out.println(temp);
                temp = "";
            }
            k++;
        }
        //System.out.println("************************************************************");
        return k;

    }

}
