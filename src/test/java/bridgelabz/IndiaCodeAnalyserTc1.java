package bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

	public class IndiaCodeAnalyserTc1 {
		private static final String STATE_CODE_FILE_PATH="C:\\Users\\VARSHA P\\Desktop\\eclipse-workspace\\CensusAnalyser\\lib\\src\\main\\java\\StateCode.csv";

	@Test
	void givencodeReturnsCorrectRecords(){
		        try
		        {
		            StateCodeAnalyser codeAnalyser = new StateCodeAnalyser();
		            int numOfRecords = codeAnalyser.loadIndiaStateCode(STATE_CODE_FILE_PATH);
		            Assertions.assertEquals(38,numOfRecords);
		        }
		        catch (CensusAnalyserException e) { }
		    }
	}
