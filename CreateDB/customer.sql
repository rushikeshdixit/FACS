create table F16_12_customer (
        customerID number,
        firstName varchar2(20) not null,
        middleName varchar2(20),
        lastName varchar2(20) not null,
        dateofBirth date not null,
        phone# varchar2(10) not null,
        emailID varchar2(30),
        blockNo varchar2(10),
        street varchar2(50),
        apartment varchar2(20),
        state varchar2(20),
        zipCode numeric(5),
        constraint pk_customer primary key(customerID),
        constraint chk_customerPhone check(length(phone#) = 10)
);
