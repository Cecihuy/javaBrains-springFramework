package org.koushik.javabrains.dao;
import org.koushik.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

@Component
public class JdbcDaoImpl {
    @Autowired
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
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
}