package com.sojson.gorgeousturn.controller;

public class MyHandler extends AbstractHandler implements Handler {  
	  
    private String name;  
    int i=0;
    public MyHandler(String name) {  
        this.name = name;  
    }  
  
    @Override  
    public void operator() {  
        System.out.println(name+"deal!");  
       
        if(getHandler()!=null){ 
        	 i++;
        	System.out.println("i:"+i);
            getHandler().operator();  
        }  
    }  
}  