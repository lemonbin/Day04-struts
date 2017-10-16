package com.lanou.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by dllo on 2017/10/13.
 */
public class MyDownloadAction extends ActionSupport {
    // 提供一个输入流对象, 作为一个动作方法的返回结果
    private InputStream inputStream;
    private String fileName;//要下载的名称

    /**
     * 文件下载
     *
     * @return
     */
    public String download() {
        // 获得下载路径
        String dirPath = ServletActionContext.getServletContext().getRealPath("files");

//        fileName = "4ec2d5628535e5dd05f20f5171c6a7efcf1b6266.jpg";//初始化文件名称
        File file = new File(dirPath, fileName);
        try {
            /* 构建输入流对象 */
            inputStream = new FileInputStream(file);

            /* 将文件名称中包含中文的部分进行浏览器的兼容处理, 放在inputStream赋值之后, 动作方法返回之前*/
            fileName = filenameEncoding(fileName,
                    ServletActionContext.getRequest(),
                    ServletActionContext.getResponse());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String filenameEncoding(String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String agent = request.getHeader("User-Agent"); //         System.out.println(agent);
        if (agent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else if (agent.contains("MSIE")) {
            filename = URLEncoder.encode(filename, "utf-8");
        } else if (agent.contains("Safari")) {
            filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");
        } else {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
