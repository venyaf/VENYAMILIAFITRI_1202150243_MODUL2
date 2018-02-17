package com.example.veny.venyamiliafitri_1202150243_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TakeAwayActivity extends AppCompatActivity {
    private EditText name, phone, alamat, catatan;
    private Button pilih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        alamat = (EditText)findViewById(R.id.alamat);
        catatan = (EditText)findViewById(R.id.catatan);
        pilih = (Button)findViewById(R.id.pilihPesanan);

        pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = name.getText().toString();
                String b = phone.getText().toString();
                String c = alamat.getText().toString();
                String d = catatan.getText().toString();

                if(a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty()){
                    Toast.makeText(TakeAwayActivity.this,"Isi Data dengan Lengkap", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TakeAwayActivity.this,TakeAwayActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(TakeAwayActivity.this,"Silahkan Pilih Menu", Toast.LENGTH_LONG).show();
                    Intent intent2 = new Intent(TakeAwayActivity.this,DaftarMenuActivity.class);
                    startActivity(intent2);
                }
            }
        });

    }
}
