-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 07 Kwi 2022, 16:34
-- Wersja serwera: 10.4.22-MariaDB
-- Wersja PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `shop`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'półbuty'),
(2, 'trzewiki'),
(3, 'Obuwie sportowe'),
(4, 'kozaki'),
(5, 'trampki');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `alt` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `image`
--

INSERT INTO `image` (`id`, `path`, `alt`) VALUES
(9, '1349-5010.jpg', NULL),
(10, '1349-5011.jpg', NULL),
(11, '1349-5012.jpg', NULL),
(12, '1349-5013.jpg', NULL),
(13, '7546-050.JPG', NULL),
(14, '7546-051.JPG', NULL),
(15, '7546-052.JPG', NULL),
(16, '7546-053.JPG', NULL),
(17, '217300200(II)0.jpg', NULL),
(18, '217300200(II)1.jpg', NULL),
(19, '217300200(II)2.jpg', NULL),
(20, '217300200(II)3.jpg', NULL),
(21, '2181304000.JPG', NULL),
(22, '2181304001.JPG', NULL),
(23, '2181304002.JPG', NULL),
(24, '2181304003.JPG', NULL),
(25, '2193517000.jpg', NULL),
(26, '2193517001.jpg', NULL),
(27, '2193517002.jpg', NULL),
(28, '2193517003.jpg', NULL),
(29, 'ENERGEN LITE S427800.jpg', NULL),
(30, 'ENERGEN LITE S427801.jpg', NULL),
(31, 'ENERGEN LITE S427802.jpg', NULL),
(32, 'ENERGEN LITE S427803.jpg', NULL),
(33, 'FF374035C0.jpg', NULL),
(34, 'FF374035C1.jpg', NULL),
(35, 'FF374035C2.jpg', NULL),
(36, 'FF374035C3.jpg', NULL),
(37, 'Filmore Decon VN0A45NM5GX10.JPG', NULL),
(38, 'Filmore Decon VN0A45NM5GX11.JPG', NULL),
(39, 'Filmore Decon VN0A45NM5GX12.JPG', NULL),
(40, 'Filmore Decon VN0A45NM5GX13.JPG', NULL),
(41, 'MI07-B176-B03-010.jpg', NULL),
(42, 'MI07-B176-B03-012.jpg', NULL),
(43, 'MI07-B176-B03-013.jpg', NULL),
(44, 'MI07-B176-B03-014.jpg', NULL),
(45, 'REBOUND GRAPHIC LOW G PS S32374-WW0010.jpg', NULL),
(46, 'REBOUND GRAPHIC LOW G PS S32374-WW0011.jpg', NULL),
(47, 'REBOUND GRAPHIC LOW G PS S32374-WW0012.jpg', NULL),
(48, 'REBOUND GRAPHIC LOW G PS S32374-WW0013.jpg', NULL),
(49, 'SUPERTEC ZERO 384642050.jpg', NULL),
(50, 'SUPERTEC ZERO 384642051.jpg', NULL),
(51, 'SUPERTEC ZERO 384642052.jpg', NULL),
(52, 'SUPERTEC ZERO 384642053.jpg', NULL),
(53, 'WS8520-08.jpg', NULL),
(54, 'WS8520-082.jpg', NULL),
(55, 'WS8520-083.jpg', NULL),
(56, 'WS8520-084.jpg', NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `imagelink`
--

CREATE TABLE `imagelink` (
  `id` int(11) NOT NULL,
  `imageID` int(11) DEFAULT NULL,
  `productID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `imagelink`
--

INSERT INTO `imagelink` (`id`, `imageID`, `productID`) VALUES
(9, 53, 2),
(10, 54, 2),
(11, 55, 2),
(12, 56, 2),
(13, 41, 3),
(14, 42, 3),
(15, 43, 3),
(16, 44, 3),
(17, 9, 4),
(18, 10, 4),
(19, 11, 4),
(20, 12, 4),
(21, 21, 5),
(22, 22, 5),
(23, 27, 5),
(24, 28, 5),
(25, 29, 6),
(26, 30, 6),
(27, 31, 6),
(28, 32, 6),
(29, 49, 7),
(30, 50, 7),
(31, 51, 7),
(32, 52, 7),
(34, 26, 8),
(36, 28, 8),
(37, 13, 9),
(38, 14, 9),
(39, 15, 9),
(40, 16, 9),
(41, 25, 8),
(42, 27, 8),
(44, 37, 10),
(45, 38, 10),
(46, 39, 10),
(47, 40, 10),
(48, 45, 12),
(49, 46, 12),
(50, 47, 12),
(51, 48, 12),
(52, 33, 13),
(53, 34, 13),
(54, 35, 13),
(55, 36, 13),
(56, 17, 15),
(57, 18, 15),
(58, 19, 15),
(59, 20, 15);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `dataOrder` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `orders`
--

INSERT INTO `orders` (`id`, `userID`, `status`, `dataOrder`) VALUES
(1, 1, 'Pending', '2022-03-22'),
(2, 3, 'Pending', '2022-03-22'),
(3, 4, 'Paid', '2022-03-22'),
(4, 5, 'Ok', '2022-03-22'),
(5, 6, 'Cart', '2022-03-22'),
(6, 8, 'Cart', '2022-03-23'),
(7, 1, 'ok', '2022-03-27');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `categoryID` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `style` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `product`
--

INSERT INTO `product` (`id`, `categoryID`, `name`, `price`, `sex`, `brand`, `color`, `model`, `style`) VALUES
(2, 1, 'Półbuty Jenny Fairy', '149.99', 'damskie', 'Jenny Fairy', 'Różowy', 'WS8520-08', 'Casualny/codzienny'),
(3, 1, 'Półbuty Sergio Bardi', '189.99', 'męskie', 'Sergio Bardi ', 'Granatowy', 'MI07-B176-B03-01 ', 'Casualny/codzienny'),
(4, 2, 'Trzewiki Mustang', '249.99', 'damskie', 'Mustang', 'Niebieski', '1349-501', 'Casualny/codzienny '),
(5, 2, 'Trzewiki Tom Tailor', '269.99', 'męskie', 'Tom Tailor', 'Brązowy', '218130400', 'Casualny/codzienny '),
(6, 3, 'Obuwie sportowe Reebok', '179.99', 'damskie', 'Reebok', 'Biały', 'ENERGEN LITE S42780', 'Sportowy'),
(7, 3, 'Obuwie sportowe Puma', '249.99', 'męskie', 'Puma', 'Biały', 'SUPERTEC ZERO 38464205', 'Sportowy'),
(8, 4, 'Kozaki Tom Tailor', '249.99', 'damskie', 'Tom Tailor', 'Czarny', '219351700', 'Casualny/codzienny'),
(9, 4, 'Kozaki Lasocki', '239.95', 'damskie', 'Lasocki', 'Bordowy', '7546-05', 'Casualny/codzienny'),
(10, 5, 'Trampki Vans', '259.99', 'damskie', 'Vans', 'Czarny', 'Filmore Decon VN0A45NM5GX1', 'Sportowy'),
(12, 3, 'Obuwie sportowe Champion', '159.99', 'dziecięce', 'Champion', 'Biały', 'REBOUND GRAPHIC LOW G PS S32374-WW001', 'Sportowy'),
(13, 1, 'Półbuty BIG STAR', '129.99', 'dziecięce', 'BIG STAR', 'Biały', 'FF374035C', 'Casualny/codzienny'),
(15, 2, 'Trzewiki Tom Tailor', '179.99', 'dziecięce', 'Tom Tailor', 'Granatowy', '217300200(II)', 'Casualny/codzienny');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `product_order`
--

CREATE TABLE `product_order` (
  `id` int(11) NOT NULL,
  `productID` int(11) DEFAULT NULL,
  `orderID` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `product_order`
--

INSERT INTO `product_order` (`id`, `productID`, `orderID`, `quantity`, `createDate`) VALUES
(1, 2, 1, 1, '2022-03-22 20:18:14'),
(2, 6, 2, 2, '2022-02-15 20:18:14'),
(3, 7, 3, 1, '2021-12-16 20:18:14'),
(4, 9, 3, 1, '2016-03-27 20:18:14'),
(5, 10, 4, 1, '2018-03-20 20:18:14'),
(6, 4, 5, 1, '2022-01-11 20:18:14'),
(8, 4, 7, 1, '2022-03-27 16:57:46');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`id`, `name`, `login`, `password`, `createDate`) VALUES
(1, 'Cezary', 'cez', 'bub', '2022-03-22 20:17:01'),
(3, 'Jakub', 'jak', 'kar', '2022-03-22 20:17:01'),
(4, 'Monika', 'moni', 'ka', '2022-03-22 20:17:01'),
(5, 'Mariusz', 'mar', 'wski', '2022-03-22 20:17:01'),
(6, 'Julita', 'jul', 'ita', '2022-03-22 20:17:01'),
(7, 'Jack', 'Sparrow', 'CzarnaPerła', '2022-03-23 18:31:03'),
(8, 'Jan', 'Paweł', 'II', '2022-03-23 18:31:23'),
(10, 'SebastianDDDDD', 'seb', 'tian', '2022-04-05 10:05:21');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `imagelink`
--
ALTER TABLE `imagelink`
  ADD PRIMARY KEY (`id`),
  ADD KEY `imageID` (`imageID`),
  ADD KEY `productID` (`productID`);

--
-- Indeksy dla tabeli `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userID` (`userID`);

--
-- Indeksy dla tabeli `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoryID` (`categoryID`);

--
-- Indeksy dla tabeli `product_order`
--
ALTER TABLE `product_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `productID` (`productID`),
  ADD KEY `orderID` (`orderID`);

--
-- Indeksy dla tabeli `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT dla tabeli `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT dla tabeli `imagelink`
--
ALTER TABLE `imagelink`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT dla tabeli `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT dla tabeli `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT dla tabeli `product_order`
--
ALTER TABLE `product_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `imagelink`
--
ALTER TABLE `imagelink`
  ADD CONSTRAINT `imagelink_ibfk_1` FOREIGN KEY (`imageID`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `imagelink_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`id`);

--
-- Ograniczenia dla tabeli `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`);

--
-- Ograniczenia dla tabeli `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`categoryID`) REFERENCES `category` (`id`);

--
-- Ograniczenia dla tabeli `product_order`
--
ALTER TABLE `product_order`
  ADD CONSTRAINT `product_order_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `product_order_ibfk_2` FOREIGN KEY (`orderID`) REFERENCES `orders` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
