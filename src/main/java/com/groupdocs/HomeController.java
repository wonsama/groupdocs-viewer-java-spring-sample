package com.groupdocs;

import com.google.gson.Gson;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.Assets;
import com.groupdocs.viewer.resources.GroupDocsViewer;
import com.groupdocs.viewer.resources.ViewerHandler;
import org.apache.commons.io.IOUtils;
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
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

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
        return index(model, request, response, "");
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam("fileId") String fileId) throws Exception {
        if (viewerHandler == null) {
            // Application path
            String appPath = applicationConfig.getApplicationPath();
            // File storage path
            String basePath = applicationConfig.getBasePath();
            // File license path
            String licensePath = applicationConfig.getLicensePath();
            // Assets path, where all js and css files will be stored
            String assetsDir = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath() + "\\assets\\";
            // INITIALIZE GroupDocs Java Viewer Object
            Assets assets = new Assets(assetsDir, DOCUMENT_VIEWER);
            ServiceConfiguration config = new ServiceConfiguration(appPath, basePath, licensePath, assets, Boolean.FALSE);
            viewerHandler = new ViewerHandler(config);
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", viewerHandler.getHeader());
        // Initialization of Viewer with document from this path
        model.addAttribute("filePath", fileId);
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
    
    @Override
    public Object getFileHandler(HttpServletResponse httpServletResponse, String path) {
        return viewerHandler.getFileHandler(path, httpServletResponse);
    }

    /**
     * Download file [GET request]
     * @param path
     * @param response
     * @return
     */
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public void getFileHandler(HttpServletRequest request, HttpServletResponse response, @RequestParam("path") String path) throws Exception {
        File file = (File) getFileHandler(response, path);
        OutputStream outputStream = response.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        IOUtils.copy(bufferedInputStream, outputStream);
        bufferedInputStream.close();
        fileInputStream.close();
    }
    
    @Override
    public Object getDocumentPageImageHandler(String guid, String width, Integer quality, Boolean usePdf, Integer pageIndex) throws Exception {
        return viewerHandler.getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex);
    }

    /**
     * Get image file [GET request]
     * @param guid
     * @param width
     * @param quality
     * @param usePdf
     * @param pageIndex
     * @return
     * @throws Exception
     */
    @RequestMapping(value = GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public void getDocumentPageImageHandler(HttpServletRequest request, HttpServletResponse response, @RequestParam("path") String guid, @RequestParam("width") String width,
            @RequestParam("quality") Integer quality, @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex) throws Exception {
        File file = (File) getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex);
        OutputStream outputStream = response.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        IOUtils.copy(bufferedInputStream, outputStream);
        bufferedInputStream.close();
        fileInputStream.close();
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
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, String callback, String data) {
        return jsonOut(viewerHandler.viewDocumentHandler(request));
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
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, String callback, String data) {
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
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request, String callback, String data) {
        return jsonOut(viewerHandler.getPrintableHtmlHandler(callback, data, request));
    }

    protected static ResponseEntity<String> jsonOut(Object obj) {
        return typeOut(obj, MediaType.APPLICATION_JSON);
    }

    protected static ResponseEntity<String> typeOut(Object obj, MediaType mediaType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(mediaType);
        return new ResponseEntity<String>(obj.toString(), httpHeaders, HttpStatus.CREATED);
    }
}
