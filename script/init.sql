-- 创建数据库
CREATE DATABASE blog DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 创建用户
CREATE USER 'blog'@'%' IDENTIFIED BY '1006';

-- 授权所有权限
GRANT ALL PRIVILEGES ON blog.* TO 'blog'@'%';

-- 刷新权限
FLUSH PRIVILEGES;


-- 用户表
create table if not exists user
(
    id         CHAR(36) primary key default (uuid()) comment '主键',
    username   varchar(10) unique comment '用户名',
    email      VARCHAR(100) UNIQUE comment '邮箱',
    nickname   VARCHAR(50)          DEFAULT NULL comment '昵称',
    password   VARCHAR(255) not null comment '密码哈希',
    avatar     VARCHAR(255) comment '头像链接',
    created_at DATETIME             DEFAULT current_timestamp comment '创建时间',
    updated_at DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
) comment '用户表';
insert into user(id, username, email, nickname, password,
                 avatar)
VALUES ('0', 'admin', 'admin@admin.com', '管理员', '1234', '');
-- 角色表
create table if not exists role
(
    id         CHAR(36) primary key default (uuid()) comment '主键',
    role_name  varchar(10) unique comment '角色名',
    created_at DATETIME             DEFAULT current_timestamp comment '创建时间',
    updated_at DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
) comment '角色表';
insert into role(id, role_name)
values ('0', '管理员');
create table user_role
(
    id      CHAR(36) PRIMARY KEY default (uuid()),
    user_id CHAR(36) not null,
    role_id CHAR(36) not null,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
) comment '用户角色表';
insert into user_role(user_id, role_id)
VALUES ('0', '0');
-- 权限表
create table if not exists menu
(
    id         CHAR(36) primary key default (uuid()) comment '主键',
    menu_name  varchar(10) unique comment '权限名',
    menu_type  int not null comment '权限类型',
    parent_id  bigint               default 0 comment '父节点id',
    is_parent  int not null comment '是否有父节点',
    created_at DATETIME             DEFAULT current_timestamp comment '创建时间',
    updated_at DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
) comment '角色表';
create table role_menu
(
    id      CHAR(36) PRIMARY KEY default (uuid()),
    menu_id CHAR(36) not null,
    role_id CHAR(36) not null,
    FOREIGN KEY (menu_id) REFERENCES menu (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
) comment '角色菜单表';
-- 码表
CREATE TABLE sys_code_type
(
    id          CHAR(36) PRIMARY KEY default (uuid()),
    code_type   VARCHAR(50)  NOT NULL UNIQUE COMMENT '码表类型唯一标识，如 role/status/category',
    name        VARCHAR(100) NOT NULL COMMENT '码表类型名称，如 用户角色/文章状态/分类类型',
    description VARCHAR(255)         DEFAULT NULL COMMENT '说明',
    created_at  DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT ='码表类型表';



CREATE TABLE sys_code_value
(
    id          CHAR(36) PRIMARY KEY default (uuid()),
    type_id     CHAR(36)     NOT NULL COMMENT '码表类型ID，外键引用 sys_code_type.id',
    code_value  VARCHAR(50)  NOT NULL COMMENT '实际存储值，如 admin/draft/published',
    code_label  VARCHAR(100) NOT NULL COMMENT '显示名称，如 管理员/草稿/已发布',
    description VARCHAR(255)         DEFAULT NULL COMMENT '备注',
    sort_order  INT                  DEFAULT 0 COMMENT '排序，用于前端显示顺序',
    is_active   TINYINT(1)           DEFAULT 1 COMMENT '是否启用，0=禁用,1=启用',
    created_at  DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uq_type_value (type_id, code_value),
    FOREIGN KEY (type_id) REFERENCES sys_code_type (id)
) COMMENT ='码表值表';

insert into sys_code_type(id, code_type, name)
VALUES ('0', 'status', '有效标志'),
       ('', '', '');
insert into sys_code_value(type_id, code_value, code_label, is_active)
VALUES ('0', 'Y', '启用', 1),
       ('0', 'N', '禁用', 1);

CREATE TABLE articles
(
    id          CHAR(36) PRIMARY KEY DEFAULT (UUID()) COMMENT '文章ID',
    author_id   CHAR(36)     NOT NULL COMMENT '作者ID，关联 users.id',
    title       VARCHAR(255) NOT NULL COMMENT '文章标题',
    content     TEXT COMMENT '文章正文',
    excerpt     TEXT COMMENT '文章摘要',
    cover_image VARCHAR(255)         DEFAULT NULL COMMENT '封面图URL',
    status      VARCHAR(50)          DEFAULT 'draft' COMMENT '文章状态，参照码表',
    views       INT                  DEFAULT 0 COMMENT '阅读量',
    created_at  DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at  DATETIME             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间'
) COMMENT ='文章表';
CREATE TABLE categories
(
    id         CHAR(36) PRIMARY KEY DEFAULT (UUID()) COMMENT '分类ID',
    name       VARCHAR(50) NOT NULL COMMENT '分类名称',
    parent_id  CHAR(36)             DEFAULT NULL COMMENT '父分类ID，自关联 categories.id',
    created_at DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    FOREIGN KEY (parent_id) REFERENCES categories (id)
) COMMENT ='分类表';

CREATE TABLE tags
(
    id   CHAR(36) PRIMARY KEY DEFAULT (UUID()) COMMENT '标签ID',
    name VARCHAR(50) NOT NULL COMMENT '标签名称'
) COMMENT ='标签表';

CREATE TABLE article_tags
(
    article_id CHAR(36) NOT NULL COMMENT '文章ID，关联 articles.id',
    tag_id     CHAR(36) NOT NULL COMMENT '标签ID，关联 tags.id',
    PRIMARY KEY (article_id, tag_id),
    FOREIGN KEY (article_id) REFERENCES articles (id),
    FOREIGN KEY (tag_id) REFERENCES tags (id)
) COMMENT ='文章标签关联表';
CREATE TABLE logs
(
    id         CHAR(36) PRIMARY KEY DEFAULT (UUID()) COMMENT '日志ID',
    user_id    CHAR(36)             DEFAULT NULL COMMENT '操作用户ID，关联 users.id',
    action     VARCHAR(255) NOT NULL COMMENT '操作内容',
    ip         VARCHAR(50)          DEFAULT NULL COMMENT '操作IP',
    created_at DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间'
) COMMENT ='系统日志表';
