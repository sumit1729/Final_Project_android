package com.example.final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class appoinment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinment);

        RecyclerView rv= findViewById(R.id.view1);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter());

        RecyclerView rv1= findViewById(R.id.view2);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1.setAdapter(new MyAdapter());





        Button b= (Button) findViewById(R.id.back);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(appoinment.this, home_page.class));
            }
        });


    }
    class MyAdapter extends RecyclerView.Adapter<viewHolder>{

        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(appoinment.this).inflate(R.layout.design,parent,false);
            return new viewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }


    class viewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView1;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text1);
            textView1=itemView.findViewById(R.id.text2);


        }
    }
}