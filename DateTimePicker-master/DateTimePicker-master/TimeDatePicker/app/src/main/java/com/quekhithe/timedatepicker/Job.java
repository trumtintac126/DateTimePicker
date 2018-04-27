package com.quekhithe.timedatepicker;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by QueKhiThe on 2/13/2018.
 */

public class Job {
    private String ten;
    private String noiDung;
    private Date ngay;
    private Date gio;

    public Job() {
    }

    public Job(String ten, String noiDung, Date ngay, Date gio) {

        this.ten = ten;
        this.noiDung = noiDung;
        this.ngay = ngay;
        this.gio = gio;
    }

    public String getTen() {

        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Date getGio() {
        return gio;
    }

    public void setGio(Date gio) {
        this.gio = gio;
    }

    public String getDateFormat(Date d)
    {
        SimpleDateFormat dft=new
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dft.format(d);
    }
    /**
     * lấy định dạng giờ phút
     * @param d
     * @return
     */
    public String getHourFormat(Date d)
    {
        SimpleDateFormat dft=new
                SimpleDateFormat("HH:mm ", Locale.getDefault());
        return dft.format(d);
    }

    @Override
    public String toString() {
        return this.ten+"-"+
                getDateFormat(this.ngay)+"-"+
                getHourFormat(this.gio);
    }

}
