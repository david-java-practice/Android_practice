package com.example.ch11_3_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);

//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                midList);

        MyGridAdapter gAdapter = new MyGridAdapter(this);
//
//
        gv.setAdapter(gAdapter);
    }

    class MyGridAdapter extends BaseAdapter
    {
        Activity act;

        public MyGridAdapter(Activity act)
        {
            this.act = act;
        }

        //1.멤버변수(필드)
        Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
                            R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                            R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
                            R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
                            R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
                            R.drawable.mov10 };

        String[] posterTitle = { "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자",
                "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처", "써니", "완득이", "괴물", "라디오스타",
                "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처", "써니", "완득이",
                "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이",
                "빽투더퓨처", "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드",
                "웰컴투동막골", "헬보이", "빽투더퓨처" };


        //2.생성자
        //3.메소드
        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView iv1 = new ImageView(act);
            iv1.setLayoutParams(new AdapterView.LayoutParams(100,150));
            iv1.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv1.setPadding(5,5,5,5);
            iv1.setImageResource(posterID[position]);

            final int pos = position;

            iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    View v1 = (View) View.inflate(act, R.layout.dialog, null);

                    AlertDialog.Builder dialog = new AlertDialog.Builder(act);
                    ImageView iv_popup = (ImageView) v1.findViewById(R.id.ivPoster);
                    iv_popup.setImageResource(posterID[pos]);

                    dialog.setTitle(posterTitle[pos]);
                    dialog.setIcon(R.drawable.movie_icon);
                    dialog.setView(v1);
                    dialog.setNegativeButton("닫기",null);
                    dialog.show();

                }
            });

            return iv1;
        }
    }

//    public class MyGridAdapter extends BaseAdapter {
//        Context context;
//
//        public MyGridAdapter(Context c) {
//            context = c;
//        }
//
//        public int getCount() {
//            return posterID.length;
//        }
//
//        public Object getItem(int position) {
//            // TODO Auto-generated method stub
//            return null;
//        }
//
//        public long getItemId(int position) {
//            // TODO Auto-generated method stub
//            return 0;
//        }
//
//        Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
//                R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
//                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
//                R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
//                R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
//                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
//                R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
//                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
//                R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
//                R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
//                R.drawable.mov10 };
//
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ImageView imageview = new ImageView(context);
//            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
//            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageview.setPadding(5, 5, 5, 5);
//
//            imageview.setImageResource(posterID[position]);
//
//            final int pos = position;
//            imageview.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    View dialogView = (View) View.inflate(
//                            MainActivity.this, R.layout.dialog, null);
//                    AlertDialog.Builder dlg = new AlertDialog.Builder(
//                            MainActivity.this);
//                    ImageView ivPoster = (ImageView) dialogView
//                            .findViewById(R.id.ivPoster);
//                    ivPoster.setImageResource(posterID[pos]);
//                    dlg.setTitle("큰 포스터");
//                    dlg.setIcon(R.drawable.ic_launcher);
//                    dlg.setView(dialogView);
//                    dlg.setNegativeButton("닫기", null);
//                    dlg.show();
//                }
//            });
//
//            return imageview;
//        }
//
//    }
}
