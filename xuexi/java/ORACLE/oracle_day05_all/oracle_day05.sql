��ͼ:
���ݿ����֮һ
��SQL��������ֵĽ�ɫ�����ͬ��
����ͼ������һ����ʵ���ڵı���ֻ��
��Ӧ��һ��SELECT����ѯ�Ľ������
ʹ����ͼ���������Ӳ�ѯ�����Ҽ�SQL
���ĸ��Ӷȡ�

��������10�Ų���Ա����Ϣ����ͼ
CREATE VIEW v_emp_10
AS
SELECT empno,ename,sal,deptno
FROM emp
WHERE deptno=10

SELECT * FROM v_emp_10

DESC v_emp_10


��ͼ��Ӧ���Ӳ�ѯ�ֶο���ʹ�ñ�����
��ô����ͼ��Ӧ���ֶ���������������ˣ�
���ֶκ��к�������ʽ������ָ��������

CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id,ename name,
       sal salary,deptno
FROM emp
WHERE deptno=10

����ͼ����DML����
����ͼ����DML�������Ƕ���ͼ����
��Դ�Ļ�������еġ�
ֻ�ܶԼ���ͼ����DML������������ͼ
������ʹ��DML������
�Լ���ͼ����DML����ʱ��Ҳ����Υ��
�����Լ��������

INSERT INTO v_emp_10
(id,name,salary,deptno)
VALUES
(1001,'JACK',5000,10)

SELECT * FROM v_emp_10
SELECT * FROM emp

��ͨ����ͼ����һ����ͼ�����ɼ���
����ʱ�����ǶԻ������Ⱦ��
����������Ⱦ���޸�Ҳ����ɡ�����
ɾ��������ɡ�
INSERT INTO v_emp_10
VALUES
(1001,'JACK',5000,20)

UPDATE v_emp_10
SET deptno=20

DELETE FROM v_emp_10
WHERE deptno=20

����ͼ��Ӽ��ѡ��
WITH CHECK OPTION
����ͼ����˼��ѡ�����ô����ͼ
���в�����޸Ĳ���ʱ����ͼҪ��:
����ʱ:�����������ͼ�������ɼ�
�޸�ʱ:�޸ĺ���ͼ��������ݿɼ�
CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id,ename name,
       sal salary,deptno
FROM emp
WHERE deptno=10
WITH CHECK OPTION

Ϊ��ͼ���ֻ��ѡ��
WITH READ ONLY
��һ����ͼ�����ֻ��ѡ���
����ͼ���������DML������
CREATE OR REPLACE VIEW v_emp_10
AS
SELECT empno id,ename name,
       sal salary,deptno
FROM emp
WHERE deptno=10
WITH READ ONLY

SELECT object_name 
FROM user_objects 
WHERE object_type = 'VIEW';

SELECT text FROM user_views

SELECT table_name FROM user_tables

������ͼ
��ѯ��京�к��������ʽ�����飬ȥ��
��������ѯ��
������ͼ���ܽ���DML��

����һ�������Ź����������ͼ��
��ͼ�������ֶ�:
���ŵı�ţ����֣��ò��ŵ���С���ʣ�
��߹��ʣ�ƽ�����ʺ͹����ܺ�
CREATE VIEW v_dept_sal
AS
SELECT d.deptno,d.dname,
       MAX(e.sal) max_sal,
       MIN(e.sal) min_sal,
       AVG(e.sal) avg_sal,
       SUM(e.sal) sum_sal
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY d.deptno,d.dname

�鿴˭���Լ����ڲ���ƽ�����ʸ�?
SELECT e.ename,e.sal,e.deptno
FROM emp e,v_dept_sal v
WHERE e.deptno=v.deptno
AND e.sal>v.avg_sal

ɾ����ͼ
DROP VIEW v_emp_10

ɾ����ͼ�е����ݻ��Ӧ�Ľ���������ɾ����
����ɾ����ͼ��������Ի������ݲ����κ�
��Ӱ�졣



����
����Ҳ�����ݿ����֮һ
��������������һϵ�����ֵġ�
����ͨ��Ϊ��������ṩֵʹ�á�

CREATE SEQUENCE seq_emp_id
START WITH 1
INCREMENT BY 1

����֧������α��
NEXTVAL:ʹ����������һ������(����
�����ɵ����ּ��ϲ����õ�)���´�����
�����򷵻�START WITHָ�������֡�
�����ǲ��ܻ��˵ģ�����ͨ��NEXTVAL
��ȡ����һ�����ֺ���޷��ٻ�ȡ֮ǰ��
�ɵ������ˡ�
CURRVAL:��ȡ�������ɵ����һ�����֣�
���۵��ö��ٴζ����ᵼ�����������µ�
���֣������´������������ٵ���һ��
NEXTVAL��ſ��Կ�ʼʹ��CURRVAL��

SELECT seq_emp_id.NEXTVAL
FROM dual

SELECT seq_emp_id.CURRVAL
FROM dual

ʹ��seq_emp_idΪemp�������
����ֵ
INSERT INTO emp
(empno,ename,job,sal,deptno)
VALUES
(seq_emp_id.NEXTVAL,'JACK',
 'CLERK',5000,10)
SELECT * FROM emp

ɾ������
DROP SEQUENCE seq_emp_id

UUID
�ַ������͵�����ֵ��32λ���ظ��ַ���
ORACLE�ṩ��һ��������������UUID��
SELECT sys_guid() FROM dual

SELECT * FROM emp
WHERE ename='SCOTT'



Լ��

Ψһ��Լ��
��ĳ���ֶ�ʹ����Ψһ��Լ���󣬸��ֶ�
��ֵ�ڱ����ǲ��������ظ�ֵ�ģ�����NULL
���⡣

CREATE TABLE employees1 (
  eid NUMBER(6) UNIQUE,
  name VARCHAR2(30),
  email VARCHAR2(50),
  salary NUMBER(7, 2),
  hiredate DATE,
  CONSTRAINT employees_email_uk 
  UNIQUE(email)
);

INSERT INTO employees1
(eid,name,email)
VALUES
(NULL,'JACK',NULL)

SELECT * FROM employees1









����Լ��
�ǿ���Ϊһ
CREATE TABLE employees2 (
  eid NUMBER(6) PRIMARY KEY,
  name VARCHAR2(30),
  email VARCHAR2(50),
  salary NUMBER(7, 2),
  hiredate DATE
);
INSERT INTO employees2
(eid,name)
VALUES
(NULL,'JACK')

SELECT * FROM employees2













