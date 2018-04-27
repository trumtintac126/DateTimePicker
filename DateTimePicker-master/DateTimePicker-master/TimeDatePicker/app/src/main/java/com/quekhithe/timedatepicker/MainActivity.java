package com.quekhithe.timedatepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    EditText txtCV, txtND;
    TextView txtNgay, txtGio;
    Button btnNgay, btnGio, btnThem;
    ListView lv;

    ArrayList<Job> arrJob = new ArrayList<Job>();
    ArrayAdapter<Job> adapterJob = null;

    Calendar calendar;

    Date date;
    Date hour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCV = findViewById(R.id.txtCV);
        txtND = findViewById(R.id.txtND);
        txtNgay = findViewById(R.id.txtNgay);
        txtGio = findViewById(R.id.txtGio);
        btnNgay = findViewById(R.id.btnNgay);
        btnGio = findViewById(R.id.btnGio);
        btnThem = findViewById(R.id.btnThem);
        lv = findViewById(R.id.lv);

        adapterJob = new ArrayAdapter<Job>(MainActivity.this, android.R.layout.simple_list_item_1, arrJob);
        lv.setAdapter(adapterJob);


        calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String sDate = sdf.format(calendar.getTime());
        txtNgay.setText(sDate);
        sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        txtGio.setText(sdf.format(calendar.getTime()));



        btnNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNgay();
            }
        });

        btnGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyGio();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themCongViec();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrJob.remove(i);
                adapterJob.notifyDataSetChanged();
                return false;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, HienThiChiTietActivity.class);
                intent.putExtra("ten", String.valueOf(arrJob.get(i).getTen()));
                intent.putExtra("noidung", String.valueOf(arrJob.get(i).getNoiDung()));
                intent.putExtra("thoigian", String.valueOf(arrJob.get(i).getDateFormat(date)));
                intent.putExtra("gio", String.valueOf(arrJob.get(i).getHourFormat(hour)));
                startActivity(intent);
            }
        });
    }

    private void xuLyNgay() {
        DatePickerDialog.OnDateSetListener callback=new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                txtNgay.setText((dayOfMonth) +"/"+(monthOfYear+1)+"/"+year);
                calendar.set(year, monthOfYear, dayOfMonth);
                date=calendar.getTime();
            }
        };
        String s=txtNgay.getText()+"";
        String strArrtmp[]=s.split("/");
        int ngay=Integer.parseInt(strArrtmp[0]);
        int thang=Integer.parseInt(strArrtmp[1])-1;
        int nam=Integer.parseInt(strArrtmp[2]);
        DatePickerDialog pic=new DatePickerDialog(MainActivity.this, callback, nam, thang, ngay);
        pic.setTitle("Chọn ngày hoàn thành");
        pic.show();

    }



    private void xuLyGio() {
        TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                txtGio.setText(i + ":" + i1);
                calendar.set(Calendar.HOUR_OF_DAY, i);
                calendar.set(Calendar.MINUTE, i1);
                hour = calendar.getTime();
            }
        };
        String s=txtGio.getText()+"";
        String strArr[]=s.split(":");
        int gio=Integer.parseInt(strArr[0]);
        int phut=Integer.parseInt(strArr[1]);
        TimePickerDialog pic = new TimePickerDialog(MainActivity.this, callback, gio, phut, true);
        pic.setTitle("Chon gio");
        pic.show();

    }

    private void themCongViec() {
        String ten = String.valueOf(txtCV.getText());
        String noidung = String.valueOf(txtND.getText());
        Job job = new Job(ten, noidung, date, hour);
        arrJob.add(job);
        adapterJob.notifyDataSetChanged();

    }


}
