create table tblSpringBoard(
b_seq number primary key,
b_title varchar2(50),
b_content varchar2(4000),
b_writer varchar2(50),
b_regdate date,
b_hitcount number,
b_password varchar2(10)
);

create sequence seq_board;

insert into tblSpringBoard(b_seq,b_title,b_content,b_writer,b_regdate,b_hitcount,b_password) values(seq_board.nextVal,'첫번째 글입니다','aaaaa','홍길동',sysdate,0,'1111');

select * from tblSpringBoard;