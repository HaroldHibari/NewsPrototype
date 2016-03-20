package com.intheloop.intheloop;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hibatop on 19/03/2016.
 */
public interface ArticleService {

    @GET("articles")
    Call<Articles> getArticles();

}
