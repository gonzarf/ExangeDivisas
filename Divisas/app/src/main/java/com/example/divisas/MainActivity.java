package com.example.divisas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DivisasModel> divisasModels = new ArrayList<>();

    public static double valor;

    public double cambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerDivisas);
        Switch vip = findViewById(R.id.switchVip);

        // TextInputLayout entrada de cantidad a cambiar
        TextInputLayout tiEuros = findViewById(R.id.etAmount);
        EditText etEuros = tiEuros.getEditText();

        // Imagen clickable para realizar el cambio
        ImageView btn_cambio = findViewById(R.id.exchangeButton);

        //TextInputLayout donde se muenstra el resultado (Se le ha quitado que sea clickable )
        TextInputLayout tiResultado = findViewById(R.id.tvResultado);
        EditText etResultado = tiResultado.getEditText();

      setHistoricEventsModels();

      DivisaRVAdapter adapter = new DivisaRVAdapter(this, divisasModels);

      recyclerView.setAdapter(adapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));

      btn_cambio.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Double euros = Double.parseDouble(etEuros.getText().toString());


              if(vip.isChecked()){

                  cambio = valor * euros;
                  etResultado.setText(cambio + "");


              }else{

                  cambio = valor * 0.98 * euros;
                  etResultado.setText(cambio + "");

              }
          }
      });





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