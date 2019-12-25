package com.zhhl.marketauthority.activity.backlog;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
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

//各部门人员组成
public class DepartmentsActivity extends BaseActivity {
    @BindView(R.id.tv_name1)
    TextView tv_name1;//工程部负责人
    @BindView(R.id.tv_count1)
    TextView tv_count1;//工程部人数
    @BindView(R.id.tv_name2)
    TextView tv_name2;//维修部负责人
    @BindView(R.id.tv_count2)
    TextView tv_count2;//维修部人数
    @BindView(R.id.tv_name3)
    TextView tv_name3;//设计部负责人
    @BindView(R.id.tv_count3)
    TextView tv_count3;//设计部人数
    @BindView(R.id.tv_name4)
    TextView tv_name4;//后勤部负责人
    @BindView(R.id.tv_count4)
    TextView tv_count4;//后勤部人数
    @BindView(R.id.tv_name5)
    TextView tv_name5;//综合部负责人
    @BindView(R.id.tv_count5)
    TextView tv_count5;//综合部人数
    @BindView(R.id.tv_name6)
    TextView tv_name6;//客服部负责人
    @BindView(R.id.tv_count6)
    TextView tv_count6;//客服部人数
    @BindView(R.id.tv_name7)
    TextView tv_name7;//行政部负责人
    @BindView(R.id.tv_count7)
    TextView tv_count7;//行政部人数
    @BindView(R.id.tv_name8)
    TextView tv_name8;//财政部负责人
    @BindView(R.id.tv_count8)
    TextView tv_count8;//财政部人数
    @BindView(R.id.et_updatetime)
    TextView et_updatetime;//评审时间
    @BindView(R.id.et_idea)
    EditText et_idea;//评审意见
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.regular)
    RadioButton regular;
    @BindView(R.id.unregular)
    RadioButton unregular;
    private ImageView back;
    private ImageView change;
    private Boolean markBool = true;
    List<String> selectList = new ArrayList<String>();
    FullyGridLayoutManager manager;
    GridImageAdapter adapter;
    private static final int REQUESTCODE = 100;
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

    @OnClick({R.id.et_updatetime})
    public void onClickView(View view){
            switch (view.getId()){
                case R.id.et_updatetime:
                    //时间选择器
                    TimePickerView pvTime = new TimePickerBuilder(DepartmentsActivity.this, new OnTimeSelectListener() {
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
    private void changeSate(Boolean bool) {
        et_updatetime.setEnabled(bool);
        et_idea.setEnabled(bool);
        regular.setEnabled(bool);
        unregular.setEnabled(bool);
        et_updatetime.setBackground(ContextCompat.getDrawable(DepartmentsActivity.this,R.drawable.background_arc_3));
        et_idea.setBackground(ContextCompat.getDrawable(DepartmentsActivity.this,R.drawable.background_arc_3));

    }

    private void init() {
        manager = new FullyGridLayoutManager(this,
                1, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new GridSpacingItemNotBothDecoration(5,
                ScreenUtils.dip2px(DepartmentsActivity.this, 4), true, false));
        adapter = new GridImageAdapter(DepartmentsActivity.this, onAddPicClickListener);
        adapter.setList(selectList);//设置数据
        recycler.setAdapter(adapter);
    }

    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

            manager = new FullyGridLayoutManager(DepartmentsActivity.this,
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
        System.out.println("请求吗是多少："+requestCode);
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
}
