


-- 根据DeptId查部门信息

select dept_no, dept_name, dept_man_emp_id ,(select emp_name from t_emp where dept_man_emp_id = emp_no ) as dept_man_emp_name, dept_create_time from t_dept where  dept_no = 'A1';


-- 根据所有DeptId部门信息
select dept_no, dept_name, dept_man_emp_id ,(select emp_name from t_emp where dept_man_emp_id = emp_no ) as dept_man_emp_name,dept_emp_cnt , dept_create_time from t_dept;
 
 查询所有员工信息
 select *, (select dept_name  from t_dept where emp_dept_no = dept_no ) as emp_dept_name from t_emp;
 
修改员工信息
update t_emp set emp_name = ?, emp_role_id = ?,  emp_dept_no = ?, emp_sex = ?, emp_edu = ?, emp_email = ?, emp_phone = ? ,emp_entry_time = ? where emp_no = ?  
 
insert into t_user (account,passwd, name, role_id, status, create_time) values ('te1','te1','nnnn',0,-1,now());

