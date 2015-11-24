package com.doudou.cn.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * Created by jinliang on 15/11/24.
 */
public class TestActivity extends Activity {
    private WebView  webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        ResultObj resultObj = new ResultObj(this);

        webview.addJavascriptInterface(resultObj, "android");
        webview.loadUrl("file:///android_asset/huhu.html");

    }

    class ResultObj {
        private Context con;
        public ResultObj(Context con) {
            this.con = con;
        }
        @JavascriptInterface
        public String getResult(String top, String end) {
            return top  + end;
        }
    }
}
