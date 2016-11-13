package com.yfairy.demo.poi;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

public class SimpleTable
{
  public static void main(String[] args)
    throws Exception
  {
    try
    {
      createSimpleTable();
    }
    catch (Exception e) {
      System.out.println("Error trying to create simple table.");
      throw e;
    }
    try {
      createStyledTable();
    }
    catch (Exception e) {
      System.out.println("Error trying to create styled table.");
      throw e;
    }
  }

  public static void createSimpleTable() throws Exception {
    XWPFDocument doc = new XWPFDocument();
    try
    {
      XWPFTable table = doc.createTable(3, 3);

      table.getRow(1).getCell(1).setText("EXAMPLE OF TABLE");

      XWPFParagraph p1 = (XWPFParagraph)table.getRow(0).getCell(0).getParagraphs().get(0);

      XWPFRun r1 = p1.createRun();
      r1.setBold(true);
      r1.setText("The quick brown fox");
      r1.setItalic(true);
      r1.setFontFamily("Courier");
      r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
      r1.setTextPosition(100);

      table.getRow(2).getCell(2).setText("only text");

      OutputStream out = new FileOutputStream("simpleTable.docx");
      try {
        doc.write(out);
      } finally {
      }
    }
    finally {
      doc.close();
    }
  }

  public static void createStyledTable()
    throws Exception
  {
    XWPFDocument doc = new XWPFDocument();
    try
    {
      int nRows = 6;
      int nCols = 3;
      XWPFTable table = doc.createTable(nRows, nCols);

      CTTblPr tblPr = table.getCTTbl().getTblPr();
      CTString styleStr = tblPr.addNewTblStyle();
      styleStr.setVal("StyledTable");

      List<XWPFTableRow> rows = table.getRows();
      int rowCt = 0;
      int colCt = 0;
      for (XWPFTableRow row : rows)
      {
        CTTrPr trPr = row.getCtRow().addNewTrPr();

        CTHeight ht = trPr.addNewTrHeight();
        ht.setVal(BigInteger.valueOf(360L));

        List<XWPFTableCell> cells = row.getTableCells();

        for (XWPFTableCell cell : cells)
        {
          CTTcPr tcpr = cell.getCTTc().addNewTcPr();

          CTVerticalJc va = tcpr.addNewVAlign();
          va.setVal(STVerticalJc.CENTER);

          CTShd ctshd = tcpr.addNewShd();
          ctshd.setColor("auto");
          ctshd.setVal(STShd.CLEAR);
          if (rowCt == 0)
          {
            ctshd.setFill("A7BFDE");
          } else if (rowCt % 2 == 0)
          {
            ctshd.setFill("D3DFEE");
          }
          else {
            ctshd.setFill("EDF2F8");
          }

          XWPFParagraph para = (XWPFParagraph)cell.getParagraphs().get(0);

          XWPFRun rh = para.createRun();

          if (colCt == nCols - 1)
          {
            rh.setFontSize(10);
            rh.setFontFamily("Courier");
          }
          if (rowCt == 0)
          {
            rh.setText("header row, col " + colCt);
            rh.setBold(true);
            para.setAlignment(ParagraphAlignment.CENTER);
          }
          else {
            rh.setText("row " + rowCt + ", col " + colCt);
            para.setAlignment(ParagraphAlignment.LEFT);
          }
          colCt++;
        }
        colCt = 0;
        rowCt++;
      }

      OutputStream out = new FileOutputStream("styledTable.docx");
      try {
        doc.write(out);
      } finally {
      }
    }
    finally {
      doc.close();
    }
  }
}