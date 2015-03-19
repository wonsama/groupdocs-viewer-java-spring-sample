package com.groupdocs.handler;

import com.groupdocs.viewer.domain.GroupDocsFileDescription;
import com.groupdocs.viewer.handlers.cache.ImageCacheDataHandler;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Local image cache handler.
 *
 * @author Aleksey Permyakov on 17.03.2015.
 */
public class CustomImageCacheHandler extends ImageCacheDataHandler {
    private static final SecureRandom random = new SecureRandom();

    /**
     * The Cache directory.
     */
    protected String cacheDirectory;

    /**
     * Instantiates a new Local image cache handler.
     *
     * @param cachePath the cache path
     */
    public CustomImageCacheHandler(String cachePath) {
        if (cachePath == null || cachePath.isEmpty() || "null".equalsIgnoreCase(cachePath)) {
            cacheDirectory = createTempDirectory("temporary_", "_cache").getAbsolutePath();
        } else {
            cacheDirectory = cachePath;
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Cache directory: " + cacheDirectory);
    }

    @Override
    public boolean imageExists(GroupDocsFileDescription fileDescription, int page, int width) throws Exception {
        String filePath = makeImagePath(fileDescription, page, width);
        return new File(filePath).exists();
    }

    @Override
    public InputStream getImageStream(GroupDocsFileDescription fileDescription, int page, int width) throws Exception {
        String filePath = makeImagePath(fileDescription, page, width);
        return new FileInputStream(filePath);
    }

    @Override
    public OutputStream getImageSaveStream(GroupDocsFileDescription fileDescription, int page, int width) throws Exception {
        String filePath = makeImagePath(fileDescription, page, width);
        return new FileOutputStream(filePath);
    }

    @Override
    public boolean pdfExists(GroupDocsFileDescription fileDescription) throws Exception {
        String filePath = makePdfPath(fileDescription);
        return new File(filePath).exists();
    }

    @Override
    public InputStream getPdfStream(GroupDocsFileDescription fileDescription) throws Exception {
        String filePath = makePdfPath(fileDescription);
        return new FileInputStream(filePath);
    }

    @Override
    public OutputStream getPdfSaveStream(GroupDocsFileDescription fileDescription) throws Exception {
        String filePath = makePdfPath(fileDescription);
        return new FileOutputStream(filePath);
    }

    @Override
    public boolean jsExists(GroupDocsFileDescription fileDescription) throws Exception {
        String filePath = makeJsPath(fileDescription);
        return new File(filePath).exists();
    }

    @Override
    public String getJsContent(GroupDocsFileDescription fileDescription) throws Exception {
        String filePath = makeJsPath(fileDescription);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            return IOUtils.toString(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override
    public void saveJsContent(String content, GroupDocsFileDescription fileDescription) throws Exception {
        String filePath = makeJsPath(fileDescription);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
            outputStream.write(content.getBytes());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    /**
     * Make image path.
     *
     * @param fileDescription the file description
     * @param page            the page
     * @param width           the width
     * @return the string
     */
    protected String makeImagePath(GroupDocsFileDescription fileDescription, Integer page, int width) {
        String guid = fileDescription.getGuid();
        String baseName = fileDescription.getBaseName();
        final String htmlPath = String.format(Locale.CANADA, "%s/%s/%s_%02d_w%d.png", cacheDirectory, guid, baseName, page, width);
        final File htmlFile = new File(htmlPath);
        if (!htmlFile.exists() && !htmlFile.getParentFile().exists() && !htmlFile.getParentFile().mkdirs()) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't create directory: " + htmlFile.getAbsolutePath());
        }
        return htmlPath;
    }

    /**
     * Make pdf path.
     *
     * @param fileDescription the file description
     * @return the string
     */
    protected String makePdfPath(GroupDocsFileDescription fileDescription) {
        String guid = fileDescription.getGuid();
        String baseName = fileDescription.getBaseName();
        final String htmlPath = String.format(Locale.CANADA, "%s/%s/%s.pdf", cacheDirectory, guid, baseName);
        final File htmlFile = new File(htmlPath);
        if (!htmlFile.exists() && !htmlFile.getParentFile().exists() && !htmlFile.getParentFile().mkdirs()) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't create directory: " + htmlFile.getAbsolutePath());
        }
        return htmlPath;
    }

    /**
     * Make js path.
     *
     * @param fileDescription the file description
     * @return the string
     */
    protected String makeJsPath(GroupDocsFileDescription fileDescription) {
        String guid = fileDescription.getGuid();
        final String htmlPath = String.format(Locale.CANADA, "%s/%s/temp.js", cacheDirectory, guid);
        final File htmlFile = new File(htmlPath);
        if (!htmlFile.exists() && !htmlFile.getParentFile().exists() && !htmlFile.getParentFile().mkdirs()) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't create directory: " + htmlFile.getAbsolutePath());
        }
        return htmlPath;
    }

    private File createTempDirectory(String prefix, String suffix) {
        final String tmpDir = System.getProperty("java.io.tmpdir");
        File tempCacheDir = new File(tmpDir + File.separator + prefix + Long.toString(random.nextLong()) + suffix);
        int count = 100;
        while ((tempCacheDir.exists() || !tempCacheDir.mkdirs()) && count-- > 0) {
            tempCacheDir = new File(tmpDir + File.separator + prefix + Long.toString(random.nextLong()) + suffix);
        }
        if (count <= 0) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't create temp directory in " + tempCacheDir);
        }
        return tempCacheDir;
    }
}
