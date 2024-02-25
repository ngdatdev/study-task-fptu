use booking_ex2

-- Bảng Guest
CREATE TABLE Guest (
    GuestID INT PRIMARY KEY,
    FirstName NVARCHAR(50) NOT NULL,
    LastName NVARCHAR(50) NOT NULL,
    DateOfBirth DATE,
	Street NVARCHAR(50),
	City NVARCHAR(50)
)

CREATE TABLE [Guest Phone] 
(
	GuestID int FOREIGN KEY REFERENCES Guest(GuestID),
	Phone NVARCHAR(12),
	[Type] NVARCHAR(20),
	PRIMARY KEY (GuestID, Phone)
)

CREATE TABLE [Email Phone] 
(
	GuestID int FOREIGN KEY REFERENCES Guest(GuestID),
	Email NVARCHAR(40),
	[Type] NVARCHAR(20),
	PRIMARY KEY (GuestID, Email)
)

CREATE TABLE [Service] (
    ServiceID INT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL
)


CREATE TABLE Booking (
    BookingID INT PRIMARY KEY,
    GuestID INT,
    ServiceID INT,
    BookingDate DATE,
    TotalPrice DECIMAL(10, 2),
    NumberOfChildren INT,
    PaymentStatus VARCHAR(20),
    FOREIGN KEY (GuestID) REFERENCES Guest(GuestID),
)

CREATE TABLE [Using Service] (
	GuestID INT FOREIGN KEY REFERENCES Guest(GuestID),
	BookingID INT FOREIGN KEY REFERENCES Booking(BookingID),
	PRIMARY KEY (GuestID, BookingID)
)


CREATE TABLE BedType (
    BedTypeID INT PRIMARY KEY,
    [Type Name] VARCHAR(50)
);

CREATE TABLE RoomType (
    RoomTypeID INT PRIMARY KEY,
    TypeName VARCHAR(50),
    [Description] VARCHAR(255),
    PricePerNight DECIMAL(10, 2),
    MaxGuestCapacity INT
)

CREATE TABLE [Room Type Bed]
(
	[BedTypeID] INT Foreign key references BedType(BedTypeID),
	[RoomTypeID] INT foreign key references RoomType(RoomTypeID)
	Constraint FK_ROOM_BED primary key(BedTypeID, RoomTypeID)
)

-- Bảng Room
CREATE TABLE Room (
    RoomID INT PRIMARY KEY,
    [Room Name] nvarchar(100),
    RoomTypeID INT,
    [Status] VARCHAR(20),
    FOREIGN KEY (RoomTypeID) REFERENCES RoomType(RoomTypeID),
)

CREATE TABLE BookingRoom (
    BookingID INT FOREIGN KEY (BookingID) REFERENCES Booking(BookingID),
    RoomID INT FOREIGN KEY (RoomID) REFERENCES Room(RoomID),
    PRIMARY KEY (BookingID, RoomID),    
)

