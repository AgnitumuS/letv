�Ӳ�ѯ
�Ӳ�ѯ��һ����ѯ��䣬��Ƕ��������
SQL����У�������Ϊ����SQL�����
�����ݵġ�

��JAMES��ͬ���ŵ�Ա��?
SELECT ename,deptno
FROM emp
WHERE 
  deptno=(SELECT deptno
          FROM emp
          WHERE ename='JAMES')

�Ӳ�ѯ���˳�����DQL֮�⣬Ҳ������
DDL��DML��ʹ�á�

��DDL��Ӧ��:
ʹ���Ӳ�ѯ�Ľ�����ٴ���һ�ű�
DROP TABLE myemployee
CREATE TABLE myemployee
AS
SELECT 
 e.empno,e.ename,e.job,e.sal*12 sal,
 e.deptno,d.dname,d.loc
FROM 
 emp e,dept d
WHERE
 e.deptno=d.deptno

DESC myemployee
SELECT sal FROM myemployee

���Ӳ�ѯ�в�ѯ�������Ǻ�������ʽ����ô
���ֶα����������

DML��ʹ���Ӳ�ѯ
ɾ����JAMES��ͬ���ŵ�����Ա��
DELETE FROM emp
WHERE 
  deptno=(SELECT deptno
          FROM emp
          WHERE ename='JAMES')
SELECT * FROM emp

��SMITH���ڲ�������Ա���������10%
UPDATE emp
SET sal=sal*1.1
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='SMITH')

�Ӳ�ѯ���ݲ�ѯ�������ͬͨ����Ϊ:
���е���:������WHERE��(���=,>,>=�ȵ�)
���е���:������WHERE��(���IN,ANY,ALL)
���ж���:������FROM����Ϊ����

�鿴��CLERK��SALESMAN���ʶ��ߵ�Ա��?
SELECT ename,sal
FROM emp
WHERE 
 sal >ALL(SELECT sal
          FROM emp
          WHERE job='SALESMAN'
          OR job='CLERK')

�鿴��CLERK��ͬ���ŵ�����ְλԱ��?
SELECT ename,job,deptno
FROM emp
WHERE deptno IN(SELECT deptno
                FROM emp
                WHERE job='CLERK')
AND job <> 'CLERK'

EXISTS�ؼ���
����WHERE�У����Ҫ��һ���Ӳ�ѯ��
���������Ӳ�ѯ���ٿ��Բ�ѯ��һ��
��¼����ôEXISTS���ʽ�����档
NOT EXISTS�����෴�����á���
���������򷵻��档

�鿴��Ա���Ĳ���?
SELECT d.deptno,d.dname,d.loc
FROM dept d
WHERE EXISTS(
  SELECT * FROM emp e
  WHERE e.deptno=d.deptno
)
û��������Ա��?
SELECT m.ename
FROM emp m
WHERE NOT EXISTS(
 SELECT * FROM emp e
 WHERE e.mgr = m.empno
)

��ѯ�г����нˮ���ڲ���30����
��нˮ�Ĳ�����Ϣ��
SELECT MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING 
  MIN(sal)>(SELECT MIN(sal)
            FROM emp
            WHERE deptno=30)

�鿴�����Լ����ڲ���ƽ�����ʵ�Ա����Ϣ?
SELECT e.ename,e.deptno,e.sal
FROM emp e,
     (SELECT AVG(sal) avg_sal,
             deptno
      FROM emp
      GROUP BY deptno) t
WHERE e.deptno=t.deptno
AND e.sal>t.avg_sal

��SELECT�Ӿ���ʹ���Ӳ�ѯ
ͨ���������ӵ�һ��д����
SELECT 
 e.ename, e.sal, 
 (SELECT d.dname FROM dept d 
  WHERE d.deptno = e.deptno) dname
FROM emp e;

��ҳ��ѯ
ͨ��һ����ѯ����ѯ������������ʱ����
��ʹ�÷�ҳ���ơ���ҳ���ǽ����ݷ�����ѯ
������һ��ֻ��ѯ�������ݡ�
�����ĺô����Լ���ϵͳ��Ӧʱ�䣬����ϵͳ
��Դ������
��ҳ�����ڱ�׼SQL��û�ж��壬���Բ�ͬ��
���ݿ��﷨����ͬ(����)

ORACLE��ʹ��ROWNUM���α����ʵ�ַ�ҳ��
ROWNUM,���в����������ݿ��κα��У�����
�κα����Բ�ѯ���У������ڽ�����е�ֵ
��ÿ����¼���кţ��кŴ�1��ʼ��
������ڲ�ѯ�Ĺ����н��еģ�ֻҪ���Դӱ�
�в�ѯ��һ�����ݣ���ô������¼��ROWNUM
�ֶ�ֵ��Ϊ������¼���кš�

SELECT 
  ROWNUM,ename,job,
  sal,deptno
FROM emp

��ѯ6��10��
SELECT 
  ROWNUM,ename,job,
  sal,deptno
FROM emp
WHERE ROWNUM BETWEEN 6 AND 10
��ʹ��ROWNUM�Խ������ŵĲ�ѯ����
�в�Ҫʹ��ROWNUM��>1�������ֵ��жϣ�
�����ѯ�����κ����ݡ�
SELECT *
FROM (SELECT 
         ROWNUM rn,ename,job,
         sal,deptno
      FROM emp)
WHERE rn BETWEEN 6 AND 10

���Բ�ѯ��������������ʱ��Ҫ��
�������������
ȡ��˾����������6-10
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,sal,job
          FROM emp
          ORDER BY sal DESC) t)
WHERE rn BETWEEN 6 AND 10

SELECT *
FROM (SELECT ROWNUM rn,t.*
      FROM(SELECT ename,sal,job
           FROM emp
           ORDER BY sal DESC) t
      WHERE ROWNUM<=10)
WHERE rn>=5      

���㷶Χֵ
PageSize:ÿҳ��ʾ������
Page:ҳ��

start = (Page-1)*PageSize+1
end = PageSize*Page

int page=2; 
int pageSize=5;
int start = (Page-1)*PageSize+1;
int end = PageSize*Page;
String sql = "SELECT * "+
             "FROM (SELECT ROWNUM rn,t.* "+
             "FROM(SELECT ename,sal,job "+
             "FROM emp "+
             "ORDER BY sal DESC) t "+
             "WHERE ROWNUM<=" + end + ") "+
             "WHERE rn>="+start;

DECODE����
����ʵ�ַ�֧Ч��

SELECT ename, job, sal,
     DECODE(job,  
            'MANAGER',sal*1.2,
            'ANALYST',sal*1.1,
            'SALESMAN',sal*1.05,
            sal
     ) bonus
FROM emp

ͳ����������ְλ��'ANALYST'��
'MANAGER'����һ�飬����ְλ����
��һ��ֱ�ͳ����������
SELECT COUNT(*),job
FROM emp
GROUP BY job

SELECT COUNT(*),
       DECODE(job,
              'ANALYST','VIP',
              'MANAGER','VIP',
              'OTHER')
FROM emp              
GROUP BY DECODE(job,
              'ANALYST','VIP',
              'MANAGER','VIP',
              'OTHER')
SELECT deptno, dname, loc
FROM dept
ORDER BY 
 DECODE(dname,
       'OPERATIONS',1,
       'ACCOUNTING',2,
       'SALES',3)


������
���������Խ����������ָ����
�ֶη��飬Ȼ�������ڰ���ָ����
�ֶ����򣬲�Ϊ����ÿ����¼����
һ����š�
ROW_NUMBER:����������Ψһ������

��˾ÿ�����ŵĹ�������:
SELECT 
 ename,sal,deptno,
 ROW_NUMBER() OVER(
   PARTITION BY deptno
   ORDER BY sal DESC
 ) rank
FROM 
 emp

RANK:�������ڲ�����Ҳ��Ψһ������
SELECT 
 ename,sal,deptno,
 RANK() OVER(
   PARTITION BY deptno
   ORDER BY sal DESC
 ) rank
FROM 
 emp


DENSE_RANK:����������������Ψһ������
SELECT 
 ename,sal,deptno,
 DENSE_RANK() OVER(
   PARTITION BY deptno
   ORDER BY sal DESC
 ) rank
FROM 
 emp

SELECT 
 year_id,month_id,day_id,
 sales_value
FROM 
 sales_tab
ORDER BY
 year_id,month_id,day_id

�鿴ÿ���Ӫҵ��?
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id,day_id
ORDER BY year_id,month_id,day_id

ÿ�µ�Ӫҵ��?
SELECT year_id,month_id,SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id
ORDER BY year_id,month_id

ÿ���Ӫҵ��?
SELECT year_id,SUM(sales_value)
FROM sales_tab
GROUP BY year_id
ORDER BY year_id

��Ӫҵ��?
SELECT SUM(sales_value)
FROM sales_tab

SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id,day_id
UNION ALL
SELECT year_id,month_id,NULL,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id
UNION ALL
SELECT year_id,NULL,NULL,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id
UNION ALL
SELECT NULL,NULL,NULL,
       SUM(sales_value)
FROM sales_tab

�߼����麯��
ROLLUP����
ROLLUP���������ָ���Ĳ�������������
Ϊ��������+1�Σ����ҷ���ԭ����ÿ������
�ݼ�����ʽ��Ȼ����Щ����Ľ������һ��
���������ʾ��

GROUP BY ROLLUP(a,b,c,...)
����:
GROUP BY ROLLUP(a,b,c)
��ͬ��
GROUP BY a,b,c
UNION ALL
GROUP BY a,b
UNION ALL
GROUP BY a
UNION ALL
ȫ��

�鿴ÿ�죬ÿ�£�ÿ�꣬����Ӫҵ��?
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY 
 ROLLUP(year_id,month_id,day_id)



CUBE����
CUBE���������2�Ĳ��������η�
�Ὣÿ����Ͻ���һ�η��鲢������
�������һ�����������ʾ��

GROUP BY CUBE(a,b,c)
a,b,c
a,b
a,c
b,c
a
b
c
ȫ��
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY 
 CUBE(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id


ֻ�鿴ÿ����ÿ��Ӫҵ��?
GROUPING SETS()
�÷��麯��������ָ���ķ��鷽ʽ
���з��飬Ȼ����Щ����ͳ�ƵĽ��
����һ�����������ʾ
������ÿһ������������һ�ַ��鷽ʽ��

SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY 
 GROUPING SETS(
  (year_id,month_id,day_id),
  (year_id,month_id)
  )
ORDER BY year_id,month_id,day_id





