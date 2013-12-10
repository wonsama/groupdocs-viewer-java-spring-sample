package com.groupdocs;

import com.google.gson.Gson;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.Assets;
import com.groupdocs.viewer.resources.ViewerHandler;
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
 * Created with IntelliJ IDEA.
 * User: liosha
 * Date: 05.12.13
 * Time: 22:54
 */
@Controller
public class HomeController {

    private static final String GROUPDOCS_VIEWER = "groupdocs-viewer";
    @Autowired
    protected ApplicationConfig applicationConfig;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) throws Exception {

        ViewerHandler viewerHandler = null;

        Object obj = request.getSession().getAttribute(GROUPDOCS_VIEWER);
        if (obj == null) {
            String appPath = applicationConfig.getApplicationPath();
            String basePath = applicationConfig.getBasePath();
            String assetsDir = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath() + "\\assets\\";
            //
            System.out.println("assetsDir: " + assetsDir);
            // INITIALIZE GroupDocs Java Viewer Object
            Assets assets = new Assets(assetsDir, "/groupdocs-viewer-java-lib-sample");
            ServiceConfiguration config = new ServiceConfiguration(appPath, basePath, null, assets, Boolean.FALSE);
            viewerHandler = new ViewerHandler(config);

            if (request.getSession() != null){
                request.getSession().setAttribute(GROUPDOCS_VIEWER, viewerHandler);
            }
        } else if (request.getSession() == null) {
            // Session is null
            throw new Exception("Session is null");
        } else {
            viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        }

        model.addAttribute("groupdocsHeader", viewerHandler.getHeader());
        model.addAttribute("message", "Hello to sample application!");
        return "index";
    }

    /**
     * Download file [GET request]
     * @param path
     * @param response
     * @return
     */
    @RequestMapping(value="/getFileHandler", method= RequestMethod.GET)
    public ResponseEntity<String> getFileHandler(HttpServletRequest request, HttpServletResponse response, @RequestParam("path") String path){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.getFileHandler(path, response));
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
    @RequestMapping(value="/getDocumentPageImageHandler", method= RequestMethod.GET)
    public ResponseEntity<String> getDocumentPageImageHandler(HttpServletRequest request, String guid, String width, Integer quality, Boolean usePdf, Integer pageIndex) throws Exception {
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex));
    }
    /**
     * Generate list of images/pages [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/viewDocumentHandler", method= RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.viewDocumentHandler(request));
    }
    /**
     * Generate list of images/pages [GET request]
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @RequestMapping(value="/viewDocumentHandler", method= RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, String callback, String data){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.viewDocumentHandler(request));
    }
    /**
     * Load tree of files from base directory [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/document-viewer/LoadFileBrowserTreeDataHandler", method= RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(request));
    }
    /**
     * Load tree of files from base directory [GET request]
     * @param callback
     * @param data
     * @return
     */
    @RequestMapping(value="/document-viewer/LoadFileBrowserTreeDataHandler", method= RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request, String callback, String data){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(callback, data));
    }
    /**
     * Get thumbs and other images files [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/getImageUrlsHandler", method= RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.getImageUrlsHandler(request));
    }
    /**
     * Get thumbs and other images files [GET request]
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @RequestMapping(value="/getImageUrlsHandler", method= RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, String callback, String data){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.getImageUrlsHandler(callback, data, request));
    }
    /**
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/getPdf2JavaScriptHandler", method= RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(request));
    }
    /**
     * Converts document to PDF and then to JavaScript for text search and selection [GET request]
     * @param callback
     * @param data
     * @return
     */
    @RequestMapping(value="/getPdf2JavaScriptHandler", method= RequestMethod.GET)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request, String callback, String data){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(callback, data));
    }
    /**
     * Print document [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/getPrintableHtmlHandler", method= RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.getPrintableHtmlHandler(request));
    }
    /**
     * Print document [GET request]
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @RequestMapping(value="/getPrintableHtmlHandler", method= RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request, String callback, String data){
        ViewerHandler viewerHandler = (ViewerHandler)request.getSession().getAttribute(GROUPDOCS_VIEWER);
        return jsonOut(viewerHandler.getPrintableHtmlHandler(callback, data, request));
    }


    protected static ResponseEntity<String> jsonOut(Object obj){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        Gson gson = new Gson();
        return new ResponseEntity<String>(gson.toJson(obj), responseHeaders, HttpStatus.CREATED);
    }
}
