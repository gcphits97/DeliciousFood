package com.example.simplifyv2.deliciousfood.Presenters;

import com.example.simplifyv2.deliciousfood.View.Fragments.FragmentHome.ViewCake;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Models.JSONHome;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONHome;
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

        DownloadJSONHome downloadJSONHome = new DownloadJSONHome(path.getPath_monan_theoloai(), attributes);
        downloadJSONHome.execute();

        try {
            data = downloadJSONHome.get();
            JSONHome jsonHome = new JSONHome();
            homeModelList = jsonHome.ParserJSONHome(data);
            viewCake.ShowDataCake(homeModelList);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDataCakeBanChay() {
        List<HomeModel> listBanChay;
        String data = "";
        List<HashMap<String, String>> attributes = new ArrayList<>();

        HashMap<String, String> hsLoaiMonAn = new HashMap<>();
        hsLoaiMonAn.put("id_loaimonan", "6");
        attributes.add(hsLoaiMonAn);

        DownloadJSONHome downloadJSONHome = new DownloadJSONHome(path.getPath_monan_theoloai(), attributes);
        downloadJSONHome.execute();

        try {
            data = downloadJSONHome.get();
            JSONHome jsonHome = new JSONHome();
            listBanChay = jsonHome.ParserJSONHome(data);
            viewCake.ShowDataCakeViewFlipper(listBanChay);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
