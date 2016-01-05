package com.example.lianrongyong.myandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReturnActivity extends Activity {

    //定义显示接收Activity传入值的TextView
    private TextView tv_rs_result = null;
    //定义跳转的Button按钮
    private Button btn_rs_skip = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        initView();
    }

    /**
     * 初始化控件信息
     * */
    private void initView(){
        //接收Activity传过来的值
        final Intent data = getIntent();
        tv_rs_result = (TextView)findViewById(R.id.tv_rs_result);
        //将Activity传过来的值赋给textview显示
        tv_rs_result.setText(data.getStringExtra("skip"));

        btn_rs_skip = (Button)findViewById(R.id.btn_rs_skip);
        btn_rs_skip.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {//采用Intent绑定Bundle的形式回传值

                //新建一个Bundle，Bundle主要放值类型
                Bundle bundle = new Bundle();
                bundle.putString("rs", "我是RsActivity关闭后回传的值！");
                //将Bundle赋给Intent
                data.putExtras(bundle);
                //跳转回MainActivity
                //注意下面的RESULT_OK常量要与回传接收的Activity中onActivityResult（）方法一致
                ReturnActivity.this.setResult(RESULT_OK, data);
                //关闭当前activity
                ReturnActivity.this.finish();
            }
        });
    }
}
