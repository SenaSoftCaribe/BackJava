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
import java.math.BigDecimal;
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

        // Columnas exactas de la tabla
            // id de vuelo
        vuelo.setOrigen(rs.getString("Origen"));       // mayúscula según tabla
        vuelo.setDestino(rs.getString("Destino"));     // mayúscula según tabla
        vuelo.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());

        // Convertir hora seguro
        String horaStr = rs.getString("hora");
        if (horaStr != null && !horaStr.isEmpty()) {
            vuelo.setHora(LocalTime.parse(horaStr)); // formato HH:mm o HH:mm:ss
        }

        // Convertir precio seguro
        String precioStr = rs.getString("precio");
        if (precioStr != null && !precioStr.isEmpty()) {
            vuelo.setPrecio(new BigDecimal(precioStr));
        }

        vuelo.setAvion(rs.getInt("Avion"));           // mayúscula según tabla

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

    public int obtenerAsientosDisponibles(int idVuelo) {
        String sql = "SELECT Avion.Asientos - COUNT(Pasajero.idPasajero) AS asientosDisponibles " +
                "FROM vuelos " +
                "JOIN avion ON vuelos.Avion = avion.idAvion " +
                "LEFT JOIN pasajero ON vuelos.idVuelos = pasajero.Vuelos_idVuelos " +
                "WHERE vuelos.idVuelos = ? " +
                "GROUP BY avion.Asientos";
        return jdbcTemplate.queryForObject(sql, Integer.class, idVuelo);}

}

