CREATE DATABASE Pandora
go

USE Pandora

go

CREATE TABLE [dbo].[User] (
    [_id]            INT             IDENTITY (1, 1),
    [firstname]      NVARCHAR (32)   NOT NULL,
    [lastname]       NVARCHAR (32)   NOT NULL,
    [id_card]        VARCHAR (20)    NULL,
    [email]          VARCHAR(256)    UNIQUE NOT NULL,
    [phone]          VARCHAR (12)    UNIQUE NOT NULl,
    [isEmailActive]  BIT             DEFAULT ((0)) NOT NULL,
    [isPhoneActive]  BIT             DEFAULT (0) NOT NULL,
    [password]       VARCHAR (50)    NOT NULL,
    [role]           VARCHAR (20)    DEFAULT ('customer') NOT NULL, --enum: ['customer', 'vendor', 'admin']
    [addresses]      NVARCHAR (1000) DEFAULT ('') NOT NULL,
    [avatar]         VARCHAR (100)   NULL,	
    [cover]          VARCHAR (100)   NULL,
    [e_wallet]       DECIMAL (19, 3) DEFAULT (0) NOT NULL,
    [createdAt]      DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]      DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [id_card] CHECK ([id_card] NOT LIKE '%[^0-9]%' AND len([id_card])>=9),
    CONSTRAINT [email] CHECK ([email] LIKE '[a-z,0-9,_,-]%@[a-z]%.[a-z][a-z]%'),
	CONSTRAINT [phone] CHECK ([phone] NOT LIKE '%[^0-9]%'),
	CONSTRAINT [password] CHECK ([password] LIKE '%[0-9]%' OR [password] LIKE '%[A-Z]%' AND len([password]) >= 6)
);

go

Insert Into dbo.[User](firstname, lastname, email, phone, password, role) values (N'Ad001', N'Admin', 'admin001@gmail.com', '0369895828', 'admin001', 'admin')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role) values (N'Ad002', N'Admin', 'admin002@gmail.com', '0236457727', 'admin002', 'admin')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role) values (N'Ad003', N'Admin', 'admin003@gmail.com', '0966566585', 'admin003', 'admin')

Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Ân', N'Ngô', 'ngothuaan2002@gmail.com', '0976978201', 'anngo2k2', 'User/nam1.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Khánh', N'Trần', 'trankhanh2002@gmail.com', '0369895576', 'khanhtran2k2', 'User/nam2.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Khánh', N'Nguyễn', 'nguyenkhanh2002@gmail.com', '0311715828', 'khanhnguyen2k2', 'User/nam3.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'An', N'Lê', 'lethithuyan97@gmail.com', '0258695828', 'thuyan97', NULL)
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Ánh', N'Trần', 'anhthuytran2k1@gmail.com', '0526995828', 'anhtt2k1', 'User/nu1.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Bảo', N'Đoàn', 'doanquocbaopro@gmail.com', '0982595828', 'quocbaoace', NULL)
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Huyền', N'Nguyễn', 'nguyentranngochuyen@gmail.com', '0347295828', 'ngochuyeneng1', 'User/nu2.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Nga', N'Nguyễn', 'nttnga999@gmail.com', '0132795828', 'nttnga084', NULL)
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Thương', N'Trần', 'hoaithuongcute@gmail.com', '0323565828', 'hthuongtt22', 'User/nu4.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Nguyên', N'Lê', 'lebanguyen2002@gmail.com', '0247595828', 'banguyenvipro999', 'User/nam4.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Lệ', N'Nguyễn', 'nguyenngomyle98@gmail.com', '0243795828', 'mylenhuhoa828', 'User/nu3.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Cẩm', N'Ngô', 'ngohoaicam256@gmail.com', '0369894539', 'hoaicammiss85u', NULL)
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Anh', N'Cao', 'caotheanhhiphop@gmail.com', '0322245828', 'hiphopnever9', 'User/nam5.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Đăng', N'Ngô', 'thedangaladin@gmail.com', '0341345828', 'thedangchemistry12hoa', 'User/nam6.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Ngân', N'Nguyễn', 'nguyenthuynganxinh123@gmail.com', '0956215828', 'nguenngankkk', 'User/nu5.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Phương', N'Lê', 'pthule97@gmail.com', '0369823448', 'awspro8@9', NULL)
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Hoài', N'Trần', 'hoaitran85@gmail.com', '0369885233', 'padora@likeThat', 'User/nu6.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Hùng', N'Nguyễn', 'manhhungbipbip@gmail.com', '0966727828', 'tuyetthatlalala', 'User/nam7.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Tiên', N'Ngô', 'ngomaitien25@gmail.com', '0324365828', 'mtITfix09', NULL)
Insert Into dbo.[User](firstname, lastname, email, phone, password, avatar) values (N'Thúy', N'Hồ', 'anhthyho25@gmail.com', '0385965811', 'hoahuongduong123@', NULL)

Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Hạnh', N'Lê', 'lethihanhk85@gmail.com', '0356722916', 'thihanhshopk85', 'vendor', N'192B Phùng Hưng, Thủ Đức, TP Hồ Chí Minh', 'User/nu8.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Quân', N'Ngô', 'ngovanquan28@gmail.com', '0253665828', 'vanquan28@', 'vendor', N'18 Đinh Tiên Hoàng, Quận 7, Thành phố Hồ Chí Minh', 'User/nam9.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Huyền', N'Lê', 'huyenlek881@gmail.com', '0223445828', 'lehuyenk35', 'vendor', N'25 Lê Đại Hành, Quận 8, TP Hồ Chí Minh', 'User/nu9.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Hương', N'Phạm', 'huongphamsks16@gmail.com', '0551295828', 'sks16huong', 'vendor', N'25/12/11B Lê Văn Viện, Thủ Đức, Thành phố Hồ Chí Minh', 'User/nu10.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Phú', N'Nguyễn', 'nguyenphu75ken@gmail.com', '0499395828', 'phunguenpro123', 'vendor', N'138A Lê Thánh Tông, Mỹ Tho, Tiền Giang', 'User/nam10.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Thắng', N'Nguyễn', 'tranlam29mbm@gmail.com', '0235455828', 'lamtranf1k98', 'vendor', N'225 Hoàng Diệu, Tân An, Long An', 'User/nam11.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Vy', N'Trần', 'trankhavyaba1@gmail.com', '0861254828', 'khavynf65@', 'vendor', N'25B Trần Quý Cáp, Vũng Tàu, Bà Rịa - Vũng Tàu', 'User/nu11.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Yến', N'Phạm', 'yenphampnf95@gmail.com', '0253975828', 'phamyen2b249', 'vendor', N'928 Phạm Văn Đồng, Biên Hòa, Đồng Nai', 'User/nu12.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Trâm', N'Nguyễn', 'nguyenbaotram88@gmail.com', '0369825399', 'baotramshopais145', 'vendor', N'85 Quang Trung, Gò Vấp, TP Hồ Chí Minh', 'User/nu7.jpg')
Insert Into dbo.[User](firstname, lastname, email, phone, password, role, addresses, avatar) values (N'Khanh', N'Trần', 'khanhctk91@gmail.com', '0234427656', 'congkhanh', 'vendor', N'96 Nguyễn Huệ, Dĩ An, Bình Dương', 'User/nam8.jpg')


GO

CREATE TRIGGER [dbo].[updateUser] 
ON [dbo].[User]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[User] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[Store] (
    [_id]            INT             IDENTITY (1, 1),
    [name]           NVARCHAR (100)  UNIQUE NOT NULL,
    [bio]            NVARCHAR (1000) NULL,
    [ownerId]        INT             NOT NULL,
    [isActive]		 BIT             DEFAULT ((0)) NOT NULL,
    [isOpen]         BIT             DEFAULT ((0)) NOT NULL,
    [avatar]         VARCHAR (100)   NULL,
    [cover]          VARCHAR (100)   NULL,
    [featured_image] VARCHAR (100)   DEFAULT ('') NOT NULL,
    [rating]         INT			 DEFAULT ((3)) NOT NULL,
    [e_wallet]       DECIMAL (19, 3) DEFAULT (0) NOT NULL,
    [createdAt]      DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]      DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Store] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [rating] CHECK ([rating]>=(0) AND [rating]<=(5)),
    CONSTRAINT [FK_Store_User] FOREIGN KEY ([ownerId]) REFERENCES [dbo].[User] ([_id]) ON DELETE CASCADE
);

go

Insert Into Store(name, ownerId) values (N'ao_thun_vdr', 24)
Insert Into Store(name, ownerId) values (N'golana.vn', 25)
Insert Into Store(name, ownerId) values (N'thanhgau33', 26)
Insert Into Store(name, ownerId) values (N'xuongbalohonglam', 27)
Insert Into Store(name, ownerId) values (N'vansvar.vn', 28)
Insert Into Store(name, ownerId) values (N'gzt.vn', 29)
Insert Into Store(name, ownerId) values (N'jacksonz.vn', 30)
Insert Into Store(name, ownerId) values (N'leevin.store', 31)
Insert Into Store(name, ownerId) values (N'cemmery', 32)
Insert Into Store(name, ownerId) values (N'xuongmay.jeans', 33)

GO

CREATE TRIGGER [dbo].[updateStore] 
ON [dbo].[Store]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[Store] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[Category] (
    [_id]        INT				IDENTITY (1, 1),
    [name]       NVARCHAR (32)		UNIQUE NOT NULL,
    [categoryId] INT				NULL,
    [image]      VARCHAR (100)		NULL,
    [isDeleted]  BIT				DEFAULT ((0)) NOT NULL,
    [createdAt]  DATE				DEFAULT (getdate()) NOT NULL,
    [updatedAt]  DATE				DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_Category_Category] FOREIGN KEY ([categoryId]) REFERENCES [dbo].[Category] ([_id])
);

go

Insert Into Category(name) values (N'Quần áo')
Insert Into Category(name) values (N'Giày dép')
Insert Into Category(name) values (N'Balo')
Insert Into Category(name) values (N'Đồng hồ')
Insert Into Category(name) values (N'Đồ chơi')
Insert Into Category(name, categoryId) values (N'Quần áo nam', 1)
Insert Into Category(name, categoryId) values (N'Quần áo nữ', 1)
Insert Into Category(name) values (N'Điện thoại & phụ kiện')
Insert Into Category(name) values (N'Máy tính & LapTop')
Insert Into Category(name) values (N'Máy ảnh & Máy quay phim')
Insert Into Category(name) values (N'Thiết bị gia dụng')
Insert Into Category(name) values (N'Thể thao & Du lịch')
Insert Into Category(name) values (N'Phụ kiện & Trang sức nữ')
Insert Into Category(name) values (N'Sức khỏe')
Insert Into Category(name) values (N'Nhà cửa & Đời sống')
Insert Into Category(name, categoryId) values (N'Quần Tây', 7)
Insert Into Category(name, categoryId) values (N'Giày', 2)
Insert Into Category(name, categoryId) values (N'Dép', 2)

Go

CREATE TRIGGER [dbo].[updateCategory] 
ON [dbo].[Category]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[Category] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[Style] (
    [_id]           INT             IDENTITY (1, 1),
    [name]          NVARCHAR (32)   NOT NULL,
    [categoryIds]   VARCHAR (1000)  NOT NULL,
    [isDeleted]     BIT             DEFAULT ((0)) NOT NULL,
    [createdAt]     DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Style ] PRIMARY KEY CLUSTERED ([_id] ASC),
);

go

Insert Into Style(name, categoryIds) values (N'Màu', '1,2,3,4,5,6,7,13')
Insert Into Style(name, categoryIds) values (N'SIZE', '1,2,6,7')
Insert Into Style(name, categoryIds) values (N'Type', '3,5')

Go

Select * From Style where _id = 2

CREATE TRIGGER [dbo].[updateStyle] 
ON [dbo].[Style]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[Style] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[StyleValue] (
    [_id]       INT             IDENTITY (1, 1),
    [name]      NVARCHAR (32)   UNIQUE NOT NULL,
    [styleId]   INT             NOT NULL,
    [isDeleted] BIT             DEFAULT ((0)) NOT NULL,
    [createdAt] DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt] DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_StyleValue] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_StyleValue_Style] FOREIGN KEY ([styleId]) REFERENCES [dbo].[Style] ([_id]) ON DELETE CASCADE
);

go

Insert Into StyleValue(name, styleId) values (N'Trắng', 1)
Insert Into StyleValue(name, styleId) values (N'Đen', 1)
Insert Into StyleValue(name, styleId) values (N'Hồng', 1)
Insert Into StyleValue(name, styleId) values (N'Xanh', 1)
Insert Into StyleValue(name, styleId) values (N'Be', 1)
Insert Into StyleValue(name, styleId) values (N'Hồng Dâu', 1)
Insert Into StyleValue(name, styleId) values (N'Xanh Lá', 1)
Insert Into StyleValue(name, styleId) values (N'Xanh Bích', 1)
Insert Into StyleValue(name, styleId) values (N'Xanh Xám', 1)
Insert Into StyleValue(name, styleId) values (N'Xanh Biển', 1)
Insert Into StyleValue(name, styleId) values (N'Xanh Neon', 1)
Insert Into StyleValue(name, styleId) values (N'Đỏ', 1)
Insert Into StyleValue(name, styleId) values (N'Xanh Mint', 1)
Insert Into StyleValue(name, styleId) values (N'Hồng Cam', 1)
Insert Into StyleValue(name, styleId) values (N'Kem', 1)
Insert Into StyleValue(name, styleId) values (N'Xanh Dương', 1)
Insert Into StyleValue(name, styleId) values (N'Be Đậm', 1)
Insert Into StyleValue(name, styleId) values (N'Be Nhạt', 1)
Insert Into StyleValue(name, styleId) values (N'Kem Sáng', 1)
Insert Into StyleValue(name, styleId) values (N'Báo Trắng', 1)
Insert Into StyleValue(name, styleId) values (N'Kẻ Trắng', 1)
Insert Into StyleValue(name, styleId) values (N'Ghi', 1)
Insert Into StyleValue(name, styleId) values (N'Cam đất', 1)
Insert Into StyleValue(name, styleId) values (N'Violet', 1)
Insert Into StyleValue(name, styleId) values (N'Tím', 1)
Insert Into StyleValue(name, styleId) values (N'Vàng', 1)
Insert Into StyleValue(name, styleId) values (N'Vàng đen', 1)
Insert Into StyleValue(name, styleId) values (N'Vàng trắng', 1)
Insert Into StyleValue(name, styleId) values (N'S', 2)
Insert Into StyleValue(name, styleId) values (N'M', 2)
Insert Into StyleValue(name, styleId) values (N'L', 2)
Insert Into StyleValue(name, styleId) values (N'XL', 2)
Insert Into StyleValue(name, styleId) values (N'XXL', 2)
Insert Into StyleValue(name, styleId) values (N'XS', 2)
Insert Into StyleValue(name, styleId) values (N'35', 2)
Insert Into StyleValue(name, styleId) values (N'36', 2)
Insert Into StyleValue(name, styleId) values (N'37', 2)
Insert Into StyleValue(name, styleId) values (N'38', 2)
Insert Into StyleValue(name, styleId) values (N'39', 2)
Insert Into StyleValue(name, styleId) values (N'40', 2)
Insert Into StyleValue(name, styleId) values (N'BL003', 3)
Insert Into StyleValue(name, styleId) values (N'BL033', 3)
Insert Into StyleValue(name, styleId) values (N'BL005', 3)
Insert Into StyleValue(name, styleId) values (N'Ducati', 3)
Insert Into StyleValue(name, styleId) values (N'Yamaha', 3)
Insert Into StyleValue(name, styleId) values (N'SetA', 3)
Insert Into StyleValue(name, styleId) values (N'SetB', 3)
Insert Into StyleValue(name, styleId) values (N'SetC', 3)
Insert Into StyleValue(name, styleId) values (N'30cm', 3)
Insert Into StyleValue(name, styleId) values (N'45cm', 3)
Insert Into StyleValue(name, styleId) values (N'Cam', 1)
Insert Into StyleValue(name, styleId) values (N'Nâu', 1)
Insert Into StyleValue(name, styleId) values (N'size 35x42cm', 3)

Go

CREATE TRIGGER [dbo].[updateStyleValue] 
ON [dbo].[StyleValue]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[StyleValue] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go


CREATE TABLE [dbo].[Product] (
    [_id]              INT             IDENTITY (1, 1),
    [name]             NVARCHAR (100)  NOT NULL,
    [description]      NVARCHAR (1000) NULL,
    [price]            DECIMAL (19, 3) NOT NULL,
    [promotionalPrice] DECIMAL (19, 3) NOT NULL,
    [quantity]         INT             NOT NULL,
    [sold]             INT             DEFAULT ((0)) NOT NULL,
    [isActive]         BIT             DEFAULT ((1)) NOT NULL,
    [isSelling]        BIT             DEFAULT ((1)) NOT NULL,
    [listImages]       VARCHAR (1000)  DEFAULT ('') NOT NULL,
    [categoryId]       INT             NOT NULL,
    [styleValueIds]    VARCHAR (50)    DEFAULT ('') NOT NULL,
    [storeId]          INT             NOT NULL,
    [rating]           INT             DEFAULT ((3)) NOT NULL,
    [createdAt]        DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]        DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [Constraint_rating] CHECK ([rating]>=(0) AND [rating]<=(5)),
    CONSTRAINT [price] CHECK ([price]>=(0)),
    CONSTRAINT [promotionalPrice] CHECK ([promotionalPrice]>=(0) AND [promotionalPrice]<=[price]),
    CONSTRAINT [quantity] CHECK ([quantity]>=(0)),
    CONSTRAINT [sold] CHECK ([sold]>=(0)),
    CONSTRAINT [FK_Product_Category] FOREIGN KEY ([categoryId]) REFERENCES [dbo].[Category] ([_id]) ON DELETE CASCADE,
    CONSTRAINT [FK_Product_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id]) ON DELETE CASCADE
);

go

Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Tee basic ss1 CREWZ áo thun tay lỡ unisex Local Brand - AO_THUN_DVR (V427)', 159000, 82680, 160773, 'Product/p1-trang.jpg,Product/p1-den.jpg,Product/p1-hong.jpg,Product/p1-xanh.jpg,Product/p1-be.jpg', 6, '1,2,3,4,5,30,31,32', 1)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo Hoodie ADLV Teddy chất nỉ dày dặn cực ấm, Áo Hoodie Unisex Nam Nữ _ ao_thun_vdr_(nmoi3)', 256000, 122880, 666641, 'Product/p2-trang.jpg,Product/p2-den.jpg', 1, '1,2,30,31,32', 1)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo thun LocalBrand Cemmery , áo thun tay lỡ form rộng dáng oversize SIGNATURE TEE 2.0 ( V61)', 159000, 69960, 4301, 'Product/p3-be.jpg,Product/p3-xanh.jpg,,Product/p3-den.jpg', 1, '5,4,2,30,31,32', 1)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo Hoodie Đôi Nam Nữ Premium Basic AO THUN VDR (N437))', 265000, 127200, 1330787, 'Product/p4-trang.jpg,Product/p4-den.jpg', 1, '1,2,30,31,32', 1)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo thun Basic Slyder - Áo Thun Tay Lỡ Streetwear, Full Tag nhiều size form rộng Unisex ( V1 )', 119000, 89250, 207371, 'Product/p5-trang.jpg,Product/p5-den.jpg,Product/p5-hong.jpg,Product/p5-cam.jpg', 7, '1,2,3,51,30,31,32', 1)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo thun Tee Dreew - Áo thun tay lỡ full tags. ( V12 )', 145000, 88450, 175677, 'Product/p6-trang.jpg,Product/p6-den.jpg,Product/p6-xanhbien.jpg,Product/p6-xanhneon.jpg', 7, '1,2,10,11,30,31,32', 1)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo sweater Missout SS1 2 màu đen trắng in 2 mặt (N343)', 255000, 130050, 594, 'Product/p7-trang.jpg,Product/p7-den.jpg', 6, '1,2,30,31,32', 1)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo thun Oversize Basic OUTERITY SS2 - Áo thun nam nữ chất thun cotton dày dặn, full tag. ( V50 )', 149000, 89400, 19229, 'Product/p8-trang.jpg,Product/p8-den.jpg,Product/p8-cam.jpg', 1, '1,2,51,30,31,32', 1)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo phông Tee Basic SS1 Vender - Áo thun tay lỡ unisex form rộng, vải thun cotton 100%. ( V20)', 169000, 89570, 5567, 'Product/p9-trang.jpg,Product/p9-den.jpg,Product/p9-xanhbien.jpg', 6, '1,2,10,30,31,32', 1)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo Thun Tay Lỡ Streetwear BÁNH DONUT, Full tags tay và gấu áo - V16', 120000, 88800, 63736, 'Product/p10-bonmau.jpg', 7, '1,2,10,3,30,31,32', 1)

Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Đầm Body Nữ Dáng Dài Đuôi Cá Len Tăm, Váy ôm body sexy Hai Dây 3 Màu tôn dáng cực đỉnh 030', 99000, 0, 25256, 'Product/p11-den.jpg,Product/p11-nau.jpg,Product/p11-ghi.jpg', 7, '2,52,22,29,30,31,32,33', 2)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Áo Sơ Mi Lụa Crotop , Áo Sơ Mi Dáng Ngắn Cách Điệu ( Có cỡ big size)', 125000, 68750, 21143, 'Product/p12-trang.jpg,Product/p12-den.jpg,Product/p12-ghi.jpg', 7, '1,2,22,30,31,32,33', 2)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Quần Tây Ống Rộng Nữ Cạp Dán Lưng Cao Siêu Cá Tính (có Bigsize) (QT001)', 120000, 120000, 25256, 'Product/p13-trang.jpg,Product/p13-den.jpg,Product/p13-ghi.jpg,Product/p13-nau.jpg', 16, '1,2,22,52,29,20,31,32,33', 2)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Quần Đùi Đũi- Quần Short Đũi Nữ dáng váy siêu hot mã QS002', 44000, 41800, 12742, 'Product/p14-trang.jpg,Product/p14-den.jpg,Product/p14-be.jpg', 7, '1,2,5,29,30,31,32,33', 2)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Túi Xách Nữ Da Xịn Hai Quai Quảng Châu 5 Ngăn Đựng Cực Hot', 139000, 136220, 4125, 'Product/p15-den.jpg,Product/p15-nau.jpg', 13, '2,52', 2)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Túi Xách Nữ Đeo Vai Hồng Laser Siêu Cá Tính ( Hai quai Đeo , Không Nơ)', 99000, 87000, 5588, 'Product/p16-trang.jpg,Product/p16-hong.jpg', 13, '1,3', 2)

Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Giày búp bê nữ nơ chữ xinh xắn( về sll đủ zai)', 99000, 99000, 22820, 'Product/p17-den.jpg,Product/p17-kem.jpg', 17, '2,15,35,36,37,38,39', 3)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Giày 3 Phân Mũi Nhọn Dây Kép Đi 2 Kiểu( xả kho SLL)', 118000, 59000, 6259, 'Product/p18-den.jpg,Product/p18-kem.jpg', 17, '2,15,35,36,37,38,39', 3)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Dép nữ quai ngang lông hàng quảng châu cao cấp', 90000, 67500, 63736, 'Product/p19-den.jpg,Product/p19-vang.jpg,Product/p19-cam.jpg', 18, '2,26,51,36,37,38,39,40', 3)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Dép nữ quai ngang hàng quảng châu X -X xả kho 79k-79k-79k', 79000, 79000, 10002, 'Product/p20-trang.jpg,Product/p20-den.jpg,Product/p20-kem.jpg', 18, '1,2,15,35,36,37,38,39', 3)

Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Balo Thời Trang Ulzzang Nam Nữ Chống Nước Mar societt', 70000, 43900, 102035, 'Product/p21-trang.jpg,Product/p21-den.jpg,Product/p21-hong.jpg', 3, '1,2,3,53', 4)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'BALO ULZZANG BASIC CHỐNG NƯỚC ( 2 khoá song song 2 bên)', 60000, 42000, 63736, 'Product/p22-den.jpg', 3, '2', 4)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Balo Thời Trang Nam Nữ Cao Cấp ChangYe ( Có túi nước)', 60000, 43900, 38714, 'Product/p23-trang.jpg,Product/p23-den.jpg,Product/p23-hong.jpg,Product/p23-xanh.jpg', 3, '1,2,3,4,53', 4)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Balo Set 4 Món Hình Hoa Cúc Trắng Siêu Hot', 80000, 59900, 5868, 'Product/p24-den.jpg', 3, '2', 4)

Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Đồng hồ thạch anh dây da đeo tay thời trang cho nữ', 41429, 30000, 4749, 'Product/p25-trang.jpg,Product/p25-den.jpg,Product/p25-xanh.jpg,Product/p25-do.jpg', 4, '1,2,4,12', 5)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Đồng Hồ Thạch Anh V241 Bằng Thép Không Gỉ Thời Trang Cho Nữ', 55714, 42000, 9575, 'Product/p26-trang.jpg,Product/p26-den.jpg', 4, '1,2', 5)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Đồng Hồ Đeo Tay Mặt Tròn Hoạ Tiết Thiên Nga Đính Đá Với Dây Thép Không Gỉ Thời Trang Cho Phụ Nữ', 36000, 36000, 3709, 'Product/p27-den.jpg,Product/p27-do.jpg,Product/p27-xanhduong.jpg', 4, '2,12,16', 5)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Đồng Hồ Quartz Nam Hiển Thị Ngày Dây Da Geneva', 85714, 60000, 1998, 'Product/p28-nau.jpg', 4, '52', 5)


Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Mô Hình Xe Mô Tô Ducati Yamaha Tỉ Lệ 1 / 18 Dùng Để Trưng Bày', 126000, 67000, 29499, 'Product/p29-ducati.jpg,Product/p29-yamaha.jpg', 5, '44,45', 6)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Đồ Chơi Xe Biến Hình Hoạ Tiết Khủng Long Biến Hình Vui Nhộn Cho Bé', 73000, 36500, 1692, 'Product/p30-xanh.jpg,Product/p30-do.jpg,Product/p30-vang.jpg', 5, '4,12,26', 6)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Set 5 Mô Hình Xe Ô Tô Thể Thao Đồ Chơi Tỉ Lệ 1 / 64', 146000, 73000, 18476, 'Product/p31-setA.jpg,Product/p31-setB.jpg,Product/p31-setC.jpg', 5, '46,47,48', 6)
Insert Into Product(name, price, promotionalPrice, quantity, listImages, categoryId, styleValueIds, storeId) values (N'Đồ chơi bóp tay hình chú heo nhỏ mềm dẻo giải tỏa căng thẳng', 14400, 7200, 6790, 'Product/p32-hong.jpg', 5, '3', 6)


Go

CREATE TRIGGER [dbo].[updateProduct] 
ON [dbo].[Product]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[Product] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[Delivery] (
    [_id]           INT             IDENTITY (1, 1),
    [name]          NVARCHAR (100)  NOT NULL,
    [description]   NVARCHAR (1000) NULL,
    [price]         INT             NOT NULL,
    [isDeleted]     BIT             DEFAULT ((0)) NOT NULL,
    [createdAt]     DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Delivery] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [CK_price ] CHECK ([price]>=(0))
);

go

CREATE TRIGGER [dbo].[updateDelivery] 
ON [dbo].[Delivery]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[Delivery] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[UserFollowStore] (
    [_id]        INT  IDENTITY (1, 1),
    [userId]     INT  NOT NULL,
    [storeId]    INT  NOT NULL,
    [createdAt]  DATE DEFAULT (getdate()) NOT NULL,
    [updatedAt]  DATE DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_UserFollowStore] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_UserFollowStore_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id]) ON DELETE CASCADE,
    CONSTRAINT [FK_UserFollowStore_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id]) 
);

go

CREATE TRIGGER [dbo].[updateUserFollowStore] 
ON [dbo].[UserFollowStore]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[UserFollowStore] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[UserFollowProduct] (
    [_id]           INT  IDENTITY (1, 1),
    [userId]        INT  NOT NULL,
    [productId]     INT  NOT NULL,
    [createdAt]     DATE DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE  DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_UserFollowProduct] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_UserFollowProduct_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id]) ON DELETE CASCADE,
    CONSTRAINT [FK_UserFollowProduct_Store] FOREIGN KEY ([productId]) REFERENCES [dbo].[Product] ([_id])
);

go

CREATE TRIGGER [dbo].[updateUserFollowProduct] 
ON [dbo].[UserFollowProduct]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[UserFollowProduct] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[Order] (
    [_id]               INT             IDENTITY (1, 1),
    [userId]            INT             NOT NULL,
    [storeId]           INT             NOT NULL,
    [deliveryId]        INT             NOT NULL,
    [address]           NVARCHAR (100)  NOT NULL,
    [phone]             VARCHAR (12)    NOT NULL,
    [status]            NVARCHAR (15)   DEFAULT ('not processed') NOT NULL,
    [isPaidBefore]      BIT             DEFAULT ((0)) NOT NULL,
    [amountFromUser]    DECIMAL (19, 3) NOT NULL ,
    [amountFromStore]   DECIMAL (19, 3) NOT NULL,
    [amountToStore]     DECIMAL (19, 3) NOT NULL,
    [amountToGD]        DECIMAL (19, 3) NOT NULL,
    [createdAt]         DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]         DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [CK_amountFromStore] CHECK ([amountFromStore]>=(0)),
    CONSTRAINT [CK_amountFromUser] CHECK ([amountFromUser]>=(0)),
    CONSTRAINT [CK_amountToGD] CHECK ([amountToGD]>=(0)),
    CONSTRAINT [CK_amountToStore] CHECK ([amountToStore]>=(0)),
    CONSTRAINT [FK_Order_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id]) ON DELETE CASCADE,
    CONSTRAINT [FK_Order_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id]),
    CONSTRAINT [FK_Order_Delivery] FOREIGN KEY ([deliveryId]) REFERENCES [dbo].[Delivery] ([_id]) ON DELETE CASCADE
);

go

CREATE TRIGGER [dbo].[updateOrder] 
ON [dbo].[Order]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[Order] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[OrderItem] (
    [_id]           INT				IDENTITY (1, 1),
    [orderId]       INT				NOT NULL,
    [productId]     INT				NOT NULL,
    [styleValueIds] VARCHAR (1000)	NOT NULL,
    [count]         INT				NOT NULL,
    [createdAt]     DATE			DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE			DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_OrderItem] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [Ck_count] CHECK ([count]>=(1)),
    CONSTRAINT [FK_OrderItem_Order] FOREIGN KEY ([orderId]) REFERENCES [dbo].[Order] ([_id]) ON DELETE CASCADE,
    CONSTRAINT [FK_OrderItem_Product] FOREIGN KEY ([productId]) REFERENCES [dbo].[Product] ([_id])
);

go

CREATE TRIGGER [dbo].[updateOrderItem] 
ON [dbo].[OrderItem]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[OrderItem] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[Cart] (
    [_id]			INT		IDENTITY (1, 1),
    [userId]		INT		NOT NULL,
    [storeId]		INT		NOT NULL,
    [createdAt]		DATE	DEFAULT (getdate()) NOT NULL,
    [updatedAt]		DATE	DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Cart] PRIMARY KEY CLUSTERED ([_id] ASC),
	CONSTRAINT [FK_Cart_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id]) ON DELETE CASCADE,
    CONSTRAINT [FK_Cart_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id]),
);

go

CREATE TRIGGER [dbo].[updateCart] 
ON [dbo].[Cart]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[Cart] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[CartItem] (
    [_id]           INT				IDENTITY (1, 1),
    [cartId]        INT				NOT NULL,
    [productId]     INT				NOT NULL,
    [styleValueIds] VARCHAR (1000)	NOT	NULL,
    [count]         INT				NOT NULL,
    [createdAt]     DATE			DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE			DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_CartItem] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [CK_Count_cartItem] CHECK ([count]>=(1)),
	CONSTRAINT [FK_CartItem_Cart] FOREIGN KEY ([cartId]) REFERENCES [dbo].[Cart] ([_id]) ON DELETE CASCADE,
	CONSTRAINT [FK_CartItem_Product] FOREIGN KEY ([productId]) REFERENCES [dbo].[Product] ([_id]) 
)
go

CREATE TRIGGER [dbo].[updateCartItem] 
ON [dbo].[CartItem]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[CartItem] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[Transaction] (
    [_id]           INT                IDENTITY (1, 1),
    [userId]        INT                NOT NULL,
    [storeId]       INT                NOT NULL,
    [isUp]          BIT                NOT NULL, -- 0: rút tiền; 1: nạp tiền
    [amount]        DECIMAL (19, 3)    NOT NULL,
    [createdAt]     DATE               DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE               DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Transaction] PRIMARY KEY CLUSTERED ([_id] ASC),
	CONSTRAINT [FK_Transaction_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id]) ON DELETE CASCADE,
    CONSTRAINT [FK_Transaction_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id]) 
);

go

CREATE TRIGGER [dbo].[updateTransaction] 
ON [dbo].[Transaction]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[Transaction] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

CREATE TABLE [dbo].[Review] (
    [_id]           INT             IDENTITY (1, 1),
    [userId]        INT				NOT NULL,
    [productId]     INT             NOT NULL,
    [storeId]       INT             NOT NULL,
    [orderId]       INT             NOT NULL,
    [content]       NVARCHAR (1000) NULL,
    [stars]         INT             NOT NULL,
    [createdAt]     DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Review] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [stars] CHECK ([stars]>=(0) AND [stars]<=(5)),
    CONSTRAINT [FK_Review_User] FOREIGN KEY ([orderId]) REFERENCES [dbo].[User] ([_id]) ON DELETE CASCADE,
    CONSTRAINT [FK_Review_Order] FOREIGN KEY ([orderId]) REFERENCES [dbo].[Order] ([_id]),
    CONSTRAINT [FK_Review_Product] FOREIGN KEY ([productId]) REFERENCES [dbo].[Product] ([_id]),
    CONSTRAINT [FK_Review_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id])
);

go

CREATE TRIGGER [dbo].[updateReview] 
ON [dbo].[Review]
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(updatedAt) 
        UPDATE [dbo].[Review] SET updatedAt=GETDATE() 
        WHERE _id IN (SELECT _id FROM inserted) 
END 

go

