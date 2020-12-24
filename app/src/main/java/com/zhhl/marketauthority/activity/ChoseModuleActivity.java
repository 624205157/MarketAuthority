package com.zhhl.marketauthority.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import com.czy.commonlib.activity.BaseActivity;
import com.zhhl.marketauthority.photo.PhotoListener;
import com.zhhl.marketauthority.photo.WaterMask;
import com.zhhl.marketauthority.photo.WaterMaskHelper;
import com.czy.jg.activity.JGMainActivity;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.R2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.OnClick;

/**
 * Created by 陈泽宇 on 2020/11/13
 * Describe:
 */
public class ChoseModuleActivity extends BaseActivity implements WaterMask.WaterMaskListener, PhotoListener {

    private WaterMaskHelper waterMaskHelper;

    @Override
    protected int setContentView() {
        return R.layout.activity_chose_module;
    }

    @Override
    protected void onCreate() {
        //初始化水印工具
        waterMaskHelper = new WaterMaskHelper(this, this, this);
    }

    @OnClick({R2.id.ts, R2.id.jg,R.id.pz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ts:
                startActivity(new Intent(ChoseModuleActivity.this, TSMainActivity.class));
                break;
            case R.id.jg:
                startActivity(new Intent(ChoseModuleActivity.this, JGMainActivity.class));
                break;
            case R.id.pz:
                takePhoto();
                break;
        }
    }

    private void takePhoto() {

        waterMaskHelper.startCapture();

    }

    @Override
    public void onChoose(ArrayList<String> photos) {

    }

    @Override
    public WaterMask.WaterMaskParam onDraw() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
        String sim = dateFormat.format(date);
        WaterMask.WaterMaskParam param = new WaterMask.WaterMaskParam();
        param.txt.add(sim);
        param.itemCount = 30;
        param.txtColor = Color.WHITE;
        return param;
    }
}
