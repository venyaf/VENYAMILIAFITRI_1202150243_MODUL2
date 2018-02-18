package com.example.veny.venyamiliafitri_1202150243_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DineInActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Mendeklarasikan Variable
    String mSpinnerlabel = "";
    private EditText name;
    private Spinner meja;
    private Button pilih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);

        name = (EditText)findViewById(R.id.name);
        meja = (Spinner) findViewById(R.id.spinner);
        pilih = (Button) findViewById(R.id.pilih);


        // Buat ArrayAdapter menggunakan array string dan default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.meja, android.R.layout.simple_spinner_item);
        // Tentukan layout yang akan digunakan saat daftar pilihan muncul
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Mengaplikasikan adapter pada spinner (nama variable meja)
        if (meja != null) {
            meja.setAdapter(adapter);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Item telah dipilih Anda dapat mengambil kegunaan item yang dipilih
        // parent.getItemAtPosition (position)
        mSpinnerlabel = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Interface callback
    }

    //Membuat method view ketika salah satu item spinner dipilih
    public void pilih(View view) {
        //Mendeklarasikan spinner diselect
        String spinner = meja.getSelectedItem().toString();
        //getText() dari nama yang diinputkan
        String a = name.getText().toString();
        //Kondisi ketika data nama dan spinner tidak lengkap
        if(a.isEmpty() || spinner.isEmpty()){
            //Mendeklarasikan toast ketika data tidak lengkap
            Toast.makeText(DineInActivity.this,"Silahkan Lengkapi Data Terlebih Dahulu",Toast.LENGTH_LONG).show();
        }else{
            //melakukan intent ke aktivitas selanjutnya apabila kondisi if tidak terpenuhi
            Intent intent = new Intent(DineInActivity.this,DaftarMenuActivity.class);
            //Melakukan start aktivitas intent
            startActivity(intent);
            //Mendeklarasikan toast ketika kondisi else terpenuhi
            Toast.makeText(DineInActivity.this,"Silahkan Pilih Menu untuk " + spinner,Toast.LENGTH_LONG).show();
        }
    }
}
