package com.rsudalihsan.ibs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.rsudalihsan.ibs.R;
import com.rsudalihsan.ibs.activity.profiluser.LoginActivity;
import com.rsudalihsan.ibs.rest.ApiClient;
import com.rsudalihsan.ibs.rest.ApiInterface;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiService;

    private SwipeRefreshLayout swiperefreshlayout;
    private CarouselView carouselView;
    private GridLayout mainGrid;
    private final ArrayList<Integer> images = new ArrayList<>();
    private final int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};

    private ImageView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        carouselView = findViewById(R.id.carouselView);
        mainGrid = findViewById(R.id.mainGrid);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        setSingleEvent(mainGrid);
        user = findViewById(R.id.user);

    }

    ImageListener imageListener = (position, imageView) -> {
        imageView.setImageResource(sampleImages[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    };

    public void LoginActivity(View view) {
        Intent LoginActivityIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(LoginActivityIntent);
    }




    private void setSingleEvent(GridLayout mainGrid) {



        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Toast.makeText(getApplicationContext(), "position="+finalI, Toast.LENGTH_SHORT).show();

                    if(finalI == 1) {
                        Intent intent = new Intent(MainActivity.this, JadwalDokterActivity.class);
                        intent.putExtra("info", "This is activity from card item index  " + finalI);
                        startActivity(intent);
                    }
                    if(finalI == 5){
                        Intent intent = new Intent(MainActivity.this,PusatBantuanActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                    if(finalI == 6){
                        Intent intent = new Intent(MainActivity.this,IbsActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }

                }
            });


        }
    }
}