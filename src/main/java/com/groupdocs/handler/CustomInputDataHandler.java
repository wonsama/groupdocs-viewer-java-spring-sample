package com.groupdocs.handler;

import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.GroupDocsFileDescription;
import com.groupdocs.viewer.handlers.input.InputDataHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 * @author Alex Bobkov
 */
public class CustomInputDataHandler extends InputDataHandler{
    private final HashMap<String, File> fileMap = new HashMap<String, File>();
    private String basePath = null;

    public CustomInputDataHandler(ServiceConfiguration serviceConfiguration) {
        basePath = serviceConfiguration.getRootDir();
    }

    @Override
    public List<GroupDocsFileDescription> getFileDescriptionList(String directory) {
        File[] files = new File(basePath + directory).listFiles();
        List<GroupDocsFileDescription> fileList = new ArrayList<GroupDocsFileDescription>();
        for(File file : files){
            //Generate file ID
            String guid = Base64.encodeBase64String(file.getName().getBytes());
            //Create file description object
            GroupDocsFileDescription fileDescription = new GroupDocsFileDescription();
            fileDescription.setGuid(guid);
            fileDescription.setName(file.getName());
            if (file.exists() && file.isFile()) {
                //If file
                fileDescription.setLastModified(file.lastModified());
                fileDescription.setSize(file.length());
            }else{
                //If directory
                fileDescription.setLastModified(0);
                fileDescription.setSize(0);
            }
            fileList.add(fileDescription);
            fileMap.put(guid, file);
        }
        return fileList;
    }
    
    @Override
    public GroupDocsFileDescription getFileDescription(String guid) throws Exception {
        //Create file description object
        GroupDocsFileDescription fileDescription = new GroupDocsFileDescription();
        fileDescription.setGuid(guid);
        //Check if guid is initial directory
        if(guid.isEmpty()){
            fileDescription.setName("");
        }else{
            //Get file
            File file = fileMap.get(guid);
            fileDescription.setName(file.getName());
            if (file.exists() && file.isFile()) {
                //If file
                fileDescription.setLastModified(file.lastModified());
                fileDescription.setSize(file.length());
            }else{
                //If directory
                fileDescription.setLastModified(0);
                fileDescription.setSize(0);
            }
        }
        return fileDescription;
    }

    @Override
    public InputStream getFile(String guid) {
        try {
            return new FileInputStream(fileMap.get(guid));
        } catch (FileNotFoundException e){
            return null;
        }
    }

    @Override
    public String saveFile(InputStream inputStream, String fileName, Integer timeToLive, String encryptedKey) throws FileNotFoundException, IOException {
        //Generate file ID
        String guid = Base64.encodeBase64String(fileName.getBytes());
        //Save file
        File saveFile = new File(basePath + "/" + fileName);
        FileOutputStream outputStream = new FileOutputStream(saveFile);
        IOUtils.copy(inputStream, outputStream);
        return guid;
    }

}
