package com.example.demo.respository;

import com.example.demo.model.Avion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class AvionRepository {
    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert insert;

    public AvionRepository(JdbcTemplate jdbc, DataSource ds) {
        this.jdbc = jdbc;
        this.insert = new SimpleJdbcInsert(ds).withTableName("Avion").usingGeneratedKeyColumns("id_avion");
    }

    private final RowMapper<Avion> mapper = (rs, rowNum) -> {
        Avion a = new Avion();
        a.setIdAvion(rs.getInt("id_avion"));
        a.setModelo(rs.getString("modelo"));
        a.setMarca(rs.getString("marca"));
        a.setAsientos(rs.getInt("asientos"));
        a.setEstado(rs.getString("estado"));
        return a;
    };

    public List<Avion> findAll() { return jdbc.query("SELECT * FROM Avion", mapper); }
    public Avion findById(int id) { return jdbc.queryForObject("SELECT * FROM Avion WHERE id_avion = ?", new Object[]{id}, mapper); }

    public Avion save(Avion a) {
        Map<String,Object> vals = Map.of("modelo", a.getModelo(),"marca",a.getMarca(),"asientos",a.getAsientos(),"estado",a.getEstado());
        Number k = insert.executeAndReturnKey(vals);
        a.setIdAvion(k.intValue()); return a;
    }

    public int update(Avion a) {
        return jdbc.update("UPDATE Avion SET modelo=?, marca=?, asientos=?, estado=? WHERE id_avion=?",
                a.getModelo(), a.getMarca(), a.getAsientos(), a.getEstado(), a.getIdAvion());
    }

    public int delete(int id) { return jdbc.update("DELETE FROM Avion WHERE id_avion = ?", id); }
}
