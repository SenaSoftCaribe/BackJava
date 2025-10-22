package com.example.demo.respository;

import com.example.demo.dto.PagadorRequest;
import com.example.demo.dto.PagadorResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PagadorRepository {


    private final JdbcTemplate jdbcTemplate;

    public PagadorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<PagadorResponse> rowMapper = new RowMapper<>() {
        @Override
        public PagadorResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new PagadorResponse(
                    rs.getInt("idPagador"),
                    rs.getString("Nombre"),
                    rs.getString("tipoDocumento"),
                    rs.getString("correo"),
                    rs.getString("telefono")
            );
        }
    };

    public List<PagadorResponse> findAll() {
        String sql = "SELECT * FROM pagador";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public PagadorResponse findById(int id) {
        String sql = "SELECT * FROM pagador WHERE idPagador = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public int save(PagadorRequest pagador) {
        String sql = "INSERT INTO pagador (idPagador, Nombre, tipoDocumento, correo, telefono) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                pagador.getIdPagador(),
                pagador.getNombre(),
                pagador.getTipoDocumento(),
                pagador.getCorreo(),
                pagador.getTelefono()
        );
    }

    public int update(PagadorRequest pagador) {
        String sql = "UPDATE pagador SET Nombre = ?, tipoDocumento = ?, correo = ?, telefono = ? WHERE idPagador = ?";
        return jdbcTemplate.update(sql,
                pagador.getNombre(),
                pagador.getTipoDocumento(),
                pagador.getCorreo(),
                pagador.getTelefono(),
                pagador.getIdPagador()
        );
    }

    public int delete(int id) {
        String sql = "DELETE FROM pagador WHERE idPagador = ?";
        return jdbcTemplate.update(sql, id);
    }

}
