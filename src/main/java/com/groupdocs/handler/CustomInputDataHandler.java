package com.groupdocs.handler;

import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.FileType;
import com.groupdocs.viewer.resources.InputDataHandler;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by liosha on 23.01.14.
 */
public class CustomInputDataHandler extends InputDataHandler {
    private HashMap<String, String> fileId2FilePath = new HashMap<String, String>();
    private HashMap<String, String> fileId2FileName = new HashMap<String, String>();
    private String basePath = null;

    public CustomInputDataHandler(ServiceConfiguration serviceConfiguration) {
        basePath = serviceConfiguration.getBasePath() + "/files/";
    }

    @Override
    public HashMap<String, String> getFileList(String directory) {
        File[] files = new File(basePath + directory).listFiles();
        for (File file : files) {
            String fileId = new String(Base64.encodeBase64(file.getName().getBytes())) + Long.toString(file.length());
            fileId2FilePath.put(fileId, file.getAbsolutePath());
            fileId2FileName.put(fileId, file.getName());
        }
        return fileId2FileName;
    }

    @Override
    public InputStream getFile(String guid) {
        try {
            return new FileInputStream(fileId2FilePath.get(guid));
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public FileType getFileType(String guid) {
        String fileName = new File(fileId2FileName.get(guid)).getName();
        if (fileName.contains(".")) {
            return FileType.valueOf(fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase());
        }
        return FileType.DIRECTORY;
    }
}
