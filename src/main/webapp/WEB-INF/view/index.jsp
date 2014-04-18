<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>GroupDocs.Viewer for Java Sample</title>
        ${groupdocsHeader}
    </head> 
    <body>
        <h1>GroupDocs.Viewer for Java Sample</h1>
        <div>
            <form enctype="multipart/form-data" method="POST" id="uploadForm" action="UploadFile">
                <input type="file" id="fileUpload" name="fileName"/>
                <input type="submit" id="submitUpload" value="Upload"/>
            </form>
        </div>
        <div id="test"></div>
        <script type="text/javascript">
            $(function() {
                var localizedStrings = null;
                var thumbsImageBase64Encoded = null;
                $('#test').groupdocsViewer({ 
                    filePath: '${filePath}',
                    quality: ${quality}, 
                    showThumbnails: ${showThumbnails}, 
                    openThumbnails: ${openThumbnails}, 
                    initialZoom: ${initialZoom}, 
                    zoomToFitWidth: ${zoomToFitWidth}, 
                    zoomToFitHeight: ${zoomToFitHeight}, 
                    width: ${width}, 
                    height: ${height}, 
                    backgroundColor: '', 
                    showFolderBrowser: ${showFolderBrowser}, 
                    showPrint: ${showPrint}, 
                    showDownload: ${showDownload}, 
                    showZoom: ${showZoom}, 
                    showPaging: ${showPaging}, 
                    showViewerStyleControl: ${showViewerStyleControl}, 
                    showSearch: ${showSearch}, 
                    preloadPagesCount: ${preloadPagesCount}, 
                    viewerStyle: 1, 
                    supportTextSelection: ${supportTextSelection}, 
                    usePdfPrinting: ${usePdfPrinting}, 
                    localizedStrings: localizedStrings, 
                    thumbsImageBase64Encoded: thumbsImageBase64Encoded, 
                    toolbarButtonsBoxShadowStyle: '', 
                    toolbarButtonsBoxShadowHoverStyle: '',
                    thumbnailsContainerBackgroundColor: '', 
                    thumbnailsContainerBorderRightColor: '',
                    toolbarBorderBottomColor: '', 
                    toolbarInputFieldBorderColor: '',
                    toolbarButtonBorderColor: '', 
                    toolbarButtonBorderHoverColor: '',
                    thumbnailsContainerWidth: 0,
                    jqueryFileDownloadCookieName: 'jqueryFileDownloadJSForGD', 
                    showDownloadErrorsInPopup: false,
                    showImageWidth: false, 
                    showHeader: ${showHeader},
                    minimumImageWidth: 0, 
                    enableStandardErrorHandling: true,
                    useHtmlBasedEngine: ${useHtmlBasedEngine}, 
                    useImageBasedPrinting: true, 
                    fileDisplayName: '', 
                    downloadPdfFile: false,
                    searchForSeparateWords: false,
                    preventTouchEventsBubbling: false, 
                    useInnerThumbnails: ${useInnerThumbnails},
                    watermarkText: '', 
                    supportPageReordering: false,
                    watermarkFontSize: null,
                    watermarkColor: null,
                    watermarkLeft: null,
                    watermarkTop: null
                }); 
            });
        </script>
    </body>
</html>
