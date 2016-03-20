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

        ArrayList<Article> newArs = new ArrayList<Article>();

        for(Article a : articles){
            a.setImg(a.getImage().replace("640", "320").replace("480", "240"));
        }

        for(int i = 0; i < 20; i++ ){
           newArs.add(articles.get(i));
        }

        return newArs;

//        return articles;
    }

    public void setArticles(ArrayList<Article> Articles){
        articles = Articles;
    }
}
