package com.zhhl.marketauthority.activity.backlog;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;
import com.zhhl.marketauthority.adapter.GridImageAdapter;
import com.zhhl.marketauthority.adapter.GridImageSecAdapter;
import com.zhhl.marketauthority.adapter.GridImageThiAdapter;
import com.zhhl.marketauthority.util.ScreenUtils;
import com.zhhl.marketauthority.view.FullyGridLayoutManager;
import com.zhhl.marketauthority.view.GridSpacingItemNotBothDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//主要设备生产状况
public class PramaryDeviceActivity extends BaseActivity {
    @BindView(R.id.et_name_device)
    EditText et_name_device;//cl_1 仪器设备名称
    @BindView(R.id.et_equipment_devcie)
    EditText et_equipment_devcie;//cl_1 仪器设备能力
    @BindView(R.id.et_count_device)
    EditText et_count_device;//cl_1 仪器设备数
    @BindView(R.id.radio_result)
    RadioGroup radio_result;//评审结果
    @BindView(R.id.regular)
    RadioButton regular;//合格
    @BindView(R.id.unregular)
    RadioButton unregular;//不合格

    @BindView(R.id.et_name_device2)
    EditText et_name_device2;//cl_2 仪器设备名称
    @BindView(R.id.et_equipment_devcie2)
    EditText et_equipment_devcie2;//cl_2 仪器设备能力
    @BindView(R.id.et_count_device2)
    EditText et_count_device2;//cl_2 仪器设备数
    @BindView(R.id.et_idea)
    EditText et_idea;//cl_2 评审意见
    @BindView(R.id.radio_result2)
    RadioGroup radio_result2;//cl_2评审结果
    @BindView(R.id.regular2)
    RadioButton regular2;//cl_2合格
    @BindView(R.id.unregular2)
    RadioButton unregular2;//cl_2不合格

    @BindView(R.id.et_name_device3)
    EditText et_name_device3;//cl_3 仪器设备名称
    @BindView(R.id.et_equipment_devcie3)
    EditText et_equipment_devcie3;//cl_3 仪器设备能力
    @BindView(R.id.et_count_device3)
    EditText et_count_device3;//cl_3 仪器设备数
    @BindView(R.id.radio_result3)
    RadioGroup radio_result3;//cl_3评审结果
    @BindView(R.id.regular3)
    RadioButton regular3;//cl_3合格
    @BindView(R.id.unregular3)
    RadioButton unregular3;//cl_3不合格

    @BindView(R.id.submit)
    TextView submit;//提交
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.recycler2)
    RecyclerView recycler2;
    @BindView(R.id.recycler3)
    RecyclerView recycler3;
    private ImageView back;
    private ImageView change;
    private Boolean markBool = true;
    List<String> selectList = new ArrayList<String>();
    FullyGridLayoutManager manager;
    FullyGridLayoutManager manager2;
    FullyGridLayoutManager manager3;
    GridImageAdapter adapter;

    List<String> selectList2 = new ArrayList<String>();
    GridImageSecAdapter adapter2;

    List<String> selectList3 = new ArrayList<String>();
    GridImageThiAdapter adapter3;
    private static final int REQUESTCODE = 100;
    private static final int REQUESTCODE2 = 101;
    private static final int REQUESTCODE3 = 102;
    @Override
    protected int setContentView() {
        return R.layout.activity_pramary_device;
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
//                mAdapter.setToChange(true);
            }
        });
        init();
        setData();
    }

    private void setData() {

    }

    private void init() {
        manager = new FullyGridLayoutManager(this,
                1, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new GridSpacingItemNotBothDecoration(5,
                ScreenUtils.dip2px(PramaryDeviceActivity.this, 4), true, false));
        adapter = new GridImageAdapter(PramaryDeviceActivity.this, onAddPicClickListener);
        adapter.setList(selectList);//设置数据
        recycler.setAdapter(adapter);

        manager2 = new FullyGridLayoutManager(this,
                1, GridLayoutManager.VERTICAL, false);
        recycler2.setLayoutManager(manager2);
        recycler2.addItemDecoration(new GridSpacingItemNotBothDecoration(5,
                ScreenUtils.dip2px(PramaryDeviceActivity.this, 4), true, false));
        adapter2 = new GridImageSecAdapter(PramaryDeviceActivity.this, onAddPicClickListener2);
        adapter2.setList(selectList2);//设置数据
        recycler2.setAdapter(adapter2);

        manager3 = new FullyGridLayoutManager(this,
                1, GridLayoutManager.VERTICAL, false);
        recycler3.setLayoutManager(manager3);
        recycler3.addItemDecoration(new GridSpacingItemNotBothDecoration(5,
                ScreenUtils.dip2px(PramaryDeviceActivity.this, 4), true, false));
        adapter3 = new GridImageThiAdapter(PramaryDeviceActivity.this, onAddPicClickListener3);
        adapter3.setList(selectList3);//设置数据
        recycler3.setAdapter(adapter3);
    }
    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

            manager = new FullyGridLayoutManager(PramaryDeviceActivity.this,
                    selectList.size()+1, GridLayoutManager.VERTICAL, false);
            recycler.setLayoutManager(manager);
            getPermissions(REQUESTCODE);

            System.out.println("第一部分");

        }
    };
    private GridImageSecAdapter.onAddPicClickListener onAddPicClickListener2 = new GridImageSecAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

            manager2 = new FullyGridLayoutManager(PramaryDeviceActivity.this,
                    selectList2.size()+1, GridLayoutManager.VERTICAL, false);
            recycler2.setLayoutManager(manager2);
            getPermissions(REQUESTCODE2);
            System.out.println("第二部分");

        }
    };
    private GridImageThiAdapter.onAddPicClickListener onAddPicClickListener3 = new GridImageThiAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

            manager3 = new FullyGridLayoutManager(PramaryDeviceActivity.this,
                    selectList3.size()+1, GridLayoutManager.VERTICAL, false);
            recycler3.setLayoutManager(manager3);
            getPermissions(REQUESTCODE3);
            System.out.println("第三部分");

        }
    };


    private void changeSate(Boolean markBool) {
        et_name_device.setEnabled(markBool);
        et_equipment_devcie.setEnabled(markBool);
        et_count_device.setEnabled(markBool);
        radio_result.setEnabled(markBool);
        et_name_device.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));
        et_equipment_devcie.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));
        et_count_device.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));

        et_name_device2.setEnabled(markBool);
        et_equipment_devcie2.setEnabled(markBool);
        et_count_device2.setEnabled(markBool);
        radio_result2.setEnabled(markBool);
        et_idea.setEnabled(markBool);
        et_name_device2.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));
        et_equipment_devcie2.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));
        et_count_device2.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));
        et_idea.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));

        et_name_device3.setEnabled(markBool);
        et_equipment_devcie3.setEnabled(markBool);
        et_count_device3.setEnabled(markBool);
        radio_result3.setEnabled(markBool);

        et_name_device3.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));
        et_equipment_devcie3.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));
        et_count_device3.setBackground(ContextCompat.getDrawable(PramaryDeviceActivity.this,R.drawable.background_arc_3));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("请求验证码："+requestCode);
        if (resultCode == 101) {
            Log.i("CJT", "picture");
            String path = data.getStringExtra("path");
            if (requestCode ==REQUESTCODE){
            selectList.add(path);
            if (selectList.size()<5){
                manager = new FullyGridLayoutManager(this,
                        selectList.size()+1, GridLayoutManager.VERTICAL, false);
                recycler.setLayoutManager(manager);
            }
            adapter.notifyDataSetChanged();
            }
            if (requestCode == REQUESTCODE2){
                selectList2.add(path);
                if (selectList2.size()<5){
                    manager2 = new FullyGridLayoutManager(this,
                            selectList2.size()+1, GridLayoutManager.VERTICAL, false);
                    recycler2.setLayoutManager(manager2);
                }
                adapter2.notifyDataSetChanged();
            }
            if (requestCode == REQUESTCODE3){
                selectList3.add(path);
                if (selectList3.size()<5){
                    manager3 = new FullyGridLayoutManager(this,
                            selectList3.size()+1, GridLayoutManager.VERTICAL, false);
                    recycler3.setLayoutManager(manager3);
                }
                adapter3.notifyDataSetChanged();
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
