package com.parassidhu.cdlumaths;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.SystemClock;
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

public class sem6 extends AppCompatActivity {

    private final String subject_names[] = {
            "Real and Complex Analysis",
            "Linear Algebra",
            "Dynamics",
            "Mathematical Modelling",
            "Mechanics",
            "Computer Graphics",
            "Programming In Java",
            "Download All"
    };

    public boolean showAds() {
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        boolean showAd = getPrefs.getBoolean("showAd", true);

        return showAd;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem6);
        setupView();
        initViews();

        sidhu.renderTheme(this);
        final AdView adView = this.findViewById(R.id.adView);
        if (showAds()){
            MobileAds.initialize(getApplicationContext(),"ca-app-pub-6089158898128407/9919503008");
            AdRequest adRequest = new AdRequest.Builder()

                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice("73CC8EA0F398EEC21B718FF0F9EB507A")
                    .addTestDevice("39C695F82AC6C82B1C9874FBBDCC2D46")
                    .build();

            adView.setAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(int i) {
                    super.onAdFailedToLoad(i);
                    adView.setVisibility(View.GONE);
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    adView.setVisibility(View.VISIBLE);
                }
            });

            adView.loadAd(adRequest);
        } else {
            adView.setVisibility(View.GONE);
        }

        final RecyclerView rcl = findViewById(R.id.card_recycler_view);
        ItemClickSupport.addTo(rcl).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                try {
                    MyApp m = (MyApp) getApplicationContext();
                    switch (position) {
                        case 0:     //Subject 1
                            m.getClickSem6(0);
                            registerForContextMenu(rcl.findFocus());
                            openContextMenu(v);
                            break;
                        case 1:     //Subject 2
                            m.getClickSem6(1);
                            registerForContextMenu(rcl.findFocus());
                            openContextMenu(v);
                            break;
                        case 2:
                            m.getClickSem6(2);
                            registerForContextMenu(rcl.findFocus());
                            openContextMenu(v);
                            break;
                        case 3:
                            m.getClickSem6(3);
                            registerForContextMenu(rcl.findFocus());
                            openContextMenu(v);
                            break;
                        case 4:
                            m.getClickSem6(4);
                            registerForContextMenu(rcl.findFocus());
                            openContextMenu(v);
                            break;
                        case 5:
                            m.getClickSem6(5);
                            registerForContextMenu(rcl.findFocus());
                            openContextMenu(v);
                            break;
                        case 6:
                            m.getClickSem6(6);
                            registerForContextMenu(rcl.findFocus());
                            openContextMenu(v);
                            break;
                        case 7:
                            m.getClickSem6(7);
                            registerForContextMenu(rcl.findFocus());
                            openContextMenu(v);
                            break;
                    }
                }catch (Exception ex){

                }
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sem6,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        MyApp m = (MyApp) getApplicationContext();
        String add="CDLU/sem6/2016/";
        String n="CDLU/sem6/2017/";
        int timeStamp = (int) System.currentTimeMillis();
        switch (item.getItemId()) {
            case R.id.download:
                switch (m.getit6()) {
                    case 0:
                        startDownload("Real and Complex Analysis (May 16).pdf",add+"RACA%28May16%29.pdf",1661);
                        starting();
                        break;
                    case 1:
                        startDownload("Linear Algebra (May 16).pdf",add+"LA%28May16%29.pdf",1662);
                        starting();
                        break;
                    case 2:
                        startDownload("Dynamics (May 16).pdf",add+"D%28May16%29.pdf",1663);
                        starting();
                        break;
                    case 3:
                        startDownload("Mathematical Modelling (May 16).pdf",add+"MM%28May16%29.pdf",1664);
                        starting();
                        break;
                    case 4:
                        startDownload("Mechanics (May 16).pdf",add+"Mech%28May16%29.pdf",1665);
                        starting();
                        break;
                    case 5:
                        startDownload("Computer Graphics (May 16).pdf",add+"CG%28May16%29.pdf",1666);
                        starting();
                        break;
                    case 6:
                        startDownload("Programming In Java (May 16).pdf",add+"PiJ%28May16%29.pdf",1667);
                        starting();
                        break;
                    case 7:
                        startDownload("MSc Maths 5-Year 6th Sem (May 16).pdf",add+"MSc%20Maths%206th%20Sem%20%28May%2016%29.pdf",1668);
                        starting();
                        break;
                }
                return true;
            case R.id.download2:
                starting();
                switch (m.getit6()){
                    case 0:
                        startDownload("Real and Complex Analysis (May 17).pdf",n+"RCA.pdf",timeStamp);
                        break;
                    case 1:
                        startDownload("Linear Algebra (May 17).pdf",n+"LA.pdf",timeStamp);
                        break;
                    case 2:
                        startDownload("Dynamics (May 17).pdf",n+"D.pdf",timeStamp);
                        break;
                    case 3:
                        startDownload("Mathematical Modelling (May 17).pdf",n+"MM.pdf",timeStamp);
                        break;
                    case 4:
                        startDownload("Mechanics (May 17).pdf",n+"Mech.pdf",timeStamp);
                        break;
                    case 5:
                        startDownload("Computer Graphics (May 17).pdf",n+"CG.pdf",timeStamp);
                        break;
                    case 6:
                        startDownload("Programming In Java (May 17).pdf",n+"PJ.pdf",timeStamp);
                        break;
                    case 7:
                        startDownload("MSc Maths 5-Year 6th Sem (May 17).pdf",n+"ALL.pdf",timeStamp);
                        break;
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void starting() {
        Toast.makeText(this, "Starting download...Please check notifications panel for progress", Toast.LENGTH_SHORT).show();
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

    public void startDownload(String filename, String url,int i){
        MyApp x =  (MyApp)getApplicationContext();
        x.getUrl(url);
        x.getFilename(filename);
        x.getID(i);
        Intent intent = new Intent(this,DownloadService.class);
        startService(intent);
    }
}
