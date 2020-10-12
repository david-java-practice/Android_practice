package com.example.ch07_context_menu;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1, button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(컨텍스트 메뉴)");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        //버튼 -> 뷰의 하나! -> 메뉴사용을 위해서 등록!
        registerForContextMenu(button1);

        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,//버튼1, 버튼2는 View에 포함된다.
                                    ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

//        MenuInflater mInflater = getMenuInflater();

        if (v == button1) {//뷰에 담긴 버튼이 뭔지를 판단 한 후, 바인딩 할꺼임
            menu.setHeaderTitle("배경색 변경");

            menu.add(0,1,0,"빨강");
            menu.add(0,2,0,"그린");
            menu.add(0,3,0,"파랑");
//            mInflater.inflate(R.menu.menu1, menu);//인플레이터
        }
        if (v == button2) {
            menu.add(0,4,0,"회전");
            menu.add(0,5,0,"확대");
//            mInflater.inflate(R.menu.menu2, menu);
        }
    }





    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                button2.setRotation(45);
                return true;
            case 5:
                button2.setScaleX(2);
                return true;
        }
        return false;
    }

}
