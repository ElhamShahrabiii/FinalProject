package ir.shariaty.finalproject;

//import android.telecom.Call;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

//    @FormUrlEncoded // annotation used in POST type requests
//    @GET("/retrofit/register.php")     // API's endpoints
//    public void registration( @Query("token") String token,
//@Query("word")String word,
////                             @Field("email") String email,
////                             @Field("password") String password,
////                             @Field("logintype") String logintype,
//                             Callback<signUpResponse> callback);

//    void registration(String trim, String word, Callback<signUpResponse> signUpResponseCallback);

    @GET("search")
    Call<searchModel> search(
            @Query("token")String token,
            @Query("q")String q,
            @Query("type") String type,
            @Query("filter")String filter);

}