# 🗺️ Graph Case-Based: Rute Kota Malang

Program ini merupakan simulasi peta sederhana Kota Malang menggunakan struktur **Graph**.  
Di dalamnya terdapat fitur untuk mengecek keterjangkauan lokasi serta menemukan jalur dari satu titik ke titik lain menggunakan tiga algoritma:

- **BFS (Breadth First Search)**
- **DFS (Depth First Search)**
- **Dijkstra (Shortest Path)**

Program berjalan di terminal dan menerima input lokasi asal dan tujuan dari pengguna.

---

## 📌 Fitur Utama

### 1. Representasi Graph
- Setiap **node** adalah lokasi di Kota Malang  
- Setiap **edge** memiliki:
  - Jarak (km)
  - Waktu tempuh (menit)
- Graph bersifat **dua arah**

### 2. Cek Keterjangkauan
Program dapat menentukan apakah dua titik saling terhubung menggunakan:
- BFS
- DFS

### 3. Pencarian Jalur
Program menghasilkan:
- Jalur lengkap (list lokasi)
- Total jarak tempuh
- Total waktu tempuh

Metode yang tersedia:
- BFS → eksplorasi per level  
- DFS → eksplorasi mendalam  
- Dijkstra → jalur terpendek berdasarkan jarak

---

## 🏛️ Struktur Kode

### **1. Edge**
Menyimpan data jalur:
```java
class Edge {
    String tujuan;
    int jarak;
    int waktu;
}
````

### **2. PathResult**

Menyimpan hasil perhitungan rute:

```java
class PathResult {
    List<String> path;
    int jarak;
    int waktu;
}
```

### **3. Graphhh**

Fungsi utama mencakup:

* Menambah lokasi & jalur
* BFS & DFS reachability check
* BFS & DFS route search
* Dijkstra shortest path
* Menghitung total jarak & waktu rute

### **4. graphMalkotPrem (Main Program)**

Terdiri dari:

* Inisialisasi peta Kota Malang
* Input titik asal & tujuan
* Menampilkan hasil BFS, DFS, dan Dijkstra

---

## 🗂️ Data Peta Kota Malang

Lokasi yang digunakan antara lain:

* Stasiun Kota Baru
* Alun-Alun Kota Malang
* Kayutangan
* Balai Kota
* Museum Brawijaya
* Ijen Boulevard
* Matos
* Universitas Brawijaya

Semua lokasi saling terhubung melalui jalur dengan jarak & waktu yang realistis.

---

## ▶️ Cara Menjalankan Program

1. Pastikan Java terinstal
2. Simpan file dengan struktur package:

```
GRAPHPAKBUCE
```

3. Compile program:

```bash
javac graphMalkotPrem.java
```

4. Jalankan:

```bash
java GRAPHPAKBUCE.graphMalkotPrem
```

5. Masukkan titik asal dan tujuan sesuai daftar lokasi

Program akan menampilkan:

* Status keterjangkauan (BFS & DFS)
* Jalur hasil BFS
* Jalur hasil DFS
* Jalur terpendek hasil Dijkstra

---

## 📝 Contoh Output

```
=== Program Peta Kota Malang ===
Daftar Lokasi:
- Balai Kota
- Universitas Brawijaya
- Ijen Boulevard
- Kayutangan
- Stasiun Kota Baru
- Alun-Alun Kota Malang
- Museum Brawijaya
- Matos
----------------------------------
NOTE: Penulisan harus sama persis (case-sensitive)
Masukkan titik asal: Balai Kota
Masukkan titik tujuan: Matos

--- HASIL ---
Dari Balai Kota menuju Matos:
BFS: Dapat dijangkau
DFS: Dapat dijangkau

Menggunakan BFS:
Total jarak: 5 km, total waktu: 23 menit
Jalur: Balai Kota , Museum Brawijaya , Ijen Boulevard , Matos

Menggunakan DFS:
Total jarak: 5 km, total waktu: 23 menit
Jalur: Balai Kota , Museum Brawijaya , Ijen Boulevard , Matos

Menggunakan Dijkstra (Jalur Terpendek):
Total jarak: 5 km, total waktu: 23 menit
Jalur: Balai Kota , Museum Brawijaya , Ijen Boulevard , Matos
```

---

## 🧠 Algoritma yang Digunakan

### **BFS**

* Menjelajah per level
* Menjamin jumlah node paling sedikit
* Tidak menjamin jarak terpendek

### **DFS**

* Menjelajah secara mendalam
* Tidak menjamin rute optimal
* Cocok untuk eksplorasi keseluruhan jalur

### **Dijkstra**

* Menemukan rute **dengan jarak total paling pendek**
* Menggunakan priority queue untuk efisiensi

---

## 📄 Lisensi

Program ini bebas digunakan untuk pembelajaran dan pengembangan.

