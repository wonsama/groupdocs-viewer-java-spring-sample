package com.groupdocs;

import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.path.EncodedPath;
import com.groupdocs.viewer.domain.path.GroupDocsPath;
import com.groupdocs.viewer.domain.path.TokenId;
import com.groupdocs.viewer.handlers.ViewerHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Aleksey Permyakov, Alex Bobkov
 */
@Controller
public class HomeController extends HomeControllerBase {
    @Autowired
    protected ApplicationConfig applicationConfig;
    protected ViewerHandler viewerHandler = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return index(model, request, response, null, null);
    }

    @RequestMapping(value = VIEW, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = false) String file, 
            @RequestParam(value = "tokenId", required = false) String tokenId) throws Exception {
        if (viewerHandler == null) {
            // INITIALIZE GroupDocs Java Viewer Object
            ServiceConfiguration config = new ServiceConfiguration(applicationConfig);
            //Uncomment this line to use Azure storage
            //viewerHandler = new ViewerHandler(config, new AzureInputDataHandler("acount_name", "account_key"));
            //Uncomment this line to use Amazon S3 storage
            //viewerHandler = new ViewerHandler(config, new AmazonS3InputDataHandler("access_key", "secret_key", "bucket_name"));
            viewerHandler = new ViewerHandler(config);
        }
        // Setting header in jsp page
        model.addAttribute("groupdocsHeader", viewerHandler.getHeader());
        // Initialization of Viewer with document from this path
        GroupDocsPath path = null;
        if(file != null && !file.isEmpty()){
            path = new EncodedPath(file, viewerHandler.getConfiguration());
        }else if(tokenId != null && !tokenId.isEmpty()){
            TokenId tki = new TokenId(tokenId, applicationConfig.getEncryptionKey());
            if(!tki.isExpired()){
                path = tki;
            }
        }
        String viewerId = "test";
        String initialFilePath = (path == null) ? "" : path.getPath();
        String locale = viewerHandler.getLocale();
        model.addAttribute("viewerScript", viewerHandler.getViewerScript(viewerId, initialFilePath, locale));
        return "index";
    }
    
    /*
     * Get JavaScript files for Viewer UI building [GET request]
     */
    @Override
    @RequestMapping(value = GET_JS_HANDLER, method = RequestMethod.GET)
    public Object getJsHandler(@RequestParam("script") String script, HttpServletResponse response) throws Exception{
        Object obj = viewerHandler.getJsHandler(script, response);
        //cache handling
        if(obj != null){
            writeOutput((InputStream) obj, response);
            return null;
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    /*
     * Get CSS files for Viewer UI building [GET request]
     */
    @Override
    @RequestMapping(value = GET_CSS_HANDLER, method = RequestMethod.GET)
    public Object getCssHandler(@RequestParam("script") String script, HttpServletResponse response) throws Exception{
        Object obj = viewerHandler.getCssHandler(script, response);
        //cache handling
        if(obj != null){
            writeOutput((InputStream) obj, response);
            return null;
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    /*
     * Get images for Viewer UI building [GET request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getImageHandler(@PathVariable("name") String name, HttpServletResponse response) throws Exception{
        Object obj = viewerHandler.getImageHandler(name, response);
        //cache handling
        if(obj != null){
            writeOutput((InputStream) obj, response);
            return null;
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
    
    /*
     * Get Fonts [GET request]
     */
    @Override
    @RequestMapping(value = GET_FONT_HANDLER, method = RequestMethod.GET)
    public Object getFontHandler(@PathVariable("name") String fontName, HttpServletResponse response) throws Exception{
        Object obj = viewerHandler.getFontHandler(fontName, response);
        //cache handling
        if(obj != null){
            writeOutput((InputStream) obj, response);
            return null;
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
    
    /*
     * Get HTML resources [GET request]
     */
    @Override
    @RequestMapping(value = GET_HTML_RESOURCES_HANDLER, method = RequestMethod.GET)
    public Object getHtmlResourcesHandler(@RequestParam("filePath") String filePath, HttpServletResponse response) throws Exception{
        writeOutput((InputStream) viewerHandler.getHtmlResourcesHandler(filePath, response), response);
        return null;
    }

    /*
     * Download file [GET request]
     */
    @Override
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public Object getFileHandler(@RequestParam("path") String path, @RequestParam("getPdf") boolean getPdf, HttpServletResponse response) throws Exception{
        writeOutput((InputStream) viewerHandler.getFileHandler(path, getPdf, response), response);
        return null;
    }

    /*
     * Get image file [GET request]
     */
    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getDocumentPageImageHandler(@RequestParam("path") String path, @RequestParam("width") Integer width, @RequestParam("quality") Integer quality, @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex, @RequestParam("isPrint") Boolean isPrint, HttpServletResponse response) throws Exception{
        writeOutput((InputStream) viewerHandler.getDocumentPageImageHandler(path, width, quality, usePdf, pageIndex, isPrint, response), response);
        return null;
    }

    /*
     * Generate list of images/pages [POST request]
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return writeOutputJson(viewerHandler.viewDocumentHandler(request, response));
    }

    /*
     * Generate list of images/pages [GET request]
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return writeOutputJson(viewerHandler.viewDocumentHandler(callback, data, request, response));
    }

    /*
     * Load tree of files from base directory [POST request]
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return writeOutputJson(viewerHandler.loadFileBrowserTreeDataHandler(request, response));
    }

    /*
     * Load tree of files from base directory [GET request]
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data, HttpServletResponse response) throws Exception {
        return writeOutputJson(viewerHandler.loadFileBrowserTreeDataHandler(callback, data, response));
    }

    /*
     * Get thumbs and other images files [POST request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return writeOutputJson(viewerHandler.getImageUrlsHandler(request, response));
    }

    /*
     * Get thumbs and other images files [GET request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return writeOutputJson(viewerHandler.getImageUrlsHandler(callback, data, request, response));
    }

    /*
     * Print document [POST request]
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuilder sb = listToJson((List<String>) viewerHandler.getPrintableHtmlHandler(request, response));
        return writeOutputJson(sb);
    }

    /*
     * Print document [GET request]
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuilder sb = listToJson((List<String>) viewerHandler.getPrintableHtmlHandler(callback, data, request, response));
        return writeOutputJson(sb);
    }
    
    /*
     * Upload document
     */
    @RequestMapping(value = UPLOAD_FILE, method = RequestMethod.POST)
    public void uploadFileHandler(@RequestParam("fileName") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, Exception{
        // Upload file
        String uploadResponse = (String) viewerHandler.uploadFile(file.getInputStream(), file.getOriginalFilename(), applicationConfig.getExpirationDate());
        // Convert upload response to json object
        JSONObject obj = new JSONObject(uploadResponse);
        // Get token id
        String tokenId = obj.getString("tokenId");
        // Redirect to uplaoded file
        response.sendRedirect("view?tokenId=" + tokenId);
    }
    
    /*
     * Get document page HTML [POST request]
     */
    @RequestMapping(value = GET_DOCUMENT_PAGE_HTML_HANDLER, method = RequestMethod.POST)
    @Override
    public Object getDocumentPageHtmlHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        writeOutput((InputStream) viewerHandler.getDocumentPageHtmlHandler(request, response), response);
        return null;
    }


    /*
    * Get pdf with print dialog [GET request]
    */
    @RequestMapping(value = GET_PDF_WITH_PRINT_DIALOG, method = RequestMethod.GET)
    @Override
    public Object getPdfWithPrintDialog(@RequestParam("path") String path, HttpServletResponse response) throws Exception {
        writeOutput((InputStream) viewerHandler.getPdfWithPrintDialog(path, response), response);
        return null;
    }

    /*
    * Reorder pages [POST request]
    */
    @RequestMapping(value = REORDER_PAGE_HANDLER, method = RequestMethod.POST)
    @Override
    public Object reorderPageHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return writeOutputJson(viewerHandler.reorderPageHandler(request, response));
    }

    @RequestMapping(value = ROTATE_PAGE_HANDLER, method = RequestMethod.POST)
    @Override
    public Object rotatePageHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return writeOutputJson(viewerHandler.rotatePageHandler(request, response));
    }

}
