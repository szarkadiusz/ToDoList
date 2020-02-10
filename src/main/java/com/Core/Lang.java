package com.Core;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "LANGUAGES")


class Lang {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Integer id;
    @Column(name = "WELCOMEMSG")
    private String welcomeMessage;

    @Column(name = "code")
    private String languageCode;
    Lang() {
    }
    public Lang(Integer id, String welcomeMessage, String languageCode) {
        this.id = id;
        this.welcomeMessage = welcomeMessage;
        this.languageCode = languageCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }


}