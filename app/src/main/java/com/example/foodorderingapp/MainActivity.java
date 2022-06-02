package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderingapp.Adapters.MainAdapters;
import com.example.foodorderingapp.Models.MainModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();

        list.add(new MainModel(R.drawable.burger, "Burger","30","Filled with potato patties and fresh sauces"));
        list.add(new MainModel(R.drawable.pizza, "Pizza","100","Crisp base with fresh sauces and toppings"));
        list.add(new MainModel(R.drawable.pasta, "Pasta","60","Creamy pasta with fresh sauce and veggies"));
        list.add(new MainModel(R.drawable.chillypotato, "Chilly Potato","70","Crisp and spicy potatoes cooked in fresh sauce"));
        list.add(new MainModel(R.drawable.paneertikka, "Paneer Tikka","120","Crisp paneer with fresh marination"));
        list.add(new MainModel(R.drawable.pastry, "Pastry","25","Fresh from the bakery with elegant pineapple taste"));

        MainAdapters adapters=new MainAdapters(list,this);
        binding.RecyclerView.setAdapter(adapters);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.RecyclerView.setLayoutManager(linearLayoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}