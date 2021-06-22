package tech.hamimitbd.shikkha;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // admob add
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        // admob add



        RecyclerView recyclerView = findViewById(R.id.recyclerview_contain_id);
        ArrayList<String> name = new ArrayList<>(Arrays.asList("MES", "MEP", "UGC", "DGS", "DGP", "DCP",
                "DG-Tec", "Board All", "Institute Registration"));
        ArrayList<Integer> icon = new ArrayList<>(Arrays.asList(R.drawable.mes_icon, R.drawable.mes_icon,
                R.drawable.mes_icon, R.drawable.mes_icon,
                R.drawable.mes_icon, R.drawable.mes_icon,
                R.drawable.mes_icon, R.drawable.mes_icon,
                R.drawable.reg_icon));

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, name, icon);
        recyclerView.setAdapter(customAdapter);

    }
}