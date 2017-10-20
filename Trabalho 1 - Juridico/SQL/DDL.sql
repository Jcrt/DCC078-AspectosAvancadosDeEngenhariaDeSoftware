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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `andamento`
--

LOCK TABLES `andamento` WRITE;
/*!40000 ALTER TABLE `andamento` DISABLE KEYS */;
INSERT INTO `andamento` VALUES (1,1,'teste','2017-10-16 00:00:00'),(2,1,'teste','2017-10-16 00:00:00'),(3,1,'teste com observer implementado','2017-10-16 00:00:00'),(4,1,'teste com observer implementado','2017-10-16 00:00:00'),(5,1,'teste com observer implementado','2017-10-16 00:00:00'),(6,1,'teste com observer implementado','2017-10-16 00:00:00'),(7,1,'tete222','2017-10-16 00:00:00'),(8,1,'tete222','2017-10-16 00:00:00'),(9,1,'tete222','2017-10-16 00:00:00'),(10,1,'hhhhhhhhhhhh','2017-10-16 00:00:00'),(11,1,'teste','2017-10-16 00:00:00'),(12,1,'rfewfwfew','2017-10-16 00:00:00'),(13,1,'hhhhhhhhhhhhhh','2017-10-16 00:00:00'),(14,1,'teste','2017-10-16 00:00:00'),(15,1,'teste','2017-10-16 00:00:00'),(16,1,'teste','2017-10-16 00:00:00'),(17,1,'teste','2017-10-16 00:00:00'),(18,1,'teste','2017-10-16 00:00:00'),(19,1,'teste','2017-10-16 00:00:00'),(20,2,'teste','2017-10-16 00:00:00'),(21,1,'teste','2017-10-16 00:00:00'),(22,1,'Opaaaa','2017-10-16 00:00:00'),(23,1,'sssss','2017-10-16 00:00:00'),(24,1,'sssss','2017-10-16 00:00:00'),(25,4,'Novo andamento deste processo','2017-10-16 00:00:00'),(26,7,'teste','2017-10-16 00:00:00'),(27,1,'Caramelo\r\n','2017-10-16 00:00:00'),(28,5,'Caracoles\r\n','2017-10-16 00:00:00'),(29,1,'ffff','2017-10-16 00:00:00'),(30,7,'teste','2017-10-17 00:00:00'),(31,1,'teste2\'','2017-10-17 00:00:00'),(32,1,'Thassya\r\n','2017-10-17 00:00:00'),(33,7,'Thassya','2017-10-17 00:00:00');
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
INSERT INTO `envolvidonotificacaoprocesso` VALUES (1,1,'teste de mensagem','2017-10-09 16:58:58'),(1,1,'teste de mensagem','2017-10-09 17:14:21'),(1,1,'Um andamento foi inserido no processo 67899099. [\"teste...\"]','2017-10-16 00:00:00'),(1,2,'Um andamento foi inserido no processo 67899099. [\"teste...\"]','2017-10-16 00:00:00'),(1,1,'Um andamento foi inserido no processo 67899099. [\"Opaaaa...\"]','2017-10-16 00:00:00'),(1,2,'Um andamento foi inserido no processo 67899099. [\"Opaaaa...\"]','2017-10-16 00:00:00'),(1,1,'Um andamento foi inserido no processo 67899099. [\"sssss...\"]','2017-10-16 20:06:07'),(1,2,'Um andamento foi inserido no processo 67899099. [\"sssss...\"]','2017-10-16 20:06:12'),(4,1,'Um andamento foi inserido no processo 3. [\"Novo andamento deste processo...\"]','2017-10-16 20:06:55'),(4,2,'Um andamento foi inserido no processo 3. [\"Novo andamento deste processo...\"]','2017-10-16 20:06:55'),(7,1,'Um andamento foi inserido no processo 5. [\"teste...\"]','2017-10-16 20:20:32'),(7,2,'Um andamento foi inserido no processo 5. [\"teste...\"]','2017-10-16 20:20:32'),(1,1,'Um andamento foi inserido no processo 67899099. [\"Caramelo\r\n...\"]','2017-10-16 20:25:11'),(1,2,'Um andamento foi inserido no processo 67899099. [\"Caramelo\r\n...\"]','2017-10-16 20:25:11'),(5,1,'Um andamento foi inserido no processo 4. [\"Caracoles\r\n...\"]','2017-10-16 20:37:09'),(5,2,'Um andamento foi inserido no processo 4. [\"Caracoles\r\n...\"]','2017-10-16 20:37:09'),(1,1,'Um andamento foi inserido no processo 67899099. [\"ffff...\"]','2017-10-16 21:09:45'),(1,2,'Um andamento foi inserido no processo 67899099. [\"ffff...\"]','2017-10-16 21:09:45'),(8,2,'O Status do processo 67899099 fol alterado para BAIXAPROVISORIA','2017-10-17 00:55:40'),(8,3,'O Status do processo 67899099 fol alterado para BAIXAPROVISORIA','2017-10-17 00:55:43'),(8,4,'O Status do processo 67899099 fol alterado para BAIXAPROVISORIA','2017-10-17 00:55:46'),(8,5,'O Status do processo 67899099 fol alterado para BAIXAPROVISORIA','2017-10-17 00:55:50'),(7,1,'O Status do processo 5 fol alterado para ARQUIVADO','2017-10-17 00:56:21'),(7,2,'O Status do processo 5 fol alterado para ARQUIVADO','2017-10-17 00:56:21'),(7,1,'O Status do processo 5 fol alterado para Baixa Provisória.','2017-10-17 01:02:26'),(7,2,'O Status do processo 5 fol alterado para Baixa Provisória.','2017-10-17 01:02:26'),(10,1,'O Status do processo  fol alterado para Baixa Provisória.','2017-10-17 01:31:51'),(10,2,'O Status do processo  fol alterado para Baixa Provisória.','2017-10-17 01:31:51'),(10,3,'O Status do processo  fol alterado para Baixa Provisória.','2017-10-17 01:31:51'),(10,6,'O Status do processo  fol alterado para Baixa Provisória.','2017-10-17 01:31:51'),(7,1,'Um andamento foi inserido no processo 0000007. [\"teste...\"]','2017-10-17 01:51:01'),(7,2,'Um andamento foi inserido no processo 0000007. [\"teste...\"]','2017-10-17 01:51:01'),(7,1,'O Status do processo 0000007 fol alterado para Ativo.','2017-10-17 17:21:14'),(7,2,'O Status do processo 0000007 fol alterado para Ativo.','2017-10-17 17:21:14'),(7,1,'Um andamento foi inserido no processo 0000007. [\"Thassya...\"]','2017-10-17 17:21:53'),(7,2,'Um andamento foi inserido no processo 0000007. [\"Thassya...\"]','2017-10-17 17:21:53');
/*!40000 ALTER TABLE `envolvidonotificacaoprocesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envolvimentoprocesso`
--

DROP TABLE IF EXISTS `envolvimentoprocesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `envolvimentoprocesso` (
  `processo_id` int(11) NOT NULL,
  `pessoa_id` int(11) NOT NULL,
  `EnvolvimentoProcessoEnum` int(11) NOT NULL,
  PRIMARY KEY (`processo_id`,`pessoa_id`),
  KEY `fk_pessoa_envolvimento` (`pessoa_id`),
  CONSTRAINT `fk_pessoa_envolvimento` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `fk_processo_envolvimento` FOREIGN KEY (`processo_id`) REFERENCES `processo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envolvimentoprocesso`
--

LOCK TABLES `envolvimentoprocesso` WRITE;
/*!40000 ALTER TABLE `envolvimentoprocesso` DISABLE KEYS */;
INSERT INTO `envolvimentoprocesso` VALUES (7,1,3),(7,2,1),(8,2,1),(8,3,2),(8,4,4),(8,5,3),(9,2,1),(9,3,2),(9,5,3),(9,6,4),(10,1,3),(10,2,1),(10,3,2),(10,6,4),(11,1,3),(11,2,1),(11,3,2),(11,4,4),(12,1,3),(12,2,1),(12,3,2),(12,4,4);
/*!40000 ALTER TABLE `envolvimentoprocesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fase`
--

DROP TABLE IF EXISTS `fase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(1000) NOT NULL,
  `tipoEnvolvimentoEnum` int(11) NOT NULL DEFAULT '3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase`
--

LOCK TABLES `fase` WRITE;
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
INSERT INTO `fase` VALUES (1,'teste',1),(2,'teste',1),(3,'teste',1),(4,'Teste 2',3),(5,'Aguardando rÃ©plica do contrÃ¡rio',3);
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Julio','CPF','07228620674','julio.trindade@teste.com',1,'julio','julio'),(2,'Thassya','CPF','00000000000','thassya.abreu@teste.com',2,'thassya','thassya'),(3,'Marco','RG','2731290387219','marco@teste.com',3,NULL,NULL),(4,'Luiz','RG','213130912-31','luiz@teste.com',4,NULL,NULL),(5,'Amanda','OAB','289382108','amanda@teste.com',1,NULL,NULL),(6,'Dario','RG','23-12930','dario@teste.com',4,NULL,NULL);
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
  `fase_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `processo_pessoa_id_fk` (`advogado`),
  KEY `fk_fase_id` (`fase_id`),
  CONSTRAINT `fk_fase_id` FOREIGN KEY (`fase_id`) REFERENCES `fase` (`id`),
  CONSTRAINT `processo_pessoa_id_fk` FOREIGN KEY (`advogado`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processo`
--

LOCK TABLES `processo` WRITE;
/*!40000 ALTER TABLE `processo` DISABLE KEYS */;
INSERT INTO `processo` VALUES (1,'0000001',2,'2017-10-09 00:00:00',NULL,NULL,NULL,NULL),(2,'0000002',1,'2017-10-16 00:00:00',NULL,NULL,NULL,NULL),(3,'0000003',1,'2017-10-16 00:00:00',NULL,NULL,NULL,NULL),(4,'0000004',1,'2017-10-16 00:00:00',NULL,NULL,NULL,NULL),(5,'0000005',2,'2017-10-16 00:00:00',NULL,NULL,NULL,NULL),(6,'0000006',4,'2017-10-16 00:00:00',NULL,NULL,NULL,NULL),(7,'0000007',1,'2017-10-16 00:00:00',NULL,NULL,NULL,NULL),(8,'0000008',3,'2017-10-16 00:00:00',NULL,NULL,NULL,NULL),(9,'0000009',1,'2017-10-16 00:00:00',NULL,NULL,NULL,NULL),(10,'0000010',3,'2017-10-17 00:00:00',NULL,NULL,NULL,NULL),(11,'67899099',1,'2017-10-20 00:00:00',NULL,NULL,NULL,4),(12,'2332131232',1,'2017-10-20 00:00:00',NULL,NULL,NULL,5);
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

-- Dump completed on 2017-10-20 15:48:40
