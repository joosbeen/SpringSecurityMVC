-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 07-08-2019 a las 23:59:50
-- Versión del servidor: 5.5.16
-- Versión de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `springmvcsecurity`
--
CREATE DATABASE `springmvcsecurity` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `springmvcsecurity`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `USERNAME` varchar(100) NOT NULL,
  `AUTHORITY` varchar(50) NOT NULL,
  PRIMARY KEY (`USERNAME`,`AUTHORITY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `authorities`
--

INSERT INTO `authorities` (`USERNAME`, `AUTHORITY`) VALUES
('benito', 'ROLE_USER'),
('benitojose', 'ROLE_ADMIN'),
('josebenito', 'ROLE_ADMIN'),
('loocooo', 'ROLE_ADMIN'),
('user_admin', 'ROLE_ADMIN'),
('usuario_administrador', 'ROLE_ADMIN'),
('usuario_gestor', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authority_list`
--

CREATE TABLE IF NOT EXISTS `authority_list` (
  `AUTHORITY` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`AUTHORITY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `authority_list`
--

INSERT INTO `authority_list` (`AUTHORITY`, `DESCRIPTION`) VALUES
('ROLE_ADMIN', 'Funcionalidades para el admin de la plataforma'),
('ROLE_USER', 'Funcionalidades para usuarios basicos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  `NOMBRE` varchar(100) DEFAULT NULL,
  `APELLIDOS` varchar(100) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `SEXO` varchar(1) DEFAULT NULL,
  `FECHA_ALTA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FECHA_MODIFICACION` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `HUSO_HORARIO` varchar(50) DEFAULT NULL,
  `CORREO_ELECTRONICO_PPAL` varchar(100) DEFAULT NULL,
  `TRACKING` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`USER_ID`, `USERNAME`, `PASSWORD`, `ENABLED`, `NOMBRE`, `APELLIDOS`, `FECHA_NACIMIENTO`, `SEXO`, `FECHA_ALTA`, `FECHA_MODIFICACION`, `HUSO_HORARIO`, `CORREO_ELECTRONICO_PPAL`, `TRACKING`) VALUES
(1, 'usuario_administrador', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', 1, 'MiNombre', 'MiApellido', '1975-01-16', 'M', '2019-07-29 06:33:06', '0000-00-00 00:00:00', 'hho', 'joosbeen@gmail.com', 0),
(2, 'usuario_gestor', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', 1, 'MiNombre', 'MiApellido', '1972-10-16', 'H', '2019-07-29 06:33:06', '0000-00-00 00:00:00', 'hhhh', 'codigoparatodos404@gmail.com', 1),
(3, 'benito', 'benito', 0, 'jose benito', 'garcia solano', '2019-08-12', 'H', '2019-08-05 20:42:42', '0000-00-00 00:00:00', NULL, 'horario@gmail.com', NULL),
(4, 'josebenito', 'josebenito', 0, 'jose', 'garcia', '2019-08-17', 'H', '2019-08-05 22:56:58', '0000-00-00 00:00:00', NULL, 'hora@gmail.com', NULL),
(5, 'benitojose', 'benitojose', 0, 'benito', 'garcia', '2019-08-19', 'H', '2019-08-05 23:09:11', '0000-00-00 00:00:00', NULL, 'jose@gmail.com', NULL),
(6, 'loocooo', 'loocooo', 0, 'loocooo', 'loocooo', '2019-08-24', 'H', '2019-08-06 00:57:48', '0000-00-00 00:00:00', NULL, 'loocooo@gmail.com', NULL),
(7, 'user_admin', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', 1, 'user admin', 'user admin', '2019-08-19', 'H', '2019-08-06 01:38:38', '0000-00-00 00:00:00', NULL, 'jose@gmail.com', NULL),
(8, 'usuario_administrador', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', 1, 'MiNombre', 'MiApellido', '1975-01-16', 'H', '2019-08-06 01:56:07', '0000-00-00 00:00:00', NULL, 'joosbeen@gmail.com', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
