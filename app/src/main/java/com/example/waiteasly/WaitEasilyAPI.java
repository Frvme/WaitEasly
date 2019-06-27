package com.example.waiteasly;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WaitEasilyAPI {

//    @GET("posts")
//    Call<List<Ticket>> getTickets();

    @GET("AzureApi.php")
    Call<JsonObject> getCurrentTicket(@Query("method") String method, @Query("idTicket") String idTicket);

}

