package com.zhhl.marketauthority.activity.backlog;

import android.content.Intent;
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
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;
import com.zhhl.marketauthority.adapter.GridImageSecAdapter;
import com.zhhl.marketauthority.bean.ApplyCompanyBean;
import com.zhhl.marketauthority.bean.InspectDeviceBean;
import com.zhhl.marketauthority.bean.SelfCheckDeviceBean;
import com.zhhl.marketauthority.config.UrlConfig;
import com.zhhl.marketauthority.nohttp.listener.HttpListener;
import com.zhhl.marketauthority.util.GsonUtil;
import com.zhhl.marketauthority.util.ScreenUtils;
import com.zhhl.marketauthority.util.ToastUtils;
import com.zhhl.marketauthority.util.UntilsTime;
import com.zhhl.marketauthority.view.FullyGridLayoutManager;
import com.zhhl.marketauthority.view.GridSpacingItemNotBothDecoration;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

//主要检验与试验仪器设备状况
public class InspectDeviceActivity extends BaseActivity {
    @BindView(R.id.et_name_device)
    EditText et_name_device;//cl_1 仪器设备名称
    @BindView(R.id.et_equipment_devcie)
    EditText et_equipment_devcie;//cl_1 仪器设备能力
    @BindView(R.id.et_count_device)
    EditText et_count_device;//cl_1 仪器设备数
    @BindView(R.id.et_device_type)
    EditText et_device_type;//规格型号
    @BindView(R.id.et_use_data)
    TextView et_use_data;//投用日期
    @BindView(R.id.radio_result)
    RadioGroup radio_result;//评审结果
    @BindView(R.id.regular)
    RadioButton regular;//合格
    @BindView(R.id.unregular)
    RadioButton unregular;//不合格
    @BindView(R.id.submit)
    TextView submit;//提交
    @BindView(R.id.et_updatetime)
    TextView et_updatetime;
    @BindView(R.id.et_idea)
    TextView et_idea;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private ImageView back;
    private ImageView change;
    private Boolean markBool = true;
    List<String> selectList = new ArrayList<String>();
    FullyGridLayoutManager manager;
    GridImageSecAdapter adapter;
    private static final int REQUESTCODE = 100;
    InspectDeviceBean.ObjBean.ResBean resBean;
    private String result = "0";
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
            }
        });
        init();
        getData();
    }

    private void getData() {
        resBean = (InspectDeviceBean.ObjBean.ResBean) getIntent().getExtras().get("data");
        setData(resBean);

    }
    @OnClick({R.id.submit,R.id.et_use_data,R.id.et_updatetime})
    public void onClickView(View view){
        switch (view.getId()) {
            case R.id.submit:
                uploadData();
                break;
            case R.id.et_use_data:
                TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = UntilsTime.getTime(date);
                        et_use_data.setText(time);

                    }
                }).setType(new boolean[]{true, true, true, false, false, false}).isDialog(false).build();
                pvTime.show();
                break;
            case R.id.et_updatetime:
                TimePickerView pvTime2 = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = UntilsTime.getTime(date);
                        et_updatetime.setText(time);

                    }
                }).setType(new boolean[]{true, true, true, true, true, true}).isDialog(false).build();
                pvTime2.show();
                break;
        }}

    private void uploadData() {
        String name_device = et_name_device.getText().toString();
        String equipment_devcie = et_equipment_devcie.getText().toString();
        String count_device = et_count_device.getText().toString();
        String device_type = et_device_type.getText().toString();
        String updatetime = et_updatetime.getText().toString();
        String use_date = et_use_data.getText().toString();
        String idea =  et_idea.getText().toString();//评审意见


        if (TextUtils.isEmpty(updatetime)){
            showToast("请选择评审时间");
            return;
        }
        if (TextUtils.isEmpty(use_date)){
            showToast("请选择投用日期");
            return;
        }

        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_UPLOAD_DATA, RequestMethod.POST);
        Map<String,Object> map = new HashMap<>();
        map.put("id",resBean.getN_T_ID());
        map.put("tjlx","8");
        map.put("v_t_name",name_device);
        map.put("v_t_type",device_type);
        map.put("d_t_begin",use_date);
        map.put("v_t_num",count_device);
        map.put("v_t_perfor",equipment_devcie);
        map.put("pssj",updatetime);
        map.put("psyj",idea);
        map.put("pszt",result);
        request.add(map);
        request(1,request,httpListener,true,true);
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

    private void setData(InspectDeviceBean.ObjBean.ResBean resBean) {
        et_name_device.setText(resBean.getV_T_NAME());//cl_1 仪器设备名称
        et_equipment_devcie.setText(resBean.getV_T_PERFOR());//cl_1 仪器设备能力
        et_count_device.setText(resBean.getV_T_NUM());//cl_1 仪器设备数
        et_device_type.setText(resBean.getV_T_TYPE());//规格型号
        et_use_data.setText(resBean.getD_T_BEGIN());//投用日期
        et_updatetime.setText(resBean.getPSSJ());//评审时间
        et_idea.setText(resBean.getPSYJ());
        if (resBean.getPSZT().equals("0")){
            regular.setChecked(false);
            unregular.setChecked(false);
        }else if(resBean.getPSZT().equals("1")){
            regular.setChecked(true);
            unregular.setChecked(false);
        }else if(resBean.getPSZT().equals("2")){
            regular.setChecked(false);
            unregular.setChecked(true);
        }
    }

    private void init() {
        manager = new FullyGridLayoutManager(this,
                1, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new GridSpacingItemNotBothDecoration(5,
                ScreenUtils.dip2px(InspectDeviceActivity.this, 4), true, false));
        adapter = new GridImageSecAdapter(InspectDeviceActivity.this, onAddPicClickListener,onDelete);
//        adapter.setList(selectList);//设置数据
        recycler.setAdapter(adapter);

        radio_result.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.regular:
                        result = "1";
                        break;
                    case R.id.unregular:
                        result = "2";
                        break;
                }
            }
        });

    }
    private GridImageSecAdapter.onAddPicClickListener onAddPicClickListener = new GridImageSecAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

            getPermissions(REQUESTCODE);

        }
    };
    private GridImageSecAdapter.OnDelete onDelete = new GridImageSecAdapter.OnDelete() {
        @Override
        public void onItemDelete(int mark) {
        }
    };

    private void changeSate(Boolean markBool) {
        et_name_device.setEnabled(markBool);
        et_equipment_devcie.setEnabled(markBool);
        et_count_device.setEnabled(markBool);
        radio_result.setEnabled(markBool);
        et_device_type.setEnabled(markBool);
        et_use_data.setEnabled(markBool);
        et_name_device.setBackground(ContextCompat.getDrawable(mContext,R.drawable.background_arc_3));
        et_equipment_devcie.setBackground(ContextCompat.getDrawable(mContext,R.drawable.background_arc_3));
        et_count_device.setBackground(ContextCompat.getDrawable(mContext,R.drawable.background_arc_3));
        et_device_type.setBackground(ContextCompat.getDrawable(mContext,R.drawable.background_arc_3));
        et_use_data.setBackground(ContextCompat.getDrawable(mContext,R.drawable.background_arc_3));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 101) {
            Log.i("CJT", "picture");
            String path = data.getStringExtra("path");
            if (requestCode ==REQUESTCODE){
            selectList.add(path);
            }
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
