package com.example.demo.respository;

import com.example.demo.dto.PagoReservaRequest;
import com.example.demo.dto.PagoReservaResponse;
import com.example.demo.model.PagoReserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;

@Repository
public class PagoReservaRepository {

    private final JdbcTemplate jdbcTemplate;

    public PagoReservaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<PagoReservaResponse> rowMapper = (ResultSet rs, int rowNum) -> new PagoReservaResponse(
            rs.getInt("idPagosReserva"),
            rs.getString("TipoPago"),
            rs.getString("Fecha"),
            rs.getInt("Reserva_idReserva"),
            rs.getInt("Pagador_idPagador")
    );

    public List<PagoReservaResponse> findAll() {
        return jdbcTemplate.query("SELECT * FROM pagosreserva", rowMapper);
    }

    public PagoReservaResponse findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM pagosreserva WHERE idPagosReserva = ?", rowMapper, id);
    }

    public int save(PagoReservaRequest request) {
        String sql = "INSERT INTO pagosreserva (idPagosReserva, TipoPago, Fecha, Reserva_idReserva, Pagador_idPagador) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                request.getIdPagosReserva(),
                request.getTipoPago(),
                request.getFecha(),
                request.getReservaId(),
                request.getPagadorId()
        );
    }

    public int update(PagoReservaRequest request) {
        String sql = "UPDATE pagosreserva SET TipoPago = ?, Fecha = ?, Reserva_idReserva = ?, Pagador_idPagador = ? WHERE idPagosReserva = ?";
        return jdbcTemplate.update(sql,
                request.getTipoPago(),
                request.getFecha(),
                request.getReservaId(),
                request.getPagadorId(),
                request.getIdPagosReserva()
        );
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM pagosreserva WHERE idPagosReserva = ?", id);
    }
}
