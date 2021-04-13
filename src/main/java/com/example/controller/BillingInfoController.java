package com.example.controller;

import com.example.model.BillingInfo;
import com.example.service.BillingInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillingInfoController {

    private BillingInfoService servicio;

    public BillingInfoController(BillingInfoService servicio) {
        this.servicio = servicio;
    }


    // -----------------------------
    // Consultas
    // -----------------------------

    @GetMapping("/facturaciones")
    public List<BillingInfo> recuperarTodasLasFacturaciones(){
        return servicio.recuperarTodasLasFacturaciones();
    }

    @GetMapping("/facturaciones/{id}")
    public ResponseEntity<BillingInfo> recuperarFacturacion(@PathVariable Long id){
        BillingInfo billingInfo = servicio.recuperarFacturacion(id);
        if(billingInfo != null){
            return ResponseEntity.ok().body(billingInfo);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("facturaciones/direccion-contiene/{subcadena}")
    public List<BillingInfo> recuperarFacturacionesDondeDireccionContiene(@PathVariable String subcadena){
        return servicio.recuperarFacturacionesDondeDireccionContiene(subcadena);
    }

    // -----------------------------
    // Crear
    // -----------------------------

    @PostMapping("/facturaciones")
    public ResponseEntity<BillingInfo> crearFacturacion(@RequestBody BillingInfo billingInfo) throws URISyntaxException {
        if(billingInfo.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BillingInfo billingInfoCreada = servicio.crearFacturacion(billingInfo);
        return ResponseEntity.created(new URI("/api/etiquetas/" + billingInfoCreada.getId())).body(billingInfoCreada);
    }

    // -----------------------------
    // Actualizar
    // -----------------------------

    @PutMapping("/facturaciones")
    public ResponseEntity<BillingInfo> actualizarFacturacion(@RequestBody BillingInfo billingInfo){
        if(billingInfo.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BillingInfo billingInfoActualizada = servicio.actualizarFacturacion(billingInfo);
        return ResponseEntity.ok().body(billingInfoActualizada);
    }
}
