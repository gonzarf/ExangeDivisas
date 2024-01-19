package com.example.divisas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DivisasModel> divisasModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerDivisas);
        setHistoricEventsModels();

        DivisasRVAdapter adapter = new DivisasRVAdapter(this, divisasModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setHistoricEventsModels(){
        String[] divisaNames = getResources().getStringArray(R.array.DIVISAS_Name);
        String[] divisaValue = getResources().getStringArray(R.array.DIVISAS_Precio);

        for (int i = 0; i < divisaNames.length;i++){
            divisasModels.add(new DivisasModel(
                    divisaNames[i],
                    divisaValue[i]
            ));
        }
    }
}