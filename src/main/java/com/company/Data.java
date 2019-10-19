/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;
/**
 *
 * @author yeong
 */
class Data {


    private int num;
    private String name,matric,link;

    public Data(){

    }

    public Data( String column1, String column2,String column3) {
        this.matric = column2;
        this.name = column1;
        this.link = column3;
    }
    public Data(String column1, String column2) {

        this.matric = column1;
        this.name = column2;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMatric() {
        return matric;
    }

    public void setMatric(String column1) {
        this.matric = column1;
    }

    public String getName() {
        return name;
    }

    public void setName(String column2) {
        this.name = column2;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String column3) {
        this.link = column3;
    }
}