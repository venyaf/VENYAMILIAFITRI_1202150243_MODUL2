package com.example.veny.venyamiliafitri_1202150243_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Mendeklarasikan variable
    private RadioGroup rg;
    private RadioButton rb1, rb2;
    private Button btPesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById dari component tree
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        rb1 = (RadioButton)findViewById(R.id.dineIn);
        rb2 = (RadioButton)findViewById(R.id.takeAway);
        btPesan = (Button)findViewById(R.id.pesanSekarang);

        //Apa yang terjadi ketika button pesan diklik
        btPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mendeklarasikan ketika radio group diklik salah satu
                int selectedItem = rg.getCheckedRadioButtonId();
                //Kondisi ketika radio button DineIn dipilih
                if(selectedItem == rb1.getId()){
                    //Mendeklarasikan new Intent ke aktivitas selanjutnya
                    Intent intent = new Intent(MainActivity.this,DineInActivity.class);
                    //Perintah start aktivitas dari intent
                    startActivity(intent);
                    //Toast ketika kondisi terpenuhi
                    Toast.makeText(MainActivity.this,"Anda Memilih Dine In",Toast.LENGTH_LONG).show();
                //Kondisi ketika radio button TakeAway dipilih
                }else if(selectedItem == rb2.getId()){
                    //Mendeklarasikan new Intent ke aktivitas selanjutnya
                    Intent intent2 = new Intent(MainActivity.this,TakeAwayActivity.class);
                    //Perintah start aktivitas dari intent
                    startActivity(intent2);
                    //Toast ketika kondisi terpenuhi
                    Toast.makeText(MainActivity.this,"Anda Memilih Take Away",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
