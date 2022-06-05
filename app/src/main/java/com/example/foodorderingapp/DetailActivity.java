package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderingapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    int orderQuantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper = new DBHelper(this);



        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderQuantity=orderQuantity+1;
                binding.quantity.setText(orderQuantity+"");
            }
        });

        binding.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(orderQuantity<2)
                {
                    Toast.makeText(DetailActivity.this, "Can't be zero", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    orderQuantity--;
                    binding.quantity.setText(orderQuantity+"");
                }


            }
        });

        if(getIntent().getIntExtra("type",0)==1) {


            int image = getIntent().getIntExtra("image", 0);
            int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String name = getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.priceLb1.setText(String.format("%d", price));
            binding.foodName.setText(name);
            binding.detailDescription.setText(description);


            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );

                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {

            final int id=getIntent().getIntExtra("id",0);
            Cursor cursor=helper.getOrderById(id);
            final int image=cursor.getInt(4);

            binding.detailImage.setImageResource(image);
            binding.priceLb1.setText(String.format("%d", cursor.getInt(3)));
            binding.foodName.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(7));
            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("Update Now");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isUpdated=helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLb1.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.foodName.getText().toString(),
                            Integer.parseInt(binding.quantity.getText().toString()),
                            id
                    );

                    if(isUpdated)
                    {
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }
    }
}