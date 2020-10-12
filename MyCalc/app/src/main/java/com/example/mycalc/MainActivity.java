package com.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //멤버변수로 격상
    EditText edt1, edt2;
    Button btn1, btn2, btn3, btn4, btn5;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//1.바인딩(View)

        edt1 = (EditText) findViewById(R.id.edt1);//2.바인딩(위젯)
        edt2 = (EditText) findViewById(R.id.edt2);//2.바인딩(위젯)

        btn1 = (Button) findViewById(R.id.btn1);//2.바인딩(위젯)
        btn2 = (Button) findViewById(R.id.btn2);//2.바인딩(위젯)
        btn3 = (Button) findViewById(R.id.btn3);//2.바인딩(위젯)
        btn4 = (Button) findViewById(R.id.btn4);//2.바인딩(위젯)
        btn5 = (Button) findViewById(R.id.btn5);//2.바인딩(위젯)

        tv1 = (TextView) findViewById(R.id.tv1);//2.바인딩(위젯)

        //이벤트 처리
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                //둘 중에 하나라도 공백이면, 에러표시
                if(str1.equals("") || str2.equals(""))
                {
                    Toast.makeText(MainActivity.this ,
                            "빈칸입력됐음!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double result = Double.parseDouble(str1)
                                  + Double.parseDouble(str2);

                    tv1.setText("결과: " + result);
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                //둘 중에 하나라도 공백이면, 에러표시
                if(str1.equals("") || str2.equals(""))
                {
                    Toast.makeText(MainActivity.this ,
                            "빈칸입력됐음!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double result = Double.parseDouble(str1)
                            - Double.parseDouble(str2);

                    tv1.setText("결과: " + result);
                }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                //둘 중에 하나라도 공백이면, 에러표시
                if(str1.equals("") || str2.equals(""))
                {
                    Toast.makeText(MainActivity.this ,
                            "빈칸입력됐음!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double result = Double.parseDouble(str1)
                            * Double.parseDouble(str2);

                    tv1.setText("결과: " + result);
                }

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString().trim();
                String str2 = edt2.getText().toString().trim();

                //둘 중에 하나라도 공백이면, 에러표시
                if(str1.equals("") || str2.equals(""))
                {
                    Toast.makeText(MainActivity.this ,
                            "빈칸입력됐음!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(str2.equals("0"))
                    {
                        Toast.makeText(getApplicationContext(),
                                        "0으로 나눌 수 없음!",
                                        Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        double result = Double.parseDouble(str1)
                                / Double.parseDouble(str2);

                        result = (int)(result * 100)/100.0;

                        tv1.setText("결과: " + result);
                    }

                }

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                //둘 중에 하나라도 공백이면, 에러표시
                if(str1.equals("") || str2.equals(""))
                {
                    Toast.makeText(MainActivity.this ,
                            "빈칸입력됐음!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double result = Double.parseDouble(str1)
                                  % Double.parseDouble(str2);
                    tv1.setText("결과: " + result);
                }

            }
        });






    }
}