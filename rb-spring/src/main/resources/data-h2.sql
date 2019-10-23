INSERT INTO users(seq,name,email,passwd) VALUES (null,'tester00','test00@gmail.com','$2a$10$mzF7/rMylsnxxwNcTsJTEOFhh1iaHv3xVox.vpf6JQybEhE4jDZI.');
INSERT INTO users(seq,name,email,passwd) VALUES (null,'tester01','test01@gmail.com','$2a$10$Mu/akK4gI.2RHm7BQo/kAO1cng2TUgxpoP.zBbPOeccVGP4lKVGYy');
INSERT INTO users(seq,name,email,passwd) VALUES (null,'tester02','test02@gmail.com','$2a$10$hO38hmoHN1k7Zm3vm95C2eZEtSOaiI/6xZrRAx8l0e78i9.NK8bHG');

INSERT INTO posts(seq,user_seq,contents,like_count,comment_count,create_at,word_cloude) VALUES (null,1,'test01 first post',1,1,'2019-03-01 13:10:00',"");
INSERT INTO posts(seq,user_seq,contents,like_count,comment_count,create_at,word_cloude) VALUES (null,1,'test01 second post',0,0,'2019-03-12 09:45:00',"");
INSERT INTO posts(seq,user_seq,contents,like_count,comment_count,create_at,word_cloude) VALUES (null,1,'test01 third post',0,0,'2019-03-20 19:05:00',"");
INSERT INTO posts(seq,user_seq,contents,like_count,comment_count,create_at,word_cloude) VALUES (null,2,'test02 post',0,1,'2019-03-20 15:13:20',"");

INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,1,1,'first comment','2019-03-01 13:15:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,2,4,'first comment','2019-03-01 13:15:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,1,1,'first comment','2019-03-01 13:15:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,2,4,'first comment','2019-03-01 13:15:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,1,1,'감동 그 자체','2019-03-01 13:15:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,2,4,'진짜 재밌어요ㅠㅠ 추천','2019-03-01 13:15:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,1,1,'여자친구가 밤마다 이거 읽느라 카톡도 대충 하길래 몰래 사서 읽었다가 눈물 쏟아서 베개 다 젖었다... 생선가게 뮤지션 너무 공감되고 슬프잖아!!','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,2,1,'지금껏 읽은 책 중 가장 빠르게 읽은 책. 나미야 잡화점의 하룻밤의 기적이 저한테도 일어난 것 같네요','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,1,1,'전자책으로 먼저 읽었는데 종이책으로도 꼭 소장하고싶은 책이네요....진짜 진한 여운 잘 읽었습니다 추천추천 ㅠㅠ','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,2,1,'넘잼있게잘읽었습니다','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,1,1,'밤새워서 읽었어요.. 손에서 놓을수 없었던 감동이 있었던 책...몇년이 지난후에도 책꽂이 한켠에 소장하고 싶은 책 이었어요','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,2,1,'감동적이고 재미있게 읽었어요. 손에서 놓기가 싫었어요.','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,1,1,'군대에서 다 읽음','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,2,1,'몇시간안에 다 읽었네요. 늘 읽던 작가느낌과 다르게 훈훈함이 느껴집니다','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,1,1,'따뜻한방에 누워 집중해서 술술 다읽었네요 너무재밌고 흥미롭게 읽었습니다 ','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,2,1,'아직 안보신 분들께 진심 추천드립니다 ','2019-10-22 16:47:00');
INSERT INTO comments(seq,user_seq,post_seq,contents,create_at) VALUES (null,1,1,'담은 내용이 따듯하고 재미있습니다. 오고가는 고민과 조언에 담긴 삶의 일면들은 저에게 많은 생각을 하게 하고 위로를 주네요. 마지막의 마지막까지 선의를 담은 기분좋은 소설. ','2019-10-22 16:47:00');

INSERT INTO connections(seq,user_seq,target_seq,granted_at,create_at) VALUES (null,1,2,'2019-03-31 13:00:00','2019-03-31 00:10:00');

INSERT INTO likes(seq,user_seq,post_seq,create_at) VALUES (null,1,1,'2019-03-01 15:10:00');