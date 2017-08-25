package com.example.administrator.databasesave;

import android.content.Context;
import android.net.Uri;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 *
 *   author   :   Alex
 *   e_mail   :   18238818283@sina.cn
 *   timr     :   2017/08/14
 *   desc     :
 *   version  :   V 1.0.5
 */
public class DBFile {

    private Context mContext;

    public DBFile(Context mContext) {
        this.mContext = mContext;
    }

   public File createFileDirInFileDir(String fileName){

       File fileDir = mContext.getFilesDir();

       File file =  new File(fileDir,fileName);
       if (!file.exists()){
           try {
               file.createNewFile();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

      return file;
   }

    public File creatCacshFileDirInCrashFile(String fileName){

        File fileDir = mContext.getCacheDir();
        File file =  new File(fileDir,fileName);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public File creatCrashFile(String url){
        String fileName = Uri.parse(url).getLastPathSegment();
        L.e(fileName);
        File file;
        try {
            file = File.createTempFile(fileName,null,mContext.getCacheDir());
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }




}
