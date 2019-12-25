package com.zhhl.marketauthority.activity.backlog;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;
import com.zhhl.marketauthority.adapter.GridImageAdapter;
import com.zhhl.marketauthority.util.ScreenUtils;
import com.zhhl.marketauthority.util.UntilsTime;
import com.zhhl.marketauthority.view.FullyGridLayoutManager;
import com.zhhl.marketauthority.view.GridSpacingItemNotBothDecoration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

//申请单位资源
public class ApplyUnitResouse extends BaseActivity {

    private ImageView back;
    private ImageView change;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.et_area_all)
    EditText et_area_all;//占地面积
    @BindView(R.id.et_area_exposure)
    EditText et_area_exposure;//曝光室面积
    @BindView(R.id.et_code)
    EditText et_code;//统一社会信用代码
    @BindView(R.id.et_count)
    EditText et_count;//焊接人员数
    @BindView(R.id.et_ability)
    EditText et_ability;//设计能力(种)
    @BindView(R.id.et_area_workshop)
    EditText et_area_workshop;//厂房面积
    @BindView(R.id.et_count_design)
    EditText et_count_design;//设计人员数
    @BindView(R.id.et_legal)
    EditText et_legal;//法定代表人
    @BindView(R.id.et_count_other)
    EditText et_count_other;//其他专业人员数
    @BindView(R.id.et_output)
    EditText et_output;//年产值
    @BindView(R.id.et_updatetime)
    TextView et_updatetime;//评审时间
    @BindView(R.id.et_idea)
    EditText et_idea;//评审意见
    @BindView(R.id.radio_result)
    RadioGroup radio_result;//评审结果
    @BindView(R.id.regular)
    RadioButton regular;
    @BindView(R.id.unregular)
    RadioButton unregular;
    private boolean markBool;
    List<String> selectList = new ArrayList<String>();
    FullyGridLayoutManager manager;
    GridImageAdapter adapter;
    private static final int REQUESTCODE = 100;
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
                if (markBool){
                    markBool = false;
                }else{
                    markBool = true;
                }
                changeSate(markBool);
//                mAdapter.setToChange(true);
            }
        });
        init();
        setData();
    }
    @OnClick({R.id.et_updatetime})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.et_updatetime:
                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(ApplyUnitResouse.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = UntilsTime.getTime(date);
                        et_updatetime.setText(time);

                    }
                }).setType(new boolean[]{true, true, true, true, true, true}).build();
                pvTime.show();
                break;
        }
    }
    private void init() {
        manager = new FullyGridLayoutManager(this,
                1, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new GridSpacingItemNotBothDecoration(5,
                ScreenUtils.dip2px(ApplyUnitResouse.this, 4), true, false));
        adapter = new GridImageAdapter(ApplyUnitResouse.this, onAddPicClickListener);
        adapter.setList(selectList);//设置数据
        recycler.setAdapter(adapter);
    }
    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

            manager = new FullyGridLayoutManager(ApplyUnitResouse.this,
                    selectList.size()+1, GridLayoutManager.VERTICAL, false);
            recycler.setLayoutManager(manager);
            getPermissions(REQUESTCODE);

        }
    };
    private void setData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 101) {
            Log.i("CJT", "picture");
            String path = data.getStringExtra("path");
//            photo.setImageBitmap(BitmapFactory.decodeFile(path));
            selectList.add(path);
            if (selectList.size()<5){
                manager = new FullyGridLayoutManager(this,
                        selectList.size()+1, GridLayoutManager.VERTICAL, false);
                recycler.setLayoutManager(manager);
//                recycler.addItemDecoration(new GridSpacingItemNotBothDecoration(selectList.size(),
//                                ScreenUtils.dip2px(ApplyUnitResouse.this, 4), true, false));
            }
            adapter.notifyDataSetChanged();
        }
        if (resultCode == 102) {
            Log.i("CJT", "video");
            String path = data.getStringExtra("path");
        }
        if (resultCode == 103) {
            Toast.makeText(this, "请检查相机权限~", Toast.LENGTH_SHORT).show();
        }
    }

    private void changeSate(boolean bool) {
        et_area_all.setEnabled(bool);
        et_area_exposure.setEnabled(bool);
        et_code.setEnabled(bool);
        et_count.setEnabled(bool);
        et_ability.setEnabled(bool);
        et_area_workshop.setEnabled(bool);
        et_count_design.setEnabled(bool);
        et_legal.setEnabled(bool);
        et_count_other.setEnabled(bool);
        et_output.setEnabled(bool);
        et_updatetime.setEnabled(bool);
        et_idea.setEnabled(bool);
//        radio_result.setEnabled(bool);
        regular.setEnabled(bool);
        unregular.setEnabled(bool);
        //设置评审结果的显示
        if (bool) {
            et_area_all.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_area_exposure.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_code.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_count.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_ability.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_area_workshop.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_count_design.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_legal.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_count_other.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_output.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_updatetime.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            et_idea.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this, R.drawable.background_arc_3));
            if (TextUtils.isEmpty(et_idea.getText().toString())){
                et_idea.setHint("请您填写评审意见");
            }
        } else {//修改完，保存后的效果设置
            et_area_all.setBackground(null);
            et_area_exposure.setBackground(null);
            et_code.setBackground(null);
            et_count.setBackground(null);
            et_ability.setBackground(null);
            et_area_workshop.setBackground(null);
            et_count_design.setBackground(null);
            et_legal.setBackground(null);
            et_count_other.setBackground(null);
            et_output.setBackground(null);
            if (TextUtils.isEmpty(et_idea.getText().toString())){
                et_idea.setHint("");
                et_idea.setText("");
            }
        }
    }


}
