package com.zhhl.marketauthority.activity.backlog;

import android.view.View;
import android.widget.ImageView;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;
//各部门人员组成
public class DepartmentsActivity extends BaseActivity {
    private ImageView back;
    private ImageView change;
    private Boolean markBool = true;
    @Override
    protected int setContentView() {
        return R.layout.activity_departments;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("各部门人员组成");
        change = addChange();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSate(markBool);
//                mAdapter.setToChange(true);
            }
        });
        init();
        setData();
    }

    private void changeSate(Boolean bool) {
    }

    private void init() {

    }

    private void setData() {

    }
}
