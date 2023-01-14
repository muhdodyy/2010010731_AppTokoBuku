-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 14, 2023 at 08:57 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2010010731_buku`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

DROP TABLE IF EXISTS `buku`;
CREATE TABLE IF NOT EXISTS `buku` (
  `kd_buku` varchar(100) CHARACTER SET latin1 NOT NULL,
  `judul` varchar(100) CHARACTER SET latin1 NOT NULL,
  `penulis` varchar(100) CHARACTER SET latin1 NOT NULL,
  `harga` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`kd_buku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`kd_buku`, `judul`, `penulis`, `harga`) VALUES
('1', 'Fiksi', 'Subhan', '12000'),
('2', 'Puisi', 'Dody', '200000'),
('3', 'Sejarah Indonesia', 'Van', '30000'),
('4', 'Agama', 'Sulivan', '200000'),
('5', 'Dongeng', 'Deden', '1.000.000');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

DROP TABLE IF EXISTS `pelanggan`;
CREATE TABLE IF NOT EXISTS `pelanggan` (
  `kd_pelanggan` varchar(100) CHARACTER SET latin1 NOT NULL,
  `nama` varchar(100) CHARACTER SET latin1 NOT NULL,
  `alamat` varchar(100) CHARACTER SET latin1 NOT NULL,
  `telp` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`kd_pelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`kd_pelanggan`, `nama`, `alamat`, `telp`) VALUES
('1', 'Yusuf', 'Jakarta', '082152994710'),
('2', 'Yon', 'Palangkaraya', '082152994766'),
('3', 'Soya', 'Kapuas', '082152774510');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

DROP TABLE IF EXISTS `penjualan`;
CREATE TABLE IF NOT EXISTS `penjualan` (
  `kd_penjualan` varchar(100) CHARACTER SET latin1 NOT NULL,
  `kd_pelanggan` varchar(100) CHARACTER SET latin1 NOT NULL,
  `kd_buku` varchar(100) CHARACTER SET latin1 NOT NULL,
  `jumlah` varchar(100) CHARACTER SET latin1 NOT NULL,
  `harga` varchar(100) CHARACTER SET latin1 NOT NULL,
  `hasil` varchar(100) NOT NULL,
  PRIMARY KEY (`kd_penjualan`),
  UNIQUE KEY `kd_pelanggan` (`kd_pelanggan`),
  UNIQUE KEY `kd_buku` (`kd_buku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`kd_penjualan`, `kd_pelanggan`, `kd_buku`, `jumlah`, `harga`, `hasil`) VALUES
('2', '2', '2', '4', '6000', '24000');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`kd_pelanggan`) REFERENCES `pelanggan` (`kd_pelanggan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`kd_buku`) REFERENCES `buku` (`kd_buku`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
