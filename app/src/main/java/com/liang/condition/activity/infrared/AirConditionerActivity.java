package com.liang.condition.activity.infrared;

import android.hardware.ConsumerIrManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liang.condition.activity.BaseActivity;
import com.liang.condition.R;
import com.liang.condition.date.CodeCommand;



//需要api大于19与下面if判断用途类似
@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class AirConditionerActivity extends BaseActivity implements View.OnClickListener {
    //获取红外控制类
    private ConsumerIrManager IR;
    //显示详细信息
    private TextView tv_detail;
    private Button btn_AirConditioner_GL;
    //判断是否有红外功能
    boolean IRBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infrared);
        inItEvent();
        inItUI();
    }


    //初始化UI
    private void inItUI() {
        tv_detail = (TextView) findViewById(R.id.tv_detail);
        btn_AirConditioner_GL = (Button) findViewById(R.id.btn_AirConditioner_GL);
        btn_AirConditioner_GL.setOnClickListener(this);
    }


    //初始化事务
    private void inItEvent() {
        //获取ConsumerIrManager实例
        IR = (ConsumerIrManager) getSystemService(CONSUMER_IR_SERVICE);

        //如果sdk版本大于4.4才进行是否有红外的功能（手机的android版本）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            IRBack = IR.hasIrEmitter();
            if (!IRBack) {
                showToast("Sorry, there is no infrared function on this device!");
            } else {
                showToast("Infrared equipment ready");//可进行下一步操作
            }
        }
    }


    private void sendMsg(int carrierFrequency, int[] pattern) {
        IR.transmit(carrierFrequency, pattern);

        showToast("success");
        String content = null;
        for(int i = 0;i<pattern.length;i++){
            content += String.valueOf(pattern[i])+",";
        }
        tv_detail.setText(content+"\n"+(pattern.length)+"个时间数据");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_AirConditioner_GL:
                if (IRBack) {
                    sendMsg(38000, CodeCommand.auto);
                } else {
                    showToast("Sorry, there is no infrared function on this device!");
                }
                break;
        }
    }
}
