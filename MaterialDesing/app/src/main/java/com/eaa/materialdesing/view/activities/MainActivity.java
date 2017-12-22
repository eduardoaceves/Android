package com.eaa.materialdesing.view.activities;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;

import com.eaa.materialdesing.R;
import com.eaa.materialdesing.model.MenuDTO;
import com.eaa.materialdesing.view.adapters.MenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar ToolBar;
    @BindView(R.id.drawer_layout)
    DrawerLayout DrawerLayout;
    @BindView(R.id.rvMenuDrawer)
    RecyclerView mRecycler;
    public ActionBarDrawerToggle DrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MenuLateral();
        cargarMenuLateral();
    }

    private void MenuLateral() {
        setSupportActionBar(ToolBar);
        DrawerToggle = new ActionBarDrawerToggle(this, DrawerLayout, ToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        DrawerLayout.addDrawerListener(DrawerToggle);
        DrawerToggle.syncState();
    }

    private void cargarMenuLateral() {
        List<MenuDTO> menuDTOList = new ArrayList<>();
        for (int i = 1; i <= 20; i++)
            menuDTOList.add(new MenuDTO("imagen", "Elemento Menu " + i));

        MenuAdapter adapterLisMenu = new MenuAdapter(menuDTOList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(manager);
        mRecycler.swapAdapter(adapterLisMenu, true);
    }


}


