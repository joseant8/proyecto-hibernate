package com.example.dao;

import com.example.model.BillingInfo;
import com.example.repository.BillingInfoRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BillingInfoDAOImpl implements BillingInfoDAO{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private Session session;

    @Autowired
    private BillingInfoRepository repository;


    /**
     * Recupera todas las facturaciones utilizando Session de Hibernate
     * @return
     */
    @Override
    public List<BillingInfo> recuperarTodasLasFacturaciones() {
        return session.createQuery("from BillingInfo", BillingInfo.class).list();
    }

    /**
     * Recupera una facturación por su id utilizando Session de Hibernate
     * @param id
     * @return
     */
    @Override
    public BillingInfo recuperarFacturacion(Long id) {
        return session.find(BillingInfo.class, id);
    }

    /**
     * Recupera la/las facturación/es que contenga en la dirección la subcadena pasada por parámetro utilizando criteria con EntityManager
     * @param subcadena
     * @return
     */
    @Override
    public List<BillingInfo> recuperarFacturacionesDondeDireccionContiene(String subcadena) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<BillingInfo> criteria = builder.createQuery(BillingInfo.class);
        Root<BillingInfo> root = criteria.from(BillingInfo.class);

        criteria.where(builder.like(root.get("direccion"), "%"+subcadena+"%"));

        return manager.createQuery(criteria).getResultList();
    }

    /**
     * Crea una nueva facturación utilizando el repositorio
     * @param facturacion
     * @return
     */
    @Override
    public BillingInfo crearFacturacion(BillingInfo facturacion) {
        return repository.save(facturacion);
    }

    /**
     * Actualiza una facturación utilizando el repositorio
     * @param facturacion
     * @return
     */
    @Override
    public BillingInfo actualizarFacturacion(BillingInfo facturacion) {
        return repository.save(facturacion);
    }
}
