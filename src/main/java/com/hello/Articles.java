package com.hello;

public class Articles {

    private final long id;
    private final String content;
    private final String test;
    //private final String test;
    public Articles(long id, String content) {
        this.id = id;
        this.content = content;
        this.test = "test";
        //this.test = testString;
    }
    public long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    
    public String getTest() {
        return test;
    }
   // public String getAdditional(){ return test; }
}
