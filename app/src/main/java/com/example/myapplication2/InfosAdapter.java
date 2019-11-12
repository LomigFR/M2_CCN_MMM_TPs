package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class InfosAdapter extends RecyclerView.Adapter<InfosAdapter.InfosViewHolder> {

    Context context;
    List<Info> listOfInfos;

    public static class InfosViewHolder extends RecyclerView.ViewHolder{

        TextView key;
        TextView value;
        Button button;

        public InfosViewHolder(@NonNull View itemView) {
            super(itemView);
            this.key = itemView.findViewById(R.id.key);
            value = itemView.findViewById(R.id.value);
            button = itemView.findViewById(R.id.info_button);
        }

    }
    public InfosAdapter(Context context, List<Info> listOfInfos) {
        this.context = context;
        this.listOfInfos = listOfInfos;
    }

    @NonNull
    @Override
    public InfosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_info, parent, false);
        InfosViewHolder infosViewHolder = new InfosViewHolder(view);
        return infosViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InfosViewHolder holder, final int position) {
        Info info = listOfInfos.get(position);
        holder.key.setText(info.getKey());
        holder.value.setText(info.getValue());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listOfInfos.get(position).getKey()
                        + "\n"
                        + listOfInfos.get(position).getValue(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is your "
                        + listOfInfos.get(position).getKey()
                        + " : "
                        + listOfInfos.get(position).getValue(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfInfos.size();
    }
}
