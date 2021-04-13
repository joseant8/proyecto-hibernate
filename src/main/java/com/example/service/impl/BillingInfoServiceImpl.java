package com.example.service.impl;

import com.example.dao.BillingInfoDAO;
import com.example.model.BillingInfo;
import com.example.service.BillingInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingInfoServiceImpl implements BillingInfoService {

    private BillingInfoDAO billingInfoDAO;

    public BillingInfoServiceImpl(BillingInfoDAO billingInfoDAO) {
        this.billingInfoDAO = billingInfoDAO;
    }


    @Override
    public List<BillingInfo> recuperarTodasLasFacturaciones() {
        return billingInfoDAO.recuperarTodasLasFacturaciones();
    }

    @Override
    public BillingInfo recuperarFacturacion(Long id) {
        return billingInfoDAO.recuperarFacturacion(id);
    }

    @Override
    public List<BillingInfo> recuperarFacturacionesDondeDireccionContiene(String subcadena) {
        return billingInfoDAO.recuperarFacturacionesDondeDireccionContiene(subcadena);
    }

    @Override
    public BillingInfo crearFacturacion(BillingInfo facturacion) {
        return billingInfoDAO.crearFacturacion(facturacion);
    }

    @Override
    public BillingInfo actualizarFacturacion(BillingInfo facturacion) {
        return billingInfoDAO.actualizarFacturacion(facturacion);
    }
}
