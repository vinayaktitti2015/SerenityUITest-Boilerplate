package common;

import org.assertj.core.api.SoftAssertions;


public class SoftAssertImpl {
	

	    private SoftAssertions softAssert;

	    public SoftAssertImpl() {
	        this.softAssert = new SoftAssertions();
	    }

	    public void assertThat(String message, String actual, String expected) {
	        softAssert.assertThat(actual).as(message).isEqualTo(expected);
	    }

	    public void assertThat(String message, int actual, int expected) {
	        softAssert.assertThat(actual).as(message).isEqualTo(expected);
	    }

	    public void assertThat(String message, boolean actual, boolean expected) {
	        softAssert.assertThat(actual).as(message).isEqualTo(expected);
	    }

	    public void assertThat(String message, Double actual, Double expected) {
	        softAssert.assertThat(actual).as(message).isEqualTo(expected);
	    }
	    
	    public void assertAll() {
	        softAssert.assertAll();
	    }

	    public SoftAssertions getSoftAssert() {
	        return softAssert;
	    }

	
}
