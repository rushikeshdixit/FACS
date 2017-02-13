create table F16_12_classSchedule (
        serviceID number,
        section varchar2(30),
        classDay varchar2(20),
        classTime varchar2(20),
        constraint chk_classDay check(classDay like 'Monday' or
                                      classDay like 'Tuesday' or
                                      classDay like 'Wednesday' or
                                      classDay like 'Thursday' or
                                      classDay like 'Friday' or
                                      classDay like 'Saturday' or
                                      classDay like 'Sunday'),
        constraint pk_classSchedule primary key(serviceID, section, classDay, classTime),
        constraint fk_classSchedule foreign key(serviceID) references F16_12_tutorClass(serviceID)
);
