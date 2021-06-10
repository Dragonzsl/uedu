package xyz.myzsl.uedu.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DruidJdbcUtilsTest {

    @Test
    void getConnection() {
        System.out.println(DruidJdbcUtils.getConnection());
    }
}