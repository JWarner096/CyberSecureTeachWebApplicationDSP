# CyberSecureTeachWebApplicationDSP
My DSP web application
Jamie Warner

Web Application for DSP project

Created within NetBeans 8.2 RC with additional software of:

**GlassFish**: to host the web application and database
**Apache Derby DB**: for the Database information

**Java code found within**: src/java/
**Jsp's found within**: web/views/
**style css found within**: web/


**Code to input dummy data and create database:** 

CREATE TABLE "USERS" (
    "USERNAME" VARCHAR(30)primary key,
    "PASSWORD" VARCHAR(30),
    "ROLE" VARCHAR(5),
	"NAME" VARCHAR(30)
);

CREATE TABLE "SCORES" (
    "SID" INTEGER not null primary key
        generated always as identity (start with 1, increment by 1),
    "SSCORE" INT,
    "SUSERNAME" VARCHAR(30) references USERS(USERNAME)
);

CREATE TABLE "QUESTIONS" (
    "QID" INTEGER not null primary key
        generated always as identity (start with 1, increment by 1),
    "QUESTION" VARCHAR(250),
    "ANSWER" BOOLEAN
);




INSERT INTO USERS (USERNAME, PASSWORD, ROLE, NAME) VALUES ('j5warner', 'password', 'admin', 'Jamie Warner');
INSERT INTO USERS (USERNAME, PASSWORD, ROLE, NAME) VALUES ('dwarner', 'password', 'user', 'David Warner');

INSERT INTO SCORES (SSCORE, SUSERNAME) VALUES ('80', 'dwarner');

INSERT INTO QUESTIONS (QUESTION, ANSWER) VALUES ('Is Jamie the admin', true);
