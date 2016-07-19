package kr.ac.kmu.cs.jsontestapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pabel on 2016-07-17.
 */
public class JSONData {
    static int count;
    static JSONArray jsonAirDatas;
    static String DataInfo;
    static JSONObject jsonObject;
    static ArrayList<JSONObject> jsonSplitAirDatas;
    public JSONData(String JSON){
        try {
            jsonObject = new JSONObject(JSON);
            count = jsonObject.getJSONObject("sensorData").getInt("totalRows");
            DataInfo = jsonObject.getJSONObject("sensorInfo").getString("name");
            jsonAirDatas = jsonObject.getJSONObject("sensorData").getJSONArray("dataArray");
            jsonSplitAirDatas = new ArrayList<>(count);
            for(int i = 0; i < count ; i++){
                jsonSplitAirDatas.add(i,jsonAirDatas.getJSONObject(i));
            }
        } catch (JSONException e) {
            Log.d("JSON",e.getMessage());
            e.printStackTrace();
        }

    }

}

/*class airData {
    int CO2,CO,SO2,NO2,PM,O3,TIME;
    public airData(JSONObject jsonObject){
        try {
            CO2 = jsonObject.getInt("co2");
            CO = jsonObject.getInt("co");
            SO2 = jsonObject.getInt("so2");
            NO2 = jsonObject.getInt("no2");
            PM = jsonObject.getInt("pm");
            O3 = jsonObject.getInt("o3");
            TIME = jsonObject.getInt("time");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public airData(int CO2,int CO,int SO2,int NO2,int PM,int O3,int TIME){
        this.CO2 = CO2;
        this.CO = CO;
        this.SO2 = SO2;
        this.NO2 = NO2;
        this.PM = PM;
        this.O3 = O3;
        this.TIME = TIME;
    }
}*/