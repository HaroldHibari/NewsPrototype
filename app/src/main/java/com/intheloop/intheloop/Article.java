package com.intheloop.intheloop;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hibatop on 19/03/2016.
 */
public class Article {

    @SerializedName("banner")
    private String imgUrl;
    @SerializedName("header")
    private String artHdr;
    @SerializedName("summary")
    private String artSumm;


    public Article(String img, String header, String summ){
        imgUrl = img;
        artHdr = header;
        artSumm = summ;
    }

    public void setImg(String img){
        imgUrl = img;
    }

    public void setHdr(String header){
        artHdr = header;
    }

    public void setSumm(String summ){  artSumm = summ;  }

    public String getImage(){
        return imgUrl;
    }

    public String getHeader(){
        return artHdr;
    }

    public String getSummary(){
        return artSumm;
    }



}
