create table F16_12_branch (
        branchID number(1),
        branchLocation varchar2(40),
        managerID number,
        constraint pk_branchID primary key(branchID),
        constraint chk_branchID check (branchID = 1 or branchID = 2)
);
