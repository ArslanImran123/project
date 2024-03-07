package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.recyclerview.Adapters.RecepieAdapter;
import com.example.recyclerview.Classes.RecyclerItemClickListener;
import com.example.recyclerview.models.Main3Activity;
import com.example.recyclerview.models.RecipieClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        ArrayList<RecipieClass> list=new ArrayList<>();
        list.add(new RecipieClass(R.drawable.food,"Chicken Minchorian"));
        list.add(new RecipieClass(R.drawable.food1,"Karhai"));
        list.add(new RecipieClass(R.drawable.food3,"Chicken Gingar"));
        list.add(new RecipieClass(R.drawable.food,"Chicken"));
        list.add(new RecipieClass(R.drawable.food,"Chicken Fajita"));
        list.add(new RecipieClass(R.drawable.food,"Burger"));
        list.add(new RecipieClass(R.drawable.food,"Burger"));
        list.add(new RecipieClass(R.drawable.food,"Burger"));

        RecepieAdapter adapter=new RecepieAdapter(list,this);
        recyclerView.setAdapter(adapter);
// vertical show show
        //LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);

        // Horizontally show
        // LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //recyclerView.setLayoutManager(layoutManager);
//grid show
        // GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        //recyclerView.setLayoutManager(gridLayoutManager);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(MainActivity.this, Main3Activity.class);
                        startActivity(intent);

                        break;

                    case 1:
                        Toast.makeText(MainActivity.this,"Second Item is Clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this,"Second Item is Clicked",Toast.LENGTH_SHORT).show();
                        break;

                    default:
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this,"Get 10% discount.",Toast.LENGTH_SHORT).show();

                        break;

                    default:
                }

            }
        }));
    }
}
