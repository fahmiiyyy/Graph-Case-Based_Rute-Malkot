# Graph-Case-Based_Rute-Malkot
🗺️ Program Peta Kota Malang
Implementasi Graph, BFS, DFS, dan Dijkstra dalam Java

Program ini merupakan simulasi peta sederhana Kota Malang menggunakan struktur Graph.
Di dalamnya terdapat fitur untuk mengecek keterjangkauan lokasi serta menemukan jalur dari satu titik ke titik lain menggunakan tiga algoritma:

BFS (Breadth First Search)

DFS (Depth First Search)

Dijkstra (Jalur Terpendek berdasarkan jarak)

Program berjalan di terminal dan menerima input lokasi asal dan tujuan dari pengguna.

📌 Fitur Utama
1. Representasi Graph

Node merepresentasikan lokasi di Kota Malang

Edge menyimpan:

jarak (km)

waktu tempuh (menit)

Graph bersifat dua arah

2. Cek Keterjangkauan

Program dapat mengecek apakah suatu lokasi dapat dijangkau dari lokasi lainnya menggunakan:

BFS

DFS

3. Pencarian Jalur

Program mengembalikan jalur lengkap serta total jarak & waktu menggunakan:

BFS → mencari rute dengan penjelajahan level-by-level

DFS → mencari jalur secara mendalam

Dijkstra → mencari jalur terpendek berdasarkan total jarak

Setiap rute menghasilkan:

- Daftar jalur yang dilalui
- Total jarak (km)
- Total waktu (menit)

🏛️ Struktur Kode
1. Edge

Menyimpan data jalur:

class Edge {
    String tujuan;
    int jarak;
    int waktu;
}

2. PathResult

Merepresentasikan output jalur:

class PathResult {
    List<String> path;
    int jarak;
    int waktu;
}

3. Graphhh

Fungsi utama:

Menambah lokasi & jalur

Mengecek keterjangkauan BFS & DFS

Mencari rute BFS & DFS

Dijkstra untuk jalur terpendek

Menghitung total jarak & waktu

4. graphMalkotPrem (Main Program)

Berisi:

Inisialisasi peta Kota Malang

Input pengguna

Output hasil pencarian rute

🗂️ Data Peta Kota Malang

Beberapa lokasi yang digunakan:

Stasiun Kota Baru

Alun-Alun Kota Malang

Kayutangan

Balai Kota

Museum Brawijaya

Ijen Boulevard

Matos

Universitas Brawijaya

Seluruh lokasi dikoneksikan dengan jarak dan waktu tempuh realistis.

▶️ Cara Menjalankan Program

Pastikan Java sudah terinstal.

Simpan file dengan struktur package yang sesuai (GRAPHPAKBUCE).

Jalankan program:

javac graphMalkotPrem.java
java GRAPHPAKBUCE.graphMalkotPrem


Masukkan titik asal dan tujuan sesuai daftar lokasi.

Program akan menampilkan:

Status keterjangkauan (BFS & DFS)

Jalur versi BFS

Jalur versi DFS

Jalur terpendek versi Dijkstra

📝 Contoh Output
=== Program Peta Kota Malang ===
Daftar Lokasi:
- Stasiun Kota Baru
- Alun-Alun Kota Malang
- Kayutangan
- ...

Dari Stasiun Kota Baru menuju Universitas Brawijaya:
BFS: Dapat dijangkau
DFS: Dapat dijangkau

Menggunakan BFS:
Total jarak: 7 km, total waktu: 40 menit
Jalur: Stasiun Kota Baru , Alun-Alun Kota Malang , Kayutangan , ...

Menggunakan Dijkstra (Jalur Terpendek):
Total jarak: 6 km, total waktu: 28 menit
Jalur: Stasiun Kota Baru , Alun-Alun Kota Malang , Kayutangan , Balai Kota , ...

🧠 Algoritma yang Digunakan
BFS

Cocok untuk mencari rute dengan lapisan terdekat terlebih dahulu.
Menjamin menemukan jalur dengan jumlah simpul paling sedikit—bukan jarak.

DFS

Menjelajah secara mendalam.
Tidak menjamin jalur paling optimal.

Dijkstra

Menghasilkan jalur paling pendek berdasarkan jarak.
Menggunakan priority queue untuk efisiensi.

📄 Lisensi

Kode ini dapat digunakan bebas untuk keperluan pembelajaran.
