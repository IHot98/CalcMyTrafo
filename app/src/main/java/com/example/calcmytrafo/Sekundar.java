package com.example.calcmytrafo;


public class Sekundar  {


   final private float Napon;
   final private float Struja;
    private float BrojNamota;
    private float DebljinaZice;


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

    }


}
