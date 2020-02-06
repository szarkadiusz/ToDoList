package com.Core;

import java.util.Optional;

public class Serwiss {
 static final String FALLBACK_NAME = "world";

    String prepGreeting (String name){
    return "Hello" + Optional.ofNullable(name).orElse(FALLBACK_NAME);
}
}
