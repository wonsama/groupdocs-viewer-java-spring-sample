package com.groupdocs.handler;

import com.groupdocs.viewer.domain.FileType;
import com.groupdocs.viewer.resources.InputDataHandler;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by liosha on 23.01.14.
 */
public class CustomInputDataHandler extends InputDataHandler {
    private HashMap<String, FileType> fileId2FileType = new HashMap<String, FileType>();
    private HashMap<String, String> id2FileName = new HashMap<String, String>();

    public CustomInputDataHandler() {
        fileId2FileType.put("123_\\/_file_id_1", FileType.PDF);
        fileId2FileType.put("123_\\/_file_id_2", FileType.DOC);
        fileId2FileType.put("123_\\/_file_id_3", FileType.JPEG);
        fileId2FileType.put("123_\\/_directory_id_1", FileType.DIRECTORY);

        fileId2FileType.put("12345", FileType.PDF);
        fileId2FileType.put("67890", FileType.DOC);

        id2FileName.put("123_\\/_file_id_1", "10_page.pdf");
        id2FileName.put("123_\\/_file_id_2", "50_page.doc");
        id2FileName.put("123_\\/_file_id_3", "GroupDocs_Demo.jpeg");
        id2FileName.put("123_\\/_directory_id_1", "directory_for_test");
    }

    @Override
    public HashMap<String, String> getFileList(String directory) {
        if (directory == null || directory.isEmpty()){
            return id2FileName;
        }
        return new HashMap<String, String>(){{
            put("12345", "in_directory.pdf");
            put("67890", "in_directory.doc");
        }};
    }

    @Override
    public InputStream getFile(String guid) {
        try {
            return new FileInputStream("E:\\Projects\\GroupDocs\\" + id2FileName.get(guid));
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public FileType getFileType(String guid) {
        return fileId2FileType.get(guid);
    }
}
