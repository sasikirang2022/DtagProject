package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class GenericUtils {

    public WebDriver driver;

    public GenericUtils(WebDriver driver){
        this.driver = driver;
    }

    public void switchWindowToChild(){
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }

    public static Map<String, List<Object>> readExcel(Path excelFilePath, List<String> columnNames) {
        Map<String, List<Object>> data = new HashMap<>();
        try (Workbook workbook = new XSSFWorkbook(excelFilePath.toFile())) {
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();

            Map<String, Integer> columnIndices = getHeaderIndices(iterator.next());

            for (String columnName : columnNames) {
                data.put(columnName, new ArrayList<>());
            }

            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                for (String columnName : columnNames) {
                    Cell cell = nextRow.getCell(columnIndices.get(columnName));
                    data.get(columnName).add(getCellValue(cell));
                }
            }
        } catch (IOException | InvalidFormatException e) {
            System.err.println("Failed to read the Excel file at " + excelFilePath + ": " + e.getMessage());
        }
        return data;
    }

    private static Map<String, Integer> getHeaderIndices(Row headerRow) {
        Map<String, Integer> columnIndices = new HashMap<>();
        headerRow.forEach(cell -> columnIndices.put(cell.getStringCellValue(), cell.getColumnIndex()));
        return columnIndices;
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return null;
        }
    }
}
