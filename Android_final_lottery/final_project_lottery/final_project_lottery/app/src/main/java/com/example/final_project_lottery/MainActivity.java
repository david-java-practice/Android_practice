package com.example.final_project_lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.final_project_lottery.Network.NetworkGet;
import com.example.final_project_lottery.Network.NetworkInsert;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button btnInsert, btnRandom, btnList, btnMap, btnWebsite;
    private ListView listView;
    private Custom_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("동행복권");

        TextView tvToday = (TextView) findViewById(R.id.tvToday);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy.MM.dd", Locale.KOREA );
        Date currentTime = new Date ( );
        String toDay = simpleDateFormat.format( currentTime );
        tvToday.setText(toDay);


        //지도로 판매지점 연결
        btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NumberMapActivity.class);
                startActivity(intent);
            }
        });

        //웹사이트보기
        btnWebsite = (Button) findViewById(R.id.btnWebsite);
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NumberWebsiteActivity.class);
                startActivity(intent);
            }
        });


        //랜덤번호 생성
        btnRandom = (Button) findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NumberRandomActivity.class);
                startActivity(intent);
            }
        });



        listView = (ListView) findViewById(R.id.listView);
        adapter = new Custom_Adapter(MainActivity.this, R.layout.adapter_numberinfo, new ArrayList<NumberInfo>());
        listView.setAdapter(adapter);

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = getLayoutInflater().inflate(R.layout.number_add_create, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("번호직접입력")
                        .setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String num1 = ((EditText)v.findViewById(R.id.edtInNum1)).getText().toString();
                                String num2 = ((EditText)v.findViewById(R.id.edtInNum2)).getText().toString();
                                String num3 = ((EditText)v.findViewById(R.id.edtInNum3)).getText().toString();
                                String num4 = ((EditText)v.findViewById(R.id.edtInNum4)).getText().toString();
                                String num5 = ((EditText)v.findViewById(R.id.edtInNum5)).getText().toString();
                                String num6 = ((EditText)v.findViewById(R.id.edtInNum6)).getText().toString();
                                String datePicker = ((DatePicker)v.findViewById(R.id.datePicker)).toString();

                                new NetworkInsert(adapter).execute(num1, num2, num3, num4, num5, num6, datePicker);
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });
        new NetworkGet((Custom_Adapter) listView.getAdapter()).execute("");  //전체불러오기


    }
}