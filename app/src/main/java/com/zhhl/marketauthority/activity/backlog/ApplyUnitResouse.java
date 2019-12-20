package com.zhhl.marketauthority.activity.backlog;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;
import com.zhhl.marketauthority.adapter.GridImageAdapter;
import com.zhhl.marketauthority.util.ScreenUtils;
import com.zhhl.marketauthority.view.FullyGridLayoutManager;
import com.zhhl.marketauthority.view.GridSpacingItemNotBothDecoration;

import butterknife.BindView;

//申请单位资源
public class ApplyUnitResouse extends BaseActivity {

    private ImageView back;
    private ImageView change;
    GridImageAdapter adapter;
//    @BindView(R.id.recycler)
//    RecyclerView recycler;
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
    EditText et_updatetime;//评审时间
    @BindView(R.id.et_idea)
    EditText et_idea;//评审意见
    @BindView(R.id.radio_result)
    RadioGroup radio_result;//评审结果
    @BindView(R.id.regular)
    RadioButton regular;
    @BindView(R.id.unregular)
    RadioButton unregular;
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
        init();
        setData();
    }

    private void init() {
//        FullyGridLayoutManager manager = new FullyGridLayoutManager(this,
//                4, GridLayoutManager.VERTICAL, false);
//        recycler.setLayoutManager(manager);
//        recyclerView.addItemDecoration(new GridSpacingItemNotBothDecoration(4,
//                ScreenUtils.dip2px(ApplyUnitResouse.this, 8), true, false));
//        adapter = new GridImageAdapter(ApplyUnitResouse.this, onAddPicClickListener);
//      adapter.setList(selectList);//设置数据
//        recycler.setAdapter(adapter);
    }
    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

        }
    };
    private void setData() {

    }
    private void changeSate() {
        et_area_all.setEnabled(true);
        et_area_exposure.setEnabled(true);
        et_code.setEnabled(true);
        et_count.setEnabled(true);
        et_ability.setEnabled(true);
        et_area_workshop.setEnabled(true);
        et_count_design.setEnabled(true);
        et_legal.setEnabled(true);
        et_count_other.setEnabled(true);
        et_output.setEnabled(true);
        et_updatetime.setEnabled(true);
        et_idea.setEnabled(true);
        radio_result.setEnabled(true);
        //设置评审结果的显示
        unregular.setVisibility(View.VISIBLE);
        et_area_all.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_area_exposure.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_code.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_count.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_ability.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_area_workshop.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_count_design.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_legal.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_count_other.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_output.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_updatetime.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
        et_idea.setBackground(ContextCompat.getDrawable(ApplyUnitResouse.this,R.drawable.background_arc_3));
    }
}
