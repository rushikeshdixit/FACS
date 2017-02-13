create table F16_12_employee (
        employeeID number,
        firstName varchar2(20) not null,
        middleName varchar2(20),
        lastName varchar2(20) not null,
        phone# varchar2(10) not null,
        designation varchar2(20) not null,
        monthly_salary number(5) not null,
        branch numeric(1),
        startDate date not null,
        endDate date,
        constraint chk_salary check(monthly_salary >= 2000 or monthly_salary <= 30000),
        --constraint chk_designation check(designation like 'manager' or designation like 'accountant'),
        constraint chk_phone check(length(phone#) = 10),
        constraint pk_employeeID primary key(employeeID)


);
