package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helloworld.adapter.MyAdapter;
import com.example.helloworld.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private ListView listView;
    //private ArrayAdapter<Item> adapter;
    private MyAdapter myAdapter;
    private List<Item> values = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addValues();

        listView = findViewById(R.id.mylistview);

        //adapter = new ArrayAdapter<>(this, R.layout.myrow, R.id.linearlayouttextview, values);
        myAdapter = new MyAdapter(values, this);
        listView.setAdapter(myAdapter);
        //listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, pos, id) ->{
            // For testing and understanding
            /*
            System.out.println("you pressed on: " + pos);
            System.out.println("View: " + view.getClass().getName());
            System.out.println("Parent: " + parent.getClass().getName());
            */
            TextView tv = view.findViewById(R.id.linearlayouttextview);
            System.out.println("You pressed " + tv.getText());

            //For navigation
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);


        });
    }

    public void addPressed(View view){
        System.out.println("add Pressed");
        values.add(new Item("New Item", R.drawable.marxlogo));
        myAdapter.notifyDataSetChanged(); // Should update the layout
    }

    private void addValues(){
        values.add(new Item("car 1", R.drawable.marxlogo));
        values.add(new Item("car 2", R.drawable.xenius));
    }

    public void homePressed(View view) {
        finish();
    }
}