package com.zking.erp.stock.task;

import com.zking.erp.personnel.vo.EmpVo;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class TestSpringEmail {

//    public static void main(String[] args) {
//        sendTextEmail();
//    }

    public static String sendTextEmail(EmpVo empVo,String activeUserEmail,String message){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        //参考qq邮箱帮助中心
        mailSender.setHost("smtp.qq.com");//qq邮箱smtp发送服务器地址
        //mailSender.setPort(465)//qq这个端口用不了
        mailSender.setPort(587);//端口号
        mailSender.setUsername(activeUserEmail);//邮箱账号
        mailSender.setPassword("fxmrxsudkopoecdf");//授权码-发短信获取

        //邮件信息
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(activeUserEmail);//发件人邮箱
        msg.setTo(empVo.getEmail());//收件人邮箱
        msg.setSubject(empVo.getTitle());//标题
        msg.setText(empVo.getContext());//文本信息
        try {
            mailSender.send(msg);
            message = "邮件发送成功";
        } catch (Exception e) {
            message = "发送失败:"+e.getMessage();
        }

        return message;

    }
}
