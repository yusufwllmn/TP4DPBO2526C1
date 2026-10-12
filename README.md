# Data Karyawan

## Janji

Saya Yusuf Willman Hammam dengan NIM 2511185 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain Pemrograman Berorientasi Objek (DPBO) untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Desain

Program pengelolaan data orang berbasis GUI (Java Swing) yang mendukung operasi **CRUD** (Create, Read, Update, Delete). Data disimpan di dalam `ArrayList`, sehingga akan kembali ke data awal setiap program dijalankan ulang.

## Atribut dan Method

### Person
* Atribut: `id`, `nama`, `tahun` (tahun lahir), `kategori`, `email`
* Method: Constructor, Getter, dan Setter untuk setiap atributnya

### PeopleMenu (turunan `JFrame`)
* Atribut:
  * `listPerson`: menampung semua objek `Person`
  * `selectedIndex`: index baris tabel yang sedang dipilih (-1 jika belum ada)
  * Komponen form: field `id`, `nama`, `tahun`, `email`, combo box `kategori`, serta tombol `Add/Update`, `Remove`, dan `Cancel`
* Method:
  * `populateList()`: mengisi 5 data awal
  * `setTable()`: membuat isi tabel dari `listPerson`
  * `insertData()`: menambah data baru
  * `updateData()`: mengubah data yang dipilih
  * `deleteData()`: menghapus data yang dipilih setelah konfirmasi
  * `clearForm()`: mengosongkan form dan mengembalikan tombol ke kondisi awal

## Penjelasan Desain

Data orang dibuat dalam class `Person` tersendiri, sedangkan `PeopleMenu` fokus mengurus tampilan dan menjalankan operasi CRUD terhadap `listPerson`.

Saat sebuah baris di tabel diklik, datanya ditampilkan di form, tombol **Add** berubah menjadi **Update**, dan tombol **Remove** ditampilkan. Semua field wajib diisi sebelum data bisa ditambah atau diubah, jika ada yang kosong akan muncul pesan peringatan. Penghapusan data selalu meminta konfirmasi terlebih dahulu. Tombol **Cancel** digunakan untuk membatalkan pilihan dan mengosongkan form.

## Alur Program

1. Program dijalankan, tabel menampilkan 5 data awal (**Read**).
2. Isi semua field pada form lalu klik **Add**, data baru muncul di tabel (**Create**).
3. Klik salah satu baris di tabel, datanya tampil di form dan tombol **Add** berubah menjadi **Update**.
4. Ubah isi form lalu klik **Update**, data di tabel ikut berubah (**Update**).
5. Pilih satu baris lalu klik **Remove** dan konfirmasi dengan **Yes**, data hilang dari tabel (**Delete**).
6. Klik **Cancel** untuk mengosongkan form dan membatalkan pilihan baris.

## Dokumentasi

1. Tampilan Awal (Read)
<img width="688" height="593" alt="Hapus #3" src="https://github.com/user-attachments/assets/f5906d7c-a6f7-4d35-bc53-bef03016b6ca" />

2. Menambah Data (Create)
<img width="684" height="590" alt="Tambah #1" src="https://github.com/user-attachments/assets/d5f1519f-c464-4405-87f7-0df9f0051139" />
<img width="685" height="591" alt="Tambah #2" src="https://github.com/user-attachments/assets/a2685c93-6b9a-41c6-a5d6-b0d1b5bf239a" />

3. Mengubah Data (Update)
<img width="685" height="591" alt="Update #1" src="https://github.com/user-attachments/assets/6d7cded4-75c6-44da-8910-1e4356468aae" />
<img width="687" height="592" alt="Update #2" src="https://github.com/user-attachments/assets/88113c46-ed0a-48e2-bc10-e02238f51772" />
<img width="685" height="594" alt="Update #3" src="https://github.com/user-attachments/assets/1fea137f-e452-452b-9a18-bac070e3f174" />

4. Menghapus Data (Delete)
<img width="687" height="592" alt="Hapus #1" src="https://github.com/user-attachments/assets/0d6ce03c-b747-4b6f-8aea-edefda2dd8d5" />
<img width="688" height="592" alt="Hapus #2" src="https://github.com/user-attachments/assets/c80833b5-b4a6-428c-864a-eed8e44c4c37" />
<img width="688" height="593" alt="Hapus #3" src="https://github.com/user-attachments/assets/79d2589c-6856-499c-8a70-88f01eaf008d" />
