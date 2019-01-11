package com.example.simplifyv2.deliciousfood.Presenters;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.simplifyv2.deliciousfood.Models.ChiTietMonAnModel;
import com.example.simplifyv2.deliciousfood.Models.DonHangModel;
import com.example.simplifyv2.deliciousfood.Models.JSONChiTietMonAn;
import com.example.simplifyv2.deliciousfood.Models.JSONDonHang;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONData;
import com.example.simplifyv2.deliciousfood.Server.Path;
import com.example.simplifyv2.deliciousfood.View.ViewDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class PresenterDetail implements ImpDetail {
    Path path;
    ViewDetail viewDetail;

    public PresenterDetail(ViewDetail viewDetail) {
        this.viewDetail = viewDetail;
        path = new Path();
    }

    @Override
    public void setEventAddtoCart(int id_monan, int soluong, int tongtien, int id_khachhang) {
        String data = "";
        List<DonHangModel> donHangModelList;
        boolean check = true;
        int id = 0;
        int soluongtruoc = 0;
        int tongtientruoc = 0;

        DownloadJSONData downloadJSONData = new DownloadJSONData(path.getPath_donhang());
        downloadJSONData.execute();
        try {
            data = downloadJSONData.get();
            JSONDonHang jsonDonHang = new JSONDonHang();
            donHangModelList = jsonDonHang.ParserJSONDonHang(data);
            if (donHangModelList.size() > 0) {
                for (DonHangModel value: donHangModelList) {
                    if (value.getId_monan() == id_monan && value.getId_khachhang() == id_khachhang) {
                        id = value.getId_donhang();
                        soluongtruoc = value.getSoluong();
                        tongtientruoc = value.getTongtien();
                        check = false;
                    }
                }
            }
            if (check == true) {
                CreateDonhang(id_khachhang, soluong, tongtien, id_monan);
            }
            if (check == false) {
                UpdateDonHang(id, soluong, tongtien, soluongtruoc, tongtientruoc);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<ChiTietMonAnModel> chiTietMonAnModelList() {
        List<ChiTietMonAnModel> chiTietMonAnModelList;
        String data = "";

        DownloadJSONData downloadJSONData = new DownloadJSONData(path.getPath_chitietmonan());
        downloadJSONData.execute();

        try {
            data = downloadJSONData.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        JSONChiTietMonAn jsonChiTietMonAn = new JSONChiTietMonAn();
        chiTietMonAnModelList = jsonChiTietMonAn.ParseJSONChiTietMonAn(data);
        return chiTietMonAnModelList;
    }

    @Override
    public void getDataToShowLike(int id_monan, int id_khachhang) {
        List<ChiTietMonAnModel> chiTietMonAnModels = new ArrayList<>();
        List<ChiTietMonAnModel> chiTietMonAnModelLikeList = new ArrayList<>();
        int count;
        if (chiTietMonAnModelList().size() > 0) {
            for (ChiTietMonAnModel value: chiTietMonAnModelList()) {
                if (value.getId_monan() == id_monan) {
                    chiTietMonAnModelLikeList.add(value);
                }
                if (value.getId_khachhang() == id_khachhang) {
                    chiTietMonAnModels.add(value);
                }
            }
        }
        count = chiTietMonAnModelLikeList.size();
        for (ChiTietMonAnModel valueMonAn: chiTietMonAnModels) {
            if (valueMonAn.getId_monan() == id_monan) {
                if (valueMonAn.getUlike() == 1) {
                    viewDetail.CheckLike(true, count);
                    if (valueMonAn.getUlike() != 1) {
                        viewDetail.CheckLike(false, count);
                    }
                }
            }
        }
    }

    @Override
    public void getDataToShowShare(int id_monan, int id_khachhang) {
        List<ChiTietMonAnModel> chiTietMonAnModels = new ArrayList<>();
        List<ChiTietMonAnModel> chiTietMonAnModelShareList = new ArrayList<>();
        int count;

        if (chiTietMonAnModelList().size() > 0) {
            for (ChiTietMonAnModel value: chiTietMonAnModelList()) {
                if (value.getId_khachhang() == id_khachhang) {
                    chiTietMonAnModels.add(value);
                }
                if (value.getUshare() == 1) {
                    chiTietMonAnModelShareList.add(value);

                }
            }
        }
        count = chiTietMonAnModelShareList.size();
        for (ChiTietMonAnModel valueMonAn: chiTietMonAnModels) {
            if (valueMonAn.getId_monan() == id_monan) {
                if (valueMonAn.getUshare() == 1) {
                    viewDetail.CheckShare(true, count);
                    if (valueMonAn.getUshare() != 1) {
                        viewDetail.CheckShare(false, count);
                    }
                }
            }
        }
    }

    private void CreateDonhang(final int id_khachhang, final int soluong, final int tongtien, final int id_monan) {
        RequestQueue queue = Volley.newRequestQueue((Context) viewDetail);
        StringRequest request = new StringRequest(Request.Method.POST, path.getPath_insert_donhang(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    viewDetail.InsertSuccess();
                } else {
                    viewDetail.InsertFail();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hsInsert = new HashMap<>();
                hsInsert.put("id_khachhang", String.valueOf(id_khachhang));
                hsInsert.put("soluong", String.valueOf(soluong));
                hsInsert.put("tongtien", String.valueOf(tongtien));
                hsInsert.put("id_monan", String.valueOf(id_monan));
                return hsInsert;
            }
        };
        queue.add(request);
    }
    private void UpdateDonHang(final int id, int soluong, int tongtien, int soluongtruoc, int tongtientruoc) {
        final int soluongsau = soluong + soluongtruoc;
        final int tongtiensau = tongtien + tongtientruoc;
        RequestQueue queue = Volley.newRequestQueue((Context) viewDetail);
        StringRequest request = new StringRequest(Request.Method.POST, path.getPath_update_donhang(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    viewDetail.InsertSuccess();
                } else {
                    viewDetail.InsertFail();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hsUpdate = new HashMap<>();
                hsUpdate.put("soluong", String.valueOf(soluongsau));
                hsUpdate.put("tongtien", String.valueOf(tongtiensau));
                hsUpdate.put("id_donhang", String.valueOf(id));
                return hsUpdate;
            }
        };
        queue.add(request);
    }
}
