SELECT SYSDATE FROM dual

������
CREATE TABLE employee_xxx(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
)

�鿴��ṹ
DESC employee


����Ĭ��ֵ
�����ݿ��У������ֶ���ʲô���ͣ�Ĭ��
ֵ����NULL�����ǿ����ڴ������ʱ��ͨ
��DEFAULT�ؼ���Ϊָ�����е�������Ĭ��
ֵ��
�����ݿ��У��ַ���ʹ�õ����ű�ʾ��������
��һ����java��һ�£���Ҫע��!

ɾ����
DROP TABLE employee_xxx

NOT NULLԼ��
NOT NULLԼ������ȷ��ָ�����ֶβ�
����ΪNULL��
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20) NOT NULL,
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
)

�޸ı�
1:�޸ı���
RENAME employee TO myemp

DESC myemp

2:�޸ı�ṹ
2.1:������ֶ�

���������µ��ֶΣ�ֻ���ڵ�ǰ���
ĩβ׷�ӡ�����ͬʱ׷�Ӷ���У�ֻ��Ҫ
ʹ�ö��Ÿ������ɣ��봴����������ʱ��
���﷨һ�¡�
ALTER TABLE myemp ADD(
  hiredate DATE DEFAULT SYSDATE
)

DESC myemp

2.2:ɾ�����������ֶ�
ɾ��myemp���е�hiredate�ֶ�
ALTER TABLE myemp DROP(hiredate)

2.3:�޸ı��������ֶ�
�����޸��ֶε����ͣ����ȣ�Ĭ��ֵ���ǿ�
ALTER TABLE myemp MODIFY(
  job VARCHAR2(40) DEFAULT 'CLERK'
)

DESC myemp

DML���
�����޸ı������ݣ���Ϊ:����ɾ����

1:��������
INSERT INTO myemp
(id,name,job,salary)
VALUES
(1,'jack','CLERK',5000)


SELECT * FROM myemp


�����������ͣ�����ʹ��TO_DATE������
����ʹ���ַ��������Ǹ�ʽ������
'DD-MON-RR'���������Բ��죬���Ƽ���
INSERT INTO myemp
(id,name,job,birth)
VALUES
(2,'rose','CLERK',
 TO_DATE('1992-08-02','YYYY-MM-DD')
)

2:�޸ı�����������
��jack�Ĺ��ʸ�Ϊ5500

UPDATE myemp
SET salary=6000,job='MANAGER'
WHERE name='jack'

�޸ı������ݵ�ʱ��ͨ��Ҫʹ��
WHERE�޶�����������ֻ�Ὣ����
�����ļ�¼�����޸ģ�����ָ��WHERE
����ȫ���������ݶ��޸�!

3:ɾ����������
��roseɾ��
DELETE FROM myemp
WHERE name='rose'

ɾ����������ͬ��Ҫʹ��WHERE���
�������������������ձ������



SELECT * FROM myemp


