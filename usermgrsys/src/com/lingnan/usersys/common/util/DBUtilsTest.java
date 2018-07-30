package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import org.junit.Before;
import org.junit.Test;

public class DBUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetConnection() {
		Connection conn = DBUtils.getConnection();
		System.out.println(conn);
		
	}
}
