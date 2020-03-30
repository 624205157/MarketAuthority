package com.zhhl.marketauthority.fragment.work;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.fragment.GroupPopFragment;

public class BacklogRootFragment extends GroupPopFragment {

    @Override
    protected void lazyLoad() {
        if (findChildFragment(BacklogFragment.class) == null) {
            loadRootFragment(R.id.home, new BacklogFragment());
        }
    }
}
