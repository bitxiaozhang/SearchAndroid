package com.search.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.search.R;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class MobSMSActivity extends Activity {
    private EventHandler eventHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mob_sms);

        SMSSDK.initSDK(this, "12bcf9d6a2018", "26cdf01444c415d77503967ed11577b1");
        eventHandler=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {

                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               Toast.makeText(MobSMSActivity.this, "提交验证码成功", Toast.LENGTH_LONG).show();
                           }
                       });
                        //提交验证码成功
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MobSMSActivity.this, "获取验证码成功", Toast.LENGTH_LONG).show();
                            }
                        });
                        //获取验证码成功
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MobSMSActivity.this, "返回支持发送验证码的国家列表", Toast.LENGTH_LONG).show();
                            }
                        });


                        //返回支持发送验证码的国家列表
                    }
                }else{
                    ((Throwable)data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eventHandler);
    }

    public void getSMS(View view){
//        SMSSDK.getSupportedCountries();
        SMSSDK.getVerificationCode("86", "17746579101");
        for(int i = 0;i<99;i++){
            String s = "17746579";
            SMSSDK.getVerificationCode("86", s+(100+i));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
