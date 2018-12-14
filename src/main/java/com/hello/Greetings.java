package com.hello;

public class Greetings {

    private final long id;
    private final String content;
    //private final String test;
    public Greetings(long id, String content) {
        this.id = id;
        this.content = content;
        //this.test = testString;
    }
    public long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
   // public String getAdditional(){ return test; }
}
