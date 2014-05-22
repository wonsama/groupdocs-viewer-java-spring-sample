package com.groupdocs;

import com.google.gson.Gson;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.FileId;
import com.groupdocs.viewer.domain.FilePath;
import com.groupdocs.viewer.domain.FileUrl;
import com.groupdocs.viewer.domain.GroupDocsPath;
import com.groupdocs.viewer.domain.TokenId;
import com.groupdocs.viewer.handlers.ViewerHandler;
import com.groupdocs.viewer.resources.GroupDocsViewer;
import java.io.FileNotFoundException;
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
        return index(model, request, response, null, null, null, null);
    }

    @RequestMapping(value = VIEW, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "filePath", required = false) String filePath, 
            @RequestParam(value = "fileUrl", required = false) String fileUrl, @RequestParam(value = "fileId", required = false) String fileId,
            @RequestParam(value = "tokenId", required = false) String tokenId) throws Exception {
        if (viewerHandler == null) {
            // Application path
            String appPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            // File storage path
            String basePath = applicationConfig.getBasePath();
            // File license path
            String licensePath = applicationConfig.getLicensePath();
            // Authorization
            boolean useAuth = applicationConfig.isUseAuthorization();
            // Use cache
            boolean useCache = applicationConfig.isUseCache();
            // Default width
            int width = applicationConfig.getWidth();
            // Encryption key
            String encryptionKey = applicationConfig.getEncKey();
            // INITIALIZE GroupDocs Java Viewer Object
            ServiceConfiguration config = new ServiceConfiguration(appPath, basePath, licensePath, useAuth, useCache, width, encryptionKey);
            viewerHandler = new ViewerHandler(config /*, new CustomInputDataHandler(config)*/);
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", viewerHandler.getHeader());
        // Initialization of Viewer with document from this path
        GroupDocsPath gPath = null;
        if(fileId !=null && !fileId.isEmpty()){
            gPath = new FileId(fileId);
        }else if(filePath != null && !filePath.isEmpty()){
            gPath = new FilePath(filePath, viewerHandler.getConfiguration());
        }else if(fileUrl != null && !fileUrl.isEmpty()){
            gPath = new FileUrl(fileUrl);
        }else if(tokenId != null && !tokenId.isEmpty()){
            TokenId tki = new TokenId(tokenId, applicationConfig.getEncKey());
            if(tki.isExpired()){
                gPath = null;
            }else{
                gPath = tki;
            }
        }
        model.addAttribute("filePath", (gPath == null) ? "" : gPath.getPath());
        // Viewer config
        model.addAttribute("useHtmlBasedEngine", applicationConfig.isUseHtmlBasedEngine());
        model.addAttribute("quality", applicationConfig.getQuality());
        model.addAttribute("showThumbnails", applicationConfig.isShowThumbnails());
        model.addAttribute("openThumbnails", applicationConfig.isOpenThumbnails());
        model.addAttribute("initialZoom", applicationConfig.getInitialZoom());
        model.addAttribute("zoomToFitWidth", applicationConfig.isZoomToFitWidth());
        model.addAttribute("zoomToFitHeight", applicationConfig.isZoomToFitHeight());
        model.addAttribute("width", applicationConfig.getWidth());
        model.addAttribute("height", applicationConfig.getHeight());
        model.addAttribute("showFolderBrowser", applicationConfig.isShowFolderBrowser());
        model.addAttribute("showPrint", applicationConfig.isShowPrint());
        model.addAttribute("showDownload", applicationConfig.isShowDownload());
        model.addAttribute("showZoom", applicationConfig.isShowZoom());
        model.addAttribute("showPaging", applicationConfig.isShowPaging());
        model.addAttribute("showViewerStyleControl", applicationConfig.isShowViewerStyleControl());
        model.addAttribute("showSearch", applicationConfig.isShowSearch());
        model.addAttribute("preloadPagesCount", applicationConfig.getPreloadPagesCount());
        model.addAttribute("supportTextSelection", applicationConfig.isSupportTextSelection());
        model.addAttribute("usePdfPrinting", applicationConfig.isUsePdfPrinting());
        model.addAttribute("showHeader", applicationConfig.isShowHeader());
        model.addAttribute("useInnerThumbnails", applicationConfig.isUseInnerThumbnails());
        return "index";
    }
    
    /*
     * Get JavaScript files for Viewer UI building [GET request]
     */
    @Override
    @RequestMapping(value = GET_JS_HANDLER, method = RequestMethod.GET)
    public void getJsHandler(@RequestParam("script") String script, HttpServletResponse response) throws IOException {
        viewerHandler.getJsHandler(script, response);
    }

    /*
     * Get CSS files for Viewer UI building [GET request]
     */
    @Override
    @RequestMapping(value = GET_CSS_HANDLER, method = RequestMethod.GET)
    public void getCssHandler(@RequestParam("script") String script, HttpServletResponse response) throws IOException {
        viewerHandler.getCssHandler(script, response);
    }

    /*
     * Get images for Viewer UI building [GET request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_HANDLER, method = RequestMethod.GET)
    public void getImageHandler(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        System.out.println(name);
        viewerHandler.getImageHandler(name, response);
    }
    
    /*
     * Get Fonts [GET request]
     */
    @Override
    @RequestMapping(value = GET_FONT_HANDLER, method = RequestMethod.GET)
    public void getFontHandler(@PathVariable("name") String fontName, HttpServletResponse response) throws IOException {
        viewerHandler.getFontHandler(fontName, response);
    }
    
    /*
     * Get HTML resources [GET request]
     */
    @Override
    @RequestMapping(value = GET_HTML_RESOURCES_HANDLER, method = RequestMethod.GET)
    public void getHtmlRecoucesHandler(@RequestParam("filePath") String filePath, HttpServletResponse response) throws FileNotFoundException, IOException {
        viewerHandler.getHtmlRecoucesHandler(filePath, response);
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
    public void getDocumentPageImageHandler(@RequestParam("path") String path, @RequestParam("width") Integer width, @RequestParam("quality") Integer quality, @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex, HttpServletResponse response) throws Exception {
        viewerHandler.getDocumentPageImageHandler(path, width, quality, usePdf, pageIndex, response);
    }

    /*
     * Generate list of images/pages [POST request]
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(viewerHandler.viewDocumentHandler(request, response));
    }

    /*
     * Generate list of images/pages [GET request]
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(viewerHandler.viewDocumentHandler(callback, data, request, response));
    }

    /*
     * Load tree of files from base directory [POST request]
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(request, response));
    }

    /*
     * Load tree of files from base directory [GET request]
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data, HttpServletResponse response) {
        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(callback, data, response));
    }

    /*
     * Get thumbs and other images files [POST request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(new Gson().toJson(viewerHandler.getImageUrlsHandler(request, response)));
    }

    /*
     * Get thumbs and other images files [GET request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(viewerHandler.getImageUrlsHandler(callback, data, request, response));
    }

    /*
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(request, response));
    }

    /*
     * Converts document to PDF and then to JavaScript for text search and selection [GET request]
     */
    @Override
    @RequestMapping(value = GET_PDF_2_JAVA_SCRIPT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPdf2JavaScriptHandler(String callback, String data, HttpServletResponse response) {
        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(callback, data, response));
    }

    /*
     * Print document [POST request]
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        return typeOut(viewerHandler.getPrintableHtmlHandler(request, response), MediaType.TEXT_HTML);
    }

    /*
     * Print document [GET request]
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return jsonOut(viewerHandler.getPrintableHtmlHandler(callback, data, request, response));
    }
    
    /*
     * Upload document
     */
    @RequestMapping(value = UPLOAD_FILE, method = RequestMethod.POST)
    public void uploadFileHandler(@RequestParam("fileName") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException{
        // Upload file
        String uploadResponse = (String) viewerHandler.uploadFile(file.getInputStream(), file.getOriginalFilename(), applicationConfig.getExpirationDate());
        // Convert upload response to json object
        JSONObject obj = new JSONObject(uploadResponse);
        // Get token id
        String tokenId = obj.getString("tokenId");
        // Redirect to uplaoded file
        String appPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        response.sendRedirect(appPath + VIEW + "?tokenId=" + tokenId);
    }
    
    /*
     * Get document page HTML [POST request]
     */
    @RequestMapping(value = GET_DOCUMENT_PAGE_HTML_HANDLER, method = RequestMethod.POST)
    @Override
    public void getDocumentPageHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        viewerHandler.getDocumentPageHtmlHandler(request, response);
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
