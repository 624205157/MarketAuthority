package com.zhhl.marketauthority.activity.backlog;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.czy.commonlib.activity.BaseActivity;
import com.zhhl.marketauthority.adapter.GridImageSecAdapter;
import com.zhhl.marketauthority.bean.DepartmentsBean;
import com.czy.commonlib.UrlConfig;
import com.czy.commonlib.nohttp.listener.HttpListener;
import com.czy.commonlib.util.DensityUtils;
import com.czy.commonlib.util.GsonUtil;
import com.czy.commonlib.util.ScreenUtils;
import com.czy.commonlib.util.ToastUtils;
import com.czy.commonlib.util.UntilsTime;
import com.czy.commonlib.view.FullyGridLayoutManager;
import com.czy.commonlib.view.GridSpacingItemNotBothDecoration;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

//各部门人员组成
public class DepartmentsActivity extends BaseActivity {
    @BindView(R.id.et_updatetime)
    TextView et_updatetime;//评审时间
    @BindView(R.id.et_idea)
    EditText et_idea;//评审意见
    @BindView(R.id.radio_result)
    RadioGroup radio_result;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.regular)
    RadioButton regular;
    @BindView(R.id.unregular)
    RadioButton unregular;
    @BindView(R.id.table_depart)
    TableLayout table_depart;
    private ImageView back;
    private ImageView change;
    private Boolean markBool = true;
    List<String> selectList = new ArrayList<String>();
    private List<DepartmentsBean.ObjBean.ResBean> mData = new ArrayList<>();
    FullyGridLayoutManager manager;
    GridImageSecAdapter adapter;
    DepartmentsBean.ObjBean.ResBean resBean;
    private String result = "0";
    @Override
    protected int setContentView() {

        return R.layout.activity_departments;

    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("各部门人员组成");
        change = addChange();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSate(markBool);
            }
        });
        change.setVisibility(View.INVISIBLE);
        init();
        getData();
    }

    //动态创建表格，填入数据
    private void addTow(List<DepartmentsBean.ObjBean.ResBean> mData) {
        for (int i=0;i<mData.size();i++){
            //TableRow的布局设置
            TableRow tableRow = new TableRow(mContext);
            tableRow.setDividerDrawable(ContextCompat.getDrawable(mContext,R.drawable.background_table));
            tableRow.setShowDividers(LinearLayout.SHOW_DIVIDER_BEGINNING|LinearLayout.SHOW_DIVIDER_MIDDLE|LinearLayout.SHOW_DIVIDER_END);
            tableRow.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            for (int j=0;j<3;j++){
                //TableRow中的TextView布局设置
                TextView textView = new TextView(mContext);
                int len = DensityUtils.dip2px(mContext,  8.0f);
                textView.setPadding(len,len,len,len);
                textView.setLayoutParams(new TableRow.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
                textView.setTextColor(ContextCompat.getColor(mContext,R.color.title_text));
                if (j==0){
                    textView.setText(mData.get(i).getV_D_DEPARTMENT());
                }else if(j==1){
                    textView.setText(mData.get(i).getV_D_PERSON());
                }else if(j==2){
                    textView.setText(mData.get(i).getV_D_NUM());
                }
                tableRow.addView(textView);
            }
            table_depart.addView(tableRow);
        }
    }

    private void getData() {
        Intent intent = getIntent();
        String N_L_ID =  intent.getStringExtra("N_L_ID");
        String N_B_ID =  intent.getStringExtra("N_B_ID");
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_COMMON, RequestMethod.POST);
        request.add("N_L_ID",N_L_ID);
        request.add("N_B_ID",N_B_ID);
        request.add("N_TYPE","10");
        request(0,request,httpListener,true,true);

    }
    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            if (what==0){
                System.out.println("各部门数据："+response.get());
                DepartmentsBean result = GsonUtil.GsonToBean(response.get(), DepartmentsBean.class);
                List<DepartmentsBean.ObjBean.ResBean> resBeans = result.getObj().getRes();
                resBean = resBeans.get(0);
                addTow(resBeans);
                setData(resBean);
            }else if(what==1){
                ToastUtils.show(mContext,"修改成功");
                finish();
            }

        }

        @Override
        public void onFailed(int what, Response<String> response) {
            ToastUtils.show(mContext,"请求失败");
        }
    };

    private void setData(DepartmentsBean.ObjBean.ResBean resBean) {
        et_updatetime.setText(resBean.getPSSJ());
        et_idea.setText(resBean.getPSYJ());
        if (resBean.getPSZT().equals("0")){
            regular.setChecked(false);
            unregular.setChecked(false);
        }else if(resBean.getPSZT().equals("1")){
            regular.setChecked(true);
            unregular.setChecked(false);
        }else if(resBean.getPSZT().equals("2")){
            regular.setChecked(false);
            unregular.setChecked(true);
        }
    }

    @OnClick({R.id.et_updatetime,R.id.submit})
    public void onClickView(View view){
        switch (view.getId()){
            case R.id.et_updatetime:
                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(DepartmentsActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = UntilsTime.getTime(date);
                        et_updatetime.setText(time);

                    }
                }).setType(new boolean[]{true, true, true, true, true, true}).build();
                pvTime.show();
                break;
            case R.id.submit:
                uploadData();
                break;
        }
    }

    private void uploadData() {
        String update_time =  et_updatetime.getText().toString();//评审时间
        String idea = et_idea.getText().toString();//评审意见
        if (TextUtils.isEmpty(update_time)){
            showToast("请选择评审时间");
            return;
        }
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_UPLOAD_DATA, RequestMethod.POST);
        Map<String,Object> map = new HashMap<>();
        map.put("id",resBean.getN_D_ID());
        map.put("tjlx","10");
        map.put("pssj",update_time);
        map.put("psyj",idea);
        map.put("pszt",result);
        request.add(map);
        request(1,request,httpListener,true,true);
    }

    private void changeSate(Boolean bool) {
        et_updatetime.setEnabled(bool);
        et_idea.setEnabled(bool);
        regular.setEnabled(bool);
        unregular.setEnabled(bool);
        et_updatetime.setBackground(ContextCompat.getDrawable(DepartmentsActivity.this,R.drawable.background_arc_3));
        et_idea.setBackground(ContextCompat.getDrawable(DepartmentsActivity.this,R.drawable.background_arc_3));

    }

    private void init() {
        manager = new FullyGridLayoutManager(this,
                5, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new GridSpacingItemNotBothDecoration(5,
                ScreenUtils.dip2px(DepartmentsActivity.this, 4), true, false));
        adapter = new GridImageSecAdapter(DepartmentsActivity.this, onAddPicClickListener,onDelete);
//        adapter.setList(selectList);//设置数据
        recycler.setAdapter(adapter);

        radio_result.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.regular:
                        result = "1";
                        break;
                    case R.id.unregular:
                        result = "2";
                        break;
                }
            }
        });
    }

    private GridImageSecAdapter.onAddPicClickListener onAddPicClickListener = new GridImageSecAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

        }
    };
    private GridImageSecAdapter.OnDelete onDelete = new GridImageSecAdapter.OnDelete() {
        @Override
        public void onItemDelete(int mark) {
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 101) {
            Log.i("CJT", "picture");
            String path = data.getStringExtra("path");
//            photo.setImageBitmap(BitmapFactory.decodeFile(path));
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
