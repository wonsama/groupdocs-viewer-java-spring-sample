<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>GroupDocs.Viewer for Java Spring Sample</title>
        ${groupdocsHeader}
    </head> 
    <body>
        <h1>GroupDocs.Viewer for Java Sample</h1>
        <div>
            <form enctype="multipart/form-data" method="POST" id="uploadForm" action="UploadFile">
                <input type="file" id="fileUpload" name="fileName"/>
                <input type="submit" id="submitUpload" value="Upload"/>
            </form>
        </div>
        <div id="test"></div>
        ${viewerScript}
    </body>
</html>
