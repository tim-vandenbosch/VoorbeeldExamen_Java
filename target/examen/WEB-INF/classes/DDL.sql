-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 03, 2016 at 06:50 PM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `boekingdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `BOOKING`
--

CREATE TABLE `BOOKING` (
  `id` bigint(20) NOT NULL,
  `DAY` date DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `STREET` varchar(255) DEFAULT NULL,
  `HOUR` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


--
-- Indexes for table `BOOKING`
--
ALTER TABLE `BOOKING`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `BOOKING`
--
ALTER TABLE `BOOKING`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;