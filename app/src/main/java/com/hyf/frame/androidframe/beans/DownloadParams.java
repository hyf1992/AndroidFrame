package com.hyf.frame.androidframe.beans;


public class DownloadParams {
    private String downloadPath;
    private String fileName;
    private String downloadUrl;

    public DownloadParams() {
        this(new Builder());
    }

    DownloadParams(Builder builder) {
        this.downloadPath = builder.downloadPath;
        this.fileName = builder.fileName;
        this.downloadUrl = builder.downloadUrl;
    }

    public static final class Builder {
        String downloadPath;
        String fileName;
        String downloadUrl;

        public void setDownloadPath(String downloadPath) {
            this.downloadPath = downloadPath;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public DownloadParams build() {
            return new DownloadParams(this);
        }
    }
}
