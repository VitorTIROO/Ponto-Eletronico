-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: bd_ponto
-- ------------------------------------------------------
-- Server version	5.7.22-log

 CREATE DATABASE BD_PONTO;

USE BD_PONTO;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nomefun` varchar(60) DEFAULT NULL,
  `profissao` varchar(60) DEFAULT NULL,
  `cpf` varchar(26) DEFAULT NULL,
  `dataadm` date DEFAULT NULL,
  `datanas` date DEFAULT NULL,
  `rgadm` varchar(20) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `foto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idfuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` VALUES (1,'Rafael Rodrigues Garcia','Professor','9823749879','2011-03-22','1985-01-22','2342348098',2000,'rafael.jpg')
								,(10,'Vitor Ribeiro dos Santos','Analista de Programação Jr.','05605502190','2018-05-09','1996-03-21','23156031',1600,'foto_13-07-2018-08-07-12.jpg')
                                ,(11,'João Teste','Programado Pl.','5879876','2018-06-03','2018-07-18','656466',1600,'foto_13-07-2018-09-07-25.jpg');

--
-- Table structure for table `ponto`
--

DROP TABLE IF EXISTS `ponto`;
CREATE TABLE `ponto` (
  `idponto` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idponto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ponto`
--

INSERT INTO `ponto` VALUES (1,'Entrada Serviço')
						  ,(2,'Saida Almoço')
                          ,(3,'Retorno Almoço')
                          ,(4,'Saída Serviço')
                          ,(5,'Saída Emergência')
                          ,(6,'Retorno Emergência')
                          ,(7,'Saída Férias')
                          ,(8,'Retorno Férias')
                          ,(9,'Inicio Hora Extra')
                          ,(10,'Fim Hora Extra');

--
-- Table structure for table `registro_ponto`
--

DROP TABLE IF EXISTS `registro_ponto`;
CREATE TABLE `registro_ponto` (
  `idregistro` int(11) NOT NULL AUTO_INCREMENT,
  `idfuncionario` int(11) DEFAULT NULL,
  `idponto` int(11) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`idregistro`),
  KEY `fk_funcionario_has_ponto_ponto1_idx` (`idponto`),
  KEY `fk_funcionario_has_ponto_funcionario_idx` (`idfuncionario`),
  CONSTRAINT `fk_funcionario_has_ponto_funcionario` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_has_ponto_ponto1` FOREIGN KEY (`idponto`) REFERENCES `ponto` (`idponto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `registro_ponto`
--

INSERT INTO `registro_ponto` VALUES (1,1,1,'2018-06-14 07:05:00')
								   ,(2,1,2,'2018-06-14 11:00:00')
                                   ,(3,1,3,'2018-06-14 13:04:00')
                                   ,(4,1,4,'2018-06-14 17:05:00')
                                   ,(5,1,1,'2018-06-15 07:02:00')
								   ,(6,1,2,'2018-06-15 11:09:00')
                                   ,(7,1,3,'2018-06-15 13:05:00')
                                   ,(8,1,4,'2018-06-15 17:05:00')
                                   ,(9,1,1,'2018-06-13 07:08:00')
								   ,(10,1,2,'2018-06-13 11:02:00')
                                   ,(11,1,3,'2018-06-13 13:07:00')
                                   ,(12,1,4,'2018-06-13 17:08:00')
                                   ,(13,10,1,'2018-06-14 07:01:00')
								   ,(14,10,2,'2018-06-14 11:01:00')
                                   ,(15,10,3,'2018-06-14 13:02:00')
                                   ,(16,10,4,'2018-06-14 17:08:00')
                                   ,(17,10,1,'2018-06-15 07:08:00')
								   ,(18,10,2,'2018-06-15 11:08:00')
                                   ,(19,10,3,'2018-06-15 13:05:00')
                                   ,(20,10,4,'2018-06-15 17:05:00')
                                   ,(21,10,1,'2018-06-13 07:04:00')
								   ,(22,10,2,'2018-06-13 11:04:00')
                                   ,(23,10,3,'2018-06-13 13:01:00')
                                   ,(24,10,4,'2018-06-13 17:10:00');
-- Dump completed on 2018-07-13 22:52:19
