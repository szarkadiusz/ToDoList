package com.Core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Serwiss {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1, "hello", "en");
    private final Logger logger = LoggerFactory.getLogger(Serwiss.class);
    private LangRepository repository;

    Serwiss() {
        this(new LangRepository());
    }

    Serwiss(LangRepository repository) {
        this.repository = repository;
    }


    String prepGreeting(String name, String lang) {
        Integer langId;
        try{
            langId = Optional.ofNullable(lang).map(Integer::valueOf).orElse(FALLBACK_LANG.getId());
        }catch (NumberFormatException e){

        logger.warn ("Non numeric language id used: " + lang);
        langId = FALLBACK_LANG.getId();

        }
        var welcomeMeassage = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMessage();
        var nameToWelcomeMessage =  Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMeassage + " "+nameToWelcomeMessage;
    }



}
