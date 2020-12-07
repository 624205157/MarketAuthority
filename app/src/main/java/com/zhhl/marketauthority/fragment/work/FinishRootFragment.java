package com.zhhl.marketauthority.fragment.work;

import com.zhhl.marketauthority.R;
import com.czy.commonlib.fragment.GroupPopFragment;

public class FinishRootFragment extends GroupPopFragment {

    @Override
    protected void lazyLoad() {
        if (findChildFragment(FinishFragment.class) == null) {
            loadRootFragment(R.id.home, new FinishFragment());
        }
    }


}
