package com.Core;

class Lang {
    private Long id;
    private String welcomeMessage;
    private String code;

    public Lang(Long id, String welcomeMessage, String code) {
        this.id = id;
        this.welcomeMessage = welcomeMessage;
        this.code = code;
    }

    public Long getId() {
        return id;
    }


    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public Lang setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Lang setCode(String code) {
        this.code = code;
        return this;
    }
}
