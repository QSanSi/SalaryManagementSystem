/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : empsys

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-06-20 10:14:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendence
-- ----------------------------
DROP TABLE IF EXISTS `attendence`;
CREATE TABLE `attendence` (
  `aid` varchar(50) NOT NULL,
  `uid` varchar(50) NOT NULL,
  `atruename` varchar(50) DEFAULT NULL,
  `aempid` varchar(50) DEFAULT NULL,
  `adept` varchar(50) DEFAULT NULL,
  `ayear` varchar(50) DEFAULT NULL,
  `amonth` varchar(50) DEFAULT NULL,
  `alatecome` int(11) DEFAULT NULL,
  `aearlyleave` int(11) DEFAULT NULL,
  `aleave` int(11) DEFAULT NULL,
  `aovertime` int(11) DEFAULT NULL,
  `anegletwork` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendence
-- ----------------------------
INSERT INTO `attendence` VALUES ('07fdbc8e-164e-4125-9da0-ecebbffcbb1e', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '郑传翔', '010', 'dept10', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('09206250-924b-441a-a2ff-2473615199f2', '9f950742-2ffa-4236-956a-4a66282d35b0', '马庆', '005', 'dept05', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('0ec4499e-a4e3-4715-9486-a12f5c02eb91', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '二狗子', '013', 'dept13', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('18e1990b-d880-4e6f-988b-3f745255e4d8', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', 'emp015', '015', 'dept15', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('1ad47c24-d095-4553-a48b-271c3e3e0c8a', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '杨欢', '009', 'dept09', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('1dc9d42f-df5e-4b23-aebd-7d9a99f78fc7', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '郑传翔', '010', 'dept10', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('21928401-9787-4a8a-9bc2-cf496c7dbb53', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '郑传翔', '010', 'dept10', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('264bda0b-b919-4586-aa57-ebcdfc595023', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', 'emp015', '015', 'dept15', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('26ec74f4-987b-422d-ab05-1e253a7e6b7b', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '代在燕', '004', 'dept04', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('27a23b30-eff7-4078-b04f-3a78701a8ede', '999db185-0832-4812-a058-88255a7273bf', 'emp016', '016', 'dept16', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('29c1ca39-dd02-439f-9411-94236c501021', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '唐历黠', '011', 'dept11', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('37b2f012-e559-4390-9ddf-722c411295ab', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '高宇航', '007', 'dept07', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('3bff3d92-fc56-485a-8157-f9acfe201442', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '高宇航', '007', 'dept07', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('415c4be9-640d-4e98-8f82-d9ed423655ab', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '江玲玲', '003', 'dept03', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('42ca0476-a862-45a6-9b58-124b29c24c2a', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '张三', '012', 'dept12', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('51027571-5874-4873-a2b7-5899c31f02d2', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '张三', '012', 'dept12', '2018', '3', '3', '2', '1', '4', '6');
INSERT INTO `attendence` VALUES ('54da3596-5dc8-4360-aae8-a2e379f9f463', '55984964-7720-4b74-a5f6-3d6f14c61d60', 'emp014', '014', 'dept14', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('5c5adcc7-c95f-4612-bc62-58609278ac2b', '9f950742-2ffa-4236-956a-4a66282d35b0', '马庆', '005', 'dept05', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('66c5cb1d-1202-4e09-b735-d980967d220f', '9badba88-8fb9-4841-91d4-74eb3439b881', 'emp018', '018', 'dept18', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('74832f4e-3980-486b-9542-5b6445b4ab12', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '二狗子', '013', 'dept13', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('7b59c48b-4094-4e35-a51f-9ed94637edb7', '55984964-7720-4b74-a5f6-3d6f14c61d60', 'emp014', '014', 'dept14', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('7ce16e88-4ec5-4a2e-9ffe-6763388c69ef', 'b4dba208-5357-449b-9501-90567bb09cfa', 'emp017', '017', 'dept17', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('7d93aff5-9f7a-4399-9789-1d084e735667', '96d992b0-b544-4384-ad74-7284bf88f524', '卿三思', '001', '人事部', '2019', '6', '0', '2', '0', '5', '0');
INSERT INTO `attendence` VALUES ('87babc39-0dba-4446-b5cd-139fd1d879cf', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', 'emp015', '015', 'dept15', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('8a3422d0-edb8-49de-845b-6859b01f661a', '97f67988-35b2-4e8c-97d9-486255dfc19b', '魏夕枚', '002', '财务部', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('8b6526cb-0446-49aa-bc35-8f934d7566f5', '97f67988-35b2-4e8c-97d9-486255dfc19b', '魏夕枚', '002', '财务部', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('8cbe32ce-cfdb-40f7-8a5b-37674c6e0884', '999db185-0832-4812-a058-88255a7273bf', 'emp016', '016', 'dept16', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('90841db4-8756-4960-aae3-c94d7172409e', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '杨欢', '009', 'dept09', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('918e62b0-2a6b-472b-9df8-fc8f7b361560', '9badba88-8fb9-4841-91d4-74eb3439b881', 'emp018', '018', 'dept18', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('936e5668-f125-4ca8-8221-4c750f6cace6', '97f67988-35b2-4e8c-97d9-486255dfc19b', '魏夕枚', '002', '财务部', '2018', '4', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('946253e9-d911-4522-8c85-f5be0954db4c', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '沈鑫', '008', 'dept08', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('a3981feb-cbf5-482d-a891-647e53ae15c6', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '江玲玲', '003', 'dept03', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('a49bba70-7580-4d02-bc76-596dfd970471', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '钟源源', '006', 'dept06', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('a627cf65-ade8-4b9b-82a8-3dab120d18f9', 'b4dba208-5357-449b-9501-90567bb09cfa', 'emp017', '017', 'dept17', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('a860fc80-5581-4593-8794-e3f895006939', '96d992b0-b544-4384-ad74-7284bf88f524', '卿三思', '001', '人事部', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('af175342-cf3f-4253-8b28-c25b53167207', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '钟源源', '006', 'dept06', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('b070b110-af7e-421c-b039-4f7801010320', '97f67988-35b2-4e8c-97d9-486255dfc19b', '魏夕枚', '002', '财务部', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('b150a35e-6e65-4931-be7a-19c27df03fc5', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '沈鑫', '008', 'dept08', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('b15450a9-a511-4f36-ba63-e97b71c5f36b', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '钟源源', '006', 'dept06', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('b2ecb7d9-cc70-4edd-a539-1e8bd024d8fa', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '代在燕', '004', 'dept04', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('b6aeda1a-54a0-4d89-92cc-4f9fb63db1f7', 'b4dba208-5357-449b-9501-90567bb09cfa', 'emp017', '017', 'dept17', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('c00d6747-6d81-4fb5-940f-d7369eefb96b', '9f950742-2ffa-4236-956a-4a66282d35b0', '马庆', '005', 'dept05', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('c14a25e3-bc85-493c-9c12-7db57e12bf23', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '张三', '012', 'dept12', '2013', '6', '2', '2', '2', '2', '2');
INSERT INTO `attendence` VALUES ('c2ce16ed-26d0-4fd6-9f70-61b2e253a4f1', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '杨欢', '009', 'dept09', '2018', '3', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('c6dfef18-5bc6-4d25-8ba2-da6514d9069b', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '代在燕', '004', 'dept04', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('d0409d9c-45f7-492b-a704-7b333d68a765', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '唐历黠', '011', 'dept11', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('d6a8be7d-4b6e-4519-9355-4f49fee9b1d1', '9badba88-8fb9-4841-91d4-74eb3439b881', 'emp018', '018', 'dept18', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('d89d6574-da89-4965-8204-c4f2188d8e01', '96d992b0-b544-4384-ad74-7284bf88f524', '卿三思', '001', '人事部', '2018', '4', null, null, null, null, null);
INSERT INTO `attendence` VALUES ('e1ea3796-9f7d-46f0-977a-443f4056908b', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '张三', '012', 'dept12', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('e38a4c72-ed5c-402a-8827-3934da3a5d1a', '96d992b0-b544-4384-ad74-7284bf88f524', '卿三思', '001', '人事部', '2018', '3', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('e6c6fd1a-bcb8-4b71-8b11-4ba4b934f0cb', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '高宇航', '007', 'dept07', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('e9bf0b9c-5085-442b-b41a-a25fc14d51ee', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '沈鑫', '008', 'dept08', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('eac78a12-84c9-4e90-8c20-23346e996d52', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '二狗子', '013', 'dept13', '2018', '3', '8', '1', '3', '6', '2');
INSERT INTO `attendence` VALUES ('ee2da0ae-9aeb-4286-9e2b-d08d26b58f42', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '江玲玲', '003', 'dept03', '2019', '5', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('f1475e58-3964-4387-a928-6881835af079', '55984964-7720-4b74-a5f6-3d6f14c61d60', 'emp014', '014', 'dept14', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('f5aaebec-eacf-4863-9515-a5ce3674360b', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '唐历黠', '011', 'dept11', '2019', '6', '0', '0', '0', '0', '0');
INSERT INTO `attendence` VALUES ('f8e8c7dc-0b28-4db4-a585-c9cda01636b1', '999db185-0832-4812-a058-88255a7273bf', 'emp016', '016', 'dept16', '2019', '5', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for attendenceset
-- ----------------------------
DROP TABLE IF EXISTS `attendenceset`;
CREATE TABLE `attendenceset` (
  `cdept` varchar(50) NOT NULL,
  `clatecome` double NOT NULL,
  `cearlyleave` double NOT NULL,
  `cleave` double NOT NULL,
  `covertime` double NOT NULL,
  `cnegletwork` double NOT NULL,
  PRIMARY KEY (`cdept`),
  CONSTRAINT `dadept` FOREIGN KEY (`cdept`) REFERENCES `dept` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendenceset
-- ----------------------------
INSERT INTO `attendenceset` VALUES ('dept03', '10', '10', '10', '10', '10');
INSERT INTO `attendenceset` VALUES ('dept04', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept05', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept06', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept07', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept08', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept09', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept10', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept11', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept12', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept13', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept14', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept15', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept16', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept17', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept18', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('dept19', '0', '0', '0', '0', '0');
INSERT INTO `attendenceset` VALUES ('人事部', '10', '20', '200', '22', '20');
INSERT INTO `attendenceset` VALUES ('财务部', '10', '10', '10', '10', '10');

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `bid` varchar(50) NOT NULL,
  `uid` varchar(50) NOT NULL,
  `bempid` varchar(50) DEFAULT NULL,
  `btruename` varchar(50) DEFAULT NULL,
  `bsex` varchar(50) DEFAULT NULL,
  `bdept` varchar(50) DEFAULT NULL,
  `cardowner` varchar(50) DEFAULT NULL,
  `bank` varchar(50) DEFAULT NULL,
  `cardid` varchar(50) DEFAULT NULL,
  `btel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES ('001', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '013', '二狗子', '男', 'dept13', 'test001', 'test001', 'test001', '12321321312');
INSERT INTO `bank` VALUES ('002', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '008', '沈鑫', '男', 'dept08', 'test002', 'test002', 'test002', 'test008');
INSERT INTO `bank` VALUES ('003', '55984964-7720-4b74-a5f6-3d6f14c61d60', '014', 'emp014', '女', 'dept14', 'test003', 'test003', 'test003', 'test014');
INSERT INTO `bank` VALUES ('004', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '009', '杨欢', '男', 'dept09', 'test004', 'test004', 'test004', 'test009');
INSERT INTO `bank` VALUES ('005', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '003', '江玲玲', '女', 'dept03', 'test005', 'test005', 'test005', 'test003');
INSERT INTO `bank` VALUES ('006', '96d992b0-b544-4384-ad74-7284bf88f524', '001', '卿三思', '男', '人事部', 'test026', 'test006', 'test006', '18xxxx');
INSERT INTO `bank` VALUES ('007', '97f67988-35b2-4e8c-97d9-486255dfc19b', '002', '魏夕枚', '女', '财务部', 'test007', 'test007', 'test007', '18xxxx');
INSERT INTO `bank` VALUES ('008', '999db185-0832-4812-a058-88255a7273bf', '016', 'emp016', '女', 'dept16', 'test008', 'test008', 'test008', 'test016');
INSERT INTO `bank` VALUES ('009', '9badba88-8fb9-4841-91d4-74eb3439b881', '018', 'emp018', '男', 'dept18', 'test009', 'test009', 'test009', 'test018');
INSERT INTO `bank` VALUES ('010', '9f950742-2ffa-4236-956a-4a66282d35b0', '005', '马庆', '女', 'dept05', 'test010', 'test010', 'test010', 'test005');
INSERT INTO `bank` VALUES ('011', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '012', '张三', '男', 'dept12', 'test011', 'test011', 'test011', '12121212121');
INSERT INTO `bank` VALUES ('012', 'b4dba208-5357-449b-9501-90567bb09cfa', '017', 'emp017', '男', 'dept17', 'test012', 'test012', 'test012', 'test017');
INSERT INTO `bank` VALUES ('013', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', '015', 'emp015', '男', 'dept15', 'test013', 'test013', 'test013', 'test015');
INSERT INTO `bank` VALUES ('014', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '007', '高宇航', '男', 'dept07', 'test014', 'test014', 'test014', 'test007');
INSERT INTO `bank` VALUES ('015', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '011', '唐历黠', '女', 'dept11', 'test015', 'test015', 'test015', 'test011');
INSERT INTO `bank` VALUES ('016', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '010', '郑传翔', '男', 'dept10', 'test016', 'test016', 'test016', 'test010');
INSERT INTO `bank` VALUES ('017', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '004', '代在燕', '女', 'dept04', 'test017', 'test017', 'test017', 'test004');
INSERT INTO `bank` VALUES ('018', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '006', '钟源源', '男', 'dept06', 'test018', 'test018', 'test018', 'test006');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `manager` varchar(50) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('0be8f41b-ab7a-4f9a-933a-bed1fd5f182b', 'dept07', '测试', '高宇航', '007', '77777');
INSERT INTO `dept` VALUES ('1b694106-6b76-4e32-a81a-ebe0e49ddd34', 'dept18', '测试', 'emp018', '018', '01018');
INSERT INTO `dept` VALUES ('1e3d243f-08eb-4960-ad1e-de3837cac950', 'dept19', '测试', '', '019', '01019');
INSERT INTO `dept` VALUES ('42f7aa4c-c83d-4b95-9bb4-c4107dd03f9b', 'dept13', '测试', '二狗子', '013', '01013');
INSERT INTO `dept` VALUES ('4defc818-3659-43dc-ba54-0a3ab4e88642', 'dept09', '测试', '杨欢', '009', '99999');
INSERT INTO `dept` VALUES ('51902424-8b60-4bf4-bd95-1de4a98babf4', 'dept17', '测试', 'emp017', '017', '01017');
INSERT INTO `dept` VALUES ('582e5c6e-8540-47ac-b954-69f6cf8d565c', 'dept08', '测试', '沈鑫', '008', '88888');
INSERT INTO `dept` VALUES ('65a23e61-53e7-48f7-8658-8d245015695a', 'dept11', '测试', '唐历黠', '011', '01011');
INSERT INTO `dept` VALUES ('6ae77627-5685-4519-aabb-850e612a4ada', '人事部', '测试', '卿三思', '001', '11111');
INSERT INTO `dept` VALUES ('75b55ba3-ba44-41ad-b450-5eba3f599b9d', 'dept15', '测试', 'emp015', '015', '01015');
INSERT INTO `dept` VALUES ('9da9aa07-e919-4535-8679-a0b829aa3d9f', 'dept05', '测试', '马庆', '005', '55555');
INSERT INTO `dept` VALUES ('af3d1992-c5f4-4af8-877e-2edf9815bc06', 'dept04', '测试', '代在燕', '004', '44444');
INSERT INTO `dept` VALUES ('b0531d59-d7ed-4ed7-8fe4-b7de82d67a1f', 'dept10', '测试', '郑传翔', '010', '10101');
INSERT INTO `dept` VALUES ('b6697151-205a-4310-a122-fc666cd5e9a1', 'dept12', '测试', '张三', '012', '01012');
INSERT INTO `dept` VALUES ('c450d07b-e601-432c-a325-122a1210d195', 'dept03', '测试', '江玲玲', '003', '33333');
INSERT INTO `dept` VALUES ('c8145345-f796-4136-98e4-dc1ff67f7cf7', 'dept06', '测试', '钟源源', '006', '66666');
INSERT INTO `dept` VALUES ('ee440bdf-a8e6-440d-905f-1999b98d2ce0', 'dept14', '测试', 'emp014', '014', '01014');
INSERT INTO `dept` VALUES ('f3346d36-2f1f-4387-baff-7abe5f3b7ad2', 'dept16', '测试', 'emp016', '016', '01016');
INSERT INTO `dept` VALUES ('f644e4f5-9cdc-45da-aa27-72cad0706086', '财务部', '管财务的！', '魏夕枚', '002', '22222');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `uid` varchar(40) NOT NULL,
  `uempid` varchar(20) DEFAULT NULL,
  `utruename` varchar(20) DEFAULT NULL,
  `age` varchar(11) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `idnum` varchar(20) DEFAULT NULL,
  `marry` varchar(20) DEFAULT NULL,
  `polity` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `telnum` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL,
  `startdate` varchar(20) DEFAULT NULL,
  `deptname` varchar(50) DEFAULT NULL,
  `remark` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1b7f586d-dafb-45a7-92c7-a8e907fbe423', '013', '二狗子', '23', '男', '2018-03-22', '212121212', '未婚', '群众', '山西', '12321321312', '上海', '清华', '硕士', '2018-03-13', 'dept13', '测试');
INSERT INTO `emp` VALUES ('1d91f499-4c66-47bf-8e01-b6ae45fad659', '008', '沈鑫', '23', '男', '2019-06-05', 'test008', 'test008', 'test008', 'test008', 'test008', 'test008', 'test008', 'test008', '2019-06-01', 'dept08', 'test008');
INSERT INTO `emp` VALUES ('55984964-7720-4b74-a5f6-3d6f14c61d60', '014', 'emp014', 'test014', '女', '2019-06-09', 'test014', 'test014', 'test014', 'test014', 'test014', 'test014', 'test014', 'test014', '2019-06-01', 'dept14', 'test014');
INSERT INTO `emp` VALUES ('611f2d55-e706-4ddf-9940-5f8e0a0b3286', '009', '杨欢', '22', '男', '2019-06-06', 'test009', 'test009', 'test009', 'test009', 'test009', 'test009', 'test009', 'test009', '2019-06-01', 'dept09', 'test009');
INSERT INTO `emp` VALUES ('66fed0d5-2b54-4a83-a238-2296bfb76a56', '003', '江玲玲', '21', '女', '2019-06-02', 'test003', 'test003', 'test003', 'test003', 'test003', 'test003', 'test003', 'test003', '2019-06-01', 'dept03', 'test003');
INSERT INTO `emp` VALUES ('96d992b0-b544-4384-ad74-7284bf88f524', '001', '卿三思', '22', '男', '1997-09-30', '510xxxxxxxxx', '未婚', '共青团员', '四川广汉', '18xxxx', '绵阳', '绵阳师范学院', '本科', '2019-06-01', '人事部', '老板');
INSERT INTO `emp` VALUES ('97f67988-35b2-4e8c-97d9-486255dfc19b', '002', '魏夕枚', '22', '女', '1997-11-02', '510xxxxxxxxx', '未婚', '预备党员', '四川威远', '18xxxx', '绵阳师范学院', '绵阳师范学院', '本科', '2019-06-01', '财务部', '测试数据');
INSERT INTO `emp` VALUES ('999db185-0832-4812-a058-88255a7273bf', '016', 'emp016', 'test016', '女', '2019-06-11', 'test016', 'test016', 'test016', 'test016', 'test016', 'test016', 'test016', 'test016', '2019-06-02', 'dept16', 'test016');
INSERT INTO `emp` VALUES ('9badba88-8fb9-4841-91d4-74eb3439b881', '018', 'emp018', 'test018', '男', '2019-06-13', 'test018', 'test018', 'test018', 'test018', 'test018', 'test018', 'test018', 'test018', '2019-06-03', 'dept18', 'test018');
INSERT INTO `emp` VALUES ('9f950742-2ffa-4236-956a-4a66282d35b0', '005', '马庆', '23', '女', '1999-06-02', 'test005', 'test005', 'test005', 'test005', 'test005', 'test005', 'test005', 'test005', '2019-06-01', 'dept05', 'test005');
INSERT INTO `emp` VALUES ('b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '012', '张三', '32', '男', '2013-06-06', '111111111111', 'q', 'q', 'q', '12121212121', 'q', 'q', 'q', '2013-06-12', 'dept12', 'q');
INSERT INTO `emp` VALUES ('b4dba208-5357-449b-9501-90567bb09cfa', '017', 'emp017', 'test017', '男', '2019-06-12', 'test017', 'test017', 'test017', 'test017', 'test017', 'test017', 'test017', 'test017', '2019-06-03', 'dept17', 'test017');
INSERT INTO `emp` VALUES ('d07b5415-ad73-41d7-91ef-fd1ec29b01d2', '015', 'emp015', 'test015', '男', '2019-06-10', 'test015', 'test015', 'test015', 'test015', 'test015', 'test015', 'test015', 'test015', '2019-06-01', 'dept15', 'test015');
INSERT INTO `emp` VALUES ('dea355d5-1207-42f2-a3f9-f747c1f776a6', '007', '高宇航', '24', '男', '2019-06-04', 'test007', 'test007', 'test007', 'test007', 'test007', 'test007', 'test007', 'test007', '2019-06-01', 'dept07', 'test007');
INSERT INTO `emp` VALUES ('debb9c27-7393-4ac4-b609-5aa923d4f837', '011', '唐历黠', '21', '女', '2019-06-08', 'test011', 'test011', 'test011', 'test011', 'test011', 'test011', 'test011', 'test011', '2019-06-01', 'dept11', 'test011');
INSERT INTO `emp` VALUES ('e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '010', '郑传翔', '23', '男', '2019-06-07', 'test010', 'test010', 'test010', 'test010', 'test010', 'test010', 'test010', 'test010', '2019-06-01', 'dept10', 'test010');
INSERT INTO `emp` VALUES ('f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '004', '代在燕', '21', '女', '2019-06-03', 'test004', 'test004', 'test004', 'test004', 'test004', 'test004', 'test004', 'test004', '2019-06-01', 'dept04', 'test004');
INSERT INTO `emp` VALUES ('feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '006', '钟源源', '20', '男', '1998-06-02', 'test006', 'test006', 'test006', 'test006', 'test006', 'test006', 'test006', 'test006', '2019-06-01', 'dept06', 'test006');

-- ----------------------------
-- Table structure for insurance
-- ----------------------------
DROP TABLE IF EXISTS `insurance`;
CREATE TABLE `insurance` (
  `old` int(10) DEFAULT NULL,
  `unemployment` int(10) DEFAULT NULL,
  `injury` int(10) DEFAULT NULL,
  `bear` int(10) DEFAULT NULL,
  `medical` int(10) DEFAULT NULL,
  `house` int(10) DEFAULT NULL,
  `id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insurance
-- ----------------------------
INSERT INTO `insurance` VALUES ('3', '1', '1', '1', '1', '2', 'dsfasfas');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `sid` varchar(50) NOT NULL,
  `uid` varchar(50) NOT NULL,
  `sempid` varchar(50) DEFAULT NULL,
  `sdept` varchar(50) DEFAULT NULL,
  `struename` varchar(50) DEFAULT NULL,
  `syear` varchar(50) DEFAULT NULL,
  `smonth` varchar(50) DEFAULT NULL,
  `sbasesalary` double DEFAULT NULL,
  `staxsalary` double DEFAULT NULL,
  `stax` double DEFAULT NULL,
  `sfinalsalary` double unsigned DEFAULT NULL,
  `slatecome` double DEFAULT NULL,
  `searlyleave` double DEFAULT NULL,
  `sleave` double DEFAULT NULL,
  `sovertime` double DEFAULT NULL,
  `snegletwork` double DEFAULT NULL,
  `sold` double DEFAULT NULL,
  `sunemployment` double DEFAULT NULL,
  `sinjury` double DEFAULT NULL,
  `sbear` double DEFAULT NULL,
  `smedical` double DEFAULT NULL,
  `shouse` double DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES ('0505f27f-cad5-4807-a3aa-2caf98694b48', '97f67988-35b2-4e8c-97d9-486255dfc19b', '002', '财务部', '魏夕枚', '2018', '3', '30000', '22900', '2080', '25820', '0', '0', '0', '0', '0', '300', '300', '300', '300', '300', '600');
INSERT INTO `salary` VALUES ('0c6d75cc-add4-4f54-a9f7-d8fbe53d7253', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '011', 'dept11', '唐历黠', '2019', '6', '4545', '0', '0', '4226', '0', '0', '0', '0', '0', '45.45', '45.45', '45.45', '45.45', '45.45', '90.9');
INSERT INTO `salary` VALUES ('10ecdcef-5985-4708-81b0-4d14b28fbe3f', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '009', 'dept09', '杨欢', '2019', '6', '5665', '268', '8', '5260', '0', '0', '0', '0', '0', '56.65', '56.65', '56.65', '56.65', '56.65', '113.3');
INSERT INTO `salary` VALUES ('154e6be7-b75f-4ca6-8326-5ae514cc9a84', '999db185-0832-4812-a058-88255a7273bf', '016', 'dept16', 'emp016', '2018', '3', '4577', '0', '0', '4256', '0', '0', '0', '0', '0', '45.77', '45.77', '45.77', '45.77', '45.77', '91.54');
INSERT INTO `salary` VALUES ('1abd8a42-f16f-4874-ba58-acb74160f61d', '9f950742-2ffa-4236-956a-4a66282d35b0', '005', 'dept05', '马庆', '2019', '5', '5000', '0', '0', '4650', '0', '0', '0', '0', '0', '50', '50', '50', '50', '50', '100');
INSERT INTO `salary` VALUES ('1bb9b566-44e0-4e08-a2d1-9c9fd85ae5ac', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '009', 'dept09', '杨欢', '2018', '3', '5665', '268', '8', '5260', '0', '0', '0', '0', '0', '56.65', '56.65', '56.65', '56.65', '56.65', '113.3');
INSERT INTO `salary` VALUES ('1c130492-92f5-4c58-8051-66e386f9fe86', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '006', 'dept06', '钟源源', '2018', '3', '4514', '0', '0', '4198', '0', '0', '0', '0', '0', '45.14', '45.14', '45.14', '45.14', '45.14', '90.28');
INSERT INTO `salary` VALUES ('1f4420ba-68fe-43d5-9c35-fc18fdf2b198', '97f67988-35b2-4e8c-97d9-486255dfc19b', '002', '财务部', '魏夕枚', '2019', '6', '30000', '22900', '2080', '25820', '0', '0', '0', '0', '0', '300', '300', '300', '300', '300', '600');
INSERT INTO `salary` VALUES ('2023cf3b-2e2a-4157-9466-776c932042b0', '96d992b0-b544-4384-ad74-7284bf88f524', '001', '人事部', '卿三思', '2019', '6', '50000', '41495', '6889', '39606', '0', '40', '0', '110', '0', '500.7', '500.7', '500.7', '500.7', '500.7', '1001.4');
INSERT INTO `salary` VALUES ('2553d607-fbfc-4c7e-a266-4a846d3c2fcd', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '003', 'dept03', '江玲玲', '2019', '6', '3200', '0', '0', '2976', '0', '0', '0', '0', '0', '32', '32', '32', '32', '32', '64');
INSERT INTO `salary` VALUES ('28087a3a-9324-4f4f-9dcd-adf3f063380c', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '006', 'dept06', '钟源源', '2019', '6', '4514', '0', '0', '4198', '0', '0', '0', '0', '0', '45.14', '45.14', '45.14', '45.14', '45.14', '90.28');
INSERT INTO `salary` VALUES ('2d1c6a23-72e9-4d67-95b1-bcc86258eb43', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '010', 'dept10', '郑传翔', '2019', '5', '7676', '2138', '64', '7074', '0', '0', '0', '0', '0', '76.76', '76.76', '76.76', '76.76', '76.76', '153.52');
INSERT INTO `salary` VALUES ('3b702112-3371-4b79-bb76-d2e19167cbf3', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '010', 'dept10', '郑传翔', '2018', '3', '7676', '2138', '64', '7074', '0', '0', '0', '0', '0', '76.76', '76.76', '76.76', '76.76', '76.76', '153.52');
INSERT INTO `salary` VALUES ('3f2e39f4-8f8b-4fda-9626-bde73739a2a5', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '006', 'dept06', '钟源源', '2019', '5', '4514', '0', '0', '4198', '0', '0', '0', '0', '0', '45.14', '45.14', '45.14', '45.14', '45.14', '90.28');
INSERT INTO `salary` VALUES ('407e6d8f-0639-4bfa-a419-b6250a784663', '999db185-0832-4812-a058-88255a7273bf', '016', 'dept16', 'emp016', '2019', '6', '4577', '0', '0', '4256', '0', '0', '0', '0', '0', '45.77', '45.77', '45.77', '45.77', '45.77', '91.54');
INSERT INTO `salary` VALUES ('4286b1b2-57c4-4416-ac61-e88eb5e40950', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '013', 'dept13', '二狗子', '2018', '3', '7000', '1510', '45', '6465', '0', '0', '0', '0', '0', '70', '70', '70', '70', '70', '140');
INSERT INTO `salary` VALUES ('48ca6fdb-bd30-46bf-991c-7e791cd07696', '55984964-7720-4b74-a5f6-3d6f14c61d60', '014', 'dept14', 'emp014', '2018', '3', '5555', '166', '4', '5162', '0', '0', '0', '0', '0', '55.55', '55.55', '55.55', '55.55', '55.55', '111.1');
INSERT INTO `salary` VALUES ('4aedc542-e6c7-4cda-a6b9-e919d7d91682', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '012', 'dept12', '张三', '2013', '6', '6000', null, null, '947', '20', '40', '200', '44', '40', '7.44', '7.44', '7.44', '7.44', '7.44', '14.88');
INSERT INTO `salary` VALUES ('4b647629-41f9-473f-b604-7a93d2fed828', '55984964-7720-4b74-a5f6-3d6f14c61d60', '014', 'dept14', 'emp014', '2019', '6', '5555', '166', '4', '5162', '0', '0', '0', '0', '0', '55.55', '55.55', '55.55', '55.55', '55.55', '111.1');
INSERT INTO `salary` VALUES ('4cfac967-92aa-4b5d-ab4c-8970fdf6f869', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '007', 'dept07', '高宇航', '2019', '5', '6666', '1199', '35', '6164', '0', '0', '0', '0', '0', '66.66', '66.66', '66.66', '66.66', '66.66', '133.32');
INSERT INTO `salary` VALUES ('51c3a019-735d-4211-b564-4b65022ab309', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', '015', 'dept15', 'emp015', '2019', '5', '6655', '1189', '35', '6154', '0', '0', '0', '0', '0', '66.55', '66.55', '66.55', '66.55', '66.55', '133.1');
INSERT INTO `salary` VALUES ('555f93c6-d2af-418c-8c0e-f3d0e5ae3319', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '008', 'dept08', '沈鑫', '2018', '3', '7777', '2232', '66', '7166', '0', '0', '0', '0', '0', '77.77', '77.77', '77.77', '77.77', '77.77', '155.54');
INSERT INTO `salary` VALUES ('587ee8a7-eafe-40f2-95ab-4cdfc45f4e0b', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '003', 'dept03', '江玲玲', '2018', '3', '3200', '0', '0', '2976', '0', '0', '0', '0', '0', '32', '32', '32', '32', '32', '64');
INSERT INTO `salary` VALUES ('593c58f9-fc82-4669-82ad-767b8c991a5a', '9f950742-2ffa-4236-956a-4a66282d35b0', '005', 'dept05', '马庆', '2018', '3', '5000', '0', '0', '4650', '0', '0', '0', '0', '0', '50', '50', '50', '50', '50', '100');
INSERT INTO `salary` VALUES ('595f2e67-e28f-4bca-8086-ea8187866e54', '55984964-7720-4b74-a5f6-3d6f14c61d60', '014', 'dept14', 'emp014', '2019', '5', '5555', '166', '4', '5162', '0', '0', '0', '0', '0', '55.55', '55.55', '55.55', '55.55', '55.55', '111.1');
INSERT INTO `salary` VALUES ('59823ef5-425e-43d5-8858-5d2dc7b6b83f', 'b4dba208-5357-449b-9501-90567bb09cfa', '017', 'dept17', 'emp017', '2019', '6', '1234', '0', '0', '1147', '0', '0', '0', '0', '0', '12.34', '12.34', '12.34', '12.34', '12.34', '24.68');
INSERT INTO `salary` VALUES ('5cf415c4-d246-468e-9e48-9a9d57bc7d49', '9badba88-8fb9-4841-91d4-74eb3439b881', '018', 'dept18', 'emp018', '2019', '5', '2345', '0', '0', '2180', '0', '0', '0', '0', '0', '23.45', '23.45', '23.45', '23.45', '23.45', '46.9');
INSERT INTO `salary` VALUES ('64ccaecb-8354-44ba-987c-ed64da179755', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '012', 'dept12', '张三', '2019', '5', '5000', '0', '0', '4650', '0', '0', '0', '0', '0', '50', '50', '50', '50', '50', '100');
INSERT INTO `salary` VALUES ('7011b468-05e7-42ce-8e8d-2fad7a42cd94', '9badba88-8fb9-4841-91d4-74eb3439b881', '018', 'dept18', 'emp018', '2019', '6', '2345', '0', '0', '2180', '0', '0', '0', '0', '0', '23.45', '23.45', '23.45', '23.45', '23.45', '46.9');
INSERT INTO `salary` VALUES ('73153890-a05e-498c-b021-622511048623', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '013', 'dept13', '二狗子', '2019', '5', '7000', '1510', '45', '6465', '0', '0', '0', '0', '0', '70', '70', '70', '70', '70', '140');
INSERT INTO `salary` VALUES ('74eae684-f668-48de-8914-ed4fc965c28e', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '013', 'dept13', '二狗子', '2019', '6', '7000', '1510', '45', '6465', '0', '0', '0', '0', '0', '70', '70', '70', '70', '70', '140');
INSERT INTO `salary` VALUES ('755a7a35-1b70-49a7-93ca-2b76cbdfc6af', '999db185-0832-4812-a058-88255a7273bf', '016', 'dept16', 'emp016', '2019', '5', '4577', '0', '0', '4256', '0', '0', '0', '0', '0', '45.77', '45.77', '45.77', '45.77', '45.77', '91.54');
INSERT INTO `salary` VALUES ('75cf5c12-ca7c-4205-9d0e-0f4cfe43fc0a', 'b4dba208-5357-449b-9501-90567bb09cfa', '017', 'dept17', 'emp017', '2019', '5', '1234', '0', '0', '1147', '0', '0', '0', '0', '0', '12.34', '12.34', '12.34', '12.34', '12.34', '24.68');
INSERT INTO `salary` VALUES ('77a4ea13-1370-4590-b073-4b093b3602cb', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '009', 'dept09', '杨欢', '2019', '5', '5665', '268', '8', '5260', '0', '0', '0', '0', '0', '56.65', '56.65', '56.65', '56.65', '56.65', '113.3');
INSERT INTO `salary` VALUES ('77d795e3-45e3-4f30-9323-4b0ca8ca7a6e', '97f67988-35b2-4e8c-97d9-486255dfc19b', '002', '财务部', '魏夕枚', '2019', '5', '30000', '22900', '2080', '25820', '0', '0', '0', '0', '0', '300', '300', '300', '300', '300', '600');
INSERT INTO `salary` VALUES ('7b3cdc8a-5d64-4da0-aaeb-4dcdf3f368a4', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '011', 'dept11', '唐历黠', '2019', '5', '4545', '0', '0', '4226', '0', '0', '0', '0', '0', '45.45', '45.45', '45.45', '45.45', '45.45', '90.9');
INSERT INTO `salary` VALUES ('8a3320aa-4407-4cd3-b0c1-87b6d0cc3a2b', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '004', 'dept04', '代在燕', '2018', '3', '5460', '77', '2', '5075', '0', '0', '0', '0', '0', '54.6', '54.6', '54.6', '54.6', '54.6', '109.2');
INSERT INTO `salary` VALUES ('8e7210ac-4045-45ad-a097-0ee5c6404f36', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '013', 'dept13', '二狗子', '2018', '2', '6000', null, null, '4650', '0', '0', '0', '0', '0', '50', '50', '50', '50', '50', '100');
INSERT INTO `salary` VALUES ('9241bc0f-01dd-4d4d-94bf-e02343c060e0', '96d992b0-b544-4384-ad74-7284bf88f524', '001', '人事部', '卿三思', '2019', '5', '50000', '41500', '6890', '39610', '0', '0', '0', '0', '0', '500', '500', '500', '500', '500', '1000');
INSERT INTO `salary` VALUES ('93ff6c45-9299-4d61-8aa6-ce7318a02769', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '008', 'dept08', '沈鑫', '2019', '6', '7777', '2232', '66', '7166', '0', '0', '0', '0', '0', '77.77', '77.77', '77.77', '77.77', '77.77', '155.54');
INSERT INTO `salary` VALUES ('9ad04535-361a-4c26-82c4-247a2d904e92', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '008', 'dept08', '沈鑫', '2019', '5', '7777', '2232', '66', '7166', '0', '0', '0', '0', '0', '77.77', '77.77', '77.77', '77.77', '77.77', '155.54');
INSERT INTO `salary` VALUES ('9d025052-6f01-4049-961f-448480b4468b', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '007', 'dept07', '高宇航', '2018', '3', '6666', '1199', '35', '6164', '0', '0', '0', '0', '0', '66.66', '66.66', '66.66', '66.66', '66.66', '133.32');
INSERT INTO `salary` VALUES ('9f3f67ef-b2b2-43e5-9436-2ae3793c7d0f', '96d992b0-b544-4384-ad74-7284bf88f524', '001', '人事部', '卿三思', '2018', '3', '50000', '41500', '6890', '39610', '0', '0', '0', '0', '0', '500', '500', '500', '500', '500', '1000');
INSERT INTO `salary` VALUES ('a24aa1d5-5c5e-4d5f-a43b-39e9a1dc9d20', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '012', 'dept12', '张三', '2019', '6', '5000', '0', '0', '4650', '0', '0', '0', '0', '0', '50', '50', '50', '50', '50', '100');
INSERT INTO `salary` VALUES ('b0556577-3e78-4de1-b49c-d034d4049777', '9badba88-8fb9-4841-91d4-74eb3439b881', '018', 'dept18', 'emp018', '2018', '3', '2345', '0', '0', '2180', '0', '0', '0', '0', '0', '23.45', '23.45', '23.45', '23.45', '23.45', '46.9');
INSERT INTO `salary` VALUES ('b2d8c87d-d802-4035-8cbe-f7b53fd5c600', 'b4dba208-5357-449b-9501-90567bb09cfa', '017', 'dept17', 'emp017', '2018', '3', '1234', '0', '0', '1147', '0', '0', '0', '0', '0', '12.34', '12.34', '12.34', '12.34', '12.34', '24.68');
INSERT INTO `salary` VALUES ('c1815a47-bebd-4228-93f6-a9c7858049b6', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', '015', 'dept15', 'emp015', '2019', '6', '6655', '1189', '35', '6154', '0', '0', '0', '0', '0', '66.55', '66.55', '66.55', '66.55', '66.55', '133.1');
INSERT INTO `salary` VALUES ('c3b09b70-c451-40ee-8b36-0f171380bb1a', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '004', 'dept04', '代在燕', '2019', '6', '5460', '77', '2', '5075', '0', '0', '0', '0', '0', '54.6', '54.6', '54.6', '54.6', '54.6', '109.2');
INSERT INTO `salary` VALUES ('cf257f71-e939-4117-8866-aa3de02a30df', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '007', 'dept07', '高宇航', '2019', '6', '6666', '1199', '35', '6164', '0', '0', '0', '0', '0', '66.66', '66.66', '66.66', '66.66', '66.66', '133.32');
INSERT INTO `salary` VALUES ('d4e99c2f-d8d8-4968-a828-7463192b2689', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '012', 'dept12', '张三', '2018', '3', '5000', '0', '0', '4650', '0', '0', '0', '0', '0', '50', '50', '50', '50', '50', '100');
INSERT INTO `salary` VALUES ('d847eebd-1f13-4ce4-ab9f-7e83a334f222', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '010', 'dept10', '郑传翔', '2019', '6', '7676', '2138', '64', '7074', '0', '0', '0', '0', '0', '76.76', '76.76', '76.76', '76.76', '76.76', '153.52');
INSERT INTO `salary` VALUES ('d8703664-f89a-4e8c-8ae3-31a67ab129c4', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', '015', 'dept15', 'emp015', '2018', '3', '6655', '1189', '35', '6154', '0', '0', '0', '0', '0', '66.55', '66.55', '66.55', '66.55', '66.55', '133.1');
INSERT INTO `salary` VALUES ('eb5ab553-00cb-4cda-9a22-ab457e9aed4f', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '012', 'dept12', '张三', '2018', '2', '6000', null, null, '930', '0', '0', '0', '0', '0', '10', '10', '10', '10', '10', '20');
INSERT INTO `salary` VALUES ('f65a8f82-e0c6-4898-8ead-c8ce3441cc1c', '9f950742-2ffa-4236-956a-4a66282d35b0', '005', 'dept05', '马庆', '2019', '6', '5000', '0', '0', '4650', '0', '0', '0', '0', '0', '50', '50', '50', '50', '50', '100');
INSERT INTO `salary` VALUES ('f8b42a58-59e1-4c48-a829-04f0245d87a2', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '003', 'dept03', '江玲玲', '2019', '5', '3200', '0', '0', '2976', '0', '0', '0', '0', '0', '32', '32', '32', '32', '32', '64');
INSERT INTO `salary` VALUES ('fac2ec2c-0c43-45c8-b7ad-984903d6caa6', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '004', 'dept04', '代在燕', '2019', '5', '5460', '77', '2', '5075', '0', '0', '0', '0', '0', '54.6', '54.6', '54.6', '54.6', '54.6', '109.2');
INSERT INTO `salary` VALUES ('fbaf4a51-e433-4a78-a989-2fb07116672f', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '011', 'dept11', '唐历黠', '2018', '3', '4545', '0', '0', '4226', '0', '0', '0', '0', '0', '45.45', '45.45', '45.45', '45.45', '45.45', '90.9');

-- ----------------------------
-- Table structure for salarystandard
-- ----------------------------
DROP TABLE IF EXISTS `salarystandard`;
CREATE TABLE `salarystandard` (
  `did` varchar(50) NOT NULL,
  `dempid` varchar(50) DEFAULT NULL,
  `uid` varchar(50) DEFAULT NULL,
  `dtruename` varchar(50) DEFAULT NULL,
  `ddept` varchar(50) DEFAULT NULL,
  `dbasesalary` double DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salarystandard
-- ----------------------------
INSERT INTO `salarystandard` VALUES ('039e1f12-ba27-4f9f-a1ad-1489672933be', '001', '96d992b0-b544-4384-ad74-7284bf88f524', '卿三思', '人事部', '50000');
INSERT INTO `salarystandard` VALUES ('1a537f59-26eb-4428-9ae0-837928671702', '006', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '钟源源', 'dept06', '4514');
INSERT INTO `salarystandard` VALUES ('1f60bf1c-3ed3-4ca5-895b-cb72f709b7c8', '004', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '代在燕', 'dept04', '5460');
INSERT INTO `salarystandard` VALUES ('204c7045-dba5-49a3-9ba6-511c0639f445', '016', '999db185-0832-4812-a058-88255a7273bf', 'emp016', 'dept16', '4577');
INSERT INTO `salarystandard` VALUES ('22741a06-4d50-4400-9737-dee1a0bb23f2', '002', '97f67988-35b2-4e8c-97d9-486255dfc19b', '魏夕枚', '财务部', '30000');
INSERT INTO `salarystandard` VALUES ('30855f23-e59b-4054-aaca-5393eb200074', '003', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '江玲玲', 'dept03', '3200');
INSERT INTO `salarystandard` VALUES ('3b3a0b3e-26be-476c-91c3-017fce85add3', '011', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '唐历黠', 'dept11', '4545');
INSERT INTO `salarystandard` VALUES ('4af455c0-c8ee-4082-b27a-df70c223aae9', '007', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '高宇航', 'dept07', '6666');
INSERT INTO `salarystandard` VALUES ('5443aa0a-5341-441f-a1d9-05dae98b2c32', '012', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '张三', 'dept12', '5000');
INSERT INTO `salarystandard` VALUES ('556a9c30-d058-4d52-85b9-a49f7f62336e', '008', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '沈鑫', 'dept08', '7777');
INSERT INTO `salarystandard` VALUES ('60137000-d123-4a5f-9791-6eb656cac41b', '017', 'b4dba208-5357-449b-9501-90567bb09cfa', 'emp017', 'dept17', '1234');
INSERT INTO `salarystandard` VALUES ('7a98b1b7-d476-45d5-9d15-dc5ec432ba72', '018', '9badba88-8fb9-4841-91d4-74eb3439b881', 'emp018', 'dept18', '2345');
INSERT INTO `salarystandard` VALUES ('97ff5a9a-e1d1-4758-87d8-210b79e88a9c', '005', '9f950742-2ffa-4236-956a-4a66282d35b0', '马庆', 'dept05', '5000');
INSERT INTO `salarystandard` VALUES ('abf4a342-d65b-4baa-8d08-c7575911afca', '009', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '杨欢', 'dept09', '5665');
INSERT INTO `salarystandard` VALUES ('baabd6ac-b5f0-479e-b1fd-f08cf5159e7d', '015', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', 'emp015', 'dept15', '6655');
INSERT INTO `salarystandard` VALUES ('bd6e9f02-b6a7-4be7-97d7-cbdbf3376e12', '010', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '郑传翔', 'dept10', '7676');
INSERT INTO `salarystandard` VALUES ('f0634d74-c868-4d9d-b9dd-ef8d534fb020', '014', '55984964-7720-4b74-a5f6-3d6f14c61d60', 'emp014', 'dept14', '5555');
INSERT INTO `salarystandard` VALUES ('f8d6a8cf-be03-48ef-8cdf-22ccd640f4d9', '013', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '二狗子', 'dept13', '7000');

-- ----------------------------
-- Table structure for tax
-- ----------------------------
DROP TABLE IF EXISTS `tax`;
CREATE TABLE `tax` (
  `tid` varchar(50) NOT NULL,
  `uid` varchar(50) NOT NULL,
  `tempid` varchar(50) DEFAULT NULL,
  `ttruename` varchar(50) DEFAULT NULL,
  `tsex` varchar(50) DEFAULT NULL,
  `tidnum` varchar(50) DEFAULT NULL,
  `tdept` varchar(50) DEFAULT NULL,
  `tyear` varchar(50) DEFAULT NULL,
  `tmonth` varchar(50) DEFAULT NULL,
  `tfinalsalary` double DEFAULT NULL,
  `taxsalary` double DEFAULT NULL,
  `tax` double DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tax
-- ----------------------------
INSERT INTO `tax` VALUES ('037ad984-82c9-4990-9426-ee6edc9d600e', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '006', '钟源源', '男', 'test006', 'dept06', '2019', '5', '4198', '0', '0');
INSERT INTO `tax` VALUES ('072e19d3-1e93-466b-a639-8d4f7b8ce353', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '004', '代在燕', '女', 'test004', 'dept04', '2019', '6', '5075', '77', '2');
INSERT INTO `tax` VALUES ('07f9edeb-2b22-4110-9348-6138b898494d', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '008', '沈鑫', '男', 'test008', 'dept08', '2019', '5', '7166', '2232', '66');
INSERT INTO `tax` VALUES ('0a85efdc-68a1-4c5f-bf66-04cc9ae1c955', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '007', '高宇航', '男', 'test007', 'dept07', '2019', '6', '6164', '1199', '35');
INSERT INTO `tax` VALUES ('0f7c9772-ad03-428f-9736-c54cbafd2021', '96d992b0-b544-4384-ad74-7284bf88f524', '001', '卿三思', '男', '510xxxxxxxxx', '人事部', '2019', '6', '39606', '41495', '6889');
INSERT INTO `tax` VALUES ('11dd47c8-c518-435f-b765-0e0c9fa37213', '1d91f499-4c66-47bf-8e01-b6ae45fad659', '008', '沈鑫', '男', 'test008', 'dept08', '2019', '6', '7166', '2232', '66');
INSERT INTO `tax` VALUES ('2c5a46ff-821b-4ae0-90db-0edbff5edb22', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '009', '杨欢', '男', 'test009', 'dept09', '2019', '5', '5260', '268', '8');
INSERT INTO `tax` VALUES ('2f07bd75-ce68-43bc-9482-e47628a86da3', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '011', '唐历黠', '女', 'test011', 'dept11', '2019', '5', '4226', '0', '0');
INSERT INTO `tax` VALUES ('381a3989-19f9-45d3-a135-dc332e754057', '97f67988-35b2-4e8c-97d9-486255dfc19b', '002', '魏夕枚', '女', '510xxxxxxxxx', '财务部', '2019', '6', '25820', '22900', '2080');
INSERT INTO `tax` VALUES ('38e72987-9327-4bc5-81d5-da3861a0ed96', '97f67988-35b2-4e8c-97d9-486255dfc19b', '002', '魏夕枚', '女', '510xxxxxxxxx', '财务部', '2019', '5', '25820', '22900', '2080');
INSERT INTO `tax` VALUES ('3e9b1df8-a177-47f8-8938-81150354b805', 'b4dba208-5357-449b-9501-90567bb09cfa', '017', 'emp017', '男', 'test017', 'dept17', '2019', '6', '1147', '0', '0');
INSERT INTO `tax` VALUES ('44b2792a-0e39-4eca-a979-799750144708', '55984964-7720-4b74-a5f6-3d6f14c61d60', '014', 'emp014', '女', 'test014', 'dept14', '2019', '6', '5162', '166', '4');
INSERT INTO `tax` VALUES ('461d845b-567f-44a8-803d-8d0053707ece', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', '015', 'emp015', '男', 'test015', 'dept15', '2019', '5', '6154', '1189', '35');
INSERT INTO `tax` VALUES ('46ed5620-0804-4595-b59b-a7953cdd24b9', '9f950742-2ffa-4236-956a-4a66282d35b0', '005', '马庆', '女', 'test005', 'dept05', '2019', '5', '4650', '0', '0');
INSERT INTO `tax` VALUES ('4c153e8c-3b0a-47a4-b781-270d61ab0e93', 'feb8b14b-ca02-4f21-9297-f3ecaf33a47c', '006', '钟源源', '男', 'test006', 'dept06', '2019', '6', '4198', '0', '0');
INSERT INTO `tax` VALUES ('521d9312-8cca-4719-a1b8-0687e71a7b66', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '012', '张三', '男', '111111111111', 'dept12', '2019', '6', '4650', '0', '0');
INSERT INTO `tax` VALUES ('5905ac3f-e279-4e63-9e88-24576955b42a', '999db185-0832-4812-a058-88255a7273bf', '016', 'emp016', '女', 'test016', 'dept16', '2019', '5', '4256', '0', '0');
INSERT INTO `tax` VALUES ('612095c1-7902-4536-aafb-bfeb1ef30470', 'f7d1630f-c338-4b47-ae0a-74ba1b75ff70', '004', '代在燕', '女', 'test004', 'dept04', '2019', '5', '5075', '77', '2');
INSERT INTO `tax` VALUES ('64583cd2-8bb9-4f83-af19-b33d0103d7b8', '611f2d55-e706-4ddf-9940-5f8e0a0b3286', '009', '杨欢', '男', 'test009', 'dept09', '2019', '6', '5260', '268', '8');
INSERT INTO `tax` VALUES ('65f5c9df-68e6-479e-bc4c-5d66908b5755', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '010', '郑传翔', '男', 'test010', 'dept10', '2019', '6', '7074', '2138', '64');
INSERT INTO `tax` VALUES ('679a0d83-63e3-4269-bb07-ce64246c2056', '9badba88-8fb9-4841-91d4-74eb3439b881', '018', 'emp018', '男', 'test018', 'dept18', '2019', '6', '2180', '0', '0');
INSERT INTO `tax` VALUES ('693f4546-30c0-4081-af17-57380eb78063', '999db185-0832-4812-a058-88255a7273bf', '016', 'emp016', '女', 'test016', 'dept16', '2019', '6', '4256', '0', '0');
INSERT INTO `tax` VALUES ('6ab0904c-d75f-4fa6-b8ba-6fab149f3717', 'b4dba208-5357-449b-9501-90567bb09cfa', '017', 'emp017', '男', 'test017', 'dept17', '2019', '5', '1147', '0', '0');
INSERT INTO `tax` VALUES ('7b968167-6888-4bd5-b61f-319352317133', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '003', '江玲玲', '女', 'test003', 'dept03', '2019', '6', '2976', '0', '0');
INSERT INTO `tax` VALUES ('7c6a1a46-7b76-44fc-8bec-4361ddfe9286', '9badba88-8fb9-4841-91d4-74eb3439b881', '018', 'emp018', '男', 'test018', 'dept18', '2019', '5', '2180', '0', '0');
INSERT INTO `tax` VALUES ('8299e805-45d7-4d54-ad06-82847b419657', 'debb9c27-7393-4ac4-b609-5aa923d4f837', '011', '唐历黠', '女', 'test011', 'dept11', '2019', '6', '4226', '0', '0');
INSERT INTO `tax` VALUES ('876c7f84-d24c-4b02-a2ef-4ccccea8caea', '9f950742-2ffa-4236-956a-4a66282d35b0', '005', '马庆', '女', 'test005', 'dept05', '2019', '6', '4650', '0', '0');
INSERT INTO `tax` VALUES ('8c7b7483-bdec-4991-a8b3-dbd127af047c', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '013', '二狗子', '男', '212121212', 'dept13', '2019', '6', '6465', '1510', '45');
INSERT INTO `tax` VALUES ('9d53ce82-fe6d-4014-91dc-8123a71576e6', 'b1f3b81c-8dfc-4ab7-a000-6636dc0e7651', '012', '张三', '男', '111111111111', 'dept12', '2019', '5', '4650', '0', '0');
INSERT INTO `tax` VALUES ('a0a37da9-c039-448e-8ee5-d92b3bdeea8c', '96d992b0-b544-4384-ad74-7284bf88f524', '001', '卿三思', '男', '510xxxxxxxxx', '人事部', '2019', '5', '39610', '41500', '6890');
INSERT INTO `tax` VALUES ('b6b02891-bd26-4a4a-b0a4-956863fbeb71', 'e09b1ef6-25d5-4a0c-ba99-70e0e994257a', '010', '郑传翔', '男', 'test010', 'dept10', '2019', '5', '7074', '2138', '64');
INSERT INTO `tax` VALUES ('da65e297-c158-4b2f-b4b5-9b5cecffbd1a', 'd07b5415-ad73-41d7-91ef-fd1ec29b01d2', '015', 'emp015', '男', 'test015', 'dept15', '2019', '6', '6154', '1189', '35');
INSERT INTO `tax` VALUES ('dff6d819-2e22-4043-8db2-60d567b4233a', '55984964-7720-4b74-a5f6-3d6f14c61d60', '014', 'emp014', '女', 'test014', 'dept14', '2019', '5', '5162', '166', '4');
INSERT INTO `tax` VALUES ('e7a84f23-6d46-4a14-b303-8efdf1631d2c', '66fed0d5-2b54-4a83-a238-2296bfb76a56', '003', '江玲玲', '女', 'test003', 'dept03', '2019', '5', '2976', '0', '0');
INSERT INTO `tax` VALUES ('f1113614-e8ce-4340-a673-f0a7fbb366c0', '1b7f586d-dafb-45a7-92c7-a8e907fbe423', '013', '二狗子', '男', '212121212', 'dept13', '2019', '5', '6465', '1510', '45');
INSERT INTO `tax` VALUES ('f34ee097-823d-4cb3-b7f5-450b62686cf1', 'dea355d5-1207-42f2-a3f9-f747c1f776a6', '007', '高宇航', '男', 'test007', 'dept07', '2019', '5', '6164', '1199', '35');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(40) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `rights` varchar(20) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', 'super', 'super');
INSERT INTO `user` VALUES ('2', 'admin2', '123', 'emp', 'super');
INSERT INTO `user` VALUES ('3', 'admin3', '123', 'salary', 'super');
INSERT INTO `user` VALUES ('4', 'dept2', '123', 'attendence', '财务部');
INSERT INTO `user` VALUES ('a1ff21b5-771e-4e7c-b406-902885cff416', 'dept1', '123', 'attendence', '人事部');
SET FOREIGN_KEY_CHECKS=1;
