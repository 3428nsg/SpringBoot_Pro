package com.itgaoshu.controller;

import com.itgaoshu.util.FaSongYzmUtil;
import com.itgaoshu.util.ShengChengYzmUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 曹小花
 * @Title: SendSmsController
 * @Description: SpringCloudAlibaba课程
 * @date 2020/4/9 0009 17:04
 */
@RestController
public class SendSmsController {

    @RequestMapping("/sendSms")
    public String sendSms(String phoneNumber,int flag){
        //调用工具类方法生成验证码
        String  yzm=ShengChengYzmUtil.getYzm();
        //调用发送验证码工具类方法
        boolean result=FaSongYzmUtil.faSong(phoneNumber,yzm,flag);
        if(result){//表示发送成功
            return yzm;
        }else{//表示发送失败
            return "";
        }
    }
}
