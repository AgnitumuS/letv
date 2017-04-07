1:����һ����ͼ������20�Ų��ŵ�Ա����Ϣ���ֶ�:empno,ename,sal,job,deptno
CREATE VIEW V_EMP_20
AS 
SELECT EMPNO,ENAME,SAL,JOB,DEPTNO
FROM EMP
WHERE DEPTNO=20
SELECT *FROM V_EMP_20


2:����һ������seq_emp_no,��10��ʼ������Ϊ10
CREATE SEQUENCE SEQ_EMP_NO
START WITH 10
INCREMENT BY 10


3:��дSQL���鿴seq_emp_no���е���һ������
SELECT SEQ_EMP_NO.NEXTVAL FROM DUAL

4:��дSQL���鿴seq_emp_no���еĵ�ǰ����
SELECT SEQ_EMP_NO.CURRVAL FROM DUAL
5:Ϊemp���ename�ֶ��������:idx_emp_ename 
CREATE INDEX IDX_EMP_ENAME  ON EMP(ENAME)

6:Ϊemp���LOWER(ename)�ֶ��������:idx_emp_lower_ename
CREATE INDEX IDX_EMP_LOWER_ENAME ON EMP(LOWER(ENAME))

7:Ϊemp���sal,comm��Ӷ�������
CREATE INDEX IDX_EMP_SAL_COMM ON EMP(SAL,COMM)

8:����myemployee���ֶ�:
  id NUMBER(4) ,
  nameVARCHAR2(20),
  birthday DATE,
  telephone VARCHAR2(11)
  scoreNUMBER(9,2)
  ����id��Ϊ������nameҪ����Ϊ��,telephone��ҪΨһ,scoreֵ����>=0
  CREATE TABLE MYEMPLOYEE1(
  ID NUMBER(4) PRIMARY KEY,
  NAME VARCHAR2(20) NOT NULL,
  BIRTHDAY DATE,
  TELEPHONE VARCHAR2(11) UNIQUE,
  SCORE NUMBER(9��2) CHECK(SCORE>=0) )
  
  INSERT INTO MYEMPLOYEE1(ID,NAME,BIRTHDAY,TELEPHONE,SCORE)
  VALUES(2��'J',TO_DATE('1998-1-1','YYYY-MM-DD'),'188',-1)
  
  SELECT *FROM MYEMPLOYEE1
  
  
  
  
  
  
  
  
  
  
  