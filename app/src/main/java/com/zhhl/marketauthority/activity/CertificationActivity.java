package com.zhhl.marketauthority.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.czy.commonlib.activity.BaseActivity;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.adapter.CertificationAdapter;
import com.czy.commonlib.bean.Certification;
import com.czy.commonlib.listener.EditTextChangeListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 陈泽宇 on 2019/12/11.
 * Describe:相关认证
 */
public class CertificationActivity extends BaseActivity implements EditTextChangeListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.submit)
    TextView submit;
    private CertificationAdapter mAdapter;
    private List<Certification> mData = new ArrayList<>();

    @Override
    protected int setContentView() {
        return R.layout.activity_certification;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("相关认证");
        ImageView change = addChange();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change.setVisibility(View.INVISIBLE);
                submit.setVisibility(View.VISIBLE);
                mAdapter.setToChange(true);
            }
        });

        mAdapter = new CertificationAdapter(mData, this);
        mAdapter.openLoadAnimation();
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter);

        getData();
    }

    @OnClick(R.id.submit)
    public void onViewClicked() {
        //return mData
    }

    @Override
    public void haveChange(Certification certification, int position) {
        mData.set(position, certification);
    }

    private void getData(){
        Certification certification1 = new Certification();
        certification1.setName("长春市红日新能源有限责任公司");
        certification1.setOrganization("其他认证机构");
        certification1.setData("2019-12-5");
        certification1.setValidity("1年");
        mData.add(certification1);

        Certification certification2 = new Certification();
        certification2.setName("长春市红日新能源有限责任公司");
        certification2.setOrganization("其他认证机构");
        certification2.setData("2019-12-5");
        certification2.setValidity("1年");
        mData.add(certification2);

        Certification certification3 = new Certification();
        certification3.setName("长春市红日新能源有限责任公司");
        certification3.setOrganization("其他认证机构");
        certification3.setData("2019-12-5");
        certification3.setValidity("1年");
        mData.add(certification3);

        mAdapter.notifyDataSetChanged();

    }
}
