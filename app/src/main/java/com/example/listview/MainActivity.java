package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.graphics.Color;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    ListView lsvDish;
    ArrayList<Dish> arr;
    DishAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsvDish = findViewById(R.id.lsvDish);
        lsvDish.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                Sua(i);
            }
        })
        ;



        arr = new ArrayList<>();

        Random  r = new Random();

        arr.add(new Dish(R.drawable.img,10,"Bài Tập"));
        arr.add(new Dish(R.drawable.img_1,r.nextInt(10)*5,"Thanh Tự"));
        arr.add(new Dish(R.drawable.img_2,r.nextInt(10)*5,"MãSV: .. 326"));
        arr.add(new Dish(R.drawable.img_3,r.nextInt(10)*5,"Buger"));
        arr.add(new Dish(R.drawable.img_4,r.nextInt(10)*5,"Combo 1"));
        arr.add(new Dish(R.drawable.img_5,r.nextInt(10)*5,"Gà Rán"));
        arr.add(new Dish(R.drawable.img_6,r.nextInt(10)*5,"Gà Rán 2"));
        arr.add(new Dish(R.drawable.img_7,r.nextInt(10)*5,"Khoai Tây"));
        arr.add(new Dish(R.drawable.img_8,r.nextInt(10)*5,"Khoai Tây2"));
        arr.add(new Dish(R.drawable.img_9,r.nextInt(10)*5,"Coca"));


        adapter = new DishAdapter(this,0,arr);
        lsvDish.setAdapter(adapter);

    }
    private void Sua(int position){
        AlertDialog.Builder alerDialog = new AlertDialog.Builder (this);
        alerDialog.setTitle("Thông Báo!");
        alerDialog.setMessage("Bạn Có Muốn sửa Món Này Không?");
        alerDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        })
        ;

        alerDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alerDialog.setIcon(R.mipmap.ic_launcher);
        alerDialog.show();
    }
    private void XacNhanXoa(int position){
        AlertDialog.Builder alerDialog = new AlertDialog.Builder (this);
        alerDialog.setTitle("Thông Báo!");
        alerDialog.setMessage("Bạn Có Muốn Xóa Món Này Không?");
        alerDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arr.remove(position);
                adapter.notifyDataSetChanged();
            }
        })
        ;

        alerDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alerDialog.setIcon(R.mipmap.ic_launcher);
        alerDialog.show();
    }
}