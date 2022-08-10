package bridgelabz;

public class CensusAnalyserException extends Exception {
	
	ExceptionType type;
	public enum ExceptionType
    {
        CENSUS_FILE_PROBLEM,
        INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER,
    }
	
	public CensusAnalyserException(String message,ExceptionType type) {
		super(message);
		this.type=type;
	}
	public CensusAnalyserException(String message,ExceptionType type,Throwable cause) {
		super(message,cause);
		this.type=type;
	}
}
