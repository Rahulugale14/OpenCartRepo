package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    // DataProvider 1 - Login Data
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        // Taking xl file from testData folder
        String path = ".\\testData\\OpenCart_LoginData.xlsx";

        // Creating object for ExcelUtility
        ExcelUtility xlutil = new ExcelUtility(path);

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // Created 2D array to store data
        String logindata[][] = new String[totalrows][totalcols];

        // Read data from xl and store in 2D array
        for (int i = 1; i <= totalrows; i++)   // i = rows (starts from 1 to skip header)
        {
            for (int j = 0; j < totalcols; j++)  // j = cols (starts from 0)
            {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        return logindata;  // returning 2D array
    }

    // DataProvider 2 - Add more DataProviders below as needed
    // @org.testng.annotations.DataProvider(name = "RegisterData")
    // public String[][] getRegisterData() throws IOException {
    //     ...
    // }
}
