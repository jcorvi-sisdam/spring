/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.olivergierke.deepdive;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Dummy test class to make sure the setup method of the superclass executes correctly.
 * 
 * @author Oliver Gierke
 * @since Step 1
 */
public class DatabasePopulationIntegrationTest extends AbstractIntegrationTest {

	@Autowired DataSource dataSource;

	@Test
	public void populatesDatabaseCorrectly() {

		JdbcOperations operations = new JdbcTemplate(dataSource);
		assertThat(operations.queryForObject("select count(*) from Customer", Integer.class), is(3));
		assertThat(operations.queryForObject("select count(*) from Address", Integer.class), is(2));
	}
}
