package com.example.dao;

import com.example.model.BillingInfo;

import java.util.List;

public interface BillingInfoDAO {

    public List<BillingInfo> recuperarTodasLasFacturaciones();

    public BillingInfo recuperarFacturacion(Long id);

    public List<BillingInfo> recuperarFacturacionesDondeDireccionContiene(String subcadena);

    public BillingInfo crearFacturacion(BillingInfo facturacion);

    public BillingInfo actualizarFacturacion(BillingInfo facturacion);
}
