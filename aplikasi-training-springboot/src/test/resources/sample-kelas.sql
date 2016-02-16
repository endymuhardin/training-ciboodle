insert into kelas (id, kode, nama, tanggal_mulai, tanggal_selesai, id_instruktur) values
(98,'K-101', 'Kelas 101', '2016-02-01', '2016-02-05', 99);

insert into peserta_training (id_kelas, id_peserta) values 
(98,94),(98,95),(98,96),(98,97);

insert into kelas (id, kode, nama, tanggal_mulai, tanggal_selesai, id_instruktur) values
(99,'K-001', 'Kelas 001', '2016-01-01', '2016-01-05', 99);

insert into peserta_training (id_kelas, id_peserta) values 
(99,91),(99,92),(99,93),(99,94);

insert into detail_materi_kelas (id, id_kelas, id_materi, urutan) values
(91,98,91,1);
insert into detail_materi_kelas (id, id_kelas, id_materi, urutan) values
(92,98,92,2);
insert into detail_materi_kelas (id, id_kelas, id_materi, urutan) values
(93,98,93,3);
insert into detail_materi_kelas (id, id_kelas, id_materi, urutan) values
(94,99,94,1);
insert into detail_materi_kelas (id, id_kelas, id_materi, urutan) values
(95,99,95,2);