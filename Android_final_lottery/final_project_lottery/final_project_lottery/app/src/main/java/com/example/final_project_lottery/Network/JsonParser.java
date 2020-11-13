package com.example.final_project_lottery.Network;

import com.example.final_project_lottery.NumberInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    static public int getNumberInfoJson(String response, ArrayList<NumberInfo> numberList) throws JSONException {
        String strnum1;
        String strnum2;
        String strnum3;
        String strnum4;
        String strnum5;
        String strnum6;
        String strwriteTime;

        JSONObject rootJSON = new JSONObject(response); //json형태의 스트림을 -> 객체로 변환해서 담기
        JSONArray jsonArray = new JSONArray(rootJSON.getString("datas"));

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = (JSONObject)jsonArray.get(i);

            if(jsonObj.getString("num1").toString().equals("null"))
                strnum1="-";
            else
                strnum1=jsonObj.getString("num1").toString();

            if(jsonObj.getString("num2").toString().equals("null"))
                strnum2="-";
            else
                strnum2=jsonObj.getString("num2").toString();

            if(jsonObj.getString("num3").toString().equals("null"))
                strnum3="-";
            else
                strnum3=jsonObj.getString("num3").toString();

            if(jsonObj.getString("num4").toString().equals("null"))
                strnum4="-";
            else
                strnum4=jsonObj.getString("num4").toString();

            if(jsonObj.getString("num5").toString().equals("null"))
                strnum5="-";
            else
                strnum5=jsonObj.getString("num5").toString();

            if(jsonObj.getString("num6").toString().equals("null"))
                strnum6="-";
            else
                strnum6=jsonObj.getString("num6").toString();

            if (jsonObj.getString("writeTime").toString().equals("null"))
                strwriteTime = "-";
            else{
                strwriteTime = jsonObj.getString("writeTime").toString();
                String temp[] = strwriteTime.split(" ");
                strwriteTime = temp[0] + "\n" + temp[1];
            }

            numberList.add(new NumberInfo(strnum1, strnum2, strnum3, strnum4, strnum5, strnum6, strwriteTime));

        }
        return jsonArray.length();
    }
    static public int getResultJson(String response) throws JSONException {
        JSONArray jsonArray = new JSONArray(response);
        JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
        return Integer.parseInt(jsonObject.getString("RESULT_OK"));
    }

}


