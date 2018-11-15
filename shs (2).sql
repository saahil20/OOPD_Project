-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2018 at 10:24 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shs`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `did` int(5) NOT NULL,
  `pid` int(5) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  `timing` varchar(20) NOT NULL,
  `post` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `username`, `password`, `email`, `department`, `timing`, `post`) VALUES
(2, 'Jayant Barve', 'jbarve', 'jayant', 'javant@gmail.com', 'Gastroenterology', '14:00-18:00', 'Specialist'),
(3, 'Saumil Shah', 'saumil', 'saumil', 'saumil@gmail.com', 'Gastroenterology', '10:00-14:00', 'Senior Doctor'),
(5, 'Rohan Gurve', 'rohan', 'rohan', 'rohan@gmail.com', 'Cardiology', '12:00-15:00', 'Senior Doctor');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `pid` int(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `age` int(5) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `location` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`pid`, `name`, `username`, `password`, `email`, `age`, `phone`, `location`) VALUES
(1, 'Saahil Shah', 'saahil20', 'saahil20', 'saahilshah48@gmail.com', 22, '8108468012', 'OPD'),
(2, 'Peter', 'pete', '9789', 'heisblack2234@gmail.com', 12, '1234987645', 'OPD'),
(3, 'harsh parikh', 'harsh', 'harshp', 'harsh@gmail.com', 22, '987654321', 'OPD'),
(4, 'Rohan Gurve', 'rohan127', 'rohan127', 'rohan@gmail.com', 22, '567488321', 'OPD'),
(5, 'Harsh Parikh', 'parick', 'parick', 'harsh@gmail.com', 22, '7345453712', 'OPD');

-- --------------------------------------------------------

--
-- Table structure for table `patient_consulted`
--

CREATE TABLE `patient_consulted` (
  `did` int(5) NOT NULL,
  `pid` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient_medical`
--

CREATE TABLE `patient_medical` (
  `id` int(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `consultant` int(5) NOT NULL,
  `doctors_opinion` varchar(200) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `rid` int(5) NOT NULL,
  `pid` int(5) NOT NULL,
  `did` int(5) NOT NULL,
  `detail` varchar(500) NOT NULL,
  `d_opinion` varchar(200) NOT NULL,
  `prescription` varchar(100) NOT NULL,
  `test_suggested` varchar(100) NOT NULL,
  `conclusion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD KEY `appointments_ibfk_1` (`did`),
  ADD KEY `pid` (`pid`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`pid`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `patient_consulted`
--
ALTER TABLE `patient_consulted`
  ADD KEY `did` (`did`),
  ADD KEY `pid` (`pid`);

--
-- Indexes for table `patient_medical`
--
ALTER TABLE `patient_medical`
  ADD KEY `id` (`id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`rid`),
  ADD KEY `did` (`did`),
  ADD KEY `pid` (`pid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `pid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `rid` int(5) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `appointments_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `patients` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `patient_consulted`
--
ALTER TABLE `patient_consulted`
  ADD CONSTRAINT `patient_consulted_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctor` (`id`),
  ADD CONSTRAINT `patient_consulted_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `patients` (`pid`);

--
-- Constraints for table `patient_medical`
--
ALTER TABLE `patient_medical`
  ADD CONSTRAINT `patient_id` FOREIGN KEY (`id`) REFERENCES `patients` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reports_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `patients` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
