package com.example.simplifyv2.deliciousfood.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;

import com.example.simplifyv2.deliciousfood.Adapters.AdapterSearchView;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Models.JSONHome;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONData;
import com.example.simplifyv2.deliciousfood.Server.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SearchViewActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, View.OnClickListener {
    Toolbar toolbarSearchView;
    ImageView imageBack;
    SearchView searchViewSearch;
    RecyclerView recyclerSearchView;
    AdapterSearchView adapterSearchView;
    Path path;
    String data;
    List<HomeModel> homeModelList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);
        toolbarSearchView = findViewById(R.id.toolbarSearchView);
        imageBack = findViewById(R.id.imageBack);
        searchViewSearch = findViewById(R.id.searchViewSearch);
        recyclerSearchView = findViewById(R.id.recyclerSearchView);

        //set up toolbar
        toolbarSearchView.setTitle("");
        setSupportActionBar(toolbarSearchView);
        imageBack.setOnClickListener(this);

        //Lay du lieu
        path = new Path();
        DownloadJSONData downloadJSONData = new DownloadJSONData(path.getPath_monan());
        downloadJSONData.execute();
        try {
            data = downloadJSONData.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONHome jsonHome = new JSONHome();
        homeModelList = jsonHome.ParserJSONHome(data);
        List<HomeModel> homeModels = new ArrayList<>();
        for (HomeModel homeModel: homeModelList) {
            if (homeModel.getId_loaimoanan() == 1 || homeModel.getId_loaimoanan() == 2 || homeModel.getId_loaimoanan() == 3) {
                homeModels.add(homeModel);
            }
        }

        //RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapterSearchView = new AdapterSearchView(homeModels, this);
        recyclerSearchView.setLayoutManager(layoutManager);
        recyclerSearchView.setAdapter(adapterSearchView);

        //Set Event Click
        searchViewSearch.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchViewSearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapterSearchView.getFilter().filter(s);
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageBack:
                onBackPressed();
                break;
        }
    }
}
