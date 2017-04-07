������
CREATE TABLE employee_lee(
  id NUMBER(4),
  name VARCHAR2(20),
  gender CHAR(1),
  birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)

);
�鿴��ṹ
DESC employee_lee;
����Ĭ��ֵ
�����ݿ��У������ֶ���ʲô���ͣ�Ĭ��ֵ����null�����ǿ����ڴ������
ʱ��ͨ��DEFAULT�ؼ���Ϊָ�����е�������Ĭ��ֵ��
�����ݿ��У��ַ���ʹ�õ����ű�ʾ����������һ���java��һ������Ҫע�⣡

ɾ����
DROP TABLE employee_lee;
DROP TABLE student;
CREATE TABLE employee_lee(
  id NUMBER(4),
  name VARCHAR2(20),
  gender CHAR(1) DEFAULT 'M',
  birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);
DESC employee_lee;
DROP TABLE employee_lee;
CREATE TABLE employee_lee(
  id NUMBER(4),
  name VARCHAR2(20) NOT NULL,
  gender CHAR(1) DEFAULT 'M',
  birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);
DESC employee_lee;
�޸ı�
�޸ı�����
RENAME employee_lee to myemp_lee;
DESE employee_lee;
DESC employee_lee;
DESC myemp_lee;
2���޸ı�ṹ
2.1��������ֶ�
���������µ��ֶΣ�ֻ���ڵ�ǰ���ĩβ׷�ӡ�����ͬʱ׷�Ӷ���У�
ֻ��Ҫʹ�ö��Ÿ������ɣ��봴����������ʱ���﷨һ�¡�
ALTER TABLE myemp_lee ADD(
  hiredate DATE DEFAULT SYSDATE
);
DESC myemp_lee
2.2ɾ�����������ֶ�
ɾ��myemp���е�hiredate�ֶ�
ALTER TABLE myemp_lee DROP(
  hiredate
)
DESC myemp_lee;
2.3 �޸ı��������ֶ�
�����޸��ֶε����ͣ����ȣ�Ĭ��ֵ���ǿ�
ALTER TABLE myemp_lee MODIFY(
  job VARCHAR2(40) DEFAULT 'CLERK'
) 
DESC myemp_lee;

DML ���
�����޸ı������ݣ���Ϊ������ɾ����

INSERT INTO myemp_lee(id,name,job,salary)
VALUES(1,'jack','CLERK',5000)
COMMIT
SELECT * FROM myemp_lee

�����������ͣ�����ʹ��TO-DATE������
����ʹ���ַ��������Ǹ�ʽ�����ǡ�DD-MON-RR���������Բ��죬���Ƽ���
INSERT INTO myemp_lee(id,name,job,birth)
VALUES(2,'rose','CLERK',TO_DATE('1992-08-02','YY-MM-DD'))
COMMIT
2:�޸ı��е���������
��rose�Ĺ��ʸ�Ϊ5500
UPDATE myemp_lee 
SET salary=5555��job='MANAGER'
WHERE name='jack'
UPDATE myemp_lee
SET salary=6500
WHERE name='rose'
�޸ı������ݵ�ʱ��ͨ��Ҫʹ��WHERE�޶�����������ֻ�Ὣ���������ļ�¼�����޸ģ�����ָ��
WHERE����ȫ���������ݶ��޸ģ�

3:ɾ����������
��roseɾ��
DELETE FROM myemp_lee
WHERE name='rose'
ɾ����������ͬ��Ҫʹ��WHERE��ӹ������������������ձ������
INSERT INTO myemp_lee(id,name)
VALUES(2,'TOM')
SELECT * FROM myemp_lee

CREATE TABLE emp_lee(
  empno NUMBER(4,0),
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4,0),
  hiredate DATE,
  sal NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2,0)
);
DESC emp_lee
COMMIT
CREATE TABLE dept(
  deptno NUMBER(2,0),
  dname VARCHAR2(14),
  loc VARCHAR2(13)
)
COMMIT
DESC dept
INSERT INTO emp_lee(empno,ename,job,mgr,hiredate,sal,deptno)
VALUES(7369,'SMITH','CLERK',7902,TO_DATE('1980/12/17','YY/MM/DD'),800.00,20)
ALTER TABLE emp_lee MODIFY(
  comm NUMBER(7,2)  DEFAULT ' '
)

DESC dept
INSERT INTO emp_lee(empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES(7499,'ALLEN','SALESMAN',7698,TO_DATE('1981/2/20','YY/MM/DD'),
1600.00,300,30)
INSERT INTO emp_lee(empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES(7521,'WARD','SALESMAN',7698,TO_DATE('1981/2/22','YY/MM/DD'),
1250.00,500.00,30)
INSERT INTO emp_lee(empno,ename,job,mgr,hiredate,sal,deptno)
VALUES(7566,'JONES','MANAGER',7839,TO_DATE('1981/4/2','YY/MM/DD'),
2975.00,20)
INSERT INTO emp_lee(empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES(7654,'MARTIN','SALESMAN',7698,TO_DATE('1981/9/28','YY/MM/DD'),
1250.00,1400.00,30)
INSERT INTO emp_lee(empno,ename,job,mgr,hiredate,sal,deptno)
VALUES(7698,'BLAKE','MAMAGER',7839,TO_DATE('1981/6/9','YY/MM/DD'),
2850.00,30)
INSERT INTO emp_lee(empno,ename,job,mgr,hiredate,sal,deptno)
VALUES(7782,'CLARK','MAMAGER',7839,TO_DATE('1981/6/9','YY/MM/DD'),
2450.00,10)
INSERT INTO emp_lee(empno,ename,job,mgr,hiredate,sal,deptno)
VALUES(7788,'SCOTT','ANALYST',7566,TO_DATE('1987/4/9','YY/MM/DD'),
3000.00,20)
INSERT INTO emp_lee(empno,ename,job,hiredate,sal,deptno)
VALUES(7839,'KING','PRESIDENT',TO_DATE('1981/11/17','YY/MM/DD'),
5000.00,10)
INSERT INTO  emp_lee(empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES(7844,'TURNER','SALESMAN',7698,TO_DATE('1981/9/8','YY/MM/DD'),
1500.00,0.00,30)
INSERT INTO  emp_lee(empno,ename,job,mgr,hiredate,sal,deptno)
VALUES(7876,'ADAMS','CLERK',7788,TO_DATE('1987/5/23','YY/MM/DD'),
1100.00,20)
INSERT INTO  emp_lee(empno,ename,job,mgr,hiredate,sal,deptno)
VALUES(7900,'JAMES','CLERK',7698,TO_DATE('1981/12/3','YY/MM/DD'),
950.00,30)
INSERT INTO  emp_lee(empno,ename,job,mgr,hiredate,sal,deptno)
VALUES(7902,'FORD','ANALYST',7566,TO_DATE('1981/12/3','YY/MM/DD'),
3000.00,20)
INSERT INTO  emp_lee(empno,ename,job,mgr,hiredate,sal,deptno)
VALUES(7934,'MILLER','CLERK',7782,TO_DATE('1982/1/23','YY/MM/DD'),
1300.00,10)
SELECT *FROM emp_lee
COMMIT
INSERT INTO dept(deptno,dname,loc)
VALUES(10,'ACCOUNTING','NEW YORK')

INSERT INTO dept(deptno,dname,loc)
VALUES(20,'RESEARCH','DALLAS')
INSERT INTO dept(deptno,dname,loc)
VALUES(30,'SALES','CHIGAGO')
INSERT INTO dept(deptno,dname,loc)
VALUES(40,'OPERATIONS','BOSTON')
commit
SELECT *FROM dept
SELECT *FROM emp_lee































