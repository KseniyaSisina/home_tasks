package com.company;

/**
 * Created by Ксения on 14.11.2016.
 */
public class Token {
    private int begin;
    private int end;
    private String text;
    private String type;

    public int getBegin() {
        return this.begin;
    }
    public int getEnd() {
        return this.end;
    }
    public String getText() {
        return this.text;
    }
    public String getType() {
        return this.type;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Token(int begin, int end, String text, String type) {
        this.setBegin(begin);
        this.setEnd(end);
        this.setText(text);
        this.setType(type);
    }
    public Token() {

    }

}
