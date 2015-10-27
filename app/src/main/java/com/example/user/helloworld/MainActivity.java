package com.example.user.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);


    }

    public void btnClickScrollView(View view) {
        Intent intent = new Intent(getBaseContext(),ScrollActivity.class);
        startActivity(intent);
    }
    public void btnClickScrollList(View view) {
        Intent intent = new Intent(getBaseContext(),ListActivity.class);
        startActivity(intent);
    }
    public void btnClickInflate(View view) {
        Intent intent = new Intent(getBaseContext(),InflateActivity.class);
        startActivity(intent);
    }
    public void btnClickDataResult(View view) {
        Intent intent = new Intent(getBaseContext(),DataActivityResult.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();


        // 전체 패키지명
//        PackageManager pm = this.getPackageManager();
//
//        List<PackageInfo> packs = getPackageManager().getInstalledPackages(PackageManager.PERMISSION_GRANTED);
//
//        for (PackageInfo pack : packs) {
//            Log.i("TEST", pack.applicationInfo.loadLabel(pm).toString());
//            Log.i("TEST", pack.packageName);
//        }
    }

}
