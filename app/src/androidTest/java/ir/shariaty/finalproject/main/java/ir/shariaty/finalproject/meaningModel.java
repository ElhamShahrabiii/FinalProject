package ir.shariaty.finalproject;

import com.google.gson.annotations.SerializedName;

public class meaningModel {
    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("title_en")
    public String title_en;
    @SerializedName("text")
    public String text;
    @SerializedName("source")
    public String source;
    @SerializedName("db")
    public String db;
    @SerializedName("num")
    public int num;

}
