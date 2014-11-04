package com.groupdocs.handler;

import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.FileType;
import com.groupdocs.viewer.handlers.input.InputDataHandler;
import com.groupdocs.viewer.utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @author Alex Bobkov
 */
public class CustomInputDataHandler extends InputDataHandler{
    private final HashMap<String, File> fileMap = new HashMap<String, File>();
    private String basePath = null;

    public CustomInputDataHandler(ServiceConfiguration serviceConfiguration) {
        basePath = serviceConfiguration.getBasePath();
    }

    @Override
    public File[] getFileList(String directory) {
        File[] files = new File(basePath + directory).listFiles();
        for (File file : files) {
            String fileId = Utils.encodeData(file.getName());
            fileMap.put(fileId, file);
        }
        return files;
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
    public FileType getFileType(String guid) {
        String fileName = fileMap.get(guid).getName();
        if (fileName.contains(".")) {
            return FileType.valueOf(fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase());
        }
        return FileType.DIRECTORY;
    }

    @Override
    public String saveFile(InputStream inputStream, String fileName, Integer timeToLive, String encryptedKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
