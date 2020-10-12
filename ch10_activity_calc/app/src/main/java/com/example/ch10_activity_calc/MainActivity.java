package com.example.ch10_activity_calc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        android.util.Log.i("act", "1111");

        final RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                android.util.Log.i("act", "2222");

                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);

                Intent intent = new Intent(getApplicationContext(),
                                            MainActivity2.class);
                intent.putExtra("Num1",
                        Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",
                        Integer.parseInt(edtNum2.getText().toString()));

                switch (rg1.getCheckedRadioButtonId())
                {
                    case R.id.rdo1:
                        intent.putExtra("Operator", "+");
                        break;
                    case R.id.rdo2:
                        intent.putExtra("Operator", "-");
                        break;
                    case R.id.rdo3:
                        intent.putExtra("Operator", "*");
                        break;
                    case R.id.rdo4:
                        intent.putExtra("Operator", "/");
                        break;
                    default:

                        break;

                }


                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "합계 :" + hap,
                    Toast.LENGTH_SHORT).show();
        }

    }

}
