package com.zhhl.marketauthority.activity;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.config.UrlConfig;

public class PreviewReport extends BaseActivity {
    private String N_L_ID ;
    @Override
    protected int setContentView() {
        return R.layout.activity_preview_report;
    }

    @Override
    protected void onCreate() {
        N_L_ID = getIntent().getStringExtra("N_L_ID");
        WebView webView = findViewById(R.id.mywebview);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
                return true;
            }
        });
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);//设置webview推荐使用的窗口
        webSettings.setLoadWithOverviewMode(true);//设置webview加载的页面的模式
        webSettings.setDisplayZoomControls(false);//隐藏webview缩放按钮
        webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        webSettings.setSupportZoom(true); // 支持缩放
//        webView.loadUrl(UrlConfig.PAHT_REPORT);
        webView.loadUrl(UrlConfig.PAHT_PRE_REPORT+"?nlId="+N_L_ID);
    }
}
