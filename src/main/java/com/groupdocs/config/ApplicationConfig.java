package com.groupdocs.config;

import com.urbanmania.spring.beans.factory.config.annotations.Property;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: liosha
 * Date: 10.12.13
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ApplicationConfig {
    @Property(key = "application.path")
    protected String applicationPath;
    @Property(key = "application.groupdocs.filespath")
    protected String basePath;

    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}
