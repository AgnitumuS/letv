1.��ͼ:
���ݿ����֮һ
��SQL ��������ֵĽ�ɫ�����ͬ��
����ͼ������һ����ʵ���ڵı���ֻ�Ƕ�Ӧ��һ��SELECT
����ѯ�Ľ������
ʹ����ͼ���������Ӳ�ѯ������SQL���ĸ��Ӷȡ�

��������10�Ų���Ա������Ϣ����ͼ
CREATE VIEW V_EMP_10
AS
SELECT EMPNO,ENAME,SAL,DEPTNO
FROM EMP
WHERE DEPTNO=10

SELECT *FROM v_EMP_10
DESC v_emp_10

��ͼ��Ӧ���Ӳ�ѯ�ֶο���ʹ�ñ�����
��ô����ͼ��Ӧ���ֶ���������������ˣ�
���ֶκ��к�������ʽ������ָ��������
CREATE OR REPLACE VIEW V_EMP_10
AS
SELECT EMPNO ID ,ENAME NAME,DEPTNO,SAL SALARY
FROM EMP
WHERE DEPTNO=10
SELECT id from v_emp_10

����ͼ����DML����
����ͼ����DML�������Ƕ���ͼ������Դ�Ļ������еġ�
ֻ�ܶԼ���ͼ����DML������������ͼ������ʹ��DML������
�Լ���ͼ����DML����ʱ��Ҳ����Υ�������Լ��������

INSERT INTO V_EMP_10(ID,NAME,DEPTNO,SALARY)
VALUES (1000,'JaaCK',10��5000)
SELECT *FROM V_EMP_10
SELECT *FROM EMP

��ͨ����ͼ����һ����ͼ�����ɼ�������ʱ�����ǶԻ������Ⱦ��
����������Ⱦ���޸�Ҳ����ɣ�����ɾ��������ɡ�
INSERT INTO V_EMP_10(ID,NAME,DEPTNO,SALARY)
VALUES(1000��'JACK',20��5000)
SELECT *FROM V_EMP_10
SELECT *FROM EMP

UPDATE V_EMP_10
SET DEPTNO=20
ɾ��������Ⱦ
DELETE FROM V_EMP_10 --ɾ��ֻ�����ͼ���е���ɾ�� ����20����ɾ��
WHERE DEPTNO=10

����ͼ��Ӽ��ѡ��
WITH CHECK OPTION
����ͼ����˼��ѡ�����ô����ͼ�����в�����޸�
����ʱ����ͼҪ��
����ʱ�������������ͼ�������ɼ�
�޸�ʱ���޸ĺ���ͼ��������ݿɼ�

CREATE OR REPLACE VIEW V_EMP_10
AS
  SELECT EMPNO ID,ENAME NAME, SAL SALARY, DEPTNO
  FROM EMP
WHERE DEPTNO=10
WITH CHECK OPTION --ɾ����Ӱ��

Ϊ��ͼ���ֻ��ѡ��
WITH READ ONLY
��һ����ͼ�����ֻ��ѡ��󣬸���ͼ���������DML������
CREATE OR REPLACE VIEW V_EMP_10
AS
  SELECT EMPNO ID,ENAME NAME ,SAL SALARY,DEPTNO
  FROM EMP
WHERE DEPTNO=10
WITH READ ONLY

�鿴�������������ݿ���󣨱����ͼ�� 
SELECT OBJECT_NAME
FROM USER_OBJECTS
WHERE OBJECT_TYPE='VIEW'

SELECT TEXT FROM USER_VIEWS--�鿴��ͼ�������

SELECT TABLE_NAME FROM USER_TABLES

������ͼ
��ѯ��京�к��������ʽ�����飬ȥ��
��������ѯ
������ͼ���ܽ���DML��
����һ�������Ź����������ͼ��
CREATE VIEW V_DEPT_SAL
AS SELECT D.DEPTNO,D.DNAME,
           MIN(E.SAL) MIN_SAL
          ,MAX(E.SAL) MAX_SAL
          ,AVG(E.SAL) AVG_SAL
          ,SUM(E.SAL) SUM_SAL
   FROM EMP E,DEPT D
   WHERE E.DEPTNO=D.DEPTNO
   GROUP BY D.DEPTNO,D.DNAME
   
SELECT *FROM V_DEPT_SAL    
���Ҹ��ڲ���ƽ�����ʵ�Ա����
SELECT E.ENAME,E.SAL,E.DEPTNO
FROM EMP E, V_DEPT_SAL D
WHERE E.DEPTNO=D.DEPTNO
AND   E.SAL>D.AVG_SAL
 
ɾ����ͼ
DROP VIEW V_EMP_10
SELECT *FROM V_EMP_10
ɾ����ͼ�е����ݻὫ��Ӧ�Ļ�������ɾ����
����ɾ����ͼ��������Ի������ݲ����κε�Ӱ�졣

����
����Ҳ�����ݿ����֮һ
��������������һϵ�����ֵġ�
����ͨ��Ϊ��������ṩֵʹ�á�

CREATE SEQUENCE SEQ_EMP_ID
START WITH 1
INCREMENT BY 1

����֧������α��
NEXTVAL��ʹ����������һ�����֣���������ɵ����ּ��ϲ����õ�����
�´����������򷵻�START WITH ָ�������֡�
�����ǲ��ܻ��˵ģ�����ͨ��NEXTVAL��ȡ����һ�����ֺ���޷��ٻ�ȡ֮ǰ���ɵ�
�����ˡ�
CURRVAL����ȡ�������ɵ����һ�����֣����۵��ö��ٴ�
�����ᵼ�����������µ����֣������´������������ٵ���һ��
NEXTVAL��ſ��Կ�ʼʹ��CURRVAL��

SELECT SEQ_EMP_ID.NEXTVAL
FROM DUAL

SELECT SEQ_EMP_ID.CURRVAL
FROM DUAL

ʹ��SEQ_EMP_IDΪEMP�������
����ֵ
INSERT INTO EMP
(EMPNO,ENAME,JOB,SAL,DEPTNO)
VALUES
(SEQ_EMP_ID.NEXTVAL,'JACK','SALESMAN',5000��10)

SELECT *FROM EMP
ɾ������
DROP SEQUENCE SEQ_EMP_ID

UUID
�ַ������͵�����ֵ��32λ���ظ��ַ���
ORACLE�ṩ��һ��������������UUID
SELECT SYS_GUID() FROM DUAL
����
CREATE INDEX IDX_EMP_ENAME ON EMP(ENAME)
��������
CREATE INDEX IDX_EMP_SAL_JOB ON EMP(JOB,SAL);
SELECT EMPNO,ENAME,SAL,JOB FROM EMP
ORDER BY JOB,SAL ---ע��˳��Ҫ������˳��һ�£�������Ч��
���ں���������
CREATE INDEX EMP_ENAME_UOOER_IDX
ON EMP(UPPER(ENAME))
���������ѯʱ���������������
SELECT *FROM EMP
WHERE UPPER(ENAME)='KING'
��������
ALTER INDEX IDX_EMP_ENAME REBUILD
ɾ������
DROP INDEX IDX_EMP_ENAME;
Լ��
CREATE TABLE EMPLOYEES(
  EID NUMBER(6),
  NAME VARCHAR2(30) not null,
  salary NUMBER(7,2),
  hiredate DATE CONSTRAINT EMPLOYEES_HIREDATE_NN NOT NULL
)
ALTER TABLE EMPLOYEES
MODIFY(EID NUMBER(6) NOT NULL)

ALTER TABLE EMPLOYEES
MODIFY(EID NUMBER(6)NULL)

DESC employees
SELECT *FROM EMPLOYEES

Ψһ��Լ��
��ĳ���ֶ�ʹ����Ψһ��Լ���󣬸��ֶε�ֵ�ڱ���
�ǲ��������ظ�ֵ�ģ�����NULL���⡣
CREATE TABLE EMPLOYEES1(
  EID NUMBER(6) UNIQUE,
  NAME VARCHAR2(30),
  EMAIL VARCHAR2(50),
  SALARY NUMBER(7��2),
  HIREDATE DATE,
  CONSTRAINT EMPLOYEES_EMAIL_UK UNIQUE (EMAIL)--��������ټ�Լ�� ��Լ��
)
DESC EMPLOYEES1
--�����ظ�EID��email ����
INSERT INTO EMPLOYEES1(EID,NAME,EMAIL)
VALUES (2��'JACK','JACK@QQ.COM')
INSERT INTO EMPLOYEES1(EID,NAME,EMAIL)
VALUES(NULL,'JACK',NULL)
SELECT *FROM EMPLOYEES1
DELETE FROM EMPLOYEES1

ALTER TABLE EMPLOYEES1
ADD CONSTRAINT EMPLOYEES_NAME_UK UNIQUE(NAME);
DESC EMPLOYEES1
����Լ��
�ǿ���Ψһ
CREATE TABLE EMPLOYEES2(
EID NUMBER(6)PRIMARY KEY,
NAME VARCHAR2(30),
EMAIL VARCHAR2(50),
SALARY NUMBER(7��2),
HIREDATE DATE
);
INSERT INTO EMPLOYEES2
(EID,NAME)
VALUES(1��'JACK')

INSERT INTO EMPLOYEES2
(EID,NAME)
VALUES(2��'JACK')

INSERT INTO EMPLOYEES2
(EID,NAME)
VALUES(NULL��'JACK')

SELECT *FROM EMPLOYEES2

ALTER TABLE EMPLOYEES2
ADD CONSTRAINT EMPLOYEES2_SALARY_CHECK
CHECK(SALARY>2000)
ALTER TABLE EMPLOYEES2
ADD CONSTRAINT EMPLOYEES2_SALARY_CHECK2
CHECK(SALARY<5000)


INSERT INTO EMPLOYEES2(EID,NAME,SALARY)
VALUES(1236��'JACK',2500)

INSERT INTO EMPLOYEES2(EID,NAME,SALARY)
VALUES(3��'JACK',2000)--С��2000�������

UPDATE EMPLOYEES2 SET SALARY=4500
WHERE EID=1236--Υ��Լ���������ܸ���


