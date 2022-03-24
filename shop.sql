-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Mar 2022, 22:47
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
(3, 'buty'),
(4, 'buty do kolan'),
(5, 'buty z przedłużoną cholewką'),
(6, 'Buty damskie'),
(7, 'Buty męskie');

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
(6, 8, 'Cart', '2022-03-23');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `categoryID` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `product`
--

INSERT INTO `product` (`id`, `categoryID`, `name`) VALUES
(2, 1, 'Gino Rossi Sport RST-ZIBI-01 Szary'),
(3, 1, 'Gino Rossi 22SS27 Camel'),
(4, 2, 'Jenny Fairy WSS20380-03ECO Biały'),
(5, 2, 'Jenny Fairy WSS20380-02ECO Czarny'),
(6, 3, 'New Balance GM500Vr1'),
(7, 3, 'Skechers 12615 BKRG Czarny'),
(8, 4, 'Badura V787-19-1 Beżowy'),
(9, 4, 'Jenny Fairy LS5618-02 Czarny'),
(10, 5, 'Saszki SA/1 czarne'),
(11, 5, 'Lasocki MB-BOBO-04 Skóra'),
(12, NULL, 'Addidasy szare'),
(13, NULL, 'Czarne też addidasy');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `product_order`
--

CREATE TABLE `product_order` (
  `id` int(11) NOT NULL,
  `productID` int(11) DEFAULT NULL,
  `orderID` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `createDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `product_order`
--

INSERT INTO `product_order` (`id`, `productID`, `orderID`, `quantity`, `price`, `createDate`) VALUES
(1, 2, 1, 1, '399.00', '2022-03-22 20:18:14'),
(2, 6, 2, 2, '798.99', '2022-03-22 20:18:14'),
(3, 7, 3, 1, '299.99', '2022-03-22 20:18:14'),
(4, 9, 3, 1, '199.99', '2022-03-22 20:18:14'),
(5, 10, 4, 1, '200.00', '2022-03-22 20:18:14'),
(6, 11, 5, 1, '499.89', '2022-03-22 20:18:14');

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
(8, 'Jan', 'Paweł', 'II', '2022-03-23 18:31:23');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT dla tabeli `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT dla tabeli `product_order`
--
ALTER TABLE `product_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Ograniczenia dla zrzutów tabel
--

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
