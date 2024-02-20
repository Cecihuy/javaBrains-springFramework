package org.koushik.javabrains.dao;
import org.koushik.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

@Component
public class JdbcDaoImpl {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }    
    public Circle getCircle(int circleId){
        Connection conn = null;
        try{            
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from circle where id = ?");
            ps.setInt(1, circleId);

            Circle circle = null;
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                circle = new Circle(circleId, rs.getString("name"));
            }
            rs.close();
            ps.close();
            return circle;
        } catch(Exception e){
            throw new RuntimeException(e);
        } finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public int getCircleCount(){
        String sql = "select count(*) from circle";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
    public String getCircleName(int circleId){
        String sql = "select name from circle where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
    }
    public Circle getCircleForId(int circleId){
        String sql = "select * from circle  where id = ?"; 
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
    }
    public List<Circle> getAllCircles(){
        String sql = "select * from circle";
        return jdbcTemplate.query(sql, new CircleMapper());
    }
    private static final class CircleMapper implements RowMapper<Circle>{

        @Override
        public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(rs.getInt("ID"));
            circle.setName(rs.getString("NAME"));
            return circle;
        }

    }
}