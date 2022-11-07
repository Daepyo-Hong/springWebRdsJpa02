CREATE TABLE `my_board` (
    `bno` bigint(20) NOT NULL AUTO_INCREMENT,
    `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `content` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `read_count` int(11) DEFAULT 0,
    `writer` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `created_date` timestamp NULL DEFAULT current_timestamp(),
    `updated_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    PRIMARY KEY (`bno`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

