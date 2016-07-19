package kr.ac.kmu.cs.jsontestapp;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;

/**
 * Created by pabel on 2016-07-17.
 */
public class pagerAdapter extends PagerAdapter {
    LayoutInflater inflater;
    //JSONData jsonData;
    public pagerAdapter(LayoutInflater inflater)
    {
        this.inflater=inflater;
    }
    @Override
    public int getCount() {

        return JSONData.count;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view=inflater.inflate(R.layout.my_data_view,null);

        Set_View(view,position);
        container.addView(view);
        return view;
        //return super.instantiateItem(container, position);
    }

    public void Set_View(View view,int page_num)
    {
        //define fragment widget
        TextView tv_CO2,tv_CO,tv_SO2,tv_NO2,tv_PM,tv_O3,tv_TIME;
        tv_TIME = (TextView)view.findViewById(R.id.frag_tv_Time);
        tv_SO2 = (TextView)view.findViewById(R.id.frag_tvSO2);
        tv_PM = (TextView)view.findViewById(R.id.frag_tv_PM);
        tv_O3 = (TextView)view.findViewById(R.id.frag_tv_O3);
        tv_CO = (TextView)view.findViewById(R.id.frag_tvCO);
        tv_CO2 = (TextView)view.findViewById(R.id.frag_tvCO2);
        tv_NO2 = (TextView)view.findViewById(R.id.frag_tvNO2);
        try {
            //Log.d("debutime",JSONData.jsonAirDatas.getJSONObject(page_num).getString("time"));
            //Log.d("debuso2",JSONData.jsonAirDatas.getJSONObject(page_num).getString("so2"));
            //Log.d("debupm",JSONData.jsonAirDatas.getJSONObject(page_num).getString("pm2.5"));
            tv_CO.setText(" CO : " + JSONData.jsonAirDatas.getJSONObject(page_num).getString("co"));
            tv_CO2.setText(" CO2 : " + JSONData.jsonAirDatas.getJSONObject(page_num).getString("co2"));
            tv_NO2.setText(" NO2 : " + JSONData.jsonAirDatas.getJSONObject(page_num).getString("no2"));
            tv_O3.setText(" O3 : " + JSONData.jsonAirDatas.getJSONObject(page_num).getString("o3"));
            tv_PM.setText(" PM : " + JSONData.jsonAirDatas.getJSONObject(page_num).getString("pm2.5"));
            tv_SO2.setText(" SO2 : " + JSONData.jsonAirDatas.getJSONObject(page_num).getString("so2"));
            tv_TIME.setText(" TIME : " + JSONData.jsonAirDatas.getJSONObject(page_num).getString("time"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return  view==object;
        //return false;
    }
}
