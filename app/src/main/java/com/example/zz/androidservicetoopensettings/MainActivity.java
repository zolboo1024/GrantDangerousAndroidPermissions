package com.example.zz.androidservicetoopensettings;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.Duration;
/**
 * Created by Zolboo Erdenebaatar
 * 11/18/2018
 * This is an example android application that checks lets your app
 * check if a "Dangerous" permissions are granted and if not,
 * it takes the users to the settings so that they can grant it.
 * This is specifically for permissions that can't be granted
 * through the app itself.
 */
public class MainActivity extends AppCompatActivity {
    private static Intent intentForOpenSettingsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Button start = (Button) findViewById(R.id.startButton);
        start.setOnClickListener(new View.OnClickListener() {
            /**
             * Here, we create a button and tells asks the user if they WANT to
             * grant the permission that the app needs. Usage_Stats is used for example
             * here, but you can use any permission that Can't be granted by the user
             * through the app. E.g. the permissions that Users THEMSELVES has to open
             * the settings and grant the permission for.
             */
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setTitle("Permission for your phone Usage Stats needed")
                        .setMessage("This permission is needed help us track and block your phone activities. Please press Ok to go to the settings and allow the access.")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                intentForOpenSettingsService = new Intent(getApplicationContext(), OpenSettingsService.class);
                                startService(intentForOpenSettingsService);
                                Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create().show();
            }
        });

    }
}

