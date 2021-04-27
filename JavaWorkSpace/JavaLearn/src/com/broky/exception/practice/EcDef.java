package com.broky.exception.practice;

public class EcDef extends Exception{
    static final long serialVersionUID = -338751612344229948L;

    public EcDef(){

    }

    public EcDef(String str){
        super(str);
    }

}
