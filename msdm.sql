/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.24 : Database - msdm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`msdm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `msdm`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `administratorId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(10) NOT NULL,
  `position` varchar(10) NOT NULL,
  `jurisdiction` int(11) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `pwd` varchar(15) NOT NULL,
  PRIMARY KEY (`administratorId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `administrator` */

insert  into `administrator`(`administratorId`,`adminName`,`position`,`jurisdiction`,`phone`,`pwd`) values (1,'马云','总店管理员',1,'15500000000','aaa'),(2,'李云龙','分店管理员',2,'12345678901','666'),(3,'李青','分店管理员',2,'12345678933','65123'),(4,'盖伦','分店管理员',2,'12345678944','26596'),(5,'马化腾','总店管理员',1,'12345678955','bbb'),(6,'提莫','分店管理员',2,'12345678966','2952651'),(7,'赵信','分店管理员',2,'12345678977','29516'),(8,'雷军','总店管理员',1,'12345678988','ccc'),(9,'特朗普','分店管理员',2,'12345678999','29562'),(10,'孙悟空','分店管理员',2,'12345678000','89156'),(11,'唐僧','分店管理员',2,'12345678011','9815'),(13,'小曜','分店管理员',2,'16666666666','616');

/*Table structure for table `chartmessage` */

DROP TABLE IF EXISTS `chartmessage`;

CREATE TABLE `chartmessage` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(11) DEFAULT NULL,
  `receiver` varchar(11) DEFAULT NULL,
  `administratorId` int(11) DEFAULT NULL,
  `memberId` int(11) DEFAULT NULL,
  `messageText` varchar(20) DEFAULT NULL,
  `messageDate` timestamp NULL DEFAULT NULL,
  `isRead` int(1) DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

/*Data for the table `chartmessage` */

insert  into `chartmessage`(`messageId`,`sender`,`receiver`,`administratorId`,`memberId`,`messageText`,`messageDate`,`isRead`) values (1,'校园超市','高坂穗乃果',1,7,'你好！今天豆沙包八折！','2019-12-04 00:00:00',2),(2,'校园超市','高坂穗乃果',1,7,'还有其它的优惠！仅限今天~','2019-12-04 00:00:00',2),(3,'高坂穗乃果','校园超市',1,7,'好的！我知道了','2019-12-04 00:00:00',2),(4,'高坂穗乃果','校园超市',1,7,'喂喂','2019-12-04 00:00:00',2),(5,'高坂穗乃果','校园超市',1,7,'在吗？','2019-12-04 10:10:06',2),(6,'校园超市','高坂穗乃果',1,7,'你好，在的','2019-12-04 10:10:47',2),(7,'老王','校园超市',1,15,'你好，我是老王','2019-12-04 10:12:28',2),(8,'校园超市','老王',1,15,'你好，请问有什么可以帮你吗？','2019-12-04 10:13:12',2),(9,'老王','校园超市',1,15,'请问怎么退货？','2019-12-04 10:13:34',2),(48,'高坂穗乃果','校园超市',1,7,'面包优惠？','2019-12-09 15:39:57',2),(49,'校园超市','高坂穗乃果',1,7,'没有','2019-12-09 15:41:00',1);

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `memberId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `address` varchar(10) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `administratorId` int(11) DEFAULT NULL,
  `core` int(11) DEFAULT NULL,
  `pwd` varchar(15) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `level` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`memberId`) USING BTREE,
  KEY `StoreId` (`administratorId`) USING BTREE,
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`administratorId`) REFERENCES `administrator` (`administratorId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `member` */

insert  into `member`(`memberId`,`name`,`address`,`phone`,`administratorId`,`core`,`pwd`,`age`,`sex`,`level`) values (1,'张三','主校','15222222222',2,60,'333',20,'男','普通会员'),(2,'李四','主校','15333333333',4,90,'333',19,'男','普通会员'),(3,'王五','海滨','15444444444',6,85,'333',19,'男','普通会员'),(4,'赵六','海滨','15555555555',7,150,'333',21,'男','普通会员'),(5,'小红','岭师','15666666666',10,135,'333',20,'女','普通会员'),(6,'小明','海滨','15777777777',11,90,'333',20,'男','普通会员'),(7,'高坂穗乃果','音乃木阪','15502070328',1,666,'110',15,'女','超级会员'),(8,'小华','海安','15888888888',5,0,'333',20,'男','普通会员'),(9,'小六','海妙','15999999999',3,0,'333',66,'男','普通会员'),(10,'小李','蒲女','13111111111',4,0,'333',20,'男','普通会员'),(11,'小千','浦之星女子学院','13222222222',4,0,'333',16,'女','普通会员'),(15,'老王','海安','13444444444',1,0,'333',20,'男','普通会员'),(16,'小海','乌咪','13555555555',1,23333,'333',16,'女','超级会员'),(17,'小梨','浦之星','15502070320',5,0,'333',15,'女','普通会员');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `messageID` int(11) NOT NULL AUTO_INCREMENT,
  `administratorId` int(11) NOT NULL,
  `memberId` int(11) NOT NULL,
  `content` varchar(50) NOT NULL,
  `mTime` date DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `isRead` int(1) DEFAULT NULL,
  PRIMARY KEY (`messageID`) USING BTREE,
  KEY `AdministratorId` (`administratorId`) USING BTREE,
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`administratorId`) REFERENCES `administrator` (`administratorId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `message` */

insert  into `message`(`messageID`,`administratorId`,`memberId`,`content`,`mTime`,`remarks`,`isRead`) values (1,1,7,'今天到店8折优惠','2019-11-11','一天',2),(2,1,15,'买一送一','2019-10-10','无',2),(3,1,16,'九折优惠','2019-10-01','无',1),(4,5,8,'赠送饮品','2019-10-01','无',1),(5,1,7,'加油','2019-12-01','Fight',2),(6,1,16,'加油','2019-12-01','Fight',1),(7,1,15,'牛奶八折','2019-12-01','哈哈哈',2);

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `saleId` int(11) NOT NULL AUTO_INCREMENT,
  `sTime` date DEFAULT NULL,
  `income` int(11) DEFAULT NULL,
  `storeId` int(11) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`saleId`) USING BTREE,
  KEY `StoreId` (`storeId`) USING BTREE,
  CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`storeId`) REFERENCES `store` (`storeId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `sale` */

insert  into `sale`(`saleId`,`sTime`,`income`,`storeId`,`orders`,`remarks`) values (1,'2019-11-11',8000,1,900,''),(2,'2019-09-08',5000,1,600,NULL),(3,'2019-12-19',1000,2,100,'缺货'),(4,'2019-10-10',6000,6,5000,NULL),(5,'2019-11-10',3000,6,300,NULL),(6,'2019-10-15',5000,9,700,NULL),(7,'2019-12-03',6666,1,666,'库存不足'),(8,'2019-11-02',43543,1,535,NULL),(9,'2019-11-03',1253,1,5233,NULL),(10,'2019-11-04',35335,1,2535,NULL),(11,'2019-11-05',5354,1,353453,NULL),(12,'2019-11-06',5245345,1,53446,NULL),(13,'2019-11-07',25354,1,53253,NULL),(14,'2019-11-08',52153,1,5235,NULL),(15,'2019-11-09',25445,1,25423,NULL),(16,'2019-11-10',25324,1,82538,NULL),(17,'2019-12-20',2434,2,2533,NULL),(18,'2019-12-18',3463,2,56354,NULL),(19,'2019-12-17',6964,2,543,NULL),(20,'2019-12-21',4253,2,4864,NULL),(21,'2019-12-22',464,2,84646,NULL),(22,'2019-12-23',69569,2,45646,NULL),(23,'2019-12-09',6666,1,666,'哈哈');

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `storeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `address` varchar(10) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `administratorId` int(11) NOT NULL,
  `membership` int(15) DEFAULT NULL,
  PRIMARY KEY (`storeId`) USING BTREE,
  KEY `AdministratorId` (`administratorId`) USING BTREE,
  CONSTRAINT `store_ibfk_1` FOREIGN KEY (`administratorId`) REFERENCES `administrator` (`administratorId`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `store` */

insert  into `store`(`storeId`,`name`,`address`,`phone`,`administratorId`,`membership`) values (1,'校园超市','湛江海大海安','123456',1,1),(2,'校园超市（海大分店）','海大主校','987654322',2,1),(3,'校园超市（霞山分店）','霞山校区','987654323',3,1),(4,'校园超市（海滨分店）','海滨校区','987654324',4,1),(5,'水果超市','湛江','987654325',5,5),(6,'水果超市（寸金分店）','寸金校区','987654326',6,5),(7,'水果超市（岭师分店）','岭南师范','987654327',7,5),(8,'麦当劳','美国','987654328',8,8),(9,'海大麦当劳','海大主校','987654329',9,8),(10,'岭师麦当劳','岭南师范','987654330',10,8);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
