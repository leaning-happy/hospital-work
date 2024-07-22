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
                 ������excel  
         *@param fileDir   excel��·�� 
         *@param sheetName Ҫ�����ı������ 
         * @param titleRow  excel�ĵ�һ�м����ͷ     */
    public static void createExcel(String fileDir, String sheetName, String titleRow[], String titleRow_[],List<ReForm> dataList) throws Exception {    
	//����workbook    
	HSSFWorkbook workbook = new HSSFWorkbook();
	//���Worksheet�������sheetʱ���ɵ�xls�ļ���ʱ�ᱨ��)    
	HSSFSheet sheet = workbook.createSheet(sheetName);
	//�½��ļ�    
	FileOutputStream out = null;    
	
		HSSFRow row=null;//��        
	    ReForm map =null;//List�е�map
	    HSSFCell cell=null;//��Ԫ��
	//  ����Ӵ�        
	CellStyle style = workbook.createCellStyle();
	HSSFFont font = workbook.createFont();
	//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//������ʾ
	font.setFontHeightInPoints((short)24);//�ֺ�
	style.setFont(font);
	
//	style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	CellStyle style1 =workbook.createCellStyle();
//	style1.setBorderTop(HSSFCellStyle.BORDER_HTIN);//�ϱ߿�
//	style1.setBorderBottom(HSSFCellStyle. BORDER_THIN);//�±߿�
//	style1.setBorderLeft(HSSFCellStyle. BORDER_THIN);//��߿�
//	style1.setBorderRight(HSSFCellStyle. BORDER_THIN);//�ұ߿�
//	style1.setTopBorderColor(HSSFColor.BLACK.index);//�ϱ߿���ɫ 
//	style1.setBottomBorderColor(HSSFColor.BLACK.index);//�±߿���ɫ
//	style1.setLeftBorderColor(HSSFColor.BLACK.index);//��߿���ɫ
//	style1.setRightBorderColor(HSSFColor.BLACK.index);//�ұ߿���ɫ
//	style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);//д��dataListֵ
	//����
		
			row= sheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue("���˹Һ���Ϣ");
			cell.setCellStyle(style);
			//��ͷ
		
			row= sheet.createRow(1);
			for (short i = 0; i < titleRow.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(titleRow[i]);
				cell.setCellStyle(style1);
				}
			//����ͷ
		
			row= sheet.createRow(2);
			for (short i = 0; i < titleRow_.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(titleRow_[i]);
				cell.setCellStyle(style1);
				}
			//����
		for (int a = 0; a < dataList.size(); a++) {
			map = dataList.get(a);
			
			String dn= map.getDname();
			
//					!= null ? map.getDname().toString() : "";
			String pn = map.getPname() ;
			String mo = map.getMoney() != null ? map.getMoney().toString() : "";
			String dp = map.getDeptname() ;
//					
			String sz[] ={String.valueOf(a+1),dn,pn,mo,dp};//�ӵ�a�п�ʼ����
			
			row=sheet.createRow(a+3);
			
			for(int i =0;i<titleRow.length;i++){
				cell = row.createCell(i);
				
				cell.setCellValue(sz[i]);
				
				cell.setCellStyle(style1);
				
				}
			}//�ϲ���Ԫ��
//		sheet.addMergedRegion(new CellRangeAddress(0 ,0, 0, 17)) ;
		
	out = new FileOutputStream(fileDir);
	workbook.write(out);
     out.close();
	
    
}
	
}	




