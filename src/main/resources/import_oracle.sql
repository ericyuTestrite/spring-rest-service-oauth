CREATE TABLE OAUTH_ACCESS_TOKEN (
  TOKEN_ID VARCHAR2(256) NOT NULL,
  TOKEN CLOB,
  AUTHENTICATION_ID VARCHAR2(256) ,
  USER_NAME VARCHAR2(256) ,
  CLIENT_ID VARCHAR2(256) ,
  AUTHENTICATION CLOB,
  REFRESH_TOKEN VARCHAR2(256) ,
  PRIMARY KEY (TOKEN_ID)
);

CREATE TABLE OAUTH_CLIENT_DETAILS (
  CLIENT_ID VARCHAR2(256) NOT NULL,
  RESOURCE_IDS VARCHAR2(256) ,
  CLIENT_SECRET VARCHAR2(256) ,
  SCOPE VARCHAR2(256) ,
  AUTHORIZED_GRANT_TYPES VARCHAR2(256) ,
  WEB_SERVER_REDIRECT_URI VARCHAR2(256) ,
  AUTHORITIES VARCHAR2(256) ,
  ACCESS_TOKEN_VALIDITY INT(11) ,
  REFRESH_TOKEN_VALIDITY INT(11) ,
  ADDITIONAL_INFORMATION VARCHAR2(4096) ,
  AUTOAPPROVE VARCHAR2(256) ,
  PRIMARY KEY (CLIENT_ID)
);

CREATE TABLE OAUTH_CODE (
  CODE VARCHAR2(256) ,
  AUTHENTICATION CLOB
);

CREATE TABLE OAUTH_REFRESH_TOKEN (
  TOKEN_ID VARCHAR2(256) ,
  TOKEN CLOB,
  AUTHENTICATION CLOB
);

INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID,RESOURCE_IDS,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE) VALUES ('clientapp','restservice','123456','read,write','password,refresh_token','','USER',64800,NULL,'{}','');
INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID,RESOURCE_IDS,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE) VALUES ('my-client-with-registered-redirect',NULL,NULL,'read,trust','authorization_code,client_credentials','http://anywhere?key=value','ROLE_CLIENT',NULL,NULL,NULL,NULL);
INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID,RESOURCE_IDS,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE) VALUES ('my-client-with-secret',NULL,'secret','read','client_credentials',NULL,'ROLE_CLIENT',NULL,NULL,NULL,NULL);
INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID,RESOURCE_IDS,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE) VALUES ('my-less-trusted-autoapprove-client',NULL,NULL,'read,write,trust','implicit',NULL,'ROLE_CLIENT',NULL,NULL,NULL,NULL);
INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID,RESOURCE_IDS,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE) VALUES ('my-less-trusted-client',NULL,NULL,NULL,'authorization_code,implicit',NULL,'ROLE_CLIENT',NULL,NULL,NULL,NULL);
INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID,RESOURCE_IDS,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE) VALUES ('my-trusted-client',NULL,NULL,'read,write,trust','password,authorization_code,refresh_token,implicit',NULL,'ROLE_CLIENT, ROLE_TRUSTED_CLIENT',60,NULL,NULL,NULL);
INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID,RESOURCE_IDS,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE) VALUES ('my-trusted-client-with-secret',NULL,'somesecret',NULL,'password,authorization_code,refresh_token,implicit',NULL,'ROLE_CLIENT, ROLE_TRUSTED_CLIENT',NULL,NULL,NULL,NULL);
INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID,RESOURCE_IDS,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE) VALUES ('my-untrusted-client-with-registered-redirect',NULL,NULL,'read','authorization_code','http://anywhere','ROLE_CLIENT',NULL,NULL,NULL,NULL);
INSERT INTO OAUTH_CLIENT_DETAILS (CLIENT_ID,RESOURCE_IDS,CLIENT_SECRET,SCOPE,AUTHORIZED_GRANT_TYPES,WEB_SERVER_REDIRECT_URI,AUTHORITIES,ACCESS_TOKEN_VALIDITY,REFRESH_TOKEN_VALIDITY,ADDITIONAL_INFORMATION,AUTOAPPROVE) VALUES ('tonr','sparklr','secret','read,write','authorization_code,implicit,refresh_token',NULL,'ROLE_CLIENT, ROLE_TRUSTED_CLIENT',NULL,NULL,NULL,NULL);
