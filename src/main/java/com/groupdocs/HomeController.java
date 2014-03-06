package com.groupdocs;

import com.google.gson.Gson;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Aleksey Permyakov, Alex Bobkov
 */
@Controller
public class HomeController extends GroupDocsViewer {
    @Autowired
    protected ApplicationConfig applicationConfig;
    protected ViewerHandler viewerHandler = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return index(model, request, response, null, null, null);
    }

    @RequestMapping(value = VIEW, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "filePath", required = false) String filePath, 
            @RequestParam(value = "fileUrl", required = false) String fileUrl, @RequestParam(value = "fileId", required = false) String fileId) throws Exception {
        if (viewerHandler == null) {
            // Application path
            String appPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            // File storage path
            String basePath = applicationConfig.getBasePath();
            // File license path
            String licensePath = applicationConfig.getLicensePath();
            // Authorization
            boolean useAuth = applicationConfig.useAuthorization();
            // Use cache
            boolean useCache = applicationConfig.useCache();
            // INITIALIZE GroupDocs Java Viewer Object
            ServiceConfiguration config = new ServiceConfiguration(appPath, basePath, licensePath, useAuth, useCache);
            viewerHandler = new ViewerHandler(config /*, new CustomInputDataHandler(config)*/);
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", viewerHandler.getHeader());
        // Initialization of Viewer with document from this path
        String encodedPath = "";
        if(StringUtils.isNotEmpty(fileUrl)) {
            encodedPath = new GroupDocsFilePath(fileUrl).getPath();
        }else if(StringUtils.isNotEmpty(filePath)){
            encodedPath = new GroupDocsFilePath(filePath, viewerHandler.getConfiguration()).getPath();
        }else if(StringUtils.isNotEmpty(fileId)){
            encodedPath = fileId;
        }
        model.addAttribute("filePath", encodedPath);
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
    
    /*
     * Get JavaScript files for Viewer UI building
     */
    @Override
    @RequestMapping(value = GET_JS_HANDLER, method = RequestMethod.GET)
    public void getJsHandler(@RequestParam("script") String script, HttpServletResponse response) throws IOException {
        viewerHandler.getJsHandler(script, response);
    }

    /*
     * Get CSS files for Viewer UI building
     */
    @Override
    @RequestMapping(value = GET_CSS_HANDLER, method = RequestMethod.GET)
    public void getCssHandler(@RequestParam("script") String script, HttpServletResponse response) throws IOException {
        viewerHandler.getCssHandler(script, response);
    }

    /*
     * Get images for Viewer UI building
     */
    @Override
    @RequestMapping(value = GET_IMAGE_HANDLER, method = RequestMethod.GET)
    public void getImageHandler(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        System.out.println(name);
        viewerHandler.getImageHandler(name, response);
    }

    /*
     * Download file [GET request]
     */
    @Override
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public void getFileHandler(@RequestParam("path") String path, HttpServletResponse response) throws Exception {
        viewerHandler.getFileHandler(path, response);
    }

    /*
     * Get image file [GET request]
     */
    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public void getDocumentPageImageHandler(@RequestParam("path") String guid, @RequestParam("width") String width, @RequestParam("quality") Integer quality, @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex, HttpServletResponse response) throws Exception {
        viewerHandler.getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex, response);
    }

    /*
     * Generate list of images/pages [POST request]
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request) {
        return jsonOut(viewerHandler.viewDocumentHandler(request));
    }

    /*
     * Generate list of images/pages [GET request]
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request) {
        return jsonOut(viewerHandler.viewDocumentHandler(callback, data, request));
    }

    /*
     * Load tree of files from base directory [POST request]
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request) {
        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(request));
    }

    /*
     * Load tree of files from base directory [GET request]
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data) {
        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(callback, data));
    }

    /*
     * Get thumbs and other images files [POST request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request) {
        return jsonOut(new Gson().toJson(viewerHandler.getImageUrlsHandler(request)));
    }

    /*
     * Get thumbs and other images files [GET request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request) {
        return jsonOut(viewerHandler.getImageUrlsHandler(callback, data, request));
    }

    /*
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request) {
        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(request));
    }

    /*
     * Converts document to PDF and then to JavaScript for text search and selection [GET request]
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPdf2JavaScriptHandler(String callback, String data) {
        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(callback, data));
    }

    /*
     * Print document [POST request]
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request) {
        return typeOut(viewerHandler.getPrintableHtmlHandler(request), MediaType.TEXT_HTML);
    }

    /*
     * Print document [GET request]
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request) {
        return jsonOut(viewerHandler.getPrintableHtmlHandler(callback, data, request));
    }
    
    /*
     * Upload document
     */
    @RequestMapping(value = UPLOAD_FILE, method = RequestMethod.POST)
    public void uploadFileHandler(@RequestParam("fileName") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException{
        // Upload file
        String uploadResponse = (String) viewerHandler.uploadFile(file.getInputStream(), file.getOriginalFilename());
        // Convert upload response to json object
        JSONObject obj = new JSONObject(uploadResponse);
        // Get token id
        String tokenId = obj.getString("tokenId");
        // Redirect to uplaoded file
        response.sendRedirect(request.getContextPath() + VIEW + "?fileId=" + tokenId);
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
