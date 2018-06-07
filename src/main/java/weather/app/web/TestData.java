package weather.app.web;


import java.text.*;
import java.util.Date;
import java.util.Random;

public class TestData {


    String province;
    String date;
    int value;
    String state;

    public TestData(String p,String d, int v, String s){
        province = p;
        date = d;
        value = v;
        state = s;

    }

    public TestData(String p){
        province = p;
        this.date = new Date().toString();
        Random gen = new Random();
        value = gen.nextInt(9)+1;
        if (value >=8)
            state = "very good";
        else if ( value >= 6)
            state = "tolerable";
        else state = "good";
    }

    public TestData(String p, String d){
        province = p;
        date = d;
        Random gen = new Random();
        value = gen.nextInt(9)+1;
        if (value >=8)
            state = "very good";
        else if ( value >= 6)
            state = "tolerable";
        else state = "good";
    }

    public String toString(){
        return "[province: "+province+", date: "+date+", value: "+value+"]\n";
    }

    public double getValue(){return value;}
    public String getDate(){return date;}
    public String getProvince(){return province;}
    public String getState(){return state;}

}
