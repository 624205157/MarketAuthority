package com.zhhl.marketauthority.fragment;


import com.czy.commonlib.fragment.GroupPopFragment;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.fragment.my.MyCenterFragment;

public class Fragment3 extends GroupPopFragment {


    @Override
    protected void lazyLoad() {
        if (findChildFragment(MyCenterFragment.class) == null) {
            loadRootFragment(R.id.home, new MyCenterFragment());
        }
    }

}
