package com.groupdocs;

import com.google.gson.Gson;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.Assets;
import com.groupdocs.viewer.domain.GroupDocsFilePath;
import com.groupdocs.viewer.handlers.ViewerHandler;
import com.groupdocs.viewer.resources.GroupDocsViewer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * User: liosha
 * Date: 05.12.13
 * Time: 22:54
 */
@Controller
public class HomeController extends GroupDocsViewer {
    @Autowired
    protected ApplicationConfig applicationConfig;
    protected ViewerHandler viewerHandler = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return index(model, request, response, "", null);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "fileId", required = false) String fileId, @RequestParam(value = "fileUrl", required = false) String fileUrl) throws Exception {
        if (viewerHandler == null) {
            // Application path
            String appPath = "http://" + request.getServerName() + ":" + request.getServerPort();
            // File storage path
            String basePath = applicationConfig.getBasePath();
            // File license path
            String licensePath = applicationConfig.getLicensePath();
            // Assets path, where all js and css files will be stored
            String assetsDir = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath() + "\\assets\\";
            // INITIALIZE GroupDocs Java Viewer Object
            Assets assets = new Assets(assetsDir, DOCUMENT_VIEWER);
            ServiceConfiguration config = new ServiceConfiguration(appPath, basePath, licensePath, assets, Boolean.FALSE, Boolean.TRUE);
            viewerHandler = new ViewerHandler(config /*, new CustomInputDataHandler(config)*/);
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", viewerHandler.getHeader());
        // Initialization of Viewer with document from this path
        GroupDocsFilePath groupDocsFilePath;
        if (StringUtils.isNotEmpty(fileUrl)) {
            groupDocsFilePath = new GroupDocsFilePath(fileUrl);
        } else {
            groupDocsFilePath = new GroupDocsFilePath(fileId);
        }
        model.addAttribute("filePath", groupDocsFilePath.getPath());
        // Viewer config
        model.addAttribute("showHeader", applicationConfig.getShowHeader());
        model.addAttribute("showThumbnails", applicationConfig.getShowThumbnails());
        model.addAttribute("openThumbnails", applicationConfig.getOpenThumbnails());
        model.addAttribute("width", applicationConfig.getWidth());
        model.addAttribute("height", applicationConfig.getHeight());
        model.addAttribute("showFolderBrowser", applicationConfig.getShowFolderBrowser());
        model.addAttribute("showPrint", applicationConfig.getShowPrint());
        model.addAttribute("showDownload", applicationConfig.getShowDownload());
        model.addAttribute("showZoom", applicationConfig.getShowZoom());
        model.addAttribute("showPaging", applicationConfig.getShowPaging());
        model.addAttribute("showSearch", applicationConfig.getShowSearch());
        return "index";
    }

    /**
     * Download file [GET request]
     * 
     * @param path
     * @param response
     * @throws java.lang.Exception
     */
    @Override
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public void getFileHandler(@RequestParam("path") String path, HttpServletResponse response) throws Exception {
        viewerHandler.getFileHandler(path, response);
    }

    /**
     * Get image file [GET request]
     * 
     * @param guid
     * @param width
     * @param quality
     * @param usePdf
     * @param pageIndex
     * @param response
     * @throws Exception
     */
    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public void getDocumentPageImageHandler(@RequestParam("path") String guid, @RequestParam("width") String width, @RequestParam("quality") Integer quality, @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex, HttpServletResponse response) throws Exception {
        viewerHandler.getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex, response);
    }

    /**
     * Generate list of images/pages [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request) {
        return jsonOut(viewerHandler.viewDocumentHandler(request));
    }

    /**
     * Generate list of images/pages [GET request]
     *
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request) {
        return jsonOut(viewerHandler.viewDocumentHandler(callback, data, request));
    }

    /**
     * Load tree of files from base directory [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request) {
        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(request));
    }

    /**
     * Load tree of files from base directory [GET request]
     *
     * @param callback
     * @param data
     * @return
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data) {
        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(callback, data));
    }

    /**
     * Get thumbs and other images files [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request) {
        return jsonOut(new Gson().toJson(viewerHandler.getImageUrlsHandler(request)));
    }

    /**
     * Get thumbs and other images files [GET request]
     *
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request) {
        return jsonOut(viewerHandler.getImageUrlsHandler(callback, data, request));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request) {
        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(request));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [GET request]
     *
     * @param callback
     * @param data
     * @return
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPdf2JavaScriptHandler(String callback, String data) {
        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(callback, data));
    }

    /**
     * Print document [POST request]
     *
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request) {
        return typeOut(viewerHandler.getPrintableHtmlHandler(request), MediaType.TEXT_HTML);
    }

    /**
     * Print document [GET request]
     *
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request) {
        return jsonOut(viewerHandler.getPrintableHtmlHandler(callback, data, request));
    }

    protected static ResponseEntity<String> jsonOut(Object obj) {
        return typeOut(obj, MediaType.APPLICATION_JSON);
    }

    protected static ResponseEntity<String> typeOut(Object obj, MediaType mediaType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (mediaType == MediaType.APPLICATION_JSON) {
            httpHeaders.set("Content-type", "application/json;charset=UTF-8");
        } else {
            httpHeaders.setContentType(mediaType);
        }
        return new ResponseEntity<String>(obj.toString(), httpHeaders, HttpStatus.CREATED);
    }
}
