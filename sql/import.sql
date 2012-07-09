--------------------------------------------------------
--  File created - poniedziałek-lipiec-09-2012   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence APP_USER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."APP_USER_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence CONFIG_STANDARD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."CONFIG_STANDARD_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DECLARATION_RECORD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."DECLARATION_RECORD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DECLARATION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TEST_APP"."DECLARATION_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20 NOCACHE  NOORDER  NOCYCLE ;
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
   (	"LOGIN" VARCHAR2(20), 
	"PASSWORD" VARCHAR2(40), 
	"ID" NUMBER(20,0)
   ) ;
--------------------------------------------------------
--  DDL for Table CONFIG_STANDARD
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."CONFIG_STANDARD" 
   (	"KEY" VARCHAR2(20), 
	"VALUE" VARCHAR2(20), 
	"ID" NUMBER(20,0), 
	"TYPE" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table DECLARATION
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DECLARATION" 
   (	"ID" NUMBER(20,0), 
	"USER" NUMBER(20,0), 
	"COMMIT_DATE" TIMESTAMP (6)
   ) ;
--------------------------------------------------------
--  DDL for Table DECLARATION_RECORD
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DECLARATION_RECORD" 
   (	"ID" NUMBER(20,0), 
	"VALUE" NUMBER(20,0), 
	"OWNERSHIP" NUMBER(20,0), 
	"SHARE_TYPE" NUMBER(20,0), 
	"ESTATE" NUMBER(20,0), 
	"INDEMNITY" NUMBER, 
	"DECLARATION_ID" NUMBER(20,0)
   ) ;
--------------------------------------------------------
--  DDL for Table DICT_ESTATE
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DICT_ESTATE" 
   (	"ID" NUMBER(20,0), 
	"VALUE" VARCHAR2(200)
   ) ;
--------------------------------------------------------
--  DDL for Table DICT_INDEMNITY
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DICT_INDEMNITY" 
   (	"ID" NUMBER(20,0), 
	"VALUE" VARCHAR2(200), 
	"TYPE" VARCHAR2(20), 
	"PARENT_ID" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table DICT_OWNERSHIP
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DICT_OWNERSHIP" 
   (	"ID" NUMBER(20,0), 
	"VALUE" VARCHAR2(1000)
   ) ;
--------------------------------------------------------
--  DDL for Table DICT_SHARE_TYPE
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."DICT_SHARE_TYPE" 
   (	"ID" NUMBER(20,0), 
	"VALUE" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table LOG_TABLE_CHANGES
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."LOG_TABLE_CHANGES" 
   (	"ID" NUMBER(20,0), 
	"ACTION" VARCHAR2(20), 
	"DETAIL" VARCHAR2(20), 
	"CREATE_DATE" DATE, 
	"ENTITY_NAME" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table USER_ROLE
--------------------------------------------------------

  CREATE TABLE "TEST_APP"."USER_ROLE" 
   (	"ID" NUMBER(20,0), 
	"ROLE_NAME" VARCHAR2(20), 
	"USER_ID" NUMBER
   ) ;
REM INSERTING into TEST_APP.APP_USER
SET DEFINE OFF;
Insert into TEST_APP.APP_USER (LOGIN,PASSWORD,ID) values ('Rambo','123','1');
Insert into TEST_APP.APP_USER (LOGIN,PASSWORD,ID) values ('Shaft','123','2');
Insert into TEST_APP.APP_USER (LOGIN,PASSWORD,ID) values ('Kapitan Żbik','123','3');
REM INSERTING into TEST_APP.CONFIG_STANDARD
SET DEFINE OFF;
Insert into TEST_APP.CONFIG_STANDARD (KEY,VALUE,ID,TYPE) values ('NEW_PARAM','Value','1','STRING');
Insert into TEST_APP.CONFIG_STANDARD (KEY,VALUE,ID,TYPE) values ('MAX_CREDIT','30001','2','NUMBER');
REM INSERTING into TEST_APP.DECLARATION
SET DEFINE OFF;
REM INSERTING into TEST_APP.DECLARATION_RECORD
SET DEFINE OFF;
REM INSERTING into TEST_APP.DICT_ESTATE
SET DEFINE OFF;
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('1','lokal mieszkalny');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('2','dom mieszkalny');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('3','budynek wielolokatowy');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('4','dziaĹ‚ka');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('5','garaĹĽ');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('6','miejsce postojowe');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('7','lokal mieszkalny z garaĹĽem');
REM INSERTING into TEST_APP.DICT_INDEMNITY
SET DEFINE OFF;
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('1','dom','MAIN',null);
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('2','meble','CHILD','1');
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('3','agd','CHILD','1');
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('4','samochĂłd','MAIN',null);
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('5','radio','CHILD','4');
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('6','benzyna','CHILD','4');
REM INSERTING into TEST_APP.DICT_OWNERSHIP
SET DEFINE OFF;
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('1','kolektywna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('2','prywatna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('4','kwirytarna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('3','indywidualna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('5','podwĂłjna');
REM INSERTING into TEST_APP.DICT_SHARE_TYPE
SET DEFINE OFF;
Insert into TEST_APP.DICT_SHARE_TYPE (ID,VALUE) values ('1','peĹ‚ne prawo');
Insert into TEST_APP.DICT_SHARE_TYPE (ID,VALUE) values ('2','czÄ™Ĺ›ciowy udziaĹ‚');
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

  CREATE UNIQUE INDEX "TEST_APP"."APP_INDEMNITY_DICT_PK" ON "TEST_APP"."DICT_INDEMNITY" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index APP_DICT_SHARE_TYPE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_DICT_SHARE_TYPE_PK" ON "TEST_APP"."DICT_SHARE_TYPE" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index APP_DICT_OWNERSHIP_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_DICT_OWNERSHIP_PK" ON "TEST_APP"."DICT_OWNERSHIP" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index APP_DECLARATION_RECORD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_DECLARATION_RECORD_PK" ON "TEST_APP"."DECLARATION_RECORD" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index APP_USER_LOGIN_UNIQUE
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_USER_LOGIN_UNIQUE" ON "TEST_APP"."APP_USER" ("LOGIN") 
  ;
--------------------------------------------------------
--  DDL for Index USER_ROLE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."USER_ROLE_PK" ON "TEST_APP"."USER_ROLE" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index APP_DECLARATION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_DECLARATION_PK" ON "TEST_APP"."DECLARATION" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index APP_USER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_USER_PK" ON "TEST_APP"."APP_USER" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index CONFIG_STANDARD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."CONFIG_STANDARD_PK" ON "TEST_APP"."CONFIG_STANDARD" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index APP_ESTATE_DICT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_ESTATE_DICT_PK" ON "TEST_APP"."DICT_ESTATE" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index APP_CONFIG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."APP_CONFIG_PK" ON "TEST_APP"."CONFIG_STANDARD" ("KEY") 
  ;
--------------------------------------------------------
--  DDL for Index USER_ROLE_USER_ROLE_PAIR
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST_APP"."USER_ROLE_USER_ROLE_PAIR" ON "TEST_APP"."USER_ROLE" ("ROLE_NAME", "USER_ID") 
  ;
--------------------------------------------------------
--  Constraints for Table DICT_ESTATE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_ESTATE" ADD CONSTRAINT "APP_ESTATE_DICT_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DICT_ESTATE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DICT_INDEMNITY
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_INDEMNITY" ADD CONSTRAINT "APP_INDEMNITY_DICT_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DICT_INDEMNITY" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DICT_INDEMNITY" ADD CONSTRAINT "TYPECONSTRAINT" CHECK (TYPE = 'MAIN' or TYPE='CHILD') ENABLE;
--------------------------------------------------------
--  Constraints for Table DICT_OWNERSHIP
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_OWNERSHIP" ADD CONSTRAINT "APP_DICT_OWNERSHIP_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DICT_OWNERSHIP" MODIFY ("VALUE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DICT_OWNERSHIP" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DICT_SHARE_TYPE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_SHARE_TYPE" ADD CONSTRAINT "APP_DICT_SHARE_TYPE_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DICT_SHARE_TYPE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DECLARATION_RECORD
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "APP_DECLARATION_RECORD_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("SHARE_TYPE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("OWNERSHIP" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("VALUE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DECLARATION
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DECLARATION" ADD CONSTRAINT "APP_DECLARATION_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION" MODIFY ("USER" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."DECLARATION" MODIFY ("COMMIT_DATE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table APP_USER
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."APP_USER" ADD CONSTRAINT "APP_USER_LOGIN_UNIQUE" UNIQUE ("LOGIN") ENABLE;
 
  ALTER TABLE "TEST_APP"."APP_USER" ADD CONSTRAINT "APP_USER_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."APP_USER" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."APP_USER" MODIFY ("PASSWORD" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."APP_USER" MODIFY ("LOGIN" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_ROLE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."USER_ROLE" MODIFY ("USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."USER_ROLE" MODIFY ("ROLE_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."USER_ROLE" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "TEST_APP"."USER_ROLE" ADD CONSTRAINT "USER_ROLE_PK" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."USER_ROLE" ADD CONSTRAINT "USER_ROLE_USER_ROLE_PAIR" UNIQUE ("ROLE_NAME", "USER_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table CONFIG_STANDARD
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."CONFIG_STANDARD" ADD CONSTRAINT "CONFIG_STANDARD_PK" PRIMARY KEY ("ID") ENABLE;
 
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

  ALTER TABLE "TEST_APP"."DECLARATION" ADD CONSTRAINT "APP_DECLARATION_APP_USER_FK1" FOREIGN KEY ("USER")
	  REFERENCES "TEST_APP"."APP_USER" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DECLARATION_RECORD
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "DECLARATION_FK" FOREIGN KEY ("DECLARATION_ID")
	  REFERENCES "TEST_APP"."DECLARATION" ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "ESTATE_FK" FOREIGN KEY ("ESTATE")
	  REFERENCES "TEST_APP"."DICT_ESTATE" ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "INDEMNITY_FK" FOREIGN KEY ("INDEMNITY")
	  REFERENCES "TEST_APP"."DICT_INDEMNITY" ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "OWNERSHIP_FK" FOREIGN KEY ("OWNERSHIP")
	  REFERENCES "TEST_APP"."DICT_OWNERSHIP" ("ID") ENABLE;
 
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "SHARE_FK" FOREIGN KEY ("SHARE_TYPE")
	  REFERENCES "TEST_APP"."DICT_SHARE_TYPE" ("ID") ENABLE;

--------------------------------------------------------
--  Ref Constraints for Table DICT_INDEMNITY
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_INDEMNITY" ADD CONSTRAINT "SELFJOIN_FK" FOREIGN KEY ("PARENT_ID")
	  REFERENCES "TEST_APP"."DICT_INDEMNITY" ("ID") ENABLE;



--------------------------------------------------------
--  Ref Constraints for Table USER_ROLE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."USER_ROLE" ADD CONSTRAINT "USER_ROLE_USER" FOREIGN KEY ("USER_ID")
	  REFERENCES "TEST_APP"."APP_USER" ("ID") ENABLE;
