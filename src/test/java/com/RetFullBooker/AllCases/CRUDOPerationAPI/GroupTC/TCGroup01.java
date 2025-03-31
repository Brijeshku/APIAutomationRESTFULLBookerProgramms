package com.RetFullBooker.AllCases.CRUDOPerationAPI.GroupTC;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TCGroup01 {

    @Test(groups = {"Sanity","QA"})
    public void SanityRun() {
        System.out.println("Sanity");
        System.out.print("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"QA"})
    public void RegQA() {
        System.out.println("REG");
        Assert.assertTrue(false);
    }
    @Test(groups = {"dev"})
    public void  Dev() {

        System.out.println("Smoke");

        Assert.assertTrue(false);
    }
    @Test(groups = {"sanity", "qa", "preprod"})
    public void sanityRun1(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa","preprod", "reg"})
    public void RegRun2(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"dev","stage"})
    public void SmokeRun3(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
