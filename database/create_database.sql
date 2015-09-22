DROP TABLE IF EXISTS codetable;
CREATE TABLE codetable (
    category_ varchar(30),
    code_ integer,
    label_ varchar(30) not null,
    desc_ varchar(40),
    order_ INT,
    PRIMARY KEY (category_,code_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
    `id` int(11) NOT NULL auto_increment,
    `code` varchar(6) NOT NULL,
    `name` varchar(20) NOT NULL,
    PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(6) NOT NULL,
  `name` varchar(20) NOT NULL,
  `provincecode` varchar(6) NOT NULL,
  PRIMARY KEY  (`id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
    `id` int(11) NOT NULL auto_increment,
    `code` varchar(6) NOT NULL,
    `name` varchar(20) NOT NULL,
    `citycode` varchar(6) NOT NULL,
    PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;