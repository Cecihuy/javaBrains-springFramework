package org.koushik.javabrains.dao;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends NamedParameterJdbcDaoSupport{
    public int getCircleCount(){
        String sql = "select count(*) from CIRCLE";
        return this.getJdbcTemplate().queryForObject(sql, Integer.class);
    }
}
