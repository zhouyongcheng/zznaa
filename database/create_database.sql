create table codetable (
    category_ varchar(30),
    code_ integer,
    label_ varchar(30) not null,
    desc_ varchar(40),
    order_ INT,
    PRIMARY KEY (category_,code_)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;