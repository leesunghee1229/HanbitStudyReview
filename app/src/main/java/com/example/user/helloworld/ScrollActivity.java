package com.example.user.helloworld;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ScrollActivity extends AppCompatActivity {

    private ImageView mImgView;
    private int mImageCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);


        Toast.makeText(this, R.string.btnImageChange, Toast.LENGTH_LONG).show();
//        String aa = getResources().getString(R.string.btnImageChange);

        Button btnChange = (Button) findViewById(R.id.btnChange);
        mImgView = (ImageView) findViewById(R.id.imageView);

        btnChange.setOnClickListener(btnClickMeClick2);
    }

    /**
     * 큰용량 이미지 버튼
     */
    private View.OnClickListener btnClickMeClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {
                BitmapDrawable bmp = null;
                int bmpW = 0, bmpH = 0;

                if(bmp != null) {
                    bmp = null;
                }

                int DrawableImg = R.drawable.img_big1;

                switch (mImageCounter) {
                    case 0:
                        DrawableImg = R.drawable.img_big1;
                        break;
                    case 1:
                        DrawableImg = R.drawable.img_big2;
                        break;
                    case 2:
                        DrawableImg = R.drawable.img_big3;
                        break;
                    case 3:
                        DrawableImg = R.drawable.img_big4;
                        break;
                    case 4:
                        DrawableImg = R.drawable.img_big5;
                        break;
                    default:
                        break;
                }

                Display display = getWindowManager().getDefaultDisplay();
                int displayWidth = display.getWidth();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;

                BitmapFactory.decodeResource(getResources(), DrawableImg, options);

                int width = options.outWidth;
                if (width > displayWidth) {
                    int widthRatio = Math.round((float) width / (float) displayWidth);
                    options.inSampleSize = widthRatio;
                }

                options.inJustDecodeBounds = false;
                Bitmap scaledBitmap =  BitmapFactory.decodeResource(getResources(),DrawableImg, options);
                mImgView.setImageBitmap(scaledBitmap);

                // 불러온 이미지의 가로, 세로 너비를 구한다.
                bmpW = scaledBitmap.getWidth();
                bmpH = scaledBitmap.getWidth();

                mImgView.getLayoutParams().width = bmpW;
                mImgView.getLayoutParams().height = bmpH;

                mImageCounter++;

                if (mImageCounter > 4) {
                    mImageCounter = 0;
                }
            } catch (OutOfMemoryError error) {
                Log.e("TEST", error.toString());
            }
        }

    };

    public static Bitmap decodeSampledBitmapFromResource(Resources res, String resId, int    reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(resId, options);

        // Calculate inSampleSize
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
//        options.inPreferredConfig = Config.RGB_565;
        options.inDither = true;
        return BitmapFactory.decodeFile(resId, options);
    }


    private View.OnClickListener btnClickMeClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {
                BitmapDrawable bmp = null;
                int bmpW = 0, bmpH = 0;

                if(bmp != null) {
                    bmp = null;
                }

                switch (mImageCounter) {
                    case 0:
                        bmp = (BitmapDrawable) getResources().getDrawable(R.drawable.img_big1);
                        break;
                    case 1:
                        bmp = (BitmapDrawable) getResources().getDrawable(R.drawable.img_big3);
                        break;
                    case 2:
                        bmp = (BitmapDrawable) getResources().getDrawable(R.drawable.img_big3);
                        break;
                    case 3:
                        bmp = (BitmapDrawable) getResources().getDrawable(R.drawable.img_big4);
                        break;
                    case 4:
                        bmp = (BitmapDrawable) getResources().getDrawable(R.drawable.img_big5);
                        break;
                    default:
                        break;
                }

                // 불러온 이미지의 가로, 세로 너비를 구한다.
                bmpW = bmp.getIntrinsicWidth();
                bmpH = bmp.getIntrinsicHeight();

                mImageCounter++;

                if (mImageCounter > 4) {
                    mImageCounter = 0;
                }

                mImgView.setImageDrawable(bmp);
                mImgView.getLayoutParams().width = bmpW;
                mImgView.getLayoutParams().height = bmpH;


            } catch (OutOfMemoryError error) {
                Log.e("TEST", error.toString());
            }
        }

    };

}
