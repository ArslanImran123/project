package com.example.recyclerview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.models.RecipieClass;

import java.util.ArrayList;

public class RecepieAdapter extends RecyclerView.Adapter<RecepieAdapter.viewHolder>{
    ArrayList<RecipieClass> list;
    Context context;

    public RecepieAdapter(ArrayList<RecipieClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rv_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        RecipieClass model=list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());

        //holder.imageView.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Toast.makeText(context,"Item is clicked",Toast.LENGTH_SHORT).show();
            //}
        //});
        switch (position){
            case 0:
                holder.imageView.setOnClickListener(new  View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Image one is clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Add your own Feature",Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case 1:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Image Two is clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"Add your desired Feature",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
