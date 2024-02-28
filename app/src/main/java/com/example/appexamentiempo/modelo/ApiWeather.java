package com.example.appexamentiempo.modelo;
import com.example.appexamentiempo.modelo.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiWeather {
    String BASE_URL = "https://api.weatherapi.com/v1/";
    @Headers("Content-type: application/json")
    @GET("current.json")
    Call<Weather> getStuff(@Query("key") String key, @Query("q") String location, @Query("lang") String lang);
}
