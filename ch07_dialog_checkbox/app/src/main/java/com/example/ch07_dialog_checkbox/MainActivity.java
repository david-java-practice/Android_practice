package com.example.ch07_dialog_checkbox;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //멤버변수로
    boolean [] checkArray = {true, false, false};

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                final String [] versionArray= {"오레오","파이","큐(10)"};
//                final boolean [] checkArray = {true, false, false};

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("안드로이드 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);

                DialogInterface.OnMultiChoiceClickListener lis1
                        = new DialogInterface.OnMultiChoiceClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked)
                    {
                        if(isChecked)
                            checkArray[which] = true;
                        else
                            checkArray[which] = false;

                        String str1="";//출력할 문자를 담는다(쉼표 포함해서)
                        int cnt=0;//선택된 갯수를 담는 변수

                        for(int i=0; i<checkArray.length;++i)
                        {
                            if(checkArray[i])
                            {
                                cnt++;//선택 될때 마다 카운팅
                                if(cnt != 1)
                                    str1 = str1+",";

                                str1 = str1 + versionArray[i] ;
                            }
                        }

                        if(cnt == 0)
                            str1 = "선택안됨!";

                        button1.setText(str1);







                        //button1.setText(versionArray[which]);

                    }
                };

                dlg.setMultiChoiceItems(versionArray,checkArray,lis1);

                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });


//        button1.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//
//                final String[] versionArray = new String[] { "오레오", "파이", "큐(10)" };
//                final boolean[] checkArray = new boolean[] { true, false, false };
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
//                dlg.setTitle("좋아하는 버전은?");
//                dlg.setIcon(R.mipmap.ic_launcher);
//                dlg.setMultiChoiceItems(versionArray, checkArray,
//                        new DialogInterface.OnMultiChoiceClickListener() {
//                            public void onClick(DialogInterface dialog,
//                                                int which, boolean isChecked) {
//                                button1.setText(versionArray[which]);
//                            }
//                        });
//                dlg.setPositiveButton("닫기", null);
//                dlg.show();
//
//            }
//        });
    }
}
