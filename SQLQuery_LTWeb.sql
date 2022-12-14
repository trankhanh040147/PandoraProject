CREATE DATABASE LTWeb
go

USE LTWeb

go

CREATE TABLE [dbo].[User] (
    [_id]            INT             IDENTITY (1, 1),
    [firstname]      NVARCHAR (32)   NULL,
    [lastname]       NVARCHAR (32)   NULL,
    [id_card]        VARCHAR (20)    UNIQUE,
    [email]          VARCHAR(256)    UNIQUE,
    [phone]          VARCHAR (12)    UNIQUE,
    [isEmailActive]  BIT             DEFAULT ((0)) NOT NULL,
    [isPhoneActive]  BIT             DEFAULT (0) NOT NULL,
    [password]       VARCHAR (50)    NULL,
    [role]           VARCHAR (20)    DEFAULT ('customer') NOT NULL, --enum: ['customer', 'vendor', 'admin']
    [addresses]      NVARCHAR (100)  DEFAULT ('') NOT NULL,
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

Select * from dbo.[User] ORDER BY firstname asc OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY
Select * from dbo.[User]
Insert Into dbo.[User](firstname, lastname, id_card, email, phone, password, addresses, avatar, cover) values (N'Ân', N'Ngô', '245398833', 'ngothuaan2002@gmail.com', '0976978201', 'anngo2k2', '', NULL, NULL)
Insert Into dbo.[User](firstname, lastname, id_card, email, phone, password, addresses, avatar, cover) values (N'Khánh', N'Trần', '245670984', 'trankhanh2002@gmail.com', '0369895576', 'khanhtran2k2', '', NULL, NULL)
Insert Into dbo.[User](firstname, lastname, id_card, email, phone, password, addresses, avatar, cover) values (N'Khánh', N'Nguyễn', '225670984', 'nguyenkhanh2002@gmail.com', '0369895828', 'khanhnguyen2k2', '', NULL, NULL)


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
    [name]           NVARCHAR (100)  NULL,
    [bio]            NVARCHAR (1000) NULL,
    [ownerId]        INT             NULL,
    [isActive]			BIT             DEFAULT ((0)) NOT NULL,
    [isOpen]        BIT             DEFAULT ((0)) NOT NULL,
    [avatar]         VARCHAR (100)   NULL,
    [cover]          VARCHAR (100)   NULL,
    [featured_image] VARCHAR (100)   DEFAULT ('') NOT NULL,
    [rating]         INT             DEFAULT ((3)) NOT NULL,
    [e_wallet]       DECIMAL (19, 3) DEFAULT (0) NOT NULL,
    [createdAt]      DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]      DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Store] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [rating] CHECK ([rating]>=(0) AND [rating]<=(5)),
    CONSTRAINT [FK_Store_User] FOREIGN KEY ([ownerId]) REFERENCES [dbo].[User] ([_id])
);

go

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
    [_id]        INT           IDENTITY (1, 1),
    [name]       NVARCHAR (32) NULL,
    [categoryId] INT           NULL,
    [image]      VARCHAR (100) NULL,
    [isDeleted]  BIT           DEFAULT ((0)) NOT NULL,
    [createdAt]  DATE          DEFAULT (getdate()) NOT NULL,
    [updatedAt]  DATE          DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_Category_Category] FOREIGN KEY ([categoryId]) REFERENCES [dbo].[Category] ([_id])
);

go

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
    [name]          NVARCHAR (32)   NULL,
    [categoryIds]   VARCHAR (100)   NULL,
    [isDeleted]     BIT             DEFAULT ((0)) NOT NULL,
    [createdAt]     DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Style ] PRIMARY KEY CLUSTERED ([_id] ASC),
);

go

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
    [name]      NVARCHAR (32)   NULL,
    [styleId]   INT             NULL,
    [isDeleted] BIT             DEFAULT ((0)) NOT NULL,
    [createdAt] DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt] DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_StyleValue] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_StyleValue_Style] FOREIGN KEY ([styleId]) REFERENCES [dbo].[Style] ([_id])
);

go

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
    [name]             NVARCHAR (32)   NULL,
    [description]      NVARCHAR (1000) NULL,
    [price]            DECIMAL (19, 3) NULL,
    [promotionalPrice] DECIMAL (19, 3) NULL,
    [quantity]         INT             NULL,
    [sold]             INT             DEFAULT ((0)) NOT NULL,
    [isActive]         INT             DEFAULT ((1)) NOT NULL,
    [isSelling]        BIT             DEFAULT ((1)) NOT NULL,
    [listImages]       VARCHAR (50)    NULL,
    [categoryId]       INT             NULL,
    [styleValueIds]    VARCHAR (50)    NULL,
    [storeId]          INT             NULL,
    [rating]           INT             DEFAULT ((3)) NOT NULL,
    [createdAt]        DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]        DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [Constraint_rating] CHECK ([rating]>=(0) AND [rating]<=(5)),
    CONSTRAINT [price] CHECK ([price]>=(0)),
    CONSTRAINT [promotionalPrice] CHECK ([promotionalPrice]>=(0) AND [promotionalPrice]<[price]),
    CONSTRAINT [quantity] CHECK ([quantity]>=(0)),
    CONSTRAINT [sold] CHECK ([sold]>=(0)),
    CONSTRAINT [FK_Product_Category] FOREIGN KEY ([categoryId]) REFERENCES [dbo].[Category] ([_id]),
    CONSTRAINT [FK_Product_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id])
);

go

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

go
CREATE TABLE [dbo].[Delivery] (
    [_id]           INT             IDENTITY (1, 1),
    [name]          NVARCHAR (100)  NULL,
    [description]   NVARCHAR (1000) NULL,
    [price]         INT             NULL,
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
    [userId]     INT  NULL,
    [storeId]    INT  NULL,
    [createdAt]  DATE DEFAULT (getdate()) NOT NULL,
    [updatedAt]  DATE DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_UserFollowStore] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_UserFollowStore_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id]),
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
    [userId]        INT  NULL,
    [productId]     INT  NULL,
    [createdAt]     DATE DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE  DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_UserFollowProduct] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_UserFollowProduct_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id]),
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
    [userId]            INT             NULL,
    [storeId]           INT             NULL,
    [deliveryId]        INT             NULL,
    [address]           NVARCHAR (100)  NULL,
    [phone]             VARCHAR (12)    NULL,
    [status]            NVARCHAR (15)   DEFAULT ('not processed') NOT NULL,
    [isPaidBefore]      BIT             DEFAULT ((0)) NOT NULL,
    [amountFromUser]    DECIMAL (19, 3) NULL ,
    [amountFromStore]   DECIMAL (19, 3) NULL,
    [amountToStore]     DECIMAL (19, 3) NULL,
    [amountToGD]        DECIMAL (19, 3) NULL,
    [createdAt]         DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]         DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [CK_amountFromStore] CHECK ([amountFromStore]>=(0)),
    CONSTRAINT [CK_amountFromUser] CHECK ([amountFromUser]>=(0)),
    CONSTRAINT [CK_amountToGD] CHECK ([amountToGD]>=(0)),
    CONSTRAINT [CK_amountToStore] CHECK ([amountToStore]>=(0)),
    CONSTRAINT [FK_Order_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id]),
    CONSTRAINT [FK_Order_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id]),
    CONSTRAINT [FK_Order_Delivery] FOREIGN KEY ([deliveryId]) REFERENCES [dbo].[Delivery] ([_id])
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
    [_id]           INT           IDENTITY (1, 1),
    [orderId]       INT           NULL,
    [productId]     INT           NULL,
    [styleValueIds] VARCHAR (100) NULL,
    [count]         INT           NULL,
    [createdAt]     DATE          DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE          DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_OrderItem] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [Ck_count] CHECK ([count]>=(1)),
    CONSTRAINT [FK_OrderItem_Order] FOREIGN KEY ([orderId]) REFERENCES [dbo].[Order] ([_id]),
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
    [_id]        INT  IDENTITY (1, 1),
    [userId]     INT  NULL,
    [storeId]    INT  NULL,
    [createdIAt] DATE DEFAULT (getdate()) NOT NULL,
    [updatedAt]  DATE DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Cart] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_Cart_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id]),
    CONSTRAINT [FK_Cart_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id])
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
    [_id]           INT           IDENTITY (1, 1),
    [cartId]        INT           NULL,
    [productId]     INT           NULL,
    [styleValueIds] VARCHAR (100) NULL,
    [count]         INT           NULL,
    [createdAt]     DATE          DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE          DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_CartItem] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [CK_Count_cartItem] CHECK ([count]>=(1)),
    CONSTRAINT [FK_CartItem_Cart] FOREIGN KEY ([cartId]) REFERENCES [dbo].[Cart] ([_id]),
    CONSTRAINT [FK_CartItem_Product] FOREIGN KEY ([productId]) REFERENCES [dbo].[Product] ([_id])
);

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
    [userId]        INT                NULL,
    [storeId]       INT                NULL,
    [isUp]          BIT                NULL,
    [amount]        DECIMAL (19, 3)    NULL,
    [createdAt]     DATE               DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE               DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Transaction] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [FK_Transaction_Store] FOREIGN KEY ([storeId]) REFERENCES [dbo].[Store] ([_id]),
    CONSTRAINT [FK_Transaction_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[User] ([_id])
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
    [userId]        INT             NULL,
    [productId]     INT             NULL,
    [storeId]       INT             NULL,
    [orderId]       INT             NULL,
    [content]       NVARCHAR (1000) NULL,
    [stars]         INT             NULL,
    [createdAt]     DATE            DEFAULT (getdate()) NOT NULL,
    [updatedAt]     DATE            DEFAULT (getdate()) NOT NULL,
    CONSTRAINT [PK_Review] PRIMARY KEY CLUSTERED ([_id] ASC),
    CONSTRAINT [stars] CHECK ([stars]>=(0) AND [stars]<=(5)),
    CONSTRAINT [FK_Review_User] FOREIGN KEY ([orderId]) REFERENCES [dbo].[Order] ([_id]),
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

