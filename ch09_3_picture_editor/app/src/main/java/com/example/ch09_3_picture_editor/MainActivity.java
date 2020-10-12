package com.example.ch09_3_picture_editor;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibGray;
    ImageButton ibBlur, ibEmboss;
    MyGraphicView graphicView;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
//    static float color = 1;
//    static float satur = 1;
    static float saturation = 1;
    static boolean bBlur = false;
    static boolean bEmboss = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private void clickIcons()
    {
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });

        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //color = color + 0.2f;
                saturation = saturation + 20.0f;
                graphicView.invalidate();
            }
        });

        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //color = color - 0.2f;
                saturation = saturation - 20.0f;
                graphicView.invalidate();
            }
        });

        ibBlur = (ImageButton) findViewById(R.id.ibBlur);
        ibBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ///???
                if(bBlur == true)
                    bBlur = false;
                else if(bBlur == false)
                    bBlur = true;

                graphicView.invalidate();

            }
        });

        ibEmboss = (ImageButton) findViewById(R.id.ibEmboss);
        ibEmboss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //???
                if(bEmboss == true)
                    bEmboss = false;
                else if(bEmboss == false)
                    bEmboss = true;

                graphicView.invalidate();
            }
        });


//        ibGray = (ImageButton) findViewById(R.id.ibGray);
//        ibGray.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (satur == 0)
//                    satur = 1;
//                else
//                    satur = 0;
//                graphicView.invalidate();
//            }
//        });

    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
//            float[] array = { color,    0,      0, 0, 0,
//                                0,  color,      0, 0, 0,
//                                0,      0, color,  0, 0,
//                                0,      0,      0, 1, 0 };
//            ColorMatrix cm = new ColorMatrix(array);
            ColorMatrix cm = new ColorMatrix();
            cm.setSaturation(saturation);
            //그레이스케일에서 조절( 흑백으로 만들기)
//            if (satur == 0)
//                cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            //1.Blur 필터 적용코드
            if(bBlur)
            {
                BlurMaskFilter blurMask;
                blurMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(blurMask);
            }

            //2.Embossing 필터 적용코드
            if(bEmboss)
            {
                EmbossMaskFilter embossMask;
                float direction[] = new float[]{3.0f, 3.0f, 3.0f};
                embossMask = new EmbossMaskFilter(new float[]{3.0f, 3.0f, 3.0f}, 0.7f, 5, 20);
                paint.setMaskFilter(embossMask);
            }

//

            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.lena256);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }
}
