package com.company;

public class Main {

    public static void main(String[] args) {
        String s = "Hi, 123! Bye 52";

        /*Token[] result = new Token[s.length()];
        result = Tokenizer.tokenize(s);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getBegin());
            System.out.println(result[i].getEnd());
            System.out.println(result[i].getText());
            System.out.println(result[i].getType());
            System.out.println();
        }
        System.out.println("*******************************************************************************");*/

        LinkedList result1 = new LinkedList();
        result1 = Tokenizer.tokenize1(s);
        result1.print();
    }
}
