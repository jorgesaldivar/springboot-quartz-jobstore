package com.saldivar.quartz.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository implementation.
 * 
 * @author saldivar
 *
 */
@Repository
public class DataRepositoryImpl implements DataRepository {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public int getCount() {
		return (Integer) jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM TEST_TABLE", 
				Integer.class);
	}

	@Override
	public int insertMessage(String message) {
		return namedParameterJdbcTemplate.update(
				"INSERT INTO TEST_TABLE VALUES (:message)", 
				new MapSqlParameterSource().addValue("message", message));
	}

}
