package com.example.ex05_1_2_3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //XML을 안쓰겠다! -> 추천방법은 아니다!
        //setContentView(R.layout.activity_main);

        //1. 파라미터(속성)을 준비, 레이아웃 만들기 전에
        //2. 레이아웃 만들기
        //3. 레이아웃 속성 정하기

        LinearLayout.LayoutParams params
                = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT
        );

        LinearLayout layout = new LinearLayout(this);//액티비티
        layout.setOrientation(LinearLayout.VERTICAL);
//        layout.setBackgroundColor(Color.rgb(0,255,0));
//
        setContentView(layout, params);//1)콘텐츠 뷰 추가 -> 엑티비티에

        //1.에디트 텍스트
        EditText edt = new EditText(this);
        edt.setHint("입력하세요");
        layout.addView(edt);

        //2.버튼
        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.MAGENTA);
        layout.addView(btn);//2)뷰 추가 -> 레이아웃에

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "버튼",Toast.LENGTH_SHORT).show();
            }
        });

        //3.텍스트뷰
        TextView tv = new TextView(this);
        tv.setText("텍스트뷰입니다!");
        tv.setTextSize(30);
        tv.setTextColor(Color.YELLOW);
        layout.addView(tv);




    }
}