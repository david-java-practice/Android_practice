package com.example.final_project_lottery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NumberMapActivity extends AppCompatActivity {

//    public boolean onCreateOptionsMenu(Menu menu){
//        super.onCreateOptionsMenu(menu);
//        menu.add(0,1,0,"돌아가기");
//        return true;
//    }
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case 1:
//                finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMap = (Button) findViewById(R.id.btnMap);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.co.kr/maps/place/%EB%B3%B5%EA%B6%8C%ED%8C%90%EB%A7%A4%EC%A0%90+%EC%B2%9C%ED%95%98%EB%AA%85%EB%8B%B9/@35.1433726,129.049001,14.42z/data=!4m8!1m2!2m1!1z66Gc65iQ7YyQ66ek7KCQ!3m4!1s0x0:0xfba76df9db11697d!8m2!3d35.1400594!4d129.0630698?hl=ko");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }

        });

    }

}
