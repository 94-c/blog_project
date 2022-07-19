package com.blog.service;

import com.blog.entity.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class EmailService {

    String host = "smtp.mailtrap.io";
    String guest = "d8ffd2a2082783";    //발신자 메일
    String password = "35d7b6d03152c0"; //발신자 비밀번호

    public String Random() {
        Random random = new Random();
        String key = "";

        for (int i=0; i<3; i++) {
            int index = random.nextInt(25) + 65; //A-Z까 랜덤 알파벳 생성
            key += (char)index;
        }

        int numIndex = random.nextInt(9999) + 1000; //4자리 랜덤 정수를 생성
        key += numIndex;
        return key;
    }

    public void sendEmail(User user) {

        String from = user.getEmail();

        Properties props = new Properties();
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "2525");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(guest, password);
                    }
                }
        );

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(guest));
            //메일 대상
            mimeMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(from));

            //메일 제목
            mimeMessage.setSubject("블로그 회원가입을 진심으로 축하드립니다.");

            //메일 본문
            mimeMessage.setText("<a href = " + Random() + " > </a>");

            // send the message
            Transport.send(mimeMessage);
            System.out.println("메일 전송 완료");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
