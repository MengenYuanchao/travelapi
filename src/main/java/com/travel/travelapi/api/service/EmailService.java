package com.travel.travelapi.api.service;

public interface EmailService {
    /**
     * 发送纯文本的简单邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content) throws Exception;
}
