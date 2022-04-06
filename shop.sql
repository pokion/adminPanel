-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2022 at 02:55 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
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
-- Table structure for table `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `alt` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `image`
--

INSERT INTO `image` (`id`, `path`, `alt`) VALUES
(1, 'adidasCzarny.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n	quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n	consequat. Duis aute irure '),
(2, 'adidasCzarny2.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n	quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n	consequat. Duis aute irure '),
(3, 'adidasSzary.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,'),
(4, 'adidasSzary2.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,'),
(5, 'image.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\n	quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\n	consequat. Duis aute irure '),
(6, 'image2.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\n	quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\n	consequat. Duis aute irure '),
(7, 'img2.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\n	quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\n	consequat. Duis aute irure '),
(8, 'img3.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\n	quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\n	consequat. Duis aute irure ');

-- --------------------------------------------------------

--
-- Table structure for table `imagelink`
--

CREATE TABLE `imagelink` (
  `id` int(11) NOT NULL,
  `imageID` int(11) DEFAULT NULL,
  `productID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `imagelink`
--

INSERT INTO `imagelink` (`id`, `imageID`, `productID`) VALUES
(1, 1, 2),
(2, 2, 2),
(3, 3, 3),
(4, 4, 3),
(5, 5, 4),
(6, 6, 4),
(7, 7, 5),
(8, 8, 5);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `dataOrder` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
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
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `categoryID` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `categoryID`, `name`, `price`) VALUES
(2, 1, 'Gino Rossi Sport RST-ZIBI-01 Szary', '299.89'),
(3, 1, 'Gino Rossi 22SS27 Camel', '399.89'),
(4, 2, 'Jenny Fairy WSS20380-03ECO Biały', '289.99'),
(5, 2, 'Jenny Fairy WSS20380-02ECO Czarny', '300.00'),
(6, 3, 'New Balance GM500Vr1', '199.99'),
(7, 3, 'Skechers 12615 BKRG Czarny', '499.99'),
(8, 4, 'Badura V787-19-1 Beżowy', '50.00'),
(9, 3, 'Jenny Fairy LS5618-02 Czarny', '89.99'),
(10, 5, 'Saszki SA/1 czarne', '90.89'),
(11, 5, 'Lasocki MB-BOBO-04 Skóra', '256.00'),
(12, NULL, 'Addidasy szare', '332.88'),
(13, NULL, 'Czarne też addidasy', '44.88'),
(15, 2, 'Govani Gucci', '484.87');

-- --------------------------------------------------------

--
-- Table structure for table `product_order`
--

CREATE TABLE `product_order` (
  `id` int(11) NOT NULL,
  `productID` int(11) DEFAULT NULL,
  `orderID` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_order`
--

INSERT INTO `product_order` (`id`, `productID`, `orderID`, `quantity`, `createDate`) VALUES
(1, 2, 1, 1, '2022-03-22 20:18:14'),
(2, 6, 2, 2, '2022-02-15 20:18:14'),
(3, 7, 3, 1, '2021-12-16 20:18:14'),
(4, 9, 3, 1, '2016-03-27 20:18:14'),
(5, 10, 4, 1, '2018-03-20 20:18:14'),
(6, 11, 5, 1, '2022-01-11 20:18:14'),
(8, 4, 7, 1, '2022-03-27 16:57:46');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
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
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `imagelink`
--
ALTER TABLE `imagelink`
  ADD PRIMARY KEY (`id`),
  ADD KEY `imageID` (`imageID`),
  ADD KEY `productID` (`productID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoryID` (`categoryID`);

--
-- Indexes for table `product_order`
--
ALTER TABLE `product_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `productID` (`productID`),
  ADD KEY `orderID` (`orderID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `imagelink`
--
ALTER TABLE `imagelink`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `product_order`
--
ALTER TABLE `product_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `imagelink`
--
ALTER TABLE `imagelink`
  ADD CONSTRAINT `imagelink_ibfk_1` FOREIGN KEY (`imageID`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `imagelink_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`categoryID`) REFERENCES `category` (`id`);

--
-- Constraints for table `product_order`
--
ALTER TABLE `product_order`
  ADD CONSTRAINT `product_order_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `product_order_ibfk_2` FOREIGN KEY (`orderID`) REFERENCES `orders` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
