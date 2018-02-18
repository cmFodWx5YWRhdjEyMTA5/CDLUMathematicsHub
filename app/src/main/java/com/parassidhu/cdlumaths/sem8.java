package com.parassidhu.cdlumaths;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class sem8 extends AppCompatActivity {

    private final String subject_names[] = {
            "Advanced Abstract Algebra-II",
            "Measure and Integration Theory",
            "Computer Programming",
            "Complex Analysis-II",
            "Ordinary Differential Equations-II",
            "Download All"
    };
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem8);
        setupView();
        initViews();
        
        sidhu.renderTheme(this);
        AdView adView = this.findViewById(R.id.adView);
        sidhu.displayAds(this,adView);
        
        final RecyclerView rcl = findViewById(R.id.card_recycler_view);
        ItemClickSupport.addTo(rcl).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                try {
                    MyApp m = (MyApp) getApplicationContext();
                    m.getClickSem8(position);
                    registerForContextMenu(rcl.findFocus());
                    openContextMenu(v);
                }catch (Exception ex){}
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sem8,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        MyApp m = (MyApp) getApplicationContext();
        String add="CDLU/sem8/2016/";
        switch (item.getItemId()) {
            case R.id.download:
                switch (m.getit8()) {
                    case 0:
                        sidhu.startDownload("Advanced Abstract Algebra-II (May 16).pdf",
                                add+"AAA2%28May16%29.pdf",this);
                        break;
                    case 1:
                        sidhu.startDownload("Measure and Integration Theory (May 16).pdf",
                                add+"MaIT%28May16%29.pdf",this);
                        break;
                    case 2:
                        sidhu.startDownload("Computer Programming (May 16).pdf",
                                add+"CP%28May16%29.pdf",this);
                        break;
                    case 3:
                        sidhu.startDownload("Complex Analysis-II (May 16).pdf",
                                add+"CA2%28May16%29.pdf",this);
                        break;
                    case 4:
                        sidhu.startDownload("Ordinary Differential Equations-II (May 16).pdf",
                                add+"ODE2%28May16%29.pdf",this);
                        break;
                    case 5:
                        sidhu.startDownload("MSc Maths 5-Year 8th Sem (May 16).pdf",
                                add+"MSc%20Maths%208th%20Sem%20%28May%2016%29.pdf",this);
                        break;
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    
    public void setupView() {
        android.support.v7.app.ActionBar acb = getSupportActionBar();
        acb.setHomeButtonEnabled(true);
        acb.setDisplayHomeAsUpEnabled(true);
        acb.setTitle("Choose Subject");
    }
    
    private void initViews(){
        RecyclerView recyclerView = findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        QueAdapter adapter = new QueAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);
    }
    
    private ArrayList prepareData(){
        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<subject_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(subject_names[i]);
            androidVersion.setAndroid_image_url(R.drawable.materialq);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
