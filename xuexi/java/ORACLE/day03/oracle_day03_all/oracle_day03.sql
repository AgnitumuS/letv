���Զ��ֶμӱ�������SELECT�Ӿ�
�г����˺������߱��ʽʱ���������
�ͻ��������������ʽ��Ϊ�ֶ�����
�ɶ��Բ��ʱ����ͨ��������ֶμ�
��������ϣ���������ִ�Сд���߰���
�ո���ô����ʹ��˫���Ž�������������
SELECT ename,sal*12 sal
FROM emp

�鿴20�Ų��ŵ�Ա����Ϣ
SELECT * FROM emp
WHERE deptno=20

�鿴ְλ��CLERK��Ա����Ϣ
SELECT * FROM emp
WHERE job='CLERK'


���ʸ���1000������ְλ��CLERK
��SALESMAN��Ա����Ϣ?
SELECT ename,job,sal
FROM emp
WHERE sal>1000
AND (job='SALESMAN'
OR job='CLERK')

AND�����ȼ�����OR������ͨ��
ʹ�����������OR�����ȼ���

LIKE����ģ��ƥ���ַ���
֧������ͨ���:
_:��ʾ��һ��һ���ַ�
%:��ʾ������ַ�(0-���)

�鿴���ֵڶ�����ĸ��A��Ա����Ϣ?
SELECT ename,job,sal
FROM emp
WHERE ename LIKE '_A%'


IN(list),NOT IN(list)
�ж��Ƿ����б��л����б���
�����Ӳ�ѯ��ʹ��

�鿴ְλ��CLERK��SALESMAN��Ա����Ϣ?
SELECT ename,sal,job
FROM emp
WHERE job NOT IN('CLERK','SALESMAN')


BETWEEN..AND..
�ж���һ����Χ��
�鿴������1500��3000֮���Ա��
SELECT ename, sal FROM emp  
WHERE sal BETWEEN 1500 AND 3000;


ANY,ALL
���:>,>=,<,<=һ���б�ʹ�á�
>ALL(list):�����б�������(��������)
>ANY(list):�����б�����С��(��������֮һ)
������б��м�������ʹ��ȷ��ֵ���������ж�
�Ӳ�ѯ�Ľ����
�����SQL��������ʾ�﷨��ʵ�ʿ�����������д��
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE sal > ANY (3500,4000,4500);

����������Ҳ����ʹ�ú�������ʽ
SELECT ename, sal, job 
FROM emp 
WHERE ename = UPPER('allen');

SELECT ename, sal, job 
FROM emp 
WHERE sal * 12 > 50000;

SELECT * FROM emp

SELECT *
FROM emp
WHERE hiredate>TO_DATE('1981-01-01','YYYY-MM-DD')
AND sal*12>30000

DISTINCT����ȥ���������ָ���ֶε�
�ظ�ֵ��
�鿴��˾���ж�����ְλ��
SELECT DISTINCT job
FROM emp

DISTINCT���������SELECT�ؼ���֮��
DISTINCT���ԶԶ���ȥ��,ȥ��ԭ������Щ
�е����û���ظ�ֵ��
SELECT DISTINCT job,deptno
FROM emp

ORDER BY�Ӿ�
�������������԰���ָ�����ֶν���
������߽������С�
ASC:���򣬿��Բ�д��Ĭ�Ͼ�������
DESC:����
��Ҫע��!ORDER BYֻ�ܶ�����SELECT���
�����һ���Ӿ��ϡ�
�鿴��˾��������
SELECT ename,sal
FROM emp
ORDER BY sal DESC

ORDER BY���ԶԶ��н�������
����������ȼ����Ȱ��յ�һ���ֶε�����
��ʽ��������������һ���ֶ����ظ�ֵʱ
�ٰ��յڶ����ֶε�����ʽ���������Դ�����.
SELECT ename,sal,deptno
FROM emp
ORDER BY deptno DESC,sal DESC

��������ֶκ���NULLֵ��
NULL���������ֵ��
SELECT ename,comm
FROM emp
ORDER BY comm DESC

�ۺϺ������ֳ�Ϊ���к���
�ۺϺ���������ͳ�ƽ���ġ�

MAX,MIN
ͳ�����ֵ����Сֵ
�鿴��˾���������͹���?
SELECT MAX(sal),MIN(sal)
FROM emp

AVG,SUM
ͳ��ƽ��ֵ���ܺ�
�鿴��˾ƽ�������Լ������ܺ�?
SELECT AVG(sal),SUM(sal)
FROM emp

COUNT
ͳ�Ƶ��Ǽ�¼��������������ע����
���ֶε�ȡֵ
�鿴��˾Ա������?
SELECT COUNT(ename)
FROM emp

�ۺϺ�������NULLֵ��
SELECT COUNT(comm)
FROM emp

SELECT AVG(NVL(comm,0)),SUM(comm)
FROM emp

ͳ�Ʊ��м�¼������ʹ��COUNT(*)
SELECT COUNT(*)
FROM emp


GROUP BY�Ӿ�
GROUP BY�Ӿ�������������ո�����
�ֶ�ֵ��ͬ�ļ�¼����һ�飬Ȼ����Ͼۺ�
������ÿ���¼����ͳ�ơ�
�鿴ÿ�����ŵ���߹���?
SELECT MAX(sal),deptno
FROM emp
GROUP BY deptno

��SELECT�к��оۺϺ���ʱ�������ھۺϺ���
�еĵ����ֶζ����������GROUP BY�Ӿ���

�鿴ÿ��ְλ��ƽ�����ʺ͹����ܺͣ�
SELECT AVG(sal),SUM(sal),job
FROM emp
GROUP BY job

�鿴ÿ�����Ÿ�������?
SELECT COUNT(*),deptno
FROM emp
GROUP BY deptno

�鿴ÿ�����ŵ�ƽ�����ʣ�ǰ���Ǹò���
ƽ�����ʸ���2000
SELECT AVG(sal),deptno
FROM emp
WHERE AVG(sal)>2000
GROUP BY deptno

WHERE�в�����ʹ�þۺϺ�����Ϊ����
������ԭ�����ڹ���ʱ����ͬ��
WHERE�Ĺ���ʱ�����ڵ�һ�δӱ��м���
����ʱ��ӹ�������������ȷ����Щ����
���Ա���ѯ��������ȷ���������

HAVING�Ӿ�:HAVING�������GROUP BY
�Ӿ�֮�󣬿���ʹ�þۺϺ�����Ϊ����������
ʹ֮���ԶԷ�����й��ˣ������������ķ���
�������������ȥ����

SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

�鿴ƽ�����ʸ���2000�Ĳ��ŵ�
��߹��ʺ���͹���
SELECT MAX(sal),MIN(sal),deptno
FROM emp,dept
WHERE sal>1000
GROUP BY deptno
HAVING AVG(sal)>2000
ORDER BY deptno


SELECT COUNT(*),job,deptno
FROM emp
GROUP BY job,deptno

SELECT deptno,dname
FROM dept

������ѯ
��ѯ�Ľ�������ֶ����Զ��ű�
���϶��ű��ѯ���ݾ��ǹ�����ѯ��
�ڹ�����ѯ����Ҫ�ڹ������������
���ű��м�¼֮��Ķ�Ӧ��ϵ��������
������Ϊ����������
N�ű����ϲ�ѯ����Ҫ��N-1������������
�������������������ѿ�������������
����£��ý����ͨ����������ģ�����
�����������󣬶�ϵͳ��Դ�����о޴�Ӱ�졣


�鿴ÿ��Ա���������Լ����ڲ�������?
SELECT ename,dname
FROM emp,dept
WHERE emp.deptno=dept.deptno

�ڹ�����ѯ�еĹ�������Ӧ������������
ͬʱ������
�鿴SALES���ŵ�Ա����Ϣ?
SELECT ename,dname
FROM emp,dept
WHERE emp.deptno=dept.deptno
AND dept.dname='SALES'

����ѯ�����У������ֶ������ű��ж���
������ǣ�������ȷ���ֶ��������ű�
SELECT e.ename,e.deptno,
       d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno


SELECT d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND e.ename='SMITH'

SELECT e.ename,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.loc='NEW YORK'

�鿴ƽ�����ʸ���2000�Ĳ������ڵ�?
SELECT AVG(e.sal),d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY d.dname,d.loc
HAVING AVG(e.sal)>2000

������
������ѯ����һ��д��
�鿴SALES���ŵ�Ա����Ϣ
SELECT e.ename,d.dname
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE d.dname='SALES'

������
�������ڽ��й�����ѯʱ���Խ���
�������������ļ�¼Ҳ��ѯ������
�����ӷ�Ϊ:�������ӣ��������ӣ�ȫ������

��������:��JOIN������Ϊ�������ñ�
�����м�¼ȫ�����г�������ô��ĳ����¼
��������������ʱ���ü�¼�������Ҳ����
�ֶε�ֵΪNULL

SELECT e.ename,d.dname
FROM emp e 
 LEFT |RIGHT |FULL OUTER JOIN 
 dept d
ON e.deptno=d.deptno

SELECT e.ename,d.dname
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno

������
������ָ�����Լ����еļ�¼��Ӧ�Լ�
��Ķ�����¼�������Ĺ�����ѯ����
�����ӡ�
������������ڽ��������ͬ�����Ǵ���
���¼���ϵ����״�ṹʹ�á�

SELECT empno,ename,mgr
FROM emp

�鿴ÿ��Ա���Լ�����˾������?
SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno
AND m.ename='JONES'

�鿴ÿ���쵼���¶�����?
SELECT COUNT(*),m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno
GROUP BY m.ename

�鿴JONES����˾���ĸ����й���? 
SELECT d.loc
FROM emp e,emp m,dept d
WHERE e.mgr = m.empno
AND m.deptno=d.deptno
AND e.ename='JONES'

SELECT deptno,dname,loc
FROM dept




