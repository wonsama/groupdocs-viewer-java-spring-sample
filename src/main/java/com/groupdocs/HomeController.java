package com.groupdocs;

import com.google.gson.Gson;
import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.Assets;
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
 * Created with IntelliJ IDEA.
 * User: liosha
 * Date: 05.12.13
 * Time: 22:54
 */
@Controller
public class HomeController {
    private static final String DOCUMENT_VIEWER = "/document-viewer";
    @Autowired
    protected ApplicationConfig applicationConfig;
    protected ViewerHandler viewerHandler = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (viewerHandler == null) {
            String appPath = applicationConfig.getApplicationPath();
            String basePath = applicationConfig.getBasePath();
            String assetsDir = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath() + "\\assets\\";
            //
            System.out.println("assetsDir: " + assetsDir);
            // INITIALIZE GroupDocs Java Viewer Object
            Assets assets = new Assets(assetsDir, DOCUMENT_VIEWER);
            ServiceConfiguration config = new ServiceConfiguration(appPath, basePath, null, assets, Boolean.FALSE);
            viewerHandler = new ViewerHandler(config);
        }

        model.addAttribute("groupdocsHeader", viewerHandler.getHeader());
        model.addAttribute("message", "Hello to sample application!");
        return "index";
    }

    /**
     * Download file [GET request]
     *
     * @param path
     * @param response
     * @return
     */
//    @ResponseBody
    @RequestMapping(value = "/GetFileHandler", method = RequestMethod.GET)
    public void getFileHandler(HttpServletRequest request, HttpServletResponse response, @RequestParam("path") String path) throws Exception {
        response.setContentType("application/octet-stream");
        File file = (File) viewerHandler.getFileHandler(path, response);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        OutputStream outputStream = response.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        IOUtils.copy(bufferedInputStream, outputStream);
        bufferedInputStream.close();
        fileInputStream.close();
    }

    /**
     * Get image file [GET request]
     *
     * @param guid
     * @param width
     * @param quality
     * @param usePdf
     * @param pageIndex
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/GetDocumentPageImageHandler", method = RequestMethod.GET)
    public void getDocumentPageImageHandler(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam("path") String guid,
            @RequestParam("width") String width,
            @RequestParam("quality") Integer quality,
            @RequestParam("usePdf") Boolean usePdf,
            @RequestParam("pageIndex") Integer pageIndex
    ) throws Exception {
        response.setContentType("image/jpeg");
        File file = (File) viewerHandler.getDocumentPageImageHandler(guid, width, quality, usePdf, pageIndex);
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
    @RequestMapping(value = "/ViewDocumentHandler", method = RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, HttpServletResponse response) {

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
    @RequestMapping(value = "/ViewDocumentHandler", method = RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, String callback, String data) {

        return jsonOut(viewerHandler.viewDocumentHandler(request));
    }

    /**
     * Load tree of files from base directory [POST request]
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/LoadFileBrowserTreeDataHandler", method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request, HttpServletResponse response) {

        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(request));
    }

    /**
     * Load tree of files from base directory [GET request]
     *
     * @param callback
     * @param data
     * @return
     */
    @RequestMapping(value = "/LoadFileBrowserTreeDataHandler", method = RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request, String callback, String data) {

        return jsonOut(viewerHandler.loadFileBrowserTreeDataHandler(callback, data));
    }

    /**
     * Get thumbs and other images files [POST request]
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/GetImageUrlsHandler", method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, HttpServletResponse response) {

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
    @RequestMapping(value = "/GetImageUrlsHandler", method = RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, String callback, String data) {

        return jsonOut(viewerHandler.getImageUrlsHandler(callback, data, request));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/GetPdf2JavaScriptHandler", method = RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request, HttpServletResponse response) {

        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(request));
    }

    /**
     * Converts document to PDF and then to JavaScript for text search and selection [GET request]
     *
     * @param callback
     * @param data
     * @return
     */
    @RequestMapping(value = "/GetPdf2JavaScriptHandler", method = RequestMethod.GET)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request, String callback, String data) {

        return jsonOut(viewerHandler.getPdf2JavaScriptHandler(callback, data));
    }

    /**
     * Print document [POST request]
     *
     * @param request
     * @return
     */
    @RequestMapping(value = DOCUMENT_VIEWER + "/GetPrintableHtmlHandler", method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request, HttpServletResponse response) {

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
    @RequestMapping(value = DOCUMENT_VIEWER + "/GetPrintableHtmlHandler", method = RequestMethod.GET)
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
