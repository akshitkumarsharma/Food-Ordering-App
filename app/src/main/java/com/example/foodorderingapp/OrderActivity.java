package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodorderingapp.Adapters.OrdersAdapter;
import com.example.foodorderingapp.Models.OrdersModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;
import com.example.foodorderingapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list=new ArrayList<>();
        list.add(new OrdersModel(R.drawable.burger,"Burger","30","45213"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","30","45213"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","30","45213"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","30","45213"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","30","45213"));
        list.add(new OrdersModel(R.drawable.burger,"Burger","30","45213"));

        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.ordersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);
    }
}