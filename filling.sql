
# Project inserts;
INSERT INTO project(id,project_name,picture,current_investment,nesessary_investment
  ,description,rating,category,author,valuation)
VALUES (1,'Production of IoT devices',LOAD_FILE('C:\Users\Mala\Desktop\FP1.jpg'),0,25000
  ,'The launch on the Internet of things for the home of an intellectual and highly efficient ecosystem of products,
   with unique characteristics, wide functionality and cutting-edge design.',9.4
  ,'Appliances, Internet and IT, Electronics','unknown',8);


INSERT INTO project(id,project_name,picture,current_investment,nesessary_investment
  ,description,rating,category,author,valuation)
VALUES (2,'Bofon',LOAD_FILE('D:\FP\FP2.PNG'),0,10000
,'Active multi-portal portal b2b, travel agency, video advertising production, information and entertainment portal'
,9.5,'Internet and IT, Information and media, Tourism, sport','Ilchenko Ivan',7 );


INSERT INTO project(id,project_name,picture,current_investment,nesessary_investment
  ,description,rating,category,author,valuation)
VALUES(3,'Electronic discount cards',LOAD_FILE('C:\Users\Mala\Desktop\FP3.PNG'),0,300000
  ,'Cloud service for business, which allows you to issue electronic discount cards and build effective channels
  of communication with customers and customers.In the personal electronic business card are stored:
   electronic discount cards, coupons, certificates, coffee cards, business cards - issued to the owner of the cardholder.'
,10,' Internet and IT, Entertainment, Trade, Services','unknown',10);

INSERT INTO project(id,project_name,picture,current_investment,nesessary_investment
  ,description,rating,category,author,valuation)
VALUES(4,'Smart service for managing calls and notifications',LOAD_FILE('C:\Users\Mala\Desktop\FP4.PNG'),0,60000
  ,'This is a smart application that manages calls and notifications on the smartphone depending on many factors'
,9.5,'Internet and IT','Alexey Zakharevich',9);

INSERT INTO project(id,project_name,picture,current_investment,nesessary_investment
  ,description,rating,category,author,valuation)
VALUES(5,'Raccoon.World',LOAD_FILE('C:\Users\Mala\Desktop\FP5.PNG'),30000,50000
  ,'We produce gadgets for hands that allow you to interact with digital reality, incl. With a virtual
  , on a new level, providing the user with additional freedom and solving actual problems of interaction
  with classical controllers.',9,'Computers, office equipment, Culture, art, Entertainment, Electronics'
,'Alexander Soroka',10);

INSERT INTO project(id,project_name,picture,current_investment,nesessary_investment
  ,description,rating,category,author,valuation)
VALUES(6,'Cordless phone charging',LOAD_FILE('C:\Users\Mala\Desktop\FP6.PNG'),34000,34000
,'Our team, worked to create a docking station with stable levitation and wireless charging for the phone.
 The essence of the idea is that you just bring the phone, it takes off and is charged in the air without wires.'
,9.8,'Gadgets ','unknown',8);

INSERT INTO project(id,project_name,picture,current_investment,nesessary_investment
  ,description,rating,category,author,valuation)
VALUES(7,'Cardiomo',LOAD_FILE('C:\Users\Mala\Desktop\FP7.PNG'),0,450000
,'Cardiomo is a miniature wearable device for monitoring vital human body parameters. In real time,
 the device informs the user, his relatives and the doctor about the current state of health and warns
  about possible violations in the body.',8.2,'Medicine, Services, Electronics','unknown',7);

INSERT INTO project(id,project_name,picture,current_investment,nesessary_investment
  ,description,rating,category,author,valuation)
VALUES(8,'Video screen pedestrian',LOAD_FILE('C:\Users\Mala\Desktop\FP8.PNG'),0,250000
,'The information video screen is pedestrian, it is a multifunctional design with the help of which the safety
 of pedestrian traffic is increased directly and in general raises the security to a higher level.',8.5
  ,'Production, Services, Electronics, Another','unknown',9);


#User inserts(investors)
INSERT INTO user(id,first_name,last_name,role,phone_number,`e-mail`,country,city)
    VALUES (1,'Ivan','Gulin','investor',0639958642,'iGulin@gmail.com','Ukraine','Kiev');

INSERT INTO user(id,first_name,last_name,role,phone_number,`e-mail`,country,city)
    VALUES (2,'Danil','Dubinin','investor',0667785412,'dubinin@gmail.com','Belarus','Minsk');

INSERT INTO user(id,first_name,last_name,role,phone_number,`e-mail`,country,city)
    VALUES (3,'Emilia','Grinvald','investor',0991177320,'emilgronvald@gmail.com','Russia','Moscow');

#User inserts(founders)
INSERT INTO user(id,first_name,last_name,role,phone_number,`e-mail`,country,city)
    VALUES (4,'Vladislav','Kuleshov','founder',098209684,'kuleshov@mail.ru','Ukraine','Dnepr');

INSERT INTO user(id,first_name,last_name,role,phone_number,`e-mail`,country,city)
    VALUES (5,'Urii','Ruban','founder',0682356891,'uriiruban@ukr.net','Russia','Vladivistok');

INSERT INTO user(id,first_name,last_name,role,phone_number,`e-mail`,country,city)
    VALUES (6,'Sergii','Pelikhov','founder',0855552358,'pelyas@gmail.com','Ukraine','Kiev');

INSERT INTO user(id,first_name,last_name,role,phone_number,`e-mail`,country,city)
    VALUES (7,'Evhenii','Moisiienko','founder',0758456655,'moisiienko@mail.ru','Belarus','Minsk');

#User inserts(administrator)

INSERT INTO user(id,first_name,last_name,role,phone_number,`e-mail`,country,city)
    VALUES (8,'Anastasiya','Kravchenko','administrator',0982098784,'anastasiyakravchenko1@gmail.com','Ukraine','Kiev');


# Role
INSERT INTO role(id_role,name)
    VALUES(1,'investor');
INSERT INTO role(id_role,name)
    VALUES(2,'founder');
INSERT INTO role(id_role,name)
    VALUES(3,'anonym_user');
INSERT INTO role (id_role, name)
    VALUES(4,'administrator');


# Rights
INSERT INTO `right`(id_right,right_name)
    VALUES(1,'ability_to_create_project');
INSERT INTO `right`(id_right,right_name)
    VALUES(2,'ability_to_invest');
INSERT INTO `right`(id_right,right_name)
    VALUES(3,'ability_to_view_project');
INSERT INTO `right`(id_right,right_name)
    VALUES(4,'ability_to_sign_up');

# role-right
INSERT INTO role_right(id_role, id_right)
    VALUES(1,2);
INSERT INTO role_right(id_role, id_right)
    VALUES(1,3);
INSERT INTO role_right(id_role, id_right)
    VALUES(1,4);
INSERT INTO role_right(id_role, id_right)
    VALUES(2,3);
INSERT INTO role_right(id_role, id_right)
    VALUES(2,4);
INSERT INTO role_right(id_role, id_right)
    VALUES(3,3);
INSERT INTO role_right(id_role, id_right)
    VALUES(3,4);
INSERT INTO role_right(id_role, id_right)
    VALUES(4,1);
INSERT INTO role_right(id_role, id_right)
    VALUES(4,3);
INSERT INTO role_right(id_role, id_right)
    VALUES(4,4);


# user-role
INSERT INTO user_role(user_id, role_id)
    VALUES(1,1);
INSERT INTO user_role(user_id, role_id)
    VALUES(2,1);
INSERT INTO user_role(user_id, role_id)
    VALUES(3,1);
INSERT INTO user_role(user_id, role_id)
    VALUES(4,2);
INSERT INTO user_role(user_id, role_id)
    VALUES(5,2);
INSERT INTO user_role(user_id, role_id)
    VALUES(6,2);
INSERT INTO user_role(user_id, role_id)
    VALUES(7,2);
INSERT INTO user_role(user_id, role_id)
    VALUES(8,4);


# user-project
INSERT INTO user_project(id_user, id_project)
    VALUES(1,1);
INSERT INTO user_project(id_user, id_project)
    VALUES(1,2);
INSERT INTO user_project(id_user, id_project)
    VALUES(1,3);
INSERT INTO user_project(id_user, id_project)
    VALUES(2,2);
INSERT INTO user_project(id_user, id_project)
    VALUES(2,3);
INSERT INTO user_project(id_user, id_project)
    VALUES(3,5);
INSERT INTO user_project(id_user, id_project)
    VALUES(3,8);
INSERT INTO user_project(id_user, id_project)
    VALUES(3,6);
INSERT INTO user_project(id_user, id_project)
    VALUES(8,7);
INSERT INTO user_project(id_user, id_project)
    VALUES(8,8);




