package com.example.simplifyv2.deliciousfood.Presenters;

import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Models.JSONHome;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONHome;
import com.example.simplifyv2.deliciousfood.View.Fragments.FragmentHome.ViewFastFood;
import com.example.simplifyv2.deliciousfood.Server.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PresentLogicFastFood implements ImpFastFood {
    ViewFastFood viewFastFood;
    Path path;

    public PresentLogicFastFood(ViewFastFood viewFastFood) {
        this.viewFastFood = viewFastFood;
        path = new Path();
    }

    @Override
    public void getDataFastFood() {
        List<HomeModel> homeModelList;
        String data = "";
        List<HashMap<String, String>> attributes = new ArrayList<>();

        HashMap<String, String> hsLoaiMonAn = new HashMap<>();
        hsLoaiMonAn.put("id_loaimonan", "1");
        attributes.add(hsLoaiMonAn);

        DownloadJSONHome downloadJSONHome = new DownloadJSONHome(path.getPath_monan_theoloai(), attributes);
        downloadJSONHome.execute();

        try {
            data = downloadJSONHome.get();
            JSONHome jsonHome = new JSONHome();
            homeModelList = jsonHome.ParserJSONHome(data);
            viewFastFood.ShowDataFastFood(homeModelList);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDataFastFoodBanChay() {
        List<HomeModel> listBanChay;
        String data = "";
        List<HashMap<String, String>> attributes = new ArrayList<>();

        HashMap<String, String> hsLoaiMonAn = new HashMap<>();
        hsLoaiMonAn.put("id_loaimonan", "4");
        attributes.add(hsLoaiMonAn);

        DownloadJSONHome downloadJSONHome = new DownloadJSONHome(path.getPath_monan_theoloai(), attributes);
        downloadJSONHome.execute();

        try {
            data = downloadJSONHome.get();
            JSONHome jsonHome = new JSONHome();
            listBanChay = jsonHome.ParserJSONHome(data);
            viewFastFood.ShowDataFastFoodViewFlipper(listBanChay);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
