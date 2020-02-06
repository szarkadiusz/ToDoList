package com.Core;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "languages" )

class Lang {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private Integer id;
    private String welcomeMessage;
    private String code;

    //hibernate uses it
@SuppressWarnings("unsused")
    Lang () {
}

    public Lang(Integer id, String welcomeMessage, String code) {
            this.id = id;
            this.welcomeMessage = welcomeMessage;
            this.code = code;
        }


    public Integer getId() {
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
