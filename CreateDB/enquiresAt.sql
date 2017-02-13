create table F16_12_enquiresAt (
        enquirerID number,
        branchID number,
        dateofEnquiry date,
        constraint pk_enquiresAt primary key(enquirerID, branchID),
        constraint fk_enquiresAt foreign key(enquirerID) references F16_12_enquirer(enquirerID),
        constraint fk_enquiresAtBranch foreign key(branchID) references F16_12_branch(branchID)
);
