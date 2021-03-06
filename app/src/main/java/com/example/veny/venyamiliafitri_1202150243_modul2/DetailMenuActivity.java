package com.example.veny.venyamiliafitri_1202150243_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class DetailMenuActivity extends AppCompatActivity {
    //Mendeklarasikan variable
    private ArrayList<Menu> menus;
    private String tanda;
    private TextView nama, harga, komposisi;
    private ImageView photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        nama = (TextView)findViewById(R.id.tvMenu);
        harga = (TextView)findViewById(R.id.tvHarga);
        komposisi = (TextView)findViewById(R.id.tvDetail);
        photo = (ImageView)findViewById(R.id.ivPhoto);

        //Memanggil menuList dari DaftarMenuActivity
        menus = DaftarMenuActivity.menuList;
        //Melakukan get data dari DaftarMenuActivity menggunakan Intent
        Intent c = getIntent();
        tanda = c.getStringExtra("MenuID");
        //Melakukan get tanda lalu set data sesuai dengan data yang didapat dari activity sebelumnya
        Menu menu = menus.get(Integer.parseInt(tanda));
        nama.setText(menu.getNama());
        harga.setText(menu.getHarga());
        komposisi.setText(menu.getKomposisi());
        photo.setImageResource(menu.getPhoto());

    }

}
