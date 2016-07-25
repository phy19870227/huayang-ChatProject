DROP TABLE chat_user;

CREATE TABLE chat_user
(
  user_flow    VARCHAR(32) NOT NULL COMMENT '用户流水号',
  user_code    VARCHAR(20) NOT NULL COMMENT '用户账号',
  user_pwd     VARCHAR(20) NOT NULL COMMENT '账户密码',
  user_name    VARCHAR(50) NOT NULL COMMENT '用户昵称',
  user_email   VARCHAR(50) NOT NULL COMMENT '用户邮箱',
  reg_datetime VARCHAR(14) NOT NULL COMMENT '注册时间',
  PRIMARY KEY (user_flow)
);