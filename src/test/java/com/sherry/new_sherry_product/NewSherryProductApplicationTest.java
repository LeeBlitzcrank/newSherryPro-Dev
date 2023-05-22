package com.sherry.new_sherry_product;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewSherryProductApplicationTest {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试pdfToHtml
     */
    @Test
    public void pdfToHtml() throws FileNotFoundException {
        //加载PDF文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("/Users/lee/Desktop/发票采集.pdf");

        //设置useEmbeddedSvg和 useEmbeddedImg布尔值为true
        pdf.getConvertOptions().setPdfToHtmlOptions(true,true);

        //保存到流
        File outFile = new File("src/main/resources/static/toHTML.html");
        OutputStream outputStream = new FileOutputStream(outFile);
        pdf.saveToStream(outputStream, FileFormat.HTML);
        pdf.close();

    }

    /**
     * 普通邮件发送
     */
    @Test
    public void sendSimpleMail() {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封测试邮件");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("45257209@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo("291549391@qq.com");
        // 设置邮件抄送人，可以有多个抄送人
        message.setCc("cn.blitzcrank@gmail.com");
        // 设置隐秘抄送人，可以有多个
//        message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("这是测试邮件的正文");
        // 发送邮件
        javaMailSender.send(message);
    }


}
