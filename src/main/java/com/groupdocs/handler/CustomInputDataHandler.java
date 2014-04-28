package com.groupdocs.handler;

import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.FileType;
import com.groupdocs.viewer.handlers.InputDataHandler;
import com.groupdocs.viewer.resources.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @author Aleksey Permyakov, Alex Bobkov
 */
public class CustomInputDataHandler extends InputDataHandler {
    private final HashMap<String, String> fileId2FilePath = new HashMap<String, String>();
    private final HashMap<String, String> fileId2FileName = new HashMap<String, String>();
    private String basePath = null;

    public CustomInputDataHandler(ServiceConfiguration serviceConfiguration) {
        basePath = serviceConfiguration.getBasePath();
    }

    @Override
    public HashMap<String, String> getFileList(String directory) {
        File[] files = new File(basePath + directory).listFiles();
        for (File file : files) {
            String fileId = Utils.encodeData(file.getAbsolutePath());
            fileId2FilePath.put(fileId, file.getAbsolutePath());
            fileId2FileName.put(fileId, file.getName());
        }
        return fileId2FileName;
    }

    @Override
    public InputStream getFile(String guid) {
        try {
            return new FileInputStream(fileId2FilePath.get(guid));
        } catch (FileNotFoundException e){
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

    @Override
    public String saveFile(InputStream inputStream, String fileName, Integer timeToLive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
