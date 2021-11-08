package com.ps.model;

public class CountryInfo {
    private String code;
    private String name;
    private String flag;
    private String capitalCity;

    public String getCode() {return code;}
    public String getName() {return name;}
    public String getFlag() {return flag;}
    public String getCapitalCity() {return capitalCity;}

    public void setCode(String code) {this.code = code;}
    public void setName(String name) {this.name = name;}
    public void setFlag(String flag) {this.flag = flag;}
    public void setCapitalCity(String capitalCity) {this.capitalCity = capitalCity;}

    @Override
    public String toString() {
        return "CountryInfo{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + flag + '\'' +
                ", capitalCity='" + capitalCity + '\'' +
                '}';
    }

    public CountryInfo(String code, String name, String flag, String capitalCity) {
        this.code = code;
        this.name = name;
        this.flag = flag;
        this.capitalCity = capitalCity;
    }
    public CountryInfo() {
    }
}
