package com.example.saintjoseph;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetData {

    @GET("/apitest.php?action=get_All_contacts")
    Call<List<Contact>> getAllContacts();

    @GET("/apitest.php?action=get_contact_like_name")
    Call<List<Contact>> getContactByName(@Query("name") String name);

    @GET("/apitest.php?action=get_contact_by_default")
    Call<List<Contact>> getContactBydefault(@Query("name") String name);

    @GET("/apitest.php?action=getDefaultForAll&a=zora&b=mer&c=platforme")
    Call<List<Contact>> getDefaultForAll(@Query("a") String a, @Query("b") String b, @Query("c") String c);

    @GET("/apitest.php?action=get_contact_by_nameProfession")
    Call<List<Contact>> getContactByNameProfession(@Query("name") String name, @Query("Profession") String profession);

    @GET("/apitest.php?action=get_contact_by_nameSer")
    Call<List<Contact>> getContactByNameSer(@Query("name") String name, @Query("Ser") String ser);

    @GET("/apitest.php?action=get_contact_by_ser")
    Call<List<Contact>> getContactBySer(@Query("Ser") String ser);

    @GET("/apitest.php?action=get_contact_by_profession")
    Call<List<Contact>> getContactByProfession(@Query("Profession") String profession);

}


///apitest.php?action=get_contact_like_name&name=kande"