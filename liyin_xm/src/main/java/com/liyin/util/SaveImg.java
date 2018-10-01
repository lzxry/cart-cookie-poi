package com.liyin.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;


public class SaveImg {
	  /**
     * 保存文件，直接以multipartFile形式
     * @param multipartFile
     * @param path 文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveImg(MultipartFile multipartFile,String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = "/"+UUID.randomUUID() + ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
    /**
     * 删除文件
     * @param fileName绝对路径
     * @return
     */
    public static boolean deleteFile(String fileName){
        File file = new File(fileName);
        if(file.isFile() && file.exists()){
            Boolean succeedDelete = file.delete();
            if(succeedDelete){
                return true;
            }
            else{
                return true;
            }
        }else{
            return false;
        }
    }
    /**
     * 删除文件夹
     * @param dir文件夹绝对路径
     * @return
     */
    public static boolean deleteDirectory(String dir){
        //如果dir不以文件分隔符结尾，自动添加文件分隔符
        if(!dir.endsWith(File.separator)){
            dir = dir+File.separator;
        }
        File dirFile = new File(dir);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if(!dirFile.exists() || !dirFile.isDirectory()){
            System.out.println("删除目录失败"+dir+"目录不存在！");
            return false;
        }
        boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for(int i=0;i<files.length;i++){
            //删除子文件
            if(files[i].isFile()){
                flag = deleteFile(files[i].getAbsolutePath());
                if(!flag){
                    break;
                }
            }
            //删除子目录
            else{
                flag = deleteDirectory(files[i].getAbsolutePath());
                if(!flag){
                    break;
                }
            }
        }


        if(!flag){
            System.out.println("删除目录失败");
            return false;
        }


        //删除当前目录
        if(dirFile.delete()){
            System.out.println("删除目录"+dir+"成功！");
            return true;
        }else{
            System.out.println("删除目录"+dir+"失败！");
            return false;
        }
    }
}

