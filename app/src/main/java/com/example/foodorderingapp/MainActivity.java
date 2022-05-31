package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

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

        list.add(new MainModel(R.drawable.burger, "Burger","30","Filled with potato patties and fresh sauce"));
        list.add(new MainModel(R.drawable.pizza, "Pizza","100","Filled with potato patties and fresh sauce"));
        list.add(new MainModel(R.drawable.pasta, "Pasta","60","Filled with potato patties and fresh sauce"));
        list.add(new MainModel(R.drawable.chillypotato, "Chilly Potato","70","Filled with potato patties and fresh sauce"));
        list.add(new MainModel(R.drawable.paneertikka, "Paneer Tikka","120","Filled with potato patties and fresh sauce"));
        list.add(new MainModel(R.drawable.pastry, "Pastry","25","Filled with potato patties and fresh sauce"));

        MainAdapters adapters=new MainAdapters(list,this);
        binding.RecyclerView.setAdapter(adapters);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.RecyclerView.setLayoutManager(linearLayoutManager);
    }
}