-- exception handling
SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    l_name users.name%TYPE;
    l_customer_id users.id%TYPE := &customer_id;
BEGIN
    -- get the customer
    SELECT name INTO l_name
    FROM users
    WHERE id <= l_customer_id;
    
    
    dbms_output.put_line('Customer name is ' || l_name);
 
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            dbms_output.put_line('Customer ' || l_customer_id ||  ' does not exist');
        WHEN TOO_MANY_ROWS THEN
            dbms_output.put_line('The database returns more than one customer');   
END;
/

-- PL/SQL raise exception
SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    password_length_low EXCEPTION;
    PRAGMA exception_init( password_length_low, -20001 );
    l_username users.username%TYPE;
    l_password users.password%TYPE := '&l_password1';
BEGIN
    IF length(l_password)<8 then
        RAISE password_length_low;
    else
        select u.username into l_username
        from users u
        where u.password=l_password;
        dbms_output.put_line('usermane is ' || l_username );
    END IF;
  
END;
/


-- PL/SQL raise exception message
SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    password_length_low EXCEPTION;
    PRAGMA exception_init( password_length_low, -20001 );
    l_username users.username%TYPE;
    l_password users.password%TYPE := '&l_password1';
BEGIN
    IF length(l_password)<8 then
        raise_application_error(-20001,'password length is low');
    else
        select u.username into l_username
        from users u
        where u.password=l_password;
        dbms_output.put_line('usermane is ' || l_username );
    END IF;
  
END;
/
-- update salary of an employee, if slary not between the min and max then raise an error
SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    salary_out_of_range EXCEPTION;
    PRAGMA exception_init( salary_out_of_range, -20001 );
    u_employee_id employees.employee_id%TYPE:= &empid;
    u_salary employees.salary%TYPE := &sal;
    u_min_salary jobs.min_salary%TYPE;
    u_max_salary jobs.max_salary%TYPE;
BEGIN
    select min_salary, max_salary
    into u_min_salary,u_max_salary
    from employees e, jobs j
    where e.employee_id=u_employee_id and e.job_id=j.job_id;
    
    if u_salary<= u_min_salary and u_salary>=u_max_salary then
        update employees 
        set salary=u_salary
        where employee_id=u_employee_id;
    else
         raise_application_error(-20001,'salary out of range');
    end if;
    commit;
END;
/


--exception block
SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    salary_out_of_range EXCEPTION;
    PRAGMA exception_init( salary_out_of_range, -20001 );
    u_employee_id employees.employee_id%TYPE:= &empid;
    u_salary employees.salary%TYPE := &sal;
    u_min_salary jobs.min_salary%TYPE;
    u_max_salary jobs.max_salary%TYPE;
BEGIN
    select min_salary, max_salary
    into u_min_salary,u_max_salary
    from employees e, jobs j
    where e.employee_id=u_employee_id and e.job_id=j.job_id;
    
    if u_salary<= u_min_salary and u_salary>=u_max_salary then
        update employees 
        set salary=u_salary
        where employee_id=u_employee_id;
    else
        raise salary_out_of_range;
    end if;
    EXCEPTION 
        WHEN salary_out_of_range THEN
            dbms_output.put_line('salary is not between ' ||u_min_salary|| ' and ' || u_max_salary);
    commit;
END;
/


SET SERVEROUTPUT ON SIZE 1000000;
create or replace
procedure HELLO is
begin
    dbms_output.put_line('Hello World');
end;


exec HELLO();

call HELLO();

begin
hello();
end;

create or replace
procedure disp_ab(A int) is
begin
    dbms_output.put_line('square: ' || (A*A) );
end;

call disp_ab(5);

declare
n_number_input INTEGER:= &n;
begin
    disp_ab(n_number_input);
end;



create or replace
procedure disp_emp_details(eid int) is
    l_name employees.first_name%TYPE;
    l_sal employees.salary%TYPE;
begin
    select first_name, salary
    into l_name, l_sal
    from employees
    where employee_id=eid;
    
    dbms_output.put_line('Name: ' || l_name || '  Salary: ' || l_sal);
end;
/

call disp_emp_details(110);

--in, out, in out

create or replace
procedure sum_ab(a int, b int, c out int) is
begin
    c := a+b;
end;

declare 
r int;
begin
    sum_ab(10,20,r);
    dbms_output.put_line('sum is: ' || r);
end;


--given employee id return name
create or replace
procedure emp_det(eid int, fname out String, lname out String) is
begin
    select first_name, last_name
    into fname, lname
    from employees
    where employee_id=eid;
end;
/

declare 
emp_id integer := &id1;
f varchar2(20);
l varchar2(20);
begin
    emp_det(emp_id,f,l);
    dbms_output.put_line(f|| ' '|| l);
end;
/
-- drop a procedure
--drop procedure emp_det


--given employee name return salry
create or replace
procedure emp_sal(ename String, sal out int) is
begin
    select salary
    into sal
    from employees
    where first_name=ename;
end;
/

declare 
emp_name varchar(20) := '&en';
empsal integer;
begin
    emp_sal(emp_name,empsal);
    dbms_output.put_line(empsal);
end;
/

create or replace
function add_two(a int, b int) return int is
begin
    return (a+b);
end;
/

begin
    dbms_output.put_line('result: ' || add_two(10,20));
end;
/

--print sum of salary of all employees
create or replace
function sum_of_salary return int is
s integer;
begin
    select sum(salary) into s from employees;
    return s;
end;
/

begin
    dbms_output.put_line('result: ' || sum_of_salary);
end;
/


--increment salary of all employees given their id
create or replace
function salary_increment(id int) return int is
s integer;
begin
    update employees
    SET salary = salary * 1.1
    where employee_id=id;
    
    select salary into s
    from employees
    where employee_id=id;
    
    return s;
end;
/

begin
    dbms_output.put_line('inc salary: ' || salary_increment(100));
end;
/

update employees
    SET salary = 24000
    where employee_id=100;
    
create trigger NameChange
before update of first_name, last_name on emp_copy
for each row
begin
    dbms_output.put_line('name is being changed');
end;
/

--triggers example 
CREATE SEQUENCE audit_id_seq
                INCREMENT BY 1
                START WITH 1
                MAXVALUE 9999
                NOCACHE
                NOCYCLE;
                
CREATE TABLE audits (
      audit_id         NUMBER PRIMARY KEY,
      table_name       VARCHAR2(255),
      transaction_name VARCHAR2(10),
      by_user          VARCHAR2(30),
      transaction_date DATE
);

CREATE OR REPLACE TRIGGER customers_audit_trg
    AFTER 
    UPDATE OR DELETE 
    ON users
    FOR EACH ROW    
DECLARE
   l_transaction VARCHAR2(10);
BEGIN
   -- determine the transaction type
   l_transaction := CASE  
         WHEN UPDATING THEN 'UPDATE'
         WHEN DELETING THEN 'DELETE'
   END;
 
   -- insert a row into the audit table   
   INSERT INTO audits (audit_id,table_name, transaction_name, by_user, transaction_date)
   VALUES(audit_id_seq.nextval,'users', l_transaction, USER, SYSDATE);
END;
/

update users
set password='passwors123'
where id=101;

select * from audits;

CREATE OR REPLACE PACKAGE personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER)
    RETURN VARCHAR2;
  -- get employee's salary
  FUNCTION get_salary(n_emp_id NUMBER)
    RETURN NUMBER;
END personnel;
/
/*
  Package personnel body
*/
CREATE OR REPLACE PACKAGE personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER)
    RETURN VARCHAR2;
  -- get employee's salary
  FUNCTION get_salary(n_emp_id NUMBER)
    RETURN NUMBER;
END personnel;
/

CREATE OR REPLACE PACKAGE BODY personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER) RETURN VARCHAR2 IS
      v_fullname VARCHAR2(46);
  BEGIN
    SELECT first_name || ',' ||  last_name
    INTO v_fullname
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN v_fullname;
 
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  WHEN TOO_MANY_ROWS THEN
    RETURN NULL;
  END; -- end get_fullname
 
  -- get salary
  FUNCTION get_salary(n_emp_id NUMBER) RETURN NUMBER IS
    n_salary NUMBER(8,2);
  BEGIN
    SELECT salary
    INTO n_salary
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN n_salary;
 
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RETURN NULL;
      WHEN TOO_MANY_ROWS THEN
        RETURN NULL;
  END;
END personnel;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  n_salary NUMBER(8,2);
  v_name   VARCHAR2(46);
  n_emp_id NUMBER := &emp_id;
BEGIN
 
  v_name   := personnel.get_fullname(n_emp_id);
  n_salary := personnel.get_salary(n_emp_id);
 
  IF v_name  IS NOT NULL AND
    n_salary IS NOT NULL
  THEN
    dbms_output.put_line('Employee: ' || v_name);
    dbms_output.put_line('Salary:' || n_salary);
  END IF;
END;
/

select * from publisher;

select * from author;

select b.isnb, b.title, b.pages, a.name , p.name, p.city
from book b, author a, publisher p
where b.author_id=a.author_id and b.publisher_id=p.publisher_id;

select *
from book b, author a, publisher p
where b.author_id=a.author_id and b.publisher_id=p.publisher_id;

select a.name, b.title
from book b, author a
where b.author_id=a.author_id
order by a.name, b.title;

--given author return count of books
create or replace
procedure book_cnt(aname String, c out int) is
begin
    select count(*)
    into c
    from book b, author a
    where b.author_id=a.author_id and a.name=aname;
end;
/
select count(*)
    from book b, author a
    where b.author_id=a.author_id and a.name='Coleho';
