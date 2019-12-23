package com.zhhl.marketauthority.activity.backlog;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;

import butterknife.BindView;

//主要检验与试验仪器设备状况
public class InspectDeviceActivity extends BaseActivity {
    @BindView(R.id.et_name_device)
    EditText et_name_device;//cl_1 仪器设备名称
    @BindView(R.id.et_equipment_devcie)
    EditText et_equipment_devcie;//cl_1 仪器设备能力
    @BindView(R.id.et_count_device)
    EditText et_count_device;//cl_1 仪器设备数
    @BindView(R.id.radio_result)
    RadioGroup radio_result;//评审结果
    @BindView(R.id.regular)
    RadioButton regular;//合格
    @BindView(R.id.unregular)
    RadioButton unregular;//不合格

    @BindView(R.id.et_name_device2)
    EditText et_name_device2;//cl_2 仪器设备名称
    @BindView(R.id.et_equipment_devcie2)
    EditText et_equipment_devcie2;//cl_2 仪器设备能力
    @BindView(R.id.et_count_device2)
    EditText et_count_device2;//cl_2 仪器设备数
    @BindView(R.id.et_idea)
    EditText et_idea;//cl_2 评审意见
    @BindView(R.id.radio_result2)
    RadioGroup radio_result2;//cl_2评审结果
    @BindView(R.id.regular2)
    RadioButton regular2;//cl_2合格
    @BindView(R.id.unregular2)
    RadioButton unregular2;//cl_2不合格

    @BindView(R.id.et_name_device3)
    EditText et_name_device3;//cl_3 仪器设备名称
    @BindView(R.id.et_equipment_devcie3)
    EditText et_equipment_devcie3;//cl_3 仪器设备能力
    @BindView(R.id.et_count_device3)
    EditText et_count_device3;//cl_3 仪器设备数
    @BindView(R.id.radio_result3)
    RadioGroup radio_result3;//cl_3评审结果
    @BindView(R.id.regular3)
    RadioButton regular3;//cl_3合格
    @BindView(R.id.unregular3)
    RadioButton unregular3;//cl_3不合格

    @BindView(R.id.submit)
    TextView submit;//提交
    private ImageView back;
    private ImageView change;
    private Boolean markBool = true;
    @Override
    protected int setContentView() {
        return R.layout.activity_inspect_device;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("主要检验与试验仪器设备状况");
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

    private void setData() {

    }

    private void init() {

    }

    private void changeSate(Boolean markBool) {
        et_name_device.setEnabled(markBool);
        et_equipment_devcie.setEnabled(markBool);
        et_count_device.setEnabled(markBool);
        radio_result.setEnabled(markBool);
        et_name_device.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));
        et_equipment_devcie.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));
        et_count_device.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));

        et_name_device2.setEnabled(markBool);
        et_equipment_devcie2.setEnabled(markBool);
        et_count_device2.setEnabled(markBool);
        radio_result2.setEnabled(markBool);
        et_idea.setEnabled(markBool);
        et_name_device2.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));
        et_equipment_devcie2.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));
        et_count_device2.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));
        et_idea.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));

        et_name_device3.setEnabled(markBool);
        et_equipment_devcie3.setEnabled(markBool);
        et_count_device3.setEnabled(markBool);
        radio_result3.setEnabled(markBool);

        et_name_device3.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));
        et_equipment_devcie3.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));
        et_count_device3.setBackground(ContextCompat.getDrawable(InspectDeviceActivity.this,R.drawable.background_arc_3));

    }
}
