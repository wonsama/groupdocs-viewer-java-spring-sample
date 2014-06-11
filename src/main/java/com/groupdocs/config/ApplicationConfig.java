package com.groupdocs.config;

import com.groupdocs.viewer.config.ServiceConfigurationBase;
import com.urbanmania.spring.beans.factory.config.annotations.Property;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Aleksey Permyakov, Alex Bobkov
 */
@Component
public class ApplicationConfig implements ServiceConfigurationBase{
    @Property(key = "groupdocs.viewer.applicationPath")
    protected String applicationPath;
    @Property(key = "groupdocs.viewer.filePath")
    protected String basePath;
    @Property(key = "groupdocs.viewer.licensePath")
    protected String licensePath;
    @Property(key = "groupdocs.viewer.useAuthorization")
    protected boolean useAuthorization;
    @Property(key = "groupdocs.viewer.useCache")
    protected boolean useCache;
    @Property(key = "groupdocs.viewer.useBrowserCache")
    protected boolean useBrowserCache;
    @Property(key = "groupdocs.viewer.expirationDate")
    protected int expirationDate;
    @Property(key = "groupdocs.viewer.encryptionKey")
    protected String encryptionKey;
    @Property(key = "groupdocs.viewer.useHtmlBasedEngine")
    protected boolean useHtmlBasedEngine;
    @Property(key = "groupdocs.viewer.quality")
    protected int quality;
    @Property(key = "groupdocs.viewer.showThumbnails")
    protected boolean showThumbnails;
    @Property(key = "groupdocs.viewer.openThumbnails")
    protected boolean openThumbnails;
    @Property(key = "groupdocs.viewer.initialZoom")
    protected int initialZoom;
    @Property(key = "groupdocs.viewer.zoomToFitWidth")
    protected boolean zoomToFitWidth;
    @Property(key = "groupdocs.viewer.zoomToFitHeight")
    protected boolean zoomToFitHeight;
    @Property(key = "groupdocs.viewer.width")
    protected int width;
    @Property(key = "groupdocs.viewer.height")
    protected int height;
    @Property(key = "groupdocs.viewer.backgroundColor")
    protected String backgroundColor;
    @Property(key = "groupdocs.viewer.showFolderBrowser")
    protected boolean showFolderBrowser;
    @Property(key = "groupdocs.viewer.showPrint")
    protected boolean showPrint;
    @Property(key = "groupdocs.viewer.showDownload")
    protected boolean showDownload;
    @Property(key = "groupdocs.viewer.showZoom")
    protected boolean showZoom;
    @Property(key = "groupdocs.viewer.showPaging")
    protected boolean showPaging;
    @Property(key = "groupdocs.viewer.showViewerStyleControl")
    protected boolean showViewerStyleControl;
    @Property(key = "groupdocs.viewer.showSearch")
    protected boolean showSearch;
    @Property(key = "groupdocs.viewer.preloadPagesCount")
    protected int preloadPagesCount;
    @Property(key = "groupdocs.viewer.viewerStyle")
    protected int viewerStyle;
    @Property(key = "groupdocs.viewer.supportTextSelection")
    protected boolean supportTextSelection;
    @Property(key = "groupdocs.viewer.usePdfPrinting")
    protected boolean usePdfPrinting;
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
    protected int thumbnailsContainerWidth;
    @Property(key = "groupdocs.viewer.showDownloadErrorsInPopup")
    protected boolean showDownloadErrorsInPopup;
    @Property(key = "groupdocs.viewer.showImageWidth")
    protected boolean showImageWidth;
    @Property(key = "groupdocs.viewer.showHeader")
    protected boolean showHeader;
    @Property(key = "groupdocs.viewer.minimumImageWidth")
    protected int minimumImageWidth;
    @Property(key = "groupdocs.viewer.enableStandardErrorHandling")
    protected boolean enableStandardErrorHandling;
    @Property(key = "groupdocs.viewer.useImageBasedPrinting")
    protected boolean useImageBasedPrinting;
    @Property(key = "groupdocs.viewer.downloadPdfFile")
    protected boolean downloadPdfFile;
    @Property(key = "groupdocs.viewer.searchForSeparateWords")
    protected boolean searchForSeparateWords;
    @Property(key = "groupdocs.viewer.preventTouchEventsBubbling")
    protected boolean preventTouchEventsBubbling;
    @Property(key = "groupdocs.viewer.useInnerThumbnails")
    protected boolean useInnerThumbnails;
    @Property(key = "groupdocs.viewer.watermarkText")
    protected String watermarkText;
    @Property(key = "groupdocs.viewer.supportPageReordering")
    protected boolean supportPageReordering;
    @Property(key = "groupdocs.viewer.watermarkColor")
    protected String watermarkColor;
    @Property(key = "groupdocs.viewer.onlyShrinkLargePages")
    protected boolean onlyShrinkLargePages;
    @Property(key = "groupdocs.viewer.searchHighlightColor")
    protected String searchHighlightColor;
    @Property(key = "groupdocs.viewer.currentSearchHighlightColor")
    protected String currentSearchHighlightColor;
    @Property(key = "groupdocs.viewer.treatPhrasesInDoubleQuotesAsExactPhrases")
    protected boolean treatPhrasesInDoubleQuotesAsExactPhrases;
    @Property(key = "groupdocs.viewer.usePngImagesForHtmlBasedEngine")
    protected boolean usePngImagesForHtmlBasedEngine;
    @Property(key = "groupdocs.viewer.showOnePageInRow")
    protected boolean showOnePageInRow;
    @Property(key = "groupdocs.viewer.loadAllPagesOnSearch")
    protected boolean loadAllPagesOnSearch;
    @Property(key = "groupdocs.viewer.useEmScaling")
    protected boolean useEmScaling;

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
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    @Override
    public boolean isUseAuthorization() {
        return useAuthorization;
    }

    public void setUseAuthorization(boolean useAuthorization) {
        this.useAuthorization = useAuthorization;
    }

    @Override
    public boolean isUseCache() {
        return useCache;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }

    @Override
    public boolean isUseBrowserCache() {
        return useBrowserCache;
    }

    public void setUseBrowserCache(boolean useBrowserCache) {
        this.useBrowserCache = useBrowserCache;
    }
    
    @Override
    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
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
    public boolean isUseHtmlBasedEngine() {
        return useHtmlBasedEngine;
    }

    public void setUseHtmlBasedEngine(boolean useHtmlBasedEngine) {
        this.useHtmlBasedEngine = useHtmlBasedEngine;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public boolean isShowThumbnails() {
        return showThumbnails;
    }

    public void setShowThumbnails(boolean showThumbnails) {
        this.showThumbnails = showThumbnails;
    }

    @Override
    public boolean isOpenThumbnails() {
        return openThumbnails;
    }

    public void setOpenThumbnails(boolean openThumbnails) {
        this.openThumbnails = openThumbnails;
    }

    @Override
    public int getInitialZoom() {
        return initialZoom;
    }

    public void setInitialZoom(int initialZoom) {
        this.initialZoom = initialZoom;
    }

    @Override
    public boolean isZoomToFitWidth() {
        return zoomToFitWidth;
    }

    public void setZoomToFitWidth(boolean zoomToFitWidth) {
        this.zoomToFitWidth = zoomToFitWidth;
    }

    @Override
    public boolean isZoomToFitHeight() {
        return zoomToFitHeight;
    }

    public void setZoomToFitHeight(boolean zoomToFitHeight) {
        this.zoomToFitHeight = zoomToFitHeight;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
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
    public boolean isShowFolderBrowser() {
        return showFolderBrowser;
    }

    public void setShowFolderBrowser(boolean showFolderBrowser) {
        this.showFolderBrowser = showFolderBrowser;
    }

    @Override
    public boolean isShowPrint() {
        return showPrint;
    }

    public void setShowPrint(boolean showPrint) {
        this.showPrint = showPrint;
    }

    @Override
    public boolean isShowDownload() {
        return showDownload;
    }

    public void setShowDownload(boolean showDownload) {
        this.showDownload = showDownload;
    }

    @Override
    public boolean isShowZoom() {
        return showZoom;
    }

    public void setShowZoom(boolean showZoom) {
        this.showZoom = showZoom;
    }

    @Override
    public boolean isShowPaging() {
        return showPaging;
    }

    public void setShowPaging(boolean showPaging) {
        this.showPaging = showPaging;
    }

    @Override
    public boolean isShowViewerStyleControl() {
        return showViewerStyleControl;
    }

    public void setShowViewerStyleControl(boolean showViewerStyleControl) {
        this.showViewerStyleControl = showViewerStyleControl;
    }

    @Override
    public boolean isShowSearch() {
        return showSearch;
    }

    public void setShowSearch(boolean showSearch) {
        this.showSearch = showSearch;
    }

    @Override
    public int getPreloadPagesCount() {
        return preloadPagesCount;
    }

    public void setPreloadPagesCount(int preloadPagesCount) {
        this.preloadPagesCount = preloadPagesCount;
    }

    @Override
    public int getViewerStyle() {
        return viewerStyle;
    }

    public void setViewerStyle(int viewerStyle) {
        this.viewerStyle = viewerStyle;
    }

    @Override
    public boolean isSupportTextSelection() {
        return supportTextSelection;
    }

    public void setSupportTextSelection(boolean supportTextSelection) {
        this.supportTextSelection = supportTextSelection;
    }

    @Override
    public boolean isUsePdfPrinting() {
        return usePdfPrinting;
    }

    public void setUsePdfPrinting(boolean usePdfPrinting) {
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
    public int getThumbnailsContainerWidth() {
        return thumbnailsContainerWidth;
    }

    public void setThumbnailsContainerWidth(int thumbnailsContainerWidth) {
        this.thumbnailsContainerWidth = thumbnailsContainerWidth;
    }

    @Override
    public boolean isShowDownloadErrorsInPopup() {
        return showDownloadErrorsInPopup;
    }

    public void setShowDownloadErrorsInPopup(boolean showDownloadErrorsInPopup) {
        this.showDownloadErrorsInPopup = showDownloadErrorsInPopup;
    }

    @Override
    public boolean isShowImageWidth() {
        return showImageWidth;
    }

    public void setShowImageWidth(boolean showImageWidth) {
        this.showImageWidth = showImageWidth;
    }

    @Override
    public boolean isShowHeader() {
        return showHeader;
    }

    public void setShowHeader(boolean showHeader) {
        this.showHeader = showHeader;
    }

    @Override
    public int getMinimumImageWidth() {
        return minimumImageWidth;
    }

    public void setMinimumImageWidth(int minimumImageWidth) {
        this.minimumImageWidth = minimumImageWidth;
    }

    @Override
    public boolean isEnableStandardErrorHandling() {
        return enableStandardErrorHandling;
    }

    public void setEnableStandardErrorHandling(boolean enableStandardErrorHandling) {
        this.enableStandardErrorHandling = enableStandardErrorHandling;
    }

    @Override
    public boolean isUseImageBasedPrinting() {
        return useImageBasedPrinting;
    }

    public void setUseImageBasedPrinting(boolean useImageBasedPrinting) {
        this.useImageBasedPrinting = useImageBasedPrinting;
    }

    @Override
    public boolean isDownloadPdfFile() {
        return downloadPdfFile;
    }

    public void setDownloadPdfFile(boolean downloadPdfFile) {
        this.downloadPdfFile = downloadPdfFile;
    }

    @Override
    public boolean isSearchForSeparateWords() {
        return searchForSeparateWords;
    }

    public void setSearchForSeparateWords(boolean searchForSeparateWords) {
        this.searchForSeparateWords = searchForSeparateWords;
    }

    @Override
    public boolean isPreventTouchEventsBubbling() {
        return preventTouchEventsBubbling;
    }

    public void setPreventTouchEventsBubbling(boolean preventTouchEventsBubbling) {
        this.preventTouchEventsBubbling = preventTouchEventsBubbling;
    }

    @Override
    public boolean isUseInnerThumbnails() {
        return useInnerThumbnails;
    }

    public void setUseInnerThumbnails(boolean useInnerThumbnails) {
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
    public boolean isSupportPageReordering() {
        return supportPageReordering;
    }

    public void setSupportPageReordering(boolean supportPageReordering) {
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
    public boolean isOnlyShrinkLargePages() {
        return onlyShrinkLargePages;
    }

    public void setOnlyShrinkLargePages(boolean onlyShrinkLargePages) {
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
    public boolean isTreatPhrasesInDoubleQuotesAsExactPhrases() {
        return treatPhrasesInDoubleQuotesAsExactPhrases;
    }

    public void setTreatPhrasesInDoubleQuotesAsExactPhrases(boolean treatPhrasesInDoubleQuotesAsExactPhrases) {
        this.treatPhrasesInDoubleQuotesAsExactPhrases = treatPhrasesInDoubleQuotesAsExactPhrases;
    }

    @Override
    public boolean isUsePngImagesForHtmlBasedEngine() {
        return usePngImagesForHtmlBasedEngine;
    }

    public void setUsePngImagesForHtmlBasedEngine(boolean usePngImagesForHtmlBasedEngine) {
        this.usePngImagesForHtmlBasedEngine = usePngImagesForHtmlBasedEngine;
    }

    @Override
    public boolean isShowOnePageInRow() {
        return showOnePageInRow;
    }

    public void setShowOnePageInRow(boolean showOnePageInRow) {
        this.showOnePageInRow = showOnePageInRow;
    }

    @Override
    public boolean isLoadAllPagesOnSearch() {
        return loadAllPagesOnSearch;
    }

    public void setLoadAllPagesOnSearch(boolean loadAllPagesOnSearch) {
        this.loadAllPagesOnSearch = loadAllPagesOnSearch;
    }

    @Override
    public boolean isUseEmScaling() {
        return useEmScaling;
    }

    public void setUseEmScaling(boolean useEmScaling) {
        this.useEmScaling = useEmScaling;
    }

}
