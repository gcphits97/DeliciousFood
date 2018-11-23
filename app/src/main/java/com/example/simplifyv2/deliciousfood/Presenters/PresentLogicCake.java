package com.example.simplifyv2.deliciousfood.Presenters;

import com.example.simplifyv2.deliciousfood.Fragments.FragmentHome.ViewCake;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Models.JSONHome;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONData;
import com.example.simplifyv2.deliciousfood.Server.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PresentLogicCake implements ImpCake {
    ViewCake viewCake;
    Path path;

    public PresentLogicCake(ViewCake viewCake) {
        this.viewCake = viewCake;
        path = new Path();
    }

    @Override
    public void getDataCake() {
        List<HomeModel> homeModelList;
        String data = "";
        List<HashMap<String, String>> attributes = new ArrayList<>();

        HashMap<String, String> hsLoaiMonAn = new HashMap<>();
        hsLoaiMonAn.put("id_loaimonan", "3");
        attributes.add(hsLoaiMonAn);

        DownloadJSONData downloadJSONData = new DownloadJSONData(path.getPath_monan(), attributes);
        downloadJSONData.execute();

        try {
            data = downloadJSONData.get();
            JSONHome jsonHome = new JSONHome();
            homeModelList = jsonHome.ParserJSONHome(data);
            viewCake.ShowDataCake(homeModelList);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
