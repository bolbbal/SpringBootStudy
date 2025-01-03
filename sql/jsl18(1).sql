create table tbl_board (
    bno number(10) not null,
    title varchar2(100) not null,
    content varchar2(4000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    updatedate date default sysdate,
    constraint tbl_board_pk primary key (bno)
);
create sequence board_bno_seq;
create table tbl_attach (
    uuid varchar2(100) not null,
    uploadpath varchar2(200) not null,
    filename varchar2(100) not null,
    uploadfile varchar2(100) not null,
    filetype char(1) default 'I',
    bno number(10),
    constraint tbl_attach_pk primary key (uuid),
    constraint tbl_attach_fk foreign key (bno) references tbl_board (bno)
);
create table president_img (
    uuid varchar2(100) not null,
    uploadpath varchar2(200) not null,
    filename varchar2(100) not null,
    uploadfile varchar2(100) not null,
    filetype char(1) default 'I',
    bno number(10),
    constraint president_pk primary key (uuid),
    constraint president_fk foreign key (bno) references tbl_board (bno) on delete CASCADE
);

alter table tbl_attach add ceoImg varchar2(100);
alter table tbl_attach drop constraint tbl_attach_fk;
alter table tbl_attach add constraint tbl_attach_fk foreign key (bno) REFERENCES tbl_board (bno) on delete CASCADE;
select * from tbl_attach;
update tbl_attach set president = 'sin2.jpeg' where bno = 133;
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(117.41)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(223.62)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(117.41)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(223.62)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(117.41)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(223.62)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(117.41)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(223.62)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(117.41)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(223.62)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(117.41)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(223.62)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(117.41)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(223.62)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(117.41)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(223.62)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(117.41)');
insert into tbl_board (bno, title, content, writer) values (board_bno_seq.nextval, '酔肯鋭', '旭精 焦失 凪猿研 庁姥稽 丘亀 右諾聖猿推?', 'しし(223.62)');
commit;

select count(*) as count from tbl_board;

select 
				* 
		from 
				(select 
					/*+ index_desc (tbl_board tbl_board_pk) */ 
					rownum rn, bno, title, content, writer, regdate, updatedate 
				from 
					tbl_board  
				where 
					rownum <= 1 * 5
				)
		where rn > (1 - 1) * 5 ;
        
select * from tbl_attach where bno = 143 and president = filename;

select * from tbl_attach;

create table siteuser (
    id number not null,
    username varchar2(100) not null,
    password varchar2(300) not null,
    email varchar2(100) not null,
    constraint siteuser_pk primary key (id)
);

create sequence siteuser_seq;

insert into siteuser (id, username, password, email) values (siteuser_seq.nextval, 'aaabbb123', 'q1w2e3r4!', 'adkfljadf@email.com');
commit;

select * from siteuser;

alter table siteuser add role varchar2(10) default 'ROLE_USER' not null;

commit;

update siteuser set role = 'ROLE_ADMIN' where username = 'admin';

create table tbl_reply (
    reply_bno number not null,
    board_bno number not null,
    username varchar2(100) not null,
    content varchar2(200) not null,
    regdate date default sysdate,
    constraint tbl_reply_pk primary key (reply_bno),
    constraint tbl_reply_fk foreign key (board_bno) references tbl_board (bno) on delete cascade
);

create sequence tbl_reply_seq;

commit;

select * from tbl_reply;

select * from tbl_reply where board_bno = 206 order by reply_bno;