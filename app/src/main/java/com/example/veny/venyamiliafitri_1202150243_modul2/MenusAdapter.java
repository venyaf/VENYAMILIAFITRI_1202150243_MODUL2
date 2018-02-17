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


    public MenusAdapter(List<Menu> menusList) {

        this.menusList = menusList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Menu menu = menusList.get(position);
        holder.tanda.setText(""+position);
        holder.photo.setImageResource(menu.getPhoto());
        holder.nama.setText(menu.getNama());
        holder.harga.setText(menu.getHarga());

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

    @Override
    public int getItemCount() {

        return menusList.size();
    }
}