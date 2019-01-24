/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  david
 * Created: Jan 23, 2019
 */



INSERT INTO tbl_charges(min_amount, max_amount, withdraw_charge, send_to_unregistered, send_to_registered)
VALUES (0, 1000, 0, 0, 0);

INSERT INTO tbl_charges(min_amount, max_amount, withdraw_charge, send_to_unregistered, send_to_registered)
VALUES (1001, 10000, 112, 205, 87);

INSERT INTO tbl_charges(min_amount, max_amount, withdraw_charge, send_to_unregistered, send_to_registered)
VALUES (10001, 30000, 180, 288, 102);

INSERT INTO tbl_charges(min_amount, max_amount, withdraw_charge, send_to_unregistered, send_to_registered)
VALUES (30001, 50000, 270, null, 105);

INSERT INTO tbl_charges(min_amount, max_amount, withdraw_charge, send_to_unregistered, send_to_registered)
VALUES (50001, 70000, 300, null, 105);




INSERT INTO tbl_customer_details(user_id, surname, first_name, second_name, id_number, phone, status)
VALUES (uuid(),'Mwaura', 'Paul', 'Kamau', 30022211, '0700111222', 'active');

INSERT INTO tbl_customer_details(user_id, surname, first_name, second_name, id_number, phone, status)
VALUES (uuid(),'Momina', 'Ezekiel', 'Mutua', 30033311, '0700111333', 'active');

INSERT INTO tbl_customer_details(user_id, surname, first_name, second_name, id_number, phone, status)
VALUES (uuid(),'Omondi', 'Collins', 'Omwomo', 30044411, '0700111444', 'active');

INSERT INTO tbl_customer_details(user_id, surname, first_name, second_name, id_number, phone, status)
VALUES (uuid(),'Hirsi', 'Farah', 'Abdi', 30055511, '0700111555', 'active');

INSERT INTO tbl_customer_details(user_id, surname, first_name, second_name, id_number, phone, status)
VALUES (uuid(),'Gatembo', 'Agness', 'Njeri', 30055511, '0700111555', 'active');




INSERT INTO tbl_mobile_wallet (id, surname, first_name, second_name,account_balance, status, last_activity, phone, pin)
VALUES(uuid(), 'Kimani','Ayub','Mbugua', 1500.75, 'active', 'debit', '0700222111', 1111);

INSERT INTO tbl_mobile_wallet (id, surname, first_name, second_name,account_balance, status, last_activity, phone, pin)
VALUES(uuid(), 'Mwangi','Stellah','Njeri', 20000.00, 'active', 'credit', '0700333111', 2222);

INSERT INTO tbl_mobile_wallet (id, surname, first_name, second_name,account_balance, status, last_activity, phone, pin)
VALUES(uuid(), 'Mutua','Ezekiel','Mavutha', 100000.00, 'active', 'credit', '0700444111', 3333);

INSERT INTO tbl_mobile_wallet (id, surname, first_name, second_name,account_balance, status, last_activity, phone, pin)
VALUES(uuid(), 'Said','Ali','Bakari', 10000.00, 'active', 'credit', '0700555111', 4444);

INSERT INTO tbl_mobile_wallet (id, surname, first_name, second_name,account_balance, status, last_activity, phone, pin)
VALUES(uuid(), 'Mohammed','Salma','Zainabu', 10000.00, 'active', 'credit', '0700666111', 5555);



