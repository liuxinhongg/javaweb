package com.bdxh.kmsale.utils;
/**
 * 
 * @author 莫夏欣
 * @date 创建时间：2018年11月12日,上午10:49:05
 * @Description 工具类验证Excel文档
 */
public class ExcelFormatUtil {
	/**
     * @描述：是否是2003的excel，返回true是2003
     * @param filePath
     * @return
     */
    public static boolean isExcel2003(String filePath)  {  
          return filePath.matches("^.+\\.(?i)(xls)$");  
    }  
         
    /**
     * @描述：是否是2007的excel，返回true是2007
     * @param filePath
     * @return
     */
    public static boolean isExcel2007(String filePath)  {  
          return filePath.matches("^.+\\.(?i)(xlsx)$");  
    }
      
    /**
     * 验证是否是EXCEL文件(仅xls后缀)
     * @param filePath
     * @return
     */
    public static boolean validateExcel(String filePath){
          if (filePath == null || !(isExcel2003(filePath))){  
              return false;  
          }  
          return true;
    }
}
