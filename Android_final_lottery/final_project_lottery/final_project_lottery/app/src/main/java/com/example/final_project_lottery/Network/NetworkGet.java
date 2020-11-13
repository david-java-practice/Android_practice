package com.example.final_project_lottery.Network;

import android.os.AsyncTask;
import android.util.Log;

import com.example.final_project_lottery.Custom_Adapter;
import com.example.final_project_lottery.NumberInfo;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;

public class NetworkGet extends AsyncTask<String, Void, String> {
    private URL Url;
    private String URL_Address = "http://10.100.206.21:8888/Project_DB/testDB3.jsp";
    private Custom_Adapter adapter;

    public NetworkGet(Custom_Adapter adapter){
        this.adapter = adapter;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res="";
        try{
            Url = new URL(URL_Address);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            //전송모드 설정
            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            //context-type 설정
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

            //전송값 설정
            StringBuilder buffer = new StringBuilder();
            buffer.append("num1").append("=").append(strings[0]); // num1을 넘김

            //서버로 전송
            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(),"utf-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush(); //보내는곳

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while((line = in.readLine())!=null){ //들어오는곳
                builder.append(line+"\n");
            }
            res = builder.toString();
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        Log.i("Get result", res);
        return res;
    }

    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);

        ArrayList<NumberInfo> numberList = new ArrayList<NumberInfo>(); //데이터 받을 곳
        int count = 0;
        try{
            count = JsonParser.getNumberInfoJson(s, numberList);
        } catch (JSONException e){
            e.printStackTrace();
        }

        if(count == 0){

        } else{
            adapter.setDatas(numberList);
            adapter.notifyDataSetInvalidated();
        }
    }
}
