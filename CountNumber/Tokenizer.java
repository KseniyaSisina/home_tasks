/**
 * Created by Ксения on 21.11.2016.
 */
public class Tokenizer {
    //собственно, вот эта функция хорошо делит строку на слова, указывает их начальную и конечную позицию в строке,
//содержание (т.е. текст) и тип
    public static LinkedList tokenize(String s) {

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
                int a = Integer.parseInt(newToken.getText());
                System.out.println(a * a);
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
