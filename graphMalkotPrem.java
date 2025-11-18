package GRAPHPAKBUCE;
import java.util.*;

// =========================
// Class Edge
// =========================
class Edge {
    String tujuan;
    int jarak;
    int waktu;

    public Edge(String tujuan, int jarak, int waktu) {
        this.tujuan = tujuan;
        this.jarak = jarak;
        this.waktu = waktu;
    }
}

// =========================
// Class PathResult
// =========================
class PathResult {
    List<String> path;
    int jarak;
    int waktu;

    public PathResult(List<String> path, int jarak, int waktu) {
        this.path = path;
        this.jarak = jarak;
        this.waktu = waktu;
    }
}

// =========================
// CLASS GRAPH
// =========================
class Graphhh {

    private Map<String, List<Edge>> graph = new HashMap<>();

    // Tambah lokasi
    public void tambahLokasi(String nama) {
        graph.putIfAbsent(nama, new ArrayList<>());
    }

    // Tambah jalur (dua arah)
    public void tambahJalur(String A, String B, int jarak, int waktu) {
        tambahLokasi(A);
        tambahLokasi(B);
        graph.get(A).add(new Edge(B, jarak, waktu));
        graph.get(B).add(new Edge(A, jarak, waktu));
    }

    // Ambil semua lokasi
    public Set<String> getLokasi() {
        return graph.keySet();
    }

    // Cek apakah lokasi ada
    public boolean lokasiAda(String lokasi) {
        return graph.containsKey(lokasi);
    }

    // ======================
    // BFS Cek keterjangkauan
    // ======================
    public boolean bisaPergiBFS(String start, String goal) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            String now = q.poll();
            if (now.equals(goal)) return true;

            if (!visited.contains(now)) {
                visited.add(now);
                for (Edge e : graph.get(now)) {
                    q.add(e.tujuan);
                }
            }
        }
        return false;
    }

    // ======================
    // DFS cek keterjangkauan
    // ======================
    public boolean bisaPergiDFS(String start, String goal) {
        return dfsHelper(start, goal, new HashSet<>());
    }

    private boolean dfsHelper(String now, String goal, Set<String> visited) {
        if (now.equals(goal)) return true;
        visited.add(now);

        for (Edge e : graph.get(now)) {
            if (!visited.contains(e.tujuan)) {
                if (dfsHelper(e.tujuan, goal, visited)) return true;
            }
        }
        return false;
    }

    // ======================
    // BFS Cari Rute
    // ======================
    public PathResult cariRuteBFS(String start, String goal) {
        Queue<List<String>> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(Arrays.asList(start));

        while (!q.isEmpty()) {
            List<String> path = q.poll();
            String now = path.get(path.size() - 1);

            if (now.equals(goal)) {
                return hitungPath(path);
            }

            if (!visited.contains(now)) {
                visited.add(now);

                for (Edge e : graph.get(now)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(e.tujuan);
                    q.add(newPath);
                }
            }
        }
        return null;
    }

    // ======================
    // DFS Cari Rute
    // ======================
    public PathResult cariRuteDFS(String start, String goal) {
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        path.add(start);

        if (dfsPathHelper(start, goal, visited, path))
            return hitungPath(path);

        return null;
    }

    private boolean dfsPathHelper(String now, String goal, Set<String> visited, List<String> path) {
        if (now.equals(goal)) return true;

        visited.add(now);

        for (Edge e : graph.get(now)) {
            if (!visited.contains(e.tujuan)) {
                path.add(e.tujuan);

                if (dfsPathHelper(e.tujuan, goal, visited, path))
                    return true;

                path.remove(path.size() - 1); // backtrack
            }
        }
        return false;
    }

    // ======================
    // DIJKSTRA - Jalur Terpendek
    // ======================
    public PathResult jalurTerpendek(String start, String goal) {

        Map<String, Integer> jarak = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(jarak::get));

        // Inisialisasi
        for (String node : graph.keySet()) {
            jarak.put(node, Integer.MAX_VALUE);
        }

        jarak.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String now = pq.poll();

            if (now.equals(goal)) break;

            for (Edge e : graph.get(now)) {
                int jarakBaru = jarak.get(now) + e.jarak;

                if (jarakBaru < jarak.get(e.tujuan)) {
                    jarak.put(e.tujuan, jarakBaru);
                    parent.put(e.tujuan, now);
                    pq.add(e.tujuan);
                }
            }
        }

        if (!parent.containsKey(goal) && !start.equals(goal)) {
            return null;
        }

        // Rekonstruksi path
        List<String> path = new ArrayList<>();
        String node = goal;
        path.add(goal);

        while (parent.containsKey(node)) {
            node = parent.get(node);
            path.add(0, node);
        }

        int totalJarak = jarak.get(goal);
        int totalWaktu = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            for (Edge e : graph.get(path.get(i))) {
                if (e.tujuan.equals(path.get(i + 1))) {
                    totalWaktu += e.waktu;
                    break;
                }
            }
        }

        return new PathResult(path, totalJarak, totalWaktu);
    }

    // ======================
    // Hitung Jarak & Waktu Path
    // ======================
    private PathResult hitungPath(List<String> path) {
        int totalJarak = 0;
        int totalWaktu = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            for (Edge e : graph.get(path.get(i))) {
                if (e.tujuan.equals(path.get(i + 1))) {
                    totalJarak += e.jarak;
                    totalWaktu += e.waktu;
                    break;
                }
            }
        }

        return new PathResult(path, totalJarak, totalWaktu);
    }
}


// =========================
// MAIN PROGRAM
// =========================
public class graphMalkotPrem {
    public static void main(String[] args) {

        Graphhh kota = new Graphhh();

        // DATA PETA MALANG
        kota.tambahJalur("Stasiun Kota Baru", "Alun-Alun Kota Malang", 1, 7);
        kota.tambahJalur("Alun-Alun Kota Malang", "Kayutangan", 1, 5);
        kota.tambahJalur("Kayutangan", "Balai Kota", 1, 3);
        kota.tambahJalur("Balai Kota", "Museum Brawijaya", 2, 10);
        kota.tambahJalur("Museum Brawijaya", "Ijen Boulevard", 1, 3);
        kota.tambahJalur("Ijen Boulevard", "Matos", 2, 10);
        kota.tambahJalur("Matos", "Universitas Brawijaya", 1, 5);
        kota.tambahJalur("Museum Brawijaya", "Universitas Brawijaya", 2, 12);

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Program Peta Kota Malang ===");
        System.out.println("Daftar Lokasi:");

        for (String lokasi : kota.getLokasi()) {
            System.out.println("- " + lokasi);
        }

        System.out.println("----------------------------------");
        System.out.println("NOTE: Penulisan harus sama persis (case-sensitive)");
        System.out.println();

        String start;
        while (true) {
            System.out.print("Masukkan titik asal: ");
            start = sc.nextLine();
            if (kota.lokasiAda(start)) break;
            System.out.println("!! Lokasi tidak ditemukan, coba lagi !!");
        }

        String goal;
        while (true) {
            System.out.print("Masukkan titik tujuan: ");
            goal = sc.nextLine();
            if (kota.lokasiAda(goal)) break;
            System.out.println("!! Lokasi tidak ditemukan, coba lagi !!");
        }

        System.out.println("\n--- HASIL ---");
        System.out.println("Dari " + start + " menuju " + goal + ":");

        boolean bfsReach = kota.bisaPergiBFS(start, goal);
        boolean dfsReach = kota.bisaPergiDFS(start, goal);

        System.out.println("BFS: " + (bfsReach ? "Dapat dijangkau" : "Tidak dapat dijangkau"));
        System.out.println("DFS: " + (dfsReach ? "Dapat dijangkau" : "Tidak dapat dijangkau"));

        if (!bfsReach && !dfsReach) {
            System.out.println("\nJalur tidak dapat dijangkau.");
            return;
        }

        PathResult bfsPath = kota.cariRuteBFS(start, goal);
        PathResult dfsPath = kota.cariRuteDFS(start, goal);
        PathResult dijkstraPath = kota.jalurTerpendek(start, goal);

        System.out.println("\nMenggunakan BFS:");
        System.out.println("Total jarak: " + bfsPath.jarak + " km, total waktu: " + bfsPath.waktu + " menit");
        System.out.println("Jalur: " + String.join(" , ", bfsPath.path));

        System.out.println("\nMenggunakan DFS:");
        System.out.println("Total jarak: " + dfsPath.jarak + " km, total waktu: " + dfsPath.waktu + " menit");
        System.out.println("Jalur: " + String.join(" , ", dfsPath.path));
        System.out.println("\nMenggunakan Dijkstra (Jalur Terpendek):");
        if (dijkstraPath == null) {
            System.out.println("Jalur tidak ditemukan.");
        } else {
            System.out.println("Total jarak: " + dijkstraPath.jarak + " km, total waktu: " + dijkstraPath.waktu + " menit");
            System.out.println("Jalur: " + String.join(" , ", dijkstraPath.path));
        }
    }
}


