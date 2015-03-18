package com.groupdocs.handler;

import com.groupdocs.viewer.domain.GroupDocsFileDescription;
import com.groupdocs.viewer.handlers.cache.HtmlCacheDataHandler;
import com.groupdocs.viewer.utils.Utils;

import java.io.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Local html cache handler.
 * @author Aleksey Permyakov on 17.03.2015.
 */
public class LocalHtmlCacheHandler extends HtmlCacheDataHandler {
    /**
     * The Cache directory.
     */
    protected String cacheDirectory;

    /**
     * Instantiates a new Local html cache handler.
     * @param cachePath the cache path
     */
    public LocalHtmlCacheHandler(String cachePath) {
        if (cachePath == null || cachePath.isEmpty() || "null".equalsIgnoreCase(cachePath)) {
            try {
                cacheDirectory = Utils.createTempDirectory("temporary_", "_cache").getAbsolutePath();
            } catch (IOException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't create temporary directory");
            }
        } else {
            cacheDirectory = cachePath;
        }
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Cache directory: " + cacheDirectory);
    }

    @Override
    public boolean htmlExists(GroupDocsFileDescription fileDescription, Integer page) throws Exception {
        String filePath = makeHtmlPath(fileDescription, page);
        return new File(filePath).exists();
    }

    @Override
    public InputStream getHtmlStream(GroupDocsFileDescription fileDescription, Integer page) throws Exception {
        String filePath = makeHtmlPath(fileDescription, page);
        return new FileInputStream(filePath);
    }

    @Override
    public OutputStream getHtmlSaveStream(GroupDocsFileDescription fileDescription, Integer page) throws Exception {
        String filePath = makeHtmlPath(fileDescription, page);
        return new FileOutputStream(filePath);
    }

    @Override
    public boolean htmlResourceExists(GroupDocsFileDescription fileDescription, Integer page, String resourceName) throws Exception {
        String filePath = makeResourcePath(fileDescription, page, resourceName);
        return new File(filePath).exists();
    }

    @Override
    public InputStream getHtmlResourceStream(GroupDocsFileDescription fileDescription, Integer page, String resourceName) throws Exception {
        String filePath = makeResourcePath(fileDescription, page, resourceName);
        return new FileInputStream(filePath);
    }

    @Override
    public OutputStream getHtmlResourceSaveStream(GroupDocsFileDescription fileDescription, Integer page, String resourceName) throws Exception {
        String filePath = makeResourcePath(fileDescription, page, resourceName);
        return new FileOutputStream(filePath);
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

    /**
     * Make html path.
     * @param fileDescription the file description
     * @param page the page
     * @return the string
     */
    protected String makeHtmlPath(GroupDocsFileDescription fileDescription, Integer page) {
        String guid = fileDescription.getGuid();
        String baseName = fileDescription.getBaseName();
        final String htmlPath = String.format(Locale.CANADA, "%s/%s/%s_%02d.html", cacheDirectory, guid, baseName, page);
        final File htmlFile = new File(htmlPath);
        if (!htmlFile.exists() && !htmlFile.getParentFile().exists() && !htmlFile.getParentFile().mkdirs()) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't create directory: " + htmlFile.getAbsolutePath());
        }
        return htmlPath;
    }

    /**
     * Make resource path.
     * @param fileDescription the file description
     * @param page the page
     * @param resourceName the resource name
     * @return the string
     */
    protected String makeResourcePath(GroupDocsFileDescription fileDescription, Integer page, String resourceName) {
        String guid = fileDescription.getGuid();
        String baseName = fileDescription.getBaseName();
        final String resourcePath = String.format(Locale.CANADA, "%s/%s/%s_%02d/%s", cacheDirectory, guid, baseName, page, resourceName);
        final File resourceFile = new File(resourcePath);
        if (!resourceFile.exists() && !resourceFile.getParentFile().exists() && !resourceFile.getParentFile().mkdirs()) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't create directory: " + resourceFile.getAbsolutePath());
        }
        return resourcePath;
    }

    /**
     * Make image path.
     * @param fileDescription the file description
     * @param page the page
     * @param width the width
     * @return the string
     */
    protected String makeImagePath(GroupDocsFileDescription fileDescription, Integer page, int width) {
        String guid = fileDescription.getGuid();
        String baseName = fileDescription.getBaseName();
        String extension = fileDescription.getFileType().name();
        final String htmlPath = String.format(Locale.CANADA, "%s/%s/%s_%02d_w%d.png", cacheDirectory, guid, baseName, page, width);
        final File htmlFile = new File(htmlPath);
        if (!htmlFile.exists() && !htmlFile.getParentFile().exists() && !htmlFile.getParentFile().mkdirs()) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't create directory: " + htmlFile.getAbsolutePath());
        }
        return htmlPath;
    }
}
