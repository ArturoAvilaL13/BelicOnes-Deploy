package com.belicones.APIRest.service.tipos;

import com.belicones.APIRest.model.dto.tipos.carne.TipoDeCarneDto;
import com.belicones.APIRest.model.dto.tipos.entrega.TipoEntregaDto;
import com.belicones.APIRest.model.dto.tipos.pago.TipoPagoDto;
import com.belicones.APIRest.model.entity.tipos.carne.TipoDeCarne;
import com.belicones.APIRest.model.entity.tipos.entrega.TipoEntrega;
import com.belicones.APIRest.model.entity.tipos.pago.TipoPago;

import java.util.List;

public interface InterfaceTiposService {
    List<TipoDeCarne> listAllTiposCarnes();
    List<TipoPago> listAllTiposPago();

    List<TipoEntrega> listAllTiposEntregas();

    TipoEntrega saveTipoEntrega(TipoEntregaDto tipoEntregaDto);
    TipoPago saveTipoPago(TipoPagoDto tipoPagoDto);
    TipoDeCarne saveTipoDeCarne(TipoDeCarneDto tipoDeCarneDto);

}
