package com.example.midtermretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;


import android.view.View;
import com.example.midtermretrofit.models.breeds;
import com.example.midtermretrofit.adapter.BreedAdapter;
import com.example.midtermretrofit.models.breedList;
import java.util.ArrayList;
import java.util.List;


import com.example.midtermretrofit.helper.CustomRVItemTouchListener;
import com.example.midtermretrofit.helper.RecyclerViewItemClickListener;


import com.example.midtermretrofit.reposervice.ApiService;
import com.example.midtermretrofit.retrofit.RetroClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<breeds> breedList;
    private RecyclerView recyclerContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerContacts = (RecyclerView) findViewById(R.id.recycledNames);

        loadData();
    }

    protected void loadData() {

        /**
         * Checking Internet Connection
         */

            final ProgressDialog dialog;

            /**
             * Progress Dialog for User Interaction
             */
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Getting JSON data");
            dialog.setMessage("Please wait...");
            dialog.show();

            //Creating an object of our api interface
            ApiService api = RetroClient.getApiService();

            /**
             * Calling JSON
             */
            Call<breedList> call = api.getBreeds();

            /**
             * Enqueue Callback will be call when get response...
             */
            call.enqueue(new Callback<breedList>() {



                @Override
                public void onFailure(Call<com.example.midtermretrofit.models.breedList> call, Throwable t) {

                    dialog.dismiss();
                }


                @Override
                public void onResponse(Call<com.example.midtermretrofit.models.breedList> call, Response<com.example.midtermretrofit.models.breedList> response) {


                    dialog.dismiss();

                    if(response.isSuccessful()) {

                        /**
                         * Got Successfully
                         */
                        // Log.d("LOGGG", "onResponse: " + response.body().getContacts());
                        breedList = response.body().getBreeds();


                        BreedAdapter adapter = new BreedAdapter(breedList, MainActivity.this);
                        recyclerContacts.setAdapter(new BreedAdapter(breedList, MainActivity.this));

                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerContacts.setLayoutManager(mLayoutManager);

                        /**
                         * Add listener to every recycler view items
                         */
                        recyclerContacts.addOnItemTouchListener(new CustomRVItemTouchListener(MainActivity.this, recyclerContacts, new RecyclerViewItemClickListener() {
                            @Override
                            public void onClick(View view, int position) {
                                Snackbar.make(findViewById(R.id.layoutMain), "onClick at position : " + position, Snackbar.LENGTH_LONG).show();

                            }

                            @Override
                            public void onLongClick(View view, int position) {
                                Snackbar.make(findViewById(R.id.layoutMain), "onLongClick at position : " + position, Snackbar.LENGTH_LONG).show();
                            }
                        }));

                    } else {
                        Snackbar.make(findViewById(R.id.layoutMain), "Something going wrong!", Snackbar.LENGTH_LONG).show();
                    }
                }



            });

    }
}