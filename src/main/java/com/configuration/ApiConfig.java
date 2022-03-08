package com.configuration;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/main/resources/ApiConfig.properties"})
public interface ApiConfig extends Config {
    @Key("webdrivers.source.path")
    String getWebdriversPath();

    @Key("stellarburgers.url.base")
    String getBaseUrl();

    @Key("site.login")
    String getLoginPageUrl();

    @Key("site.register")
    String getRegisterPageUrl();

    @Key("site.profile")
    String getProfilePageUrl();
}
