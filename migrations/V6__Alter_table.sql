alter table car
    alter column car_name set NOT NULL,
    alter column price set not null;

alter table owner alter column owner_name set not null;

alter table car_saloon alter column saloon_name set not null;

alter table producer
    alter column producer_name set not null,
    alter column car_price_prod set not null;
