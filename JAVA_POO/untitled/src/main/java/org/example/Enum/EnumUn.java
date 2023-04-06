package org.example.Enum;

public enum EnumUn {
    A("HIGH"),
    B("MEDIUM"),
    C("LOW"),
    D("LOW");


    private String mess;

    private EnumUn(String message){
        this.mess = message;
    }

    public String getEnumUn(){
        return this.mess;
    }
}
