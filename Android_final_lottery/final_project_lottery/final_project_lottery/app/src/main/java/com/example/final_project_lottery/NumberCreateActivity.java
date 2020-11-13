package com.example.final_project_lottery;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NumberCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_create);
        setTitle("직접생성");

        final EditText edtInNum1 = (EditText) findViewById(R.id.edtInNum1);
        final EditText edtInNum2 = (EditText) findViewById(R.id.edtInNum2);
        final EditText edtInNum3 = (EditText) findViewById(R.id.edtInNum3);
        final EditText edtInNum4 = (EditText) findViewById(R.id.edtInNum4);
        final EditText edtInNum5 = (EditText) findViewById(R.id.edtInNum5);
        final EditText edtInNum6 = (EditText) findViewById(R.id.edtInNum6);
        final LinearLayout ll = findViewById(R.id.ll);

        Button btnInsertAdd = (Button) findViewById(R.id.btnInsertAdd);
        Button btnInsertRefresh = (Button) findViewById(R.id.btnInsertRefresh);

        btnInsertRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll.removeAllViews();
            }
        });

        btnInsertAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num1 = Integer.parseInt(edtInNum1.getText().toString());
                int num2 = Integer.parseInt(edtInNum2.getText().toString());
                int num3 = Integer.parseInt(edtInNum3.getText().toString());
                int num4 = Integer.parseInt(edtInNum4.getText().toString());
                int num5 = Integer.parseInt(edtInNum5.getText().toString());
                int num6 = Integer.parseInt(edtInNum6.getText().toString());

                    EditText edtInNum = new EditText(getApplicationContext());
                    LinearLayout.LayoutParams p = new LinearLayout.LayoutParams
                            (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    edtInNum.setLayoutParams(p);
                    edtInNum.setText((edtInNum1).getText().toString());
                    edtInNum.setText((edtInNum2).getText().toString());
                    edtInNum.setText((edtInNum3).getText().toString());
                    edtInNum.setText((edtInNum4).getText().toString());
                    edtInNum.setText((edtInNum5).getText().toString());
                    edtInNum.setText((edtInNum6).getText().toString());

                    edtInNum.setId(num1);
                    edtInNum.setId(num2);
                    edtInNum.setId(num3);
                    edtInNum.setId(num4);
                    edtInNum.setId(num5);
                    edtInNum.setId(num6);

                    ll.addView(edtInNum);
                }
        });
    }
}
