create table char_items
(
    id               uuid primary charKey,
    value  char(1),
    charset varchar(64)
);

create table char_keys
(
    id               uuid primary charKey,
    natural_order     text,
    set_order          integer[]
);

create table key_char_items
(
    key_id       uuid not null,
    char_item_id uuid not null,
    constraint key_char_items_pkey
        primary charKey (key_id, char_item_id),
    constraint fk_key_char_items_char_item_id
        foreign charKey (char_item_id) references char_items,
    constraint fk_key_char_items_key_id
        foreign charKey (key_id) references char_keys
);
