-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: dcc078trab1
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `andamento`
--

DROP TABLE IF EXISTS `andamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `andamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idProcesso` int(11) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `andamento_processo_id_fk` (`idProcesso`),
  CONSTRAINT `andamento_processo_id_fk` FOREIGN KEY (`idProcesso`) REFERENCES `processo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `andamento`
--

LOCK TABLES `andamento` WRITE;
/*!40000 ALTER TABLE `andamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `andamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envolvidonotificacaoprocesso`
--

DROP TABLE IF EXISTS `envolvidonotificacaoprocesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `envolvidonotificacaoprocesso` (
  `processo_id` int(11) DEFAULT NULL,
  `pessoa_id` int(11) DEFAULT NULL,
  `mensagem` varchar(200) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  KEY `envolvidoNotificacaoProcesso_ pessoa_id_fk` (`pessoa_id`),
  CONSTRAINT `envolvidoNotificacaoProcesso_pessoa_id_fk` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envolvidonotificacaoprocesso`
--

LOCK TABLES `envolvidonotificacaoprocesso` WRITE;
/*!40000 ALTER TABLE `envolvidonotificacaoprocesso` DISABLE KEYS */;
INSERT INTO `envolvidonotificacaoprocesso` VALUES (1,1,'teste de mensagem','2017-10-09 16:58:58'),(1,1,'teste de mensagem','2017-10-09 17:14:21');
/*!40000 ALTER TABLE `envolvidonotificacaoprocesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `tipoDocumento` varchar(100) DEFAULT NULL,
  `numeroDocumento` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `tipo` int(11) NOT NULL,
  `login` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Julio','CPF','07228620674','julio.trindade@teste.com',1,'julio','julio'),(2,'Thassya','CPF','00000000000','thassya.abreu@teste.com',2,'thassya','thassya');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processo`
--

DROP TABLE IF EXISTS `processo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `processo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numeroProcesso` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `dataCadastro` datetime DEFAULT NULL,
  `dataBaixa` datetime DEFAULT NULL,
  `dataEncerramento` datetime DEFAULT NULL,
  `advogado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `processo_pessoa_id_fk` (`advogado`),
  CONSTRAINT `processo_pessoa_id_fk` FOREIGN KEY (`advogado`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processo`
--

LOCK TABLES `processo` WRITE;
/*!40000 ALTER TABLE `processo` DISABLE KEYS */;
INSERT INTO `processo` VALUES (1,'67899099',1,'2017-10-09 00:00:00',NULL,NULL,NULL);
/*!40000 ALTER TABLE `processo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-09 17:16:33
