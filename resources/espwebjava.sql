CREATE TABLE cliente (
  id               SERIAL NOT NULL, 
  nombre           varchar(255) NOT NULL UNIQUE, 
  ruc              varchar(15) NOT NULL, 
  fecha_nacimiento date NOT NULL, 
  direccion        varchar(255) NOT NULL, 
  numero           int4, 
  barrio           varchar(255), 
  ciudad           varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE funcionario (
  id               SERIAL NOT NULL, 
  nombre           varchar(255) NOT NULL UNIQUE, 
  ruc              varchar(15) NOT NULL, 
  fecha_nacimiento date NOT NULL, 
  direccion        varchar(255) NOT NULL, 
  numero           int4, 
  barrio           varchar(255), 
  ciudad           varchar(255), 
  PRIMARY KEY (id));
CREATE TABLE marca (
  id          SERIAL NOT NULL, 
  descripcion varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (id));
CREATE TABLE modelo (
  id          SERIAL NOT NULL, 
  id_marca    int4 NOT NULL, 
  descripcion varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE orden_servicio (
  id          SERIAL NOT NULL, 
  fecha       date NOT NULL, 
  descripcion varchar(255) NOT NULL, 
  id_vehiculo int4 NOT NULL, 
  total_prod  float8 NOT NULL, 
  total_serv  float8 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE orden_servicio_det_producto (
  id                SERIAL NOT NULL, 
  id_orden_servicio int4 NOT NULL, 
  id_producto       int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE orden_servicio_det_servicio (
  id                SERIAL NOT NULL, 
  id_orden_servicio int4 NOT NULL, 
  id_servicio       int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE producto (
  id          SERIAL NOT NULL, 
  descripcion varchar(255) NOT NULL UNIQUE, 
  valor       float8 NOT NULL, 
  cantidad    int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE servicio (
  id          SERIAL NOT NULL, 
  descripcion varchar(255) NOT NULL UNIQUE, 
  valor_hora  float8 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE servicio_funcionario (
  id             SERIAL NOT NULL, 
  descripcion    varchar(255) NOT NULL UNIQUE, 
  id_servicio    int4 NOT NULL, 
  id_funcionario int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE usuario (
  id       SERIAL NOT NULL, 
  login    varchar(100) NOT NULL, 
  password varchar(100) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE vehiculo (
  id         SERIAL NOT NULL, 
  placa      varchar(10) NOT NULL UNIQUE, 
  color      varchar(50) NOT NULL, 
  anho       int4 NOT NULL, 
  id_modelo  int4 NOT NULL, 
  id_cliente int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE venta (
  id          SERIAL NOT NULL, 
  fecha       date NOT NULL, 
  id_vehiculo int4 NOT NULL, 
  descripcion varchar(255) NOT NULL, 
  total_prod  float8 NOT NULL, 
  total_serv  float8 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE venta_det_producto (
  id         SERIAL NOT NULL, 
  id_venta   int4 NOT NULL, 
  productoid int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE venta_det_servicio (
  id          SERIAL NOT NULL, 
  id_venta    int4 NOT NULL, 
  id_servicio int4 NOT NULL, 
  PRIMARY KEY (id));
CREATE UNIQUE INDEX u_idx_servicio_funcionario 
  ON servicio_funcionario (id_servicio, id_funcionario);
ALTER TABLE modelo ADD CONSTRAINT "fk_modelo-marca" FOREIGN KEY (id_marca) REFERENCES marca (id);
ALTER TABLE orden_servicio ADD CONSTRAINT "fk_orden_servicio-vehiculo" FOREIGN KEY (id_vehiculo) REFERENCES vehiculo (id);
ALTER TABLE orden_servicio_det_producto ADD CONSTRAINT "fk_orden_servicio_det_producto-orden_servicio" FOREIGN KEY (id_orden_servicio) REFERENCES orden_servicio (id);
ALTER TABLE orden_servicio_det_producto ADD CONSTRAINT "fk_orden_servicio_det_producto-producto" FOREIGN KEY (id_producto) REFERENCES producto (id);
ALTER TABLE orden_servicio_det_servicio ADD CONSTRAINT "fk_orden_servicio_det_servicio-orden_servicio" FOREIGN KEY (id_orden_servicio) REFERENCES orden_servicio (id);
ALTER TABLE orden_servicio_det_servicio ADD CONSTRAINT "fk_orden_servicio_det_servicio-servicio" FOREIGN KEY (id_servicio) REFERENCES servicio (id);
ALTER TABLE servicio_funcionario ADD CONSTRAINT "fk_servicio_funcionario-funcionario" FOREIGN KEY (id_funcionario) REFERENCES funcionario (id);
ALTER TABLE servicio_funcionario ADD CONSTRAINT "fk_servicio_funcionario-servicio" FOREIGN KEY (id_servicio) REFERENCES servicio (id);
ALTER TABLE vehiculo ADD CONSTRAINT "fk_vehiculo-cliente" FOREIGN KEY (id_cliente) REFERENCES cliente (id);
ALTER TABLE vehiculo ADD CONSTRAINT "fk_vehiculo-modelo" FOREIGN KEY (id_modelo) REFERENCES modelo (id);
ALTER TABLE venta ADD CONSTRAINT "fk_venta-vehiculo" FOREIGN KEY (id_vehiculo) REFERENCES vehiculo (id);
ALTER TABLE venta_det_producto ADD CONSTRAINT "fk_venta_det_producto-producto" FOREIGN KEY (productoid) REFERENCES producto (id);
ALTER TABLE venta_det_producto ADD CONSTRAINT "fk_venta_det_producto-venta" FOREIGN KEY (id_venta) REFERENCES venta (id);
ALTER TABLE venta_det_servicio ADD CONSTRAINT "fk_venta_det_servicio-servicio" FOREIGN KEY (id_servicio) REFERENCES servicio (id);
ALTER TABLE venta_det_servicio ADD CONSTRAINT "fk_venta_det_servicio-venta" FOREIGN KEY (id_venta) REFERENCES venta (id);
