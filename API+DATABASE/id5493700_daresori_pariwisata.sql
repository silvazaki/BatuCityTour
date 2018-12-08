-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 08, 2018 at 04:39 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id5493700_daresori_pariwisata`
--

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(5) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL,
  `gambar` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`, `gambar`) VALUES
(1, 'Taman Kota', 'img-kategori/1.jpg'),
(2, 'Rekreasi', 'img-kategori/2.jpg'),
(4, 'Museum', 'img-kategori/4.jpg'),
(5, 'Wisata Alam', 'img-kategori/5.jpg'),
(6, 'Argowisata', 'img-kategori/6.jpg'),
(7, 'Air Terjun', 'img-kategori/7.jpg'),
(8, 'Gunung', 'img-kategori/8.jpg'),
(9, 'Pemandian Air Hangat', 'img-kategori/9.jpg'),
(10, 'Pasar', 'img-kategori/10.jpg'),
(11, 'Goa', 'img-kategori/11.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `kategori_harga`
--

CREATE TABLE `kategori_harga` (
  `id_kategori_harga` int(5) NOT NULL,
  `jenis_kategori` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `kategori_harga`
--

INSERT INTO `kategori_harga` (`id_kategori_harga`, `jenis_kategori`) VALUES
(1, 'Murah'),
(2, 'Sedang'),
(3, 'Mahal');

-- --------------------------------------------------------

--
-- Table structure for table `komentar`
--

CREATE TABLE `komentar` (
  `id_komentar` int(11) NOT NULL,
  `id_wisata` int(11) NOT NULL,
  `id_user` int(10) NOT NULL,
  `komentar` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `komentar`
--

INSERT INTO `komentar` (`id_komentar`, `id_wisata`, `id_user`, `komentar`) VALUES
(1, 1, 1, 'testing komentar'),
(2, 1, 2, 'yo yo yo ayo'),
(3, 2, 1, 'kita datang lihat menang'),
(5, 1, 1, 'jvxzdgi kkjgzxb'),
(6, 1, 1, 'bagusnya alun alun batu'),
(7, 7, 1, 'ini dimana ya, kok ga pernah tau?'),
(8, 9, 1, 'ksoskab'),
(9, 1, 1, 'tempat ini bagus ');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`) VALUES
(1, 'silva', 'silva'),
(2, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `wisata`
--

CREATE TABLE `wisata` (
  `id_wisata` int(11) NOT NULL,
  `id_kategori` int(5) NOT NULL,
  `id_kategori_harga` int(5) NOT NULL,
  `nama_wisata` varchar(50) NOT NULL,
  `detail_wisata` varchar(255) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `no_telepon` varchar(12) NOT NULL,
  `gambar` varchar(255) NOT NULL,
  `jadwal_buka` varchar(25) NOT NULL,
  `harga_tiket` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wisata`
--

INSERT INTO `wisata` (`id_wisata`, `id_kategori`, `id_kategori_harga`, `nama_wisata`, `detail_wisata`, `latitude`, `longitude`, `alamat`, `no_telepon`, `gambar`, `jadwal_buka`, `harga_tiket`) VALUES
(1, 1, 1, 'Alun Alun Batu', 'Alun-Alun Kota Batu bukanlah alun-alun biasa yang berisi lapangan dan taman saja. Di sini pengunjung akan dibuat takjub dengan aneka fasilitas pendukung yang keren.  ', -7.871101, 112.526748, 'Batu, Kecamtn Batu, Kota Batu, Jawa Timur', '-', 'img-wisata/1.jpg', 'Buka 24 Jam', 'Rp.3.000-Rp.10.000'),
(2, 1, 2, 'Selecta', 'Wisata taman Selecta menyajikan berbagai daya tarik berupa taman bunga dan wahana di dalamnya.', -7.81828, 112.525449, 'Jl. Raya Selecta No. 1, Bumiaji, Tulungrejo, Bumiaji, Kota Batu, Jawa Timur 65336', '(0341)592379', 'img-wisata/2.jpg', 'pukul 06.00-17.00', 'Rp.2000-Rp.20.000'),
(3, 2, 3, 'Jatim Park 1', 'Jatim Park 1 ini merupakan tempat wisata yang menawarkan berbagai macam wahana yang sebagai taman belajar sekaligus rekreasi yang menarik.', -7.884502, 112.524882, ' Jl. Kartika No.2, Sisir, Kec. Batu, Kota Batu, Jawa Timur 65315', '(0341)597777', 'img-wisata/3.jpg', 'pukul 08.30-16.30', 'Rp.60.000-Rp.100.000'),
(4, 2, 3, 'Jatim Park 2', 'Di kawasan Jatim park 2 terdapat kebun binatang yang disebut Batu Secret Zoo yang lebih  lengkap daripada kebun binatang pada umumnya.', -7.888397, 112.529977, 'Jl. Oro-Oro Ombo No.9, Temas, Kec. Batu, Kota Batu, Jawa Timur 65315', '03415025777', 'img-wisata/4.jpg', 'pukul 10.00-18.00', 'Rp.75.000-Rp.125.000'),
(5, 2, 3, 'Jatim Park 3 / Dino Park', 'Di wisata ini pengunjung akan merasakan sensasi yang seakan-akan berada di zaman prasejarah. Dino Park merupakan taman Dinosaurus terbesar di Indonesia.', -7.897415, 112.556367, 'Jl. Raya Ir. Soekarno No.144, Beji, Junrejo, Kota Batu, Jawa Timur 65236', '03415103030', 'img-wisata/5.jpg', 'pukul 11.00-21.00', 'Rp.55.000-Rp.100.000'),
(6, 2, 2, 'Predator Fun Park', 'Predator Fun Park yang merupakan tempat untuk melihat berbagai jenis buaya baik itu yang masih hidup purba yang sudah punah.', -7.913067, 112.548409, 'Jl. Raya Tlekung No. 315, Dusun Gangsiran, Desa Tlekung, Kecamatan Junrejo, Tlekung, Junrejo, Kota Batu, Jawa Timur 65327', '(0341)531999', 'img-wisata/6.jpg', 'pukul 08.30-16.30', 'Rp.30.000-Rp.50.000'),
(7, 1, 1, 'Bukit Teletubbies', 'Model bukit dalam kawasan tempat wisata ini memang mirip dengan bukit Teletubbies yang ada di serial TV anak tersebut.', -7.853868, 112.54023, 'Jalan Terusan Sultan Agung No. 2, Batu, NgagliBumiaji, Kota Batu, Jawa Timur 65331k, Kec. Batu, Kota Batu', '(022)8473358', 'img-wisata/7.jpg', 'Buka 24 Jam', 'Gratis'),
(8, 4, 3, 'Museum Angkut', 'Di tempat wisata ini pengunjung dapat melihat berbagai macam jenis koleksi kendaraan dari berbagai dunia dari yang masih tradisional maupun yang sudah modern.', -7.878915, 112.520208, 'Jalan Terusan Sultan Agung No. 2, Batu, Ngaglik, Kec. Batu, Kota Batu', '(0341)595007', 'img-wisata/8.jpg', 'pukul 12.00-20.00', 'Rp.70.000-Rp.80.000'),
(9, 5, 1, 'Omah Kayu', 'Wisata omah kayu yang sangat menarik ini berada pada ketinggian 1.340 meter diatas permukaan laut.', -7.854949, 112.497805, 'Gunungsari, Bumiaji, Kota Batu', '081333183380', 'img-wisata/9.jpg', 'pukul 09.00-17.00', 'Rp.5.000'),
(10, 5, 1, 'Paralayang', 'Wisata ini adalah tempat dimana semua orang merasa senang melihat keindahan lanskap Kota Wisata Batu dari atas ketinggian.', -7.855139, 112.497156, 'Jl. Songgokerto, Songgokerto, Kec. Batu, Kota Batu', '03415032699', 'img-wisata/10.jpg', 'pukul 07.00-17.00', 'Rp.10.000-Rp.15.000'),
(11, 6, 2, 'Petik Apel', 'Di area wisata ini pengunjung dapat langsung memetik sendiri buah apel dari pohon dan ditemani oleh pemandu wisata.', -7.852942, 112.527076, 'Jl. Bukit Berbunga No.53 Sidomulyo, Kec. Batu, Kota Batu, Jawa Timur 65317', '(0341)511158', 'img-wisata/11.jpg', 'pukul 07.00-17.00', 'Rp.34.000-Rp.54.000'),
(12, 7, 1, 'Coban Rais', 'Di kawasan wisata ini ada air terjun dengan tinggi sekitar 20 m yang dulunya bernama Coban Sabrangan. Daya tarik utama tempat ini adalah adanya spot foto unik dan menarik yang instagramable.', -7.911647, 112.52063, 'Dusun Dresel, Desa Oro-oro Ombo Kecamatan Batu, Kota Batu', '-', 'img-wisata/12.jpg', 'pukul 07.30-15.00', 'Rp.10.000-Rp.25.000'),
(13, 7, 1, 'Coban Talun', 'Obyek wisata Coban Talun ini berupaya memadukan wisata alam dan wisata buatan dengn air terjun dan fasilitasnya.', -7.805056, 112.517058, 'Dusun Wonorejo, Desa Tulungrejo, Kec. Bumiaji, Kota Batu, Malang', '082131424038', 'img-wisata/13.jpg', 'pukul 07.00-17.00', 'Rp.5.000-Rp.10.000'),
(14, 8, 1, 'Panderman', 'Gunung Panderman merupakan background pemandangan kota Batu yang mempunyai ketinggian 2045 mdpl.', -7.904167, 112.496667, 'Dusun Toyomerto, Desa Pesanggrahan, Kota Batu, Jawa Timur', '-', 'img-wisata/14.jpg', 'Buka 24 jam', 'Rp.5.000-Rp.10.000'),
(15, 2, 3, 'BNS (Batu Night Spectacular)', 'BNS ini sejenis pasar malam namun dibuat secara modern dengan berbagai wahana yang menarik.', -7.896525, 112.534535, 'Jalan Hayam Wuruk No. 1, Oro-Oro Ombo, Batu, Oro-Oro Ombo, Kec. Batu, Kota Batu, Jawa Timur 65316', '03415025111', 'img-wisata/15.jpg', 'pukul 15.00-24.00', 'Rp.30.000-Rp.100.000'),
(16, 9, 1, 'Cangar', 'Di wisata ini, anda bisa berendam di dalam air panas dengan suasana pegunungan yang sejuk', -7.741727, 112.534377, 'Tulungrejo, Bumiaji, Sumber Brantas, Batu, Kota Batu, Jawa Timur 65336', '-', 'img-wisata/16.jpg', 'pukul 07.00-16.00', 'Rp.3.000-Rp.5.500'),
(17, 2, 1, 'Batu Wonderland', 'Wisata ini memiliki fasilitas waterpark, seperti taman bermain air dan wahana air lainnya.', -7.880352, 112.533101, 'Jalan Imam Bonjol Bawah No. 9, Temas, Batu, Kecamatan Batu, Kota Batu, Jawa Timur 65315', '(0341)595929', 'img-wisata/17.jpg', 'pukul 09.00-17.00', 'Rp.5.000-Rp.10.000'),
(18, 10, 1, 'Pasar Apung', 'Dikawasan Pasar Apung ini pengunjung bisa mendapatkan berbagai hal menarik khas kota Malang, seperti cindera mata, dan juga kuliner.', -7.878596, 112.519287, 'Jalan Sultan Agung No.2, Ngaglik, Kec. Batu, Kota Wisata Batu, Jawa Timur 65314', '(0341)595007', 'img-wisata/18.jpg', 'pukul 12.00-20.00', 'Rp.10.000'),
(21, 5, 1, 'Taman Langit', 'Fasilitas spot foto di kawasan wisata Taman Langit Gunung Banyak sangat diunggulkan. Banyak poperti unik dan keren disini.', -7.853467, 112.499232, 'Jalan Gunung Banyak, Songgokerto, Kecamatan Batu, Kota Batu, Jawa Timur 65312', '-', 'wisata/img-wisata/21.jpg', 'pukul 07.00-17.00', 'Rp.10.000'),
(22, 11, 1, 'Taman Goa Pandawa', 'Dinamakan demikian karena memiliki lima gua sesuai dengan jumlah tokoh Pandawa dalam cerita pewayangan. Gua ini sangat cocok dijadikan tempat wisata.', -7.846798, 112.504116, 'Desa Brau, Gunungsari, Bumiaji, Kota Batu', '-', 'wisata/img-wisata/22.jpg', 'Buka 24 jam', 'Rp.5.000'),
(23, 11, 1, 'Goa Pinus', 'Sebenarnya goa pinus ini pada awalnya merupakan tempat penambangan pasir, namun disulap jadi wisata yang keren.', -7.848028, 112.494003, 'g. Mbah Ba\'i, Gunungsari, Bumiaji, Kota Batu, Jawa Timur 65391', '-', 'img-wisata/20.jpg', 'pukul 07.00-17.30', 'Rp.5.000'),
(24, 7, 1, 'Coban Putri', 'Kecantikan Coban Putri adalah sesuatu yang pantas untuk dikagumi karena aliran air yan deras dan pemandangan indahnya.', -7.912613, 112.522665, 'Oro-Oro Ombo, Kec. Batu, Kota 20Batu, Jawa Timur 65316', '081222562234', 'wisata/img-wisata/19.jpg', 'pukul 06.00-17.15', 'Rp.3.000-Rp.8.000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `kategori_harga`
--
ALTER TABLE `kategori_harga`
  ADD PRIMARY KEY (`id_kategori_harga`);

--
-- Indexes for table `komentar`
--
ALTER TABLE `komentar`
  ADD PRIMARY KEY (`id_komentar`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `wisata`
--
ALTER TABLE `wisata`
  ADD PRIMARY KEY (`id_wisata`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `komentar`
--
ALTER TABLE `komentar`
  MODIFY `id_komentar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
