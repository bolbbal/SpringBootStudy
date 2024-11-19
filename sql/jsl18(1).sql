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

select * from tbl_board;

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