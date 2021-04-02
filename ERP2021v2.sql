use ERP2021;
create database ERP2021
on primary
(
name=ERP2021_dat,--nombre logico del archivo de datos
filename='C:\BD\ERP2021\ERP2021_dat.mdf',--nombre fisico
size=5MB, 
maxsize=10MB, 
filegrowth=1MB

)
log on
(
name=ERP2021_log,--nombre logioc del archivo de log
filename='C:\BD\ERP2021\ERP2021_log.ldf',--nombre fisico
size=3MB, 
maxsize=6MB, 
filegrowth=1MB
)
go

create table UnidadesMedida(
idUnidad integer identity(1,1) not null,
nombre varchar(80),
salidas varchar(20),
estatus char,
constraint pk_UnidadMedida primary key (idUnidad)
)

create table Categorias(
idCategoria integer identity(1,1) not null,
nombre varchar(30),
estatus char,
constraint pk_Categorias primary key(idCategoria)
)
create table Laboratorios(
idLaboratorio integer identity(1,1) not null,
nombre varchar(50),
origen varchar(30),
estatus char,
constraint pk_Laboratorios primary key (idLaboratorio)
)
create table Estados(
idEstado int not null IDENTITY(1,1),
nombre varchar(60),
siglas varchar(10),
estatus char,
constraint Estado_PK primary key (idEstado)
)
create table Ciudades(
idCiudad int not null IDENTITY(1,1),
nombre varchar(80),
idEstado int,
estatus char,
constraint Ciudades_PK primary key (idCiudad),
constraint fk_Ciudades_Estados foreign key (idEstado) references Estados(idEstado)
)

create table Turnos(
idTurno integer not null,
nombre varchar(20),
horaInicio date not null,
horaFin date not null,
dias varchar(30),
constraint pk_Turnos primary key(idTurno)
)
create table Puestos(
idPuesto integer not null,
nombre varchar(60),
salarioMinimo float not null,
salarioMaximo float not null,
estatus char not null,
constraint pk_Puestos primary key(idPuesto)
)

create table Periodos(
idPeriodo integer not null,
nombre varchar,
fechaInicio date,
fechaFin date,
estatus char,
constraint pk_Periodos primary key(idPeriodo)
)

create table Departamentos(
idDepartamento integer not null,
nombre varchar(50),
estatus char not null,
constraint pk_Departamentos primary key(idDepartamento)
)

create table Percepciones(
idPercepcion integer not null,
nombre varchar,
descripcion varchar,
diasPagar integer not null,
constraint pk_Percepciones primary key(idPercepcion)
)
create table Deducciones(
idDeduccion integer not null,
nombre varchar,
decripcion varchar,
porcentaje float,
constraint pk_Deducciones primary key(idDeduccion)
)

create table Asociaciones(
idAsociacion integer not null,
estatus char not null,
fechaIncorporacion date not null,
constraint pk_Asociaciones primary key (idAsociacion)
)

create table Cultivos(
idCultivo integer not null,
nombre varchar(100),
costoAsesoria float not null,
estatus char,
constraint pk_cultivos primary key (idCultivo)
)
CREATE TABLE Clientes(
idCliente INTEGER IDENTITY(1,1) NOT NULL,
nombre VARCHAR(100),
razonSocial VARCHAR(100),
limiteCredito FLOAT,
rfc CHAR(13),
telefono CHAR(12),
email VARCHAR(100),
tipo CHAR,
CONSTRAINT pk_Clientes PRIMARY KEY (idCliente)
)
CREATE TABLE UnidadesTransporte(
idUnidadTransporte INTEGER IDENTITY(1,1) NOT NULL,
placas VARCHAR(10),
marca VARCHAR(80),
modelo VARCHAR(80),
anio INTEGER,
capacidad INTEGER,
tipo VARCHAR(30),
CONSTRAINT pk_UnidadesTransporte PRIMARY KEY (idUnidadTransporte)
)

create table Empaques(
idEmpaque integer not null,
idUnidad integer not null,
nombre varchar(80),
capacidad float not null,
estatus char not null,
constraint pk_Empaques primary key(idEmpaque),
constraint fk_Empaques_UnidadMedida FOREIGN KEY(idUnidad) REFERENCES UnidadesMedida(idUnidad)
)
create table Productos(
idProducto integer identity(1,1) not null,
nombre varchar(50) not null,
descripcion varchar(100) not null,
ingredienteActivo varchar(100) not null,
bandaToxicologica varchar(80) not null,
aplicacion varchar(200) not null,
uso varchar(200) not null,
estatus char not null,
idLaboratorio integer not null,
idCategoria integer not null,
constraint pk_Productos primary key(idProducto),
CONSTRAINT fk_Productos_Laboratorios FOREIGN KEY(idLaboratorio) REFERENCES Laboratorios(idLaboratorio),
CONSTRAINT fk_Productos_Categorias FOREIGN KEY(idCategoria) REFERENCES Categorias(idCategoria)
)
create table ImagenesProductos(
idImagen integer identity(1,1) not null,
nombreImagen varchar(100) not null,
imagen varbinary not null,
principal char not null,
idProducto integer not null,
constraint pk_ImagenesProductos primary key(idImagen),
constraint fk_ImagenesProductos_Producto foreign key (idProducto) references Productos(idProducto)
)
Create table Proveedores(
idProveedor integer identity(1,1) not null,
nombre varchar(80) not null,
telefono char(12) not null,
email varchar(100) not null,
direccion varchar(80) not null,
colonia varchar(50) not null,
codigoPostal varchar(5) not null,
idCiudad integer not null
constraint pk_Proveedores primary key(idProveedor),
CONSTRAINT fk_Proveedores_Ciudades FOREIGN KEY(idCiudad) REFERENCES Ciudades(idCiudad)
)

create table ContactosProveedor(
idContacto integer not null,
nombre varchar(80) not null,
telefono char(12) not null,
email varchar(12) not null,
idProveedor integer not null
constraint pk_ContactosProveedor primary key(idContacto),
CONSTRAINT fk_ContactosProveedor_Porveedores FOREIGN KEY(idProveedor) REFERENCES Proveedores(idProveedor)
)
CREATE TABLE PresentacionesProductos(
idPresentacion integer IDENTITY(1,1) not null,
precioCompra float,
precioVenta float,
puntoReorden float, 
idProducto integer not null,
idEmpaque integer not null
CONSTRAINT pk_PresentacionesProducto PRIMARY KEY(idPresentacion)
constraint fk_PresentacionesProducto foreign key (idEmpaque) references Empaques(idEmpaque)
)

create table ProductosProveedor(
idProveedor integer identity(1,1) not null,
idPresentacion integer not null,
diasRetardo integer not null,
precioEstandar float not null,
precioUltimaCompra float not null,
cantMinPedir integer not null,
cantMaxPedir integer not null
constraint pk_ProductosProveedor primary key(idProveedor,idPresentacion),
CONSTRAINT fk_ProductosProveedor_Proveedores FOREIGN KEY(idProveedor) REFERENCES Proveedores(idProveedor),
CONSTRAINT fk_ProductoProveedor_PresentacionesProducto FOREIGN KEY(idPresentacion) REFERENCES PresentacionesProductos(idPresentacion)
)

create table CuentasProveerdor(
idCuentaProveedor integer not null,
idProveedor integer not null,
noCuenta varchar(10) not null,
banco varchar(10) not null,
referenciaBancaria varchar(20) not null
constraint pk_CuentasProveedor primary key(idCuentaProveedor),
CONSTRAINT fk_CuentasProveedor_Proveedores FOREIGN KEY(idProveedor) REFERENCES Proveedores(idProveedor)
)

create table Ofertas(
idOferta integer not null,
idPresentacion integer not null,
nombre varchar(50),
descripcion varchar(100),
porDescuento float not null,
fechaInicio date not null,
fechaFin date not null,
canMinProducto integer not null,
estatus char not null,
constraint pk_Ofertas primary key(idOferta),
CONSTRAINT fk_ofertas_presentacionesProducto FOREIGN KEY(idPresentacion) REFERENCES PresentacionesProductos(idPresentacion)
)
create table Sucursales(
idSucursal integer not null,
idCiudad integer not null,
nombre varchar(50),
telefono varchar(15),
direccion varchar(80),
colonia varchar(50),
codigoPostal varchar(5),
presupuesto float not null,
estatus char not null,
constraint pk_Sucursales primary key (idSucursal),
constraint fk_Sucursales_Ciudades foreign key (idCiudad) references Ciudades(idCiudad)
)

create table ExistenciasSucursal(
idPresentacion integer not null,
idSucursal integer not null,
cantidad float not null,
constraint pk_ExistenciaSucursal primary key (idPresentacion, idSucursal),
constraint fk_ExistenciaSucursal_Sucursales foreign key (idSucursal) references Sucursales(idSucursal),
constraint fk_ExistenciaSucursal_PresentacionesProducto foreign key (idPresentacion) references PresentacionesProductos(idPresentacion)
)

create table Empleados(
idEmpleado integer not null,
nombre varchar(30),
apellidoPaterno varchar(30),
apellidoMaterno varchar(30),
sexo char not null,
fechaNacimiento date not null,
curp varchar(20),
estadoCivil varchar(20),
fechaContratacion date not null,
salarioDiario float not null,
nss varchar(10),
diasVacaciones integer not null,
diasPermiso integer not null,
fotografia varbinary not null,
direccion varchar(80),
colonia varchar(50),
codigoPostal varchar(5),
escolaridad varchar(80),
especialidad varchar(100),
email varchar(100),
password varchar(20),
tipo varchar(10),
estatus char not null,
idDepartamento integer not null,
idPuesto integer not null,
idCiudad integer not null,
idSucursal integer not null,
idTurno integer not null,
constraint pk_Empleados primary key (idEmpleado),
constraint fk_Empleados_Ciudades foreign key (idCiudad) references Ciudades(idCiudad),
constraint fk_Empleados_Sucursales foreign key (idSucursal) references Sucursales(idSucursal),
constraint fk_Empleados_Departamentos foreign key (idDepartamento) references Departamentos(idDepartamento),
constraint fk_Empleados_Puestos foreign key (idPuesto) references Puestos(idPuesto),
constraint fk_Empleados_Turnos foreign key (idTurno) references Turnos(idTurno)
)

CREATE TABLE Pedidos(
idPedido integer not null IDENTITY(1,1),
fechaRegistro date not null,
fechaRecepcion date not null,
totalPagar float not null,
cantidadPagada float not null,
estatus char not null,
idProveedor integer not null,
idSucursal integer not null,
idEmpleado integer not null,
CONSTRAINT pk_Pedidos PRIMARY KEY(idPedido),
CONSTRAINT fk_Pedidos_Proveedores FOREIGN KEY(idProveedor) REFERENCES Proveedores(idProveedor),
CONSTRAINT fk_Pediddos_Sucursales FOREIGN KEY(idSucursal) REFERENCES Sucursales(idSucursal),
CONSTRAINT fk_Pedidos_Empleados FOREIGN KEY(idEmpleado) REFERENCES Empleados(idEmpleado)
)
CREATE TABLE PedidoDetalle(
idPedidoDetalle integer not null IDENTITY(1,1),
cantPedida integer not null,
precioCompra float not null,
subtotal float not null,
cantRecibida integer not null,
cantRechazada integer not null,
cantAceptada float not null, 
idPedido integer not null,
idPresentacion integer not null,
CONSTRAINT pk_PedidoDetalle PRIMARY KEY(idPedidoDetalle),
CONSTRAINT fk_PedidoDetalle_Pedido FOREIGN KEY(idPedido) REFERENCES Pedidos(idPedido),
CONSTRAINT fk_PedidoDetalle_Presentacion FOREIGN KEY(idPresentacion) REFERENCES PresentacionesProductos(idPresentacion)
)
create table FormasPago(
idFormaPago integer not null,
nombre varchar(50),
estatus char not null,
constraint pk_FormasPago primary key (idFormaPago)
)

CREATE TABLE Pagos(
idPago integer not null IDENTITY(1,1),
fecha date not null,
importe float not null, 
idPedido integer not null,
idFormaPago integer not null,
CONSTRAINT pk_Pagos PRIMARY KEY(idPago),
CONSTRAINT fk_Pagos_Pedidos FOREIGN KEY(idPedido) REFERENCES Pedidos(idPedido),
CONSTRAINT fk_Pagos_FormaPago FOREIGN KEY(idFormaPago) REFERENCES FormasPago(idFormaPago),
)
create table Asistencias(
idAsistencia integer not null,
fecha date not null,
horaEntrada date not null,
horaSalida date not null,
dia varchar(10) not null,
idEmpleado integer not null
constraint pk_Asistencias primary key (idAsistencia),
constraint fk_Asistencias_Empleados foreign key (idEmpleado) references Empleados(idEmpleado)
)
create table AusenciaJustificada(	
idAusencia int not null IDENTITY(1,1),
fechaSolicitud date,
fechaInicio date,
fechaFin date,
tipo char,
idEmpleadoS int,
idEmpleadoA int,
evidencia varbinary,
motivo varchar(100),
estatus char,
constraint AusenciasJustificadas_PK primary key (idAusencia),
constraint AusenciasJustificadas_EmpleadosA_FK foreign key (idEmpleadoA) references Empleados(idEmpleado),
constraint AusenciasJustificadas_EmpleadosS_FK foreign key (idEmpleadoS) references Empleados(idEmpleado)
)
create table DocumentacionEmpleado(
idDocumento int not null IDENTITY(1,1),
nombreDocumento varchar(80),
fechaEntrega date,
documento varbinary,
idEmpleado int,
constraint pk_DocumentacionEmpleado primary key (idDocumento),
constraint fk_DocumentacionEmpleado_Empleado foreign key (idEmpleado) references Empleados(idEmpleado)
)
create table Nominas(
idNomina integer not null,
fechaElaboracion date,
fechaPago date,
subtotal float,
retenciones float,
total float,
diasTrabajados integer not null,
estatus char,
idEmpleado integer not null,
idFormaPago integer not null,
idPeriodo integer not null,
constraint pk_Nominas primary key(idNomina),
constraint fk_Nominas_Empleados foreign key (idEmpleado) references Empleados(idEmpleado),
constraint fk_Nominas_FormasPago foreign key (idFormaPago) references FormasPago(idFormaPago),
constraint fk_Nominas_Periodos foreign key (idPeriodo) references Periodos(idPeriodo)
)
create table NominasDeducciones(
idNomina integer not null,
idDeduccion integer not null,
importe float,
constraint pk_NominasDeducciones primary key(idNomina,idDeduccion),
constraint fk_NominasDeducciones_Deducciones foreign key (idDeduccion) references Deducciones(idDeduccion),
constraint fk_NominasDeducciones_Nomina foreign key (idNomina) references Nominas(idNomina)
)

create table NominasPercepciones(
idNomina integer not null,
idPercepcion integer not null,
importe float,
constraint pk_NominasPercepciones primary key (idNomina, idPercepcion),
constraint fk_NominasPercepciones_Nominas foreign key (idNomina) references Nominas(idNomina),
constraint fk_NominasPercepciones_Percepciones foreign key (idPercepcion) references Percepciones(idPercepcion)
)
create table HistorialPuestos(
idEmpleado int not null,
idPuesto int not null,
idDepartamento int not null,
fechaInicio date not null,
fechaFin date
constraint pk_HistorialPuestos primary key (fechaInicio,idEmpleado,idPuesto,idDepartamento),
constraint fk_HistorialPuestos_Empleados foreign key (idEmpleado) references Empleados(idEmpleado),
constraint fk_HistorialPuestos_Departamentos foreign key (idDepartamento) references Departamentos(idDepartamento),
constraint fk_HistorialPuestos_Puestos foreign key (idPuesto) references Puestos(idPuesto)
)
CREATE TABLE Ventas(
idVenta INTEGER IDENTITY(1,1) NOT NULL,
fecha DATE,
subtotal float,
iva float,
total FLOAT,
cantPagada FLOAT,
comentarios VARCHAR(100),
estatus CHAR,
tipo CHAR,
idCliente INTEGER,
idSucursal INTEGER,
idEmpleado INTEGER,
CONSTRAINT pk_Ventas PRIMARY KEY(idVenta),
constraint fk_Ventas_Clientes FOREIGN KEY(idCliente) REFERENCES Clientes(idCliente),
constraint fk_Ventas_Sucursal FOREIGN KEY(idSucursal) REFERENCES Sucursales(idSucursal),
constraint fk_Ventas_Empleado FOREIGN KEY(idEmpleado) REFERENCES Empleados(idEmpleado)
)

create table OfertasAsociacion(
idAsociacion integer not null,
idOferta integer not null,
estatus char not null,
constraint pk_OfertasAsociacion primary key(idAsociacion, idOferta),
constraint fk_OfertasAsociacion_Asociaciones foreign key(idAsociacion) references Asociaciones(idAsociacion),
constraint fk_OfertasAsociacion_Ofertas foreign key(idOferta) references Ofertas(idOferta)
)

create table Miembros(
idCliente integer not null,
idAsociacion integer not null,
estatus char not null,
fechaIncorporacion date not null,
constraint pk_Miembros primary key(idAsociacion, idCliente),
constraint Miembros_Clientes foreign key (idCliente) references Clientes(idCliente),
constraint Miembros_Asociaciones foreign key (idAsociacion) references Asociaciones(idAsociacion)
)
create table Direcciones_Cliente(
idDireccion integer identity (1,1) not null,
calle varchar(80),
numero varchar(15),
colonia varchar(100),
codigoPostal varchar(5),
tipo char,
idCliente integer not null,
idCiudad integer not null
constraint pk_Direccion_Cliente primary key(idCliente),
constraint fk_Direcciones_Clientes_Ciudad FOREIGN KEY (idCiudad) REFERENCES Ciudades(idCiudad),
constraint fk_Direcciones_Clientes_Clientes FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
)
create table Parcelas(
idParcela integer not null,
extencion float not null,
idCliente integer not null,
idCultivo integer not null,
idDireccion integer not null,
constraint pk_Parcelas primary key(idParcela),
constraint fk_Parcelas_Clientes foreign key (idCliente)references Clientes(idCliente),
constraint fk_Parcelas_Cultivos foreign key (idCultivo) references Cultivos(idCultivo),
)
create table Envios(
idEnvio integer identity(1,1) not null,
fechaInicio date,
fechaFin date,
idUnidadTransporte integer not null,
pesototal float not null,
constraint pk_Envios primary key (idEnvio),
constraint fk_Envios_UnidadTransporte FOREIGN KEY (idUnidadTransporte) REFERENCES UnidadesTransporte(idUnidadTransporte)
)
create table Tripulacion(
idEmpleado integer not null,
idEnvio integer not null,
rol varchar,
constraint pk_Tripulacion primary key (idEmpleado, idEnvio, rol),
constraint fk_Tripulacion_Envios foreign key (idEnvio) references Envios(idEnvio),
constraint fk_Tripulacion_Empleados foreign key (idEmpleado) references Empleados(idEmpleado)
)
create table ContactosCliente(
idContacto integer not null,
nombre varchar(100),
telefono varchar(12),
email varchar(100),
idCliente integer not null,
constraint pk_ContactosCliente primary key (idContacto),
constraint fk_ContactosCliente_Cliente foreign key (idCliente) references Clientes(idCliente)
)
create table Detalles_Envio(
 idEnvio integer identity(1,1)not null,
 idVenta integer not null,
 idDireccion integer not null,
 fechaEntregaPlaneada date,
 fechaRecepcion date,
 peso float not null,
 estatus char,
 idContacto integer not null
 constraint pk_Detalles_Envio primary key (idVenta,IdEnvio)
 constraint fk_Detalles_Envio_Envios Foreign key(idEnvio) References Envios(idEnvio),
 constraint fk_Detalles_Envio_Ventas Foreign key(idVenta) References Ventas(idVenta),
 constraint fk_Detalles_Envio_ContactosCliente Foreign key(idContacto) References ContactosCliente(idContacto)
 )
 create table Asesorias(
idAsesoria integer not null,
fecha date not null,
comentarios varchar(200),
estatus char not null,
costo float not null,
idParcela integer not null,
idEmpleado integer not null,
idUnidadTransporte integer not null,
constraint pk_Asesorias primary key (idAsesoria),
constraint fk_Asesorias_ClientesCultivos foreign key(idParcela) references Parcelas(idParcela),
constraint fk_Asesorias_UnidadesTransporte foreign key(idUnidadTransporte) references UnidadesTransporte(idUnidadTransporte),
constraint fk_Asesorias_Empleados foreign key(idEmpleado) references Empleados(idEmpleado)
)
CREATE TABLE Cobros(
idCobro INTEGER IDENTITY(1,1) NOT NULL,
fecha DATE not  null,
importe FLOAT not null,
idVenta INTEGER not null,
idFormaPago INTEGER not null,
CONSTRAINT pk_Cobros PRIMARY KEY(idCobro),
constraint fk_Cobros_Venta FOREIGN KEY (idVenta) REFERENCES Ventas(idVenta),
constraint fk_Cobros_FormaPago FOREIGN KEY (idFormaPago) REFERENCES FormasPago(idFormaPago)
)
CREATE TABLE Mantenimientos(
idMantenimiento INTEGER IDENTITY(1,1) NOT NULL,
fecha DATE,
fechaFin date,
taller VARCHAR(100),
costo FLOAT,
comentarios VARCHAR(200),
tipo VARCHAR(30),
idUnidadTransporte INTEGER,
CONSTRAINT pk_Mantenimientos PRIMARY KEY (idMantenimiento),
constraint fk_Mantenimientos_UnidadTransporte FOREIGN KEY (idUnidadTransporte) REFERENCES UnidadesTransporte(idUnidadTransporte)
)