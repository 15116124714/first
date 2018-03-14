package com.offcn.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.offcn.model.Mobile;
import com.offcn.service.MobileService;

@Controller
public class MobileController {
	
	@Autowired
	private MobileService mobileService;
	
	@RequestMapping("ReadMobile")
//	@Test
	public void testReadMobile(@RequestParam("file") MultipartFile file,HttpServletRequest request,Model model)
	{
			//获取服务器端路径
			String path=request.getServletContext().getRealPath("upload");
			//获取到上传文件名称
			String fileName=file.getOriginalFilename();
			//创建File
			File targetFile=new File(path,fileName);
			//判断服务器端目录是否存在,如果不存在创建目录
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			//把上传的文件存储到服务器端
			try {
				file.transferTo(targetFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 try {
				Workbook workbook = WorkbookFactory.create(targetFile);
				int sheetnum= workbook.getNumberOfSheets();
				for(int i=0;i<sheetnum;i++)
				{
					Sheet sheet = workbook.getSheetAt(i);
					int rownum = sheet.getPhysicalNumberOfRows();
					for(int j=1;j<rownum;j++)
					{
						Row row = sheet.getRow(j);
						int cellnum = row.getPhysicalNumberOfCells();
						StringBuffer buf=new StringBuffer();
						for(int k=0;k<cellnum;k++)
						{
							Cell cell = row.getCell(k);
							
							if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
								buf.append(cell.getStringCellValue()+"_");
							}else if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
								buf.append(cell.getNumericCellValue()+"_");
							}else if(cell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
								buf.append(cell.getBooleanCellValue()+"_");
							}else if(cell.getCellType()==HSSFCell.CELL_TYPE_BLANK){
								buf.append(""+"_");
							}else{
								buf.append(cell.getDateCellValue()+"_");
							}
						}
						//单元格循环完成后读取到的是一行内容
						String hang=buf.toString();
						String[] rows=hang.split("_");
						Mobile mobile = new Mobile();
						
						mobile.setId(rows[0]);
						mobile.setMobileNumber(rows[1]);
						mobile.setMobileArea(rows[2]);
						mobile.setMobileType(rows[3]);
						mobile.setAreaCode(rows[4]);
						mobile.setPostCode(rows[5]);
						
						mobileService.saveMobile(mobile);
					}
				}
		 }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	/*@Test
	public void testRead()
	{
		 try {
			Workbook workbook = WorkbookFactory.create(new File("d:\\chart\\1.xlsx"));
			int sheetnum= workbook.getNumberOfSheets();
			for(int i=0;i<sheetnum;i++)
			{
				Sheet sheet = workbook.getSheetAt(i);
				int rownum = sheet.getPhysicalNumberOfRows();
				for(int j=0;j<rownum;j++)
				{
					Row row = sheet.getRow(j);
					int cellnum = row.getPhysicalNumberOfCells();
					for(int k=0;k<cellnum;k++)
					{
						Cell cell = row.getCell(k);
						if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
							System.out.print(cell.getStringCellValue()+"\t");
						}else if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
							System.out.print(cell.getNumericCellValue()+"\t");
						}else if(cell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
							System.out.println(cell.getBooleanCellValue()+"\t");
						}else if(cell.getCellType()==HSSFCell.CELL_TYPE_BLANK){
							System.out.print("NULL"+"\t");
						}else{
							System.out.print(cell.getDateCellValue()+"\t");
						}
					}
					System.out.println();
				}
			}
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
