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

Create table Proveedores(
    idProveedor integer not null,
    nombre varchar(80) not null,
    telefono char(12) not null,
	email varchar(100) not null,
	direccion varchar(80) not null,
	colonia varchar(50) not null,
	codigoPostal varchar(5) not null,
	idCiudad integer not null
    constraint pk_Proveedores primary key(idProveedor),
	--CONSTRAINT fk_Proveedores_Ciudades FOREIGN KEY(idCiudad) REFERENCES Ciudades(idCiudad)
	)

	create table CuentasProveerdor(
	idCuentaProveedor integer not null,
	idProveedor integer not null,
	noCuenta varchar(10) not null,
	banco varchar(10) not null,
	referenciaBancaria varchar(20) not null
	constraint pk_CuentasProveedor primary key(idCuentaProveedor),
	--CONSTRAINT fk_CuentasProveedor_Proveedores FOREIGN KEY(idProveedor) REFERENCES Proveedores(idProveedor)
	)

	create table ContactosProveedor(
	idContacto integer not null,
	nombre varchar(80) not null,
	telefono char(12) not null,
	email varchar(12) not null,
	idProveedor integer not null
	constraint pk_ContactosProveedor primary key(idContacto),
	--CONSTRAINT fk_ContactosProveedor_Porveedores FOREIGN KEY(idProveedor) REFERENCES Proveedores(idProveedor)
	)

	create table ProductosProveedor(
	idProveedor integer not null,
	idPresentacion integer not null,
	diasRetardo integer not null,
	precioEstandar float not null,
	precioUltimaCompra float not null,
	cantMinPedir integer not null,
	cantMaxPedir integer not null
	constraint pk_ProductosProveedor primary key(idProveedor,idPresentacion),
	--CONSTRAINT fk_ProductosProveedor_Proveedores FOREIGN KEY(idProveedor) REFERENCES Proveedores(idProveedor),
	--CONSTRAINT fk_ProductoProveedor_PresentacionesProducto FOREIGN KEY(idPresentacion) REFERENCES PresentacionesProductos(idPresentacion)
	);

	create table Ciudades(
	idCiudad int not null IDENTITY(1,1),
	nombre varchar(80),
	idEstado int,
	estatus char,
	constraint Ciudades_PK primary key (idCiudad),
	constraint fk_Ciudades_Estados foreign key (idEstado) references Estados(idEstado)
	)

	create table Estados(
	idEstado int not null IDENTITY(1,1),
	nombre varchar(60),
	siglas varchar(10),
	estatus char,
	constraint Estado_PK primary key (idEstado)
	)
	create table AusenciaJustificada(
	idAusencia int not null IDENTITY(1,1),
	fechaSolicitud date,
	fechaInicio date,
	fechaFin date,
	tipo char,
	idEmpleadoS int,
	idEmpleadoA int,
	--evidencia BLOB,
	motivo varchar(100),
	estatus char,
	constraint AusenciasJustificadas_PK primary key (idAusencia),
	--constraint AusenciasJustificadas_EmpleadosA_FK foreign key (idEmpleadoA) references Empleados(idEmpleado),
	--constraint AusenciasJustificadas_EmpleadosS_FK foreign key (idEmpleadoS) references Empleados(idEmpleado)
	)

	create table Asistencias(
	idAsistencia integer not null,
	fecha date not null,
	horaEntrada date not null,
	horaSalida date not null,
	dia varchar(10) not null,
	idEmpleado integer not null
	constraint pk_Asistencias primary key (idAsistencia),
	--constraint fk_Asistencias_Empleados foreign key (idEmpleado) references Empleados(idEmpleado)
	)

	create table DocumentacionEmpleado(
	idDocumento int not null IDENTITY(1,1),
	nombreDocumento varchar(80),
	fechaEntrega date,
	documento varbinary,
	idEmpleado int,
	constraint pk_DocumentacionEmpleado primary key (idDocumento),
	--constraint fk_DocumentacionEmpleado_Empleado foreign key (idEmpleado) references Empleados(idEmpleado)
	)

	CREATE TABLE Cobros(
	idCobro INTEGER IDENTITY(1,1) NOT NULL,
	fecha DATE not  null,
	importe FLOAT not null,
	idVenta INTEGER not null,
	idFormaPago INTEGER not null,

	CONSTRAINT pk_Cobros PRIMARY KEY(idCobro),
	--constraint fk_Cobros_Venta FOREIGN KEY (idVenta) REFERENCES Ventas(idVenta),
	--constraint fk_Cobros_FormaPago FOREIGN KEY (idFormaPago) REFERENCES FormasPago(idFormaPago)
	);

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


	create table Direcciones_Cliente(
	idDireccion integer not null,
	calle varchar(80),
	numero varchar(15),
	colonia varchar(100),
	codigoPostal varchar(5),
	tipo char,
	idCliente integer not null,
	idCiudad integer not null
	constraint pk_Direccion_Cliente primary key(idCliente),
	--constraint fk_Direcciones_Clientes_Ciudad FOREIGN KEY (idCiudad) REFERENCES Ciudades(idCiudad),
	--constraint fk_Direcciones_Clientes_Ciudad FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
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
	--constraint fk_Mantenimientos_UnidadTransporte FOREIGN KEY (idUnidadTransporte) REFERENCES UnidadesTransporte(idUnidadTransporte)
	create table Empaques(
	idEmpaque integer not null,
	idUnidad integer not null,
	nombre varchar(80),
	capacidad float not null,
	estatus char not null,
	constraint pk_Empaques primary key(idEmpaque)
	)

	create table UnidadesMedida(
	idUnidad integer not null,
	nombre varchar(80),
	siglas varchar(20),
	estaus char not null,
	constraint pk_UnidadesMedida primary key(idUnidad)
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
	constraint pk_Ofertas primary key(idOferta)
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
	constraint pk_Sucursales primary key (idSucursal)
	)
)
