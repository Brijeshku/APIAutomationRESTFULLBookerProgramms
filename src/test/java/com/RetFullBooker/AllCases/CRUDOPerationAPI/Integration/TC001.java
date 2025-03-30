package com.RetFullBooker.AllCases.CRUDOPerationAPI.Integration;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC001 {

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that True is == true ")
    @Test
    public void TC_01() {
        Assert.assertEquals(true,true);
    }
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that true !=false")
   @Test
    public void TC_02(){

        Assert.assertEquals(true,false);


    }
}
