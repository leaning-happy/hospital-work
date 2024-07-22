package poiexcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import users.ReForm;

public class ExcelUtils {
/*	
                 创建新excel  
         *@param fileDir   excel的路径 
         *@param sheetName 要创建的表格索引 
         * @param titleRow  excel的第一行即表格头     */
    public static void createExcel(String fileDir, String sheetName, String titleRow[], String titleRow_[],List<ReForm> dataList) throws Exception {    
	//创建workbook    
	HSSFWorkbook workbook = new HSSFWorkbook();
	//添加Worksheet（不添加sheet时生成的xls文件打开时会报错)    
	HSSFSheet sheet = workbook.createSheet(sheetName);
	//新建文件    
	FileOutputStream out = null;    
	
		HSSFRow row=null;//行        
	    ReForm map =null;//List中的map
	    HSSFCell cell=null;//单元格
	//  字体加粗        
	CellStyle style = workbook.createCellStyle();
	HSSFFont font = workbook.createFont();
	//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
	font.setFontHeightInPoints((short)24);//字号
	style.setFont(font);
	
//	style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	CellStyle style1 =workbook.createCellStyle();
//	style1.setBorderTop(HSSFCellStyle.BORDER_HTIN);//上边框
//	style1.setBorderBottom(HSSFCellStyle. BORDER_THIN);//下边框
//	style1.setBorderLeft(HSSFCellStyle. BORDER_THIN);//左边框
//	style1.setBorderRight(HSSFCellStyle. BORDER_THIN);//右边框
//	style1.setTopBorderColor(HSSFColor.BLACK.index);//上边框颜色 
//	style1.setBottomBorderColor(HSSFColor.BLACK.index);//下边框颜色
//	style1.setLeftBorderColor(HSSFColor.BLACK.index);//左边框颜色
//	style1.setRightBorderColor(HSSFColor.BLACK.index);//右边框颜色
//	style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);//写入dataList值
	//标题
		
			row= sheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue("病人挂号信息");
			cell.setCellStyle(style);
			//表头
		
			row= sheet.createRow(1);
			for (short i = 0; i < titleRow.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(titleRow[i]);
				cell.setCellStyle(style1);
				}
			//副表头
		
			row= sheet.createRow(2);
			for (short i = 0; i < titleRow_.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(titleRow_[i]);
				cell.setCellStyle(style1);
				}
			//内容
		for (int a = 0; a < dataList.size(); a++) {
			map = dataList.get(a);
			
			String dn= map.getDname();
			
//					!= null ? map.getDname().toString() : "";
			String pn = map.getPname() ;
			String mo = map.getMoney() != null ? map.getMoney().toString() : "";
			String dp = map.getDeptname() ;
//					
			String sz[] ={String.valueOf(a+1),dn,pn,mo,dp};//从第a行开始创建
			
			row=sheet.createRow(a+3);
			
			for(int i =0;i<titleRow.length;i++){
				cell = row.createCell(i);
				
				cell.setCellValue(sz[i]);
				
				cell.setCellStyle(style1);
				
				}
			}//合并单元格
//		sheet.addMergedRegion(new CellRangeAddress(0 ,0, 0, 17)) ;
		
	out = new FileOutputStream(fileDir);
	workbook.write(out);
     out.close();
	
    
}
	
}	




