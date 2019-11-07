package com.rimi.esports.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

/**
 * @author shangzf
 * @date 2019/10/30 14:42
 */
public class FastDfsUtils {

    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageClient1 storageClient1;

    static {
        try{
            ClientGlobal.initByProperties("config/db/fastdfs-client.properties");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient1 = new StorageClient1(trackerServer, null);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     *
     * @param fileBytes 文件的字节数组
     * @param suffix    文件的后缀
     * @return
     */
    public static String upload(byte[] fileBytes, String suffix) {
        try {
            return storageClient1.upload_file1(fileBytes, suffix, null);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String uploadLocalFile(String file, String suffix) {
        // 文件上传
        try {
            return storageClient1.upload_file1(file, suffix, null);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
