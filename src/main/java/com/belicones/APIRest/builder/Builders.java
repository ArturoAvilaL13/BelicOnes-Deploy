package com.belicones.APIRest.builder;

import com.belicones.APIRest.model.dto.*;
import com.belicones.APIRest.model.dto.tipos.carne.TipoDeCarneDto;
import com.belicones.APIRest.model.dto.tipos.entrega.TipoEntregaDto;
import com.belicones.APIRest.model.dto.tipos.pago.TipoPagoDto;
import com.belicones.APIRest.model.entity.*;
import com.belicones.APIRest.model.entity.tipos.carne.TipoDeCarne;
import com.belicones.APIRest.model.entity.tipos.entrega.TipoEntrega;
import com.belicones.APIRest.model.entity.tipos.pago.TipoPago;

public class Builders {
    public Usuario builderUsuario(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .idUsuario(usuarioDto.getIdUsuario())
                .correo(usuarioDto.getCorreo())
                .contrasena(usuarioDto.getContrasena())
                .nombre(usuarioDto.getNombre())
                .apellidos(usuarioDto.getApellidos())
                .telefono(usuarioDto.getTelefono())
                .direccion(usuarioDto.getDireccion())
                .idTipoDeUsuario(usuarioDto.getIdTipoDeUsuario())
                .build();
    }
    public UsuarioDto builderUsuario(Usuario usuario) {
        return UsuarioDto.builder()
                .idUsuario(usuario.getIdUsuario())
                .correo(usuario.getCorreo())
                .contrasena(usuario.getContrasena())
                .nombre(usuario.getNombre())
                .apellidos(usuario.getApellidos())
                .telefono(usuario.getTelefono())
                .direccion(usuario.getDireccion())
                .idTipoDeUsuario(usuario.getIdTipoDeUsuario())
                .build();
    }

    public Carne builderCarne(CarneDto carneDto){
        return Carne.builder()
                .idCarne(carneDto.getIdCarne())
                .nombreCarne(carneDto.getNombreCarne())
                .descripcionCarne(carneDto.getDescripcionCarne())
                .precioCarne(carneDto.getPrecioCarne())
                .imagenCarne(carneDto.getImagenCarne())
                .fkIdTipoDeCorte(carneDto.getFkIdTipoDeCorte())
                .build();
    }
    public CarneDto builderCarne(Carne carne){
        return CarneDto.builder()
                .idCarne(carne.getIdCarne())
                .nombreCarne(carne.getNombreCarne())
                .descripcionCarne(carne.getDescripcionCarne())
                .precioCarne(carne.getPrecioCarne())
                .imagenCarne(carne.getImagenCarne())
                .fkIdTipoDeCorte(carne.getFkIdTipoDeCorte())
                .build();
    }

    public TipoDeCarne builderTipoDeCarne(TipoDeCarneDto tipoDeCarneDto){
        return TipoDeCarne.builder()
                .idTipoDeCorte(tipoDeCarneDto.getIdTipoDeCorte())
                .tipoDeCorte(tipoDeCarneDto.getTipoDeCorte())
                .build();
    }

    public TipoDeCarneDto builderTipoDeCarne(TipoDeCarne tipoDeCarne){
        return TipoDeCarneDto.builder()
                .idTipoDeCorte(tipoDeCarne.getIdTipoDeCorte())
                .tipoDeCorte(tipoDeCarne.getTipoDeCorte())
                .build();
    }

    public Pedido builderPedido(PedidoDto pedidoDto){
        return Pedido.builder()
                .idPedido(pedidoDto.getIdPedido())
                .totalPedido(pedidoDto.getTotalPedido())
                .fkIdMetodoDePago(pedidoDto.getFkIdMetodoDePago())
                .fkIdTipoDeEnvio(pedidoDto.getFkIdTipoDeEnvio())
                .fkIdUsuario(pedidoDto.getFkIdUsuario())
                .build();
    }

    public PedidoDto builderPedido(Pedido pedido){
        return PedidoDto.builder()
                .idPedido(pedido.getIdPedido())
                .totalPedido(pedido.getTotalPedido())
                .fkIdMetodoDePago(pedido.getFkIdMetodoDePago())
                .fkIdTipoDeEnvio(pedido.getFkIdTipoDeEnvio())
                .fkIdUsuario(pedido.getFkIdUsuario())
                .build();
    }

    public VideoCarne builderVideoCarne(VideoCarneDto videoCarneDto){
        return VideoCarne.builder()
                .idVideoCarne(videoCarneDto.getIdVideoCarne())
                .urlVideoCarne(videoCarneDto.getUrlVideoCarne())
                .descripcionVideoCarne(videoCarneDto.getDescripcionVideoCarne())
                .fkIdCarne(videoCarneDto.getFkIdCarne())
                .build();
    }

    public VideoCarneDto builderVideoCarne(VideoCarne videoCarne){
        return VideoCarneDto.builder()
                .idVideoCarne(videoCarne.getIdVideoCarne())
                .urlVideoCarne(videoCarne.getUrlVideoCarne())
                .descripcionVideoCarne(videoCarne.getDescripcionVideoCarne())
                .fkIdCarne(videoCarne.getFkIdCarne())
                .build();
    }

    public PedidoTieneCarne builderPedidoCarne(PedidoTieneCarneDto pedidoTieneCarneDto){
        return PedidoTieneCarne.builder()
                .fkIdPedido(pedidoTieneCarneDto.getFkIdPedido())
                .fkIdCarne(pedidoTieneCarneDto.getFkIdCarne())
                .cantidadCarne(pedidoTieneCarneDto.getCantidadCarne())
                .build();
    }

    public PedidoTieneCarneDto builderPedidoCarne(PedidoTieneCarne pedidoTieneCarne){
        return PedidoTieneCarneDto.builder()
                .fkIdPedido(pedidoTieneCarne.getFkIdPedido())
                .fkIdCarne(pedidoTieneCarne.getFkIdCarne())
                .cantidadCarne(pedidoTieneCarne.getCantidadCarne())
                .build();
    }

    public TipoEntrega builderTipoEntrega(TipoEntregaDto tipoEntregaDto){
        return TipoEntrega.builder()
                .idTipoDeEntrega(tipoEntregaDto.getIdTipoDeEntrega())
                .tipoDeEntrega(tipoEntregaDto.getTipoDeEntrega())
                .build();
    }
    public TipoEntregaDto builderTipoEntrega(TipoEntrega tipoEntrega){
        return TipoEntregaDto.builder()
                .idTipoDeEntrega(tipoEntrega.getIdTipoDeEntrega())
                .tipoDeEntrega(tipoEntrega.getTipoDeEntrega())
                .build();
    }
    public TipoPago builderTipoPago(TipoPagoDto tipoPagoDto){
        return TipoPago.builder()
                .idMetodoDePago(tipoPagoDto.getIdMetodoDePago())
                .metodoDePago(tipoPagoDto.getMetodoDePago())
                .build();
    }
    public TipoPagoDto builderTipoPago(TipoPago tipoPago){
        return TipoPagoDto.builder()
                .idMetodoDePago(tipoPago.getIdMetodoDePago())
                .metodoDePago(tipoPago.getMetodoDePago())
                .build();
    }

    public TipoDeCarne builderTipoCarne(TipoDeCarneDto tipoDeCarneDto){
        return TipoDeCarne.builder()
                .idTipoDeCorte(tipoDeCarneDto.getIdTipoDeCorte())
                .tipoDeCorte(tipoDeCarneDto.getTipoDeCorte())
                .build();
    }
    public TipoDeCarneDto builderTipoCarne(TipoDeCarne tipoDeCarne){
        return TipoDeCarneDto.builder()
                .idTipoDeCorte(tipoDeCarne.getIdTipoDeCorte())
                .tipoDeCorte(tipoDeCarne.getTipoDeCorte())
                .build();
    }

}
