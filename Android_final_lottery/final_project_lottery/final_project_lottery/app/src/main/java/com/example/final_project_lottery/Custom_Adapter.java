package com.example.final_project_lottery;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project_lottery.Network.NetworkDelete;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<NumberInfo> mNumberInfoObjArr;
    int mListLayout;

    public Custom_Adapter(Activity a, int listLayout, ArrayList<NumberInfo> numberInfoObjArrayListT){
        mAct = a;
        mListLayout = listLayout;
        mNumberInfoObjArr = numberInfoObjArrayListT;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<NumberInfo> arrayList){
        mNumberInfoObjArr = arrayList;
    }
    @Override
    public int getCount() {
        return mNumberInfoObjArr.size();
    }

    @Override
    public Object getItem(int i) {
        return mNumberInfoObjArr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view = mInflater.inflate(mListLayout, viewGroup, false);

        final TextView tv_num1 = (TextView) view.findViewById(R.id.tv_num1);
        tv_num1.setTag(mNumberInfoObjArr.get(i).num1);

        final TextView tv_num2 = (TextView) view.findViewById(R.id.tv_num2);
        tv_num2.setTag(mNumberInfoObjArr.get(i).num2);

        final TextView tv_num3 = (TextView) view.findViewById(R.id.tv_num3);
        tv_num3.setTag(mNumberInfoObjArr.get(i).num3);

        final TextView tv_num4 = (TextView) view.findViewById(R.id.tv_num4);
        tv_num4.setTag(mNumberInfoObjArr.get(i).num4);

        final TextView tv_num5 = (TextView) view.findViewById(R.id.tv_num5);
        tv_num5.setTag(mNumberInfoObjArr.get(i).num5);

        final TextView tv_num6 = (TextView) view.findViewById(R.id.tv_num6);
        tv_num6.setTag(mNumberInfoObjArr.get(i).num6);

        final TextView tv_writeTime = (TextView) view.findViewById(R.id.tv_writeTime);
        tv_writeTime.setTag(mNumberInfoObjArr.get(i).writeTime);


        Button btnDelete = (Button) view.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = tv_num1.getText().toString();
                AlertDialog.Builder ad = new AlertDialog.Builder(mAct);
                ad.setTitle("삭제하기");
                ad.setMessage("번호를 정말 삭제하시겠습니까?");

                ad.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        new NetworkDelete(Custom_Adapter.this).execute(tv_num1.getText().toString());
                    }
                });

                ad.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(mAct, "취소하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();
            }
        });

        return view;
    }
}
