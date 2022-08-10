package bridgelabz;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	
	public int loadIndiaCensusdata(String CSVFilePath) throws CensusAnalyserException{
		try(Reader reader=Files.newBufferedReader(Paths.get(CSVFilePath));){
			CsvToBeanBuilder<IndiaCensuscsv> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensuscsv.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensuscsv> csvToBean=csvToBeanBuilder.build();
			Iterator<IndiaCensuscsv> censuscsvIterator=csvToBean.iterator();
			Iterable<IndiaCensuscsv> csvIterable=()->censuscsvIterator;
			int numOfEnteries=(int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEnteries;
		}catch(IOException e) {
			throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}catch(RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER);
		}
}
}