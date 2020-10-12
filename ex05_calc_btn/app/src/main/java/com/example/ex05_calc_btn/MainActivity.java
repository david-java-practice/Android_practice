package com.example.ex05_calc_btn;

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

//    Button btn00,btn01,btn02, btn03, btn04;
//    Button btn05,btn06,btn07, btn08, btn09;

    //1.버튼을 배열로!
    Button btnArr[] = new Button[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);//1.바인딩(View)

        edt1 = (EditText) findViewById(R.id.edt1);//2.바인딩(위젯)
        edt2 = (EditText) findViewById(R.id.edt2);//2.바인딩(위젯)

        btn1 = (Button) findViewById(R.id.btn1);//2.바인딩(위젯)
        btn2 = (Button) findViewById(R.id.btn2);//2.바인딩(위젯)
        btn3 = (Button) findViewById(R.id.btn3);//2.바인딩(위젯)
        btn4 = (Button) findViewById(R.id.btn4);//2.바인딩(위젯)
//        btn5 = (Button) findViewById(R.id.btn5);//2.바인딩(위젯)

        tv1 = (TextView) findViewById(R.id.tv1);//2.바인딩(위젯)

//        btn01 = (Button) findViewById(R.id.BtnNum0);//2.바인딩(위젯)
//        btn02 = (Button) findViewById(R.id.BtnNum1);//2.바인딩(위젯)
//        btn4 = (Button) findViewById(R.id.BtnNum2);//2.바인딩(위젯)
//        btn4 = (Button) findViewById(R.id.btn4);//2.바인딩(위젯)
//        btn4 = (Button) findViewById(R.id.btn4);//2.바인딩(위젯)
//        btn4 = (Button) findViewById(R.id.btn4);//2.바인딩(위젯)
//        btn4 = (Button) findViewById(R.id.btn4);//2.바인딩(위젯)
//        btn4 = (Button) findViewById(R.id.btn4);//2.바인딩(위젯)
//        btn4 = (Button) findViewById(R.id.btn4);//2.바인딩(위젯)


        //2.버튼의 ID를 배열로, 목적은 반복문에서 인덱스(i)를 쓰려고
        int btnIDs[] = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                        R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5,
                        R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8,
                        R.id.BtnNum9};

        //3.바인딩을 배열에
        for(int i=0; i<btnArr.length;i++)
            btnArr[i] = (Button) findViewById(btnIDs[i]);

        //4.이벤트 처리를 배열에
        for(int i=0; i<btnArr.length;++i)
        {
            final int idx = i;
            btnArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edt1.isFocused()) {
//                        String str1 = edt1.getText().toString() + idx;
                        String str1 = edt1.getText().toString()
                                    + btnArr[idx].getText().toString();
                        edt1.setText(str1);
                    } else if (edt2.isFocused()) {
                        String str1 = edt2.getText().toString()
                                + btnArr[idx].getText().toString();
                        edt2.setText(str1);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "에디터를 선택해주세요",
                                Toast.LENGTH_SHORT).show();
                        ;
                    }
                }
            });
        }


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

//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String str1 = edt1.getText().toString();
//                String str2 = edt2.getText().toString();
//
//                //둘 중에 하나라도 공백이면, 에러표시
//                if(str1.equals("") || str2.equals(""))
//                {
//                    Toast.makeText(MainActivity.this ,
//                            "빈칸입력됐음!",
//                            Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    double result = Double.parseDouble(str1)
//                            % Double.parseDouble(str2);
//                    tv1.setText("결과: " + result);
//                }
//
//            }
//        });






    }
}