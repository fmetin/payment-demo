-- auto-generated definition
create table payment_transaction
(
    transaction_id varchar(36) not null
        constraint payment_transaction_pk
            primary key,
    name           varchar,
    surname        varchar,
    amount         numeric(18, 2),
    user_id        varchar(36) not null,
    status         varchar
);
