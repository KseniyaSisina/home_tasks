/**
 * Created by Ксения on 21.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        String s = "Hi, 123! Bye 52";
        LinkedList result = new LinkedList();
        result = Tokenizer.tokenize(s);
        //result.print();
    }

}
