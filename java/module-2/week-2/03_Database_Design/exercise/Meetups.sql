BEGIN TRANSACTION;
DROP TABLE IF EXISTS member,interest_group, event,track_people,track_interest_group CASCADE;


CREATE TABLE member(
	member_id serial NOT NULL,
	last_name varchar(100) NOT NULL,
	first_name varchar(100) NOT NULL,
	email_address varchar(100) NOT NULL,
	phone_number int NOT NULL,
	birthday date NOT NULL,
	flag boolean NULL,
	CONSTRAINT PK_member PRIMARY KEY (member_id)
);


Create TABLE interest_group(
	interest_group_id serial NOT NULL,
	group_name varchar(100) NOT NULL,
	--member_id int NOT NULL  ,
	CONSTRAINT PK_interest_group PRIMARY KEY (interest_group_id)
	--CONSTRAINT FK_interest_group FOREIGN KEY (member_id)REFERENCES member (member_id)
);

Create TABLE event(
	interest_group_id int NOT NULL,
	event_id serial NOT NULL,
	event_name varchar(100) NOT NULL,
	description varchar(500) NOT NULL,
	date_time timestamp  NOT NULL,
	length_minutes int NOT NULL,
	CONSTRAINT PK_event PRIMARY KEY (event_id),
	CONSTRAINT FK_interest_group FOREIGN KEY (interest_group_id) REFERENCES interest_group (interest_group_id)
);
CREATE TABLE track_people(
	people_id int NOT NULL,
	event_id int NOT NULL,
	CONSTRAINT PK_track_people PRIMARY KEY(people_id, event_id),
	CONSTRAINT FK_track_people_people FOREIGN KEY(people_id) REFERENCES member (member_id),
	CONSTRAINT FK_track_people_event FOREIGN KEY(event_id) REFERENCES event (event_id)
);
CREATE TABLE track_interest_group(
	member_id int NOT NULL,
	interest_group_id int NOT NULL,
	CONSTRAINT PK_track_interest_group PRIMARY KEY(member_id, interest_group_id),
	CONSTRAINT FK_track_interest_group_member FOREIGN KEY(member_id) REFERENCES member(member_id),
	CONSTRAINT FK_track_interest_group FOREIGN KEY(interest_group_id) REFERENCES interest_group (interest_group_id)
);


INSERT INTO  member
(last_name, first_name,email_address,phone_number,birthday, flag)
VALUES
('Johnson','John','johnson@gmail.com', 6143896, '1950-03-01',true),
('Johnson2','John','johnson@gmail.com', 6143796, '1950-10-01',true),
('Johnson3','John','johnson@gmail.com', 6764796, '1950-11-01',true),
('Johnson5','John','johnson@gmail.com', 61498796, '1950-03-01',true),
('Johnson8','John','johnson@gmail.com', 6164396, '1950-07-01',true),
('Johnson4','John','johnson@gmail.com', 6144566, '1950-09-01',true),
('Johnson9','John','johnson@gmail.com', 6140796, '1950-12-01',true),
('Johnson1','John','johnson@gmail.com', 6143896, '1950-06-01',true);

INSERT INTO  interest_group
(group_name)
VALUES
('group1'),
('group2'),
('group3');

INSERT INTO  event
(interest_group_id, event_name, description, date_time, length_minutes)
VALUES
((SELECT interest_group_id FROM interest_group WHERE group_name = 'group1'),'event1','music1','2022-04-30 06:30:23', 210),
((SELECT interest_group_id FROM interest_group WHERE group_name = 'group2'),'event2','music2','2021-04-20 05:30:26', 210),
((SELECT interest_group_id FROM interest_group WHERE group_name = 'group3'),'event3','music3','2020-04-10 04:30:24', 210),
((SELECT interest_group_id FROM interest_group WHERE group_name = 'group1'),'event4','music4','2021-04-29 03:30:23', 210);


INSERT INTO track_interest_group
(interest_group_id, member_id)
VALUES
((SELECT interest_group_id from interest_group WHERE group_name = 'group1'),(SELECT member_id from member WHERE last_name = 'Johnson2')),
((SELECT interest_group_id from interest_group WHERE group_name = 'group2'),(SELECT member_id from member WHERE last_name = 'Johnson3'));

INSERT INTO track_people
(people_id , event_id)
VALUES
((SELECT member_id FROM member WHERE last_name = 'Johnson'), (SELECT event_id FROM event WHERE event_name = 'event1')),
((SELECT member_id FROM member WHERE last_name = 'Johnson2'), (SELECT event_id FROM event WHERE event_name = 'event2'));


COMMIT;

