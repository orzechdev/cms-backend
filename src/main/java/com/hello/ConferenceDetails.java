package com.hello;

public class ConferenceDetails {

    private final long id;
    private final String content;
    private final String test;
    //private final String test;
    public ConferenceDetails(long id, String content) {
        this.id = id;
        this.content = content;
        this.test = "cdetailstest";
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
