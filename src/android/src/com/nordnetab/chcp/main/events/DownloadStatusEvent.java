package com.nordnetab.chcp.main.events;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by xuqiang on 2016/12/7.
 */

public class DownloadStatusEvent {
    public static final String START = "START";
    public static final String DOWNLOADING = "downloading";
    public static final String COMPLETED = "completed";
    public static final String ERROR = "error";
    public static final String INSTALL = "install";
    public String status;
    public float progress = 0;
    public DownloadStatusEvent(String status){
        this(status,0);
    }
    public DownloadStatusEvent(String status, float progress){
        this.status = status;
        this.progress = progress;
    }


    public static void sendError(){
        EventBus.getDefault().post(new DownloadStatusEvent(DownloadStatusEvent.ERROR));
    }

    public static void sendStart(){
        EventBus.getDefault().post(new DownloadStatusEvent(DownloadStatusEvent.START));
    }

    public static void sendComplete(){
        EventBus.getDefault().post(new DownloadStatusEvent(DownloadStatusEvent.COMPLETED));
    }

    public static void sendProgress(float progress){
        EventBus.getDefault().post(new DownloadStatusEvent(DownloadStatusEvent.DOWNLOADING,progress));
    }

    public static void sendInstall(){
        EventBus.getDefault().post(new DownloadStatusEvent(DownloadStatusEvent.INSTALL));
    }

}
