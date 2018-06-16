package weather.app.web;


import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class TestData {


    String province;
    String date;
    double value;
    String component;
    String state;

    public TestData(String p,String d, double v, String c){
        province = p;
        date = d;
        value = v;
        component = c;
        if(v <2)
            state = "Very Bad";
        else if (v <4)
            state = "Bad";
        else if (v <6)
            state = "Tolerable";
        else if (v <8)
            state = "Good";
        else
            state = "Very Good";

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

    public TestData(String p, double v, String c, boolean b){
        province = p;
        Calendar now = Calendar.getInstance();
        if(b) {
            Date date = new Date();
            date.setMinutes(0);
            date.setSeconds(0);
            this.date = date.toString();
        } else {
            now.add(Calendar.HOUR, 6);
            Date date = now.getTime();
            date.setMinutes(0);
            date.setSeconds(0);
            this.date = date.toString();
        }
        value = v;
        component = c;
        switch (c) {
            case "pm10":
                if (v < 21)
                    state = "Bardzo dobry";
                else if (v < 61)
                    state = "Dobry";
                else if (v < 101)
                    state = "Umiarkowany";
                else if (v < 141)
                    state = "Dostateczny";
                else if (v < 201)
                    state = "Zły";
                else
                    state = "Bardzo zły";
                break;
            case "pm2.5":
                if (v < 13)
                    state = "Bardzo dobry";
                else if (v < 37)
                    state = "Dobry";
                else if (v < 61)
                    state = "Umiarkowany";
                else if (v < 85)
                    state = "Dostateczny";
                else if (v < 121)
                    state = "Zły";
                else
                    state = "Bardzo zły";
                break;
            case "o3":
                if (v < 71)
                    state = "Bardzo dobry";
                else if (v < 121)
                    state = "Dobry";
                else if (v < 151)
                    state = "Umiarkowany";
                else if (v < 181)
                    state = "Dostateczny";
                else if (v < 241)
                    state = "Zły";
                else
                    state = "Bardzo zły";
                break;
            case "no2":
                if (v < 41)
                    state = "Bardzo dobry";
                else if (v < 101)
                    state = "Dobry";
                else if (v < 151)
                    state = "Umiarkowany";
                else if (v < 201)
                    state = "Dostateczny";
                else if (v < 401)
                    state = "Zły";
                else
                    state = "Bardzo zły";
                break;
            case "so2":
                if (v < 51)
                    state = "Bardzo dobry";
                else if (v < 101)
                    state = "Dobry";
                else if (v < 201)
                    state = "Umiarkowany";
                else if (v < 351)
                    state = "Dostateczny";
                else if (v < 501)
                    state = "Zły";
                else
                    state = "Bardzo zły";
                break;
            case "c6h6":
                if (v < 6)
                    state = "Bardzo dobry";
                else if (v < 11)
                    state = "Dobry";
                else if (v < 16)
                    state = "Umiarkowany";
                else if (v < 21)
                    state = "Dostateczny";
                else if (v < 51)
                    state = "Zły";
                else
                    state = "Bardzo zły";
                break;
            case "co":
                if (v < 3)
                    state = "Bardzo dobry";
                else if (v < 7)
                    state = "Dobry";
                else if (v < 11)
                    state = "Umiarkowany";
                else if (v < 15)
                    state = "Dostateczny";
                else if (v < 21)
                    state = "Zły";
                else
                    state = "Bardzo zły";
                break;
        }
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
    public String getComponent(){return component;}

}
