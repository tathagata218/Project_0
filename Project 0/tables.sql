--Table one Which will incude all the User Information. 

create table userInfo (
    userInf_id number primary key,
    firstName varchar2(100) not null,
    lastName varchar2(100) not null,
    userEmail varchar2(200) not null unique,
    userName varchar2(100) not null ,
    userPass varchar2(100) not null

    
);
--This table will contatin all the account information related to the account.
-- One user can have multiple accounts

create table accountInfo(
    account_id number primary key,
    accNumebr integer not null,
    accDiposit number(10,2) not null,
    accCheckings number(10,2) not null,
    
    userInf_id number not null,

    constraint mulAcc foreign key (userInf_id) references userInfo(userInf_id) on delete cascade 

);

--create table usersAcc(
    --userInf_id number primary key,
    --account_Id number primary key,
    
--)



create table transactions (
    tranID number primary key,
    tranDate date not null,
    accType varchar2(200) not null,
    amount number not null,
    previousBal number not null,
    updateBal number not null,

    account_id number not null,

    constraint multiTran foreign key (account_id) references accountInfo(account_id)
    on delete cascade

);


--Inserting data when user is registering table userInfo
insert into userInfo (firstName,lastName) values(inpFirstName,inpLastName,inpUserPass);

--Inserting data when user is registering table userPassInfo
insert into userPassInfo (userPass,userEmail,userName) values(inpUserPass,inpUserEmail,inpUserName);

--Inserting data when user is registering table accountInfo
insert into userPassInfo (userPass,userEmail,userName) values(inpUserPass,inpUserEmail,inpUserName);

--Getting Users data when loging in.
insert into userPassInfo (userPass,userEmail,userName) values(inpUserPass,inpUserEmail,inpUserName);


--This is PL SQL for the tables and its Sequences

CREATE SEQUENCE   "ACCNUM_INC"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 900000000000 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE   "USERINFO_INC"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 50000 NOCACHE  NOORDER  NOCYCLE ;


--UserInfo Insert Procedure:

create or replace procedure "USERINFOINSERT"
(firstname IN VARCHAR2,
lastname IN VARCHAR2,
useremail IN VARCHAR2,
username IN VARCHAR2,
userpass IN VARCHAR2,
userinf_id OUT VARCHAR2)
is
begin
select USERINFO_INC.nextval into userinf_id from dual;
insert into userInfo(firstName,lastName,userEmail,userName,userPass) values (firstname,lastname,useremail,username,userpass);

end;


--AccountInfo Insert Procedure:
create or replace procedure "ACCOUNTINFOINSERT"
(accdiposit IN NUMBER,
acccheckings IN NUMBER,
accnumebr OUT NUMBER,
userinf_id IN NUMBER)
is
begin
select ACCNUM_INC.nextval into accNumebr from dual;
insert into accountInfo(accDiposit,accCheckings,userInf_id) values (accdiposit,acccheckings,userinf_id);
end;


--TransactionInfo Insert Procedure:



