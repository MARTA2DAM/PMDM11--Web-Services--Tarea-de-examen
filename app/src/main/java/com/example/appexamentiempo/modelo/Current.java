package com.example.appexamentiempo.modelo;
import com.google.gson.annotations.SerializedName;
public class Current {

    @SerializedName("wind_kph")
    private double windKph;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("temp_c")
    private double tempCelsius;

    @SerializedName("condition")
    private Condition condition;

    public double getWindKph() {
        return windKph;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getTempCelsius() {
        return tempCelsius;
    }

    public Condition getCondition() {
        return condition;
    }


}
