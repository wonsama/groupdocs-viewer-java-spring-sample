package com.groupdocs.config;

import com.groupdocs.viewer.config.IServiceConfiguration;
import com.urbanmania.spring.beans.factory.config.annotations.Property;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Aleksey Permyakov, Alex Bobkov
 */
@Component
public class ApplicationConfig implements IServiceConfiguration {
    @Property(key = "groupdocs.viewer.applicationPath")
    protected String applicationPath;
    @Property(key = "groupdocs.viewer.filePath")
    protected String basePath;
    @Property(key = "groupdocs.viewer.licensePath")
    protected String licensePath;
    @Property(key = "groupdocs.viewer.localesPath")
    protected String localesPath;
    @Property(key = "groupdocs.viewer.uploadPath")
    protected String uploadPath;
    @Property(key = "groupdocs.viewer.cachePath")
    protected String cachePath;
    @Property(key = "groupdocs.viewer.useCache")
    protected Boolean useCache;
    @Property(key = "groupdocs.viewer.useBrowserCache")
    protected Boolean useBrowserCache;
    @Property(key = "groupdocs.viewer.expirationDate")
    protected Integer expirationDate;
    @Property(key = "groupdocs.viewer.encryptionKey")
    protected String encryptionKey;
    @Property(key = "groupdocs.viewer.encoding")
    protected String encoding;
    @Property(key = "groupdocs.viewer.fontsPath")
    protected String fontsPath;
    @Property(key = "groupdocs.viewer.useHtmlBasedEngine")
    protected Boolean useHtmlBasedEngine;
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
    @Property(key = "groupdocs.viewer.customDocumentCss")
    protected String customDocumentCss;
    @Property(key = "groupdocs.viewer.width")
    protected Integer width;
    @Property(key = "groupdocs.viewer.height")
    protected Integer height;
    @Property(key = "groupdocs.viewer.backgroundColor")
    protected String backgroundColor;
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
    @Property(key = "groupdocs.viewer.viewerStyle")
    protected Integer viewerStyle;
    @Property(key = "groupdocs.viewer.supportTextSelection")
    protected Boolean supportTextSelection;
    @Property(key = "groupdocs.viewer.usePdfPrinting")
    protected Boolean usePdfPrinting;
    @Property(key = "groupdocs.viewer.pdfPrintMarginsEnabled")
    protected Boolean pdfPrintMarginsEnabled;
    @Property(key = "groupdocs.viewer.toolbarButtonsBoxShadowStyle")
    protected String toolbarButtonsBoxShadowStyle;
    @Property(key = "groupdocs.viewer.toolbarButtonsBoxShadowHoverStyle")
    protected String toolbarButtonsBoxShadowHoverStyle;
    @Property(key = "groupdocs.viewer.thumbnailsContainerBackgroundColor")
    protected String thumbnailsContainerBackgroundColor;
    @Property(key = "groupdocs.viewer.thumbnailsContainerBorderRightColor")
    protected String thumbnailsContainerBorderRightColor;
    @Property(key = "groupdocs.viewer.toolbarBorderBottomColor")
    protected String toolbarBorderBottomColor;
    @Property(key = "groupdocs.viewer.toolbarInputFieldBorderColor")
    protected String toolbarInputFieldBorderColor;
    @Property(key = "groupdocs.viewer.toolbarButtonBorderColor")
    protected String toolbarButtonBorderColor;
    @Property(key = "groupdocs.viewer.toolbarButtonBorderHoverColor")
    protected String toolbarButtonBorderHoverColor;
    @Property(key = "groupdocs.viewer.thumbnailsContainerWidth")
    protected Integer thumbnailsContainerWidth;
    @Property(key = "groupdocs.viewer.showDownloadErrorsInPopup")
    protected Boolean showDownloadErrorsInPopup;
    @Property(key = "groupdocs.viewer.showImageWidth")
    protected Boolean showImageWidth;
    @Property(key = "groupdocs.viewer.showHeader")
    protected Boolean showHeader;
    @Property(key = "groupdocs.viewer.minimumImageWidth")
    protected Integer minimumImageWidth;
    @Property(key = "groupdocs.viewer.enableStandardErrorHandling")
    protected Boolean enableStandardErrorHandling;
    @Property(key = "groupdocs.viewer.useImageBasedPrinting")
    protected Boolean useImageBasedPrinting;
    @Property(key = "groupdocs.viewer.downloadPdfFile")
    protected Boolean downloadPdfFile;
    @Property(key = "groupdocs.viewer.searchForSeparateWords")
    protected Boolean searchForSeparateWords;
    @Property(key = "groupdocs.viewer.preventTouchEventsBubbling")
    protected Boolean preventTouchEventsBubbling;
    @Property(key = "groupdocs.viewer.useInnerThumbnails")
    protected Boolean useInnerThumbnails;
    @Property(key = "groupdocs.viewer.watermarkText")
    protected String watermarkText;
    @Property(key = "groupdocs.viewer.supportPageReordering")
    protected Boolean supportPageReordering;
    @Property(key = "groupdocs.viewer.watermarkColor")
    protected String watermarkColor;
    @Property(key = "groupdocs.viewer.onlyShrinkLargePages")
    protected Boolean onlyShrinkLargePages;
    @Property(key = "groupdocs.viewer.searchHighlightColor")
    protected String searchHighlightColor;
    @Property(key = "groupdocs.viewer.currentSearchHighlightColor")
    protected String currentSearchHighlightColor;
    @Property(key = "groupdocs.viewer.treatPhrasesInDoubleQuotesAsExactPhrases")
    protected Boolean treatPhrasesInDoubleQuotesAsExactPhrases;
    @Property(key = "groupdocs.viewer.usePngImagesForHtmlBasedEngine")
    protected Boolean usePngImagesForHtmlBasedEngine;
    @Property(key = "groupdocs.viewer.showOnePageInRow")
    protected Boolean showOnePageInRow;
    @Property(key = "groupdocs.viewer.loadAllPagesOnSearch")
    protected Boolean loadAllPagesOnSearch;
    @Property(key = "groupdocs.viewer.useEmScaling")
    protected Boolean useEmScaling;
    @Property(key = "groupdocs.viewer.maxCacheSize")
    protected Long maxCacheSize;
    @Property(key = "groupdocs.viewer.fileDisplayName")
    protected String fileDisplayName;
    @Property(key = "groupdocs.viewer.jqueryFileDownloadCookieName")
    protected String jqueryFileDownloadCookieName;
    @Property(key = "groupdocs.viewer.watermarkFontSize")
    protected Integer watermarkFontSize;
    @Property(key = "groupdocs.viewer.watermarkPosition")
    protected String watermarkPosition;
    @Property(key = "groupdocs.viewer.convertWordDocumentsCompletely")
    protected Boolean convertWordDocumentsCompletely;
    @Property(key = "groupdocs.viewer.ignoreDocumentAbsence")
    protected Boolean ignoreDocumentAbsence;
    @Property(key = "groupdocs.viewer.preloadPagesOnBrowserSide")
    protected Boolean preloadPagesOnBrowserSide;
    @Property(key = "groupdocs.viewer.printWithWatermark")
    protected Boolean printWithWatermark;
    @Property(key = "groupdocs.viewer.supportPageRotation")
    protected Boolean supportPageRotation;
    @Property(key = "groupdocs.viewer.imageWebRequestTimeout")
    protected Integer imageWebRequestTimeout;
    @Property(key = "groupdocs.viewer.imageResolution")
    protected Integer imageResolution;

    @Override
    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    @Override
    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public String getLicensePath() {
        if (licensePath == null || licensePath.isEmpty()) {
            return System.getenv("GROUPDOCS_VIEWER");
        }
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    @Override
    public String getLocalesPath() {
        return localesPath;
    }

    public void setLocalesPath(String localesPath) {
        this.localesPath = localesPath;
    }

    @Override
    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Override
    public String getCachePath() {
        return cachePath;
    }

    public void setCachePath(String cachePath) {
        this.cachePath = cachePath;
    }

    @Override
    public Boolean isUseCache() {
        return useCache;
    }

    public void setUseCache(Boolean useCache) {
        this.useCache = useCache;
    }

    @Override
    public Boolean isUseBrowserCache() {
        return useBrowserCache;
    }

    public void setUseBrowserCache(Boolean useBrowserCache) {
        this.useBrowserCache = useBrowserCache;
    }

    @Override
    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    @Override
    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public String getFontsPath() {
        return fontsPath;
    }

    @Override
    public Integer getImageWebRequestTimeout() {
        return imageWebRequestTimeout;
    }

    @Override
    public Integer getImageResolution() {
        return this.imageResolution;
    }

    public void setImageResolution(Integer imageResolution) {
        this.imageResolution = imageResolution;
    }

    public void setImageWebRequestTimeout(Integer imageWebRequestTimeout) {
        this.imageWebRequestTimeout = imageWebRequestTimeout;
    }

    public void setFontsPath(String fontsPath) {
        this.fontsPath = fontsPath;
    }

    @Override
    public Boolean isUseHtmlBasedEngine() {
        return useHtmlBasedEngine;
    }

    public void setUseHtmlBasedEngine(Boolean useHtmlBasedEngine) {
        this.useHtmlBasedEngine = useHtmlBasedEngine;
    }

    @Override
    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    @Override
    public Boolean isShowThumbnails() {
        return showThumbnails;
    }

    public void setShowThumbnails(Boolean showThumbnails) {
        this.showThumbnails = showThumbnails;
    }

    @Override
    public Boolean isOpenThumbnails() {
        return openThumbnails;
    }

    public void setOpenThumbnails(Boolean openThumbnails) {
        this.openThumbnails = openThumbnails;
    }

    @Override
    public Integer getInitialZoom() {
        return initialZoom;
    }

    public void setInitialZoom(Integer initialZoom) {
        this.initialZoom = initialZoom;
    }

    @Override
    public Boolean isZoomToFitWidth() {
        return zoomToFitWidth;
    }

    public void setZoomToFitWidth(Boolean zoomToFitWidth) {
        this.zoomToFitWidth = zoomToFitWidth;
    }

    @Override
    public Boolean isZoomToFitHeight() {
        return zoomToFitHeight;
    }

    public void setZoomToFitHeight(Boolean zoomToFitHeight) {
        this.zoomToFitHeight = zoomToFitHeight;
    }

    @Override
    public String getCustomDocumentCss() {
        return customDocumentCss;
    }

    public void setCustomDocumentCss(String customDocumentCss) {
        this.customDocumentCss = customDocumentCss;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public Boolean isShowFolderBrowser() {
        return showFolderBrowser;
    }

    public void setShowFolderBrowser(Boolean showFolderBrowser) {
        this.showFolderBrowser = showFolderBrowser;
    }

    @Override
    public Boolean isShowPrint() {
        return showPrint;
    }

    public void setShowPrint(Boolean showPrint) {
        this.showPrint = showPrint;
    }

    @Override
    public Boolean isShowDownload() {
        return showDownload;
    }

    public void setShowDownload(Boolean showDownload) {
        this.showDownload = showDownload;
    }

    @Override
    public Boolean isShowZoom() {
        return showZoom;
    }

    public void setShowZoom(Boolean showZoom) {
        this.showZoom = showZoom;
    }

    @Override
    public Boolean isShowPaging() {
        return showPaging;
    }

    public void setShowPaging(Boolean showPaging) {
        this.showPaging = showPaging;
    }

    @Override
    public Boolean isShowViewerStyleControl() {
        return showViewerStyleControl;
    }

    public void setShowViewerStyleControl(Boolean showViewerStyleControl) {
        this.showViewerStyleControl = showViewerStyleControl;
    }

    @Override
    public Boolean isShowSearch() {
        return showSearch;
    }

    public void setShowSearch(Boolean showSearch) {
        this.showSearch = showSearch;
    }

    @Override
    public Integer getPreloadPagesCount() {
        return preloadPagesCount;
    }

    public void setPreloadPagesCount(Integer preloadPagesCount) {
        this.preloadPagesCount = preloadPagesCount;
    }

    @Override
    public Integer getViewerStyle() {
        return viewerStyle;
    }

    public void setViewerStyle(Integer viewerStyle) {
        this.viewerStyle = viewerStyle;
    }

    @Override
    public Boolean isSupportTextSelection() {
        return supportTextSelection;
    }

    public void setSupportTextSelection(Boolean supportTextSelection) {
        this.supportTextSelection = supportTextSelection;
    }

    @Override
    public Boolean isUsePdfPrinting() {
        return usePdfPrinting;
    }

    @Override
    public Boolean isPdfPrintMarginsEnabled() {
        return pdfPrintMarginsEnabled;
    }

    public void setPdfPrintMarginsEnabled(Boolean pdfPrintMarginsEnabled) {
        this.pdfPrintMarginsEnabled = pdfPrintMarginsEnabled;
    }

    public void setUsePdfPrinting(Boolean usePdfPrinting) {
        this.usePdfPrinting = usePdfPrinting;
    }

    @Override
    public String getToolbarButtonsBoxShadowStyle() {
        return toolbarButtonsBoxShadowStyle;
    }

    public void setToolbarButtonsBoxShadowStyle(String toolbarButtonsBoxShadowStyle) {
        this.toolbarButtonsBoxShadowStyle = toolbarButtonsBoxShadowStyle;
    }

    @Override
    public String getToolbarButtonsBoxShadowHoverStyle() {
        return toolbarButtonsBoxShadowHoverStyle;
    }

    public void setToolbarButtonsBoxShadowHoverStyle(String toolbarButtonsBoxShadowHoverStyle) {
        this.toolbarButtonsBoxShadowHoverStyle = toolbarButtonsBoxShadowHoverStyle;
    }

    @Override
    public String getThumbnailsContainerBackgroundColor() {
        return thumbnailsContainerBackgroundColor;
    }

    public void setThumbnailsContainerBackgroundColor(String thumbnailsContainerBackgroundColor) {
        this.thumbnailsContainerBackgroundColor = thumbnailsContainerBackgroundColor;
    }

    @Override
    public String getThumbnailsContainerBorderRightColor() {
        return thumbnailsContainerBorderRightColor;
    }

    public void setThumbnailsContainerBorderRightColor(String thumbnailsContainerBorderRightColor) {
        this.thumbnailsContainerBorderRightColor = thumbnailsContainerBorderRightColor;
    }

    @Override
    public String getToolbarBorderBottomColor() {
        return toolbarBorderBottomColor;
    }

    public void setToolbarBorderBottomColor(String toolbarBorderBottomColor) {
        this.toolbarBorderBottomColor = toolbarBorderBottomColor;
    }

    @Override
    public String getToolbarInputFieldBorderColor() {
        return toolbarInputFieldBorderColor;
    }

    public void setToolbarInputFieldBorderColor(String toolbarInputFieldBorderColor) {
        this.toolbarInputFieldBorderColor = toolbarInputFieldBorderColor;
    }

    @Override
    public String getToolbarButtonBorderColor() {
        return toolbarButtonBorderColor;
    }

    public void setToolbarButtonBorderColor(String toolbarButtonBorderColor) {
        this.toolbarButtonBorderColor = toolbarButtonBorderColor;
    }

    @Override
    public String getToolbarButtonBorderHoverColor() {
        return toolbarButtonBorderHoverColor;
    }

    public void setToolbarButtonBorderHoverColor(String toolbarButtonBorderHoverColor) {
        this.toolbarButtonBorderHoverColor = toolbarButtonBorderHoverColor;
    }

    @Override
    public Integer getThumbnailsContainerWidth() {
        return thumbnailsContainerWidth;
    }

    public void setThumbnailsContainerWidth(Integer thumbnailsContainerWidth) {
        this.thumbnailsContainerWidth = thumbnailsContainerWidth;
    }

    @Override
    public Boolean isShowDownloadErrorsInPopup() {
        return showDownloadErrorsInPopup;
    }

    public void setShowDownloadErrorsInPopup(Boolean showDownloadErrorsInPopup) {
        this.showDownloadErrorsInPopup = showDownloadErrorsInPopup;
    }

    @Override
    public Boolean isShowImageWidth() {
        return showImageWidth;
    }

    public void setShowImageWidth(Boolean showImageWidth) {
        this.showImageWidth = showImageWidth;
    }

    @Override
    public Boolean isShowHeader() {
        return showHeader;
    }

    public void setShowHeader(Boolean showHeader) {
        this.showHeader = showHeader;
    }

    @Override
    public Integer getMinimumImageWidth() {
        return minimumImageWidth;
    }

    public void setMinimumImageWidth(Integer minimumImageWidth) {
        this.minimumImageWidth = minimumImageWidth;
    }

    @Override
    public Boolean isEnableStandardErrorHandling() {
        return enableStandardErrorHandling;
    }

    public void setEnableStandardErrorHandling(Boolean enableStandardErrorHandling) {
        this.enableStandardErrorHandling = enableStandardErrorHandling;
    }

    @Override
    public Boolean isUseImageBasedPrinting() {
        return useImageBasedPrinting;
    }

    public void setUseImageBasedPrinting(Boolean useImageBasedPrinting) {
        this.useImageBasedPrinting = useImageBasedPrinting;
    }

    @Override
    public Boolean isDownloadPdfFile() {
        return downloadPdfFile;
    }

    public void setDownloadPdfFile(Boolean downloadPdfFile) {
        this.downloadPdfFile = downloadPdfFile;
    }

    @Override
    public Boolean isSearchForSeparateWords() {
        return searchForSeparateWords;
    }

    public void setSearchForSeparateWords(Boolean searchForSeparateWords) {
        this.searchForSeparateWords = searchForSeparateWords;
    }

    @Override
    public Boolean isPreventTouchEventsBubbling() {
        return preventTouchEventsBubbling;
    }

    public void setPreventTouchEventsBubbling(Boolean preventTouchEventsBubbling) {
        this.preventTouchEventsBubbling = preventTouchEventsBubbling;
    }

    @Override
    public Boolean isUseInnerThumbnails() {
        return useInnerThumbnails;
    }

    public void setUseInnerThumbnails(Boolean useInnerThumbnails) {
        this.useInnerThumbnails = useInnerThumbnails;
    }

    @Override
    public String getWatermarkText() {
        return watermarkText;
    }

    public void setWatermarkText(String watermarkText) {
        this.watermarkText = watermarkText;
    }

    @Override
    public Boolean isSupportPageReordering() {
        return supportPageReordering;
    }

    public void setSupportPageReordering(Boolean supportPageReordering) {
        this.supportPageReordering = supportPageReordering;
    }

    @Override
    public String getWatermarkColor() {
        return watermarkColor;
    }

    public void setWatermarkColor(String watermarkColor) {
        this.watermarkColor = watermarkColor;
    }

    @Override
    public Boolean isOnlyShrinkLargePages() {
        return onlyShrinkLargePages;
    }

    public void setOnlyShrinkLargePages(Boolean onlyShrinkLargePages) {
        this.onlyShrinkLargePages = onlyShrinkLargePages;
    }

    @Override
    public String getSearchHighlightColor() {
        return searchHighlightColor;
    }

    public void setSearchHighlightColor(String searchHighlightColor) {
        this.searchHighlightColor = searchHighlightColor;
    }

    @Override
    public String getCurrentSearchHighlightColor() {
        return currentSearchHighlightColor;
    }

    public void setCurrentSearchHighlightColor(String currentSearchHighlightColor) {
        this.currentSearchHighlightColor = currentSearchHighlightColor;
    }

    @Override
    public Boolean isTreatPhrasesInDoubleQuotesAsExactPhrases() {
        return treatPhrasesInDoubleQuotesAsExactPhrases;
    }

    public void setTreatPhrasesInDoubleQuotesAsExactPhrases(Boolean treatPhrasesInDoubleQuotesAsExactPhrases) {
        this.treatPhrasesInDoubleQuotesAsExactPhrases = treatPhrasesInDoubleQuotesAsExactPhrases;
    }

    @Override
    public Boolean isUsePngImagesForHtmlBasedEngine() {
        return usePngImagesForHtmlBasedEngine;
    }

    public void setUsePngImagesForHtmlBasedEngine(Boolean usePngImagesForHtmlBasedEngine) {
        this.usePngImagesForHtmlBasedEngine = usePngImagesForHtmlBasedEngine;
    }

    @Override
    public Boolean isShowOnePageInRow() {
        return showOnePageInRow;
    }

    public void setShowOnePageInRow(Boolean showOnePageInRow) {
        this.showOnePageInRow = showOnePageInRow;
    }

    @Override
    public Boolean isLoadAllPagesOnSearch() {
        return loadAllPagesOnSearch;
    }

    public void setLoadAllPagesOnSearch(Boolean loadAllPagesOnSearch) {
        this.loadAllPagesOnSearch = loadAllPagesOnSearch;
    }

    @Override
    public Boolean isUseEmScaling() {
        return useEmScaling;
    }

    public void setUseEmScaling(Boolean useEmScaling) {
        this.useEmScaling = useEmScaling;
    }

    @Override
    public Long getMaxCacheSize() {
        return maxCacheSize;
    }

    public void setMaxCacheSize(Long maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    @Override
    public String getFileDisplayName() {
        return fileDisplayName;
    }

    public void setFileDisplayName(String fileDisplayName) {
        this.fileDisplayName = fileDisplayName;
    }

    @Override
    public String getJqueryFileDownloadCookieName() {
        return jqueryFileDownloadCookieName;
    }

    public void setJqueryFileDownloadCookieName(String jqueryFileDownloadCookieName) {
        this.jqueryFileDownloadCookieName = jqueryFileDownloadCookieName;
    }

    @Override
    public Integer getWatermarkFontSize() {
        return watermarkFontSize;
    }

    public void setWatermarkFontSize(Integer watermarkFontSize) {
        this.watermarkFontSize = watermarkFontSize;
    }

    @Override
    public String getWatermarkPosition() {
        return watermarkPosition;
    }

    public void setWatermarkPosition(String watermarkPosition) {
        this.watermarkPosition = watermarkPosition;
    }

    @Override
    public Boolean isConvertWordDocumentsCompletely() {
        return convertWordDocumentsCompletely;
    }

    public void setConvertWordDocumentsCompletely(Boolean convertWordDocumentsCompletely) {
        this.convertWordDocumentsCompletely = convertWordDocumentsCompletely;
    }

    @Override
    public Boolean isIgnoreDocumentAbsence() {
        return ignoreDocumentAbsence;
    }

    public void setIgnoreDocumentAbsence(Boolean ignoreDocumentAbsence) {
        this.ignoreDocumentAbsence = ignoreDocumentAbsence;
    }

    @Override
    public Boolean isPreloadPagesOnBrowserSide() {
        return preloadPagesOnBrowserSide;
    }

    public void setPreloadPagesOnBrowserSide(Boolean preloadPagesOnBrowserSide) {
        this.preloadPagesOnBrowserSide = preloadPagesOnBrowserSide;
    }

    @Override
    public Boolean isPrintWithWatermark() {
        return printWithWatermark;
    }

    public void setPrintWithWatermark(Boolean printWithWatermark) {
        this.printWithWatermark = printWithWatermark;
    }

    @Override
    public Boolean isSupportPageRotation() {
        return supportPageRotation;
    }

    public void setSupportPageRotation(Boolean supportPageRotation) {
        this.supportPageRotation = supportPageRotation;
    }

}