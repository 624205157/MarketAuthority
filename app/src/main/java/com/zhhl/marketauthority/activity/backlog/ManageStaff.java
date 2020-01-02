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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;
import com.zhhl.marketauthority.adapter.GridImageAdapter;
import com.zhhl.marketauthority.bean.BacklogBean;
import com.zhhl.marketauthority.config.UrlConfig;
import com.zhhl.marketauthority.nohttp.listener.HttpListener;
import com.zhhl.marketauthority.util.GsonUtil;
import com.zhhl.marketauthority.util.ScreenUtils;
import com.zhhl.marketauthority.util.ToastUtils;
import com.zhhl.marketauthority.view.FullyGridLayoutManager;
import com.zhhl.marketauthority.view.GridSpacingItemNotBothDecoration;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private ImageView back;
    private ImageView change;
    private Boolean markBool = true;
    FullyGridLayoutManager manager;
    GridImageAdapter adapter;
    List<String> selectList = new ArrayList<String>();
    private static final int REQUESTCODE = 100;
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
        getData();
    }
    private void getData() {

        //Constants.URL_NOHTTP_POST
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_COMMON, RequestMethod.POST);
        request.add("N_L_ID","4cbd25f2d8874c2b9c69c6ff747f2573");
        request.add("N_B_ID","2dcb6349acc545c1a92d6c9253d89547");
        request.add("N_TYPE","9");
        request(0,request,httpListener,true,true);

    }
    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            BacklogBean backlogBean = GsonUtil.GsonToBean(response.get(), BacklogBean.class);
            if (backlogBean!=null){
//                setData(backlogBean);
            }
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            ToastUtils.show(mContext,"请求失败");
        }
    };
    private void setData() {
         et_homework.setText("");//作业项目
         et_username.setText("");//姓名
         et_age.setText("");//年龄
         et_education.setText("");//学历
         et_profession.setText("");//专业
         et_job_name.setText("");//职称
         et_work_years.setText("");//从事专业工作年限
         et_profession_card.setText("");//持专业证
         et_remark.setText("");//备注(注明从事专业)
    }

    private void init() {
        manager = new FullyGridLayoutManager(this,
                1, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new GridSpacingItemNotBothDecoration(5,
                ScreenUtils.dip2px(ManageStaff.this, 4), true, false));
        adapter = new GridImageAdapter(ManageStaff.this, onAddPicClickListener);
        adapter.setList(selectList);//设置数据
        recycler.setAdapter(adapter);
    }

    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

            manager = new FullyGridLayoutManager(ManageStaff.this,
                    selectList.size()+1, GridLayoutManager.VERTICAL, false);
            recycler.setLayoutManager(manager);
            getPermissions(REQUESTCODE);

        }
    };

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
        et_updatetime.setEnabled(bool);
        et_idea.setEnabled(bool);
        et_homework.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_username.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_age.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_education.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_profession.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_job_name.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_work_years.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_profession_card.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_remark.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_updatetime.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        et_idea.setBackground(ContextCompat.getDrawable(ManageStaff.this,R.drawable.background_arc_3));
        if (bool){
            markBool = false;
        }else {
            markBool = true;
        }
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
}
