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
    private RadioGroup rg;
    private RadioButton rb1, rb2;
    private Button btPesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup)findViewById(R.id.radioGroup);
        rb1 = (RadioButton)findViewById(R.id.dineIn);
        rb2 = (RadioButton)findViewById(R.id.takeAway);
        btPesan = (Button)findViewById(R.id.pesanSekarang);

        btPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedItem = rg.getCheckedRadioButtonId();

                if(selectedItem == rb1.getId()){
                    Intent intent = new Intent(MainActivity.this,DineInActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Anda Memilih Dine In",Toast.LENGTH_LONG).show();
                }else if(selectedItem == rb2.getId()){
                    Intent intent2 = new Intent(MainActivity.this,TakeAwayActivity.class);
                    startActivity(intent2);
                    Toast.makeText(MainActivity.this,"Anda Memilih Take Away",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
