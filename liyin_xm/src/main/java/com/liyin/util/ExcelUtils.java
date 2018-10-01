package com.liyin.util;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;




/**
 * poi操作excel
 * @author Administrator
 */
public class ExcelUtils {
	public static void main(String[] args) throws Exception {
//		List<User> list = new ArrayList<User>();
//		for (int i=0;i<10;i++) {
//			User us = new User();
//			us.setName("张三"+i);
//			us.setPhone(i+"11111111111");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			us.setCreate_time(sdf.format(new Date()));
//			us.setEmail(i+"wawerer@123123.com");
//			list.add(us);
//		}
		String columnNames[] = {"姓名","电话","时间","邮箱"};
		String columns[] = {"name","phone","create_time","email"};
//		exportExcelByList("D:\\wang.xls", list, columnNames, columns, "用户信息");
	}
	/**
	 * 读取excel
	 * @param filepath 文件路径
	 * @param startrow 读取的开始行
	 * @Result 返回一个二维数组（第一维放的是行，第二维放的是列表）
	 * @throws Exception
	 */
	public static String[][] readexcell(MultipartFile file,int startrow) throws Exception{
		//获取sheet
        Sheet sheet = getSheet(file);
		// 得到总行数
		int rowNum = sheet.getLastRowNum()+1;
		// 根据第一行获取列数
		Row row = sheet.getRow(0);
		//获取总列数
		int colNum = row.getPhysicalNumberOfCells();
		//根据行列创建二维数组
		String[][] content = new String[rowNum-startrow][colNum];
		String[] cols = null;
		//通过循环，给二维数组赋值
		for (int i = startrow; i < rowNum; i++) {
			row = sheet.getRow(i);
			cols = new String[colNum];
			for (int j = 0; j < colNum; j++) {
				//获取每个单元格的值
				cols[j] = getCellValue(row.getCell(j));
				//把单元格的值存入二维数组
				content[i - startrow][j] =cols[j];
			}
		}
		return content;
	}
	

	/**
	 * 读取excel
	 * @param filepath 文件路径
	 * @param startrow 读取的开始行
	 * @Result 返回一个Map
	 * @throws Exception
	 */
	public static Map<Integer,List<String>> readexcellReturnMap(MultipartFile file,int startrow) throws Exception{
		//获取sheet
        Sheet sheet = getSheet(file);
		// 得到总行数
		int rowNum = sheet.getLastRowNum()+1;
		// 根据第一行获取列数
		Row row = sheet.getRow(0);
		//获取总列数
		int colNum = row.getPhysicalNumberOfCells();
		//根据行列创建二维数组
		Map<Integer, List<String>> content = new HashMap<Integer,List<String>>();
		List<String> cols = null;
		//String[][] content = new String[rowNum-startrow][colNum];
		//String[] cols = null;
		//通过循环，给map赋值
		for (int i = startrow; i < rowNum; i++) {
			row = sheet.getRow(i);
			//cols = new String[colNum];
			cols=new ArrayList<String>();
			for (int j = 0; j < colNum; j++) {
				//获取每个单元格的值
				cols.add(getCellValue(row.getCell(j)));
				//cols[j] = getCellValue(row.getCell(j));
				//把单元格的值存入二维数组
				//content[i - startrow][j] =cols[j];
			}
			content.put(i, cols);
		}
		return content;
	}
	/**
	 * 根据表名获取第一个sheet
	 * @param path d:\\1213.xml
	 * @return 2003-HSSFWorkbook  2007-XSSFWorkbook
	 * @throws Exception 
	 */
	public static Sheet getSheet(MultipartFile file) throws Exception {
		//文件后缀
		String filename =file.getOriginalFilename();
		String extension = filename.lastIndexOf(".") == -1 ? "" : filename.substring(filename.lastIndexOf("."));
		//创建输入流
		InputStream is = file.getInputStream();
		if (".xls".equals(extension)) {//2003
			//获取工作薄
			POIFSFileSystem fs = new POIFSFileSystem(is);
			return new HSSFWorkbook(fs).getSheetAt(0);
		} else if (".xlsx".equals(extension) || ".xlsm".equals(extension)) {
			return new XSSFWorkbook(is).getSheetAt(0);
		} else {
			throw new IOException("文件（" + file + "）,无法识别！");
		}
	}
	/**
	 * 导入读取excel数据
	 * @return
	 */
	public static List<Map<String,Object>> readexcell(){
		return null;
	}
	  /**
     * 功能:获取单元格的值
     */
    private static String getCellValue(Cell cell) {
        Object result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                result = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
             // 在excel里,日期也是数字,在此要进行判断 
				if(HSSFDateUtil.isCellDateFormatted(cell)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					 Date date = cell.getDateCellValue();  
					 result =  sdf.format(date); 
				}else{
					DecimalFormat df=new DecimalFormat("#"); 
					result=df.format(cell.getNumericCellValue());
				}
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                result = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_FORMULA:
                result = cell.getCellFormula();
                break;
            case Cell.CELL_TYPE_ERROR:
                result = cell.getErrorCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                break;
            default:
                break;
            }
        }
        return result.toString();
    }
    /**
     * 导出
     * 根据传入List数据集合导出Excel表格 生成本地excel
     * @param file （输出流路径）d:\\123.xml
     * @param list 任何对象类型的list（数据库直接查询出的）User（id，name，age，sex)
     * @param columnNames（表头名称）(姓名、性别、年龄)
     * @param columns （表头对应的列名）（name,sex,age）注意顺序
     * @param sheetName（sheet名称）
     */
 	@SuppressWarnings("rawtypes")
 	public static void exportExcelByList(String file, List list,String[] columnNames, String[] columns, String sheetName) {
 		OutputStream fos  =null;
 		try {
			//获取输出流
 			fos= new FileOutputStream(file);
			//创建工作薄HSSFWorkbook
 			HSSFWorkbook wb = new HSSFWorkbook();
			//创建表单sheet
 			HSSFSheet sheet = wb.createSheet(sheetName);
			//创建样式对象
 			HSSFCellStyle style = wb.createCellStyle(); // 样式对象
 			//style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
 			//style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平

			//创建行--表头
 			HSSFRow row = sheet.createRow(0);
 			for (int i = 0; i < columnNames.length; i++) {
				//创建列、单元格
 				HSSFCell cell = row.createCell(i);
 				cell.setCellValue(columnNames[i]);
 				cell.setCellStyle(style);
 			}
			//创建数据列
 			for (int i = 0; i < list.size(); i++) {
 				Object o = list.get(i);
				//创建行--数据
 				HSSFRow listRow = sheet.createRow(i + 1);
				//循环列字段数组
 				for (int j = 0; j < columns.length; j++) {
					//创建列
 					HSSFCell listCell = listRow.createCell(j);
 					//根据反射调用方法
 					Method m = o.getClass().getMethod("get" + upperStr(columns[j]));
 					String value = (String) m.invoke(o);
 					if (value != null) {
 						listCell.setCellValue(value);
 						listCell.setCellStyle(style);
 					} else {
 						listCell.setCellValue("");
 						listCell.setCellStyle(style);
 					}
 					sheet.autoSizeColumn(j+1, true);//自适应，从1开始
 				}
 			}
			//把工作薄写入到输出流
 			wb.write(fos);
 			System.out.println("生成excel成功："+file);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}finally {
 			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 	}

 	/**
 	 * 根据传入List数据集合导出Excel表格 返回页面选择保存路径的excel
 	 * @param response （响应页面）
 	 * @param list 数据列表
 	 * @param columnNames 表头
 	 * @param columns 对应列名
 	 * @param sheetName 
 	 * @param filename
 	 */
 	@SuppressWarnings("rawtypes")
 	public static void exportExcel(HttpServletResponse response,List list, String[] columnNames, String[] columns,String sheetName, String filename) {
 		OutputStream fos = null;
 		try {
			//响应输出流，让用户自己选择保存路径
 			response.setCharacterEncoding("UTF-8");
 			response.reset();//清除缓存
 			response.setContentType("octets/stream");
 			response.addHeader("Content-Disposition", "attachment;filename="+ new String((filename).getBytes("UTF-8"), "iso8859-1")+ ".xls");
 			fos = response.getOutputStream();

 			HSSFWorkbook wb = new HSSFWorkbook();
 			HSSFSheet sheet = wb.createSheet(sheetName);
 			HSSFCellStyle style = wb.createCellStyle(); // 样式对象
 			//style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
 			//style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平

 			HSSFRow row = sheet.createRow(0);
 			for (int i = 0; i < columnNames.length; i++) {
 				HSSFCell cell = row.createCell(i);
 				cell.setCellValue(columnNames[i]);
 				cell.setCellStyle(style);
 			}
 			for (int i = 0; i < list.size(); i++) {
 				HSSFRow listRow = sheet.createRow(i + 1);
 				Object o = list.get(i);
 				for (int j = 0; j < columns.length; j++) {
 					HSSFCell listCell = listRow.createCell(j);
 					Method m = o.getClass().getMethod("get" + upperStr(columns[j]));
 					String value = (String) m.invoke(o);
 					if (value != null) {
 						listCell.setCellValue(value + "");
 						listCell.setCellStyle(style);
 					} else {
 						listCell.setCellValue("");
 						listCell.setCellStyle(style);
 					}
 					sheet.autoSizeColumn(j+1, true);//自适应，从1开始
 				}
 			}
 			wb.write(fos);
 		} catch (Exception e) {
 			e.printStackTrace();
 		} finally {
 			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 	}
 	/**
 	 * ##############图片+数据导出######
 	 * @param imgpath图片所在文件夹
 	 * @param response （响应页面）
 	 * @param list 数据列表
 	 * @param columnNames 表头
 	 * @param columns 对应列名
 	 * @param sheetName 
 	 * @param filename
 	 */
 	@SuppressWarnings("rawtypes")
 	public static void exportImageExcel(HttpServletResponse response,List list, String[] columnNames, String[] columns,String sheetName, String filename,String imgpath) {
 		OutputStream fos = null;
 		 BufferedImage bufferImg = null;  
 		try {
 			//响应输出流，让用户自己选择保存路径
 			response.setCharacterEncoding("UTF-8");
 			response.reset();//清除缓存
 			response.setContentType("octets/stream");
 			response.addHeader("Content-Disposition", "attachment;filename="+ new String((filename).getBytes("UTF-8"), "iso8859-1")+ ".xls");
 			fos = response.getOutputStream();
 			
 			HSSFWorkbook wb = new HSSFWorkbook();
 			HSSFSheet sheet = wb.createSheet(sheetName);
 			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();     
             
 			HSSFCellStyle style = wb.createCellStyle(); // 样式对象
 			//style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
 			//style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
 			
 			HSSFRow row = sheet.createRow(0);
 			for (int i = 0; i < columnNames.length; i++) {
 				HSSFCell cell = row.createCell(i);
 				cell.setCellValue(columnNames[i]);
 				cell.setCellStyle(style);
 			}
 			for (int i = 0; i < list.size(); i++) {
 				HSSFRow listRow = sheet.createRow(i + 1);
 				Object o = list.get(i);
 				for (int j = 0; j < columns.length; j++) {
 					HSSFCell listCell = listRow.createCell(j);
 					Method m = o.getClass().getMethod("get" + upperStr(columns[j]));
 					String value = (String) m.invoke(o);
 					value = value.trim();
 					if (value != null) {
 						//最后一个单元写入图片
 						if(j==columns.length-1) {
 					          //加载图片  	
 								File file = new File(imgpath+value);
 								if(file.exists()&&value!="") {
 									bufferImg = ImageIO.read(file);
 								}else {
 									bufferImg = ImageIO.read(new File(imgpath+"/img_read_error.png")); 
 								}
 							ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(); 
 							ImageIO.write(bufferImg, "png", byteArrayOut);
 							HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) j, (i+1), (short) (j+1), i+2);  
 							patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));  
 						}else {
 							listCell.setCellValue(value + "");
 							listCell.setCellStyle(style);
 						}
 					} else {
 						listCell.setCellValue("");
 						listCell.setCellStyle(style);
 					}
 					sheet.autoSizeColumn(j+1, true);//自适应，从1开始
 				}
 			}
 			wb.write(fos);
 		} catch (Exception e) {
 			e.printStackTrace();
 		} finally {
 			try {
 				//org.apache.catalina.connector.ClientAbortException: java.io.IOException: 远程主机强迫关闭了一个现有的连接。
 				//解决办法https://www.oschina.net/question/2546873_2210868
 				//springboot可以通过yml配置超时时间
 				fos.close();
 			} catch (IOException e) {
 				//e.printStackTrace();
 				System.out.println("远程主机强迫关闭了一个现有的连接。");
 			}
 		}
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
 	/**
 	 * 把输入字符串的首字母改成大写
 	 * 
 	 * @param str
 	 * @return
 	 */
 	private static String upperStr(String str) {
 		char[] ch = str.toCharArray();
 		if (ch[0] >= 'a' && ch[0] <= 'z') {
 			ch[0] = (char) (ch[0] - 32);
 		}
 		return new String(ch);
 	}
 	/**
 	 * 大数据导出
 	 * @param response
 	 * @param list
 	 * @param columnNames
 	 * @param columns
 	 * @param sheetName
 	 * @param filename
 	 */
 	public static void exportBigData(HttpServletResponse response,List list, String[] columnNames, String[] columns,String sheetName, String filename){

		OutputStream os = null;
		try {
			response.setContentType("application/force-download"); // 设置下载类型
			response.setHeader("Content-Disposition","attachment;filename=" + filename); // 设置文件的名称
			os = response.getOutputStream(); // 输出流
			SXSSFWorkbook wb = new SXSSFWorkbook(1000);//内存中保留 1000 条数据，以免内存溢出，其余写入 硬盘
	        //获得该工作区的第一个sheet   
			Sheet sheet1 = wb.createSheet(sheetName); 
	        int excelRow = 0;
	        //标题行
	        Row titleRow = (Row) sheet1.createRow(excelRow++);
			for (int i = 0; i < columns.length; i++) {
				Cell cell = titleRow.createCell(i);  
                cell.setCellValue(columns[i]);
			}
			
			if (list!= null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					//明细行
			        Row contentRow = (Row) sheet1.createRow(excelRow++);
					List<String> reParam = (List<String>) list.get(i);
					for (int j = 0; j < reParam.size(); j++) {
						Cell cell = contentRow.createCell(j);  
		                cell.setCellValue(reParam.get(j));
					}
				}
			}
			wb.write(os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} // 关闭输出流
		}
 	}

}
