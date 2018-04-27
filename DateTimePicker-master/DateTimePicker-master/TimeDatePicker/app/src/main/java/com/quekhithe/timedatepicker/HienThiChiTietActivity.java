package com.quekhithe.timedatepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HienThiChiTietActivity extends AppCompatActivity {

    TextView txtNoiDung, txtThoiGian, txtTen;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_chi_tiet);

        txtNoiDung = findViewById(R.id.txtHienThi);
        txtTen = findViewById(R.id.txtTen);
        txtThoiGian = findViewById(R.id.txtThoiGian);

        Intent intent = getIntent();
        String noidung =intent.getStringExtra("noidung");
        String ten = intent.getStringExtra("ten");
        String thoigian = intent.getStringExtra("thoigian");
        String gio = intent.getStringExtra("gio");
        txtNoiDung.setText( "Nội dung: " +noidung);
        txtTen.setText( "Công việc: " +ten);
        txtThoiGian.setText( "Thời gian: " +thoigian + "\n " + gio);



    }

    public void quayve(View view) {
        Toast.makeText(HienThiChiTietActivity.this, "Nhớ thực hiện nhé ^^", Toast.LENGTH_SHORT).show();
    }
}
