package com.example.ch07_option_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
{
//    LinearLayout baseLaout;
//    Button btn1;

    EditText edt1;
    ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);//예제
        setContentView(R.layout.activity_main2);//문제

//        baseLaout = (LinearLayout) findViewById(R.id.baseLayout);
//        btn1 = (Button) findViewById(R.id.button1);

        edt1 = (EditText) findViewById(R.id.edt1);
        iv1 = (ImageView) findViewById(R.id.iv1);

    }

//    //1.옵션메뉴 만들기(create) - 방법1: xml로 디자인 (선호)
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater mIn = getMenuInflater();
//        mIn.inflate(R.menu.menu, menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mIn = getMenuInflater();
        mIn.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    float f2 = 0;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.itemRotate:
                String str1 = edt1.getText().toString();
                Float f1 = Float.parseFloat(str1);
                f2 = f2 + f1;
                iv1.setRotation(f2);
                return true;
            case R.id.item1:
                iv1.setImageResource(R.drawable.jeju1);
                item.setChecked(true);
                return true;
            case R.id.item2:
                iv1.setImageResource(R.drawable.jeju10);
                item.setChecked(true);
                return true;
            case R.id.item3:
                iv1.setImageResource(R.drawable.jeju15);
                item.setChecked(true);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //    //1.옵션메뉴 만들기(create) - 방법2: java로 디자인 (비선호)
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        menu.add(0,1,0, "배경색(빨강)");
//        menu.add(0,2,0, "배경색(그린)");
//        menu.add(0,3,0, "배경색(파랑)");
//
//        SubMenu sMenu = menu.addSubMenu("버튼변경");
//        sMenu.add(0,4,0, "크기 2배");
//        sMenu.add(0,5,0, "회전 45도");
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    //2.옵션메뉴 이벤트 처리
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item)
//    {
//        switch (item.getItemId())
//        {
////            case R.id.itemRed:
//            case 1://id
//                baseLaout.setBackgroundColor(Color.RED);
//                return true;
//            case 2:
//                baseLaout.setBackgroundColor(Color.GREEN);
//                return true;
//            case 3:
//                baseLaout.setBackgroundColor(Color.BLUE);
//                return true;
//
//            case 4:
//                btn1.setScaleX(2);
//                return true;
//            case 5:
//                btn1.setRotation(45);
//                return true;
//        }
//
//
//        return super.onOptionsItemSelected(item);
//    }
}









