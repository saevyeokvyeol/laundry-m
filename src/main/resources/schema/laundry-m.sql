DROP TABLE pay_log;
DROP TABLE fee;
DROP TABLE extra_fee;
DROP TABLE review;
DROP TABLE adjust;
DROP TABLE favorite;
DROP TABLE book_line;
DROP TABLE clothes;
DROP TABLE fabric;
DROP TABLE book_method;
DROP TABLE pay_account;
DROP TABLE book;
DROP TABLE metapay;
DROP TABLE laundry;
DROP TABLE bank;
DROP TABLE book_state;
DROP TABLE users;
DROP TABLE pay_category;
DROP TABLE BOOOK_METHOD;

DROP SEQUENCE LAUNDRY_SEQ;
DROP SEQUENCE METAPAY_SEQ;
DROP SEQUENCE BOOK_SEQ;
DROP SEQUENCE PAY_ACCOUNT_SEQ;
DROP SEQUENCE PAY_LOG_SEQ;
DROP SEQUENCE BOOK_LINE_SEQ;
DROP SEQUENCE FEE_SEQ;
DROP SEQUENCE EXTRA_FEE_SEQ;
DROP SEQUENCE REVIEW_SEQ;
DROP SEQUENCE ADJUST_SEQ;
DROP SEQUENCE FAVORITE_SEQ;

CREATE TABLE users (
	user_id	varchar2(20)		NOT NULL,
	user_pwd	varchar2(20)		NULL,
	user_name	varchar2(20)		NULL,
	user_phone	varchar2(20)		NULL,
	user_type	varchar2(20)		NULL,
	user_address	varchar2(100)		NULL,
	user_state	varchar2(20)		NULL,
	user_latitude	number		NULL,
	user_longitude	number		NULL
);

COMMENT ON COLUMN users.user_type IS '회원/점주/관리자';

COMMENT ON COLUMN users.user_state IS 'Y/N';


CREATE TABLE laundry (
	laundry_id	number		NOT NULL,
	user_id	varchar2(20)		NOT NULL,
	laundry_name	varchar2(50)		NULL,
	laundry_tel	varchar2(20)		NULL,
	laundry_address	varchar2(100)		NULL,
	laundry_delivery_fee	number		NULL,
	laundry_account_number	varchar2(20)		NULL,
	laundry_latitude	number		NULL,
	laundry_longitude	number		NULL
);


CREATE TABLE metapay (
	metapay_id	number		NOT NULL,
	user_id	varchar2(20)		NOT NULL,
	metapay_balance	number		NULL,
	metapay_password	varchar2(6)		NULL,
	metapay_date	timestamp		NULL,
	metapay_update_date	timestamp		NULL
);


CREATE TABLE book (
	book_id	number		NOT NULL,
	laundry_id	number		NOT NULL,
	user_id	varchar2(20)		NOT NULL,
	book_state_id	number		NOT NULL,
	book_count	number		NULL,
	book_insert_date	timestamp		NULL,
	book_memo	varchar2(1000)		NULL,
	book_method_id	number		NOT NULL,
	book_total_fee	number		NULL,
	book_update_date	timestamp		NULL
);


CREATE TABLE pay_account (
	pay_account_id	number		NOT NULL,
	metapay_id	number		NOT NULL,
	bank_id	number		NOT NULL,
	pay_account_number	varchar2(20)		NULL,
	pay_account_quit_state	varchar2(2)		NULL
);


CREATE TABLE bank (
	bank_id	number		NOT NULL,
	bank_name	varchar2(15)		NULL
);


CREATE TABLE pay_log (
	pay_log_id	number		NOT NULL,
	metapay_id	number		NOT NULL,
	pay_category_id	number		NOT NULL,
	pay_account_id	number		NOT NULL,
	pay_log_amount	number		NULL,
	pay_log_insert_date	timestamp		NULL
);


CREATE TABLE pay_category (
	pay_category_id     number		NOT NULL,
	pay_category_name	varchar2(50)		NULL
);


CREATE TABLE book_line (
	book_line_id	number		NOT NULL,
	book_id	number		NOT NULL,
	clothes_id	number		NOT NULL,
	fabric_id	number		NOT NULL,
	book_line_fee	number		NULL
);


CREATE TABLE book_state (
	book_state_id	number		NOT NULL,
	book_state_name	varchar2(20)		NULL
);


CREATE TABLE clothes (
	clothes_id	number		NOT NULL,
	clothes_name	varchar2(30)		NULL
);

CREATE TABLE fee (
	fee_id	number		NOT NULL,
	laundry_id	number		NOT NULL,
	clothes_id	number		NOT NULL,
	clothes_fee	number		NULL
);


CREATE TABLE fabric (
	fabric_id	number		NOT NULL,
	fabric_name	varchar2(20)		NULL,
	fabric_wash_method	varchar2(500)		NULL
);


CREATE TABLE extra_fee (
	extra_fee_id	number		NOT NULL,
	fabric_id	number		NOT NULL,
	laundry_id	number		NOT NULL,
	fabric_fee	number		NULL,
	extra_fee_operation	char		NULL
);

COMMENT ON COLUMN extra_fee.extra_fee_operation IS 'Y/N';


CREATE TABLE review (
	review_id	number		NOT NULL,
	user_id	varchar2(20)		NOT NULL,
	laundry_id	number		NOT NULL,
	book_id	number		NOT NULL,
	review_content	varchar2(200)		NULL,
	review_rate	number		NULL,
	review_insert_date	timestamp		NULL,
	review_update_date	timestamp		NULL
);


CREATE TABLE adjust (
	adjust_id	number		NOT NULL,
	laundry_id	number		NOT NULL,
	book_id	number		NOT NULL,
	adjust_insert_date	timestamp		NULL
);


CREATE TABLE favorite (
	favorite_id	number		NOT NULL,
	user_id	varchar2(20)		NOT NULL,
	laundry_id	number		NOT NULL
);

CREATE TABLE book_method (
	book_method_id	number		NOT NULL,
	book_method_name	varchar2(50)		NOT NULL
);

ALTER TABLE users ADD CONSTRAINT PK_USERS PRIMARY KEY (
	user_id
);

ALTER TABLE laundry ADD CONSTRAINT PK_LAUNDRY PRIMARY KEY (
	laundry_id
);

ALTER TABLE metapay ADD CONSTRAINT PK_METAPAY PRIMARY KEY (
	metapay_id
);

ALTER TABLE book ADD CONSTRAINT PK_BOOK PRIMARY KEY (
	book_id
);

ALTER TABLE pay_account ADD CONSTRAINT PK_PAY_ACCOUNT PRIMARY KEY (
	pay_account_id
);

ALTER TABLE bank ADD CONSTRAINT PK_BANK PRIMARY KEY (
	bank_id
);

ALTER TABLE pay_log ADD CONSTRAINT PK_PAY_LOG PRIMARY KEY (
	pay_log_id
);

ALTER TABLE pay_category ADD CONSTRAINT PK_PAY_CATEGORY PRIMARY KEY (
	pay_category_id
);

ALTER TABLE book_line ADD CONSTRAINT PK_BOOK_LINE PRIMARY KEY (
	book_line_id
);

ALTER TABLE book_state ADD CONSTRAINT PK_BOOK_STATE PRIMARY KEY (
	book_state_id
);

ALTER TABLE clothes ADD CONSTRAINT PK_CLOTHES PRIMARY KEY (
	clothes_id
);

ALTER TABLE fee ADD CONSTRAINT PK_FEE PRIMARY KEY (
	fee_id
);

ALTER TABLE fabric ADD CONSTRAINT PK_FABRIC PRIMARY KEY (
	fabric_id
);

ALTER TABLE extra_fee ADD CONSTRAINT PK_EXTRA_FEE PRIMARY KEY (
	extra_fee_id
);

ALTER TABLE review ADD CONSTRAINT PK_REVIEW PRIMARY KEY (
	review_id
);

ALTER TABLE adjust ADD CONSTRAINT PK_ADJUST PRIMARY KEY (
	adjust_id
);

ALTER TABLE favorite ADD CONSTRAINT PK_FAVORITE PRIMARY KEY (
	favorite_id
);

ALTER TABLE book_method ADD CONSTRAINT PK_BOOK_METHOD PRIMARY KEY (
	book_method_id
);

ALTER TABLE laundry ADD CONSTRAINT FK_users_TO_laundry_1 FOREIGN KEY (
	user_id
)
REFERENCES users (
	user_id
);

ALTER TABLE metapay ADD CONSTRAINT FK_users_TO_metapay_1 FOREIGN KEY (
	user_id
)
REFERENCES users (
	user_id
);

ALTER TABLE book ADD CONSTRAINT FK_laundry_TO_book_1 FOREIGN KEY (
	laundry_id
)
REFERENCES laundry (
	laundry_id
);

ALTER TABLE book ADD CONSTRAINT FK_users_TO_book_1 FOREIGN KEY (
	user_id
)
REFERENCES users (
	user_id
);

ALTER TABLE book ADD CONSTRAINT FK_book_state_TO_book_1 FOREIGN KEY (
	book_state_id
)
REFERENCES book_state (
	book_state_id
);

ALTER TABLE pay_account ADD CONSTRAINT FK_metapay_TO_pay_account_1 FOREIGN KEY (
	metapay_id
)
REFERENCES metapay (
	metapay_id
);

ALTER TABLE pay_account ADD CONSTRAINT FK_bank_TO_pay_account_1 FOREIGN KEY (
	bank_id
)
REFERENCES bank (
	bank_id
);

ALTER TABLE pay_log ADD CONSTRAINT FK_metapay_TO_pay_log_1 FOREIGN KEY (
	metapay_id
)
REFERENCES metapay (
	metapay_id
);

ALTER TABLE pay_log ADD CONSTRAINT FK_pay_category_TO_pay_log_1 FOREIGN KEY (
	pay_category_id
)
REFERENCES pay_category (
	pay_category_id
);

ALTER TABLE pay_log ADD CONSTRAINT FK_pay_account_TO_pay_log_1 FOREIGN KEY (
	pay_account_id
)
REFERENCES pay_account (
	pay_account_id
);

ALTER TABLE book_line ADD CONSTRAINT FK_book_TO_book_line_1 FOREIGN KEY (
	book_id
)
REFERENCES book (
	book_id
);

ALTER TABLE book_line ADD CONSTRAINT FK_clothes_TO_book_line_1 FOREIGN KEY (
	clothes_id
)
REFERENCES clothes (
	clothes_id
);

ALTER TABLE book_line ADD CONSTRAINT FK_fabric_TO_book_line_1 FOREIGN KEY (
	fabric_id
)
REFERENCES fabric (
	fabric_id
);

ALTER TABLE fee ADD CONSTRAINT FK_laundry_TO_fee_1 FOREIGN KEY (
	laundry_id
)
REFERENCES laundry (
	laundry_id
);

ALTER TABLE fee ADD CONSTRAINT FK_clothes_TO_fee_1 FOREIGN KEY (
	clothes_id
)
REFERENCES clothes (
	clothes_id
);

ALTER TABLE extra_fee ADD CONSTRAINT FK_fabric_TO_extra_fee_1 FOREIGN KEY (
	fabric_id
)
REFERENCES fabric (
	fabric_id
);

ALTER TABLE extra_fee ADD CONSTRAINT FK_laundry_TO_extra_fee_1 FOREIGN KEY (
	laundry_id
)
REFERENCES laundry (
	laundry_id
);

ALTER TABLE review ADD CONSTRAINT FK_users_TO_review_1 FOREIGN KEY (
	user_id
)
REFERENCES users (
	user_id
);

ALTER TABLE review ADD CONSTRAINT FK_laundry_TO_review_1 FOREIGN KEY (
	laundry_id
)
REFERENCES laundry (
	laundry_id
);

ALTER TABLE review ADD CONSTRAINT FK_book_TO_review_1 FOREIGN KEY (
	book_id
)
REFERENCES book (
	book_id
);

ALTER TABLE adjust ADD CONSTRAINT FK_laundry_TO_adjust_1 FOREIGN KEY (
	laundry_id
)
REFERENCES laundry (
	laundry_id
);

ALTER TABLE adjust ADD CONSTRAINT FK_book_TO_adjust_1 FOREIGN KEY (
	book_id
)
REFERENCES book (
	book_id
);

ALTER TABLE favorite ADD CONSTRAINT FK_users_TO_favorite_1 FOREIGN KEY (
	user_id
)
REFERENCES users (
	user_id
);

ALTER TABLE favorite ADD CONSTRAINT FK_laundry_TO_favorite_1 FOREIGN KEY (
	laundry_id
)
REFERENCES laundry (
	laundry_id
);

ALTER TABLE book ADD CONSTRAINT FK_book_method_TO_book_1 FOREIGN KEY (
	book_method_id
)
REFERENCES book_method (
	book_method_id
);

ALTER TABLE LAUNDRY MODIFY (LAUNDRY_DELIVERY DEFAULT 3000);
