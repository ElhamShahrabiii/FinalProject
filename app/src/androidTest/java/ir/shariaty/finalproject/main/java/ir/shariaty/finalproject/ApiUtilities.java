package ir.shariaty.finalproject;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    public static final String BASE_URL="http://api.vajehyab.com/v3/";

    public static final String token="68372.KmVovB43vrMzRNgCU5g85UyoJJqgUzoyhDNZVfjH";
private static Retrofit retrofit=null;

    public static Retrofit getApiInterface(Context mContext) {

        if(retrofit == null){
            Gson gson=new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
        // change your base URL
//        RestAdapter adapter = new RestAdapter.Builder()
//                .setEndpoint("http://api.vajehyab.com/v3/") //Set the Root URL
//                .build(); //Finally building the adapter
//        //Creating object for our interface
//        ApiInterface api = adapter.create(ApiInterface.class);
//        return api; // return the APIInterface object
    }
}