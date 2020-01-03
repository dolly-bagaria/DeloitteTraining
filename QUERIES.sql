select * from employees;

select * from employees where department_id in (select department_id from departments where department_name='Executive');

select last_name, salary, salary+300 from employees;
select last_name"Name", salary*12 "Annual Salary" from employees;
select last_name||q'[, ]'||first_name as "Name" from employees;
desc employees;
select last_name,salary from employees where salary between 17000 AND 24000;
SELECT first_name, last_name from employees where last_name like 'K%';
SELECT first_name, last_name from employees where last_name like '_o%';
select last_name, manager_id from employees where manager_id is null;
SELECT last_name, department_id, salary from employees order by department_id, salary desc;
SELECT last_name, department_id, salary from employees where ROWNUM=1 order by salary desc;
SELECT first_name, last_name, job_id from employees where salary=( select min(salary) from employees);

SELECT employee_id, last_name from employees WHERE employee_id=&employee_id;

select * from jobs;

SELECT employee_id, last_name from employees WHERE job_id='&ejob_id';

select employee_id,first_name,last_name,job_id,&column_name
from employees 
where &condition
order by &order_column;

select employee_id,first_name,last_name,job_id,&&column_name
from employees 
order by &column_name;

select employee_id,first_name,last_name,job_id,&column_nam
from employees 
order by &&column_nam;

select last_name, LPAD(salary, (select LENGTH(max(salary)) from employees), '*') from employees ;

SELECT employee_id, CONCAT(first_name,last_name) NAME, job_id, LENGTH(last_name), INSTR(last_name,'a') "conatains 'a'?"
from employees
where SUBSTR(job_id, 4)='REP';

select ROUND(45.926,2), ROUND(45.926,0), ROUND(455.929,-1)
FROM dual;

select sysdate from dual;

select first_name, hire_date from employees where hire_date between '01-JAN-1990' and '31-DEC-10';

select round(sysdate, 'month'),round(sysdate, 'year'),round(sysdate, 'day') from dual;

select last_name, to_char(hire_date, 'DD Month YYYY') as hiredate from employees;

select last_name,upper(concat(substr(last_name,1,8),'_us')) 
from employees
where department_id=60;

select last_name, job_id, commission_pct from employees where commission_pct is null;

select last_name, salary, NVL(commission_pct, 0),
(salary*12) + (salary*12*NVL(commission_pct, 0.1)) AN_SAL
from employees
where UPPER(job_id) like 'ST_CLERL';

select last_name,salary,job_id,nvl(commission_pct,0.1),(salary*12)+(salary*12*nvl(commission_pct,0.1)) AN_SAL 
from employees
where upper(job_id) like 'ST_CLERK';

select * from employees where hire_date is null;

select last_name, salary, commission_pct,NVL2(commission_pct, 'SAL+COMM', 'SAL') income
from employees
where department_id in (50,80);

select first_name, length(first_name) "expr_1",
       last_name,  length(last_name) "expr_2",
       nullif(length(first_name),length(last_name)) RESULT
from employees;

select last_name, manager_id, commission_pct,
       coalesce(manager_id, commission_pct,-1) comm
from employees
order by commission_pct;

select last_name, job_id, salary,
       CASE job_id WHEN 'IT_PROG' THEN 1.10*salary
                   when 'ST_CLERK' THEN 1.15*salary
                   when 'SA_REP' THEN 1.20*salary
       ELSE salary END "REVISED SALARY"
from employees;

select last_name, department_id,salary,
       decode(department_id, 30, 1.10*salary,
                             40, 1.15*salary,
                             50, 1.20*salary,
              salary)
        REVISED_SALARY
from employees;

select last_name, salary,
decode(trunc(salary/2000,0), 0, 0.00,
                             1, 0.09,
                             2, 0.20,
                             3,0.3,
                             4,0.4,
                             5,0.42,
                             6,0.44,
              0.45) TAX_RATE
from employees
WHERE DEPARTMENT_ID=80;

SELECT MAX(SALARY)-&&VAR, AVG(SALARY)-MIN(SALARY)
FROM EMPLOYEES;

SELECT COUNT(DISTINCT DEPARTMENT_ID)
FROM DEPARTMENTS;

SELECT COUNT(DISTINCT DEPARTMENT_ID)
FROM EMPLOYEES;

SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID) FROM EMPLOYEES GROUP BY(DEPARTMENT_ID) ORDER BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID,JOB_ID, COUNT(EMPLOYEE_ID), SUM(SALARY) FROM EMPLOYEES GROUP BY(DEPARTMENT_ID, JOB_ID) ORDER BY DEPARTMENT_ID;

SELECT COUNT(EMPLOYEE_ID) 
FROM EMPLOYEES 
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEES);

select e.employee_id, e.first_name, l.city
from employees e, departments d, locations l
where ((e.department_id=d.department_id) and (d.location_id=l.location_id));


select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e join departments d
on (e.department_id=d.department_id);

select e.last_name EMP,m.last_name MGR
from employees e join employees m
on (e.MANAGER_ID=m.EMPLOYEE_ID)
where m.last_name='Kochhar';

select e.employee_id, e.first_name, l.city
from employees e, departments d, locations l
where ((e.department_id=d.department_id) and (d.location_id=l.location_id) and l.city='Seattle');


select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e join departments d
on (e.department_id=d.department_id) 
join locations l
on d.location_id=l.location_id
where l.city like 'Seattle' ;

select * from jobs;


select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e left outer join departments d
on (e.department_id=d.department_id);


select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e right outer join departments d
on (e.department_id=d.department_id);


select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e full outer join departments d
on (e.department_id=d.department_id);

select last_name, department_name from employees cross join departments;

select employee_id, salary from employees where last_name='Abel';

select last_name from employees where salary > (select salary from employees where last_name='Abel');

select last_name job_id, salary 
from employees 
where job_id=(select job_id from employees where employee_id=141) 
and salary > (select salary from employees where employee_id=143);

select last_name job_id, salary 
from employees 
where salary=(select min(salary) from employees);

select last_name job_id, salary 
from employees 
where salary < (select avg(salary) from employees);

select employee_id, last_name
from employees
where salary in  (select min(salary) from employees group by department_id);

select employee_id, last_name,job_id,salary
from employees
where salary <all  (select salary from employees where job_id='IT_PROG')
and job_id<> 'IT_PROG';

select emp.last_name 
from employees emp
where emp.employee_id NOT IN (select DISTINCT m.manager_id from employees m);

select e.employee_id
from employees e join employees m
on (e.MANAGER_ID=m.EMPLOYEE_ID);

select count(*) from employees;

select distinct m.manager_id from employees m;

select emp.employee_id
from employees emp
where emp.employee_id NOT IN (select DISTINCT m.manager_id from employees m WHERE m.manager_id is not null);

select last_name, department_id 
from employees 
where department_id in (20,50) 
order by last_name;

select last_name, hire_date from employees where hire_date like '%04';

select last_name,hire_date
from employees
where hire_date between '01-JAN-04' and '31-DEC-04';

select last_name, salary, commission_pct
from employees
where commission_pct is not null
order by salary desc, commission_pct desc;

select last_name 
from employees
where last_name like '__a%';

select last_name 
from employees
where last_name like '%a%' and last_name like '%e%';

select last_name, job_id, salary
from employees
where job_id in('SA_REP', 'ST_CLERK')
and salary not in(2500, 3500, 7000);

SELECT INITCAP(last_name) lastName,
decode(last_name , 'J%', length(last_name),
                  'A%', length(last_name),
                  'M%', length(last_name),
    0) length_name
from employees;

select initcap(last_name), length(last_name)
from employees
where last_name like 'J%' or last_name like 'A%' or last_name like 'M%';

select last_name, round(months_between(sysdate,hire_date)) MONTHS_WORKED
from employees
order by months_between(sysdate,hire_date);

SELECT LAST_NAME, DEPARTMENT_ID
FROM EMPLOYEES 
WHERE DEPARTMENT_ID=(SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME LIKE 'Abel');

select last_name, hire_date 
from employees
where hire_date > (select hire_date from employees where last_name like 'Davies');

select e.last_name, e.hire_date 
from employees e
where e.hire_date <(select hire_date from employees d where d.employee_id=e.manager_id);

select e.last_name, e.hire_date, m.last_name, m.hire_date
from employees e, employees m
where e.manager_id = m.employee_id and e.hire_date<m.hire_date;

select e.employee_id, e.last_name, e.department_id, l.city
from employees e, departments d, locations l
where e.department_id=d.department_id and d.location_id=l.location_id and l.city like 'T%';

select employee_id, last_name, department_id
from employees
where department_id in(select department_id from departments where location_id in
                                                                                (select location_id from locations where city like 'T%'));
                                                                            
select employee_id, last_name
from employees e
where not exists (select manager_id from employees d where e.employee_id=d.manager_id);

  SELECT  last_name 
  FROM employees o 
  WHERE EXISTS (SELECT 'X' FROM employees i 
  WHERE i.department_id = o.department_id
  AND i.hire_date > o.hire_date
  AND i.salary > o.salary);	
  
  select e.employee_id, e.last_name, d.department_name
  from employees e, departments d
  where e.department_id=d.department_id;
  
select employee_id, last_name, inner.department_name from employees outer, departments inner where exists
 (select 'X' from departments where inner.department_id=outer.department_id);
 
select sum(salary)/8 from employees;

select d.department_name, sum(e.salary) sal
from employees e, departments d
where e.department_id=d.department_id 
group by department_name;


with temp(s) as (select sum(e.salary) from employees e, departments d where e.department_id=d.department_id group by department_name ),
select d.department_name, sum(e.salary)
from employees e, departments d
where e.department_id=d.department_id and temp.s>(select sum(salary)/8 from employees)
group by department_name;
 
 WITH summary AS ( SELECT d.department_name, SUM(e.salary) AS dept_total FROM employees e, departments d WHERE e.department_id = d.department_id GROUP BY d.department_name) 
 SELECT department_name, dept_total 
 FROM summary 
 WHERE dept_total > ( SELECT SUM(dept_total) * 1/8 FROM summary ) 
 ORDER BY dept_total DESC; 

select employee_id, job_id
from employees
union
select employee_id, job_id
from job_history;

select employee_id, job_id
from employees
intersect
select employee_id, job_id
from job_history; 

select employee_id,job_id,department_id
from employees
UNION ALL
select employee_id,job_id,department_id
from job_history
order by employee_id;

select employee_id,job_id,department_id
from employees
where employee_id=200
UNION 
select employee_id,job_id,department_id
from job_history
where employee_id=200
order by employee_id;

select employee_id, job_id
from employees
minus
select employee_id, job_id
from job_history; 

select department_id, TO_NUMBER(null) location, hire_date
from employees
union 
select department_id, location_id, TO_DATE(null)
from departments;

select employee_id, department_id, TO_NUMBER(null) location, hire_date
from employees
union 
select TO_NUMBER(NULL) EMPLOYEE_ID ,department_id, location_id, TO_DATE(null)
from departments;

SELECT department_id, location_id
from departments
union
select  TO_NUMBER(NULL) department_id, LOCATION_ID
from locations;

SELECT employee_id, job_id, salary
from employees
union
select employee_id, job_id,0
from job_history;


column a_dummy NOPRINT
select 'sing' AS "My dream",3 a_dummy
from dual
union
select 'I''d like to teach',1 a_dummy
from dual
union
select 'the world to', 2 a_dummy
from dual
order by a_dummy;

INSERT INTO departments(department_id,department_name, manager_id, location_id)
values(71,'Public Relations',100,1700);

INSERT INTO departments
values(100,'Finance',NULL,NULL);

INSERT INTO departments(department_id,department_name)
VALUES (30,'Purchasing');

insert into employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES (1130,'LOUIS','Popp','louis@gmail.com','515.124.4567',SYSDATE,'AC_ACCOUNT',6900,NULL,205,71);

insert into employees
values (1131,'Dolly','Bagaria','dolly@gmail.com','515.124.4567',TO_DATE('FEB 3, 1999', 'MON DD, YYYY'),'AC_ACCOUNT',69000,NULL,205,71);

SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID=71;

insert into departments
(department_id,department_name,location_id)
values(&department_id,'&department_name',&location_id);

INSERT INTO sa_rep(id, name, salary, commission_pct)
select employee_id,last_name,salary,commission_pct
from employees
where job_id LIKE '%REP%';

update employees
set department_id=70
where employee_id=1131;

SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=1131;

select * from departments where department_name='TEST';

insert into employees
values (1132,'Niharika','Bagaria','niharika@gmail.com','515.124.4567',TO_DATE('FEB 3, 1999', 'MON DD, YYYY'),'AC_ACCOUNT',69000,NULL,205,72);

select * from employees where department_id=72;

delete from employees
where department_id=(select department_id from departments where department_name='TEST');

select * from employees where department_id=72;

select * from employees where department_id=71;

select * from locations;

insert into locations 
values (3300, 'Financial district', 560037, 'Hyderabad', 'Telangana', 'IN');

insert into departments
(department_id,department_name,location_id)
values(73,'TEST_DEPT',3300);

insert into employees
values (1135,'Pragyat','Singh','pragyat@gmail.com','515.124.4567',TO_DATE('FEB 3, 1999', 'MON DD, YYYY'),'AC_ACCOUNT',69000,NULL,205,73);

update employees
set salary=(salary+(salary*10/100))
where employee_id=1135;

select * from employees where employee_id=1135;

delete from employees
where department_id=
                    (select department_id from departments where location_id = 
                    (select location_id from locations where city='Hyderabad'));
                    
select * from employees where department_id=50;

insert into
          (select employee_id, last_name,email, hire_date, job_id, salary, department_id
            FROM employees
            where department_id=50)
values (99999, 'taylor', 'dtay', TO_DATE('07-JUN-99', 'DD-MON-RR'), 'ST_CLERK', 5000, 50);

select * from employees where department_id=50;

update employees
set first_name='Swift'
where employee_id=99999;

select * from employees where department_id=50;

savepoint update_done;

insert into
          (select employee_id, last_name,email, hire_date, job_id, salary, department_id
            FROM employees
            where department_id=50)
values (99997, 'taylor', 'dtay@gmail.com', TO_DATE('07-JUN-99', 'DD-MON-RR'), 'ST_CLERK', 5000, 50);

Rollback to update_done;

select * from employees where employee_id=99997;

select * from employees where employee_id=99999;

delete from employees
where employee_id=99999;

insert into departments
(department_id,department_name,location_id)
values(74,'Corporate tax',3100);

commit;

create table dept
                (depatno NUMBER(2),
                 dname VARCHAR(14),
                 loc VARCHAR(13),
                 create_date DATE DEFAULT SYSDATE);

create table dept80
    as
        select employee_id, last_name, salary*12 ANNSAL
        from employees
        where department_id=80;

select * from dept80;

select employee_id, last_name, salary*12 ANNSAL
from employees
where department_id=80;

desc dept80;

create table emp_copy
as
    select * from employees;

delete from emp_copy;
rollback;

select * from emp_copy;

insert into emp_copy
values (207,'Niharika','Bagaria','niharika@gmail.com','515.124.4567',TO_DATE('FEB 3, 1999', 'MON DD, YYYY'),'AC_ACCOUNT',69000,NULL,205,110);

delete from emp_copy
where employee_id=207;
commit;

rollback;

select * from emp_copy where employee_id=207;


create table roles
(role_id NUMBER(3) CONSTRAINT role_id_pk PRIMARY KEY,
 name VARCHAR2(10));
 
create table users
(id  NUMBER(3) CONSTRAINT user_id_pk PRIMARY KEY,
 name VARCHAR2(20),
 username VARCHAR2(20),
 password  VARCHAR2(20) check (LENGTH(password)>8),
 email VARCHAR2(20),
 role_id NUMBER(3) CONSTRAINT role_id_fk REFERENCES roles(role_id));
 
 INSERT into roles
 values
 (1,'Admin');
 
 INSERT into roles
 values
 (2,'Manager');
  
 INSERT into roles
 values
 (3,'User');
 
 select * from roles;
 
drop table users;

create table users
(id  NUMBER(3) CONSTRAINT user_id_pk PRIMARY KEY,
 name VARCHAR2(20) CONSTRAINT name_nn NOT NULL ,
 username VARCHAR2(20) CONSTRAINT username_nn NOT NULL CONSTRAINT username_uk UNIQUE,
 password  VARCHAR2(20) check (LENGTH(password)>8),
 email VARCHAR2(20) CONSTRAINT email_nn NOT NULL CONSTRAINT email_uk UNIQUE,
 role_id NUMBER(3) CONSTRAINT role_id_fk REFERENCES roles(role_id));
 
 insert into users
 values
 (101,'Niharika','nigu1','password1','nigu@gmail.com',1);
 
insert into users
values
(102,'Pragyat','pasi1','password2','pasi@gmail.com',2);

insert into users
values
(103,'Dolly','doba1','password3','doba@gmail.com',2);
 
insert into users
values
(104,'Yashvi','yame1','password4','yame@gmail.com',3);

insert into users
values
(105,'Pranav','pana1','password5','pana@gmail.com',3);

select * from users;

update users
set mobile='9987536325'
where id=101;

update users
set mobile='9987536326'
where id=102;

update users
set mobile='914536325'
where id=103;

update users
set mobile='7787536325'
where id=104;

update users
set mobile='7987536300'
where id=105;

select * from users;

update users
set mobile='7787536325'
where id=105;

insert into users
values
(106,'Geeta','geta1','pass6','geta@gmail.com',3,'9874561251');

select * from users;

delete from users
where id=106;

create view empvu80
as select employee_id, last_name, salary
from employees
where department_id=80;

DESCRIBE empvu80;

select * from empvu80;

create or replace view empvu80
(id_number, name, sal, department_id)
as select employee_id, first_name || ' ' || last_name, salary, department_id
from employees
where department_id=80;

select * from empvu80;

create or replace view dept_sum_vu 
(name,minsal,maxsal,avgsal)
as select d.department_name,min(e.salary),max(e.salary),trunc(avg(e.salary),3)
FROM employees e JOIN departments d
ON (e.department_id=d.department_id)
GROUP BY d.department_name;

select * from dept_sum_vu;

create or replace view empvu20
as select * from employees
where department_id=20
with check option constraint empvu20_ck;

describe empvu20;

select * from empvu20;

update empvu20 set department_id=20;

create or replace view empvu20
as select * from employees
where department_id=20;

update empvu20 set department_id=10;

create or replace view empvu10
(employee_number, employee_name, job_title)
as select employee_id, last_name, job_id from employees
where department_id=10
with read only;

select * from empvu10;
update empvu10 set employee_name='jane' where employee_number=200;

select * from users;

CREATE SEQUENCE users_id_seq
                INCREMENT BY 1
                START WITH 106
                MAXVALUE 9999
                NOCACHE
                NOCYCLE;
                
INSERT INTO users
values
(users_id_seq.NEXTVAL,'Seeta','seta1','password7','seta@gmail.com',3,'9874561252');

select * from users;

select users_id_seq.CURRVAL from dual;

delete from users where id=107;

CREATE SEQUENCE users_id_seq1
                INCREMENT BY 1
                START WITH 106
                MAXVALUE 9999
                NOCACHE
                NOCYCLE;
                
INSERT INTO users
values
(users_id_seq1.NEXTVAL,'Seeta','seta1','password7','seta@gmail.com',3,'9874561252');

select * from users;

select users_id_seq1.currval from dual;

CREATE SEQUENCE role_id_seq1
                INCREMENT BY 1
                START WITH 1
                MAXVALUE 9999
                NOCACHE
                NOCYCLE;
                
select * from roles;

insert into roles values (role_id_seq1.nextval, 'supervisor',null);

create INDEX users_name_idx
on users (name);

create or replace view manager_view_from_users
(user_id, name_name, email)
as select id, name, email from users
where role_id=2;

create synonym mngr_vu
for manager_view_from_users;

describe dictionary;

select * from dictionary where table_name='user_objects';
select * from dictionary;

select object_name, object_type, created, status
from user_objects
order by object_type;

describe user_tables;

select table_name from user_tables;

select column_name, data_type, data_length, data_precision, data_scale, nullable
from user_tab_columns
where table_name='USERS';

DESCRIBE USER_CONSTRAINTS;

SELECT constraint_name, constraint_type, search_condition, r_constraint_name, delete_rule, status
from USER_CONSTRAINTS
where table_name='USERS';

SELECT constraint_name,column_name
from user_cons_columns
where table_name='USERS';

describe user_views;

select distinct view_name from user_views;

select text from user_views where view_name='EMPVU80';

select sequence_name, min_value,max_value, increment_by, last_number
from user_sequences;

select * from user_synonyms;

desc user_synonyms;

comment on table users
is 'user information';

select * from users;

select * from user_tab_comments;

select u.id, u.name, u.username, u.password, u.email,u.role_id, r.name Role_Name, u.mobile from users u,roles r where u.role_id=r.role_id; 

select * from employees;


set SERVEROUTPUT ON;
DECLARE
     a NUMBER := 3;
BEGIN
    a := a+1;
    DBMS_output.put_line(a);
END;
/

set serveroutput on;

declare 
    a Number;
    b Number;

begin 
    select role_id,role_name into a,b from role where role_id=1;
    
    if b=1 then
         insert into t1 values (b,a);
    else
         a := a+b;

end;
/

set SERVEROUTPUT ON;
DECLARE
     a NUMBER := 5;
BEGIN
    a := a+1;
    if mod(a,2)=0 then
        DBMS_output.put_line(a);
    else 
        DBMS_output.put_line(a+1);
    end if;
END;
/

DECLARE
    i NUMBER := 1;
BEGIN
    LOOP
        INSERT INTO T1 values(i,i);
        i:=i+1;
        EXIT WHEN i>100;
    END LOOP;
END;
/

SELECT * FROM T1;
delete from t1;

DECLARE
    i NUMBER := 100;
BEGIN
    WHILE i<100 LOOP
        INSERT INTO T1 values(i,i);
        i:=i+1;
        
    END LOOP;
END;
/

SELECT * FROM T1;

declare 
    i number:=1;
begin
    while i <= 150 loop
        insert into T2 values(i,i);
        i:=i+1;
    end loop;
end;
/

select * from t2;

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    n_pct employees.commission_pct%TYPE;
    v_eval varchar2(10);
    n_emp_id employees.employee_id%TYPE := 145;
BEGIN
    SELECT commission_pct
    INTO n_pct
    FROM employees
    WHERE employee_id=n_emp_id;
    
    CASE n_pct
        when 0 then
            v_eval:='N/A';
        when 0.1 then
            v_eval:='Low';
        when 0.4 then
            v_eval:='High';
        else 
            v_eval:='Fair';
    end case;
    DBMS_output.put_line('Employee '||n_emp_id||' commission '||to_char(n_pct)||' which is '||v_eval);
end;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    n_name users.name%TYPE := 'Dolly';
    v_role_id users.role_id%TYPE;
    v_role_name varchar2(10);
BEGIN
    SELECT role_id 
    INTO v_role_id
    FROM users
    WHERE name=n_name;
    
    CASE v_role_id
        when 1 then
            v_role_name:='Admin';
        when 2 then
            v_role_name:='Manager';
        when 3 then
            v_role_name:='User';
        when 4 then
            v_role_name:='Supervisor';
    end case;
    DBMS_output.put_line('User '||n_name||' role is '||v_role_name);
end;
/

select * from employee_salary;


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
     n_name employee_salary.name%TYPE := 'pragyat';
     n_salary employee_salary.gross_salary%TYPE;
     n_tax INTEGER;
BEGIN
    SELECT gross_salary
    INTO n_salary
    FROM employee_salary
    WHERE name=n_name;
    CASE 
        when n_salary<=20000 then
            n_tax:=10*n_salary/100;
        when n_salary>20000 and n_salary<=30000 then
            n_tax:=15*n_salary/100;
       when n_salary>30000 and n_salary<=40000 then
            n_tax:=20*n_salary/100; 
        else
            n_tax:=25*n_salary/100;
    end case;
    DBMS_output.put_line('Employee: '||n_name||' tax: Rs.'||n_tax );
END;
/

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  n_emp_id EMPLOYEES.EMPLOYEE_ID%TYPE := &emp_id1;
BEGIN
  DECLARE
    n_emp_id employees.employee_id%TYPE := &emp_id2;
    v_name   employees.first_name%TYPE;
  BEGIN
    SELECT first_name
    INTO v_name
    FROM employees
    WHERE employee_id = n_emp_id;
 
    DBMS_OUTPUT.PUT_LINE('First name of employee ' || n_emp_id || 
                                       ' is ' || v_name);
    EXCEPTION
      WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('Employee ' || n_emp_id || ' not found');
  END;
END;
/

SET SERVEROUTPUT ON SIZE 1000000;
<<parent>>
DECLARE
  n_emp_id EMPLOYEES.EMPLOYEE_ID%TYPE := &emp_id1;
BEGIN
  <<child>>
  DECLARE
    n_emp_id employees.employee_id%TYPE := &emp_id2;
    v_name   employees.first_name%TYPE;
  BEGIN
    SELECT first_name
    INTO v_name
    FROM employees
    WHERE employee_id = parent.n_emp_id;
 
    DBMS_OUTPUT.PUT_LINE('First name of employee ' || parent.n_emp_id || 
                         ' is ' || child.v_name);
 
    EXCEPTION
      WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('Employee ' || parent.n_emp_id || ' not found');
  END;
END;
/



SET SERVEROUTPUT ON SIZE 1000000;
<<parent>>
DECLARE
    n_id employee_salary.emp_no%TYPE := &id1;
    n_name employee_salary.name%TYPE := '&name1';
    n_basic employee_salary.basic%TYPE := &basic1;
    n_hra employee_salary.hra%TYPE := &hra1;
    n_da employee_salary.da%TYPE := &da1;
    n_total_deduction employee_salary.total_deduction%TYPE := &total_deduction1;
    n_net_salary employee_salary.net_salary%TYPE := &net_salary1;
    n_gross_salary employee_salary.gross_salary%TYPE := &gross_salary1;
BEGIN
    INSERT into employee_salary
    VALUES (n_id,n_name,n_basic,n_hra,n_da,n_total_deduction,n_net_salary,n_gross_salary);
    
    
        <<child>>
        DECLARE
             n_salary employee_salary.gross_salary%TYPE;
             n_tax INTEGER;
        BEGIN
            SELECT gross_salary
            INTO n_salary
            FROM employee_salary
            WHERE name=parent.n_name;
            CASE 
                when n_salary<=20000 then
                    n_tax:=10*n_salary/100;
                when n_salary>20000 and n_salary<=30000 then
                    n_tax:=15*n_salary/100;
               when n_salary>30000 and n_salary<=40000 then
                    n_tax:=20*n_salary/100; 
                else
                    n_tax:=25*n_salary/100;
            end case;
            DBMS_output.put_line('Employee: '||parent.n_name||' tax: Rs.'||n_tax );
        END;
END;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT u.username,
             r.name
      FROM users u
      INNER JOIN roles r ON u.role_id=r.role_id;
 
  r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
 
    EXIT WHEN cur_chief%NOTFOUND;
 
    -- print department - chief
    DBMS_OUTPUT.PUT_LINE(r_chief.username || ' - ' ||
                         r_chief.name);
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/

delete from t2;
select * from t2;

declare 
    i number:=1;
begin
while i<150 loop
    insert into T2 values(i,i+1);
        i:=i+1;
    end loop;
end;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    E T2.A%TYPE;
    F T2.B%TYPE;
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT A,B
      FROM T2
      WHERE A<B
      FOR UPDATE;
 
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO E,F;
    
    EXIT WHEN cur_chief%NOTFOUND;
    
    UPDATE t2 set A=F, B=E where CURRENT OF cur_chief;
 
    DBMS_OUTPUT.PUT_LINE('done');
    
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/

SELECT * FROM T2;

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE

  -- declare a cursor
  CURSOR cur_chief IS
      SELECT salary, hire_date
      FROM EMP_COPY
      WHERE hire_date > '31-DEC-05'
      FOR UPDATE;
      
r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
    
    EXIT WHEN cur_chief%NOTFOUND;
    
    UPDATE EMP_COPY set salary=(salary+(r_chief.salary*10/100)) where CURRENT OF cur_chief;
 
    DBMS_OUTPUT.PUT_LINE('done');
    
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/

SELECT EMPLOYEE_ID, HIRE_DATE, SALARY FROM EMP_COPY;



SET SERVEROUTPUT ON SIZE 1000000;
DECLARE

  -- declare a cursor
  CURSOR cur_chief IS
      SELECT first_name, last_name, hire_date
      FROM EMP_COPY
      ORDER BY hire_date asc;
      
r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  --LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
    
    --EXIT WHEN cur_chief%NOTFOUND;
    
    
 
    DBMS_OUTPUT.PUT_LINE('The Oldest Employee is '||r_chief.last_name || ', ' || r_chief.first_name);
    
 -- END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/

SELECT first_name, last_name, hire_date
      FROM EMP_COPY
      ORDER BY hire_date asc;
    
    
    
      
SET SERVEROUTPUT ON SIZE 1000000;

DECLARE
    E employees.last_name%TYPE;
    F employees.first_name%TYPE;
    G employees.hire_date%type;
    
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT last_name,first_name,hire_date
      FROM employees
      WHERE hire_date= (select min(hire_date) from employees);
 
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO E,F,G;
    
    EXIT WHEN cur_chief%NOTFOUND;    
    DBMS_OUTPUT.PUT_LINE('The oldest employee is' || '  ' ||
                         E || ', ' ||
                         F);
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/



SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  --row_count INTEGER:=0;
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT first_name, last_name, hire_date
      FROM EMPLOYEES;
      
r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
    
    EXIT WHEN cur_chief%ROWCOUNT=12;
 
    DBMS_OUTPUT.PUT_LINE(r_chief.last_name || ', ' || r_chief.first_name);
  --  row_count := row_count+1;
    
 END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/

