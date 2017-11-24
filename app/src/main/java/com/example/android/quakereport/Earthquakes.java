package com.example.android.quakereport;

/**
 * Created by doc on 05/11/2017.
 */

public class Earthquakes {
   private double magnitude;
   private String place;
   private long time;
   private String url;


    /*
   Constructor
    */
public Earthquakes(double magnitude, String place, long time, String url){
    this.magnitude = magnitude;
    this.place = place;
    this.time = time;
    this.url = url;
}

    /*
    public setters
     */
    public void setMagnitude(double magnitude){
        this.magnitude = magnitude;
    }
    public void setPlace(String place){
        this.place = place;
    }
    public void setTime(long time){
        this.time = time;
    }


     /*
    public getters
     */

    public double getMagnitude(){
         return this.magnitude;
     }
    public String getPlace(){
        return this.place;
    }
    public long getTime(){
        return this.time;
    }
    public String getUrl() { return this.url; }

}
