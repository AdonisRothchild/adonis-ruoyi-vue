/* 创建书籍类别的表*/
create table book_type
(
    type_id     varchar(50)  not null comment '书籍类别id',
    type_name   varchar(500) null comment '类别名称',
    create_time datetime     null comment '创建时间',
    update_time datetime     null comment '更新时间',
    is_up       int          null comment '是否上架 1:代表上架 0:代表下架',
    sort        int          null comment '排序字段',
    constraint book_type_type_id_uindex
        unique (type_id)
)
    comment '书籍类别表';

alter table book_type
    add primary key (type_id);

/* 创建书籍主体 的表 内容打算压缩后放入表中*/
create table book_content
(
    book_id     varchar (50) not null comment '书籍id',
    type_id     varchar(50)  not null comment '书籍类别id',
    book_name   varchar(500) null comment '书籍名称',
    create_time datetime     null comment '创建时间',
    update_time datetime     null comment '更新时间',
    is_up       int          null comment '是否上架 1:代表上架 0:代表下架',
    version       int          null comment '书籍版本',
    sort        int          null comment '排序字段',
    constraint book_content_book_id_uindex
        unique (book_id)
)
    comment '书籍表';

alter table book_content
    add primary key (book_id);

