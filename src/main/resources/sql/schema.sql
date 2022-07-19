create table member (
                        id integer not null auto_increment,
                        login_id varchar(255),
                        name varchar(255),
                        password varchar(255),
                        primary key (id)
);

create table person (
                        id integer not null auto_increment,
                        member_id integer not null,
                        person varchar(255),
                        primary key (id)
);

alter table person
    add constraint FK7vxx4e27h28uetswuwl1yawtc
    foreign key (member_id)
    references member (id);