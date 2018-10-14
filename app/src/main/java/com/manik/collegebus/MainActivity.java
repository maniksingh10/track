package com.manik.collegebus;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.LocaleList;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    double lat, longi;
    private View parent;
    private RelativeLayout off;
    private DatabaseReference appinfo;

    private ProgressBar progressBar;
    private int stime;
    private int ttime;
    private String versionName;
    private String state;
    private String quote;
    private TextView alertyv;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = findViewById(R.id.root);
        off = findViewById(R.id.offview);
        appinfo = FirebaseDatabase.getInstance().getReference("AppInfo");
        alertyv = findViewById(R.id.alerttv);
        progressBar = findViewById(R.id.wait);

        if(isNetworkAvailable()){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            parent.setVisibility(View.GONE);
            off.setVisibility(View.VISIBLE);
            alertyv.setText("Hey, It looks Like you are Offline \n :(");
        }

        appinfo.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    MyInfo myInfo = snapshot.getValue(MyInfo.class);
                    stime = myInfo.getStart();
                    ttime = myInfo.getTill();
                    state = myInfo.getState();
                    quote = myInfo.getQuote();
                    versionName=myInfo.getVer();
                }
                progressBar.setVisibility(View.GONE);
                CheckAppInfo();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });




    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void CheckAppInfo() {
        String currentDateAndTime = new SimpleDateFormat("HHmm", Locale.getDefault()).format(new Date());
        time = Integer.parseInt(currentDateAndTime);
        String vename= BuildConfig.VERSION_NAME;

        Log.d("cjeck", String.valueOf(time)+String.valueOf(stime) + String.valueOf(ttime) +state + versionName);

        if(versionName.equals(vename)){
            if (time >= stime && time < ttime && state.equals("on")) {
                off.setVisibility(View.GONE);
                parent.setVisibility(View.VISIBLE);
                Snackbar.make(parent, "Thankssss!!! It means a lot :)", Snackbar.LENGTH_SHORT).show();
                FloatingActionButton button = findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent);
                    }
                });
                MessageFragment messageFragment = new MessageFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.msg_container, messageFragment)
                        .commit();
            }
            else {
                parent.setVisibility(View.GONE);
                off.setVisibility(View.VISIBLE);
                alertyv.setText("App is Closed! \n \nPlease Come Back between 6:30AM - 9:00AM \n \n ");
            }
        }
        else {
            parent.setVisibility(View.GONE);
            off.setVisibility(View.VISIBLE);
            alertyv.setText("New Version of the app is available. \n Update it from the link \n \nhttps://drive.google.com/open?id=1iHaioe1kJ1wzKmb8UiS4s2Z8TguO5b5M ");
            Linkify.addLinks(alertyv, Linkify.WEB_URLS);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                // do something
                Intent intent = new Intent(MainActivity.this, AboutMe.class);
                startActivity(intent);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
