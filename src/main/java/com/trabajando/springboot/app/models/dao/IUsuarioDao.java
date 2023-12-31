package com.trabajando.springboot.app.models.dao;

import com.trabajando.springboot.app.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario,Long> {
    public Usuario findByUsername(String username);
}
