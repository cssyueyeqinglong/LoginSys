package com.cy.pro.test;

import com.cy.pro.utils.UUIDUtils;
import org.testng.annotations.Test;

public class JDBCTest {
    @Test
    public void uuidTest() {
        String uuid = UUIDUtils.getUUID();
        System.out.print("uuid::::" + uuid);
    }

    @Test
    public void deptTest(){

    }
}
