# minhaj_bank
# Tapader_BANK
# bank_minhaj
# bank_minhaj
# minhaj_bank
# minhaj_bank
# tapader_bank_project
create database banking;
use banking;
create table signup(formno varchar(20), Cname varchar(20), father_name varchar(20),religion varchar(20), sex varchar(20),email varchar(30), marital_status varchar(20), city varchar(40), village varchar(25), pincode varchar(20), postcode varchar(25));
show tables;
select * from signup;
set sql_safe_updates=0;
delete from insuranceOne;
set sql_safe_updates=1;
create table signuptwo(formno varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), idcardnumber varchar(20),existingaccount varchar(20));
create table login(formno varchar(20), cardnumber varchar(25), pin varchar(10));
select * from signuptwo;
select * from login;
create table balance(pin varchar(20), type varchar(20), amount varchar(25));
select * from balance;
create table loan(pin varchar(20), type varchar(20), amount varchar(25));
select * from loan;
create table history(pin varchar(20),date varchar(40),cardnumber varchar(20), type varchar(20), amount varchar(25));
select * from history;
create table insurance(pin varchar(20),formno  varchar(20), name varchar(20), plane varchar(20),mobile varchar(20), sex varchar(20),coverage varchar(30), marital varchar(20), SpouseN varchar(40), SpouseS varchar(25), SpouseOcc varchar(20));
select * from insurance;
drop table insurance;
create table insuranceOne(formno varchar(20), suffer varchar(20), cov varchar(20),trt varchar(20), doctor varchar(20),test varchar(30), madiname varchar(40), smoke varchar(40));
select * from insuranceOne;







....................................Database Commend......................
