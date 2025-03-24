create database QuanLyBanHang;

use QuanLyBanHang;

insert into customer
values (1,'Minh Quan',10), (2,'Ngoc Oanh',20), (3,'Hong Ha',50);

insert into orderr
values (1,1,'2006-3-21',Null), (2,2,'2006-3-23',Null), (3,1,'2006-3-16',Null);

insert into product
values (1,'May Giat',3), (2,'Tu Lanh',5), (3,'Dieu Hoa',7), (4,'Quat',1), (5,'Bep Dien',2);

insert into orderdetail
values (1,1,3), (1,3,7), (1,4,2), (2,1,1), (3,1,8), (3,5,4), (2,3,3);

# Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID, oDate, oTotalPrice from orderr;

# Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.cName, p.pName from customer c
inner join orderr o on o.cID = c.cID 
inner join orderdetail od on o.oID = od.oID
inner join product p on p.pID = od.pID;

# Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.cName from customer c 
left join orderr o on c.cID = o.cID
where o.oID is null;

# Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
update orderr
set oTotalPrice = 0;

UPDATE orderr o
JOIN (
    SELECT od.oID, SUM(od.odQTY * p.pPrice) AS total_price
    FROM orderdetail od
    JOIN product p ON od.pID = p.pID
    GROUP BY od.oID
) t ON o.oID = t.oID
SET o.oTotalPrice = t.total_price;


select oID, oDate, oTotalPrice from orderr;