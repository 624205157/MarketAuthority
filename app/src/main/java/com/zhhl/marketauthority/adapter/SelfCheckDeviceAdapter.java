package com.zhhl.marketauthority.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.bean.Backlog;
import com.zhhl.marketauthority.bean.ProduceBean;
import com.zhhl.marketauthority.bean.SelfCheckDeviceBean;

import java.util.List;

public class SelfCheckDeviceAdapter extends BaseQuickAdapter<SelfCheckDeviceBean.ObjBean.ResBean, BaseViewHolder> {

    public SelfCheckDeviceAdapter(List<SelfCheckDeviceBean.ObjBean.ResBean> data) {
        super(R.layout.item_selfcheckdevice, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, SelfCheckDeviceBean.ObjBean.ResBean item) {
        helper.setText(R.id.tv_title,"仪器设备名称："+item.getV_V_NAME());
    }
}
