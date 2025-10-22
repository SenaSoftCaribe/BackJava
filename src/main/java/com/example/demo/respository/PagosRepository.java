package com.example.demo.respository;

import com.example.demo.dto.PagoRequest;
import com.example.demo.dto.PagoResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;


@Repository
public class PagosRepository {

    private final JdbcTemplate jdbcTemplate;

    public PagosRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<PagoResponse> rowMapper = (ResultSet rs, int rowNum) -> new PagoResponse(
            rs.getInt("idPago"),
            rs.getString("TipoPago"),
            rs.getString("Fecha"),
            rs.getInt("Pagador_idPagador"),
            rs.getInt("Pasajero_idPasajero")
    );

    public List<PagoResponse> findAll() {
        return jdbcTemplate.query("SELECT * FROM pagos", rowMapper);
    }

    public PagoResponse findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM pagos WHERE idPago = ?", rowMapper, id);
    }

    public int save(PagoRequest pago) {
        String sql = "INSERT INTO pagos (idPago, TipoPago, Fecha, Pagador_idPagador, Pasajero_idPasajero) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                pago.getIdPago(),
                pago.getTipoPago(),
                pago.getFecha(),
                pago.getPagadorId(),
                pago.getPasajeroId()
        );
    }

    public int update(PagoRequest pago) {
        String sql = "UPDATE pagos SET TipoPago = ?, Fecha = ?, Pagador_idPagador = ?, Pasajero_idPasajero = ? WHERE idPago = ?";
        return jdbcTemplate.update(sql,
                pago.getTipoPago(),
                pago.getFecha(),
                pago.getPagadorId(),
                pago.getPasajeroId(),
                pago.getIdPago()
        );
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM pagos WHERE idPago = ?", id);
    }
}
