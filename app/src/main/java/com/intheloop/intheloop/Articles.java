package com.intheloop.intheloop;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hibatop on 19/03/2016.
 */
public class Articles {

    @SerializedName("articles")
    ArrayList<Article> articles;

    public Articles(ArrayList<Article> Articles){
        this.articles=Articles;
    }

    public ArrayList<Article> getArticles(){
        return articles;
    }

    public void setArticles(ArrayList<Article> Articles){
        articles = Articles;
    }
}
