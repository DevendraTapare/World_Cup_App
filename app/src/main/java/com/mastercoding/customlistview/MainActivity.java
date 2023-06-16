package com.mastercoding.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter adapter;
    ArrayList<CountryModelClass> dataModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1- AdapterView: a listView
        listView = findViewById(R.id.listview);

        // 2- Data source
        dataModels = new ArrayList<>();

        dataModels.add(new CountryModelClass("brazil","5", R.drawable.brazil));
        dataModels.add(new CountryModelClass("Germany","4",R.drawable.germany));
        dataModels.add(new CountryModelClass("France","2",R.drawable.france));
        dataModels.add(new CountryModelClass("Spain","1",R.drawable.spain));
        dataModels.add(new CountryModelClass("England","1",R.drawable.unitedkingdom));
        dataModels.add(new CountryModelClass("United States","0",R.drawable.unitedstates));
        dataModels.add(new CountryModelClass("Saudi Arabia","0",R.drawable.saudiarabia));



        // 3- Adapter
        adapter = new CustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);



        // 4- Handling the click events on Listview items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Country " + adapter.getItem(i).getCountry_name() +"\n"+
                        "World Cups wins: "+adapter.getItem(i).getCup_win_count(),
                        Toast.LENGTH_SHORT).show();
            }
        });



    }


}