package com.example.demo.respository;

import com.example.demo.dto.PasajeroRequest;
import com.example.demo.dto.PasajeroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PasajeroRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PasajeroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<PasajeroResponse> rowMapper = (rs, rowNum) -> {
        PasajeroResponse p = new PasajeroResponse();
        p.setIdPasajero(rs.getInt("idPasajero"));
        p.setNombre(rs.getString("nombre"));
        p.setPrimerApellido(rs.getString("primerApellido"));
        p.setSegundoApellido(rs.getString("segundoApellido"));
        p.setTipoDocumento(rs.getString("tipoDocumento"));
        p.setNumeroDocumento(rs.getInt("numeroDocumento"));
        p.setCondicionInfante(rs.getString("condicionInfante"));
        p.setCelular(rs.getString("celular"));
        p.setCorreo(rs.getString("correo"));
        p.setIdVuelo(rs.getInt("Vuelos_idVuelos"));
        return p;
    };

    // Obtener todos
    public List<PasajeroResponse> obtenerTodos() {
        String sql = "SELECT * FROM pasajero";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Obtener por ID
    public Optional<PasajeroResponse> obtenerPorId(int id) {
        String sql = "SELECT * FROM pasajero WHERE idPasajero = ?";
        try {
            PasajeroResponse p = jdbcTemplate.queryForObject(sql, rowMapper, id);
            return Optional.ofNullable(p);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    // Crear pasajero
    public int crearPasajero(PasajeroRequest req) {
        String sql = "INSERT INTO pasajero (idPasajero, nombre, primerApellido, segundoApellido, tipoDocumento, numeroDocumento, condicionInfante, celular, correo, Vuelos_idVuelos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,

                req.getNombre(),
                req.getPrimerApellido(),
                req.getSegundoApellido(),
                req.getTipoDocumento(),
                req.getNumeroDocumento(),
                req.getCondicionInfante(),
                req.getCelular(),
                req.getCorreo(),
                req.getIdVuelos()
        );
    }

    // Actualizar pasajero
    public int actualizarPasajero(int id, PasajeroRequest req) {
        String sql = "UPDATE pasajero SET nombre = ?, primerApellido = ?, segundoApellido = ?, tipoDocumento = ?, numeroDocumento = ?, condicionInfante = ?, celular = ?, correo = ?, Vuelos_idVuelos = ? WHERE idPasajero = ?";
        return jdbcTemplate.update(sql,
                req.getNombre(),
                req.getPrimerApellido(),
                req.getSegundoApellido(),
                req.getTipoDocumento(),
                req.getNumeroDocumento(),
                req.getCondicionInfante(),
                req.getCelular(),
                req.getCorreo(),
                req.getIdVuelos(),
                id
        );
    }

    // Eliminar pasajero
    public int eliminarPasajero(int id) {
        String sql = "DELETE FROM pasajero WHERE idPasajero = ?";
        return jdbcTemplate.update(sql, id);
    }
}
