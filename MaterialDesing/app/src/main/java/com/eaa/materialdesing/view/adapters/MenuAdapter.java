package com.eaa.materialdesing.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eaa.materialdesing.R;
import com.eaa.materialdesing.model.MenuDTO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {

    private List<MenuDTO> menuAdapterList;

    public MenuAdapter(List<MenuDTO> menuAdapterList) {
        this.menuAdapterList = menuAdapterList;
    }

    // Encargado de crear los nuevos objetos ViewHolder necesarios para los elementos de la colección
    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_menu_item, parent, false);
        return new MenuHolder(itemView);
    }

    // Encargado de actualizar los datos de un ViewHolder ya existente
    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
        holder.menuTexto.setText(menuAdapterList.get(position).getTitulo());
        holder.menuImagen.setImageResource(R.drawable.ic_action_name);
    }

    // Indica el número de elementos de la colección de datos
    @Override
    public int getItemCount() {
        if (menuAdapterList != null)
            return menuAdapterList.size();
        else
            return 0;
    }


    public static class MenuHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.menu_TV)
        public TextView menuTexto;
        @BindView(R.id.menu_IV)
        public ImageView menuImagen;

        public MenuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
