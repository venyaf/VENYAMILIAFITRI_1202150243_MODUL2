package com.example.veny.venyamiliafitri_1202150243_modul2;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DaftarMenuActivity extends AppCompatActivity {
    public static ArrayList<Menu> menuList = new ArrayList<>();

    private RecyclerView recyclerView;
    private MenusAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);

        menuList = isiMenu();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MenusAdapter(menuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }



    public ArrayList<Menu> isiMenu(){
        ArrayList<Menu> data = new ArrayList<>();

        data.add(new Menu(R.drawable.bakso,"Bakso Spesial", "Harga : Rp 18.000", "Campuran daging sapi giling dan tepung tapioka"));

        data.add(new Menu(R.drawable.soto,"Soto Betawi", "Harga : Rp 19.000","Jerohan, daging sapi, kentang,batang serai, daun salam, daun jeruk, santan sedang kentalnya, air jeruk limo, bawang goreng, daun bawang, garam, gula"));

        data.add(new Menu(R.drawable.nasiayam,"Nasi Ayam Goreng", "Harga : Rp 21.000","Ayam, mentimun, sambal terasi,tomat, nasi, sambal kecap"));

        data.add(new Menu(R.drawable.nasibebek,"Nasi Bebek", "Harga : Rp 22.500","Bebek muda, nasi, bawang putih, bawang merah, kunyit, jahe, ketumbar, cabai"));

        data.add(new Menu(R.drawable.nasipecel,"Nasi Pecel Komplit", "Harga : Rp 15.000","Kacang panjang, taoge, mentimun, daun singkong, daun kemangi,  kencur, gula merah, garam, cabai, kecombrang, daun jeruk purut, kacang tanah sangrai "));

        data.add(new Menu(R.drawable.nasiwagyu,"Nasi Wagyu", "Harga : Rp 21.000","Nasi, daging kambing, telur"));

        data.add(new Menu(R.drawable.satemadura,"Sate Madura", "Harga : Rp 16.000","Sate, garam, merica, bawang putih, kecap manis, bawang merah, sambal"));

        data.add(new Menu(R.drawable.miegorengspesial,"Mie Goreng Spesial", "Harga : Rp 15.000","Mie, telur, cabai, bawang putih, daging sapi, tomat"));

        data.add(new Menu(R.drawable.miekuah,"Mie Kuah","Harga : Rp 14.500", "Mie, bawang goreng, seledri cina, daun bawang, cabai"));

        return data;

    }
}
