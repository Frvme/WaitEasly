package com.example.waiteasly;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Ticket>> getTickets();

    @GET("posts/{id}")
    Call<Ticket> getTicket(@Query("id") int postId);
}
