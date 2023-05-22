package com.sherry.new_sherry_product.controller.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author ： lpy
 * @Date : 下午4:54 2022/2/14
 */
@RestController
@RequestMapping("/SendEmailController")
@Api(value = "邮箱Controller", tags = { "邮箱相关接口" })
public class SendEmailController {
    @Autowired(required = false)
    private JavaMailSender javaMailSender;

    /**
     * 普通邮件发送
     */
    @ApiOperation(value = "发送邮件")
    @PostMapping("/sendSimpleMail")
    public void sendSimpleMail(@ApiParam("邮箱主题") @RequestParam(value = "邮件主题", required = true) String emailTextTile,
                               @ApiParam(value = "收件人", allowEmptyValue = false) @RequestParam(value = "收件人", required = true) String addressee,
                               @ApiParam("抄送人") @RequestParam(value = "抄送人",required = false) String copyInAddress,
                               @ApiParam("邮件正文") @RequestParam(value = "邮件正文", required = true) String emailContent) {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject(emailTextTile);
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("45257209@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo(addressee);
        // 设置邮件抄送人，可以有多个抄送人
        if (copyInAddress != null && copyInAddress != ""){
            message.setCc(copyInAddress);
        }
        // 设置隐秘抄送人，可以有多个
//        message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText(emailContent);
        try {
            // 发送邮件
            javaMailSender.send(message);
        } catch (Exception e){

        }
    }


    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());

        System.out.println(1024>>8);        // 1024 除以 2 的 8 次方

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AAAA");
        stringBuffer.append("----");
        stringBuffer.append("BBBB");
        System.out.println(stringBuffer);

    }

    /**
     * 奇.偶数判断
     * @return
     */
    public String chekJiOu(){
        if ((0&1)!=0){
            return "false";
        }else {
            return "true";
        }
    }


}
