package com.zhhl.marketauthority.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.backlog.ApplyCategoryActivity;
import com.zhhl.marketauthority.activity.backlog.ApplyCompanyActivity;
import com.zhhl.marketauthority.activity.backlog.ApplyUnitResouse;
import com.zhhl.marketauthority.activity.backlog.DepartmentsActivity;
import com.zhhl.marketauthority.activity.backlog.InspectDeviceActivity;
import com.zhhl.marketauthority.activity.backlog.ManageStaff;
import com.zhhl.marketauthority.activity.backlog.PramaryDeviceActivity;
import com.zhhl.marketauthority.activity.backlog.ProduceActivity;
import com.zhhl.marketauthority.activity.backlog.SelfCheckDeviceActivity;
import com.zhhl.marketauthority.activity.backlog.SubcontractActivity;
import com.zhhl.marketauthority.bean.BacklogBean;
import com.zhhl.marketauthority.config.UrlConfig;
import com.zhhl.marketauthority.nohttp.listener.HttpListener;
import com.zhhl.marketauthority.util.GsonUtil;
import com.zhhl.marketauthority.util.ToastUtils;
import com.zhhl.marketauthority.view.dialog.BottomDialogFr;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 陈泽宇 on 2019/12/6.
 * Describe:待办事项 详情
 */
public class BacklogActivity extends BaseActivity {


    @BindView(R.id.name)
    TextView name;//申请单位
    @BindView(R.id.legalPerson)
    TextView legalPerson;//法定代表人
    @BindView(R.id.industry)
    TextView industry;//所属行业
    @BindView(R.id.establishment)
    TextView establishment;//成立日期
    @BindView(R.id.assets)
    TextView assets;//固定资产
    @BindView(R.id.registeredCapital)
    TextView registeredCapital;//注册资金
    @BindView(R.id.address)
    TextView address;//单位地址
    @BindView(R.id.sort)
    TextView sort;
    @BindView(R.id.children)
    TextView children;
    @BindView(R.id.level)
    TextView level;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.operating_2_state)
    ImageView operating2State;
    @BindView(R.id.equipment_1_state)
    ImageView equipment1State;
    @BindView(R.id.equipment_2_state)
    ImageView equipment2State;
    @BindView(R.id.equipment_3_state)
    ImageView equipment3State;
    @BindView(R.id.personnel_1_state)
    ImageView personnel1State;
    @BindView(R.id.personnel_2_state)
    ImageView personnel2State;
    @BindView(R.id.application_1_state)
    ImageView application1State;

    @Override
    protected int setContentView() {
        return R.layout.activity_backlog;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("待办事项");
        getData();
    }

    private void getData() {

        //Constants.URL_NOHTTP_POST
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_COMMON, RequestMethod.POST);
        request.add("N_L_ID","4cbd25f2d8874c2b9c69c6ff747f2573");
        request.add("N_B_ID","2dcb6349acc545c1a92d6c9253d89547");
        request.add("N_TYPE","1");
        request(0,request,httpListener,true,true);

    }
    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            BacklogBean backlogBean = GsonUtil.GsonToBean(response.get(), BacklogBean.class);
            if (backlogBean==null){
                System.out.println("==================================空空");
            }
            System.out.println("获取到的数据："+response.get());
            setData(backlogBean);
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            ToastUtils.show(BacklogActivity.this,"请求失败");
        }
    };

    private void setData(BacklogBean backlogBean) {
        BacklogBean.ObjBean.ResBean bean = backlogBean.getObj().getRes();
        name.setText(bean.getV_C_NAME());
        legalPerson.setText(bean.getV_LEGAL_PERSON());
        industry.setText(bean.getV_TRADE());
        establishment.setText(bean.getD_CREATE_DATE());
        assets.setText(bean.getFIXED_ASSETS());
        registeredCapital.setText(bean.getREGISTERED_CAPITAL());
        address.setText(bean.getV_ADDRESS());
    }

    @OnClick(R.id.review)
    public void onViewClicked() {
//        showToast("测试");
        BottomDialogFr bottomDialogFr = new BottomDialogFr();
        bottomDialogFr.show(getSupportFragmentManager(), "BacklogActivity");
    }

    @OnClick({R.id.company, R.id.apply_permission_sort, R.id.check, R.id.operating_rl_1, R.id.operating_rl_2, R.id.equipment_rl_1, R.id.equipment_rl_2, R.id.equipment_rl_3, R.id.personnel_rl_1, R.id.personnel_rl_2, R.id.application_rl_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.company://申请单位基本信息
                startActivity(new Intent(BacklogActivity.this, ApplyCompanyActivity.class));
                break;
            case R.id.apply_permission_sort://申请许可类别
                startActivity(new Intent(BacklogActivity.this, ApplyCategoryActivity.class));
                break;
            case R.id.check:
                startActivity(new Intent(BacklogActivity.this,CertificationActivity.class));//相关认证
                break;
            case R.id.operating_rl_1://试生产(制造)情况
                startActivity(new Intent(BacklogActivity.this, ProduceActivity.class));
                break;
            case R.id.operating_rl_2://分包、外协情况
                startActivity(new Intent(BacklogActivity.this, SubcontractActivity.class));
                break;
            case R.id.equipment_rl_1://自行校验一起设备能力
                startActivity(new Intent(BacklogActivity.this, SelfCheckDeviceActivity.class));
                break;
            case R.id.equipment_rl_2://主要生产设备状况
                startActivity(new Intent(BacklogActivity.this, PramaryDeviceActivity.class));
                break;
            case R.id.equipment_rl_3://主要检验与试验仪器设备状况
                startActivity(new Intent(BacklogActivity.this, InspectDeviceActivity.class));
                break;
            case R.id.personnel_rl_1://管理、专业、作业人员情况
                startActivity(new Intent(BacklogActivity.this, ManageStaff.class));
                break;
            case R.id.personnel_rl_2://各部门人员组成
                startActivity(new Intent(BacklogActivity.this, DepartmentsActivity.class));
                break;
            case R.id.application_rl_1://申请单位资源
                startActivity(new Intent(BacklogActivity.this, ApplyUnitResouse.class));
                break;
        }
    }
}
