package com.example.demo.repository;

import com.example.demo.model.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

@Repository
public class AdminRepository {
    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert insert;

    public AdminRepository(JdbcTemplate jdbc, DataSource ds) {
        this.jdbc = jdbc;
        this.insert = new SimpleJdbcInsert(ds)
                .withTableName("Admin")
                .usingGeneratedKeyColumns("id_admin");
    }

    private final RowMapper<Admin> mapper = (rs, rowNum) -> {
        Admin a = new Admin();
        a.setIdAdmin(rs.getInt("id_admin"));
        a.setNombreAdmin(rs.getString("nombre_admin"));
        a.setPasswordHash(rs.getString("password_hash"));
        a.setCorreo(rs.getString("correo"));
        return a;
    };

    public Admin findById(int id) {
        return jdbc.queryForObject("SELECT * FROM Admin WHERE id_admin = ?", new Object[]{id}, mapper);
    }

    public Admin findByCorreo(String correo) {
        return jdbc.queryForObject("SELECT * FROM Admin WHERE correo = ?", new Object[]{correo}, mapper);
    }

    public Admin save(Admin a) {
        Map<String,Object> vals = Map.of(
                "nombre_admin", a.getNombreAdmin(),
                "password_hash", a.getPasswordHash(),
                "correo", a.getCorreo()
        );
        Number key = insert.executeAndReturnKey(vals);
        a.setIdAdmin(key.intValue());
        return a;
    }

    public int delete(int id) {
        return jdbc.update("DELETE FROM Admin WHERE id_admin = ?", id);
    }
}
