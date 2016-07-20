DROP TABLE chat_friend;

CREATE TABLE chat_friend
(
  friend_flow VARCHAR(32) NOT NULL COMMENT '朋友流水号',
  origin_user_flow VARCHAR(32) NOT NULL COMMENT '本人用户流水号',
  target_user_flow VARCHAR(32) NOT NULL COMMENT '朋友用户流水号',
  PRIMARY KEY (friend_flow)
);