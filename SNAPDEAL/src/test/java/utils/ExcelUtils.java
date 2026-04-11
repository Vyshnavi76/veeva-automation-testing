package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.*;

public class ExcelUtils {

	// to read excel file data
    public static List<Map<String, String>> getData(String path) {

        List<Map<String, String>> dataList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            
            // to create workbook and access first sheet
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheetAt(0);

            // to read first row as keys
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                Map<String, String> map = new HashMap<>();

                // to map keys and values
                for (int j = 0; j < headerRow.getLastCellNum(); j++) {

                    String key = headerRow.getCell(j).getStringCellValue();
                    String value = row.getCell(j).toString();

                    map.put(key, value);
                }

                dataList.add(map);
            }

            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
}