package com.example.demo.repository;

import com.example.demo.model.PagoReserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;

@Repository
public class PagoReservaRepository {
    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert insert;

    public PagoReservaRepository(JdbcTemplate jdbc, DataSource ds) {
        this.jdbc = jdbc;
        this.insert = new SimpleJdbcInsert(ds).withTableName("PagosReserva").usingGeneratedKeyColumns("id_pagos_reserva");
    }

    private final RowMapper<PagoReserva> mapper = (rs, rowNum) -> {
        PagoReserva p = new PagoReserva();
        p.setIdPagosReserva(rs.getInt("id_pagos_reserva"));
        p.setTipoPago(rs.getString("tipo_pago"));
        Timestamp t = rs.getTimestamp("fecha"); if (t!=null) p.setFecha(t.toLocalDateTime());
        p.setReservaId(rs.getInt("reserva_id"));
        p.setPagadorId(rs.getInt("pagador_id"));
        p.setMonto(rs.getBigDecimal("monto"));
        return p;
    };

    public List<PagoReserva> findAll() { return jdbc.query("SELECT * FROM PagosReserva", mapper); }
    public PagoReserva findById(int id) { return jdbc.queryForObject("SELECT * FROM PagosReserva WHERE id_pagos_reserva = ?", new Object[]{id}, mapper); }

    public PagoReserva save(PagoReserva p) {
        Map<String,Object> vals = Map.of(
                "tipo_pago", p.getTipoPago(),
                "fecha", Timestamp.valueOf(p.getFecha() == null ? LocalDateTime.now() : p.getFecha()),
                "reserva_id", p.getReservaId(),
                "pagador_id", p.getPagadorId(),
                "monto", p.getMonto()
        );
        Number k = insert.executeAndReturnKey(vals);
        p.setIdPagosReserva(k.intValue());
        return p;
    }

    public int delete(int id) { return jdbc.update("DELETE FROM PagosReserva WHERE id_pagos_reserva = ?", id); }
}
