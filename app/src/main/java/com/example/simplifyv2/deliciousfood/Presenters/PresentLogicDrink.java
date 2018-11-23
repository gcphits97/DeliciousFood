package com.example.simplifyv2.deliciousfood.Presenters;

import com.example.simplifyv2.deliciousfood.Fragments.FragmentHome.ViewDrink;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Models.JSONHome;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONData;
import com.example.simplifyv2.deliciousfood.Server.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PresentLogicDrink implements ImpDrink {
    ViewDrink viewDrink;
    Path path;

    public PresentLogicDrink(ViewDrink viewDrink) {
        this.viewDrink = viewDrink;
        path = new Path();
    }

    @Override
    public void getDataDrink() {
        List<HomeModel> homeModelList;
        String data = "";
        List<HashMap<String, String>> attributes = new ArrayList<>();

        HashMap<String, String> hsLoaiMonAn = new HashMap<>();
        hsLoaiMonAn.put("id_loaimonan", "2");
        attributes.add(hsLoaiMonAn);

        DownloadJSONData downloadJSONData = new DownloadJSONData(path.getPath_monan(), attributes);
        downloadJSONData.execute();

        try {
            data = downloadJSONData.get();
            JSONHome jsonHome = new JSONHome();
            homeModelList = jsonHome.ParserJSONHome(data);
            viewDrink.ShowDataDrink(homeModelList);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDataDrinkBanChay() {
        List<HomeModel> listBanChay;
        String data = "";
        List<HashMap<String, String>> attributes = new ArrayList<>();

        HashMap<String, String> hsLoaiMonAn = new HashMap<>();
        hsLoaiMonAn.put("id_loaimonan", "5");
        attributes.add(hsLoaiMonAn);

        DownloadJSONData downloadJSONData = new DownloadJSONData(path.getPath_monan(), attributes);
        downloadJSONData.execute();

        try {
            data = downloadJSONData.get();
            JSONHome jsonHome = new JSONHome();
            listBanChay = jsonHome.ParserJSONHome(data);
            viewDrink.ShowDataDrinkViewFlipper(listBanChay);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
