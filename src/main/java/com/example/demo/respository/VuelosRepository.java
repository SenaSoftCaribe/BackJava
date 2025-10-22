package com.example.demo.respository;

import com.example.demo.dto.VuelosRequest;
import com.example.demo.dto.VuelosResponse;
import com.example.demo.model.Vuelos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.*;

@Repository
public class VuelosRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VuelosRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<VuelosResponse> rowMapper = (rs, rowNum) -> {
        VuelosResponse vuelo = new VuelosResponse();
        vuelo.setIdVuelos(rs.getInt("idVuelos"));
        vuelo.setOrigen(rs.getString("Origen"));
        vuelo.setDestino(rs.getString("Destino"));
        vuelo.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
        vuelo.setHora(LocalTime.parse(rs.getString("hora")));
        vuelo.setPrecio(rs.getBigDecimal("precio"));

        vuelo.setAvion(rs.getInt("Avion"));
        return vuelo;
    };

    public List<VuelosResponse> obtenerTodos() {
        String sql = "SELECT * FROM vuelos";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Optional<VuelosResponse> obtenerPorId(int id) {
        String sql = "SELECT * FROM vuelos WHERE idVuelos = ?";
        try {
            VuelosResponse vuelo = jdbcTemplate.queryForObject(sql, rowMapper, id);
            return Optional.ofNullable(vuelo);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public int crearVuelo(VuelosRequest req) {
        String sql = "INSERT INTO vuelos (Origen, Destino, fechaSalida, hora, precio, Avion) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                req.getOrigen(),
                req.getDestino(),
                java.sql.Date.valueOf(req.getFechaSalida()),
                req.getHora(),
                req.getPrecio(),
                req.getAvion()
        );
    }

    public int actualizarVuelo(int id, VuelosRequest req) {
        String sql = "UPDATE vuelos SET Origen = ?, Destino = ?, fechaSalida = ?, hora = ?, precio = ?, Avion = ? WHERE idVuelos = ?";
        return jdbcTemplate.update(sql,
                req.getOrigen(),
                req.getDestino(),
                java.sql.Date.valueOf(req.getFechaSalida()),
                req.getHora(),
                req.getPrecio(),
                req.getAvion(),
                id
        );
    }

    public int eliminarVuelo(int id) {
        String sql = "DELETE FROM vuelos WHERE idVuelos = ?";
        return jdbcTemplate.update(sql, id);
    }
}

