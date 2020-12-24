package com.czy.jg.media;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.czy.commonlib.activity.BaseActivity;
import com.czy.jg.R;
import com.czy.jg.R2;
import com.czy.jg.UrlConfig;

import butterknife.BindView;
import butterknife.OnClick;

public class PicturePreviewActivity extends BaseActivity {
    @BindView(R2.id.left_back)
    ImageButton left_back;
    @BindView(R2.id.preview_image)
    ImageView preview_image;
    @BindView(R2.id.picture_title)
    TextView picture_title;
    @Override
    protected int setContentView() {
        return R.layout.jg_activity_preview_pic;
    }

    @Override
    protected void onCreate() {
        Intent intent = getIntent();
        String position = intent.getStringExtra("position");
        String sum = intent.getStringExtra("sum");
        String id = intent.getStringExtra("id");
        String path = intent.getStringExtra("path");
        String mediatype = intent.getStringExtra("mediatype");
        mediatype = "0";//强制设置为0, 0代表显示图片
        picture_title.setText(position+"/"+sum);
        if (path!=null && path.length()>1){
            Glide.with(this)
                    .load(path)
                    .into(preview_image);
        }else{
            Glide.with(this)
                    .load(UrlConfig.PATH_SHOW_IMG+"?mogondbId="+id+"&mediatype="+mediatype)
                    .into(preview_image);
        }

    }

    @OnClick({R2.id.left_back,})
    public void onClickView(View view){
        if (view.getId() == R.id.left_back) {
            this.finish();
        }
    }
}