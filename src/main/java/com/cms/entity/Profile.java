package com.cms;

public class Profile {

    private final long id;
    private final String content;
    private final String test;
    //private final String test;
    public Profile(long id, String content) {
        this.id = id;
        this.content = content;
        this.test = "profiletest";
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
