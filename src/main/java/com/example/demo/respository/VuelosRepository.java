package com.example.demo.respository;

import com.example.demo.model.Vuelos;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class VuelosRepository {

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert insert;

    public VuelosRepository(JdbcTemplate jdbc, DataSource ds) {
        this.jdbc = jdbc;
        this.insert = new SimpleJdbcInsert(ds).withTableName("Vuelos").usingGeneratedKeyColumns("id_vuelo");
    }

    private final RowMapper<Vuelos> mapper = (rs, rowNum) -> {
        Vuelos v = new Vuelos();
        v.setIdVuelo(rs.getInt("id_vuelo"));
        v.setOrigen(rs.getString("origen"));
        v.setDestino(rs.getString("destino"));
        if (rs.getDate("fecha_salida") != null) v.setFechaSalida(rs.getDate("fecha_salida").toLocalDate());
        if (rs.getTime("hora_salida") != null) v.setHoraSalida(rs.getTime("hora_salida").toLocalTime());
        v.setPrecio(rs.getBigDecimal("precio"));
        v.setAvionId(rs.getInt("avion_id"));
        return v;
    };
    public List<Vuelos> findAll() { return jdbc.query("SELECT * FROM Vuelos", mapper); }
    public Vuelos findById(int id) { return jdbc.queryForObject("SELECT * FROM Vuelos WHERE id_vuelo = ?", new Object[]{id}, mapper); }

    public Vuelos save(Vuelos v) {
        Map<String,Object> vals = Map.of(
                "origen", v.getOrigen(), "destino", v.getDestino(), "fecha_salida", v.getFechaSalida(),
                "hora_salida", v.getHoraSalida(), "precio", v.getPrecio(), "avion_id", v.getAvionId());
        Number k = insert.executeAndReturnKey(vals);
        v.setIdVuelo(k.intValue()); return v;
    }
    public int update(Vuelos v) {
        return jdbc.update("UPDATE Vuelos SET origen=?, destino=?, fecha_salida=?, hora_salida=?, precio=?, avion_id=? WHERE id_vuelo=?",
                v.getOrigen(), v.getDestino(), v.getFechaSalida(), v.getHoraSalida(), v.getPrecio(), v.getAvionId(), v.getIdVuelo());
    }
    public int delete(int id) { return jdbc.update("DELETE FROM Vuelos WHERE id_vuelo = ?", id); }


}
