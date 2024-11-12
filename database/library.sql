-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2024 at 09:03 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `isbn` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`isbn`, `author`, `name`) VALUES
('978-0-06-112008-4', 'Suzanne Collins', 'The Hunger Games'),
('978-0-14-028333-4', 'Herman Melville', 'Moby-Dick'),
('978-0-14-118266-2', 'Aldous Huxley', 'Brave New World'),
('978-0-14-310598-5', 'Markus Zusak', 'The Book Thief'),
('978-0-14-312854-0', 'Paulo Coelho', 'The Alchemist'),
('978-0-345-34272-7', 'J.R.R. Tolkien', 'The Lord of the Rings'),
('978-0-451-52815-7', 'Ray Bradbury', 'Fahrenheit 451'),
('978-0-452-28423-4', 'George Orwell', '1984'),
('978-0-671-02735-0', 'Stephen King', 'The Shining'),
('978-0-7432-7352-7', 'Cormac McCarthy', 'The Road'),
('978-0-7432-7355-8', 'Charles Dickens', 'A Tale of Two Cities'),
('978-0-7432-7356-5', 'Harper Lee', 'To Kill a Mockingbird'),
('978-1-56619-909-4', 'F. Scott Fitzgerald', 'The Great Gatsby'),
('978-1-59030-170-2', 'J.R.R. Tolkien', 'The Hobbit'),
('978-3-16-148410-0', 'J.D. Salinger', 'The Catcher in the Rye');

-- --------------------------------------------------------

--
-- Table structure for table `checked_out_book`
--

CREATE TABLE `checked_out_book` (
  `id` int(11) NOT NULL,
  `checkout_date` datetime(6) DEFAULT NULL,
  `book_isbn` varchar(255) DEFAULT NULL,
  `member_jmbg` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `checked_out_book`
--

INSERT INTO `checked_out_book` (`id`, `checkout_date`, `book_isbn`, `member_jmbg`) VALUES
(11, '2024-11-11 21:00:02.000000', '978-0-14-118266-2', '1234567890123');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `jmbg` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `entry_date` datetime(6) DEFAULT NULL,
  `expiry_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`jmbg`, `address`, `entry_date`, `expiry_date`, `name`, `phone_number`) VALUES
('0123456789012', '707 Ash St, Šabac', '2020-04-02 00:00:00.000000', '2021-04-02 00:00:00.000000', 'Bojan Stanković', '0620123456'),
('1234567890123', '123 Main St, Belgrade', '2023-01-15 00:00:00.000000', '2024-01-15 00:00:00.000000', 'Ana Petrović', '0631234567'),
('1234567890124', '808 Poplar St, Kraljevo', '2023-01-18 00:00:00.000000', '2024-01-18 00:00:00.000000', 'Tamara Milenković', '0632345678'),
('2345678901234', '456 Oak St, Novi Sad', '2022-05-10 00:00:00.000000', '2023-05-10 00:00:00.000000', 'Marko Jovanović', '0642345678'),
('2345678901235', '909 Willow St, Senta', '2021-05-15 00:00:00.000000', '2022-05-15 00:00:00.000000', 'Vladimir Lukić', '0643456789'),
('3456789012345', '789 Maple St, Niš', '2021-07-20 00:00:00.000000', '2022-07-20 00:00:00.000000', 'Jelena Nikolić', '0653456789'),
('3456789012346', '1010 Fir St, Zaječar', '2022-06-22 00:00:00.000000', '2023-06-22 00:00:00.000000', 'Stefan Ristić', '0654567890'),
('4567890123456', '101 Pine St, Kragujevac', '2022-09-05 00:00:00.000000', '2023-09-05 00:00:00.000000', 'Nikola Ivanić', '0664567890'),
('4567890123457', '1111 Redwood St, Prokuplje', '2020-08-30 00:00:00.000000', '2021-08-30 00:00:00.000000', 'Maja Đokić', '0665678901'),
('5678901234567', '202 Birch St, Subotica', '2023-03-25 00:00:00.000000', '2024-03-25 00:00:00.000000', 'Marija Kovač', '0675678901'),
('5678901234568', '1212 Hickory St, Vranje', '2023-04-13 00:00:00.000000', '2024-04-13 00:00:00.000000', 'Dušan Tadić', '0676789012'),
('6789012345678', '303 Cedar St, Zrenjanin', '2020-11-12 00:00:00.000000', '2021-11-12 00:00:00.000000', 'Petar Savić', '0686789012'),
('7890123456789', '404 Elm St, Vršac', '2021-02-18 00:00:00.000000', '2022-02-18 00:00:00.000000', 'Ivana Đorđević', '0697890123'),
('8901234567890', '505 Walnut St, Užice', '2023-07-30 00:00:00.000000', '2024-07-30 00:00:00.000000', 'Aleksandar Milić', '0608901234'),
('9012345678901', '606 Cherry St, Pirot', '2022-10-10 00:00:00.000000', '2023-10-10 00:00:00.000000', 'Sofija Babić', '0619012345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`isbn`);

--
-- Indexes for table `checked_out_book`
--
ALTER TABLE `checked_out_book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdtx62tkxuqghh56kfisj4cd3m` (`book_isbn`),
  ADD KEY `FKscn1a458mkbe8vwm4xbg49jke` (`member_jmbg`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`jmbg`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `checked_out_book`
--
ALTER TABLE `checked_out_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `checked_out_book`
--
ALTER TABLE `checked_out_book`
  ADD CONSTRAINT `FKdtx62tkxuqghh56kfisj4cd3m` FOREIGN KEY (`book_isbn`) REFERENCES `book` (`isbn`),
  ADD CONSTRAINT `FKscn1a458mkbe8vwm4xbg49jke` FOREIGN KEY (`member_jmbg`) REFERENCES `member` (`jmbg`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
