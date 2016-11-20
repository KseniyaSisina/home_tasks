package com.company;

/**
 * Created by Ксения on 14.11.2016.
 */
public class Tokenizer {
//эта функция работает некорректно, всем элементам массива присваивает значение последнего слова строки
//я с ней долго мучилась, переделать не получилось, поэтому написала другую, возвращающую не массив, а связный список
    public static Token[] tokenize(String s) {

        char text[] = s.toCharArray();
        String temp = "";
        Token token[] = new Token[Count.count(s)];
        for (int i = 0; i < token.length; i++) {
            token[i] = new Token();
        }

        for (int j = 0; j < token.length; j++) {
            for (int i = 0; i < text.length; i++) {
                if (i < s.length() && Character.isLetter(text[i])) {
                    token[j].setBegin(i);
                    while (i < s.length() && Character.isLetter(text[i])) {
                        temp += text[i];
                        i++;
                    }
                    i--;
                    token[j].setType("Word");
                    token[j].setText(temp);
                    token[j].setEnd(i);
                    temp = "";
                } else if (i < s.length() && Character.isDigit(text[i])) {
                    token[j].setBegin(i);
                    while (i < s.length() && Character.isDigit(text[i])) {
                        temp += text[i];
                        i++;
                    }
                    i--;
                    token[j].setType("Number");
                    token[j].setText(temp);
                    token[j].setEnd(i);
                    temp = "";
                } else if (i < s.length() && Character.isSpaceChar(text[i])) {
                    token[j].setBegin(i);
                    while (i < s.length() && Character.isSpaceChar(text[i])) {
                        temp += text[i];
                        i++;
                    }
                    i--;
                    token[j].setType("Space");
                    token[j].setText(temp);
                    token[j].setEnd(i);
                    temp = "";
                } else if (i < s.length() && (!Character.isLetter(text[i]) & !Character.isDigit(text[i]) & !Character.isSpaceChar(text[i]))) {
                    token[j].setBegin(i);
                    while (i < s.length() && (!Character.isLetter(text[i]) & !Character.isDigit(text[i]) & !Character.isSpaceChar(text[i]))) {
                        temp += text[i];
                        i++;
                    }
                    i--;
                    token[j].setType("Punctuation mark");
                    token[j].setText(temp);
                    token[j].setEnd(i);
                    temp = "";
                }
            }
        }
        return token;
    }
//собственно, вот эта функция хорошо делит строку на слова, указывает их начальную и конечную позицию в строке,
//содержание (т.е. текст) и тип
    public static LinkedList tokenize1(String s) {

        char text[] = s.toCharArray();
        String temp = "";
        LinkedList token = new LinkedList();

        for (int i = 0; i < text.length; i++) {
            Token newToken = new Token();
                if (i < s.length() && Character.isLetter(text[i])) {
                    newToken.setBegin(i);
                    while (i < s.length() && Character.isLetter(text[i])) {
                        temp += text[i];
                        i++;
                    }
                    i--;
                    newToken.setType("Word");
                    newToken.setText(temp);
                    newToken.setEnd(i);
                    token.add(newToken);
                    temp = "";
                } else if (i < s.length() && Character.isDigit(text[i])) {
                    newToken.setBegin(i);
                    while (i < s.length() && Character.isDigit(text[i])) {
                        temp += text[i];
                        i++;
                    }
                    i--;
                    newToken.setType("Number");
                    newToken.setText(temp);
                    newToken.setEnd(i);
                    token.add(newToken);
                    temp = "";
                } else if (i < s.length() && Character.isSpaceChar(text[i])) {
                    newToken.setBegin(i);
                    while (i < s.length() && Character.isSpaceChar(text[i])) {
                        temp += text[i];
                        i++;
                    }
                    i--;
                    newToken.setType("Space");
                    newToken.setText(temp);
                    newToken.setEnd(i);
                    token.add(newToken);
                    temp = "";
                } else if (i < s.length() && (!Character.isLetter(text[i]) & !Character.isDigit(text[i]) & !Character.isSpaceChar(text[i]))) {
                    newToken.setBegin(i);
                    while (i < s.length() && (!Character.isLetter(text[i]) & !Character.isDigit(text[i]) & !Character.isSpaceChar(text[i]))) {
                        temp += text[i];
                        i++;
                    }
                    i--;
                    newToken.setType("Punctuation mark");
                    newToken.setText(temp);
                    newToken.setEnd(i);
                    token.add(newToken);
                    temp = "";
                }
            }
        return token;
    }
}




