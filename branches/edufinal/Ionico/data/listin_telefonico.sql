-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-02-2014 a las 18:47:27
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `listin_telefonico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigos`
--

CREATE TABLE IF NOT EXISTS `amigos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `calle` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `cp` int(11) NOT NULL,
  `localidad` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `provincia` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `movil` int(11) NOT NULL,
  `fijo` int(11) NOT NULL,
  `anotaciones` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Volcado de datos para la tabla `amigos`
--

INSERT INTO `amigos` (`id`, `nombre`, `apellido`, `calle`, `cp`, `localidad`, `provincia`, `movil`, `fijo`, `anotaciones`) VALUES
(1, 'pepe', 'villuela', '', 0, '', '', 111111111, 0, ''),
(2, 'pepe', 'villuelon', '', 0, '', 'Bilbao', 222222222, 0, ''),
(3, 'alfonso', 'merino', '', 0, '', '', 666666666, 0, ''),
(4, 'alfonso', 'morcuende', '', 0, '', '', 555555555, 0, ''),
(5, 'zuriÃ±e', 'menendez', '', 0, '', '', 333333333, 0, '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
