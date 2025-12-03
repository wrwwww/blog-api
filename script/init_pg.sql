-- 创建 schema
-- CREATE SCHEMA IF NOT EXISTS blog;

-- Table: articles
CREATE TABLE blog.articles
(
    id          uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    author_id   uuid         NOT NULL,
    title       varchar(255) NOT NULL,
    content     text,
    excerpt     text,
    cover_image varchar(255),
    status      varchar(50)      DEFAULT 'draft',
    views       integer          DEFAULT 0,
    created_at  timestamp        DEFAULT CURRENT_TIMESTAMP,
    updated_at  timestamp        DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE blog.articles IS '文章表';
COMMENT ON COLUMN blog.articles.id IS '文章ID';
COMMENT ON COLUMN blog.articles.author_id IS '作者ID，关联 users.id';
COMMENT ON COLUMN blog.articles.title IS '文章标题';
COMMENT ON COLUMN blog.articles.content IS '文章正文';
COMMENT ON COLUMN blog.articles.excerpt IS '文章摘要';
COMMENT ON COLUMN blog.articles.cover_image IS '封面图URL';
COMMENT ON COLUMN blog.articles.status IS '文章状态，参照码表';
COMMENT ON COLUMN blog.articles.views IS '阅读量';
COMMENT ON COLUMN blog.articles.created_at IS '创建时间';
COMMENT ON COLUMN blog.articles.updated_at IS '最后更新时间';

-- Table: categories
CREATE TABLE blog.categories
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name       varchar(50) NOT NULL,
    parent_id  uuid,
    created_at timestamp        DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT categories_parent_fk FOREIGN KEY (parent_id) REFERENCES blog.categories (id)
);

COMMENT ON TABLE blog.categories IS '分类表';
COMMENT ON COLUMN blog.categories.id IS '分类ID';
COMMENT ON COLUMN blog.categories.name IS '分类名称';
COMMENT ON COLUMN blog.categories.parent_id IS '父分类ID，自关联 categories.id';
COMMENT ON COLUMN blog.categories.created_at IS '创建时间';

-- Table: tags
CREATE TABLE blog.tags
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name varchar(50) NOT NULL
);

COMMENT ON TABLE blog.tags IS '标签表';
COMMENT ON COLUMN blog.tags.id IS '标签ID';
COMMENT ON COLUMN blog.tags.name IS '标签名称';

-- Table: article_tags
CREATE TABLE blog.article_tags
(
    article_id uuid NOT NULL,
    tag_id     uuid NOT NULL,
    PRIMARY KEY (article_id, tag_id),
    CONSTRAINT article_tags_article_fk FOREIGN KEY (article_id) REFERENCES blog.articles (id),
    CONSTRAINT article_tags_tag_fk FOREIGN KEY (tag_id) REFERENCES blog.tags (id)
);

COMMENT ON TABLE blog.article_tags IS '文章标签关联表';
COMMENT ON COLUMN blog.article_tags.article_id IS '文章ID，关联 articles.id';
COMMENT ON COLUMN blog.article_tags.tag_id IS '标签ID，关联 tags.id';

-- Table: user
CREATE TABLE blog."user"
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    username   varchar(10) UNIQUE,
    email      varchar(100) UNIQUE,
    nickname   varchar(50),
    password   varchar(255) NOT NULL,
    avatar     varchar(255),
    created_at timestamp        DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp        DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE blog."user" IS '用户表';
COMMENT ON COLUMN blog."user".id IS '主键';
COMMENT ON COLUMN blog."user".username IS '用户名';
COMMENT ON COLUMN blog."user".email IS '邮箱';
COMMENT ON COLUMN blog."user".nickname IS '昵称';
COMMENT ON COLUMN blog."user".password IS '密码哈希';
COMMENT ON COLUMN blog."user".avatar IS '头像链接';
COMMENT ON COLUMN blog."user".created_at IS '创建时间';
COMMENT ON COLUMN blog."user".updated_at IS '更新时间';

-- Table: role
CREATE TABLE blog.role
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    role_name  varchar(10) UNIQUE,
    created_at timestamp        DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp        DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE blog.role IS '角色表';
COMMENT ON COLUMN blog.role.id IS '主键';
COMMENT ON COLUMN blog.role.role_name IS '角色名';
COMMENT ON COLUMN blog.role.created_at IS '创建时间';
COMMENT ON COLUMN blog.role.updated_at IS '更新时间';

-- Table: menu
CREATE TABLE blog.menu
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    menu_name  varchar(10) UNIQUE,
    menu_type  integer NOT NULL,
    parent_id  bigint           DEFAULT 0,
    is_parent  integer NOT NULL,
    created_at timestamp        DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp        DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE blog.menu IS '权限表';
COMMENT ON COLUMN blog.menu.menu_name IS '权限名';
COMMENT ON COLUMN blog.menu.menu_type IS '权限类型';
COMMENT ON COLUMN blog.menu.parent_id IS '父节点id';
COMMENT ON COLUMN blog.menu.is_parent IS '是否有父节点';
COMMENT ON COLUMN blog.menu.created_at IS '创建时间';
COMMENT ON COLUMN blog.menu.updated_at IS '更新时间';

-- Table: role_menu
CREATE TABLE blog.role_menu
(
    id      uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    menu_id uuid NOT NULL,
    role_id uuid NOT NULL,
    CONSTRAINT role_menu_menu_fk FOREIGN KEY (menu_id) REFERENCES blog.menu (id),
    CONSTRAINT role_menu_role_fk FOREIGN KEY (role_id) REFERENCES blog.role (id)
);

COMMENT ON TABLE blog.role_menu IS '角色菜单表';
COMMENT ON COLUMN blog.role_menu.menu_id IS '菜单ID';
COMMENT ON COLUMN blog.role_menu.role_id IS '角色ID';

-- Table: logs
CREATE TABLE blog.logs
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id    uuid,
    action     varchar(255) NOT NULL,
    ip         varchar(50),
    created_at timestamp        DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT logs_user_fk FOREIGN KEY (user_id) REFERENCES blog."user" (id)
);

COMMENT ON TABLE blog.logs IS '系统日志表';
COMMENT ON COLUMN blog.logs.user_id IS '操作用户ID';
COMMENT ON COLUMN blog.logs.action IS '操作内容';
COMMENT ON COLUMN blog.logs.ip IS '操作IP';
COMMENT ON COLUMN blog.logs.created_at IS '操作时间';

-- Table: user_role
CREATE TABLE blog.user_role
(
    id      uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id uuid NOT NULL,
    role_id uuid NOT NULL,
    CONSTRAINT user_role_user_fk FOREIGN KEY (user_id) REFERENCES blog."user" (id),
    CONSTRAINT user_role_role_fk FOREIGN KEY (role_id) REFERENCES blog.role (id)
);

COMMENT ON TABLE blog.user_role IS '用户角色表';

-- Table: sys_code_type
CREATE TABLE blog.sys_code_type
(
    id          uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    code_type   varchar(50) UNIQUE NOT NULL,
    name        varchar(100)       NOT NULL,
    description varchar(255),
    created_at  timestamp        DEFAULT CURRENT_TIMESTAMP,
    updated_at  timestamp        DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE blog.sys_code_type IS '码表类型表';
COMMENT ON COLUMN blog.sys_code_type.code_type IS '码表类型唯一标识，如 role/status/category';
COMMENT ON COLUMN blog.sys_code_type.name IS '码表类型名称，如 用户角色/文章状态/分类类型';
COMMENT ON COLUMN blog.sys_code_type.description IS '说明';

-- Table: sys_code_value
CREATE TABLE blog.sys_code_value
(
    id          uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    code_type   varchar(50)  NOT NULL,
    code_value  varchar(50)  NOT NULL,
    code_label  varchar(100) NOT NULL,
    description varchar(255),
    sort_order  integer          DEFAULT 0,
    is_active   integer          DEFAULT 1,
    created_at  timestamp        DEFAULT CURRENT_TIMESTAMP,
    updated_at  timestamp        DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uq_type_value UNIQUE (code_type, code_value)
);

COMMENT ON TABLE blog.sys_code_value IS '码表值表';
COMMENT ON COLUMN blog.sys_code_value.code_type IS 'code_type';
COMMENT ON COLUMN blog.sys_code_value.code_value IS '实际存储值';
COMMENT ON COLUMN blog.sys_code_value.code_label IS '显示名称';
COMMENT ON COLUMN blog.sys_code_value.description IS '备注';
COMMENT ON COLUMN blog.sys_code_value.sort_order IS '排序';
COMMENT ON COLUMN blog.sys_code_value.is_active IS '是否启用，0=禁用,1=启用';

-- 初始数据插入
INSERT INTO blog.role (id, role_name, created_at, updated_at)
VALUES ('aec4879a-0970-4af6-b882-dbdae9efe9b9', '管理员', '2025-11-26 11:59:56', '2025-11-26 11:59:56');

INSERT INTO blog.sys_code_type (id, code_type, name, description, created_at, updated_at)
VALUES ('1e2e29d8-4d39-4348-a86b-eee9ae81d7ab', 'status', '有效标志', NULL, '2025-11-26 11:59:56',
        '2025-11-26 12:59:48');

INSERT INTO blog.sys_code_value (id, code_type, code_value, code_label, description, sort_order, is_active, created_at,
                                 updated_at)
VALUES ('007bff21-cac8-11f0-a0cf-f6018fe6fee3', 'status', 'Y', '启用', NULL, 0, 1, '2025-11-26 13:01:19',
        '2025-12-02 13:53:22'),
       ('007c0245-cac8-11f0-a0cf-f6018fe6fee3', 'status', 'N', '禁用', NULL, 0, 1, '2025-11-26 13:01:19',
        '2025-12-02 13:53:22');

INSERT INTO blog."user" (id, username, email, nickname, password, avatar, created_at, updated_at)
VALUES ('d333dcbe-588a-4b53-aa06-f4580eb7f477', 'admin', 'admin@admin.com', '管理员', '1234', '',
        '2025-11-26 11:59:56', '2025-11-26 11:59:56');

INSERT INTO blog.user_role (id, user_id, role_id)
VALUES ('0074b0c5-cac8-11f0-a0cff6018fe6fee3', 'd333dcbe-588a-4b53-aa06-f4580eb7f477', 'aec4879a-0970-4af6-b882-dbdae9efe9b9');
