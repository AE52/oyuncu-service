CREATE TABLE oyuncu (
                        id INT PRIMARY KEY,
                        ad VARCHAR(50),
                        soyad VARCHAR(50),
                        mevki VARCHAR(50),
                        fiziksel_durum INT,
                        hiz INT,
                        sut INT,
                        pas INT,
                        savunma INT,
                        top_surme INT,
                        total_ovral DECIMAL(5,2)
);

INSERT INTO oyuncu (id, ad, soyad, mevki, fiziksel_durum, hiz, sut, pas, savunma, top_surme, total_ovral) VALUES
                                                                                                              (1, 'Ahmet', 'Yılmaz', 'Forvet', 85, 90, 88, 75, 60, 80, 79.67),
                                                                                                              (2, 'Mehmet', 'Demir', 'Orta Saha', 75, 80, 70, 85, 65, 75, 74.17),
                                                                                                              (3, 'Ayşe', 'Kara', 'Defans', 80, 70, 60, 65, 90, 50, 70.83);
