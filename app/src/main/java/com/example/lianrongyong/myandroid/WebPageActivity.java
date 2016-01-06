package com.example.lianrongyong.myandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class WebPageActivity extends Activity {

    //定义跳转的Button按钮
    private Button btn_rs_skip = null;

    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        initView();
    }

    /**
     * 初始化控件信息
     */
    private void initView() {
        //接收Activity传过来的值
        final Intent data = getIntent();

        btn_rs_skip = (Button) findViewById(R.id.btn_rs_skip);
        btn_rs_skip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {//采用Intent绑定Bundle的形式回传值

                //新建一个Bundle，Bundle主要放值类型
                Bundle bundle = new Bundle();
                bundle.putString("rs", "我是WebPageActivity关闭后回传的值！");
                //将Bundle赋给Intent
                data.putExtras(bundle);
                //跳转回MainActivity
                //注意下面的RESULT_OK常量要与回传接收的Activity中onActivityResult（）方法一致
                WebPageActivity.this.setResult(RESULT_OK, data);
                //关闭当前activity
                WebPageActivity.this.finish();
            }
        });


        webView = (WebView) findViewById(R.id.Toweb);
        webView.loadUrl("http://www.baidu.com");

        //设置可自由缩放网页
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);

        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }


    /**
     * 4、如何使得物理返回键实现页面上翻而不是退出程序
     * 用过浏览器的同学应该都知道，
     * 浏览网页时点按手机上的返回键并不会导致程序的退出，
     * 而是回到之前打开的网页，
     * 这时候就需要重写onKeyDown(keyCode, event)方法 改写物理按键返回的逻辑。以下是设置方法：
     */

    //重写onKeyDown(keyCode, event)方法 改写物理按键 返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //TODO 先测试一下，再用这代码
        /*
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();//返回上一页面
                return true;
            } else {
                System.exit(0);//退出程序
            }
        }
        */
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
