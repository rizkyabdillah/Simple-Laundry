-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 26 Jun 2020 pada 12.18
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 7.0.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `DETAIL_TAGIHAN`
--

CREATE TABLE `DETAIL_TAGIHAN` (
  `id_tagihan` char(8) NOT NULL,
  `id_paket` char(4) NOT NULL,
  `quantity` int(11) NOT NULL,
  `sub_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `DETAIL_TAGIHAN`
--

INSERT INTO `DETAIL_TAGIHAN` (`id_tagihan`, `id_paket`, `quantity`, `sub_total`) VALUES
('18951470', 'P001', 1, 6000),
('18951470', 'P002', 1, 7500),
('18951470', 'P003', 1, 7000),
('18951470', 'P005', 1, 10000),
('55532490', 'P001', 1, 6000),
('34819421', 'P001', 1, 6000),
('34819421', 'P002', 2, 15000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `KARYAWAN`
--

CREATE TABLE `KARYAWAN` (
  `id_user` char(16) NOT NULL,
  `nama_karyawan` varchar(45) NOT NULL,
  `jenis_kelamin` enum('Laki - Laki','Perempuan') NOT NULL,
  `no_telpon` char(13) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `KARYAWAN`
--

INSERT INTO `KARYAWAN` (`id_user`, `nama_karyawan`, `jenis_kelamin`, `no_telpon`, `alamat`) VALUES
('1234123412341234', 'Sidiq Fatonah', 'Laki - Laki', '082337819281', 'Jl. Soekarno Hatta, Malang'),
('3321332133213321', 'Samsul Arifin', 'Laki - Laki', '082337872873', 'Jl. Tidar, No.5, Malang');

-- --------------------------------------------------------

--
-- Struktur dari tabel `KONSUMEN`
--

CREATE TABLE `KONSUMEN` (
  `id_konsumen` char(16) NOT NULL,
  `nama_konsumen` varchar(45) NOT NULL,
  `jenis_kelamin` enum('Laki - Laki','Perempuan') NOT NULL,
  `no_telpon` char(13) NOT NULL,
  `tgl_jadi_konsumen` date NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `KONSUMEN`
--

INSERT INTO `KONSUMEN` (`id_konsumen`, `nama_konsumen`, `jenis_kelamin`, `no_telpon`, `tgl_jadi_konsumen`, `alamat`) VALUES
('1234123412341234', 'Untung Abdullah', 'Laki - Laki', '082333826883', '2020-06-23', 'Jl. Bandulan, Malang'),
('2345234523452345', 'Tantriana Devi', 'Perempuan', '0896753342512', '2020-06-23', 'Jl. Imam Bonjol, Probolinggo'),
('4321432134214321', 'Hasan Malik', 'Laki - Laki', '0856676726372', '2020-06-23', '2020-06-23');

-- --------------------------------------------------------

--
-- Struktur dari tabel `PAKET`
--

CREATE TABLE `PAKET` (
  `id_paket` char(4) NOT NULL,
  `nama_paket` varchar(15) NOT NULL,
  `harga_perkg` int(11) NOT NULL,
  `deskripsi_paket` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `PAKET`
--

INSERT INTO `PAKET` (`id_paket`, `nama_paket`, `harga_perkg`, `deskripsi_paket`) VALUES
('P001', 'Paket Pkn Dalam', 6000, 'Paket berisi pakaian dalam'),
('P002', 'Paket Jkt Levis', 7500, 'Paket berisi jaket levis'),
('P003', 'Paket Jkt Hodie', 7000, 'Paket berisi jaket hoodie'),
('P004', 'Paket Cln Levis', 8000, 'Paket berisi celana levis'),
('P005', 'Paket Boneka', 10000, 'Paket berisi boneka');

-- --------------------------------------------------------

--
-- Struktur dari tabel `TAGIHAN`
--

CREATE TABLE `TAGIHAN` (
  `id_tagihan` char(8) NOT NULL,
  `id_konsumen` char(16) NOT NULL,
  `id_user` char(16) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `total` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembali` int(11) NOT NULL,
  `status` enum('Dibayar','Belum Bayar') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `TAGIHAN`
--

INSERT INTO `TAGIHAN` (`id_tagihan`, `id_konsumen`, `id_user`, `tgl_transaksi`, `total`, `bayar`, `kembali`, `status`) VALUES
('18951470', '1234123412341234', '3321332133213321', '2020-06-24', 30500, 40000, 9500, 'Dibayar'),
('34819421', '1234123412341234', '0000000000000000', '2020-06-26', 21000, 25000, 4000, 'Dibayar'),
('55532490', '1234123412341234', '0000000000000000', '2020-06-24', 6000, 10000, 4000, 'Dibayar');

-- --------------------------------------------------------

--
-- Struktur dari tabel `USER`
--

CREATE TABLE `USER` (
  `id_user` char(16) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `level` enum('Admin','Karyawan') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `USER`
--

INSERT INTO `USER` (`id_user`, `username`, `password`, `level`) VALUES
('0000000000000000', 'Admin', 'Admin', 'Admin'),
('1234123412341234', 'Sidiq', 'Sidiq', 'Karyawan'),
('3321332133213321', 'Samsul', 'Samsul', 'Karyawan');

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `VIEW_DETAIL_TAGIHAN`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `VIEW_DETAIL_TAGIHAN` (
`id_tagihan` char(8)
,`id_paket` char(4)
,`nama_paket` varchar(15)
,`harga_perkg` int(11)
,`quantity` int(11)
,`sub_total` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `VIEW_KARYAWAN`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `VIEW_KARYAWAN` (
`id_user` char(16)
,`nama_karyawan` varchar(45)
,`jenis_kelamin` enum('Laki - Laki','Perempuan')
,`no_telpon` char(13)
,`alamat` text
,`username` varchar(25)
,`password` varchar(25)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `VIEW_TAGIHAN`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `VIEW_TAGIHAN` (
`id_tagihan` char(8)
,`nama_konsumen` varchar(45)
,`id_user` char(16)
,`username` varchar(25)
,`tgl_transaksi` date
,`total` int(11)
,`bayar` int(11)
,`kembali` int(11)
,`status` enum('Dibayar','Belum Bayar')
);

-- --------------------------------------------------------

--
-- Struktur untuk view `VIEW_DETAIL_TAGIHAN`
--
DROP TABLE IF EXISTS `VIEW_DETAIL_TAGIHAN`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `VIEW_DETAIL_TAGIHAN`  AS  select `DETAIL_TAGIHAN`.`id_tagihan` AS `id_tagihan`,`DETAIL_TAGIHAN`.`id_paket` AS `id_paket`,`PAKET`.`nama_paket` AS `nama_paket`,`PAKET`.`harga_perkg` AS `harga_perkg`,`DETAIL_TAGIHAN`.`quantity` AS `quantity`,`DETAIL_TAGIHAN`.`sub_total` AS `sub_total` from (`DETAIL_TAGIHAN` join `PAKET`) where (`DETAIL_TAGIHAN`.`id_paket` = `PAKET`.`id_paket`) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `VIEW_KARYAWAN`
--
DROP TABLE IF EXISTS `VIEW_KARYAWAN`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `VIEW_KARYAWAN`  AS  select `KARYAWAN`.`id_user` AS `id_user`,`KARYAWAN`.`nama_karyawan` AS `nama_karyawan`,`KARYAWAN`.`jenis_kelamin` AS `jenis_kelamin`,`KARYAWAN`.`no_telpon` AS `no_telpon`,`KARYAWAN`.`alamat` AS `alamat`,`USER`.`username` AS `username`,`USER`.`password` AS `password` from (`KARYAWAN` join `USER`) where (`KARYAWAN`.`id_user` = `USER`.`id_user`) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `VIEW_TAGIHAN`
--
DROP TABLE IF EXISTS `VIEW_TAGIHAN`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `VIEW_TAGIHAN`  AS  select `TAGIHAN`.`id_tagihan` AS `id_tagihan`,`KONSUMEN`.`nama_konsumen` AS `nama_konsumen`,`USER`.`id_user` AS `id_user`,`USER`.`username` AS `username`,`TAGIHAN`.`tgl_transaksi` AS `tgl_transaksi`,`TAGIHAN`.`total` AS `total`,`TAGIHAN`.`bayar` AS `bayar`,`TAGIHAN`.`kembali` AS `kembali`,`TAGIHAN`.`status` AS `status` from ((`TAGIHAN` join `KONSUMEN`) join `USER`) where ((`TAGIHAN`.`id_konsumen` = `KONSUMEN`.`id_konsumen`) and (`TAGIHAN`.`id_user` = `USER`.`id_user`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `DETAIL_TAGIHAN`
--
ALTER TABLE `DETAIL_TAGIHAN`
  ADD KEY `FOREIGN_PAKET` (`id_paket`),
  ADD KEY `FOREIGN_TAGIHAN` (`id_tagihan`);

--
-- Indeks untuk tabel `KARYAWAN`
--
ALTER TABLE `KARYAWAN`
  ADD PRIMARY KEY (`id_user`);

--
-- Indeks untuk tabel `KONSUMEN`
--
ALTER TABLE `KONSUMEN`
  ADD PRIMARY KEY (`id_konsumen`);

--
-- Indeks untuk tabel `PAKET`
--
ALTER TABLE `PAKET`
  ADD PRIMARY KEY (`id_paket`);

--
-- Indeks untuk tabel `TAGIHAN`
--
ALTER TABLE `TAGIHAN`
  ADD PRIMARY KEY (`id_tagihan`),
  ADD KEY `FOREIGN_KONSUMEN` (`id_konsumen`),
  ADD KEY `FOREIGN_USER1` (`id_user`);

--
-- Indeks untuk tabel `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`id_user`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `DETAIL_TAGIHAN`
--
ALTER TABLE `DETAIL_TAGIHAN`
  ADD CONSTRAINT `FOREIGN_PAKET` FOREIGN KEY (`id_paket`) REFERENCES `PAKET` (`id_paket`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FOREIGN_TAGIHAN` FOREIGN KEY (`id_tagihan`) REFERENCES `TAGIHAN` (`id_tagihan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `KARYAWAN`
--
ALTER TABLE `KARYAWAN`
  ADD CONSTRAINT `FOREIGN_USER` FOREIGN KEY (`id_user`) REFERENCES `USER` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `TAGIHAN`
--
ALTER TABLE `TAGIHAN`
  ADD CONSTRAINT `FOREIGN_KONSUMEN` FOREIGN KEY (`id_konsumen`) REFERENCES `KONSUMEN` (`id_konsumen`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FOREIGN_USER1` FOREIGN KEY (`id_user`) REFERENCES `USER` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
