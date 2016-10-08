package com.search.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by zhang shuailing on 2016/4/29.
 * email bitxiaozhang@163.com
 */
public class DialogUtils {

    public static void selectDate(Context context,final OnSelectedDelegate delegate){
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int date = now.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                if (delegate != null){
                    delegate.onSelect(i+"-"+(i1+1)+"-"+i2);
                }
            }
        },year,month,date);
        datePickerDialog.show();
    }

    public interface OnSelectedDelegate{
        void onSelect(String result);
    }
}
