package com.example.ahnaf.myapplication2;

/**
 * Created by Ahnaf on 1/21/2019.
 */
public class Houseiteam {
    String id,phone,area,roadno,housename,houseno,floor,flatno,bedroom,washroom,rent;

    public Houseiteam(String id,String phone, String area, String roadno, String housename, String houseno, String floor, String flatno, String bedroom, String washroom,  String rent) {
        this.id = id;
        this.phone = phone;
        this.area = area;
        this.roadno = roadno;
        this.housename = housename;
        this.houseno = houseno;
        this.floor = floor;
        this.flatno = flatno;
        this.bedroom = bedroom;
        this.washroom = washroom;
        this.rent = rent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRoadno() {return roadno; }

    public  void setRoadno( String roadno)  {this.roadno = roadno; }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public  String getFlatno (){ return flatno ;}
    public  void setFlatno(String flatno ){
        this.flatno  = flatno;
    }
    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getWashroom() {
        return washroom;
    }

    public void setWashroom(String washroom) {
        this.washroom = washroom;
    }



    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }
}

