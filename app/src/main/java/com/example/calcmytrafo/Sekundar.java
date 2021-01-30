package com.example.calcmytrafo;

import android.os.Parcelable;



public class Sekundar  {


    private float Napon;
    private float Struja;
    private float BrojNamota;
    private float DebljinaZice;

    public void setNapon(float napon) {        Napon = napon;    }
    public void setStruja(float struja) {        Struja = struja;    }
    public void setBrojNamota(float brojNamota) { BrojNamota = brojNamota;}

    public void setDebljinaZice(float debljinaZice) {        DebljinaZice = debljinaZice;    }

    public float getStruja() {        return Struja;    }
    public float getNapon() {  return Napon;    }
    public float getBrojNamota() {return BrojNamota; }

    public float getDebljinaZice() {
        return DebljinaZice;
    }

    public Sekundar(float sNapon, float sStruja){
        Napon=sNapon;
        Struja=sStruja;
        BrojNamota=0;
        DebljinaZice=0;

    };
    public Sekundar(float sNapon, float sStruja, float BN){
        Napon=sNapon;
        Struja=sStruja;
        BrojNamota=BN;
        DebljinaZice=0;

    };
    public Sekundar(){
        Napon=0;
        Struja=0;
        BrojNamota=0;
        DebljinaZice=0;
    };

}
