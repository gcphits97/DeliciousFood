package com.example.simplifyv2.deliciousfood.Presenters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.simplifyv2.deliciousfood.Models.ChiTietDonHangModel;
import com.example.simplifyv2.deliciousfood.Models.JSONChiTietDonHang;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONChiTietDonHang;
import com.example.simplifyv2.deliciousfood.Server.Path;
import com.example.simplifyv2.deliciousfood.View.ViewCartDetail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class PresenterCartDetailActivity implements ImpCartDetail, AdapterView.OnItemSelectedListener, View.OnClickListener {
    ViewCartDetail viewCartDetail;
    Button btnBook, btnRelativeBank;
    Spinner spinnerDay, spinnerMonth, spinnerHour, spinnerMinute;
    Path path;
    private int minute, hour, month, day;
    private int id_donhang;
    String thoigiandatban;
    AlertDialog.Builder builderBook;

    public PresenterCartDetailActivity(ViewCartDetail viewCartDetail, int id_donhang) {
        this.viewCartDetail = viewCartDetail;
        this.id_donhang = id_donhang;
        path = new Path();
    }
    //start set event delete don hang
    @Override
    public void setEventDelete(final ImageButton imageButtonMinus, final TextView txtSoLuong, final int soluong, final int id_donhang) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context) viewCartDetail);
        builder.setTitle(R.string.title_alert_dialog_delete);
        builder.setMessage(R.string.message_alert_dialog_delete);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.cancel_alert_dialog_delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                txtSoLuong.setText(soluong+"");
                imageButtonMinus.setVisibility(View.VISIBLE);
                dialog.cancel();
            }
        });
        builder.setNegativeButton(R.string.ok_alert_dialog_delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DeleteDonHang(id_donhang);
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void DeleteDonHang(final int id_donhang) {
        RequestQueue queue = Volley.newRequestQueue((Context) viewCartDetail);
        StringRequest request = new StringRequest(Request.Method.POST, path.getPath_delete_donhang(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equalsIgnoreCase("1")) {
                    viewCartDetail.DeleteSuccessfully();
                } else {
                    viewCartDetail.DeleteFail();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hsDelete = new HashMap<>();
                hsDelete.put("id_donhang", String.valueOf(id_donhang));
                return hsDelete;
            }
        };
        queue.add(request);
    }
    //end set event delete don hang
    //start set event save don hang
    @Override
    public void setEventSaveToCart(final String id_donhang, final String soluong, final String tongtien) {
        RequestQueue queue = Volley.newRequestQueue((Context) viewCartDetail);
        StringRequest request = new StringRequest(Request.Method.POST, path.getPath_update_donhang(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equalsIgnoreCase(String.valueOf(id_donhang))) {
                    viewCartDetail.SaveSuccessfully();
                } else {
                    viewCartDetail.SaveFail();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hsUpdate = new HashMap<>();
                hsUpdate.put("id_donhang", id_donhang);
                hsUpdate.put("tongtien", tongtien);
                hsUpdate.put("soluong", soluong);
                return hsUpdate;
            }
        };
        queue.add(request);
    }
    //end set event save don hang
    //start set event click button book
    @Override
    public void setEventClickBook(View dialogViewBook) {
        minute = Calendar.getInstance().get(Calendar.MINUTE);
        hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        month = Calendar.getInstance().get(Calendar.MONTH);

        builderBook = new AlertDialog.Builder((Context) viewCartDetail);
        btnBook = dialogViewBook.findViewById(R.id.btnBook);
        btnRelativeBank = dialogViewBook.findViewById(R.id.btnRelativeBank);
        spinnerDay = dialogViewBook.findViewById(R.id.spinnerDay);
        spinnerMonth = dialogViewBook.findViewById(R.id.spinnerMonth);
        spinnerHour = dialogViewBook.findViewById(R.id.spinnerHour);
        spinnerMinute = dialogViewBook.findViewById(R.id.spinnerMinute);
        //set default value day
        List<Integer> listDay = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            listDay.add(i);
        }
        //set default value month
        List<Integer> listMonth = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            listMonth.add(i);
        }
        //set default value hour
        List<Integer> listHour = new ArrayList<>();
        for (int i = 1; i <= 24; i++) {
            listHour.add(i);
        }
        //set default value minute
        List<Integer> listMinute = new ArrayList<>();
        for (int i = 0; i <= 60; i++) {
            listMinute.add(i);
        }

        ArrayAdapter<Integer> arrayAdapterDay = new ArrayAdapter<>((Context) viewCartDetail, android.R.layout.simple_spinner_item, listDay);
        arrayAdapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(arrayAdapterDay);
        spinnerDay.setSelection(day - 1);
        spinnerDay.setOnItemSelectedListener(this);

        ArrayAdapter<Integer> arrayAdapterMonth = new ArrayAdapter<>((Context) viewCartDetail, android.R.layout.simple_spinner_item, listMonth);
        arrayAdapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(arrayAdapterMonth);
        spinnerMonth.setSelection(month - 1);
        spinnerMonth.setOnItemSelectedListener(this);

        ArrayAdapter<Integer> arrayAdapterHour = new ArrayAdapter<>((Context) viewCartDetail, android.R.layout.simple_spinner_item, listHour);
        arrayAdapterHour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHour.setAdapter(arrayAdapterHour);
        spinnerHour.setSelection(hour - 1);
        spinnerHour.setOnItemSelectedListener(this);

        ArrayAdapter<Integer> arrayAdapterMinute = new ArrayAdapter<>((Context) viewCartDetail, android.R.layout.simple_spinner_item, listMinute);
        arrayAdapterMinute.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinute.setAdapter(arrayAdapterMinute);
        spinnerMinute.setSelection(minute - 1);
        spinnerMinute.setOnItemSelectedListener(this);

        builderBook.setView(dialogViewBook);
        builderBook.create().show();

        btnRelativeBank.setOnClickListener(this);
        btnBook.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinnerDay:
                if (!parent.getItemAtPosition(position).equals(day)) {
                    day = Integer.parseInt(parent.getItemAtPosition(position).toString());
                }
                break;
            case R.id.spinnerMonth:
                if (!parent.getItemAtPosition(position).equals(month)) {
                    month = Integer.parseInt(parent.getItemAtPosition(position).toString());
                }
                break;
            case R.id.spinnerHour:
                if (!parent.getItemAtPosition(position).equals(hour)) {
                    hour = Integer.parseInt(parent.getItemAtPosition(position).toString());
                }
                break;
            case R.id.spinnerMinute:
                if (!parent.getItemAtPosition(position).equals(minute)) {
                    minute = Integer.parseInt(parent.getItemAtPosition(position).toString());
                }
                break;
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        thoigiandatban = hour+":"+minute+" - "+day+"/"+month+"/"+year;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //TODO Auto-generated method stub
    }
    //end set event click button book

    @Override
    public void setEventClickDelivery(View dialogViewDelivery) {

    }

    @Override
    public void showCartDetail(int id_donhang) {
        Log.d("kiemtralist", chiTietDonHangModelList().get(0).getTenhinhthucthanhtoan());
        boolean check = false;
        if (chiTietDonHangModelList().size() > 0) {
            for (ChiTietDonHangModel chiTietDonHangModel: chiTietDonHangModelList()) {
                if (chiTietDonHangModel.getId_donhang() == id_donhang) {
                    if (chiTietDonHangModel.getId_hinhthucthanhtoan() == 3) {
                        viewCartDetail.ShowInfoCartDetail(chiTietDonHangModel.getTenloaidonhang(), ""
                                , chiTietDonHangModel.getTenhinhthucthanhtoan(), chiTietDonHangModel.getThoigiandatban());
                    } else {
                        viewCartDetail.ShowInfoCartDetail(chiTietDonHangModel.getTenloaidonhang(), chiTietDonHangModel.getDiachigiaohang()
                                , chiTietDonHangModel.getTenhinhthucthanhtoan(), chiTietDonHangModel.getThoigiangiaohang());
                    }
                    check = true;
                }
            }
            if (check == false) {
                viewCartDetail.CartDetailHaveNotData();
            }
        }
    }

    public List<ChiTietDonHangModel> chiTietDonHangModelList() {
        List<ChiTietDonHangModel> chiTietDonHangModelList;
        String data = "";

        DownloadJSONChiTietDonHang downloadJSONChiTietDonHang = new DownloadJSONChiTietDonHang(path.getPath_chitietdonhang());
        downloadJSONChiTietDonHang.execute();
        try {
            data = downloadJSONChiTietDonHang.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JSONChiTietDonHang jsonChiTietDonHang = new JSONChiTietDonHang();
        chiTietDonHangModelList = jsonChiTietDonHang.ParseJSONChiTietDonHang(data);

        return chiTietDonHangModelList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRelativeBank:
                btnBook.setVisibility(View.VISIBLE);
                viewCartDetail.BookSuccessfully(0, "", "", "");
                break;
            case R.id.btnBook:
                InsertDataBook();
                break;
        }
    }
    public void InsertDataBook() {
        RequestQueue queue = Volley.newRequestQueue((Context) viewCartDetail);
        StringRequest request = new StringRequest(Request.Method.POST, path.getPath_chitietdonhang_insert(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    for (ChiTietDonHangModel value: chiTietDonHangModelList()) {
                        if (response.equalsIgnoreCase(String.valueOf(value.getId_chitietdonhang()))) {
                            viewCartDetail.BookSuccessfully(1, value.getTenloaidonhang(), value.getTenhinhthucthanhtoan(), value.getThoigiandatban());
                        }
                    }
                } else {
                    viewCartDetail.BookFail();
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
                hsInsert.put("id_donhang", String.valueOf(id_donhang));
                hsInsert.put("diachigiaohang", "");
                hsInsert.put("thoigiangiaohang", "");
                hsInsert.put("thoigiandatban", thoigiandatban);
                hsInsert.put("id_hinhthucthanhtoan", "3");
                return hsInsert;
            }
        };
        queue.add(request);
    }
}
