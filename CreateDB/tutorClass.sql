create table F16_12_tutorClass (
        serviceID number,
        classType varchar2(50) not null,
        constraint chk_classType check(classType like 'GRE' or classType like 'TOEFL' or classType like 'IELTS'),
        constraint pk_tutorClass primary key(serviceID),
        constraint fk_tutorClass foreign key(serviceID) references F16_12_service(serviceID)
);
