
��ѯĳ�ű��������ֶε����м�¼��
SELECT *FROM emp_lee;
�鿴ָ���ֶε�ֵ
SELECT ename,sal,job,deptno
FROM emp_lee

DQL������� �Ĳ�����SELECT�Ӿ�
��FROM�Ӿ䡣
SELECT����ȷ����ѯ���ֶΣ�����
ʹ�õ��У�����ֶΣ����������ʽ
FROM�Ӿ�����ȷ����ѯ�ı�

SELECT ��ʹ�ñ��ʽ��
�鿴ÿ��Ա������н��
SELECT ename,sal*12
FROM emp_lee

�ַ���������
1��CONCAT(P1��P2)
�����ַ���
SELECT CONCAT(ename,sal*12)
FROM emp_lee
SELECT CONCAT(CONCAT(ename,':'),sal)
FROM emp_lee
�����ַ�������һ�ּ��ķ�ʽ��ʹ�á�||��ע����JAVA�����֡�
SELECT ename||':'||sal
FROM emp_lee

LENGTH(P)����
��ȡ�ַ�����
SELECT ename��LENGTH(ename)
FROM emp_lee
SELECT sal,LENGTH(sal)
FROM emp_lee

UPPER,LOWER,INITCAP
���ַ�ת��Ϊȫ��д��ȫСд������ĸ��д��
dual��α������ѯ���������κ�һ�ű��е������޹�ʱ��
���Բ�ѯα��
SELECT UPPER('helloworld'),
       LOWER('HOLLOWORLD'),
       INITCAP('HELLO WROLD')
FROM dual
 
 
 TRIM,LTRIM,RTRIM
 ȥ���ַ������ߵ�ָ���ַ�
 SELECT 
 TRIM('e'FROM 'eeeliteee')//ֻ��һ����ĸ
 FROM dual
 SELECT
 LTRIM('eelitee','e')
 FROM dual
 SELECT
 RTRIM('eeeliteee','e')
 FROM dual
SELECT
LTRIM('eesskkkliteeeess','esk')
FROM dual

LPAD,RPAD��λ����
Ҫ����ʾָ������ָ��λ����
�������򲹳�����ָ���ַ��ԴﵽҪ����ʾ�ĳ��ȡ�
SELECT 
ename ,LPAD(sal,5,'$')
FROM emp_lee
SELECT ename ,RPAD(sal,5,' ')
FROM emp_lee
SELECT ename ,RPAD(SAL,3,' ')//��ȡ���Ǵ�������
FROM emp_lee
SELECT ename ,LPAD(SAL,3,' ')
FROM EMP_LEE


SUBSTR��ȡ�ַ���
��ȡ�����ַ�������ָ��λ�ÿ�ʼ��ȡָ�����ַ���
�����ݿ��У��±궼�Ǵ�1��ʼ�ģ�������
SELECT 
SUBSTR('thinking in java',1,5)
FROM dual
SELECT
SUBSTR('thinking in java',-4,4)//������ʾ�ӵ���λ�ÿ�ʼ����ȡ��������Ϊ����
FROM dual

INStR(char1,char2[,n[,m]])
����char2��char1�е�λ��
nΪ��ָ��λ�ÿ�ʼ���ң����Բ�д
mΪ�ڼ��γ��֣����Բ�д��
n��m��дĬ�϶���1
SELECT
INSTR('thinking in java','in')
FROM dual
SELECT
INSTR('thinking in java','in',-7,1)
FROM dual

SELECT ename,sal,deptno
FROM emp_lee
WHERE LOWER(ename)='smith'

SELECT ename
FROM emp_lee
WHERE LENGTH(ename)=5

SELECT ename
FROM emp_lee
WHERE SUBSTR(ename,1,1)='A'
SELECT ename
FROM emp_lee
WHERE INSTR(ename,'A')=1

���ֺ���
1��ROUND(N,[,M])
��n�����������룬����
��С�����Mλ
m���Բ�д����дĬ��Ϊ0
MΪ0����������λ��-1λΪ10λ���������ơ�
SELECT ROUND(45.678��2) FROM dual;
SELECT ROUND(45.678)FROM DUAL;
SELECT ROUND(55.678,-2)FROM DUAL;
SELECT ROUND(45.678,-1)FROM DUAL;

2:TRUNC()����������������ROUND
һ�£�ֻ�ǲ������������룬����ֱ�ӽ�ȡ
SELECT TRUNC(45.678,2)FROM DUAL;
SELECT TRUNC(45.678��0)FROM DUAL;
SELECT TRUNC(45.678,-1)FROM DUAL;


MOD()������������
SELECT
  ename,sal,MOD(SAL,1000)
FROM EMP_LEE;

CEIL��FLOOR
����ȡ��������ȡ��
SELECT CEIL(45.678)FROM DUAL
SELECT FLOOR(45.678)FROM DUAL
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
��������
DATE:7���ֽڣ��������ͣ�������ʱ���롣
TIMESTAMP:ʱ�������date��4���ֽڣ����Ա��������µľ��ȣ�
ǰ7���ֽ���dateһ�¡�
�ؼ��֣�
SYSDATE: ��Ӧһ�����ú���������һ����ʾ��ǰϵͳʱ���DATE����ֵ
SYSTIMESTAMP:ͬ���ģ����ص��Ǳ�ʾ��ǰϵͳʱ���ʱ������͵�ֵ
SELECT SYSDATE FROM dual
DATEĬ��ֻ��ʾ��DD-MON-RR��
SELECT SYSTIMESTAMP FROM DUAL
ʱ�����ʾ�����ݽ϶�


TO_DATE������
���ո��������ڸ�ʽ���ַ�������Ϊ
DATE����ֵ��
SELECT
  TO_DATE('1989-09-01  23��22��11','YYYY-MM-DD  HH24:MI:SS')
FROM dual

SELECT
  TO_DATE('1989��09��01�� 23:22:11','YYYY"��"MM"��"DD"��" HH24:MI:SS')
FROM DUAL

DATE�ǿ��ԱȽϴ�С�ģ�Խ��Խ��
�鿴82���Ժ���ְ��Ա����
SELECT ename,hiredate
FROM emp_lee
WHERE hiredate>TO_DATE('1982-01-01','YYYY-MM-DD')

DATE֮���������������Ϊ��������
����ÿ��Ա������Ϊֹ��ְ�������ˣ�
SELECT
 ename,TRUNC(SYSDATE-hiredate)
 FROM emp_lee

SELECT
  TRUNC(SYSDATE-TO_DATE('1989-02-26','YYYY-MM-DD'))
FROM dual

DATE���Ժ�һ�����ֽ��мӼ����㣬�൱��Ӽ���ָ��������������ֵΪ��Ӧ������
7���������
SELECT
 SYSDATE+7
FROM dual

TO_CAHR
������ת�����ڣ����Խ����ڰ���ָ�������ڸ�ʽת��Ϊ�ַ���
SELECT
  TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS')
FROM DUAL

SELECT 
  TO_CHAR(
    TO_DATE('50-03-01','RR-MM-DD'),
    'YYYY MM DD'
  )
FROM DUAL

LAST_DAY(DATE)
�ú������ظ������������µ����һ��
�鿴�����µף�
SELECT TO_CHAR(LAST_DAY(SYSDATE),'YY-MM-DD') FROM DUAL
�鿴ÿ��Ա����ְ�����µ��µף�
SELECT ename,LAST_DAY(hiredate)
FROM emp_lee

ADD_MONTHS(date,i)
�Ը��������ڼ���Iֵ��Ӧ����

�鿴ÿ��Ա����ְ20����ļ����գ�
SELECT 
  ename,ADD_MONTHS(hiredate,12*20)
FROM EMP_LEE

MONTH_BETWEEN(date1��date2)
������������֮�������£����㷽ʽ��
ʹ��date1-date2�Ľ������ġ�
SELECT
  ename,TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate))
FROM EMP_LEE 

NEXT_DAY(date,i)
���ظ�������֮��һ���ڵ��ܼ�
SELECT
 NEXT_DAY(SYSDATE,1)
 FROM DUAL
 
LEAST��GREATEST
����Сֵ�����ֵ
���麯�������������������������ϼ��ɡ�
SELECT
TO_CHAR(LEAST(SYSDATE,TO_DATE('2008-10-10','YYYY-MM-DD')),'YYYY-MM-DD')
FROM DUAL;
 
 �鿴82���Ժ���ְ��Ա������ְ���ڣ�����82����ǰ��ְ�ģ�
 ����ʾΪ��1982-01-01
 SELECT
  ename,TO_CHAR(GREATEST(hiredate,TO_DATE('1982-01-01','YYYY-MM-DD')),'YYYY-MM-DD')
  FROM EMP_LEE
 
 EXTRACT()��ȡָ������ָ��ʱ�������ֵ
 SELECT EXTRACT(YEAR FROM SYSDATE)
 FROM DUAL;
 �鿴81����ְ��Ա��
 SELECT ename��hiredate
 from emp_lee
 WHERE EXTRACT(YEAR FROM hiredate)=1981;
 
 CREATE TABLE student
 (id NUMBER(4),
  name VARCHAR2(20),
  gender CHAR(1)
 );
INSERT INTO student
VALUES(1000,'��Ī��','F');
INSERT INTO student
VALUES(1002��'��ƽ֮',NULL)
INSERT INTO student(id,name)
VALUES(1002,'���޼�')
UPDATE STUDENT
SET ID=1001
WHERE NAME='��ƽ֮'
�ж�һ���ֶε�ֵ�Ƿ�Ϊ�գ�Ҫʹ�ã�IS NULL �� IS NOT NULL
UPDATE STUDENT
SET gender='M'
WHERE gender is NULL

COMMIT
SELECT *FROM STUDENT

NULL������
NULL���ַ������ӵ���ʲô��û��
NULL����������������NULL
�鿴ÿ��Ա��������
SELECT ename,sal,comm,sal+comm
FROM EMP_LEE

NVL(p1,p2)
��P1ΪNULL����������p2
����ΪNULL����������p1����
���Ըú����������ǽ�NULLֵ�滻Ϊ��NULLֵ��
SELECT ename,sal,comm,sal+NVL(comm,0)
FROM EMP_LEE
�鿴ÿ��Ա���Ľ��������
������ΪNULL������ʾΪ���н���
ΪNULL������ʾΪ��û�н���
NVL2(p1,p2,p3)
��P1��ΪNULL����������P2
��p1ΪNULL����������P3
SELECT ename,comm,NVL2(COMM,'�н���','û�н���')
FROM EMP_LEE
NVL2������ȫʵ��NVL���ܣ����Ƿ��������С�
SELECT ename,NVL2(COMM,COMM+SAL,SAL)
FROM emp_lee




