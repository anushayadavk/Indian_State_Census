package indianstate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\Admin\\eclipse-workspace\\IndianAnalyzer\\src\\indianstate\\IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "C:\\Users\\Admin\\eclipse-workspace\\IndianAnalyzer\\src\\indianstate\\IndiaStateCensusData.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(29,numOfRecords);
		} catch (CensusAnalyserException e) {}
	}
	
	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(null, CensusAnalyserException.CENSUS_FILE_CSV, e);
		}
	}
	

}
