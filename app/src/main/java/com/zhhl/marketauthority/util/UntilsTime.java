package com.zhhl.marketauthority.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UntilsTime {

    public static String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return format.format(date);
    }
}
