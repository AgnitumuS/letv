���Զ��ֶμӱ�������SELECT�Ӿ�
�г����˺������߱��ʽʱ���������
�ͻ��������������ʽ��Ϊ�ֶ�����
�ɶ��Բ��ʱ����ͨ��������ֶμӱ�����AS�����֣�AS����ʡ�ԣ�
SELECT ename,sal*12 as sal
FROM EMP_LEE
��ϣ���������ִ�Сд���߰����ո���ô����ʹ��˫���Ž�������������
SELECT ename,sal*12 as "s al "
FROM emp_lee
�鿴20�Ų��ŵ�Ա����Ϣ
SELECT *
FROM EMP_LEE
WHERE DEPTNO=20;
�鿴ְλ��CLERK��Ա����Ϣ
SELECT * FROM EMP_LEE
WHERE JOB='CLERK'
SELECT *FROM EMP_LEE
WHERE SAL<2000;
SELECT *FROM EMP_LEE
WHERE DEPTNO<>10//������

SELECT *FROM EMP_LEE
WHERE hiredate> TO_DATE('1987��1��1��','YYYY"��"MM"��"DD"��"');


SELECT *FROM EMP_LEE
WHERE SAL>1000 and job='CLERK';
SELECT *FROM EMP_LEE
WHERE SAL>1000 OR JOB='CLERK'
and ���ȼ����� or ,����ͨ��ʹ�����������or�����ȼ�
SELECT *FROM EMP_LEE
WHERE SAL>1000 AND (JOB='SALESMAN' OR JOB='CLERK')

LIKE����ģ��ƥ���ַ���
֧������ͨ�����
_:��ʾ��һ��һ���ַ�
%����ʾ������ַ���0�������
�鿴���ֵڶ�����ĸ��A��Ա����Ϣ��
SELECT *FROM EMP_LEE
WHERE ename LIKE '_A%';

SELECT *FROM EMP_LEE
WHERE ENAME LIKE '_L_E%'
SELECT *FROM EMP_LEE
WHERE ENAME LIkE '%N'
SELECT *FROM EMP_LEE
WHERE ENAME LIkE '%E_'

IN(list),NOT IN(list)
�ж��Ƿ����б��л����б���
�����Ӳ�ѯ��ʹ��
�鿴ְλ��CLERK��SALESMAN��Ա����Ϣ��
SELECT *FROM EMP_LEE
WHERE JOB IN('CLERK','SALESMAN')
SELECT *FROM EMP_LEE
WHERE JOB NOT IN('CLERK','SALESMAN')

BETWEEN..AND..
�ж���һ����Χ��
�鿴Ա��������1500��3000֮���
SELECT *FROM EMP_LEE
WHERE SAL BETWEEN 1500 AND 3000;

ANY,ALL
��ϣ�>,>=,<,<=һ���б�ʹ�á�
>ALL(list):�����б������ģ��������У�
>ANY(list):�����б�����С�ģ���������֮һ��
������б��м�������ʹ��ȷ��ֵ���������ж��Ӳ�ѯ�Ľ����
������SQL��������ʾ�﷨��ʵ�ʿ���������ô��
SELECT *FROM EMP_LEE
WHERE SAL>ALL(3000��4000��4500)
SELECT *FROM EMP_LEE
WHERE SAL>=ANY(3000��4000��4500)
SELECT *FROM EMP_LEE
WHERE SAL<ANY(3000��4000��4500)

����������Ҳ����ʹ�ú�������ʽ
SELECT *FROM EMP_LEE
WHERE ENAME=UPPER('allen');

SELECT *FROM EMP_LEE
WHERE SAL*12>50000;

SELECT *FROM EMP_LEE
WHERE COMM IS NOT NULL AND SAL>1300 AND JOB='SALESMAN' 

SELECT *FROM EMP_LEE
WHERE SAL*12>30000 AND HIREDATE>TO_DATE('1981-1-1','YYYY-MM-DD')

DISTINCT����ȥ���������ָ���ֶε��ظ�ֵ��
�鿴��˾���ж���ְλ��
SELECT DISTINCT JOB
FROM EMP_LEE

SELECT DISTINCT DEPTNO
FROM EMP_LEE
SELECT ENAME,JOB
FROM EMP_LEE
DISTINCT ���������SELECT �ؼ���֮��
DISTINCT ���ԶԶ���ȥ�أ�ȥ��ԭ������Щ�е����û���ظ�ֵ��
SELECT DISTINCT JOB,DEPTNO
FROM EMP_LEE


ORDER BY �Ӿ�
�������������԰���ָ�����ֶν���
����������С�
ASC ���򣬿��Բ�д��Ĭ��������
DESC ����
��Ҫע�� ORDER BY ֻ�ܶ����� SELECT �������һ���Ӿ��ϡ�
�鿴��˾��������
SELECT ENAME,SAL
FROM EMP_LEE
ORDER BY SAL DESC;

ORDER BY ���ԶԶ��н�������
����������ȼ����Ȱ��յ�һ���ֶε�����ʽ������������
��һ���ֶ����ظ�ֵʱ���ٰ��յڶ����ֶε�����ʽ���������Դ�����
SELECT ENAME,SAL,DEPTNO FROM EMP_LEE
ORDER BY DEPTNO DESC ,SAL DESC
��������ֶκ���NULLֵ��NULL���������ֵ
SELECT ename,comm
FROM EMP_LEE
ORDER BY COMM DESC

�ۺϺ������ֳ�Ϊ���к���
�ۺϺ���������ͳ�ƽ���ġ�

MAX,MIN
ͳ�����ֵ����Сֵ
�鿴��˾���������͹��ʣ�
SELECT MAX(SAL),MIN(SAL)
FROM EMP_LEE

AVG,SUM
ͳ��ƽ��ֵ���ܺ�
�鿴��˾ƽ�������Լ������ܺͣ�
SELECT ROUND(AVG(SAL)),SUM(SAL)
FROM EMP_LEE

COUNT
ͳ�Ƶ��Ǽ�¼��������������ע������ֶε�ȡֵ
�鿴��˾Ա����������
SELECT COUNT(ENAME)
FROM EMP_LEE

�ۺϺ����Ǻ���NULL
SELECT COUNT(COMM)
FROM EMP_LEE

SELECT AVG(NVL(COMM,0)),SUM(COMM)
FROM EMP_LEE

ͳ�Ʊ��м�¼������ʹ��COUNT(*)
SELECT COUNT(*)
FROM EMP_LEE

GROUP BY�Ӿ�
GROUP BY �Ӿ����������
���ո������ֶ�ֵ��ͬ�ļ�¼����һ�飬Ȼ����ϾۺϺ���
��ÿ���¼����ͳ��
�鿴ÿ�����ŵ���߹���
SELECT MAX(sal),deptno
FROM emp_lee
GROUP BY DEPTNO
��SELECT ���оۺϺ���ʱ�������ھۺϺ����еĵ����ֶζ�����
������GROUP BY �Ӿ���
ÿ��ְλ��ƽ�����ʺ͹����ܺ�
SELECT AVG(SAL),SUM(SAL),JOB
FROM EMP_LEE
GROUP BY JOB
ÿ�������ж�����
SELECT COUNT(DEPTNO)��DEPTNO
FROM EMP_LEE
GROUP BY DEPTNO
�鿴ÿ�����ŵ�ƽ�����ʣ�ǰ���Ǹò��ŵ�ƽ�����ʸ���2000
SELECT AVG(SAL),DEPTNO
FROM EMP_LEE
WHERE AVG(SAL)>2000--WHERE �в�������־ۺϺ���
GROUP BY DEPTNO
WHERE �в�������־ۺϺ�����Ϊ����
������ԭ�����ڹ��˻��Ʋ�ͬ��
WHERE�Ĺ���ʱ�����ڵ�һ�δӱ��м�������ʱ��ӹ���������
����ȷ����Щ���ݿ��Ա���ѯ��������ȷ���������

HAVING�Ӿ䣺HAVING�������GROUP BY�Ӿ�֮��
����ʹ�þۺϺ�����Ϊ����������ʹ֮���ԶԷ�����й��ˣ������������ķ���
�������������ȥ����
SELECT AVG(SAL),DEPTNO
FROM EMP_LEE
GROUP BY DEPTNO
HAVING AVG(SAL)>2000
�鿴ƽ�����ʸ���2000�Ĳ��ŵ���߹��ʺ���͹���
SELECT MAX(SAL),MIN(SAL)
FROM EMP_LEE
GROUP BY DEPTNO
HAVING AVG(SAL)>2000--HAVING �ǹ��˷���� �ȹ��˷����SELECT������Ҫ����

������ѯ
��ѯ�Ľ�������ֶ����Զ��ű�
���϶��ű��ѯ���ݾ��ǹ�����ѯ��
�ڹ�����ѯ����Ҫ�ڹ���������������ű��м�¼֮���Ӧ
��ϵ��������������Ϊ����������
N�ű����ϲ�ѯ����Ҫ��N-1�������������������������
������ѿ�����������������£��ý����ͨ����������ģ�����������������
��ϵͳ��Դ�����о޴�Ӱ�졣


�鿴ÿ��Ա���������Լ����ڲ��ŵ����֣�
SELECT ename,dname
from emp_lee,dept
where emp_lee.deptno=dept.deptno --������������д

�ڹ�����ѯ�еĹ�������Ӧ������������ͬʱ������
�鿴SALES���ŵ�Ա����Ϣ��
SELECT ename,dname
FROM emp_lee,dept
where emp_lee.deptno=dept.deptno
and dept.dname='SALES'

����ѯ�����У������ֶ������ű��ж��е������������ȷ���ֶ��������ű�
SELECT E.ENAME,E.DEPTNO,D.DNAME
FROM EMP_LEE E,DEPT D --�������¶�������ﵽ��д
WHERE E.DEPTNO=D.DEPTNO

SELECT E.ENAME,D.DNAME
FROM EMP_LEE E,DEPT D
WHERE E.DEPTNO=D.DEPTNO
AND E.ENAME='SMITH'

SELECT *FROM DEPT

SELECT E.ENAME,D.LOC,D.DNAME
FROM EMP_LEE E,DEPT D
WHERE E.DEPTNO=D.DEPTNO
AND D.LOC='NEW YORK'
�鿴ƽ�����ʸ���2000�Ĳ������ڵأ�
SELECT D.LOC,AVG(E.SAL),D.DNAME
FROM EMP_LEE E,DEPT D
WHERE E.DEPTNO=D.DEPTNO
GROUP BY D.LOC,D.DNAME
HAVING AVG(E.SAL)>2000

������
������ѯ����һ��д��
�鿴SALES���ŵ�Ա����Ϣ
SELECT e.ename,d.dname
FROM emp_lee e JOIN dept d
ON e.deptno=d.deptno
where d.dname='SALES'

������
�������ڽ��й�����ѯʱ���Խ�����������������
��¼Ҳ��ѯ������
�����ӷ�Ϊ���������ӣ��������ӣ�ȫ������

�������ӣ���join�������������ñ������м�¼ȫ�����г���
��ô��ĳ����¼��������������ʱ���ü�¼�������Ҳ�����ֶε�ֵΪNULL

SELECT E.ENAME ,D.DNAME 
FROM EMP_LEE E LEFT OUTER JOIN DEPT D
ON E.DEPTNO=D.DEPTNO

SELECT E.ENAME ,D.DNAME 
FROM EMP_LEE E RIGHT OUTER JOIN DEPT D
ON E.DEPTNO=D.DEPTNO

SELECT E.ENAME ,D.DNAME
FROM EMP_LEE E FULL OUTER JOIN DEPT D
ON E.DEPTNO=D.DEPTNO

SELECT E.ENAME ,D.DNAME
FROM EMP_LEE E,DEPT D
WHERE E.DEPTNO=D.DEPTNO(+)



������
������ָ�����Լ����еļ�¼��Ӧ�Լ�
��Ķ�����¼�������Ĺ�����ѯ���������ӡ�
������������ڽ��������ͬ�����Ǵ������¼���ϵ����״�ṹʹ�á�

�鿴ÿ��Ա���Լ�����˾������
SELECT E.ENAME,D.ENAME
FROM EMP_LEE E,EMP_LEE D
WHERE E.MGR=D.EMPNO(+)

SELECT E.ENAME,D.ENAME
FROM EMP_LEE E,EMP_LEE D
WHERE E.MGR=D.EMPNO(+)
AND D.ENAME='JONES'

SELECT COUNT(E.ENAME),D.ENAME
FROM EMP_LEE E,EMP_LEE D
WHERE E.MGR=D.EMPNO
GROUP BY D.ENAME

�鿴JONES����˾���ĸ����й�����
SELECT D.LOC ,M.ENAME
FROM EMP_LEE E,EMP_LEE M,DEPT D
WHERE E.MGR=M.EMPNO
AND  M.DEPTNO=D.DEPTNO
AND  E.ENAME='JONES' 

SELECT D.LOC ,M.ENAME
FROM EMP_LEE E JOIN EMP_LEE M 
ON E.MGR=M.EMPNO 
JOIN DEPT D ON M.DEPTNO=D.DEPTNO
WHERE E.ENAME='JONES'








