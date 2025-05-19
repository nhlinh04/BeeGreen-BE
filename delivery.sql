# USE db_datn_sd_02;
# INSERT INTO district (name, is_active) VALUES ('Ba Đình', true);
# INSERT INTO district (name, is_active) VALUES ('Hoàn Kiếm', true);
# INSERT INTO district (name, is_active) VALUES ('Tây Hồ', true);
# INSERT INTO district (name, is_active) VALUES ('Long Biên', true);
# INSERT INTO district (name, is_active) VALUES ('Cầu Giấy', true);
# INSERT INTO district (name, is_active) VALUES ('Đống Đa', true);
# INSERT INTO district (name, is_active) VALUES ('Hai Bà Trưng', true);
# INSERT INTO district (name, is_active) VALUES ('Hoàng Mai', true);
# INSERT INTO district (name, is_active) VALUES ('Thanh Xuân', true);
# INSERT INTO district (name, is_active) VALUES ('Nam Từ Liêm', true);
# INSERT INTO district (name, is_active) VALUES ('Bắc Từ Liêm', true);
# INSERT INTO district (name, is_active) VALUES ('Sóc Sơn', true);
# INSERT INTO district (name, is_active) VALUES ('Đan Phượng', true);
# INSERT INTO district (name, is_active) VALUES ('Hoài Đức', true);
# INSERT INTO district (name, is_active) VALUES ('Mỹ Đức', true);
# INSERT INTO district (name, is_active) VALUES ('Thanh Oai', true);
# INSERT INTO district (name, is_active) VALUES ('Chương Mỹ', true);
# INSERT INTO district (name, is_active) VALUES ('Phú Xuyên', true);
# INSERT INTO district (name, is_active) VALUES ('Thường Tín', true);
# INSERT INTO district (name, is_active) VALUES ('Ứng Hòa', true);
# INSERT INTO district (name, is_active) VALUES ('Ba Vì', true);
# INSERT INTO district (name, is_active) VALUES ('Mê Linh', true);
# INSERT INTO district (name, is_active) VALUES ('Sơn Tây', true);
# INSERT INTO district (name, is_active) VALUES ('Đông Anh', true);
# INSERT INTO district (name, is_active) VALUES ('Gia Lâm', true);
# INSERT INTO district (name, is_active) VALUES ('Kỳ Sơn', true);


-- Chèn các phường thuộc quận Ba Vì vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Tây Đằng', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Ba Trại', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Ba Vì', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Cẩm Lĩnh', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Cam Thượng', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Châu Sơn', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Chu Minh', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Cổ Đô', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Đông Quang', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Đồng Thái', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Khánh Thượng', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Minh Châu', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Minh Quang', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Phong Vân', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Phú Châu', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Phú Cường', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Phú Đông', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Phú Phương', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Phú Sơn', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Sơn Đà', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Tản Hồng', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Tản Lĩnh', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thái Hòa', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thuần Mỹ', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thụy An', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Tiên Phong', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Tòng Bạt', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Vân Hòa', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Vạn Thắng', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Vật Lại', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Yên Bài', (SELECT id FROM district WHERE name = 'Ba Vì'), true);

-- Chèn các phường/xã thuộc huyện Chương Mỹ vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Chúc Sơn', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã An Mỹ', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã An Phú', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Bình Minh', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Bình Lãng', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Bích Hòa', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Cao Dương', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Cẩm Lĩnh', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đại Yên', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đông Sơn', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hòa Sơn', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hồng Sơn', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hợp Đồng', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hương Sơn', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Kim Bảng', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Lê Lợi', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Lương Sơn', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Nam Sơn', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phú Cường', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phú Lương', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phúc Sơn', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tân Mỹ', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tô Hiệu', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Thanh Bình', (SELECT id FROM district WHERE name = 'Chương Mỹ'), true);

-- Chèn các phường/xã thuộc huyện Gia Lâm vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Trâu Quỳ', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Dương Xá', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đông Dư', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Cổ Bi', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Kim Sơn', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phù Đổng', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Bát Tràng', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đình Xuyên', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Văn Đức', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Lệ Chi', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Kiêu Kỵ', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Yên Thường', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Dương Quang', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Trung Mầu', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Bảo Đà', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Vân Hà', (SELECT id FROM district WHERE name = 'Gia Lâm'), true);

-- Chèn các phường/xã thuộc huyện Hoài Đức vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Trạm Trôi', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã An Khánh', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã An Thượng', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Cát Quế', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Di Trạch', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Dương Liễu', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đức Thượng', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hoài Sơn', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Minh Khai', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Minh Phú', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phú Cát', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phương Trung', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Song Phương', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Yên Sở', (SELECT id FROM district WHERE name = 'Hoài Đức'), true);

-- Chèn các phường/xã thuộc huyện Mê Linh vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Mê Linh', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tiền Phong', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Chu Phan', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Quang Minh', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Thanh Lâm', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đại Thịnh', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Kim Hoa', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Mê Linh', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Liên Mạc', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Vạn Yên', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Lý Nhân', (SELECT id FROM district WHERE name = 'Mê Linh'), true);

-- Chèn các phường/xã thuộc huyện Mỹ Đức vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Đại Nghĩa', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã An Mỹ', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Bột Xuyên', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Dũng Tiến', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hồng Sơn', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hợp Tiến', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hương Sơn', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hữu Bằng', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Lê Thanh', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Mỹ Thành', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Mỹ Lâm', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Minh Tân', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phúc Lâm', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tuy Lai', (SELECT id FROM district WHERE name = 'Mỹ Đức'), true);

-- Chèn các phường/xã thuộc huyện Phú Xuyên vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Phú Xuyên', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Chuyên Mỹ', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đại Thắng', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hồng Minh', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hòa Nam', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hòa Sơn', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Minh Tân', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phú Túc', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phượng Dực', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Quang Lãng', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Quất Động', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Sơn Hà', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Thụy Phú', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tiền Phong', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tân Dân', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Vân Tảo', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Vĩnh Quỳnh', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Văn Hoàng', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Trạch Mỹ Lộc', (SELECT id FROM district WHERE name = 'Phú Xuyên'), true);

-- Chèn các phường/xã thuộc huyện Phúc Thọ vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Phúc Thọ', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Bình Phú', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Cổ Đông', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đoan Hạ', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hát Môn', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hiền Lương', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phụng Thượng', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Sen Phương', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Thọ Lộc', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tam Thuấn', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tích Giang', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Vân Hòa', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Xuân Phú', (SELECT id FROM district WHERE name = 'Phúc Thọ'), true);

-- Chèn các phường/xã thuộc huyện Quốc Oai vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Quốc Oai', (SELECT id FROM district WHERE name = 'Quốc Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Cấn Hữu', (SELECT id FROM district WHERE name = 'Quốc Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đông Yên', (SELECT id FROM district WHERE name = 'Quốc Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hòa Thạch', (SELECT id FROM district WHERE name = 'Quốc Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hữu Bằng', (SELECT id FROM district WHERE name = 'Quốc Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Liệp Tuyết', (SELECT id FROM district WHERE name = 'Quốc Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Nghĩa Hương', (SELECT id FROM district WHERE name = 'Quốc Oai'), true);

-- Chèn các phường/xã thuộc huyện Sóc Sơn vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Sóc Sơn', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Bắc Sơn', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Cao Minh', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đông Xuân', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hiền Ninh', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hồng Kỳ', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Minh Phú', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phù Lỗ', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Quang Tiến', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tân Hưng', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tân Dân', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tiên Dương', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Việt Long', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Vân Trì', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Xuân Giang', (SELECT id FROM district WHERE name = 'Sóc Sơn'), true);

-- Chèn các phường/xã thuộc huyện Thanh Oai vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Kim Bài', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Cao Dương', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Cự Khối', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Dân Hòa', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hồng Dương', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hòa Sơn', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Liên Châu', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Kim An', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Mỹ Hương', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Phú Túc', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tân Ước', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Thanh Mai', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Thanh Thùy', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tam Hưng', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Văn Bình', (SELECT id FROM district WHERE name = 'Thanh Oai'), true);

-- Chèn các phường/xã thuộc huyện Thanh Trì vào bảng ward

INSERT INTO ward (name, district_id, is_active)
VALUES ('Thị trấn Thanh Trì', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Đại Áng', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Duyên Hà', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hòa Bình', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Hữu Hòa', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Ngọc Hồi', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tân Triều', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tam Hiệp', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Thanh Liệt', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Tả Thanh Oai', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Văn Điển', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

INSERT INTO ward (name, district_id, is_active)
VALUES ('Xã Vĩnh Quỳnh', (SELECT id FROM district WHERE name = 'Thanh Trì'), true);

