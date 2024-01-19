package com.example.divisas;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DivisasRVAdapter extends RecyclerView.Adapter<DivisasRVAdapter.MyViewHolder> {
    Context context;
    ArrayList<DivisasModel> divisasModels;

    public DivisasRVAdapter(Context context, ArrayList<DivisasModel> divisasModels) {
        this.context = context;
        this.divisasModels = divisasModels;
    }

    @NonNull
    @Override
    public DivisasRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new DivisasRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DivisasRVAdapter.MyViewHolder holder, int position) {
        holder.tvAbrev.setText(divisasModels.get(position).getDivisaAbrev());
        holder.tvValue.setText(divisasModels.get(position).getDivisaValor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.setBackgroundColor(Color.WHITE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return divisasModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvAbrev, tvValue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAbrev = itemView.findViewById(R.id.tvDivisaAbrev);
            tvValue = itemView.findViewById(R.id.tvDivisaValue);
        }
    }
}

