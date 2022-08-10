package bridgelabz;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCodeAnalyser {
	public int loadIndiaStateCode(String csvFilePath) throws CensusAnalyserException
    {
        try
        {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaStateCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaStateCodeCSV>(reader);
            csvToBeanBuilder.withType(IndiaStateCodeCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaStateCodeCSV> csvToBean = csvToBeanBuilder.build();

            Iterator<IndiaStateCodeCSV> censusCSVIterator = csvToBean.iterator();
            int numberOfEntries = 0;
            while (censusCSVIterator.hasNext())
            {
                numberOfEntries++;
                IndiaStateCodeCSV censusData = censusCSVIterator.next();
            }
            return numberOfEntries;
        }
        catch (IOException e)
        {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
        catch (RuntimeException e)
        {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER);
        }
    }
}
