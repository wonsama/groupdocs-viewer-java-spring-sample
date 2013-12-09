package com.groupdocs;

import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.Assets;
import com.groupdocs.viewer.resources.ViewerHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: liosha
 * Date: 05.12.13
 * Time: 22:54
 */
@Controller
public class HomeController {

    @RequestMapping(value="/index.htm", method= RequestMethod.GET)
    public String index(Model model /* , @RequestParam("json") String json */) throws Exception {
        // INITIALIZE GroupDocs Java Viewer Object
        Assets assets = new Assets("D:\\Projects\\GroupDocs\\app\\Viewer\\GroupDocsJavaViewerSampleTomcat\\target\\groupdocs-viewer-java-lib-sample-1.0.0\\WEB-INF", "");
        ServiceConfiguration config = new ServiceConfiguration("http://127.0.0.1:8080", "E:\\Projects\\GroupDocs", null, assets, Boolean.FALSE);
        ViewerHandler viewer = new ViewerHandler(config);
        model.addAttribute("header", viewer.getHeader());
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
    public ResponseEntity<String> getFileHandler(String path, HttpServletResponse response){

        String sampleJson = "{path: '" + path + "'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
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
    public ResponseEntity<String> getDocumentPageImageHandler(String guid, String width, Integer quality, Boolean usePdf, Integer pageIndex) throws Exception {

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Generate list of images/pages [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/viewDocumentHandler", method= RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Generate list of images/pages [GET request]
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @RequestMapping(value="/viewDocumentHandler", method= RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Load tree of files from base directory [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/loadFileBrowserTreeDataHandler", method= RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Load tree of files from base directory [GET request]
     * @param callback
     * @param data
     * @return
     */
    @RequestMapping(value="/loadFileBrowserTreeDataHandler", method= RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Get thumbs and other images files [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/getImageUrlsHandler", method= RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Get thumbs and other images files [GET request]
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @RequestMapping(value="/getImageUrlsHandler", method= RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Converts document to PDF and then to JavaScript for text search and selection [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/getPdf2JavaScriptHandler", method= RequestMethod.POST)
    public ResponseEntity<String> getPdf2JavaScriptHandler(HttpServletRequest request){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Converts document to PDF and then to JavaScript for text search and selection [GET request]
     * @param callback
     * @param data
     * @return
     */
    @RequestMapping(value="/getPdf2JavaScriptHandler", method= RequestMethod.GET)
    public ResponseEntity<String> getPdf2JavaScriptHandler(String callback, String data){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Print document [POST request]
     * @param request
     * @return
     */
    @RequestMapping(value="/getPrintableHtmlHandler", method= RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Print document [GET request]
     * @param callback
     * @param data
     * @param request
     * @return
     */
    @RequestMapping(value="/getPrintableHtmlHandler", method= RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request){

        String sampleJson = "{test: 'value'}";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(sampleJson, responseHeaders, HttpStatus.CREATED);
    }


}
