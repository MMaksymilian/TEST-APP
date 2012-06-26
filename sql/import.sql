--------------------------------------------------------
--  File created - wtorek-czerwiec-26-2012   
--------------------------------------------------------
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
	"VALUE" VARCHAR2(20)
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
REM INSERTING into TEST_APP.APP_USER
SET DEFINE OFF;
Insert into TEST_APP.APP_USER (LOGIN,PASSWORD,ID) values ('Rambo','123','1');
Insert into TEST_APP.APP_USER (LOGIN,PASSWORD,ID) values ('Shaft','123','2');
REM INSERTING into TEST_APP.CONFIG_STANDARD
SET DEFINE OFF;
Insert into TEST_APP.CONFIG_STANDARD (KEY,VALUE) values ('MAX_CREDIT','100000');
REM INSERTING into TEST_APP.DECLARATION
SET DEFINE OFF;
REM INSERTING into TEST_APP.DECLARATION_RECORD
SET DEFINE OFF;
REM INSERTING into TEST_APP.DICT_ESTATE
SET DEFINE OFF;
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('1','lokal mieszkalny');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('2','dom mieszkalny');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('3','budynek wielolokatowy');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('4','działka');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('5','garaż');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('6','miejsce postojowe');
Insert into TEST_APP.DICT_ESTATE (ID,VALUE) values ('7','lokal mieszkalny z garażem');
REM INSERTING into TEST_APP.DICT_INDEMNITY
SET DEFINE OFF;
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('1','dom','MAIN',null);
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('2','meble','CHILD','1');
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('3','agd','CHILD','1');
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('4','samochód','MAIN',null);
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('5','radio','CHILD','4');
Insert into TEST_APP.DICT_INDEMNITY (ID,VALUE,TYPE,PARENT_ID) values ('6','benzyna','CHILD','4');
REM INSERTING into TEST_APP.DICT_OWNERSHIP
SET DEFINE OFF;
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('1','kolektywna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('2','prywatna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('4','kwirytarna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('3','indywidualna');
Insert into TEST_APP.DICT_OWNERSHIP (ID,VALUE) values ('5','podwójna');
REM INSERTING into TEST_APP.DICT_SHARE_TYPE
SET DEFINE OFF;
Insert into TEST_APP.DICT_SHARE_TYPE (ID,VALUE) values ('1','pełne prawo');
Insert into TEST_APP.DICT_SHARE_TYPE (ID,VALUE) values ('2','częściowy udział');
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
--  Constraints for Table DICT_ESTATE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_ESTATE" ADD CONSTRAINT "APP_ESTATE_DICT_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "TEST_APP"."DICT_ESTATE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DICT_SHARE_TYPE
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_SHARE_TYPE" ADD CONSTRAINT "APP_DICT_SHARE_TYPE_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "TEST_APP"."DICT_SHARE_TYPE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DICT_INDEMNITY
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_INDEMNITY" ADD CONSTRAINT "TYPECONSTRAINT" CHECK (TYPE = 'MAIN' or TYPE='CHILD') ENABLE;
  ALTER TABLE "TEST_APP"."DICT_INDEMNITY" ADD CONSTRAINT "APP_INDEMNITY_DICT_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "TEST_APP"."DICT_INDEMNITY" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CONFIG_STANDARD
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."CONFIG_STANDARD" ADD CONSTRAINT "APP_CONFIG_PK" PRIMARY KEY ("KEY") ENABLE;
  ALTER TABLE "TEST_APP"."CONFIG_STANDARD" MODIFY ("VALUE" NOT NULL ENABLE);
  ALTER TABLE "TEST_APP"."CONFIG_STANDARD" MODIFY ("KEY" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DICT_OWNERSHIP
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DICT_OWNERSHIP" ADD CONSTRAINT "APP_DICT_OWNERSHIP_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "TEST_APP"."DICT_OWNERSHIP" MODIFY ("VALUE" NOT NULL ENABLE);
  ALTER TABLE "TEST_APP"."DICT_OWNERSHIP" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DECLARATION_RECORD
--------------------------------------------------------

  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("SHARE_TYPE" NOT NULL ENABLE);
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("OWNERSHIP" NOT NULL ENABLE);
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("VALUE" NOT NULL ENABLE);
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "TEST_APP"."DECLARATION_RECORD" ADD CONSTRAINT "APP_DECLARATION_RECORD_PK" PRIMARY KEY ("ID") ENABLE;
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

  ALTER TABLE "TEST_APP"."APP_USER" ADD CONSTRAINT "APP_USER_PK" PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "TEST_APP"."APP_USER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "TEST_APP"."APP_USER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "TEST_APP"."APP_USER" MODIFY ("LOGIN" NOT NULL ENABLE);


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

