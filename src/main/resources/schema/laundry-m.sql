
CREATE TABLE users (
	user_id	varchar2(20)		NOT NULL,
	user_pwd	varchar2(20)		NULL,
	user_name	varchar2(20)		NULL,
	user_phone	varchar2(20)		NULL,
	user_type	varchar2(20)		NULL,
	user_address	varchar2(100)		NULL,
	user_state	varchar2(2)		NULL
);

COMMENT ON COLUMN users.user_type IS '회원/점주/관리자';

COMMENT ON COLUMN users.user_state IS 'Y/N';

CREATE TABLE laundry (
	laundry_id	number		NOT NULL,
	user_id	varchar2(20)		NOT NULL,
	laundry_name	varchar2(100)		NULL,
	laundry_tel	varchar2(20)		NULL,
	laundry_address	varchar2(100)		NULL,
	laundry_delivery_fee	number		NULL,
	laundry_account_number	varchar2(20)		NULL
);

COMMENT ON COLUMN laundry.laundry_delivery_fee IS 'default 3000';

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
	book_method	varchar2(50)		NULL,
	book_total_fee	number		NULL,
	book_update_date	timestamp		NULL
);

COMMENT ON COLUMN book.book_method IS '카드/ 메타페이 / 직접결제';

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
	pay_category_id	number		NOT NULL,
	pay_category_name	varchar2(20)	NULL
);

CREATE TABLE book_line (
	book_line_id	number		NOT NULL,
	book_id	number		NOT NULL,
	clothes_id	number		NOT NULL,
	fabric_id	number		NOT NULL,
	book_line_fee	number		NULL
);

COMMENT ON COLUMN book_line.book_line_fee IS 'fee의가격+추가가격';

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


