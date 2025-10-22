package com.example.demo.respository;

import com.example.demo.dto.AdminRequest;
import com.example.demo.dto.AdminResponse;
import com.example.demo.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class AdminRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createAdmin(AdminRequest admin) {
        String sql = "INSERT INTO admin (idAdmin, nombreAdmin, passwordAdmin, Correo) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, admin.getIdAdmin(), admin.getNombreAdmin(), admin.getPasswordAdmin(), admin.getCorreo());
    }

    public AdminResponse getAdminById(int id) {
        String sql = "SELECT idAdmin, nombreAdmin, Correo FROM admin WHERE idAdmin = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(AdminResponse.class), id);
    }

    public List<AdminResponse> getAllAdmins() {
        String sql = "SELECT idAdmin, nombreAdmin, Correo FROM admin";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AdminResponse.class));
    }

    public void updateAdmin(AdminRequest admin) {
        String sql = "UPDATE admin SET nombreAdmin = ?, passwordAdmin = ?, Correo = ? WHERE idAdmin = ?";
        jdbcTemplate.update(sql,
                admin.getNombreAdmin(),       // param 1
                admin.getPasswordAdmin(),     // param 2
                admin.getCorreo(),            // param 3
                admin.getIdAdmin()            // param 4
        );
    }

    public void deleteAdmin(int id) {
        String sql = "DELETE FROM admin WHERE idAdmin = ?";
        jdbcTemplate.update(sql, id);
    }
    /// //LOGIN ADMIN

    public AdminResponse login(String correo, String password) {
        String sql = "SELECT idAdmin, nombreAdmin, Correo FROM admin WHERE Correo = ? AND passwordAdmin = ?";
        List<AdminResponse> result = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(AdminResponse.class),
                correo, password);

        return result.isEmpty() ? null : result.get(0);
    }
}
