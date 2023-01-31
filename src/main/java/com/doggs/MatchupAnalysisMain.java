package com.doggs;

import com.doggs.model.Record;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

public class MatchupAnalysisMain {

    final static String PATH = "src/main/resources/matchup-team-data/";

    public static void main(String[] args) {
        readExcelData(PATH+"rank_record_pfpa.xlsx");
    }

    private static void readExcelData(String filename) {
        try {
            String opponent = "";
            String result = "";
            double opponentRank = 0;
            double pointsScored = 0;
            double pointsAllowed = 0;
            Record opponentRecord = null;
            String opponentWins = "";
            String opponentLosses = "";
            boolean overtimeIndicator = false;

            // Create input stream from xlsx file
            FileInputStream fis = new FileInputStream(filename);

            // Create workbook instance for xlsx file input stream
            Workbook workbook = null;
            if(filename.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            }

            int numSheets = workbook.getNumberOfSheets();
            for(int i=0; i<numSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);

                // all sheets have rows -- iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while(rowIterator.hasNext()) {
                    // get Row object
                    Row row = rowIterator.next();

                    // reset variables
                    if(row.getRowNum() % 2 == 0) {
                        opponent = "";
                        result = "";
                        opponentRank = 0;
                        pointsScored = 0;
                        pointsAllowed = 0;
                        opponentRecord = null;
                        opponentWins = "";
                        opponentLosses = "";
                        overtimeIndicator = false;
                    }
                    // all Rows have columns - iterate over each column (Cell)
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()) {
                        // get Cell object
                        Cell cell = cellIterator.next();

                        switch(cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                String cellValueString = cell.getStringCellValue().trim();

                                if(opponent.isEmpty() && !cellValueString.startsWith("(") && !cellValueString.endsWith(")")) {
                                    opponent = cellValueString;
                                    System.out.println("Parsing OPPONENT from row["+row.getRowNum()+"]: " + opponent);
                                }
                                else if(result.isEmpty() && cellValueString.equalsIgnoreCase("W") || cellValueString.equalsIgnoreCase("L")) {
                                    result = cellValueString;
                                    System.out.println("Parsing RESULT from row["+row.getRowNum()+"]: " + result);
                                }
                                else if(opponentWins.isEmpty() && opponentLosses.isEmpty() && cellValueString.startsWith("(") && cellValueString.endsWith(")")) {
                                    String record = cellValueString.substring(1, cellValueString.length()-1);
                                    opponentWins = cellValueString.substring(1, cellValueString.indexOf("-"));
                                    opponentLosses = cellValueString.substring(cellValueString.indexOf("-")+1, cellValueString.length()-1);
                                    System.out.println(
                                            "Parsing RECORD from row["+row.getRowNum()+"]:\n\t" +
                                            "record = ["+record+"]\n\t" +
                                            "opponentWins=["+opponentWins+"]\n\t" +
                                            "opponentLosses=["+opponentLosses+"]"
                                    );
                                }
                                else if(cellValueString.equalsIgnoreCase("OT")) {
                                    result += " "+cellValueString;
                                    System.out.println("Detected OT matchup -- updating RESULT: " + result);
                                }
                                else {
                                    System.out.println("** irrelevant data detected -- " + cellValueString + " **");
                                }
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                double cellValueNumeric = cell.getNumericCellValue();

                                if(opponentRank == 0) {
                                    opponentRank = cellValueNumeric;
                                    System.out.println("Parsing OPPONENT RANK from row["+row.getRowNum()+"]: " + opponentRank);
                                }
                                else if(pointsScored == 0) {
                                    pointsScored = cellValueNumeric;
                                    System.out.println("Parsing POINTS SCORED from row["+row.getRowNum()+"]: " + pointsScored);
                                }
                                else if(pointsAllowed == 0) {
                                    pointsAllowed = cellValueNumeric;
                                    System.out.println("Parsing POINTS ALLOWED from row["+row.getRowNum()+"]: " + pointsAllowed);
                                }
                                break;
                        }
                    }
                }
            }

            fis.close(); //close file input stream
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
