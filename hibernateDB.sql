USE [master]
GO
/****** Object:  Database [hibernateDB]    Script Date: 2022/9/6 下午 07:21:32 ******/
CREATE DATABASE [hibernateDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'hibernateDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\hibernateDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'hibernateDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\hibernateDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [hibernateDB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [hibernateDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [hibernateDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [hibernateDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [hibernateDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [hibernateDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [hibernateDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [hibernateDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [hibernateDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [hibernateDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [hibernateDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [hibernateDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [hibernateDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [hibernateDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [hibernateDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [hibernateDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [hibernateDB] SET  ENABLE_BROKER 
GO
ALTER DATABASE [hibernateDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [hibernateDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [hibernateDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [hibernateDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [hibernateDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [hibernateDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [hibernateDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [hibernateDB] SET RECOVERY FULL 
GO
ALTER DATABASE [hibernateDB] SET  MULTI_USER 
GO
ALTER DATABASE [hibernateDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [hibernateDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [hibernateDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [hibernateDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [hibernateDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [hibernateDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'hibernateDB', N'ON'
GO
ALTER DATABASE [hibernateDB] SET QUERY_STORE = OFF
GO
USE [hibernateDB]
GO
/****** Object:  Table [dbo].[accounts]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[accounts](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NULL,
	[balance] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[books]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[books](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[booktitle] [nvarchar](50) NULL,
	[publicYear] [nvarchar](50) NULL,
	[fk_user_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[bookUsers]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bookUsers](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[company]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[company](
	[companyId] [int] NOT NULL,
	[companyName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[companyId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[level] [int] NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[department]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[department](
	[deptid] [int] IDENTITY(1,1) NOT NULL,
	[deptname] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[deptid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[employee_name] [nvarchar](50) NULL,
	[salary] [int] NULL,
	[vacation] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[friend_group]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[friend_group](
	[fk_friend_id] [int] NOT NULL,
	[fk_group_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[fk_friend_id] ASC,
	[fk_group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[friends]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[friends](
	[friends_id] [int] IDENTITY(1,1) NOT NULL,
	[friendName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[friends_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[groups]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[groups](
	[groups_id] [int] IDENTITY(1,1) NOT NULL,
	[groupName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[groups_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[instructor]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[instructor](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[instructorName] [nvarchar](50) NOT NULL,
	[fk_instructorDetail_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[instructorDetail]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[instructorDetail](
	[id] [int] IDENTITY(101,1) NOT NULL,
	[email] [nvarchar](100) NOT NULL,
	[phone] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[member]    Script Date: 2022/9/6 下午 07:21:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[member](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[member_name] [varchar](50) NULL,
	[member_pwd] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[accounts] ON 

INSERT [dbo].[accounts] ([id], [username], [balance]) VALUES (1, N'Amy', 9500)
INSERT [dbo].[accounts] ([id], [username], [balance]) VALUES (2, N'Bill', 1000)
SET IDENTITY_INSERT [dbo].[accounts] OFF
GO
SET IDENTITY_INSERT [dbo].[books] ON 

INSERT [dbo].[books] ([id], [booktitle], [publicYear], [fk_user_id]) VALUES (1, N'Learn Java11', N'2020 1st', 1)
INSERT [dbo].[books] ([id], [booktitle], [publicYear], [fk_user_id]) VALUES (2, N'Spy Family', N'2022', 1)
SET IDENTITY_INSERT [dbo].[books] OFF
GO
SET IDENTITY_INSERT [dbo].[bookUsers] ON 

INSERT [dbo].[bookUsers] ([id], [username]) VALUES (1, N'Tom')
SET IDENTITY_INSERT [dbo].[bookUsers] OFF
GO
INSERT [dbo].[company] ([companyId], [companyName]) VALUES (1001, N'Google')
INSERT [dbo].[company] ([companyId], [companyName]) VALUES (1002, N'TSMC')
INSERT [dbo].[company] ([companyId], [companyName]) VALUES (1003, N'seven')
INSERT [dbo].[company] ([companyId], [companyName]) VALUES (1005, N'Meta')
GO
SET IDENTITY_INSERT [dbo].[customer] ON 

INSERT [dbo].[customer] ([id], [level], [name]) VALUES (1, 5, N'館長')
INSERT [dbo].[customer] ([id], [level], [name]) VALUES (2, 5, N'館長')
SET IDENTITY_INSERT [dbo].[customer] OFF
GO
SET IDENTITY_INSERT [dbo].[department] ON 

INSERT [dbo].[department] ([deptid], [deptname]) VALUES (1, N'HR')
INSERT [dbo].[department] ([deptid], [deptname]) VALUES (2, N'Toys')
INSERT [dbo].[department] ([deptid], [deptname]) VALUES (4, N'Tech')
SET IDENTITY_INSERT [dbo].[department] OFF
GO
SET IDENTITY_INSERT [dbo].[Employee] ON 

INSERT [dbo].[Employee] ([id], [employee_name], [salary], [vacation]) VALUES (1, N'Mary', 36000, 15)
INSERT [dbo].[Employee] ([id], [employee_name], [salary], [vacation]) VALUES (2, N'Tom', 40000, 5)
INSERT [dbo].[Employee] ([id], [employee_name], [salary], [vacation]) VALUES (3, N'Betty', 50000, 3)
INSERT [dbo].[Employee] ([id], [employee_name], [salary], [vacation]) VALUES (4, N'John', 28000, 6)
SET IDENTITY_INSERT [dbo].[Employee] OFF
GO
INSERT [dbo].[friend_group] ([fk_friend_id], [fk_group_id]) VALUES (1, 1)
INSERT [dbo].[friend_group] ([fk_friend_id], [fk_group_id]) VALUES (1, 2)
INSERT [dbo].[friend_group] ([fk_friend_id], [fk_group_id]) VALUES (2, 3)
INSERT [dbo].[friend_group] ([fk_friend_id], [fk_group_id]) VALUES (3, 1)
INSERT [dbo].[friend_group] ([fk_friend_id], [fk_group_id]) VALUES (3, 2)
INSERT [dbo].[friend_group] ([fk_friend_id], [fk_group_id]) VALUES (4, 3)
GO
SET IDENTITY_INSERT [dbo].[friends] ON 

INSERT [dbo].[friends] ([friends_id], [friendName]) VALUES (1, N'Tom')
INSERT [dbo].[friends] ([friends_id], [friendName]) VALUES (2, N'Mary')
INSERT [dbo].[friends] ([friends_id], [friendName]) VALUES (3, N'Tina')
INSERT [dbo].[friends] ([friends_id], [friendName]) VALUES (4, N'Bill')
SET IDENTITY_INSERT [dbo].[friends] OFF
GO
SET IDENTITY_INSERT [dbo].[groups] ON 

INSERT [dbo].[groups] ([groups_id], [groupName]) VALUES (1, N'high school')
INSERT [dbo].[groups] ([groups_id], [groupName]) VALUES (2, N'game')
INSERT [dbo].[groups] ([groups_id], [groupName]) VALUES (3, N'work')
SET IDENTITY_INSERT [dbo].[groups] OFF
GO
SET IDENTITY_INSERT [dbo].[instructor] ON 

INSERT [dbo].[instructor] ([id], [instructorName], [fk_instructorDetail_id]) VALUES (2, N'Jerry', NULL)
SET IDENTITY_INSERT [dbo].[instructor] OFF
GO
SET IDENTITY_INSERT [dbo].[member] ON 

INSERT [dbo].[member] ([id], [member_name], [member_pwd]) VALUES (1, N'jerry', N'1234')
SET IDENTITY_INSERT [dbo].[member] OFF
GO
ALTER TABLE [dbo].[books]  WITH CHECK ADD FOREIGN KEY([fk_user_id])
REFERENCES [dbo].[bookUsers] ([id])
GO
ALTER TABLE [dbo].[friend_group]  WITH CHECK ADD FOREIGN KEY([fk_friend_id])
REFERENCES [dbo].[friends] ([friends_id])
GO
ALTER TABLE [dbo].[friend_group]  WITH CHECK ADD FOREIGN KEY([fk_group_id])
REFERENCES [dbo].[groups] ([groups_id])
GO
ALTER TABLE [dbo].[instructor]  WITH CHECK ADD FOREIGN KEY([fk_instructorDetail_id])
REFERENCES [dbo].[instructorDetail] ([id])
GO
USE [master]
GO
ALTER DATABASE [hibernateDB] SET  READ_WRITE 
GO
