create table sj_gourmet_review (
	gm_no number(3) primary key, 
	gm_g_no varchar2(20 char) not null,
	gm_l_no number(3) not null,
	gm_pw number(4) not null,
	gm_grade number(4,2) not null,
	gm_date date not null,
	gm_menu varchar2(100 char) not null,
	gm_review varchar2(1000 char) not null,
	gm_pic varchar2(500 char) not null
);

create sequence gm_no_seq;

insert into sj_gourmet_review values (gm_no_seq.nextval, 'CONT_000000000500349', 1, 10, 0708, SYSDATE, 'testmenu', '¸ÀÀÖ¾î¿ä.', 'test_picture');

select * from sj_gourmet_review;






drop table sj_gourmet_review;
drop sequence gm_no_seq;