# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table application (
  id                        bigint not null,
  identifier                varchar(255),
  name                      varchar(255),
  version                   varchar(255),
  icon_file                 varchar(255),
  constraint pk_application primary key (id))
;

create table module (
  id                        bigint not null,
  identifier                varchar(255),
  name                      varchar(255),
  version                   varchar(255),
  constraint pk_module primary key (id))
;


create table application_module (
  application_id                 bigint not null,
  module_id                      bigint not null,
  constraint pk_application_module primary key (application_id, module_id))
;

create table module_application (
  module_id                      bigint not null,
  application_id                 bigint not null,
  constraint pk_module_application primary key (module_id, application_id))
;
create sequence application_seq;

create sequence module_seq;




alter table application_module add constraint fk_application_module_applica_01 foreign key (application_id) references application (id) on delete restrict on update restrict;

alter table application_module add constraint fk_application_module_module_02 foreign key (module_id) references module (id) on delete restrict on update restrict;

alter table module_application add constraint fk_module_application_module_01 foreign key (module_id) references module (id) on delete restrict on update restrict;

alter table module_application add constraint fk_module_application_applica_02 foreign key (application_id) references application (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists application;

drop table if exists application_module;

drop table if exists module;

drop table if exists module_application;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists application_seq;

drop sequence if exists module_seq;

