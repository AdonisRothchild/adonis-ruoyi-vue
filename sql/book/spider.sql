create table spider_task
(
    task_id     varchar (50) not null comment '爬虫任务id',
    type     varchar(50)  not null comment '爬虫种类',
    spider_url   varchar(500) null comment '爬虫目标地址',
    create_time datetime     null comment '创建时间',
    update_time datetime     null comment '更新时间',
    is_over       int          null comment '是否结束 1:代表执行结束 0:代表未开始 -1:代表执行失败',
    constraint spider_task_task_id_uindex
        unique (task_id)
)
    comment '书籍表';

alter table spider_task
    add primary key (task_id);

create table spider_log
(
    log_id     varchar (50) not null comment '爬虫日志id',
    task_id  varchar(50)  not null comment '爬虫任务id',
    req_param  varchar(2000)   comment '请求参数',
    res_content varchar(2000)  comment '返回值',
    create_time datetime     null comment '创建时间',
    update_time datetime     null comment '更新时间',
    is_success       int          null comment '是否执行成功',
    constraint spider_log_log_id_uindex
        unique (log_id)
)
    comment '书籍表';

alter table spider_log
    add primary key (log_id);