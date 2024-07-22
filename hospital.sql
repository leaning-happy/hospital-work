-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2019-06-20 15:29:18
-- 服务器版本： 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- 表的结构 `doctor`
--

CREATE TABLE `doctor` (
  `name` varchar(6) COLLATE utf8_bin NOT NULL,
  `deptName` varchar(10) COLLATE utf8_bin NOT NULL,
  `sex` varchar(10) COLLATE utf8_bin NOT NULL,
  `id` int(10) NOT NULL,
  `acount` varchar(20) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `doctor`
--

INSERT INTO `doctor` (`name`, `deptName`, `sex`, `id`, `acount`) VALUES
('张一', '儿科', '男', 1001, '2017201'),
('张二', '眼科', '男', 1002, '2017203'),
('张三', '心脏科', '女', 1003, '2017204');

-- --------------------------------------------------------

--
-- 表的结构 `patient`
--

CREATE TABLE `patient` (
  `name` varchar(6) NOT NULL,
  `phoneName` double DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `acount` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `patient`
--

INSERT INTO `patient` (`name`, `phoneName`, `sex`, `acount`) VALUES
('王一', 1001, '男', '2018001'),
('王二', 1002, '男', '2018002'),
('王三', 1003, '女', '2018003'),
('王四', 1004, '男', '2018004'),
('王五', NULL, NULL, '2018005');

-- --------------------------------------------------------

--
-- 表的结构 `reform`
--

CREATE TABLE `reform` (
  `id` int(20) NOT NULL,
  `dname` varchar(5) NOT NULL,
  `pname` varchar(5) NOT NULL,
  `deptname` varchar(20) NOT NULL,
  `money` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `reform`
--

INSERT INTO `reform` (`id`, `dname`, `pname`, `deptname`, `money`) VALUES
(1, '张一', '王一', '儿科', 20),
(5, '张三', '王一', '心脏课', 20),
(6, '张二', '王一', '眼科', 20);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `acount` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`acount`, `password`, `type`) VALUES
('', '', ''),
('2017201', '2017201', '医生'),
('2017203', '2017203', '医生'),
('2017204', '2017204', '医生'),
('2018001', '2018001', '用户'),
('2018002', '2018002', '用户'),
('2018003', '2018003', '用户'),
('2018004', '2018004', '用户'),
('2018005', '2018005', '用户');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`acount`);

--
-- Indexes for table `reform`
--
ALTER TABLE `reform`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`acount`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `reform`
--
ALTER TABLE `reform`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
