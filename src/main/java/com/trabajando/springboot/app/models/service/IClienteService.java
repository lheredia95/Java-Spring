package com.trabajando.springboot.app.models.service;

import com.trabajando.springboot.app.models.entity.Cliente;
import com.trabajando.springboot.app.models.entity.Factura;
import com.trabajando.springboot.app.models.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {
    public List<Cliente> listAll();

    public Page<Cliente> findAll(Pageable pageable);

    public void save(Cliente cliente);

    public Cliente findOne(Long id);

    public Cliente fetchByIdWithFactura(Long id);

    public void eliminar(Long id);

    public List<Producto> finByNombre(String term);

    public void saveFactura(Factura factura);

    public Producto findProductoById(Long id);

    public Factura findFacturaById(Long id);

    public void deleteFactura(Long id);

    public Factura fetchByIdWithClienteWhithItemFacturaWithProducto(Long id);
}
