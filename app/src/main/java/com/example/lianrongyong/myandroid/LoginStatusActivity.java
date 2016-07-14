package com.example.lianrongyong.myandroid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class LoginStatusActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_status);

        saveInFile();

    }

    //定义显示接收Activity传入值的TextView
    private TextView tv_main_result = null;

    private void saveInFile() {
        //SharedPreferences 保存数据的实现代码
        SharedPreferences sharedPreferences =
                getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
//如果不能找到Editor接口。尝试使用 SharedPreferences.Editor
        editor.putString("user_id", "aaaaaaabbbbbbbb");
//我将用户信息保存到其中，你也可以保存登录状态
        editor.commit();

        //取sharedpreferences中数据的代码
        String user_id = "";
        SharedPreferences sharedPreferencesGet =
                getSharedPreferences("user", Context.MODE_PRIVATE);
        user_id = sharedPreferencesGet.getString("user_id", "null");
        System.out.println("---------------------------userId:" + user_id);

        tv_main_result = (TextView) findViewById(R.id.tv_main_result);
        tv_main_result.setText("保存的内容为:"+user_id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_status, menu);
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
