package com.example.allappsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = (TextView) findViewById(R.id.textViewResult);

        PackageManager pm = getPackageManager();
        int nonSysAppsCount=0;
        int systemAppsCount = 0;
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for(ApplicationInfo packageInfo:packages){
            if( pm.getLaunchIntentForPackage(packageInfo.packageName) != null ){
                String currAppName = pm.getApplicationLabel(packageInfo).toString();
                nonSysAppsCount++;
            }
            else{
                systemAppsCount++;
            }
        }

        textViewResult.setText("Non system apps: "+nonSysAppsCount+"\nSystem apps: "+systemAppsCount+"\nOverall: "+(systemAppsCount+nonSysAppsCount));

    }
}
