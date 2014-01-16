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
    @Property(key = "groupdocs.viewer.applicationPath")
    protected String applicationPath;
    @Property(key = "groupdocs.viewer.filePath")
    protected String basePath;
    @Property(key = "groupdocs.viewer.licensePath")
    protected String licensePath;
    @Property(key = "groupdocs.viewer.showHeader")
    protected Boolean showHeader;
    @Property(key = "groupdocs.viewer.showThumbnails")
    protected Boolean showThumbnails;
    @Property(key = "groupdocs.viewer.openThumbnails")
    protected Boolean openThumbnails;
    @Property(key = "groupdocs.viewer.width")
    protected Integer width;
    @Property(key = "groupdocs.viewer.height")
    protected Integer height;
    @Property(key = "groupdocs.viewer.showFolderBrowser")
    protected Boolean showFolderBrowser;
    @Property(key = "groupdocs.viewer.showPrint")
    protected Boolean showPrint;
    @Property(key = "groupdocs.viewer.showDownload")
    protected Boolean showDownload;
    @Property(key = "groupdocs.viewer.showZoom")
    protected Boolean showZoom;
    @Property(key = "groupdocs.viewer.showPaging")
    protected Boolean showPaging;
    @Property(key = "groupdocs.viewer.showSearch")
    protected Boolean showSearch;

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

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    public Boolean getShowHeader() {
        return showHeader;
    }

    public void setShowHeader(Boolean showHeader) {
        this.showHeader = showHeader;
    }

    public Boolean getShowThumbnails() {
        return showThumbnails;
    }

    public void setShowThumbnails(Boolean showThumbnails) {
        this.showThumbnails = showThumbnails;
    }

    public Boolean getOpenThumbnails() {
        return openThumbnails;
    }

    public void setOpenThumbnails(Boolean openThumbnails) {
        this.openThumbnails = openThumbnails;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getShowFolderBrowser() {
        return showFolderBrowser;
    }

    public void setShowFolderBrowser(Boolean showFolderBrowser) {
        this.showFolderBrowser = showFolderBrowser;
    }

    public Boolean getShowPrint() {
        return showPrint;
    }

    public void setShowPrint(Boolean showPrint) {
        this.showPrint = showPrint;
    }

    public Boolean getShowDownload() {
        return showDownload;
    }

    public void setShowDownload(Boolean showDownload) {
        this.showDownload = showDownload;
    }

    public Boolean getShowZoom() {
        return showZoom;
    }

    public void setShowZoom(Boolean showZoom) {
        this.showZoom = showZoom;
    }

    public Boolean getShowPaging() {
        return showPaging;
    }

    public void setShowPaging(Boolean showPaging) {
        this.showPaging = showPaging;
    }

    public Boolean getShowSearch() {
        return showSearch;
    }

    public void setShowSearch(Boolean showSearch) {
        this.showSearch = showSearch;
    }
    
}
