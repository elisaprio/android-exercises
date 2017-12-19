package fr.android.androidexercises;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MyApp extends Application {
    private static HenriPotierService service;

    public void onCreate(){
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create()) //transforme du Gson en Java
                .build();

        service = retrofit.create(HenriPotierService.class);
    }

    public static HenriPotierService getService(){
        return service;
    }

}
