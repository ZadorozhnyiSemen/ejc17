package task_06_csvparser.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import task_06_csvparser.model.UserDataUnit;
import task_06_csvparser.providers.AbstractDataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for parsing of given data files and creating result csv files
 */
public class CsvParserUtils {

    /**
     * Parses given file
     * @param file file for parse
     * @return list of user data units in file
     */
    public static List<UserDataUnit> parseUserHistoryCsv(File file) {
        List<UserDataUnit> userDataUnit = new ArrayList<>();
        try (Reader in = new FileReader(file)) {
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record: records) {
                userDataUnit.add(
                        new UserDataUnit(Long.parseLong(record.get("id")),
                                record.get("url"),
                                Long.parseLong(record.get("time")),
                                record.get("user")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userDataUnit;
    }

    /**
     * Clears old result file
     * and creates, fills new with data from given List
     * @param dataList fist of user data units
     */
    public static void createAndFillResults(List<UserDataUnit> dataList) {
        final String resultFilePath = AbstractDataProvider.resultFile;
        File resultFile = new File(resultFilePath);

        if (resultFile.delete()) {
            System.out.println("Old result file deleted! " + resultFile.getName());
        } else {
            System.out.println("No old files to delete");
        }

        CSVFormat csvFormat = CSVFormat.EXCEL.withRecordSeparator("\n");
        try (FileWriter fileWriter = new FileWriter(resultFilePath);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat)){
            csvPrinter.printRecord("id", "url", "time", "name");
            for (UserDataUnit unit : dataList) {
                csvPrinter.printRecord(unit.getId(), unit.getUrl(), unit.getTimeSpend(), unit.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
