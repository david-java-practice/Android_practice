package com.example.ch07_dialog_login;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    TextView tvName, tvEmail;
    EditText edt1, edt2;
    Button button1;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;//중요~ 응용을 많이 해야함

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

//        tvName = (TextView) findViewById(R.id.tvName);
//        tvEmail = (TextView) findViewById(R.id.tvEmail);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);

        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //1.뷰만들기
                dialogView = (View) View.inflate(
                                        MainActivity.this,
                                        R.layout.dialog1,
                                        null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(
                        MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);

                //2.뷰 꽂기, 확장한(inflate) 뷰를 꽂는다!
                dlg.setView(dialogView);

                EditText dlg_edt1;
                EditText dlg_edt2;

                //3.뷰 안에 위젯 가져와서 바인딩
                dlg_edt1 = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                dlg_edt2 = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                dlg_edt1.setText(str1);
                dlg_edt2.setText(str2);


                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dlgEdtName = (EditText) dialogView
                                        .findViewById(R.id.dlgEdt1);
                                dlgEdtEmail = (EditText) dialogView
                                        .findViewById(R.id.dlgEdt2);

                                edt1.setText(dlgEdtName.getText().toString());
                                edt2.setText(dlgEdtEmail.getText()
                                        .toString());
                                // dlgLayout = null;
                            }
                        });

                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast toast = new Toast(MainActivity.this);

                                Display dis = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                                int xOffset = (int)(Math.random() * dis.getWidth());
                                int yOffset = (int)(Math.random() * dis.getHeight());

                                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);

                                //1.뷰만들기
                                toastView = (View) View.inflate(
                                        MainActivity.this,
                                        R.layout.toast1, null);
                                toastText = (TextView) toastView
                                        .findViewById(R.id.toastText1);
                                toastText.setText("취소했습니다");
                                //2.뷰 꽂기
                                toast.setView(toastView);
                                toast.show();
                            }
                        });
                dlg.show();

            }
        });

    }
}
