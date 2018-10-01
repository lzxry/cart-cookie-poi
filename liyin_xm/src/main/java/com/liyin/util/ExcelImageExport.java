package com.liyin.util;  
  
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.PictureData;
  
public class ExcelImageExport {  
	public static void main(String[] args) {
		
	}
	/** 
     * 获取Excel2003图片 
     *  
     * @param sheetNum 
     *            当前sheet编号 
     * @param sheet 
     *            当前sheet对象 
     * @param workbook 
     *            工作簿对象 
     * @return Map key:图片单元格索引（sheet(id)_[row1,col1]_[row2,col2]）String，value:图片流PictureData 
     * @throws IOException 
     */  
    public static Map<String, PictureData> getSheetPictrues03(int sheetNum,  
            HSSFSheet sheet, HSSFWorkbook workbook) {
        Map<String, PictureData> sheetIndexPicMap = new HashMap<String, PictureData>();  
        List<HSSFPictureData> pictures = workbook.getAllPictures();  
        if (pictures.size() != 0) {
            HSSFPatriarch hssPatriarch = sheet.getDrawingPatriarch();
            HSSFRow row = sheet.getRow(0);
            HSSFCell cell = row.getCell(0);
            //cell.getcell
            if (hssPatriarch !=null ) {
                for (HSSFShape shape : hssPatriarch.getChildren()) {  
                    HSSFClientAnchor anchor = (HSSFClientAnchor) shape  
                            .getAnchor();  
                    if (shape instanceof HSSFPicture) {  
                        HSSFPicture pic = (HSSFPicture) shape;  
                        int pictureIndex = pic.getPictureIndex() - 1;  
                        HSSFPictureData picData = pictures.get(pictureIndex);  
                        //行列下标都是从0开始的,  
                        //这里行数加+1,第一张图片信息行数不准确，测试下就知道了  
                        String picIndex = "sheet" + String.valueOf(sheetNum)  
                                + "_[" + String.valueOf(anchor.getRow1()+1)+"," + String.valueOf(anchor.getCol1())  
                                + "]_["+ String.valueOf(anchor.getRow2()+1)+"," + String.valueOf(anchor.getCol2())+"]";  
                        sheetIndexPicMap.put(picIndex, picData);  
                    }  
                }  
            }  
            return sheetIndexPicMap;  
        } else {  
            return null;  
        }  
    }  
  /**
   * 图片导出Excel
   * @param args
   */
    public static void main1(String[] args) {  
         FileOutputStream fileOut = null;     
         BufferedImage bufferImg = null;     
        try {  
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();  
          //加载图片  
            bufferImg = ImageIO.read(new File("F:/img/QQ截图20180512134630.png"));     
            ImageIO.write(bufferImg, "png", byteArrayOut);  
            HSSFWorkbook wb = new HSSFWorkbook();     
            HSSFSheet sheet1 = wb.createSheet("sheet1");    
            HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();     
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 7, 7, (short) 8, 8);  
            //插入图片 1   
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));  
              
            //图片2  
            anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 2, 9, (short) 5, 15);  
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));  
            fileOut = new FileOutputStream("C:\\Users\\LiYing\\Desktop/商品清单.xls");     
            // 输出文件   
             wb.write(fileOut);     
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
             // 关于HSSFClientAnchor(dx1,dy1,dx2,dy2,col1,row1,col2,row2)的参数，有必要在这里说明一下：
             // dx1：起始单元格的x偏移量，
             // dy1：起始单元格的y偏移量，
             // dx2：终止单元格的x偏移量，
             // dy2：终止单元格的y偏移量，
             // col1：起始单元格列序号，从0开始计算；
             // row1：起始单元格行序号，从0开始计算，
             // col2：终止单元格列序号，从0开始计算；
             // row2：终止单元格行序号，从0开始计算，
             //添加多个图片时:多个pic应该share同一个DrawingPatriarch在同一个sheet里面。
    }  
}  