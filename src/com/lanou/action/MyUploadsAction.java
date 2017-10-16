package com.lanou.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

/**
 * Created by dllo on 2017/10/13.
 */
public class MyUploadsAction extends ActionSupport {
    private File[] photos;
    private String[] photosFileName;
    private String[] photosContentType;

    public String moreUpload() {
        // 获取当前项目下的files路径
        String path = ServletActionContext.getServletContext().getRealPath("files");
        System.out.println("文件路径" + path);
        File deskFile = new File(path);

        // 如果目的文件不存在, 需要创建一下files
        if (!deskFile.exists() || !deskFile.isDirectory()) {
            deskFile.mkdirs();
        }

        for (int i = 0; i < photos.length; i++) {
            File file = new File(deskFile, photosFileName[i]);
            try {
                FileUtils.copyFile(photos[i],file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return SUCCESS;
    }

    public File[] getPhotos() {
        return photos;
    }

    public void setPhotos(File[] photos) {
        this.photos = photos;
    }

    public String[] getPhotosFileName() {
        return photosFileName;
    }

    public void setPhotosFileName(String[] photosFileName) {
        this.photosFileName = photosFileName;
    }

    public String[] getPhotosContentType() {
        return photosContentType;
    }

    public void setPhotosContentType(String[] photosContentType) {
        this.photosContentType = photosContentType;
    }
}
