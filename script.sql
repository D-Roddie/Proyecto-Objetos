USE [master]
GO
CREATE DATABASE [DBCorteJusticia]
GO
USE [DBCorteJusticia]
GO
CREATE TABLE tCaso(
	id_caso int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	numero_caso varchar(50) NULL,
	descripcion varchar(200) NOT NULL,
	fecha_registro date NULL,
	id_estado int NULL,
	id_juez int NULL,
	id_querellante int NULL,
	comentario_estado varchar(200) NOT NULL
)

GO
CREATE TABLE tEstado(
	[id_estado] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[nombre_estado] [varchar](50) NULL

)

GO
CREATE TABLE tHistorialCasos(
	[id_historia] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[comentario_estado] [varchar](200) NOT NULL,
	[id_estado] [int] NOT NULL,
	[id_caso] [int] NOT NULL,
	[fecha_cambio] [date] NOT NULL
)

GO
CREATE TABLE tJuez(
	[id_juez] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[nombre] [varchar](50) NULL,
	[apellido1] [varchar](50) NULL,
	[apellido2] [varchar](50) NULL,
	[cedula] [varchar](50) NULL,
	[telefono] [varchar](50) NULL,
	[numero_sala] [varchar](50) NULL,
	[usuario] [varchar](50) NULL,
	[clave] [varchar](50) NULL
)

GO
CREATE TABLE tQuerellante(
	[id_querellante] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[nombre] [varchar](50) NULL,
	[apellido1] [varchar](50) NULL,
	[apellido2] [varchar](50) NULL,
	[cedula] [varchar](50) NULL,
	[telefono] [varchar](50) NULL,
	[direccion] [varchar](255) NULL
)

GO
CREATE TABLE tSecretario(
	[id_secretario] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[nombre] [varchar](50) NULL,
	[apellido1] [varchar](50) NULL,
	[apellido2] [varchar](50) NULL,
	[telefono] [varchar](50) NULL,
	[usuario] [varchar](50) NULL,
	[clave] [varchar](50) NULL
)

GO
ALTER TABLE [dbo].[tCaso]  WITH CHECK ADD FOREIGN KEY([id_estado])
REFERENCES [dbo].[tEstado] ([id_estado])
GO
ALTER TABLE [dbo].[tCaso]  WITH CHECK ADD FOREIGN KEY([id_juez])
REFERENCES [dbo].[tJuez] ([id_juez])
GO
ALTER TABLE [dbo].[tCaso]  WITH CHECK ADD FOREIGN KEY([id_querellante])
REFERENCES [dbo].[tQuerellante] ([id_querellante])
GO
ALTER TABLE [dbo].[tHistorialCasos]  WITH CHECK ADD FOREIGN KEY([id_caso])
REFERENCES [dbo].[tCaso] ([id_caso])
GO
ALTER TABLE [dbo].[tHistorialCasos]  WITH CHECK ADD FOREIGN KEY([id_estado])
REFERENCES [dbo].[tEstado] ([id_estado])
GO


GO
CREATE PROCEDURE [dbo].[pa_registrar_juez]
	@pnombre varchar(50),
	@papellido1 varchar(50),
	@papellido2 varchar(50),
	@pcedula varchar(50),
	@ptelefono varchar(50),
	@pnumero_sala varchar(50),
	@pusuario varchar(50),
	@pclave varchar(50)
AS BEGIN
INSERT INTO tJuez(nombre,apellido1,apellido2,cedula,telefono ,numero_sala,usuario,clave)
VALUES (@pnombre,@papellido1,@papellido2,@pcedula,@ptelefono,@pnumero_sala,@pusuario,@pclave)
END;
GO


GO
CREATE PROCEDURE [dbo].[pa_registrar_querellante]
@pnombre varchar(50),
	@papellido1 varchar(50),
	@papellido2 varchar(50),
	@pcedula varchar(50),
	@ptelefono varchar(50),
	@direccion_sala varchar(255)
AS BEGIN
INSERT INTO tQuerellante(nombre,apellido1,apellido2,cedula,telefono ,direccion)
VALUES (@pnombre,@papellido1,@papellido2,@pcedula,@ptelefono,@direccion_sala)
END;
GO


GO
CREATE PROCEDURE [dbo].[pa_registrar_secretario]
@pnombre varchar(50),
	@papellido1 varchar(50),
	@papellido2 varchar(50),
	@pcedula varchar(50),
	@ptelefono varchar(50),
	@usuario varchar(50),
	@clave varchar(50)
AS BEGIN
INSERT INTO tSecretario(nombre,apellido1,apellido2,telefono ,usuario, clave)
VALUES (@pnombre,@papellido1,@papellido2,@ptelefono,@usuario, @clave)
END;
GO

insert into tEstado(nombre_estado) values ('Recibido')
insert into tEstado(nombre_estado) values ('Aceptado')
insert into tEstado(nombre_estado) values ('Consulta')
insert into tEstado(nombre_estado) values ('Rechazado')
insert into tEstado(nombre_estado) values ('Redactado')
insert into tEstado(nombre_estado) values ('Revision')
insert into tEstado(nombre_estado) values ('Resuelto')