DROP TABLE PAYMENT;
DROP TABLE TICKET_STATUS;
DROP TABLE TICKET_BOOKS;
DROP TABLE USERS;
DROP TABLE USER_ADDRESS;
DROP TABLE STATIONS;
DROP TABLE TRAINS;
DROP TABLE AMOUNTS;
DROP TABLE DUMMY;

CREATE TABLE USER_ADDRESS(Pin varchar(10),
City varchar2(15),
State varchar2(15),
CONSTRAINT pin_pk PRIMARY KEY (Pin));

CREATE TABLE USERS(User_ID varchar2(7),
F_Name varchar2(10),
L_Name varchar2(10),
Age Int,
Gender varchar2(6),
Pin varchar2(10),
Mobile_no varchar2(10),
login_attempts INT,
CONSTRAINT uid_pk PRIMARY KEY (User_ID),
CONSTRAINT age_chk CHECK (age > 18),
CONSTRAINT gender_chk CHECK (Gender IN ('F','M')),
CONSTRAINT ph_chk CHECK (LENGTH(Mobile_no) = 10),
CONSTRAINT pin_fk FOREIGN KEY (Pin) REFERENCES USER_ADDRESS(Pin));


CREATE TABLE TRAINS(
Tr_no varchar2(5),
Tr_Name varchar2(20),
Cap Int,
Source varchar2(10) NOT NULL,
Dest varchar2(10) NOT NULL,
S_Time varchar2(10),
Dest_Time varchar2(10),
CONSTRAINT Trno_pk PRIMARY KEY (Tr_no));

CREATE TABLE STATIONS (
Tr_no varchar2(5),
St_no varchar2(5),
St_name varchar2(15),
Arr_Time varchar2(10),
Dept_Time varchar2(10),
CONSTRAINT trno_fk FOREIGN KEY (Tr_no) REFERENCES TRAINS (Tr_no) ON DELETE CASCADE);

CREATE TABLE AMOUNTS(
U_Source varchar2(15),
U_Dest varchar2(15),
Ticket_Price INT
);

CREATE TABLE TICKET_BOOKS(
Ticket_PNR varchar2(10),
No_of_passengers Int,
User_ID varchar2(5) NOT NULL,
Tr_no varchar2(5) NOT NULL,
U_Source varchar2(15),
U_Dest varchar2(15),
Res_date DATE,
Book_date DATE,
CONSTRAINT pnr_pk PRIMARY KEY (Ticket_PNR ),
CONSTRAINT Tr_fk FOREIGN KEY (Tr_No) REFERENCES TRAINS (Tr_No) ON DELETE CASCADE,
CONSTRAINT uid_fk FOREIGN KEY (User_ID) REFERENCES USERS (User_ID) ON DELETE CASCADE);

CREATE TABLE TICKET_STATUS
(Ticket_PNR varchar2(10),
Tr_no varchar2(5),
Ti_status varchar2(15),
CONSTRAINT  pnr_fk FOREIGN KEY (Ticket_PNR) REFERENCES TICKET_BOOKS (Ticket_PNR) ON DELETE CASCADE,
CONSTRAINT  tr_no_fk FOREIGN KEY (Tr_no) REFERENCES TRAINS (Tr_no) ON DELETE CASCADE);

CREATE TABLE PAYMENT
(Payment_ID varchar2(5),
Ticket_PNR varchar2(10),
Amount Int,
CONSTRAINT tpnr_fk FOREIGN KEY (Ticket_PNR) REFERENCES TICKET_BOOKS (Ticket_PNR) ON DELETE CASCADE);

CREATE TABLE dummy
(User_ID varchar2(7),
Mobile_no varchar2(10)
);

DROP PROCEDURE modify_capacity;

CREATE OR REPLACE PROCEDURE modify_capacity(trno TRAINS.Tr_No%TYPE, temp INT) AS
  v_temp_cap INT;
BEGIN
  SELECT Cap INTO v_temp_cap
  FROM TRAINS
  WHERE Tr_No = trno;

  IF (v_temp_cap>=0 and v_temp_cap >=temp) THEN
    UPDATE TRAINS
    SET Cap = Cap-temp
    WHERE Tr_No = trno;
  END IF;

  COMMIT;
END;
/


DROP PROCEDURE modify_status;

CREATE OR REPLACE PROCEDURE modify_status(trno IN TRAINS.Tr_No%TYPE,temp2 INT, temp1 OUT VARCHAR2)
AS
BEGIN
  SELECT CASE
           WHEN (Cap <= 0 or temp2 > Cap) THEN 'Waiting List'
           ELSE 'Confirmed'
         END
  INTO temp1
  FROM TRAINS
  WHERE Tr_No = trno;
END;
/

DROP PROCEDURE modify_capacity1;

CREATE OR REPLACE PROCEDURE modify_capacity1(trno1 TRAINS.Tr_No%TYPE, temp INT, resdate TICKET_BOOKS.Res_Date%TYPE) AS
  v_exists INT;
  v_no_of_passengers INT;
  pnr Varchar2(10);
BEGIN
  SELECT COUNT(*)
  INTO v_exists
  FROM Ticket_Status TS
  JOIN Ticket_Books TB ON TS.Ticket_PNR = TB.Ticket_PNR
  WHERE TS.Ti_Status = 'Waiting List'
    AND TB.No_Of_passengers <= temp
    AND TB.Tr_No = trno1
    AND resdate = TB.Res_Date;

  IF v_exists > 0 THEN
    SELECT TS.Ticket_PNR, TB.No_Of_Passengers
    INTO pnr, v_no_of_passengers
    FROM Ticket_Status TS
    JOIN Ticket_Books TB ON TS.Ticket_PNR = TB.Ticket_PNR
    WHERE TS.Ti_Status = 'Waiting List'
      AND TB.No_Of_passengers <= temp
      AND TB.Tr_No = trno1
      AND resdate = TB.Res_Date;

    UPDATE Ticket_Status
    SET Ti_Status = 'Confirmed'
    WHERE Tr_No = trno1;

    UPDATE TRAINS
    SET Cap = Cap + temp - v_no_of_passengers
    WHERE Tr_No = trno1;

    COMMIT;
  ELSE
    UPDATE TRAINS
    SET Cap = Cap + temp
    WHERE Tr_No = trno1;

    COMMIT;
  END IF;
END;
/

DROP PROCEDURE CHECK_LOGIN_Procedure;


CREATE OR REPLACE TRIGGER check_failed_login
BEFORE INSERT OR UPDATE ON dummy
FOR EACH ROW
DECLARE
   p_user_id users.user_id%type;
   p_pass users.Mobile_No%type;
BEGIN
   SELECT user_id INTO p_user_id FROM users WHERE user_id = :new.user_id;
   
   IF p_user_id IS NOT NULL THEN
      SELECT Mobile_No INTO p_pass FROM users WHERE user_id = p_user_id;
   
      IF :NEW.Mobile_No <> p_pass THEN
         UPDATE users SET login_attempts = login_attempts + 1 WHERE user_id = p_user_id;
      END IF;
   END IF;
END;
/



CREATE OR REPLACE PROCEDURE check_login_procedure(
  p_user_id IN users.user_id%type,
  p_pass IN users.Mobile_No%type,
  p_flag OUT NUMBER
) AS
  p_count users.login_attempts%type;
  pass users.Mobile_No%type;
BEGIN
  INSERT INTO dummy VALUES (p_user_id, p_pass);
  SELECT login_attempts INTO p_count FROM users WHERE user_id = p_user_id;
  SELECT Mobile_No INTO pass FROM users WHERE user_id = p_user_id;
  
  IF pass = p_pass THEN
    p_flag := 2;
    UPDATE users SET login_attempts = 0 WHERE user_id = p_user_id;
    dbms_output.put_line('Correct login');
  ELSIF p_count >= 3 THEN
    dbms_output.put_line('Invalid login');
    p_flag := 1;
    UPDATE users SET login_attempts = 0 WHERE user_id = p_user_id;
  ELSE
    p_flag := 0;
  END IF;
END;
/


INSERT INTO USER_ADDRESS VALUES('638056', 'Erode', 'TamilNadu');
INSERT INTO USER_ADDRESS VALUES('668909', 'Chennai', 'TamilNadu');
INSERT INTO USER_ADDRESS VALUES('567889', 'Selam', 'TamilNadu');
INSERT INTO USER_ADDRESS VALUES('600127', 'Vijayawada', 'AndhraPraesh');
INSERT INTO USER_ADDRESS VALUES('632201', 'Vellore', 'TamilNadu');
INSERT INTO USER_ADDRESS VALUES('632789', 'Coimbatore', 'TamilNadu');
INSERT INTO USER_ADDRESS VALUES('520016', 'Thotapalli', 'AndhraPradesh');
INSERT INTO USER_ADDRESS VALUES('786787', 'Nellore', 'AndhraPradesh');

INSERT INTO USERS VALUES('Admin', 'Mega', 'V', 19, 'M', '638056', '9965091519',0);
INSERT INTO USERS VALUES('U1', 'Mega', 'V', 19, 'M', '638056', '9965091519',0);
INSERT INTO USERS VALUES('U2', 'Arun', 'S', 40, 'M', '668909', '8098051213',0);
INSERT INTO USERS VALUES('U3', 'Lisa', 'M', 20, 'F', '567889', '8098054224',0);
INSERT INTO USERS VALUES('U4', 'Teju', 'K', 19, 'F', '600127', '9391246778',0);
INSERT INTO USERS VALUES('U5', 'Jaanu', 'G', 19, 'F', '632201', '7358856160',0);
INSERT INTO USERS VALUES('U6', 'Vishwa', 'K', 19, 'M', '786787', '9488840747',0);
INSERT INTO USERS VALUES('U7', 'Charu', 'G', 19, 'F', '632201', '7358856160',0);
INSERT INTO USERS VALUES('U8', 'Akash', 'B', 21, 'M', '520016', '9173532349',0);


INSERT INTO TRAINS VALUES('T1', 'Chennai Exp', 1000, 'Coimbatore', 'Chennai', '05:00', '14:30');
INSERT INTO TRAINS VALUES('T2', 'Shirdi Exp', 3500, 'Mumbai', 'Shirdi', '18:10', '23:45');
INSERT INTO TRAINS VALUES('T3', 'Pinakini Exp', 1500, 'Chennai', 'Vijayawada', '14:00', '22:40');
INSERT INTO TRAINS VALUES('T4', 'Charminar Exp', 1200, 'Chennai', 'Hyderabad', '04:15', '22:00');
INSERT INTO TRAINS VALUES('T5', 'Pune Express', 3000, 'Bangalore', 'Pune', '02:00', '21:30');
INSERT INTO TRAINS VALUES('T6', 'Tirupati Exp', 1950, 'Chennai', 'Tirupati', '10:00', '14:00');
INSERT INTO TRAINS VALUES('T7', 'Howrah Mail', 3200, 'Mumbai', 'Kolkata', '08:40', '20:30');
INSERT INTO TRAINS VALUES('T8', 'Gokarna Exp', 2300, 'Bangalore', 'Gokarna', '09:00', '18:20');


INSERT INTO STATIONS VALUES('T1', 'S1', 'Coimbatore', '05:00', '05:15');
INSERT INTO STATIONS VALUES('T1', 'S2', 'Chennai', '14:30', '14:45');
INSERT INTO STATIONS VALUES('T2', 'S1', 'Coimbatore', '05:00', '05:15');
INSERT INTO STATIONS VALUES('T2', 'S2', 'Chennai', '14:30', '14:45');
INSERT INTO STATIONS VALUES('T2', 'S3', 'Mumbai', '18:10', '18:20');
INSERT INTO STATIONS VALUES('T2', 'S4', 'Shirdi', '23:45', '23:57');
INSERT INTO STATIONS VALUES('T3', 'S2', 'Chennai', '14:00', '14:10');
INSERT INTO STATIONS VALUES('T3', 'S5', 'Vijayawada', '22:40', '22:55');
INSERT INTO STATIONS VALUES('T4', 'S2', 'Chennai', '04:15', '04:25');
INSERT INTO STATIONS VALUES('T4', 'S6', 'Hyderabad', '22:00', '22:10');
INSERT INTO STATIONS VALUES('T5', 'S7', 'Bangalore', '02:00', '02:12');
INSERT INTO STATIONS VALUES('T5', 'S8', 'Pune', '21:30', '21:40');
INSERT INTO STATIONS VALUES('T6', 'S2', 'Chennai', '10:00', '10:10');
INSERT INTO STATIONS VALUES('T6', 'S9', 'Tirupati', '14:00', '14:15');
INSERT INTO STATIONS VALUES('T7', 'S3', 'Mumbai', '08:40', '08:55');
INSERT INTO STATIONS VALUES('T7', 'S10', 'Kolkata', '20:30', '20:45');
INSERT INTO STATIONS VALUES('T8', 'S7', 'Bangalore','09:00', '09:15');
INSERT INTO STATIONS VALUES('T8', 'S11', 'Gokarna', '18:20', '18:35');


INSERT INTO AMOUNTS VALUES('Coimbatore', 'Chennai', 520);
INSERT INTO AMOUNTS VALUES('Mumbai', 'Shirdi', 328);
INSERT INTO AMOUNTS VALUES('Chennai', 'Vijayawada', 430);
INSERT INTO AMOUNTS VALUES('Chennai', 'Hyderabad', 496);
INSERT INTO AMOUNTS VALUES('Bangalore', 'Pune', 870);
INSERT INTO AMOUNTS VALUES('Chennai', 'Tirupati', 245);
INSERT INTO AMOUNTS VALUES('Mumbai', 'Kolkata', 1520);
INSERT INTO AMOUNTS VALUES('Bangalore', 'Gokarna', 619);










