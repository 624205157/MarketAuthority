package com.zhhl.marketauthority.activity.backlog;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.czy.commonlib.activity.BaseActivity;
import com.zhhl.marketauthority.bean.ApplyAllowBean;
import com.czy.commonlib.UrlConfig;
import com.czy.commonlib.nohttp.listener.HttpListener;
import com.czy.commonlib.util.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

//申请许可类别
public class ApplyAllowActivity extends BaseActivity {
    @BindView(R.id.submit)
    TextView submit;
    @BindView(R.id.et_unit)
    EditText et_unit;//许可项目
    @BindView(R.id.et_unit_chaild)
    EditText et_unit_chaild;//许可子项
    @BindView(R.id.et_level)
    TextView et_level;//许可级别
    @BindView(R.id.et_param)
    EditText et_param;//参数
    @BindView(R.id.et_formal_unit)
    EditText et_formal_unit;//型式试验单位
    @BindView(R.id.et_product)
    EditText et_product;//单位地址
    private ImageView back;
    private ImageView change;
    ApplyAllowBean.ObjBean.ResBean resBean;
    @Override
    protected int setContentView() {
        return R.layout.activity_applycateory;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("申请许可类别");
        change = addChange();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSate();
            }
        });
        getData();
    }
    private void getData() {

        resBean = (ApplyAllowBean.ObjBean.ResBean) getIntent().getExtras().get("data");
        setData(resBean);

    }
    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            if (what==1){
                ToastUtils.show(mContext,"修改成功");
                finish();
            }
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            ToastUtils.show(mContext,"请求失败");
        }
    };
    @OnClick({R.id.submit})
    public void onViewClick(View view){
        switch (view.getId()) {
            case R.id.submit:
                uploadData();
                break;
        }

    }

    private void uploadData() {
        submit.setVisibility(View.INVISIBLE);
        change.setVisibility(View.VISIBLE);
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_UPLOAD_DATA, RequestMethod.POST);
        Map<String,Object> map = new HashMap<>();
        map.put("id",resBean.getN_LT_ID());//主键表ID
        map.put("tjlx","2");//提交类型
//        map.put("n_first_id",et_unit.getText());//许可项目
//        map.put("n_second_id",et_unit_chaild.getText());//许可子项
//        map.put("n_third_id",et_level.getText());//许可级别
//        map.put("v_para_id",et_param.getText());//参数
        map.put("v_unit",et_formal_unit.getText());//型式试验单位
        map.put("v_production",et_product.getText());//代表作品
        request.add(map);
        request(1,request,httpListener,true,true);
    }

    private void changeSate() {
        change.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.VISIBLE);
//        et_unit.setEnabled(true);
//        et_unit_chaild.setEnabled(true);
//        et_level.setEnabled(true);
//        et_param.setEnabled(true);
        et_formal_unit.setEnabled(true);
        et_product.setEnabled(true);
//        et_unit.setBackground(ContextCompat.getDrawable(ApplyAllowActivity.this,R.drawable.background_arc_3));
//        et_unit_chaild.setBackground(ContextCompat.getDrawable(ApplyAllowActivity.this,R.drawable.background_arc_3));
//        et_level.setBackground(ContextCompat.getDrawable(ApplyAllowActivity.this,R.drawable.background_arc_3));
//        et_param.setBackground(ContextCompat.getDrawable(ApplyAllowActivity.this,R.drawable.background_arc_3));
        et_formal_unit.setBackground(ContextCompat.getDrawable(ApplyAllowActivity.this,R.drawable.background_arc_3));
        et_product.setBackground(ContextCompat.getDrawable(ApplyAllowActivity.this,R.drawable.background_arc_3));
    }

    private void setData(ApplyAllowBean.ObjBean.ResBean resBean) {
        et_unit.setText(resBean.getN_FIRST_ID());//许可类别
        et_unit_chaild.setText(resBean.getN_SECOND_ID());//许可子项
        et_level.setText(resBean.getN_THIRD_ID());//许可级别
        et_param.setText(resBean.getV_PARA_ID());//参数
        et_formal_unit.setText(resBean.getV_UNIT());//型式试验单位
        et_product.setText(resBean.getV_PRODUCTION());//代表产品

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
