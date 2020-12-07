package com.zhhl.marketauthority.activity;

import android.content.Intent;
import android.view.View;

import com.czy.commonlib.activity.BaseActivity;
import com.czy.jg.activity.JGMainActivity;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.R2;

import butterknife.OnClick;

/**
 * Created by 陈泽宇 on 2020/11/13
 * Describe:
 */
public class ChoseModuleActivity extends BaseActivity {
    @Override
    protected int setContentView() {
        return R.layout.activity_chose_module;
    }

    @Override
    protected void onCreate() {

    }

    @OnClick({R2.id.ts, R2.id.jg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ts:
                startActivity(new Intent(ChoseModuleActivity.this, TSMainActivity.class));
                break;
            case R.id.jg:
                startActivity(new Intent(ChoseModuleActivity.this, JGMainActivity.class));
                break;
        }
    }
}
