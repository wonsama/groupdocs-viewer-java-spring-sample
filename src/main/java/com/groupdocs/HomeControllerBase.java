package com.groupdocs;

import com.groupdocs.viewer.resources.GroupDocsViewer;
import com.groupdocs.viewer.resources.IGroupDocsViewer;
import com.groupdocs.viewer.resources.IGroupDocsViewerIE;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Alex Bobkov
 */
public abstract class HomeControllerBase extends GroupDocsViewer implements IGroupDocsViewer, IGroupDocsViewerIE{
    
    protected ResponseEntity<String> writeOutputJson(Object obj) {
        return writeOutput(obj, MediaType.APPLICATION_JSON);
    }

    protected ResponseEntity<String> writeOutput(Object obj, MediaType mediaType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (mediaType == MediaType.APPLICATION_JSON) {
            httpHeaders.set("Content-type", "application/json;charset=UTF-8");
        } else {
            httpHeaders.setContentType(mediaType);
        }
        return new ResponseEntity<String>(obj.toString(), httpHeaders, HttpStatus.CREATED);
    }
    
    protected void writeOutput(InputStream inputStream, HttpServletResponse response){
        try {
            if (inputStream != null) {
                IOUtils.copy(inputStream, response.getOutputStream());
            }
        } catch (IOException ex) {
            Logger.getLogger(HomeControllerBase.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(HomeControllerBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    protected StringBuilder listToJson(List<String> list){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < list.size(); i++){
            sb.append("\"").append(list.get(i)).append("\"");
            if(i < list.size()-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb;
    }
}
