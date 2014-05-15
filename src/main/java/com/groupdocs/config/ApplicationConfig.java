package com.groupdocs.config;

import com.urbanmania.spring.beans.factory.config.annotations.Property;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Aleksey Permyakov, Alex Bobkov
 */
@Component
public class ApplicationConfig {
    @Property(key = "groupdocs.viewer.filePath")
    protected String basePath;
    @Property(key = "groupdocs.viewer.licensePath")
    protected String licensePath;
    @Property(key = "groupdocs.viewer.useAuthorization")
    protected Boolean useAuthorization;
    @Property(key = "groupdocs.viewer.useCache")
    protected Boolean useCache;
    @Property(key = "groupdocs.viewer.useHtmlBasedEngine")
    protected Boolean useHtmlBasedEngine;
    @Property(key = "groupdocs.viewer.expirationDate")
    protected Integer expirationDate;
    @Property(key = "groupdocs.viewer.quality")
    protected Integer quality;
    @Property(key = "groupdocs.viewer.showThumbnails")
    protected Boolean showThumbnails;
    @Property(key = "groupdocs.viewer.openThumbnails")
    protected Boolean openThumbnails;
    @Property(key = "groupdocs.viewer.initialZoom")
    protected Integer initialZoom;
    @Property(key = "groupdocs.viewer.zoomToFitWidth")
    protected Boolean zoomToFitWidth;
    @Property(key = "groupdocs.viewer.zoomToFitHeight")
    protected Boolean zoomToFitHeight;
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
    @Property(key = "groupdocs.viewer.showViewerStyleControl")
    protected Boolean showViewerStyleControl;
    @Property(key = "groupdocs.viewer.showSearch")
    protected Boolean showSearch;
    @Property(key = "groupdocs.viewer.preloadPagesCount")
    protected Integer preloadPagesCount;
    @Property(key = "groupdocs.viewer.supportTextSelection")
    protected Boolean supportTextSelection;
    @Property(key = "groupdocs.viewer.usePdfPrinting")
    protected Boolean usePdfPrinting;
    @Property(key = "groupdocs.viewer.showHeader")
    protected Boolean showHeader;
    @Property(key = "groupdocs.viewer.useInnerThumbnails")
    protected Boolean useInnerThumbnails;
    @Property(key = "groupdocs.viewer.encKey")
    protected String encKey;

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

    public Boolean isUseAuthorization() {
        return useAuthorization;
    }

    public void setUseAuthorization(Boolean useAuthorization) {
        this.useAuthorization = useAuthorization;
    }

    public Boolean isUseCache() {
        return useCache;
    }

    public void setUseCache(Boolean useCache) {
        this.useCache = useCache;
    }

    public Boolean isUseHtmlBasedEngine() {
        return useHtmlBasedEngine;
    }

    public void setUseHtmlBasedEngine(Boolean useHtmlBasedEngine) {
        this.useHtmlBasedEngine = useHtmlBasedEngine;
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Boolean isShowThumbnails() {
        return showThumbnails;
    }

    public void setShowThumbnails(Boolean showThumbnails) {
        this.showThumbnails = showThumbnails;
    }

    public Boolean isOpenThumbnails() {
        return openThumbnails;
    }

    public void setOpenThumbnails(Boolean openThumbnails) {
        this.openThumbnails = openThumbnails;
    }

    public Integer getInitialZoom() {
        return initialZoom;
    }

    public void setInitialZoom(Integer initialZoom) {
        this.initialZoom = initialZoom;
    }

    public Boolean isZoomToFitWidth() {
        return zoomToFitWidth;
    }

    public void setZoomToFitWidth(Boolean zoomToFitWidth) {
        this.zoomToFitWidth = zoomToFitWidth;
    }

    public Boolean isZoomToFitHeight() {
        return zoomToFitHeight;
    }

    public void setZoomToFitHeight(Boolean zoomToFitHeight) {
        this.zoomToFitHeight = zoomToFitHeight;
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

    public Boolean isShowFolderBrowser() {
        return showFolderBrowser;
    }

    public void setShowFolderBrowser(Boolean showFolderBrowser) {
        this.showFolderBrowser = showFolderBrowser;
    }

    public Boolean isShowPrint() {
        return showPrint;
    }

    public void setShowPrint(Boolean showPrint) {
        this.showPrint = showPrint;
    }

    public Boolean isShowDownload() {
        return showDownload;
    }

    public void setShowDownload(Boolean showDownload) {
        this.showDownload = showDownload;
    }

    public Boolean isShowZoom() {
        return showZoom;
    }

    public void setShowZoom(Boolean showZoom) {
        this.showZoom = showZoom;
    }

    public Boolean isShowPaging() {
        return showPaging;
    }

    public void setShowPaging(Boolean showPaging) {
        this.showPaging = showPaging;
    }

    public Boolean isShowViewerStyleControl() {
        return showViewerStyleControl;
    }

    public void setShowViewerStyleControl(Boolean showViewerStyleControl) {
        this.showViewerStyleControl = showViewerStyleControl;
    }

    public Boolean isShowSearch() {
        return showSearch;
    }

    public void setShowSearch(Boolean showSearch) {
        this.showSearch = showSearch;
    }

    public Integer getPreloadPagesCount() {
        return preloadPagesCount;
    }

    public void setPreloadPagesCount(Integer preloadPagesCount) {
        this.preloadPagesCount = preloadPagesCount;
    }

    public Boolean isSupportTextSelection() {
        return supportTextSelection;
    }

    public void setSupportTextSelection(Boolean supportTextSelection) {
        this.supportTextSelection = supportTextSelection;
    }

    public Boolean isUsePdfPrinting() {
        return usePdfPrinting;
    }

    public void setUsePdfPrinting(Boolean usePdfPrinting) {
        this.usePdfPrinting = usePdfPrinting;
    }

    public Boolean isShowHeader() {
        return showHeader;
    }

    public void setShowHeader(Boolean showHeader) {
        this.showHeader = showHeader;
    }

    public Boolean isUseInnerThumbnails() {
        return useInnerThumbnails;
    }

    public void setUseInnerThumbnails(Boolean useInnerThumbnails) {
        this.useInnerThumbnails = useInnerThumbnails;
    }

    public String getEncKey() {
        return encKey;
    }

    public void setEncKey(String encKey) {
        this.encKey = encKey;
    }

}
