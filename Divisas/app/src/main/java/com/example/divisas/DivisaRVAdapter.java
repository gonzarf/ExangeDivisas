package com.example.divisas;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DivisaRVAdapter extends RecyclerView.Adapter<DivisaRVAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<DivisasModel> divisaModels;

    public DivisaRVAdapter(Context context, ArrayList<DivisasModel> divisaModels){
        this.context = context;
        this.divisaModels = divisaModels;
    }

    @NonNull
    @Override
    public DivisaRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent,false);
        return new DivisaRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DivisaRVAdapter.MyViewHolder holder, int position) {
        DivisasModel currentDivisa = divisaModels.get(position);

        holder.tvAbrev.setText(currentDivisa.getDivisaAbrev());
        holder.tvValor.setText(currentDivisa.getDivisaValor());


        // Si el atributo clicked es true cambia el color, si no, lo devuelve a su color original
        if (currentDivisa.getClicked()) {
            holder.itemView.setBackgroundColor(Color.parseColor("#6A7B91"));
            MainActivity.valor = Double.parseDouble(holder.tvValor.getText().toString());
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#778da9"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Ponemos todos los atributos clicked en false para que al clickar uno nuevo el anterior no esta clickado.

                for (DivisasModel divisa : divisaModels) {
                    divisa.setClicked(false);
                }

                currentDivisa.setClicked(true);

                // Notificamos que los datos han cambiado.

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return divisaModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvAbrev, tvValor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvAbrev = itemView.findViewById(R.id.tvDivisaAbrev);
            this.tvValor = itemView.findViewById(R.id.tvDivisaValue);
        }
    }
}
