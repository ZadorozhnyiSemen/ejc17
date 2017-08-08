package task_06_csvparser.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvParserUtil {
    public List<UserDataUnit> parse(File file) {
        List<UserDataUnit> userDataUnit = new ArrayList<>();
        try {
            Reader in = new FileReader(file);
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
}
