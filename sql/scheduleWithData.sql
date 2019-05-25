# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2019-05-25 17:28:41
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "calendar"
#

DROP TABLE IF EXISTS `calendar`;
CREATE TABLE `calendar` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `section` varchar(10) DEFAULT NULL,
                            `monday` varchar(50) DEFAULT NULL,
                            `tuesday` varchar(50) DEFAULT NULL,
                            `wednesday` varchar(50) DEFAULT NULL,
                            `thursday` varchar(50) DEFAULT NULL,
                            `friday` varchar(50) DEFAULT NULL,
                            `saturday` varchar(50) DEFAULT NULL,
                            `sunday` varchar(50) DEFAULT NULL,
                            `week` varchar(10) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3538 DEFAULT CHARSET=utf8;

#
# Data for table "calendar"
#

INSERT INTO `calendar` VALUES (3458,'1-2',NULL,NULL,'打球 ',NULL,NULL,NULL,NULL,'第1周'),(3459,'3-5','英语','语文',NULL,NULL,NULL,NULL,NULL,'第1周'),(3460,'6-7',NULL,NULL,'睡觉 ',NULL,NULL,NULL,NULL,'第1周'),(3461,'8-9',NULL,'数学',NULL,NULL,'游戏 ',NULL,NULL,'第1周'),(3462,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第1周'),(3463,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第2周'),(3464,'3-5','英语','语文',NULL,NULL,NULL,NULL,NULL,'第2周'),(3465,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第2周'),(3466,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第2周'),(3467,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第2周'),(3468,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第3周'),(3469,'3-5','英语','语文',NULL,NULL,NULL,NULL,NULL,'第3周'),(3470,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第3周'),(3471,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第3周'),(3472,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第3周'),(3473,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第4周'),(3474,'3-5','英语','语文',NULL,NULL,NULL,NULL,NULL,'第4周'),(3475,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第4周'),(3476,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第4周'),(3477,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第4周'),(3478,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第5周'),(3479,'3-5','英语','语文',NULL,NULL,NULL,NULL,NULL,'第5周'),(3480,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第5周'),(3481,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第5周'),(3482,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第5周'),(3483,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第6周'),(3484,'3-5',NULL,'语文',NULL,NULL,NULL,NULL,NULL,'第6周'),(3485,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第6周'),(3486,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第6周'),(3487,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第6周'),(3488,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第7周'),(3489,'3-5',NULL,'语文',NULL,NULL,NULL,NULL,NULL,'第7周'),(3490,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第7周'),(3491,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第7周'),(3492,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第7周'),(3493,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第8周'),(3494,'3-5',NULL,'语文',NULL,NULL,NULL,NULL,NULL,'第8周'),(3495,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第8周'),(3496,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第8周'),(3497,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第8周'),(3498,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第9周'),(3499,'3-5',NULL,'语文',NULL,NULL,NULL,NULL,NULL,'第9周'),(3500,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第9周'),(3501,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第9周'),(3502,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第9周'),(3503,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第10周'),(3504,'3-5',NULL,'语文',NULL,NULL,NULL,NULL,NULL,'第10周'),(3505,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第10周'),(3506,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第10周'),(3507,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第10周'),(3508,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第11周'),(3509,'3-5',NULL,'语文',NULL,NULL,NULL,NULL,NULL,'第11周'),(3510,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第11周'),(3511,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第11周'),(3512,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第11周'),(3513,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第12周'),(3514,'3-5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第12周'),(3515,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第12周'),(3516,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第12周'),(3517,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第12周'),(3518,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第13周'),(3519,'3-5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第13周'),(3520,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第13周'),(3521,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第13周'),(3522,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第13周'),(3523,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第14周'),(3524,'3-5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第14周'),(3525,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第14周'),(3526,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第14周'),(3527,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第14周'),(3528,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第15周'),(3529,'3-5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第15周'),(3530,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第15周'),(3531,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第15周'),(3532,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第15周'),(3533,'1-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第16周'),(3534,'3-5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第16周'),(3535,'6-7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第16周'),(3536,'8-9',NULL,'数学',NULL,NULL,NULL,NULL,NULL,'第16周'),(3537,'10-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'第16周');

#
# Structure for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `name` varchar(50) NOT NULL,
                            `recordNumber` int(10) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "category"
#

INSERT INTO `category` VALUES (7,'吃饭',2),(8,'游戏',3);

#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `name` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
                          `count` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
                          `week` varchar(10) COLLATE utf8_hungarian_ci DEFAULT NULL,
                          `section` varchar(10) COLLATE utf8_hungarian_ci DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

#
# Data for table "course"
#

INSERT INTO `course` VALUES (76,'语文','11','周二','3-5'),(77,'数学','16','周二','8-9'),(78,'英语','5','周一','3-5');

#
# Structure for table "record"
#

DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `spend` int(11) NOT NULL,
                          `cid` int(11) NOT NULL,
                          `comment` varchar(255) DEFAULT NULL,
                          `date` date DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `fk_record_category` (`cid`),
                          CONSTRAINT `fk_record_category` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "record"
#

INSERT INTO `record` VALUES (10,11,8,'游戏','2019-05-22'),(11,11,7,'吃饭','2019-05-22');
