1:��ѯEMP���е����ݣ��г�һ�У�����Ϊ������ְλ
��ʾ��ʽ��ename:job
SELECT ename||':'||job
FROM EMP_LEE
SELECT CONCAT(CONCAT(ENAME,':'),JOB)
FROM EMP_LEE
2:�鿴ÿ��Ա��ְλ���ַ�����
SELECT ename,LENGTH(ename)
FROM EMP_LEE
3:������Ա����������Сд��ʽ��������ĸ��д��ʽ
   ��ѯ��������һ��ΪСд��ʽ���ڶ���Ϊ����ĸ��д
SELECT LOWER(ename),INITCAP(ename)
FROM emp_lee
4:���ַ���'aaaaaabaaaaa'���������ߵ�aȥ��
SELECT TRIM('a'FROM'aaaaaabaaaa')
FROM dual

5:��ʾÿ��Ա�������֣�Ҫ����ʾ10λ����һ�������Ч�����ڶ���    �Ҷ���Ч��
SELECT LPAD(ename,10,' '),RPAD(ename,10,' ')
FROM emp_lee
6:��ȡ�ַ���'DOCTOR WHO'�е�'WHO'
SELECT SUBSTR('DOCTOR WHO',-3,3)
FROM dual
7:�鿴'DOCTOR WHO'��'WHO'��λ��
SELECT INSTR('DOCTOR WHO','WHO')
FROM DUAL
8:�ֱ�鿴55.789�������뱣��С�����2λ������λ��ʮλ���
   ���֣���ʾ�����С�
SELECT ROUND(55.789,2),ROUND(55.789),ROUND(55.789,-1)
FROM DUAL
9:�ֱ�鿴55.789��ȡ����С�����2λ������λ��ʮλ���
   ���֣���ʾ�����С�
SELECT TRUNC(55.789,2),TRUNC(55.789),TRUNC(55.789,-1)
FROM dual;
10���鿴ÿ��Ա�����ʰ�λ���µ�����?
SELECT ename,sal,MOD(sal,100)
FROM emp_lee;
11:�鿴ÿ��Ա������ְ������һ�������죬����С��������ȡ����
SELECT ename,ROUND(SYSDATE-hiredate)
FROM emp_lee;
12:�鿴��2008-08-08�ŵ�����Ϊֹһ�������˶�����?
SELECT TRUNC(SYSDATE-TO_DATE('2008-08-08','YYYY-MM-DD'))
FROM DUAL
13:��ÿ��Ա����ְʱ��������:
     1981��12��3��
     ����ʽ��ʾ
SELECT ename,TO_CHAR(hiredate,'YYYY"��"MM"��"DD"��"')
FROM emp_lee;
14���鿴ÿ��Ա����ְ�����µ��µ�������?
SELECT ename,LAST_DAY(hiredate)
FROM emp_lee;
15:�鿴ÿ��Ա��ת������(��ְ��3����)
SELECT ename,ADD_MONTHS(hiredate,3)
FROM emp_lee;
16���鿴ÿ��Ա����ְ���񹲶��ٸ���?
SELECT ename,MONTHS_BETWEEN(SYSDATE,hiredate)
FROM emp_lee;
17:�鿴�����쿪ʼһ���ڵ�����������?
SELECT NEXT_DAY((SYSDATE+1),1)
FROM DUAL
18:�鿴82���Ժ���ְ��Ա������ְ���ڣ�82����ǰ�İ���
     1982��01��01����ʾ����ʽ����DD-MON-RR(Ĭ�ϸ�ʽ)
SELECT ename,greatest(hiredate,TO_DATE('1982��01��01��','YYYY"��"MM"��"DD"��"'))
FROM EMP_LEE
19:�鿴ÿ��Ա������ְ���?
SELECT ENAME,EXTRACT( YEAR FROM hiredate)
FROM emp_lee
20:��ʾÿ��Ա����������(���ʼӽ���)������ΪNULL��ֻ������
SELECT ENAME,nvl(COMM,0)+SAL
FROM EMP_LEE
21:ʹ��NVL2ʵ��20�������
SELECT ENAME,nvl2(COMM,SAL+COMM,SAL)AS SALARY
FROM EMP_LEE

     


