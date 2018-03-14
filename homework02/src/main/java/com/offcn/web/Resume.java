package com.offcn.web;

import java.io.FileNotFoundException;

import javax.swing.GroupLayout.Alignment;

import org.junit.Test;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class Resume {

	@Test
	public void testResume() throws Exception
	{
		PdfWriter write = new PdfWriter("d:\\chart\\简历.pdf");
		PdfDocument pdfDoc = new PdfDocument(write);
		Document doc = new Document(pdfDoc);
		
		PdfFont font = PdfFontFactory.createFont("STSongStd-Light","UniGB-UCS2-H",false);
		
		Table table = new Table(new float[]{100,200,100,200,150});
		table.setWidthPercent(100f);
		Cell c1 = new Cell(1,5);
		c1.setBackgroundColor(Color.CYAN);
		c1.add(new Paragraph("基本情况").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		table.addCell(c1);
		String name[] = {"姓名","性别","民族","出身年月","政治面貌","健康情况","籍贯","学历","电子信箱","联系电话","专业","毕业院校","求职意向"};
		
		for(int i=0;i<name.length;i++)
		{
			if(i == 2)
			{
				Cell c4 = new Cell(7,1);
				c4.add(new Image(ImageDataFactory.create("d:\\chart\\1.png")));
				Cell c2 = new Cell(1,1);
				c2.add(new Paragraph(name[i]).setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
				Cell c3 = new Cell(1,1);
				
				table.addCell(c4);
				table.addCell(c2);
				table.addCell(c3);
				
			}
			else if(i==10 || i==11)
			{
				
				Cell c2 = new Cell(1,1);
				c2.add(new Paragraph(name[i]).setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
				Cell c3 = new Cell(1,3);
				table.addCell(c2);
				table.addCell(c3);
			}
			else if(i==12)
			{
				Cell c2 = new Cell(1,1);
				c2.add(new Paragraph(name[i]).setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
				Cell c3 = new Cell(1,4);
				table.addCell(c2);
				table.addCell(c3);
			}
			else
			{
				Cell c2 = new Cell(1,1);
				c2.add(new Paragraph(name[i]).setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
				Cell c3 = new Cell(1,1);
				table.addCell(c2);
				table.addCell(c3);
			}
			
		}
		

		Table table1 = new Table(new float[]{150,150,150,150});
		table1.setWidthPercent(100f);
		Cell c2 = new Cell(1,4);
		c2.setBackgroundColor(Color.CYAN);
		c2.setBorderTop(null);
		c2.add(new Paragraph("教育情况").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		table1.addCell(c2);
		String[] s = {"时间","院校名称","专业","学历"};
		for(int i=0;i<s.length;i++){
			Cell c3 = new Cell(1,1);
			c3.add(new Paragraph(s[i]).setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
			table1.addCell(c3);
		}
		for(int i=0;i<8;i++){
			Cell c3 = new Cell(1,1);
			c3.setHeight(20);
			table1.addCell(c3);
		}
		
		Cell c4 = new Cell(1,4);
		c4.setBackgroundColor(Color.CYAN);
		c4.add(new Paragraph("培训经历").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		table1.addCell(c4);
		
		String[] s1 = {"时间","培训机构","课程","证书"};
		for(int i=0;i<s1.length;i++){
			Cell c3 = new Cell(1,1);
			c3.add(new Paragraph(s1[i]).setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
			table1.addCell(c3);
		}
		for(int i=0;i<8;i++){
			Cell c3 = new Cell(1,1);
			c3.setHeight(20);
			table1.addCell(c3);
		}
		
		Cell c5 = new Cell(1,4);
		c5.setBackgroundColor(Color.CYAN);
		c5.add(new Paragraph("技能特长").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		table1.addCell(c5);
		Cell c6 = new Cell(2,4);
		c6.setHeight(40);
		table1.addCell(c6);
		
		Cell c7 = new Cell(1,4);
		c7.setBackgroundColor(Color.CYAN);
		c7.add(new Paragraph("工作经验").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		table1.addCell(c7);
		
		String[] s2 = {"时间","公司名称","职位","工作内容"};
		Cell c8 = new Cell(1,1);
		c8.setWidth(100);
		c8.add(new Paragraph("时间").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c9 = new Cell(1,1);
		c9.setWidth(200);
		c9.add(new Paragraph("公司名称").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c10 = new Cell(1,1);
		c10.setWidth(80);
		c10.add(new Paragraph("职位").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c11 = new Cell(1,1);
		c11.setWidth(300);
		c11.add(new Paragraph("工作内容").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		table1.addCell(c8);
		table1.addCell(c9);
		table1.addCell(c10);
		table1.addCell(c11);
		
		for(int i=0;i<4;i++){
			Cell c3 = new Cell(1,1);
			c3.setHeight(20);
			table1.addCell(c3);
		}
		
		Cell c12 = new Cell(1,4);
		c12.setBackgroundColor(Color.CYAN);
		c12.add(new Paragraph("英文、计算机水平").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		table1.addCell(c12);
		Cell c13 = new Cell(2,4);
		c13.setHeight(40);
		table1.addCell(c13);
		
		Cell c14 = new Cell(1,4);
		c14.setBackgroundColor(Color.CYAN);
		c14.add(new Paragraph("奖励荣誉").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		table1.addCell(c14);
		Cell c15 = new Cell(1,4);
		c15.setHeight(30);
		table1.addCell(c15);
		
		Cell c16 = new Cell(1,4);
		c16.setBackgroundColor(Color.CYAN);
		c16.add(new Paragraph("自我评价").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		table1.addCell(c16);
		Cell c17 = new Cell(1,4);
		c17.setHeight(30);
		table1.addCell(c17);
		
		doc.add(table);
		doc.add(table1);
		
		doc.close();
		pdfDoc.close();
		
		/*Cell c2 = new Cell(1,1);
		c2.add(new Paragraph("姓名").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c3 = new Cell(1,1);
		Cell c4 = new Cell(1,1);
		c4.add(new Paragraph("性别").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c5 = new Cell(1,1);
		Cell c6 = new Cell(7,1);
		c6.add(new Image(ImageDataFactory.create("d:\\chart\\1.png")));
		Cell c7 = new Cell(1,1);
		c7.add(new Paragraph("民族").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c8 = new Cell(1,1);
		Cell c9 = new Cell(1,1);
		c9.add(new Paragraph("出身年月").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c10 = new Cell(1,1);
		Cell c11 = new Cell(1,1);
		c11.add(new Paragraph("政治面貌").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c12 = new Cell(1,1);
		Cell c13 = new Cell(1,1);
		c13.add(new Paragraph("健康情况").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c14 = new Cell(1,1);
		Cell c15 = new Cell(1,1);
		c15.add(new Paragraph("籍贯").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c16 = new Cell(1,1);
		Cell c17 = new Cell(1,1);
		c17.add(new Paragraph("学历").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c18 = new Cell(1,1);
		Cell c19 = new Cell(1,1);
		c19.add(new Paragraph("电子信箱").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c20 = new Cell(1,1);
		Cell c21 = new Cell(1,1);
		c21.add(new Paragraph("联系电话").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c22 = new Cell(1,1);
		Cell c23 = new Cell(1,1);
		c23.add(new Paragraph("专业").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c24 = new Cell(1,3);
		Cell c25 = new Cell(1,1);
		c25.add(new Paragraph("毕业院校").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c26 = new Cell(1,3);
		Cell c27 = new Cell(1,1);
		c27.add(new Paragraph("求职意向").setTextAlignment(TextAlignment.LEFT).setBold().setFont(font));
		Cell c28 = new Cell(1,4);
		
		
		table.addCell(c2);
		table.addCell(c3);
		table.addCell(c4);
		table.addCell(c5);
		table.addCell(c6);
		table.addCell(c7);
		table.addCell(c8);
		table.addCell(c9);
		table.addCell(c10);
		table.addCell(c11);
		table.addCell(c12);
		table.addCell(c13);
		table.addCell(c14);
		table.addCell(c15);
		table.addCell(c16);
		table.addCell(c17);
		table.addCell(c18);
		table.addCell(c19);
		table.addCell(c20);
		table.addCell(c21);
		table.addCell(c22);
		table.addCell(c23);
		table.addCell(c24);
		table.addCell(c25);
		table.addCell(c26);
		table.addCell(c27);
		table.addCell(c28);*/
		
	}
}
