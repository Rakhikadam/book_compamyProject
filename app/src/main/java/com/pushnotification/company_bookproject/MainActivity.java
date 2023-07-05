package com.pushnotification.company_bookproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BookAdpter adpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper helper = new DBHelper((MainActivity.this));
        Button button = findViewById(R.id.button);
        RecyclerView recycler = findViewById(R.id.recycler);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,AddbookActivity.class);
                startActivity(intent);
                finish();
             //   adpter.notifyDataSetChanged();

            }
        });


        List<bookinfo>list = helper.getinfo();
         adpter = new BookAdpter(list);
        recycler.setAdapter(adpter);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
     //   adpter.notifyDataSetChanged();

    }
    class BookAdpter extends RecyclerView.Adapter<BookAdpter.CustomViewHolder>{
        List<bookinfo> list;

        public BookAdpter(List<bookinfo> list) {

            this.list = list;
        }

        @NonNull
        @Override
        public BookAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.booklist_layout,parent,false);
           CustomViewHolder holder = new CustomViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull BookAdpter.CustomViewHolder holder, int position) {
            holder.name.setText(list.get(position).getName());
            holder.offer.setText(list.get(position).getOffer());
            holder.price.setText(list.get(position).getPrice());
            holder.author.setText(list.get(position).getAuthor());
            Glide.with(MainActivity.this).load(list.get(position).getImage()).into(holder.image);

        }

        @Override
        public int getItemCount() {

            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder{
            TextView name , offer,price,author;
            ImageView image;
            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                offer = itemView.findViewById(R.id.offer);
                price = itemView.findViewById(R.id.price);
                author = itemView.findViewById(R.id.author);
                image = itemView.findViewById(R.id.image);

            }
        }
    }
}