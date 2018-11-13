package com.mkdika.javamockitobdd.model;

import java.util.Set;

public class Mail {

    private final String sender;
    private final String recipients; // comma separated
    private final String subject;
    private final String body;

    public Mail(String sender, String recipients, String subject, String body) {
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipients() {
        return recipients;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
