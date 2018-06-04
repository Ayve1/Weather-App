package weather.app.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataExample {
    List<TestData> data;
    List<String> provinces;


    public DataExample(){
        data = new ArrayList<TestData>();
        provinces = new ArrayList<String>();
        makeProvinces();
        makeTest();
    }

    public void makeProvinces(){
        provinces.add("dolnośląskie");
        provinces.add("kujawsko-pomorskie");
        provinces.add("lubelskie");
        provinces.add("lubuskie");
        provinces.add("łódzkie");
        provinces.add("małopolskie");
        provinces.add("mazowieckie");
        provinces.add("opolskie");
        provinces.add("podkarpackie");
        provinces.add("podlaskie");
        provinces.add("pomorskie");
        provinces.add("śląskie");
        provinces.add("świętokrzyskie");
        provinces.add("warmińsko-mazurskie");
        provinces.add("wielkopolskie");
        provinces.add("zachodniopomorskie");
    }

    public void makeTest(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.HOUR, 9*(-6));
        dt = c.getTime();
        for(int i=0; i<10; i++){
            for (String province : provinces) {
                data.add(new TestData(province, dt.toString()));
            }
            c.add(Calendar.HOUR, 6);
            dt = c.getTime();
        }
    }

    public String toString(){
        String s = "";
        for(TestData test : data){
            s += test.toString();
        }
        return s.toString();
    }

    public List<TestData> getData(){ return data;}
    public List<String> getProvinces(){ return provinces;}

    public List<TestData> getData(String province){
        List<TestData> provinceData = new ArrayList<>();
        for(TestData test : data){
            if(province.equals(test.province))
                provinceData.add(test);
        }
        return provinceData;
    }

    public void addMore(){
        for(String p : provinces){ data.add(new TestData(p));}
    }
}
