package weather.app.web;


import java.text.*;
import java.util.Date;
import java.util.Random;

public class TestData {


    String province;
    String date;
    int value;

    public TestData(String p,String d, int v){
        province = p;
        date = d;
        value = v;
    }

    public TestData(String p){
        province = p;
        this.date = new Date().toString();
        Random gen = new Random();
        value = gen.nextInt(9)+1;
    }

    public TestData(String p, String d){
        province = p;
        date = d;
        Random gen = new Random();
        value = gen.nextInt(9)+1;
    }

    public String toString(){
        return "[province: "+province+", date: "+date+", value: "+value+"]\n";
    }

    public double getValue(){return value;}
    public String getDate(){return date;}
    public String getProvince(){return province;}

}
