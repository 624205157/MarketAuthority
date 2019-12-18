package com.zhhl.marketauthority.activity.backlog;

import android.view.View;
import android.widget.ImageView;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;

public class ApplyUnitResouse extends BaseActivity {

    private ImageView back;
    private ImageView change;
    @Override
    protected int setContentView() {
        return R.layout.activity_applyunit_res;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("申请单位资源");
        change = addChange();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSate();
//                mAdapter.setToChange(true);
            }
        });
        setData();
    }

    private void setData() {

    }

    private void changeSate() {

    }
}
