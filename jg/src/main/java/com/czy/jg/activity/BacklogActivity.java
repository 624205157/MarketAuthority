package com.czy.jg.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.czy.commonlib.activity.BaseActivity;
import com.czy.commonlib.nohttp.listener.HttpListener;
import com.czy.commonlib.util.GsonUtil;
import com.czy.commonlib.util.ToastUtils;
import com.czy.jg.R;
import com.czy.jg.R2;
import com.czy.jg.UrlConfig;
import com.czy.jg.bean.BacklogBean;
import com.czy.jg.bean.JgCompany;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 陈泽宇 on 2019/12/6.
 * Describe:待办事项 详情
 */
public class BacklogActivity extends BaseActivity {


    @BindView(R2.id.name)
    TextView name;//申请单位
    @BindView(R2.id.legalPerson)
    TextView legalPerson;//法定代表人
    @BindView(R2.id.industry)
    TextView industry;//所属行业
    @BindView(R2.id.establishment)
    TextView establishment;//成立日期
    @BindView(R2.id.assets)
    TextView assets;//固定资产
    @BindView(R2.id.registeredCapital)
    TextView registeredCapital;//注册资金
    @BindView(R2.id.address)
    TextView address;//单位地址
    @BindView(R2.id.sort)
    TextView sort;//许可项目
    @BindView(R2.id.children)
    TextView children;//许可子项
    @BindView(R2.id.level)
    TextView level;//级别
    @BindView(R2.id.type)
    TextView type;//参数

    //    @BindView(R2.id.operating_2_state)
//    ImageView operating2State;
//    @BindView(R2.id.equipment_1_state)
//    ImageView equipment1State;
//    @BindView(R2.id.equipment_2_state)
//    ImageView equipment2State;
//    @BindView(R2.id.equipment_3_state)
//    ImageView equipment3State;
//    @BindView(R2.id.personnel_1_state)
//    ImageView personnel1State;
//    @BindView(R2.id.personnel_2_state)
//    ImageView personnel2State;
//    @BindView(R2.id.application_1_state)
//    ImageView application1State;
    @Override
    protected int setContentView() {
        return R.layout.jg_activity_backlog;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("待办事项");
        getData();
    }

    private void getData() {

        //Constants.URL_NOHTTP_POST
        Intent intent = getIntent();
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_COMMON, RequestMethod.POST);
        request.add("masterId", intent.getStringExtra("ID"));
        request(0, request, httpListener, true, true);

    }

    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            BacklogBean backlogBean = GsonUtil.GsonToBean(response.get(), BacklogBean.class);
//            N_L_ID =  backlogBean.getObj().getN_L_ID();
//            N_B_ID = backlogBean.getObj().getN_B_ID();
            setData(backlogBean);
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            ToastUtils.show(BacklogActivity.this, "请求失败");
        }
    };

    private void setData(BacklogBean backlogBean) {
        JgCompany bean = backlogBean.getObj().getIclicJgCompany().get(0);

        //申请单位基本信息
        name.setText(bean.getJgname());
        legalPerson.setText(bean.getJgfrname());
        industry.setText(bean.getIndustry());
        establishment.setText(bean.getEstablishdate());
        assets.setText(bean.getAssets());
        address.setText(bean.getJgaddress());
        //申请许可类别
        if (backlogBean.getObj().getHzxmList().size() > 0) {
            BacklogBean.Hzxm bean1 = backlogBean.getObj().getHzxmList().get(0);
            sort.setText(bean1.getHztier());
            children.setText(bean1.getHzproject());
            level.setText(bean1.getPermittype());
            type.setText(bean1.getProjectcode());
        }
    }

//    @OnClick(R.id.review)
//    public void onViewClicked() {
////        showToast("测试");
//        BottomDialogFr bottomDialogFr = new BottomDialogFr();
//        bottomDialogFr.setN_B_ID(N_B_ID);
//        bottomDialogFr.show(getSupportFragmentManager(), "BacklogActivity");
//    }

    @OnClick({R2.id.review
//            ,R2.id.company, R2.id.apply_permission_sort, R2.id.check, R2.id.operating_rl_1, R2.id.operating_rl_2, R2.id.equipment_rl_1, R2.id.equipment_rl_2, R2.id.equipment_rl_3, R2.id.personnel_rl_1, R2.id.personnel_rl_2, R2.id.application_rl_1
    })
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        int id = view.getId();
//        if (id == R.id.company) {//申请单位基本信息
////                startActivity(new Intent(BacklogActivity.this, ApplyCompanyActivity.class));
//            intent.setClass(mContext, ApplyCompanyActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.apply_permission_sort) {//申请许可类别
////                startActivity(new Intent(BacklogActivity.this, ApplyAllowListActivity.class));
//            intent.setClass(mContext, ApplyAllowListActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.check) {//相关认证
//            intent.setClass(mContext, CertificationListActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.operating_rl_1) {//试生产(制造)情况
//            intent.setClass(mContext, ProduceListActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.operating_rl_2) {//分包、外协情况
//            intent.setClass(mContext, SubcontractListActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.equipment_rl_1) {//自行校验仪器设备能力
//            intent.setClass(mContext, SelfCheckDeviceListActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.equipment_rl_2) {//主要生产设备状况
//            intent.setClass(mContext, PramaryDeviceListActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.equipment_rl_3) {//主要检验与试验仪器设备状况
//            intent.setClass(mContext, InspectDeviceListActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.personnel_rl_1) {//管理、专业、作业人员情况
////                startActivity(new Intent(BacklogActivity.this, ManageStaffListActivity.class));
//            intent.setClass(mContext, ManageStaffListActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.personnel_rl_2) {//各部门人员组成
////                startActivity(new Intent(BacklogActivity.this, DepartmentsActivity.class));
//            intent.setClass(mContext, DepartmentsActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.application_rl_1) {//申请单位资源
////                startActivity(new Intent(BacklogActivity.this, ApplyUnitResouse.class));
//            intent.setClass(mContext, ApplyUnitResouse.class);
//            startActivity(intent);
//        } else
        if (id == R.id.review) {//                BottomDialogFr bottomDialogFr = new BottomDialogFr();
//                bottomDialogFr.setN_B_ID(N_B_ID);
//                bottomDialogFr.show(getSupportFragmentManager(), "BacklogActivity");

            intent.setClass(mContext, ReviewActivity.class);
            intent.putExtra("ID", getIntent().getStringExtra("ID"));
            startActivityForResult(intent, 10);
            overridePendingTransition(R.anim.dialog_fr_in, R.anim.dialog_fr_out_hide);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            finish();
        }

    }
}
