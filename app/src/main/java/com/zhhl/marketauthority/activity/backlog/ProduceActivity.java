package com.zhhl.marketauthority.activity.backlog;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;

import butterknife.BindView;

//试生产(制造)情况
public class ProduceActivity  extends BaseActivity {
    @BindView(R.id.et_name_product)
    EditText et_name_product;//产品名称
    @BindView(R.id.et_device_type)
    EditText et_device_type;//设备品种/类别
    @BindView(R.id.et_param_level)
    EditText et_param_level;//参数级别
    @BindView(R.id.et_device_model)
    EditText et_device_model;//设备型号
    @BindView(R.id.et_updatetime)
    EditText et_updatetime;//评审时间
    @BindView(R.id.et_idea)
    EditText et_idea;//评审意见
    @BindView(R.id.radio_result)
    RadioGroup radio_result;//评审结果
    @BindView(R.id.regular)
    RadioButton regular;//合格
    @BindView(R.id.unregular)
    RadioButton unregular;//不合格
    private ImageView back;
    private ImageView change;
    private Boolean markBool = true;
    @Override
    protected int setContentView() {
        return R.layout.activity_produce;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("试生产(制造)情况");
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
        et_name_product.setEnabled(bool);
        et_device_type.setEnabled(bool);
        et_param_level.setEnabled(bool);
        et_device_model.setEnabled(bool);
        et_updatetime.setEnabled(bool);
        et_idea.setEnabled(bool);

        et_name_product.setBackground(ContextCompat.getDrawable(ProduceActivity.this,R.drawable.background_arc_3));
        et_device_type.setBackground(ContextCompat.getDrawable(ProduceActivity.this,R.drawable.background_arc_3));
        et_param_level.setBackground(ContextCompat.getDrawable(ProduceActivity.this,R.drawable.background_arc_3));
        et_device_model.setBackground(ContextCompat.getDrawable(ProduceActivity.this,R.drawable.background_arc_3));
        et_updatetime.setBackground(ContextCompat.getDrawable(ProduceActivity.this,R.drawable.background_arc_3));
        et_idea.setBackground(ContextCompat.getDrawable(ProduceActivity.this,R.drawable.background_arc_3));

    }

    private void init() {

    }

    private void setData() {

    }
}
