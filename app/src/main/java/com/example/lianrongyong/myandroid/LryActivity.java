package com.example.lianrongyong.myandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LryActivity extends Activity {

    //定义显示接收Activity传入值的TextView
    private TextView tv_main_result = null;
    //定义跳转的Button按钮
    private Button btn_main_skip = null;
    //定义一个startActivityForResult（）方法用到的整型值
    private final int requestCode = 1500;

    /**
     * 初始化控件信息
     * */
    public void initView(){
        tv_main_result = (TextView)findViewById(R.id.tv_main_result);
        btn_main_skip = (Button)findViewById(R.id.btn_main_skip);
        btn_main_skip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LryActivity.this,ReturnActivity.class);
                //采用Intent普通传值的方式
                intent.putExtra("skip", "我是LryActivity传过来的值！");
                //跳转Activity
                startActivityForResult(intent, requestCode);
            }
        });
    }


    /**
     * 接收当前Activity跳转后，目标Activity关闭后的回传值
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(resultCode){
            case RESULT_OK:{//接收并显示Activity传过来的值
                Bundle bundle = data.getExtras();
                String rs = bundle.getString("rs");
                tv_main_result.setText(rs);
                break;
            }
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lry);
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lry, menu);
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
