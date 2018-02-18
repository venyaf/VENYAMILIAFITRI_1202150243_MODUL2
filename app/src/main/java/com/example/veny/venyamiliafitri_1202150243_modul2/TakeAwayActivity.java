package com.example.veny.venyamiliafitri_1202150243_modul2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TakeAwayActivity extends AppCompatActivity {
    private EditText name, phone, alamat, catatan;
    private Button pilih;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText txt_tgl, txt_jam;
    Button btn_get_datetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        alamat = (EditText) findViewById(R.id.alamat);
        catatan = (EditText) findViewById(R.id.catatan);
        pilih = (Button) findViewById(R.id.pilihPesanan);

        pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = name.getText().toString();
                String b = phone.getText().toString();
                String c = alamat.getText().toString();
                String d = catatan.getText().toString();
                String e = txt_tgl.getText().toString();
                String f = txt_jam.getText().toString();

                if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty() || e.isEmpty() || f.isEmpty()) {
                    Toast.makeText(TakeAwayActivity.this, "Isi Data dengan Lengkap", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TakeAwayActivity.this, TakeAwayActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(TakeAwayActivity.this, "Silahkan Pilih Menu", Toast.LENGTH_LONG).show();
                    Intent intent2 = new Intent(TakeAwayActivity.this, DaftarMenuActivity.class);
                    startActivity(intent2);
                }

            }
        });
        txt_tgl = (EditText) findViewById(R.id.txt_tgl);
        txt_jam = (EditText) findViewById(R.id.txt_jam);
        btn_get_datetime = (Button) findViewById(R.id.btn_get_datetime);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        txt_tgl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(TakeAwayActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txt_jam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(TakeAwayActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        txt_jam.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

        btn_get_datetime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(TakeAwayActivity.this,
                        "Tanggal : " + txt_tgl.getText().toString() + "\n" +
                                "Jam : " + txt_jam.getText().toString()
                        , Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txt_tgl.setText(sdf.format(myCalendar.getTime()));
    }

}

