/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2005                    */
/* Created on:     2016/4/3 9:24:33                             */
/*==============================================================*/

create database studentManage
go
use studentManage
go

/*==============================================================*/
/* Table: Cscourse                                              */
/*==============================================================*/
create table Cscourse (
   cscourseid           int    identity               not null,
   id                   int                  not null,
   courseid             int                  not null,
   constraint PK_CSCOURSE primary key nonclustered (cscourseid)
)
go



/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course (
   courseid             int          identity        not null,
   courseName           varchar(60)             null,
   constraint PK_COURSE primary key nonclustered (courseid)
)
go

/*==============================================================*/
/* Table: userInfo                                              */
/*==============================================================*/
create table userInfo (
   id                   int    primary key  identity              not null,
   name                 char(50)             not null,
   password             varchar(8)              not null,
   address              varchar(100)            null,
   age                  int                  null,
   telephone            varchar(11)             null,
   birthday             datetime             null,
   sex                  varchar(4)                  null
)
go
create table Manageuser (
   id                   int    primary key  identity              not null,
   name                 varchar(50)             not null,
   password             varchar(8)              not null,
   address              varchar(100)            null,
   age                  int                  null,
   telephone            varchar(11)             null,
   birthday             datetime             null,
   sex                  varchar(4)                  null
)
go

alter table Cscourse 
add constraint fk_Cscourse_userInfo_id
foreign key(id)
references userInfo(id)

go
alter table Cscourse 
add constraint fk_Cscourse_course_courseid
foreign key(courseid)
references course(courseid)

insert into userInfo values('xyh','111','csmzxy',20,'13077777777','2000-04-18','男')
insert into Manageuser values('xyh','111','csmzxy',20,'13077777777','2000-04-18','男')
insert into userInfo values('jordan','111','csmzxy',20,'13077777777','2000-04-18','女')
insert into course values('英语')
insert into course values('计算机')
insert into course values('政治')
insert into course values('社会管理')

insert into Cscourse values(1,1)
insert into Cscourse values(1,2)

select * from Cscourse where id=1
select * from userInfo