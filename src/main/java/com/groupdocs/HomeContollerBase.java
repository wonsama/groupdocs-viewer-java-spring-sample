package com.groupdocs;

import com.groupdocs.viewer.resources.GroupDocsViewer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Alex Bobkov
 */
public abstract class HomeContollerBase extends GroupDocsViewer{
    
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
