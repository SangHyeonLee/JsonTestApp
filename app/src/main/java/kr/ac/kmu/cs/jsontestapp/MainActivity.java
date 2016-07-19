package kr.ac.kmu.cs.jsontestapp;

import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ViewPager page; // define page_container
    JSONData jsonData; // JSON File manage
    final String Path = Environment.getExternalStorageDirectory().getPath() + "/Download/sensordata.json";
    int jsonCount = 2;
    int currentCount = 1;
    String[] jsonFileName = {"sensordata.json","sensordata2.json"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set JSON data

       // Log.d("JSON",jsonData.DataInfo);
       // Log.d("JSON",jsonData.count+"");
      //  Log.d("JSON",jsonData.jsonObject.toString());
        /*for(int i = 0; i < jsonData.count;i++){
            Log.d("JSONARRAY",jsonData.jsonSplitAirDatas.get(i).toString());
        }*/
        jsonData = new JSONData(loadJSONFromAsset("sensordata.json"));
        //set page_container
        page=(ViewPager)findViewById(R.id.page_container);
        page.setAdapter(new pagerAdapter(getLayoutInflater()));
        page.setCurrentItem(0);

    }
    public String loadJSONFromAsset(String FileName) {
        String json = null;
        try {
            InputStream is = getBaseContext().getAssets().open(FileName);

            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            //Log.d("2","2됨");
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void onChange(View view){
        currentCount = currentCount%jsonCount;
        jsonData = new JSONData(loadJSONFromAsset(jsonFileName[currentCount]));
        //set page_container
        page=(ViewPager)findViewById(R.id.page_container);
        page.setAdapter(new pagerAdapter(getLayoutInflater()));
        page.setCurrentItem(0);
        currentCount++;
    }
}
