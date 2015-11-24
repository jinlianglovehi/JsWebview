package com.doudou.cn.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.doudou.cn.myapplication.webview.InjectedChromeClient;

public class WebActivity extends Activity {
    @SuppressLint("JavascriptInterface")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView wv = new WebView(this);
        setContentView(wv);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);

        ResultObject resultObject = new ResultObject(this);
        wv.addJavascriptInterface(resultObject, "demo");


//        wv.setWebChromeClient(
//            new CustomChromeClient("HostApp", HostJsScope.class)
//        );
        wv.loadUrl("file:///android_asset/test.html");
    }


    public class ResultObject {
        Activity activity;

        public ResultObject(Activity activity) {
            this.activity = activity;
        }
        @SuppressLint("JavascriptInterface")
        public String testMethod(final String str1, final String str2) {

            Log.i("WebActivity", "-----获取的数据：" + str1 + "--" + str2);
            String rtnStr;

            rtnStr = str1 + str2;
            //to-do
            return rtnStr;
        }

    }
    public class CustomChromeClient extends InjectedChromeClient {

        public CustomChromeClient (String injectedName, Class injectedCls) {
            super(injectedName, injectedCls);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            // to do your work
            // ...
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public void onProgressChanged (WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            // to do your work
            // ...
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            // to do your work
            // ...
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }
    }
}
