package com.zhhl.marketauthority.activity.backlog;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;

import butterknife.BindView;

//主要检验与试验仪器设备状况
public class InspectDeviceActivity extends BaseActivity {

    @BindView(R.id.radio_result)
    RadioGroup radio_result;//评审结果
    @BindView(R.id.regular)
    RadioButton regular;//合格
    @BindView(R.id.unregular)
    RadioButton unregular;//不合格
    @Override
    protected int setContentView() {
        return R.layout.activity_inspect_device;
    }

    @Override
    protected void onCreate() {

    }
}
