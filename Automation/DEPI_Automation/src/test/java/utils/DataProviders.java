package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "standardUser")
    public Object[][] getStandardUser(){
        return new Object[][]{
                {"standard_user","secret_sauce"}
        };
    }

    @DataProvider(name = "lockedOutUser")
    public Object[][] getLockedOutUser(){
        return new Object[][]{
                {"locked_out_user","secret_sauce"}
        };
    }
    @DataProvider(name = "validCheckoutInfo")
    public Object[][] getValidCheckoutData() {
        return new Object[][] {
                {"Aml", "Ahmed", "12345"}
        };
    }

    @DataProvider(name = "invalidCheckoutInfo")
    public Object[][] getInvalidCheckoutData() {
        return new Object[][] {

                {"", "Ahmed", "12345", "Error: First Name is required"},

                {"Aml", "Ahmed", "", "Error: Postal Code is required"}
        };
    }

    @DataProvider(name = "spacesCheckoutInfo")
    public Object[][] getSpacesCheckoutData() {
        return new Object[][] {
                {" ", "Ahmed", "12345", "Error: First Name is required"}
        };
    }

}