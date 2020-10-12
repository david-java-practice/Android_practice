package com.example.ch12_02_sqlite_groubdb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1.DB 헬퍼~ -> DDL -> 정의(DDL)->(Create, Drop, Alter) - Definition
    MyDBHelper myHelper;

    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect;
    Button btnUpdate, btnDelete;

    //2.LiteDB 클래스 -> 조작(DML)->select, insert, update, delete -> Manipulation
    SQLiteDatabase sqlDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        //이 줄에서, 객체가 만들어지면, 1.DB만들고, 2.테이블 만든다!
        myHelper = new MyDBHelper(this);

        //이벤트1 -> 초기화
        btnInit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //헬퍼 객체에서 -> DB객체를 얻어온다
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2); // 인수는 아무거나 입력하면 됨.
                sqlDB.close();
            }
        });

        //이벤트2 -> 입력(insert) -> 특징:execSQL()메소드를 사용한다.
        btnInsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                        + edtName.getText().toString() + "' , "
                        + edtNumber.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //이벤트3 -> 수정(update) -> 특징:execSQL()메소드를 사용한다.
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                sqlDB = myHelper.getWritableDatabase();

                String query = "";
                query =  " update ";
                query += "        groupTBL ";
                query += " set ";
                query += "       gNumber = " + edtNumber.getText().toString();
                query += " where ";
                query += "       gName = '" + edtName.getText().toString() + "';";

                sqlDB.execSQL(query);

                sqlDB.close();
                Toast.makeText(getApplicationContext(), "수정됨",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //이벤트4 -> 삭제(delete) -> 특징:execSQL()메소드를 사용한다.
        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL(" delete from groupTBL where gName = '"+edtName.getText().toString()+"';");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "삭제됨",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //이벤트5 -> 조회(select)
        // -> 특징1:rawQuery()메소드를 사용한다
        // -> 특징2: 조회기 때문에 커서(Cursor)객체를 사용한다.
        btnSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strNames = "그룹이름" + "\r\n" + "--------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "--------" + "\r\n";

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }
        });

    }

    public class MyDBHelper extends SQLiteOpenHelper {

        //1.생성자 -> 액티비티(context) 받아서, <DB이름> 설정
        public MyDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db)//2.테이블 만들기(DB이름 아님!)
        {
            db.execSQL("CREATE TABLE  groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }

        @Override //3.테이블 재생성
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");//일단 삭제 후
            onCreate(db);//생성 (create table..._
        }
    }
}
