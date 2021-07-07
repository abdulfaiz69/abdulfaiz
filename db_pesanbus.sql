-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2021 at 08:28 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pesanbus`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_bus`
--

CREATE TABLE `tb_bus` (
  `namaBus` varchar(255) DEFAULT NULL,
  `keberangkatan` varchar(255) DEFAULT NULL,
  `kedatangan` varchar(255) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `kodebus` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_bus`
--

INSERT INTO `tb_bus` (`namaBus`, `keberangkatan`, `kedatangan`, `harga`, `kodebus`) VALUES
('Merah Putih', 'Semarang', 'Surabaya', 150000, 'MP001'),
('Garuda', 'Semarang', 'Jakarta', 180000, 'GA001'),
('Garuda', 'Semarang', 'Bandung', 145000, 'GA001'),
('Sumber Indah', 'Pekalongan', 'Yogyakarta', 80000, 'SI001');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pemesanan`
--

CREATE TABLE `tb_pemesanan` (
  `namaPembeli` varchar(255) DEFAULT NULL,
  `kodeBus` varchar(255) DEFAULT NULL,
  `namaBus` varchar(255) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
