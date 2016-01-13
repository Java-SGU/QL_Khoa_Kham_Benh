-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 14, 2014 at 07:44 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `khoakhambenh`
--
CREATE DATABASE IF NOT EXISTS `khoakhambenh` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `khoakhambenh`;

-- --------------------------------------------------------

--
-- Table structure for table `benhan`
--

CREATE TABLE IF NOT EXISTS `benhan` (
  `maba` int(11) NOT NULL AUTO_INCREMENT,
  `mabn` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngaykham` date NOT NULL,
  `mapk` int(11) NOT NULL,
  `bacsi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `chandoan` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ngaytaikham` date NOT NULL,
  PRIMARY KEY (`maba`),
  KEY `mabn` (`mabn`),
  KEY `phongkham` (`mapk`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `benhnhan`
--

CREATE TABLE IF NOT EXISTS `benhnhan` (
  `mabn` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `hoten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `ngaysinh` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `cmnd` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dienthoai` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tiensusk` text COLLATE utf8_unicode_ci,
  `bhyt` tinyint(1) DEFAULT NULL,
  `ngayhethan` date DEFAULT NULL,
  `vuottuyen` tinyint(1) DEFAULT NULL,
  `mabh` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngaydangky` date DEFAULT NULL,
  `mapk` int(11) NOT NULL,
  PRIMARY KEY (`mabn`),
  KEY `hoten` (`hoten`),
  KEY `mapk` (`mapk`),
  KEY `mapk_2` (`mapk`),
  KEY `mapk_3` (`mapk`),
  KEY `mapk_4` (`mapk`),
  KEY `mapk_5` (`mapk`),
  KEY `mapk_6` (`mapk`),
  KEY `mapk_7` (`mapk`),
  KEY `mapk_8` (`mapk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `benhnhan`
--

INSERT INTO `benhnhan` (`mabn`, `hoten`, `gioitinh`, `ngaysinh`, `cmnd`, `diachi`, `dienthoai`, `tiensusk`, `bhyt`, `ngayhethan`, `vuottuyen`, `mabh`, `ngaydangky`, `mapk`) VALUES
('0001', 'abcxyz', 'Nam', '1990', '31294859490', 'aaaaaaa', '0909090909', NULL, 0, '2015-01-01', 0, '', NULL, 3),
('0002', 'dkjdkfjdk', 'Nữ', '1990', '989483439', 'adkfkd', '33494394839489', NULL, 1, '2015-01-01', 0, '232323545145145', NULL, 1),
('20140513210010', 'ieuieieurieuri', 'Nam', '1973', '454545', 'aaaaaa', '344343423', NULL, 0, NULL, 0, '', NULL, 1),
('20140513215644', 'Nguyễn Văn Thành', 'Nam', '1967', '3454355464', 'Huế', '33343564534', '', 0, NULL, 0, '', NULL, 13),
('20140514210634', 'trtrr', 'Nam', '1977', '454545', 'a', '3434323', '', 0, NULL, 0, '', NULL, 1),
('20140514210707', 'eeee', 'Nữ', '2007', '34234234', 'aaaa', '432323', 'addfadfat', 1, '2015-01-01', 1, 'e423423434', NULL, 1),
('20140515000721', 'a', 'Nam', '1972', '45454', 'qqqq', '3333', 'eeee', 1, '2015-01-01', 1, '67776756', '2014-05-15', 9);

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE IF NOT EXISTS `chucvu` (
  `macv` int(4) NOT NULL AUTO_INCREMENT,
  `tencv` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`macv`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`macv`, `tencv`) VALUES
(1, 'trưởng khoa'),
(2, 'phó khoa'),
(3, 'không'),
(4, 'y tá trưởng');

-- --------------------------------------------------------

--
-- Table structure for table `chuyenkhoa`
--

CREATE TABLE IF NOT EXISTS `chuyenkhoa` (
  `mack` int(4) NOT NULL AUTO_INCREMENT,
  `tenck` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mack`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `chuyenkhoa`
--

INSERT INTO `chuyenkhoa` (`mack`, `tenck`) VALUES
(1, 'mắt'),
(2, 'thần kinh');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE IF NOT EXISTS `nguoidung` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `tendangnhap` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `manv` int(11) NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `manv` (`manv`),
  KEY `manv_2` (`manv`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`id`, `tendangnhap`, `matkhau`, `manv`, `email`) VALUES
(1, 'a', '123', 1, 'a@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE IF NOT EXISTS `nhanvien` (
  `manv` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `ngaysinh` date DEFAULT NULL,
  `cmnd` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dienthoai` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hocvi` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mack` int(4) DEFAULT NULL,
  `macv` int(4) DEFAULT NULL,
  PRIMARY KEY (`manv`),
  KEY `chuyenkhoa` (`mack`,`macv`),
  KEY `chucvu` (`macv`),
  KEY `chuyenkhoa_2` (`mack`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `hoten`, `gioitinh`, `ngaysinh`, `cmnd`, `diachi`, `dienthoai`, `hocvi`, `mack`, `macv`) VALUES
(1, 'Nguyễn Văn A', 'Nam', '1914-01-01', '34343434324', 'aaee', '', 'Y tá', 1, 1),
(3, 'b', 'Nữ', '1990-01-01', '3434334343', 'a', '433434', 'Bác sĩ', 1, 3),
(4, 'aaa', 'Nữ', '1950-04-03', '334343434', 'a', '434334', 'Y tá', 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `phongkham`
--

CREATE TABLE IF NOT EXISTS `phongkham` (
  `mapk` int(11) NOT NULL AUTO_INCREMENT,
  `tenpk` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mapk`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=15 ;

--
-- Dumping data for table `phongkham`
--

INSERT INTO `phongkham` (`mapk`, `tenpk`) VALUES
(1, 'Bệnh cơ xương khớp'),
(2, 'Bệnh da liễu\r\n'),
(3, 'Bệnh mắt\r\n'),
(4, 'Bệnh ngoại tổng quát'),
(5, 'Bệnh nhiệt đới'),
(6, 'Bệnh nội thần kinh\r\n'),
(7, 'Bệnh nội tiết\r\n'),
(8, 'Bệnh răng hàm mặt\r\n'),
(9, 'Bệnh tai mũi họng\r\n'),
(10, 'Bệnh tiêu hoá\r\n'),
(11, 'Bệnh tim mạch\r\n'),
(12, 'Khám và chứng nhận sức khoẻ\r\n'),
(13, 'Ngoại thần kinh, thận niệu\r\n');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `benhan`
--
ALTER TABLE `benhan`
  ADD CONSTRAINT `benhan_fk_phongkham` FOREIGN KEY (`mapk`) REFERENCES `phongkham` (`mapk`),
  ADD CONSTRAINT `benhan_ibfk_1` FOREIGN KEY (`mabn`) REFERENCES `benhnhan` (`mabn`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `benhnhan`
--
ALTER TABLE `benhnhan`
  ADD CONSTRAINT `benhnhan_fk_phongkham` FOREIGN KEY (`mapk`) REFERENCES `phongkham` (`mapk`);

--
-- Constraints for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD CONSTRAINT `nguoidung_nhanvien_fk` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`macv`) REFERENCES `chucvu` (`macv`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nhanvien_ibfk_3` FOREIGN KEY (`mack`) REFERENCES `chuyenkhoa` (`mack`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
