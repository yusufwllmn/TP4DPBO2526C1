public class Person {

    private String id;
    private String nama;
    private String tahun;
    private String kategori;
    private String email;

    // Constructor
    public Person() {
    }

    public Person(String id, String nama, String tahun, String kategori, String email) {
        this.id = id;
        this.nama = nama;
        this.tahun = tahun;
        this.kategori = kategori;
        this.email = email;
    }

    // Getter untuk ID
    public String getId() { return id; }

    // Setter untuk ID
    public String setId(String id) { return this.id = id; }

    // Getter untuk Nama
    public String getNama() { return nama;}

    // Setter untuk Nama
    public String setNama(String nama) { return this.nama = nama; }

    // Getter untuk Tahun
    public String getTahun() { return tahun; }

    // Setter untuk Tahun
    public String setTahun(String tahun) { return this.tahun = tahun; }

    // Getter untuk Kategori
    public String getKategori() { return kategori; }

    // Setter untuk Kategori
    public String setKategori(String kategori) { return this.kategori = kategori; }

    // Getter untuk Email
    public String getEmail() { return email; }

    // Setter untuk Email
    public String setEmail(String email) { return this.email = email; }
}
