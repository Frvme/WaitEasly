package com.example.waiteasly;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Ticket>> getTickets();

    @GET("AzureApi.php/")
    Call<List<Ticket>> getTicket(@Query("method") String methode, @Query("idTicket") String id);



}

