<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>GroupDocs Viewer for Java Sample</title>
        ${groupdocsHeader}
    </head> 
    <body>
        <div id="test" style="width:${width}px;height:${height}px;overflow:hidden;position:relative;margin-bottom:20px;background-color:gray;border:1px solid #ccc;"></div>
        <script type="text/javascript">
            $(function() {
                var localizedStrings = null;
                var thumbsImageBase64Encoded = null;
                $('#test').groupdocsViewer({
                    filePath: '${filePath}',
                    docViewerId: 'doc_viewer1',
                    quality: 100,
                    showThumbnails: ${showThumbnails},
                    openThumbnails: ${openThumbnails},
                    initialZoom: 100,
                    zoomToFitWidth: true,
                    zoomToFitHeight: false,
                    width: ${width},
                    height: ${height},
                    backgroundColor: '',
                    showFolderBrowser: ${showFolderBrowser},
                    showPrint: ${showPrint},
                    showDownload: ${showDownload},
                    showZoom: ${showZoom},
                    showPaging: ${showPaging},
                    showViewerStyleControl: true,
                    showSearch: ${showSearch},
                    preloadPagesCount: 0,
                    viewerStyle: 1,
                    supportTextSelection: true,
                    usePdfPrinting: false,
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
                    showDownloadErrorsInPopup: true,
                    showImageWidth: false,
                    showHeader: ${showHeader},
                    minimumImageWidth: 0,
                    enableStandardErrorHandling: true
                });
            });
        </script>
    </body>
</html>
