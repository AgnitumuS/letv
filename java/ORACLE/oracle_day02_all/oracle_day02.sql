SELECT���
SELECT��������ѯ���ݵ����DQL

��ѯĳ�ű��������ֶε����м�¼:
SELECT * FROM emp

�鿴ָ���ֶε�ֵ:
SELECT ename,sal,job,deptno
FROM emp

DQL��������Ĳ�����SELECT�Ӿ�
��FROM�Ӿ䡣
SELECT����ȷ����ѯ���ֶΣ�����
ʹ�õ���:����ֶΣ����������ʽ
FROM�Ӿ�����ȷ����ѯ�ı�

SELECT��ʹ�ñ��ʽ:
�鿴ÿ��Ա������н:
SELECT ename,sal*12
FROM emp

�ַ�������:
1:CONCAT(p1,p2)
�����ַ���
SELECT CONCAT(ename,sal)
FROM emp

SELECT 
 CONCAT(CONCAT(ename,':'),sal)
FROM emp

�����ַ�������һ�ּ��ķ�ʽ:ʹ��"||"
ע����java�����֡�
SELECT ename||':'||sal
FROM emp


LENGTH(p)����
��ȡ�ַ�����
SELECT ename,LENGTH(ename)
FROM emp

UPPER,LOWER,INITCAP
���ַ�ת��Ϊȫ��д��ȫСд������ĸ
��д��
dual:α������ѯ���������κ�һ�ű�
�е������޹�ʱ�����Բ�ѯα��
SELECT 
  UPPER('helloworld'),
  LOWER('HELLOWORLD'),
  INITCAP('HELLO WORLD')
FROM dual


TRIM,LTRIM,RTRIM
ȥ���ַ������ߵ�ָ���ַ�
SELECT 
  TRIM('e' FROM 'eeeliteee')
FROM dual

SELECT
  LTRIM('esesesliteseses','se')
FROM
  dual

LPAD,RPAD��λ����
Ҫ����ʾָ������ָ��λ����
�������򲹳�����ָ���ַ���
�ﵽҪ��ʾ�ĳ��ȡ�
SELECT ename,RPAD(sal,5,'$')
FROM emp

SUBSTR��ȡ�ַ���
��ȡ�����ַ�������ָ��λ��
��ʼ��ȡָ�����ַ���
�����ݿ��У��±궼�Ǵ�1��ʼ�ģ���
SELECT 
 SUBSTR('thinking in java',-4,4)
FROM 
 dual 


INSTR(char1,char2[,n[,m]])
����char2��char1�е�λ��
nΪ��ָ��λ�ÿ�ʼ���ң����Բ�д
mΪ�ڼ��γ��֣����Բ�д��
n,m��дĬ�϶���1
SELECT 
 INSTR('thinking in java','in',4,2)
FROM 
 dual

SELECT ename,sal,deptno
FROM emp
WHERE SUBSTR(ename,1,1)='A'

���ֺ���
1:ROUND(n[,m])
��n�����������룬����
��С�����mλ��
m���Բ�д����дĬ��Ϊ0
mΪ0����������λ��-1
λ10λ���Դ����ơ�
SELECT ROUND(45.678, 2) FROM DUAL; 
SELECT ROUND(45.678, 0) FROM DUAL;
SELECT ROUND(45.678, -1) FROM DUAL;

TRUNC()����������������ROUND
һ�£�ֻ�ǲ������������룬����
ֱ�ӽ�ȡ
SELECT TRUNC(45.678, 2) FROM DUAL; 
SELECT TRUNC(45.678, 0) FROM DUAL;
SELECT TRUNC(45.678, -1) FROM DUAL;

MOD()������������
SELECT 
  ename, sal, MOD(sal, 1000) 
FROM emp; 


CEIL��FLOOR
����ȡ��������ȡ��
SELECT CEIL(45.678) FROM DUAL 
SELECT FLOOR(45.678) FROM DUAL


��������
DATE:7���ֽڣ��������ͣ�������ʱ���롣
TIMESTAMP:ʱ�������DATE��4���ֽڣ�����
���������µľ��ȣ�ǰ7���ֽ���DATEһ�¡�

�ؼ���:
SYSDATE:��Ӧһ�����ú���������һ����ʾ
��ǰϵͳʱ���DATE����ֵ
SYSTIMESTAMP:ͬ���ģ����ص��Ǳ�ʾ��ǰ
ϵͳʱ���ʱ������͵�ֵ

SELECT SYSDATE FROM dual
DATEĬ��ֻ��ʾ"DD-MON-RR"

SELECT SYSTIMESTAMP FROM dual
ʱ�����ʾ���ݽ϶ࡣ

TO_DATE����
���ո��������ڸ�ʽ���ַ�������Ϊ
DATE����ֵ��
SELECT 
 TO_DATE('1992-09-01 23:22:11',
         'YYYY-MM-DD HH24:MI:SS'
 )
FROM 
 dual

�����ڸ�ʽ�ַ����У�������Ӣ�ģ����ź�
���ֵ������ַ�����Ҫʹ��˫����������
SELECT 
 TO_DATE(
  '1992��09��01�� 23:22:11',
  'YYYY"��"MM"��"DD"��" HH24:MI:SS'
 )
FROM 
 dual

DATE�ǿ��ԱȽϴ�С�ģ�Խ���Խ��
�鿴82���Ժ���ְ��Ա��?
SELECT ename,hiredate
FROM emp
WHERE hiredate>TO_DATE(
                '1982-01-01',
                'YYYY-MM-DD')

DATE֮���������������Ϊ��������
�鿴ÿ��Ա������Ϊֹ��ְ��������?
SELECT 
 ename,TRUNC(SYSDATE-hiredate)
FROM emp

SELECT 
 TRUNC(SYSDATE-TO_DATE('1992-01-01','YYYY-MM-DD'))
FROM 
 dual

DATE���Ժ�һ�����ֽ��мӼ����㣬�൱
��Ӽ���ָ��������������ֵΪ��Ӧ������
7���������?
SELECT SYSDATE+7
FROM dual



TO_CHAR
������ת�����ڣ����Խ����ڰ���ָ��
�����ڸ�ʽת��Ϊ�ַ�����
SELECT 
 TO_CHAR(SYSDATE,'YY-MM-DD HH24:MI:ss')
FROM 
 dual

SELECT 
 TO_CHAR(
  TO_DATE('03-09-01','RR-MM-DD'),
  'YYYY-MM-DD'
 )
FROM 
 dual


LAST_DAY(date)
�ú������ظ������������µ�
���һ��
�鿴�����µ�?
SELECT LAST_DAY(SYSDATE)
FROM dual

�鿴ÿ��Ա����ְ�����µ��µ�?
SELECT ename,LAST_DAY(hiredate)
FROM emp


ADD_MONTHS(date,i)
�Ը��������ڼ���ָ������������iΪ
�������Ǽ�ȥ

�鿴ÿ��Ա����ְ20����ļ�����?
SELECT 
 ename,ADD_MONTHS(hiredate,12*20)
FROM emp

MONTH_BETWEEN(date1,date2)
������������֮�������£����㷽ʽ��
ʹ��date1-date2�Ľ������ġ�
�鿴ÿ��Ա������Ϊֹ��ְ���ٸ�����?
SELECT 
 ename,MONTHS_BETWEEN(
         SYSDATE,hiredate
       )
FROM emp


NEXT_DAY(date,i)
���ظ�������֮��һ���ڵ��ܼ�
SELECT 
 NEXT_DAY(SYSDATE,1)
FROM 
 dual


LEAST��GREATEST
����Сֵ�����ֵ
���麯���Ĳ����������������������ϼ��ɡ�
SELECT 
 LEAST(SYSDATE, TO_DATE(
                '2008-10-10',
                'YYYY-MM-DD')
      ) 
FROM DUAL;

�鿴82���Ժ���ְ��Ա������ְ���ڣ�����
82����ǰ��ְ�ģ�����ʾΪ:1982-01-01
SELECT 
 ename,GREATEST(hiredate,TO_DATE('1982-01-01','YYYY-MM-DD'))
FROM
 emp

EXTRACT()��ȡָ������ָ��ʱ�������ֵ
SELECT EXTRACT(YEAR FROM SYSDATE)
FROM DUAL;

�鿴81����ְ��Ա��
SELECT ename,hiredate
FROM emp
WHERE 
 EXTRACT(YEAR FROM hiredate)=1981


CREATE TABLE student
    (id NUMBER(4), 
     name CHAR(20), 
     gender CHAR(1) NOT NULL);

INSERT INTO student VALUES(1000, '��Ī��', 'F');

INSERT INTO student VALUES(1001, '��ƽ֮', NULL);

INSERT INTO student(id, name) VALUES(1002, '���޼�');

�ж�һ���ֶε�ֵ�Ƿ�Ϊ�գ�Ҫʹ��:
IS NULL �� IS NOT NULL
UPDATE student
SET gender='M'
WHERE gender IS NULL

SELECT * FROM student

NULL������
NULL���ַ������ӵ���ʲô��û��
NULL����������������NULL

�鿴ÿ��Ա��������
SELECT ename,sal,comm,sal+comm
FROM emp

NVL(p1,p2)
��p1ΪNULL����������p2
����ΪNULL����������p1����
���Ըú����������ǽ�NULLֵ�滻Ϊ
��NULLֵ��

�鿴ÿ��Ա��������
SELECT 
 ename,sal,comm,
 sal+NVL(comm,0)
FROM emp

�鿴ÿ��Ա���Ľ������:
������ΪNULL������ʾΪ"�н���"
ΪNULL������ʾΪ"û�н���"
NVL2(p1,p2,p3)
��p1��ΪNULL����������p2
��p1ΪNULL����������p3
SELECT 
 ename,comm,
 NVL2(comm,'�н���','û�н���')
FROM 
 emp
 
NVL2������ȫʵ��NVL���ܣ����Ƿ�����
���С�
SELECT
 ename,NVL2(comm,sal+comm,sal)
FROM emp







