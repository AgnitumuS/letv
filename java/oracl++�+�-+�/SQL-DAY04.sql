�Ӳ�ѯ
�Ӳ�ѯ��һ����ѯ��䣬��Ƕ��������SQL����У�������Ϊ����SQL����ṩ
����
��JAMES��ͬ���ŵ�Ա���ţ�
SELECT ENAME,deptno
FROM EMP_LEE
WHERE  deptno=(SELECT DEPTNO
               FROM EMP_LEE
               WHERE ENAME='JAMES'            
              )
RENAME EMP_LEE TO EMP;
SELECT *FROM EMP
COMMIT

�Ӳ�ѯ���˳������DQL֮�⣬Ҳ������DDL��DML��ʹ�á�
��DDL��Ӧ�ã�
ʹ���Ӳ�ѯ�Ľ�����ٴ���һ�ű�
CREATE TABLE MYEMPLOYEE
AS
SELECT  
 E.EMPNO,E.ENAME,E.JOB,E.SAL,
 E.DEPTNO,D.DNAME,D.LOC
FROM 
  EMP_LEE E,DEPT D
WHERE 
  E.DEPTNO=D.DEPTNO
  
DESC myemployee
SELECT *FROM MYEMPLOYEE

DML ��ʹ���Ӳ�ѯ
ɾ����JAMES ��ͬ���ŵ�����Ա��
DELETE FROM EMP
WHERE
    deptno=(SELECT DEPTNO
            FROM EMP
            WHERE ENAME='JAMES'
    ) 
    
SELECT *FROM EMP

��SMITH���ڲ��ŵ�Ա�����10%
UPDATE EMP
SET SAL=SAL*(1+0.1)
WHERE 
      DEPTNO=(SELECT DEPTNO
              FROM EMP
              WHERE ENAME='SMITH'
      )
SELECT *FROM dept

�Ӳ�ѯ���ݲ�ѯ�������ͬͨ����Ϊ��
���е��У�������WHERE�У����=,>,>=�ȣ�
���е��У�������WHERE�У����IN��ANY,ALL��
���ж��У�������FROM ����Ϊ����

�鿴��CLERK��SALESMAN���ʶ��ߵ�Ա����
SELECT ename,sal
FROM EMP
WHERE SAL>ALL(
              SELECT SAL
              FROM EMP
              WHERE JOB='CLERK' 
              OR JOB='SALESMAN')

�鿴��CLERK��ͬ���ŵ�����ְλ��Ա����
SELECT ENAME,JOB,DEPTNO
FROM EMP
WHERE  DEPTNO IN(SELECT DEPTNO
                  FROM EMP 
                  WHERE  JOB='CLERK')
AND JOB<>'CLERK'      
      

EXISTS�ؼ���
����WHERE�У����Ҫ��һ���Ӳ�ѯ��
���������Ӳ�ѯ���ٿ��Բ�ѯ��һ����¼��
��ôEXISTS���ʽ�����档
NOT EXISTS �����෴�����á���ѯ���������򷵻��档

�鿴��Ա���Ĳ�����Ϣ��
SELECT d.deptno,d.dname,d.loc
FROM dept d
WHERE  EXISTS(
      SELECT *FROM EMP E
      WHERE E.DEPTNO=D.DEPTNO
)
��ѯû���¼���Ա�� SELECT *FROM EMP
SELECT M.ENAME
FROM EMP M
WHERE NOT EXISTS(
      SELECT *FROM EMP E 
      WHERE M.EMPNO=E.MGR
)

��ѯ�г����нˮ���ڲ���30�����нˮ�Ĳ��ŵ����нˮ
SELECT MIN(SAL),DEPTNO
FROM EMP
GROUP BY DEPTNO
HAVING MIN(SAL)>
      (
      SELECT MIN(SAL)
      FROM EMP
      WHERE DEPTNO=30)

��ѯ�����Լ����ڲ���ƽ�����ʵ�Ա����Ϣ��
SELECT E.ENAME,E.DEPTNO,E.SAL,E.JOB
FROM EMP E,
     ( SELECT AVG(SAL) AVG_SAL,DEPTNO
        FROM EMP
        GROUP BY DEPTNO) T
WHERE E.DEPTNO=T.DEPTNO
AND E.SAL>T.AVG_SAL

��SELECT�����ʹ���Ӳ�ѯ
ͨ����������
SELECT 
  E.ENAME,E.SAL,
  (SELECT D.DNAME FROM DEPT D
  WHERE D.DEPTNO=E.DEPTNO) DNAME
FROM EMP E;

��ҳ��ѯ
ͨ��ͨ��һ����ѯ����ѯ������������ʱ����
��ʹ�÷�ҳ���ơ���ҳ���ǽ����ݷ�����ѯ������
һ�β�ѯ�������ݡ�
�����ĺô����Լ���ϵͳ��Ӧʱ�䣬����ϵͳ��Դ������
��ҳ�����ڱ�׼SQL��û�ж��壬���Բ�ͬ�����ݿ��﷨����ͬ�����ԣ�

ORACLE��ʹ��ROWNUM���α����ʵ�ַ�ҳ��
ROWNUM�����в����������ݿ��κα��У�����
�κα����Բ�ѯ���У������ڽ�����е�ֵ��ÿ����¼���кţ�
�кŴ�1��ʼ��
������ڲ�ѯ�����н��еģ�ֻҪ���Դӱ��в�ѯ��һ�����ݣ���ô������¼��
ROWNUM�ֶ�ֵ��Ϊ������¼���кš�
SELECT ROWNUM,ename,job,sal,deptno
FROM emp
WHERE ROWNUM BETWEEN 1 AND 10
��ʹ��ROWNUM�Խ������ŵĲ�ѯ������
��Ҫʹ��ROWNUM��>1�������ֵ��жϣ������ѯ�����κ����ݡ�--��ΪROWNUM���ڲ�ѯ�б�ŵ�,С�ڲ�Ӱ��

SELECT *
FROM (
      SELECT  ROWNUM RN,ENAME,JOB
      SAL,DEPTNO
      FROM EMP
)
WHERE RN BETWEEN 6 AND 10



���Բ�ѯ��������������ʱ��Ҫ�Ƚ������������
ȡ��˾����������6-10
SELECT *
FROM (
      SELECT ROWNUM RN,T.*
      FROM (SELECT  ENAME,SAL,JOB
            FROM EMP
            ORDER BY SAL DESC)T )

WHERE RN BETWEEN 6 AND 10


SELECT *
FROM (  
      SELECT ROWNUM RN,T.*
      FROM(
          SELECT ENAME,SAL,JOB
          FROM EMP
          ORDER BY SAL DESC) T
      WHERE ROWNUM<=10)
WHERE RN>5

���㷶Χֵ
PageSize:ÿҳ��ʾ������
Page��ҳ��
start=(Page-1)*PageSize+1
end =PageSize*Page


SELECT ENAME,JOB,SAL,
        DECODE(JOB,
                'MANAGER',SAL*1.2,
                'ANALYST',SAL*1.1,
                'SALESMAN',sal*1.05,
                sal
        ) bonus
from emp
                
SELECT ename,job,sal,
      CASE job WHEN 'MANAGER' THEN SAL*1.2
               WHEN 'ANALYST' THEN SAL*1.1
               WHEN 'SALESMAN'THEN SAL*1.05
               ELSE SAL END
      bonus
FROM emp;


ͳ����������ְλ�ǡ�ANALYST����

SELECT COUNT(*),
        DECODE(
              JOB,
              'ANALYST','VIP',
              'MANAGER','VIP',
              'OTHER'
        ) 
FROM EMP
GROUP BY DECODE(
              JOB,
              'ANALYST','VIP',
              'MANAGER','VIP',
              'OTHER'
        )
SELECT DEPTNO,DNAME,LOC
FROM DEPT
ORDER BY
  DECODE(
        DNAME,
        'OPERATIONS',1,
        'ACCOUNTING',2,
        'SALES',3)
������
���������Խ����������ָ�����ֶη��飬Ȼ��
�����ڰ���ָ�����ֶ����򣬲�Ϊ����ÿ����¼����һ����š�
ROW_NUMBER:����������Ψһ������

��˾ÿ�����ŵĹ���������
SELECT 
  ENAME,SAL,DEPTNO,
  ROW_NUMBER() OVER(
   PARTITION BY DEPTNO
   ORDER BY SAL DESC
   )RANK
FROM EMP

SELECT 
  ENAME,SAL,DEPTNO,JOB,
  ROW_NUMBER() OVER(
   PARTITION BY JOB
   ORDER BY SAL DESC
   )RANK
FROM EMP

RANK���������ڲ���������

SELECT ENAME,SAL,DEPTNO,
 RANK() OVER(
   PARTITION BY DEPTNO
   ORDER BY SAL DESC
   ) RANK
FROM EMP

DENSE_RANK: �������ڲ�����

SELECT 
 ENAME,SAL,DEPTNO,
 DENSE_RANK() OVER(
   PARTITION BY DEPTNO
   ORDER BY SAL DESC
   ) RANK
FROM EMP


CREATE TABLE sales_tab(
   year_id NUMBER NOT NULL,
   month_id NUMBER NOT NULL,
   day_id NUMBER NOT NULL,
   sales_value NUMBER(10,2) NOT NULL);
   
INSERT INTO sales_tab
SELECT TRUNC(DBMS_RANDOM.value(2010,2012))AS year_id,
       TRUNC(DBMS_RANDOM.value(1,13))AS month_id,
       TRUNC(DBMS_RANDOM.value(1,32))AS day_id,
       TRUNC(DBMS_RANDOM.value(1,100),2)AS sales_value
FROM dual
CONNECT BY level<=1000;
commit
select * from sales_tab

SELECT ename ,job,sal FROM emp
WHERE job='MANAGER'
UNION
SELECT EName,JOB,SAL FROM EMP
WHERE SAL>2500;


SELECT ename,JOB,SAL FROM EMP
WHERE JOB='MANAGER'
UNION ALL
SELECT ENAME,JOB,SAL FROM EMP
WHERE SAL>2500;
 
SELECT ENAME,JOB,SAL FROM EMP
WHERE JOB='MANAGER'
INTERSECT
SELECT ENAME,JOB,SAL FROM EMP
WHERE SAL>2500

SELECT ENAME,JOB,SAL FROM EMP
WHERE JOB='MANAGER'
MINUS
SELECT ENAME,JOB,SAL FROM EMP
WHERE SAL>=2500

�߼����麯��
ROLLUP����
ROLLUP ���������ָ���Ĳ�������������
Ϊ��������+1�Σ����ҷ���ԭ����ÿ�������ݼ�����ʽ��Ȼ��
����Щ����Ľ������һ�����������ʾ��
GROUP BY ROLLUP(a��b,c ,...)
�鿴ÿ�죬ÿ�£�ÿ�꣬����Ӫҵ�
SELECT year_id,month_id,day_id,
       SUM (sales_value)
FROM sales_tab
GROUP BY
   ROLLUP(year_id,month_id,day_id)

CUBE����
CUBE���������2�Ĳ��������η�
�Ὣÿ����Ͻ���һ�η��鲢�����н������һ�����������ʾ��
SELECT year_id,month_id,day_id,
        sum(sales_value)
from sales_tab
GROUP BY CUBE(year_id,month_id,day_id)

ֻ�鿴ÿ����ÿ��Ӫҵ�
GROUPING SETS()
�÷��麯��������ָ���ķ��鷽ʽ���з��飬Ȼ��
����Щ����ͳ�ƵĽ������һ�����������ʾ
������ÿһ������������һ�ַ��鷽ʽ��
SELECT year_id,month_id,day_id,
        SUM(sales_value)
FROM sales_tab
GROUP BY 
    GROUPING SETS(
    (year_id,month_id,day_id),
    (year_id,month_id)
)







        










