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

//管理专业作业人员情况
public class ManageStaff extends BaseActivity {
    @BindView(R.id.et_homework)
    EditText et_homework;//作业项目
    @BindView(R.id.et_username)
    EditText et_username;//姓名
    @BindView(R.id.et_age)
    EditText et_age;//年龄
    @BindView(R.id.et_education)
    EditText et_education;//学历
    @BindView(R.id.et_profession)
    EditText et_profession;//专业
    @BindView(R.id.et_job_name)
    EditText et_job_name;//职称
    @BindView(R.id.et_work_years)
    EditText et_work_years;//从事专业工作年限
    @BindView(R.id.et_profession_card)
    EditText et_profession_card;//持专业证
    @BindView(R.id.et_remark)
    EditText et_remark;//备注(注明从事专业)
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
        return R.layout.activity_managestaff;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("管理、专业、作业人员情况");
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

    private void changeSate(Boolean bool) {
        et_homework.setEnabled(bool);
        et_username.setEnabled(bool);
        et_age.setEnabled(bool);
        et_education.setEnabled(bool);
        et_profession.setEnabled(bool);
        et_job_name.setEnabled(bool);
        et_work_years.setEnabled(bool);
        et_profession_card.setEnabled(bool);
        et_remark.setEnabled(bool);

        et_homework.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_username.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_age.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_education.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_profession.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_job_name.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_work_years.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_profession_card.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_remark.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        if (bool){
            markBool = false;
        }else {
            markBool = true;
        }
    }
}
