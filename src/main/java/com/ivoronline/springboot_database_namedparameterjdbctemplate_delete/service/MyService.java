package com.ivoronline.springboot_database_namedparameterjdbctemplate_delete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  //=========================================================================================================
  // DELETE
  //=========================================================================================================
  public int delete(String name, Integer age) {

    String sql = "DELETE FROM PERSON WHERE name = :personName AND age = :personAge";

    SqlParameterSource parameters = new MapSqlParameterSource()
      .addValue("personName", name)
      .addValue("personAge" , age );

    return namedParameterJdbcTemplate.update(sql, parameters);

  }

}
