package com.zhhl.marketauthority.fragment.my;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 陈泽宇 on 2019/12/4.
 * Describe:个人中心
 */
public class MyCenterFragment extends BaseFragment {
    @BindView(R.id.head_portrait)
    ImageView headPortrait;
    @BindView(R.id.id_card)
    TextView idCard;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.phone_num)
    TextView phoneNum;


    @Override
    protected int setContentView() {
        return R.layout.fragment_my_center;
    }

    @Override
    protected void lazyLoad() {

    }




    @OnClick({R.id.version_iv, R.id.exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.version_iv:
                break;
            case R.id.exit:
                break;
        }
    }
}
