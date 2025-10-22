package com.example.demo.respository;

import com.example.demo.dto.ReservaRequest;
import com.example.demo.dto.ReservaResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;


@Repository
public class ReservaRepository {


    private final JdbcTemplate jdbcTemplate;

    public ReservaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<ReservaResponse> rowMapper = (ResultSet rs, int rowNum) -> new ReservaResponse(
            rs.getInt("idReserva"),
            rs.getString("FechaReserva"),
            rs.getInt("Pasajero_idPasajero")
    );



    public List<ReservaResponse> findAll() {
        return jdbcTemplate.query("SELECT * FROM reserva", rowMapper);
    }

    public ReservaResponse findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM reserva WHERE idReserva = ?", rowMapper, id);
    }

    public int save(ReservaRequest reserva) {
        String sql = "INSERT INTO reserva (idReserva, FechaReserva, Pasajero_idPasajero) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,
                reserva.getIdReserva(),
                reserva.getFechaReserva(),
                reserva.getPasajeroId()
        );
    }

    public int update(ReservaRequest reserva) {
        String sql = "UPDATE reserva SET FechaReserva = ?, Pasajero_idPasajero = ? WHERE idReserva = ?";
        return jdbcTemplate.update(sql,
                reserva.getFechaReserva(),
                reserva.getPasajeroId(),
                reserva.getIdReserva()
        );
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM reserva WHERE idReserva = ?", id);
    }
}

