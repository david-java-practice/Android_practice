package com.example.ch04_animal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //멤버변수!
    TextView textView2;
//    CheckBox chkAgree ;
    Switch swAgree;

    RadioGroup rGroup1;
//    RadioButton rdoDog, rdoCat, rdoRabbit;
    RadioButton []rdoBtn = new RadioButton[3];
//    Button btnOk;
    ImageView imgPet;
//    Button btnFinish, btnInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //지역 변수! onCreate()메소드의
        final Button btnFinish, btnInit;

        //XML에 있는 위젯과 여기 자바에 있는 위젯 객체랑 연결(바인딩)

        textView2 = (TextView) findViewById(R.id.Text2);
//        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);
        swAgree = (Switch) findViewById(R.id.swAgree);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
//        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
//        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
//        rdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);
        rdoBtn[0] = (RadioButton) findViewById(R.id.RdoCat);
        rdoBtn[1] = (RadioButton) findViewById(R.id.RdoDog);
        rdoBtn[2] = (RadioButton) findViewById(R.id.RdoRabbit);
//        int a = 0;
//        a= 1;
//        a= 3;



//        btnOk = (Button) findViewById(R.id.BtnOK);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        btnFinish = (Button) findViewById(R.id.BtnFinish);
        btnInit = (Button) findViewById(R.id.BtnInit);

//        btnFinish = (Button) findViewById(R.id.BtnInit);

        swAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                //if(isChecked == true)
                if(isChecked)//체크된 상태로 바뀌면...
                {
                    //아래 위젯들을 화면에 보이게...
                    textView2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    //btnOk.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                    btnFinish.setVisibility(View.VISIBLE);
                    btnInit.setVisibility(View.VISIBLE);
                }
                else
                {
                    //아래 위젯들을 화면에 "안"보이게...
                    textView2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
//                    btnOk.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                    btnFinish.setVisibility(View.INVISIBLE);
                    btnInit.setVisibility(View.INVISIBLE);
                }

            }
        });

        //2번째 이벤트 처리 -> 버튼
//        btnOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
////                switch (선택된 라디오버튼의 아이디!)
//                switch (rGroup1.getCheckedRadioButtonId())
//                {
//                    case R.id.RdoDog:
//                        imgPet.setImageResource(R.drawable.dog2);
//                        break;
//
//                    case R.id.RdoCat :
//                        imgPet.setImageResource(R.drawable.cat);
//                        break;
//
//                    case R.id.RdoRabbit:
//                        imgPet.setImageResource(R.drawable.rabbit);
//                        break;
//
//                    default:
//                        Toast.makeText(MainActivity.this,
//                                "라디오버튼을 먼저선택하세요",
//                                Toast.LENGTH_SHORT).show();
//                        break;
//                }
//
//            }
//        });

        //1.라디오버튼 3개를 1개로? -> 배열로... 객체 배열로..!
        //2. 이미지 객체를(예:R.drawable.dog2) 를 1개로 -> 배열로!

        final int [] nImage = {R.drawable.dog2,
                               R.drawable.cat,
                               R.drawable.rabbit};

        for(int i=0; i<rdoBtn.length; ++i)
        {
            final int idx_i = i;//왜 final 인가?
            rdoBtn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgPet.setImageResource(nImage[idx_i]);
                }
            });
        }

        rdoBtn[0] = (RadioButton) findViewById(R.id.RdoRabbit);
//        rdoDog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgPet.setImageResource(R.drawable.dog2);
//            }
//        });
//
//        rdoCat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgPet.setImageResource(R.drawable.cat);
//            }
//        });
//
//        rdoRabbit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgPet.setImageResource(R.drawable.rabbit);
//            }
//        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //아래 위젯들을 화면에 "안"보이게...
                textView2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
//                    btnOk.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);
                btnFinish.setVisibility(View.INVISIBLE);
                btnInit.setVisibility(View.INVISIBLE);

                swAgree.setChecked(false);
                rGroup1.clearCheck();
                imgPet.setImageResource(0);

            }
        });


    }
}










