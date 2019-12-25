package com.zhhl.marketauthority.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.backlog.ApplyUnitResouse;
import com.zhhl.marketauthority.util.UntilsTime;

import java.util.Date;

public class BottomDialogFr extends DialogFragment {

    private View frView;
    private Window window;
    private TextView et_updatetime;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 去掉默认的标题
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        frView = inflater.inflate(R.layout.dialog_fr_bottom, null);
        init();
        return frView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private void init() {
        et_updatetime = frView.findViewById(R.id.et_updatetime);
        et_updatetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.et_updatetime:
                        TimePickerView pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
                            @Override
                            public void onTimeSelect(Date date, View v) {
                                String time = UntilsTime.getTime(date);
                                et_updatetime.setText(time);

                            }
                        }).setType(new boolean[]{true, true, true, true, true, true}).isDialog(true).build();
                        pvTime.show();
                        break;
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // 下面这些设置必须在此方法(onStart())中才有效

        window = getDialog().getWindow();
        // 如果不设置这句代码, 那么弹框就会与四边都有一定的距离
        window.setBackgroundDrawableResource(android.R.color.transparent);
        // 设置动画
        window.setWindowAnimations(R.style.bottomDialog);
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        // 如果不设置宽度,那么即使你在布局中设置宽度为 match_parent 也不会起作用
        params.width = getResources().getDisplayMetrics().widthPixels;
        window.setAttributes(params);
    }
}
