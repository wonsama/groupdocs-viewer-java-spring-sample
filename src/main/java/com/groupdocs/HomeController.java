package com.groupdocs;

import com.groupdocs.config.ApplicationConfig;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.path.EncodedPath;
import com.groupdocs.viewer.domain.path.GroupDocsPath;
import com.groupdocs.viewer.domain.path.TokenId;
import com.groupdocs.viewer.handlers.ViewerHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
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
            viewerHandler = new ViewerHandler(config /*, new CustomInputDataHandler(config)*/);
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
    public Object getJsHandler(@RequestParam("script") String script, HttpServletResponse response){
        writeOutput((InputStream) viewerHandler.getJsHandler(script, response), response);
        return null;
    }

    /*
     * Get CSS files for Viewer UI building [GET request]
     */
    @Override
    @RequestMapping(value = GET_CSS_HANDLER, method = RequestMethod.GET)
    public Object getCssHandler(@RequestParam("script") String script, HttpServletResponse response){
        writeOutput((InputStream) viewerHandler.getCssHandler(script, response), response);
        return null;
    }

    /*
     * Get images for Viewer UI building [GET request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getImageHandler(@PathVariable("name") String name, HttpServletResponse response){
        writeOutput((InputStream) viewerHandler.getImageHandler(name, response), response);
        return null;
    }
    
    /*
     * Get Fonts [GET request]
     */
    @Override
    @RequestMapping(value = GET_FONT_HANDLER, method = RequestMethod.GET)
    public Object getFontHandler(@PathVariable("name") String fontName, HttpServletResponse response){
        writeOutput((InputStream) viewerHandler.getFontHandler(fontName, response), response);
        return null;
    }
    
    /*
     * Get HTML resources [GET request]
     */
    @Override
    @RequestMapping(value = GET_HTML_RESOURCES_HANDLER, method = RequestMethod.GET)
    public Object getHtmlRecoucesHandler(@RequestParam("filePath") String filePath, HttpServletResponse response){
        writeOutput((InputStream) viewerHandler.getHtmlRecoucesHandler(filePath, response), response);
        return null;
    }

    /*
     * Download file [GET request]
     */
    @Override
    @RequestMapping(value = GET_FILE_HANDLER, method = RequestMethod.GET)
    public Object getFileHandler(@RequestParam("path") String path, @RequestParam("getPdf") boolean getPdf, HttpServletResponse response){
        writeOutput((InputStream) viewerHandler.getFileHandler(path, getPdf, response), response);
        return null;
    }

    /*
     * Get image file [GET request]
     */
    @Override
    @RequestMapping(value = GET_DOCUMENT_PAGE_IMAGE_HANDLER, method = RequestMethod.GET)
    public Object getDocumentPageImageHandler(@RequestParam("path") String path, @RequestParam("width") Integer width, @RequestParam("quality") Integer quality, @RequestParam("usePdf") Boolean usePdf, @RequestParam("pageIndex") Integer pageIndex, HttpServletResponse response){
        writeOutput((InputStream) viewerHandler.getDocumentPageImageHandler(path, width, quality, usePdf, pageIndex, response), response);
        return null;
    }

    /*
     * Generate list of images/pages [POST request]
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> viewDocumentHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(viewerHandler.viewDocumentHandler(request, response));
    }

    /*
     * Generate list of images/pages [GET request]
     */
    @Override
    @RequestMapping(value = VIEW_DOCUMENT_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> viewDocumentHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(viewerHandler.viewDocumentHandler(callback, data, request, response));
    }

    /*
     * Load tree of files from base directory [POST request]
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.POST)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(viewerHandler.loadFileBrowserTreeDataHandler(request, response));
    }

    /*
     * Load tree of files from base directory [GET request]
     */
    @Override
    @RequestMapping(value = LOAD_FILE_BROWSER_TREE_DATA_HANLER, method = RequestMethod.GET)
    public ResponseEntity<String> loadFileBrowserTreeDataHandler(String callback, String data, HttpServletResponse response) {
        return writeOutputJson(viewerHandler.loadFileBrowserTreeDataHandler(callback, data, response));
    }

    /*
     * Get thumbs and other images files [POST request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getImageUrlsHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(viewerHandler.getImageUrlsHandler(request, response));
    }

    /*
     * Get thumbs and other images files [GET request]
     */
    @Override
    @RequestMapping(value = GET_IMAGE_URL_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getImageUrlsHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(viewerHandler.getImageUrlsHandler(callback, data, request, response));
    }

    /*
     * Print document [POST request]
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.POST)
    public ResponseEntity<String> getPrintableHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutput(viewerHandler.getPrintableHtmlHandler(request, response), MediaType.TEXT_HTML);
    }

    /*
     * Print document [GET request]
     */
    @Override
    @RequestMapping(value = GET_PRINTABLE_HTML_HANDLER, method = RequestMethod.GET)
    public ResponseEntity<String> getPrintableHtmlHandler(String callback, String data, HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(viewerHandler.getPrintableHtmlHandler(callback, data, request, response));
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
        response.sendRedirect("view?tokenId=" + tokenId);
    }
    
    /*
     * Get document page HTML [POST request]
     */
    @RequestMapping(value = GET_DOCUMENT_PAGE_HTML_HANDLER, method = RequestMethod.POST)
    @Override
    public Object getDocumentPageHtmlHandler(HttpServletRequest request, HttpServletResponse response) {
        writeOutput((InputStream) viewerHandler.getDocumentPageHtmlHandler(request, response), response);
        return null;
    }


    /*
    * Get pdf with print dialog [GET request]
    */
    @RequestMapping(value = GET_PDF_WITH_PRINT_DIALOG, method = RequestMethod.GET)
    @Override
    public Object getPdfWithPrintDialog(@RequestParam("path") String path, HttpServletResponse response) {
        writeOutput((InputStream) viewerHandler.getPdfWithPrintDialog(path, response), response);
        return null;
    }

    /*
    * Reorder pages [POST request]
    */
    @RequestMapping(value = REORDER_PAGE_HANDLER, method = RequestMethod.POST)
    @Override
    public Object reorderPageHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(viewerHandler.reorderPageHandler(request, response));
    }

    @Override
    public Object rotatePageHandler(HttpServletRequest request, HttpServletResponse response) {
        return writeOutputJson(viewerHandler.rotatePageHandler(request, response));
    }

}
