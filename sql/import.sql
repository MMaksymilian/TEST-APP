--------------------------------------------------------
--  File created - niedziela-lipiec-29-2012   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence APP_USER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."APP_USER_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence CONFIG_STANDARD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."CONFIG_STANDARD_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 48 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DECLARATION_RECORD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."DECLARATION_RECORD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 37 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DECLARATION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."DECLARATION_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 28 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DICT_INDEMNITY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."DICT_INDEMNITY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DICT_OWNERSHIP_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."DICT_OWNERSHIP_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DICT_SHARE_TYPE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."DICT_SHARE_TYPE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence LOG_TABLE_CHANGES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."LOG_TABLE_CHANGES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence USER_ROLE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."USER_ROLE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table APP_USER
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."APP_USER" 
   (	"LOGIN" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(40 BYTE), 
	"ID" NUMBER(20,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CONFIG_STANDARD
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."CONFIG_STANDARD" 
   (	"KEY" VARCHAR2(20 BYTE), 
	"VALUE" VARCHAR2(20 BYTE), 
	"ID" NUMBER(20,0), 
	"TYPE" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DECLARATION
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DECLARATION" 
   (	"ID" NUMBER(20,0), 
	"USER_ID" NUMBER(20,0), 
	"COMMIT_DATE" TIMESTAMP (6), 
	"CREDIT_AMOUNT" NUMBER(18,2), 
	"ESTATE_VALUE" NUMBER(18,2), 
	"INTEREST" NUMBER(18,2), 
	"TYPE" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DECLARATION_RECORD
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DECLARATION_RECORD" 
   (	"ID" NUMBER(20,0), 
	"VALUE" NUMBER(22,2), 
	"OWNERSHIP" NUMBER(20,0), 
	"SHARE_TYPE" NUMBER(20,0), 
	"ESTATE_ID" NUMBER, 
	"DECLARATION_ID" NUMBER(20,0), 
	"PARENT_RECORD_ID" NUMBER(20,0), 
	"TYPE" VARCHAR2(10 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DICT_ESTATE
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DICT_ESTATE" 
   (	"ID" NUMBER(20,0), 
	"VALUE" VARCHAR2(200 BYTE), 
	"TYPE" VARCHAR2(20 BYTE), 
	"PARENT_ID" NUMBER
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DICT_OWNERSHIP
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DICT_OWNERSHIP" 
   (	"ID" NUMBER(20,0), 
	"VALUE" VARCHAR2(1000 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DICT_SHARE_TYPE
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DICT_SHARE_TYPE" 
   (	"ID" NUMBER(20,0), 
	"VALUE" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOG_TABLE_CHANGES
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."LOG_TABLE_CHANGES" 
   (	"ID" NUMBER(20,0), 
	"ACTION" VARCHAR2(20 BYTE), 
	"DETAIL" VARCHAR2(20 BYTE), 
	"CREATE_DATE" DATE, 
	"ENTITY_NAME" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USER_ROLE
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."USER_ROLE" 
   (	"ID" NUMBER(20,0), 
	"ROLE_NAME" VARCHAR2(20 BYTE), 
	"USER_ID" NUMBER
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into TEST_APP.APP_USER
SET DEFINE OFF;
Insert into TEST_APP.APP_USER (LOGIN,PASSWORD,ID) values ('admin','admin','1');
Insert into TEST_APP.APP_USER (LOGIN,PASSWORD,ID) values ('user','user','2');
REM INSERTING into TEST_APP.CONFIG_STANDARD
SET DEFINE OFF;
Insert into TEST_APP.CONFIG_STANDARD (KEY,VALUE,ID,TYPE) values ('MAX_CREDIT','70000','2','NUMBER');
REM INSERTING into TEST_APP.DECLARATION
SET DEFINE OFF;
Insert into TEST_APP.DECLARATION (ID,USER_ID,COMMIT_DATE,CREDIT_AMOUNT,ESTATE_VALUE,INTEREST,TYPE) values ('24','2',to_timestamp('12/07/29 21:09:27,705000000','RR/MM/DD HH24:MI:SS,FF'),'23000','56449','0,2',null);
Insert into TEST_APP.DECLARATION (ID,USER_ID,COMMIT_DATE,CREDIT_AMOUNT,ESTATE_VALUE,INTEREST,TYPE) values ('25','2',to_timestamp('12/07/29 21:23:14,160000000','RR/MM/DD HH24:MI:SS,FF'),'23000','5433','0,1',null);
Insert into TEST_APP.DECLARATION (ID,USER_ID,COMMIT_DATE,CREDIT_AMOUNT,ESTATE_VALUE,INTEREST,TYPE) values ('26','2',to_timestamp('12/07/29 21:57:33,943000000','RR/MM/DD HH24:MI:SS,FF'),'20001','4688','0,9',null);
Insert into TEST_APP.DECLARATION (ID,USER_ID,COMMIT_DATE,CREDIT_AMOUNT,ESTATE_VALUE,INTEREST,TYPE) values ('27','2',to_timestamp('12/07/29 23:45:42,739000000','RR/MM/DD HH24:MI:SS,FF'),'34000','456211','4,54',null);
Insert into TEST_APP.DECLARATION (ID,USER_ID,COMMIT_DATE,CREDIT_AMOUNT,ESTATE_VALUE,INTEREST,TYPE) values ('23','2',to_timestamp('12/07/29 20:55:40,935000000','RR/MM/DD HH24:MI:SS,FF'),'23000','6899','0,49',null);
REM INSERTING into TEST_APP.DECLARATION_RECORD
SET DEFINE OFF;
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('25','49999','3','1','1','24',null,'MAIN');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('26','2400','4','1','3','24','25','CHILD');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('27','4000','2','2','4','24',null,'MAIN');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('28','50','5','2','6','24','27','CHILD');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('29','2000','1','1','4','25',null,'MAIN');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('30','33','1','2','8','25','29','CHILD');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('31','3400','1','1','6','25','29','CHILD');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('32','3344','2','1','4','26',null,'MAIN');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('33','900','4','1','8','26','32','CHILD');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('34','444','3','2','5','26','32','CHILD');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('35','455656','1','1','1','27',null,'MAIN');
Insert into TEST_APP.DECLARATION_RECORD (ID,VALUE,OWNERSHIP,SHARE_TYPE,ESTATE_ID,DECLARATION_ID,PARENT_RECORD_ID,TYPE) values ('36','555','4','1','3','27','35','CHILD');
REM INSERTING into TEST_APP.DICT_ESTATE
SET DEFINE OFF;
Insert into TEST_APP.DICT_ESTATE (ID,VALUE,TYPE,PARENT_ID) values ('1','dom mieszkalny','MAIN',null);
Insert into TEST_APP.DICT_ESTATE (ID,VALUE,TYPE,PARENT_ID) values ('2','dzia�ka','CHILD','1');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE,TYPE,PARENT_ID) values ('3','gara�','CHILD','1');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE,TYPE,PARENT_ID) values ('4','budynek wielolokalowy','MAIN',null);
Insert into TEST_APP.DICT_ESTATE (ID,VALUE,TYPE,PARENT_ID) values ('5','lokal mieszkalny','CHILD','4');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE,TYPE,PARENT_ID) values ('6','lokal mieszkalny z gara�em','CHILD','4');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE,TYPE,PARENT_ID) values ('7','miejsce postojowe','CHILD','1');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE,TYPE,PARENT_ID) values ('8','ten mo�na zmieni�','CHILD','4');
REM INSERTING into TEST_APP.DICT_OWNERSHIP
SET DEFINE OFF;
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('1','kolektywna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('2','prywatna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('4','kwirytarna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('3','indywidualna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('5','podwójna');
REM INSERTING into TEST_APP.DICT_SHARE_TYPE
SET DEFINE OFF;
Insert into TEST_APP.DICT_SHARE_TYPE (ID,VALUE) values ('1','pe�ne prawo');
Insert into TEST_APP.DICT_SHARE_TYPE (ID,VALUE) values ('2','cz�ciowy udzia�');
REM INSERTING into TEST_APP.LOG_TABLE_CHANGES
SET DEFINE OFF;
REM INSERTING into TEST_APP.USER_ROLE
SET DEFINE OFF;
Insert into TEST_APP.USER_ROLE (ID,ROLE_NAME,USER_ID) values ('3','ADMIN','1');
Insert into TEST_APP.USER_ROLE (ID,ROLE_NAME,USER_ID) values ('1','USER_ROLE','1');
Insert into TEST_APP.USER_ROLE (ID,ROLE_NAME,USER_ID) values ('2','USER_ROLE','2');
--------------------------------------------------------
--  DDL for Index APP_INDEMNITY_DICT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_INDEMNITY_DICT_PK" ON "TEST_APP"."DICT_ESTATE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index APP_DICT_SHARE_TYPE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_DICT_SHARE_TYPE_PK" ON "TEST_APP"."DICT_SHARE_TYPE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index APP_DICT_OWNERSHIP_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_DICT_OWNERSHIP_PK" ON "TEST_APP"."DICT_OWNERSHIP" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index APP_DECLARATION_RECORD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_DECLARATION_RECORD_PK" ON "TEST_APP"."DECLARATION_RECORD" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index APP_USER_LOGIN_UNIQUE
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_USER_LOGIN_UNIQUE" ON "TEST_APP"."APP_USER" ("LOGIN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USER_ROLE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."USER_ROLE_PK" ON "TEST_APP"."USER_ROLE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index APP_DECLARATION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_DECLARATION_PK" ON "TEST_APP"."DECLARATION" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index APP_USER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_USER_PK" ON "TEST_APP"."APP_USER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index CONFIG_STANDARD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."CONFIG_STANDARD_PK" ON "TEST_APP"."CONFIG_STANDARD" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index APP_CONFIG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_CONFIG_PK" ON "TEST_APP"."CONFIG_STANDARD" ("KEY") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USER_ROLE_USER_ROLE_PAIR
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."USER_ROLE_USER_ROLE_PAIR" ON "TEST_APP"."USER_ROLE" ("ROLE_NAME", "USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DICT_ESTATE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_ESTATE" ADD CONSTRAINT "APP_INDEMNITY_DICT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST_APP"."DICT_ESTATE" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DICT_ESTATE" ADD CONSTRAINT "TYPECONSTRAINT" CHECK (TYPE = 'MAIN' or TYPE='CHILD') ENABLE;
--------------------------------------------------------
--  Constraints for Table DICT_OWNERSHIP
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_OWNERSHIP" ADD CONSTRAINT "APP_DICT_OWNERSHIP_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST_APP"."DICT_OWNERSHIP" MODIFY ("VALUE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DICT_OWNERSHIP" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DICT_SHARE_TYPE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_SHARE_TYPE" ADD CONSTRAINT "APP_DICT_SHARE_TYPE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST_APP"."DICT_SHARE_TYPE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DECLARATION_RECORD
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "APP_DECLARATION_RECORD_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("SHARE_TYPE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("OWNERSHIP" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("VALUE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DECLARATION
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DECLARATION" ADD CONSTRAINT "APP_DECLARATION_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION" MODIFY ("USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION" MODIFY ("COMMIT_DATE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION" MODIFY ("CREDIT_AMOUNT" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION" MODIFY ("ESTATE_VALUE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION" MODIFY ("INTEREST" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table APP_USER
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."APP_USER" ADD CONSTRAINT "APP_USER_LOGIN_UNIQUE" UNIQUE ("LOGIN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST_APP"."APP_USER" ADD CONSTRAINT "APP_USER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST_APP"."APP_USER" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."APP_USER" MODIFY ("PASSWORD" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."APP_USER" MODIFY ("LOGIN" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_ROLE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."USER_ROLE" MODIFY ("USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."USER_ROLE" MODIFY ("ROLE_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."USER_ROLE" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."USER_ROLE" ADD CONSTRAINT "USER_ROLE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST_APP"."USER_ROLE" ADD CONSTRAINT "USER_ROLE_USER_ROLE_PAIR" UNIQUE ("ROLE_NAME", "USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CONFIG_STANDARD
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."CONFIG_STANDARD" ADD CONSTRAINT "CONFIG_STANDARD_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST_APP"."CONFIG_STANDARD" MODIFY ("VALUE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."CONFIG_STANDARD" MODIFY ("KEY" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."CONFIG_STANDARD" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOG_TABLE_CHANGES
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."LOG_TABLE_CHANGES" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."LOG_TABLE_CHANGES" MODIFY ("ACTION" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."LOG_TABLE_CHANGES" MODIFY ("DETAIL" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."LOG_TABLE_CHANGES" MODIFY ("CREATE_DATE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."LOG_TABLE_CHANGES" MODIFY ("ENTITY_NAME" NOT NULL ENABLE);


--------------------------------------------------------
--  Ref Constraints for Table DECLARATION
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DECLARATION" ADD CONSTRAINT "APP_DECLARATION_APP_USER_FK1" FOREIGN KEY ("USER_ID")
	  REFERENCES "TEST_APP"."APP_USER" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DECLARATION_RECORD
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "DECLARATION_FK" FOREIGN KEY ("DECLARATION_ID")
	  REFERENCES "TEST_APP"."DECLARATION" ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "INDEMNITY_FK" FOREIGN KEY ("ESTATE_ID")
	  REFERENCES "TEST_APP"."DICT_ESTATE" ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "OWNERSHIP_FK" FOREIGN KEY ("OWNERSHIP")
	  REFERENCES "TEST_APP"."DICT_OWNERSHIP" ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "SHARE_FK" FOREIGN KEY ("SHARE_TYPE")
	  REFERENCES "TEST_APP"."DICT_SHARE_TYPE" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DICT_ESTATE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_ESTATE" ADD CONSTRAINT "SELFJOIN_FK" FOREIGN KEY ("PARENT_ID")
	  REFERENCES "TEST_APP"."DICT_ESTATE" ("ID") ENABLE;



--------------------------------------------------------
--  Ref Constraints for Table USER_ROLE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."USER_ROLE" ADD CONSTRAINT "USER_ROLE_USER" FOREIGN KEY ("USER_ID")
	  REFERENCES "TEST_APP"."APP_USER" ("ID") ENABLE;
