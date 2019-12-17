package com.zhhl.marketauthority.activity.backlog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;

import butterknife.BindView;

public class CompanyActivity extends BaseActivity {
    @BindView(R.id.submit)
    TextView submit;
    @BindView(R.id.name)
    TextView name;

    private ImageView back;
    @Override
    protected int setContentView() {
        return R.layout.activity_company;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("申请单位基本信息");
        ImageView change = addChange();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change.setVisibility(View.INVISIBLE);
                submit.setVisibility(View.VISIBLE);
//                mAdapter.setToChange(true);
            }
        });
        setData();
    }

    private void setData() {
        name.setText("长春市宏日新能源有限责任公司,长春市宏日新能源有限责任公司长春市宏日新能源有限责任公司长春市宏日新能源有限责任公司长春市宏日新能源有限责任公司长春市宏日新能源有限责任公司长春市宏日新能源有限责任公司");
    }

    protected void addBack() {
        back = findViewById(R.id.back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
