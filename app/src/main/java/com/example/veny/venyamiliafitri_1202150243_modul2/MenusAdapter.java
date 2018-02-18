package com.example.veny.venyamiliafitri_1202150243_modul2;

/**
 * Created by Veny on 2/17/2018.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Veny on 2/16/2018.
 */

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MyViewHolder> {

    private List<Menu> menusList;

    // Referensi views untuk masing-masing data item
    // Data yang kompleks mungkin membutuhkan lebih dari 1 view per item
    // Sehingga dapat mengakses semua data item dalam view di dalam view holder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView photo;
        public TextView nama, harga, tanda;

        public MyViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.photo);
            nama = (TextView) itemView.findViewById(R.id.nama);
            harga = (TextView) itemView.findViewById(R.id.harga);
            tanda = (TextView) itemView.findViewById(R.id.tanda);
        }
    }

    //Memberikan konstruktor yang sesuai (tergantung pada jenis dataset)
    public MenusAdapter(List<Menu> menusList) {

        this.menusList = menusList;
    }

    // Buat tampilan baru (dipanggil oleh layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_row, parent, false);

        return new MyViewHolder(itemView);
    }


    // Ganti isi tampilan (dipanggil oleh layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        // Mendapatkan elemen dari dataset Anda di posisi ini
        // Mengganti isi tampilan dengan elemen itu
        Menu menu = menusList.get(position);
        holder.tanda.setText(""+position);
        holder.photo.setImageResource(menu.getPhoto());
        holder.nama.setText(menu.getNama());
        holder.harga.setText(menu.getHarga());

        //Memberikan tindakan ketika salah satu item view diklik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String komp = holder.tanda.getText().toString();
                Log.d("ItemMenuCLICKED","ID:"+komp);
                Intent i = new Intent(view.getContext().getApplicationContext(), DetailMenuActivity.class);
                i.putExtra("MenuID",""+komp);
                view.getContext().startActivity(i);
            }
        });

    }

    // Kembalikan ukuran dataset(dipanggil oleh layout manager)
    @Override
    public int getItemCount() {

        return menusList.size();
    }
}