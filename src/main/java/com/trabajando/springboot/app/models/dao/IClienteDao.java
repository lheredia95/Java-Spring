package com.trabajando.springboot.app.models.dao;

import com.trabajando.springboot.app.models.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {
    @Query("select c from Cliente c left join fetch c.facturas f where c.id = ?1")
    public Cliente fetchByIdWithFactura(Long id);

}
