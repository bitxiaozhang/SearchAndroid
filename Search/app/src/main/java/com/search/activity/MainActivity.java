package com.search.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.search.JsonParseModel;
import com.search.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private String[] datas = new String[]{"search","openTimeListView","Custom","BGARefresh",
            "PercentLayout","QRCode","WatchView","SMS_MOB","SlideLockView"};
    private StickyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        listView = (ListView) findViewById(R.id.rl_modulename_refresh);
        adapter = new StickyAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void test() {
        try {
            JSONObject jsonObject = new JSONObject("{\"count\":11,\"msg\":\"提交成功\",\"eventList\":[{\"startDate\":\"2015-12-06 09:00:00\",\"isFull\":0,\"matchStartDate\":\"2016-03-15 11:22:11\",\"status\":4,\"isNative\":0,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/9c4991d10f354f8aa82d290c47cee9af\\/_thumbs\\/images\\/marathon\\/marathonEvent\\/2015\\/12\\/%E9%95%87%E6%B1%9F(1).jpg\",\"endDate\":\"2015-12-31 14:36:34\",\"collection\":0,\"code\":0,\"remind\":0,\"content\":\"000\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"2\",\"likes\":0,\"outUrl\":\"\",\"name\":\"2015年镇江国际半程马拉松\",\"matchEndDate\":\"2016-03-24 11:22:14\",\"mini\":0},{\"startDate\":\"2016-04-15 08:00:00\",\"isFull\":0,\"matchStartDate\":\"2016-04-22 16:02:54\",\"status\":1,\"isNative\":0,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/9c4991d10f354f8aa82d290c47cee9af\\/_thumbs\\/images\\/marathon\\/marathonEvent\\/2015\\/12\\/%E6%B8%A9%E5%B7%9E.jpg\",\"endDate\":\"2016-04-15 17:00:00\",\"collection\":0,\"code\":0,\"remind\":1,\"content\":\"wu00\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"965d25c4ba684207b202f1a99e53274e\",\"likes\":0,\"outUrl\":\"\",\"name\":\"2015年温州马拉松\",\"matchEndDate\":\"2016-04-29 16:02:55\",\"mini\":0},{\"startDate\":\"2016-04-01 07:30:00\",\"isFull\":0,\"matchStartDate\":\"2016-04-25 16:00:37\",\"status\":1,\"isNative\":0,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/9c4991d10f354f8aa82d290c47cee9af\\/_thumbs\\/images\\/marathon\\/marathonEvent\\/2015\\/12\\/%E6%9D%AD%E5%B7%9E.jpg\",\"endDate\":\"2016-04-20 16:00:00\",\"collection\":0,\"code\":0,\"remind\":1,\"content\":\"啊0\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"eb8ec114c1344e43aeec4fc3354566b7\",\"likes\":0,\"outUrl\":\"\",\"name\":\"2015杭州马拉松\",\"matchEndDate\":\"2016-04-30 16:00:39\",\"mini\":0},{\"startDate\":\"2016-04-03 08:00:00\",\"isFull\":0,\"matchStartDate\":\"2016-04-20 15:59:52\",\"status\":2,\"isNative\":0,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/1\\/images\\/marathon\\/marathonEvent\\/2016\\/03\\/yuanan.jpg\",\"endDate\":\"2016-04-15 12:00:00\",\"collection\":0,\"code\":0,\"remind\":1,\"content\":\"1.报名者已阅读本赛事竞赛规程和组委会发布的赛事责任声明。\\r\\n2.本报名系统规定了报名者须接受组委会网上报名的各项条款。为完成全部报名过程，须认真阅读、理解并同意接受竞赛规程和相关规定。\\r\\n3.报名者依照收费标准，在提交报名申请的同时，须在规定时间内完成网上支付流程，逾期即未报名成功。\\r\\n4.鉴于组委会将根据您提交的信息为您购买保险和提供相关其他服务，报名者应真实、准确填写个人信息，正确选择比赛项目，如提供不实、不详信息，后果由报名者自负。\\r\\n5.跑跑网报名支付成功后，如需退费按赛事组委会相关规定执行。\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"fc79f09f993548eba8b8fc44b839fa10\",\"likes\":0,\"outUrl\":\"\",\"name\":\"2016远安国际田野马拉松\",\"matchEndDate\":\"2016-04-26 15:59:54\",\"mini\":0},{\"startDate\":\"2016-04-01 07:00:00\",\"isFull\":0,\"matchStartDate\":\"2016-04-27 16:00:44\",\"status\":2,\"isNative\":0,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/9c4991d10f354f8aa82d290c47cee9af\\/_thumbs\\/images\\/marathon\\/marathonEvent\\/2015\\/12\\/%E4%B8%8A%E6%B5%B7.jpg\",\"endDate\":\"2016-04-09 17:00:00\",\"collection\":0,\"code\":0,\"remind\":0,\"content\":\"00\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"51b997524d6a47bda65c0eff0e1a720b\",\"likes\":0,\"outUrl\":\"\",\"name\":\"2015上海国际马拉松\",\"matchEndDate\":\"2016-04-28 16:00:45\",\"mini\":0},{\"startDate\":\"2016-03-27 09:00:00\",\"isFull\":0,\"matchStartDate\":\"2016-04-08 16:00:01\",\"status\":4,\"isNative\":0,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/9c4991d10f354f8aa82d290c47cee9af\\/_thumbs\\/images\\/marathon\\/marathonEvent\\/2016\\/01\\/%E4%B8%BD%E6%B0%B4%E9%A9%AC%E6%8B%89%E6%9D%BE.jpg\",\"endDate\":\"2016-04-06 12:00:00\",\"collection\":0,\"code\":0,\"remind\":0,\"content\":\"1.报名者已阅读本赛事竞赛规程和组委会发布的赛事责任声明。\\r\\n2.本报名系统规定了报名者须接受组委会网上报名的各项条款。为完成全部报名过程，须认真阅读、理解并同意接受竞赛规程和相关规定。\\r\\n3.报名者依照收费标准，在提交报名申请的同时，须在规定时间内完成网上支付流程，逾期即未报名成功。\\r\\n4.鉴于组委会将根据您提交的信息为您购买保险和提供相关其他服务，报名者应真实、准确填写个人信息，正确选择比赛项目，如提供不实、不详信息，后果由报名者自负。\\r\\n5.跑跑网报名支付成功后，如需退费按赛事组委会相关规定执行。\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"1d2d8477b8f14c55a29b24a324cc98a5\",\"likes\":0,\"outUrl\":\"\",\"name\":\"2016丽水半程马拉松赛\",\"matchEndDate\":\"2016-04-08 16:00:03\",\"mini\":0},{\"startDate\":\"2015-12-26 09:30:00\",\"isFull\":0,\"matchStartDate\":\"2016-03-21 16:00:25\",\"status\":4,\"isNative\":0,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/1\\/_thumbs\\/images\\/marathon\\/marathonEvent\\/2015\\/12\\/123456.jpg\",\"endDate\":\"2015-12-22 00:00:00\",\"collection\":0,\"code\":0,\"remind\":0,\"content\":\"户外跑是一项高负荷大强度长距离的活动，也是一项高风险的活动，对参加者身体状况有较高的要求，参赛者应身体健康，有长期参加跑步锻炼或训练的基础，参加活动者可根据自己的身体状况和实际能力进行报名，有以下疾病患者不宜参加活动： \\r\\n1、先天性心脏病和风湿性心脏病患者； \\r\\n2、高血压和脑血管疾病患者； \\r\\n3、心肌炎和其它心脏病患者；\\r\\n4、冠状动脉病患者和严重心律不齐者； \\r\\n5、血糖过高或过少的糖尿病患者；\\r\\n6、其它不适合运动的疾病患者。 \\r\\n在活动中，因个人身体及其他个人原因导致的人身损害和财产损失，由参加活动者个人承\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"b272446189264e3eb860c052eba4d483\",\"likes\":0,\"outUrl\":\"\",\"name\":\"2015彭州山地半程马拉松\",\"matchEndDate\":\"2016-03-21 16:00:27\",\"mini\":0},{\"startDate\":\"2016-01-10 08:00:00\",\"isFull\":0,\"matchStartDate\":\"2016-03-21 16:00:17\",\"status\":4,\"isNative\":1,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/1\\/_thumbs\\/images\\/marathon\\/marathonEvent\\/2016\\/01\\/QQ%E6%B5%8F%E8%A7%88%E5%99%A8%E6%88%AA%E5%B1%8F%E6%9C%AA%E5%91%BD%E5%90%8D(3).png\",\"endDate\":\"2016-01-28 17:30:00\",\"collection\":0,\"code\":0,\"remind\":0,\"content\":\"00\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"c17d456ce1094776af3508d0fd75e774\",\"likes\":0,\"outUrl\":\"http:\\/\\/www.yangling-marathon.com\\/\",\"name\":\"2016杨凌农科城国际马拉松\",\"matchEndDate\":\"2016-04-01 16:00:19\",\"mini\":0},{\"startDate\":\"2015-04-26 08:00:00\",\"isFull\":0,\"matchStartDate\":\"2015-05-21 16:00:31\",\"status\":4,\"isNative\":0,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/9c4991d10f354f8aa82d290c47cee9af\\/_thumbs\\/images\\/marathon\\/marathonEvent\\/2015\\/12\\/01(1).jpg\",\"endDate\":\"2015-03-31 17:00:00\",\"collection\":0,\"code\":0,\"remind\":0,\"content\":\"00\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"a624980ed0434221baa51998b0f8043b\",\"likes\":0,\"outUrl\":\"\",\"name\":\"黄河口（东营）国际马拉松赛\",\"matchEndDate\":\"2015-03-21 16:00:33\",\"mini\":0},{\"startDate\":\"2015-10-17 09:30:00\",\"isFull\":0,\"matchStartDate\":\"2016-03-21 16:00:50\",\"status\":4,\"isNative\":0,\"half\":0,\"image\":\"\\/Running\\/userfiles\\/9c4991d10f354f8aa82d290c47cee9af\\/_thumbs\\/images\\/marathon\\/marathonEvent\\/2015\\/12\\/%E9%95%BF%E5%9F%8E.jpg\",\"endDate\":\"2016-01-01 12:00:00\",\"collection\":0,\"code\":0,\"remind\":0,\"content\":\"30\",\"share\":0,\"hits\":0,\"full\":0,\"event\":\"fd537858436d419abf2a40cb6215e079\",\"likes\":0,\"outUrl\":\"\",\"name\":\"2015长城马拉松\",\"matchEndDate\":\"2016-03-21 16:00:52\",\"mini\":0}],\"code\":1}");
            JsonParseModel model = new Gson().fromJson(jsonObject.toString(), JsonParseModel.class);
            Log.e("test", "asd");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0: {
                Intent intent = new Intent(this, SearchEventActivity.class);
                startActivity(intent);
            }
            break;
            case 1: {
                Intent intent = new Intent(this, TimerListViewActivity.class);
                startActivity(intent);
            }
            break;
            case 2: {
                Intent intent = new Intent(this, CustomDrawActivity.class);
                startActivity(intent);
            }
            case 3:
            {
                Intent intent = new Intent(this, BGARefreshActivity.class);
                startActivity(intent);
            }
            break;
            case 4:
            {
                Intent intent = new Intent(this,PercentLayoutAcitivty.class);
                startActivity(intent);
            }
            break;
            case 5:{
                Intent intent = new Intent(this,QRCodeActivity.class);
                startActivity(intent);
            }
            break;
            case 6:
            {
                Intent intent = new Intent(this,WatchViewActivity.class);
                startActivity(intent);
            }
            break;
            case 7:
            {
                Intent intent = new Intent(this,MobSMSActivity.class);
                startActivity(intent);
            }
            break;
            case 8:
            {
                Intent intent = new Intent(this,SlideLockActivity.class);
                startActivity(intent);
            }
            default:
                break;
        }
    }

    private class StickyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return datas.length;
        }

        @Override
        public Object getItem(int i) {
            return datas.length;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.stick_item_layout, null);
            }
            ((TextView) view.findViewById(R.id.title)).setText(datas[i]);
            return view;
        }
    }
}
