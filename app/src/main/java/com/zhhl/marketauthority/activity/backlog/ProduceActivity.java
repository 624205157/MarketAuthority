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
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
        getData();
    }

    private void getData() {

        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_COMMON, RequestMethod.POST);
        request.add("N_L_ID","4cbd25f2d8874c2b9c69c6ff747f2573");
        request.add("N_B_ID","2dcb6349acc545c1a92d6c9253d89547");
        request.add("N_TYPE","4");
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
    public void setData(){
         et_name_product.setText("");//产品名称
         et_device_type.setText("");//设备品种/类别
         et_param_level.setText("");//参数级别
         et_device_model.setText("");//设备型号
    };
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
        manager = new FullyGridLayoutManager(this,
                1, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new GridSpacingItemNotBothDecoration(5,
                ScreenUtils.dip2px(ProduceActivity.this, 4), true, false));
        adapter = new GridImageAdapter(ProduceActivity.this, onAddPicClickListener);
        adapter.setList(selectList);//设置数据
        recycler.setAdapter(adapter);
    }
    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

            manager = new FullyGridLayoutManager(ProduceActivity.this,
                    selectList.size()+1, GridLayoutManager.VERTICAL, false);
            recycler.setLayoutManager(manager);
            getPermissions(REQUESTCODE);

        }
    };

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
