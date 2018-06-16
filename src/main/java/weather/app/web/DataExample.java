package weather.app.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataExample {
    List<TestData> data;
    List<String> provinces;


    public DataExample(){
        data = new ArrayList<TestData>();
        provinces = new ArrayList<String>();
        makeProvinces();
        makeTestData();
    }
    public DataExample(boolean b){
        data = new ArrayList<TestData>();
        provinces = new ArrayList<String>();
        makeProvinces();
        predictionTestData();
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

    public void makeTestData(){
        Random gen = new Random();
        for (String province: provinces){
            data.add(new TestData(province, gen.nextDouble()*80, "pm10", true));
            data.add(new TestData(province, gen.nextDouble()*50, "pm2.5", true));
            data.add(new TestData(province, gen.nextDouble()*130, "o3", true));
            data.add(new TestData(province, gen.nextDouble()*110, "no2", true));
            data.add(new TestData(province, gen.nextDouble()*130, "so2", true));
            data.add(new TestData(province, gen.nextDouble()*14, "c6h6", true));
            data.add(new TestData(province, gen.nextDouble()*10, "co", true));
        }
    }
    public void predictionTestData(){
        Random gen = new Random();
        for (String province: provinces){
            data.add(new TestData(province, gen.nextDouble()*80, "pm10", false));
            data.add(new TestData(province, gen.nextDouble()*50, "pm2.5", false));
            data.add(new TestData(province, gen.nextDouble()*130, "o3", false));
            data.add(new TestData(province, gen.nextDouble()*110, "no2", false));
            data.add(new TestData(province, gen.nextDouble()*130, "so2", false));
            data.add(new TestData(province, gen.nextDouble()*14, "c6h6", false));
            data.add(new TestData(province, gen.nextDouble()*10, "co", false));
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
