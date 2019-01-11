package com.cms.entity;

public class Greeting {

    private final long id;
    private final String content;
    //private final String test;
    public Greeting(long id, String content) {
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
