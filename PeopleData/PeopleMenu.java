import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PeopleMenu extends JFrame {
    public static void main(String[] args) {
        // buat object window
        PeopleMenu menu = new PeopleMenu();

        // atur ukuran window
        menu.setSize(700, 600);

        // letakkan window di tengah layar
        menu.setLocationRelativeTo(null);

        // isi window
        menu.setContentPane(menu.mainPanel);

        // ubah warna background
        menu.getContentPane().setBackground(Color.WHITE);

        // tampilkan window
        menu.setVisible(true);

        // agar program ikut berhenti saat window diclose
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // index baris yang diklik (-1 jika tidak ada yang dipilih)
    private int selectedIndex = -1;

    // list untuk menampung semua data person
    private ArrayList<Person> listPerson;

    private JTable peopleMenu;
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField namaField;
    private JTextField tahunField;
    private JComboBox kategoriField;
    private JTextField emailField;
    private JButton addButton;
    private JButton removeButton;
    private JLabel titleLabel;
    private JButton cancelButton;

    public PeopleMenu() {
        // inisialisasi list data
        listPerson = new ArrayList<>();

        // isi data dummy awal
        populateList();

        // set model tabel awal
        peopleMenu.setModel(setTable());

        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // atur isi combo box
        String[] kategoriData = {"???", "Full-time", "Part-time", "Contract", "Internship"};
        kategoriField.setModel(new DefaultComboBoxModel<>(kategoriData));

        // sembunyikan tombol remove saat belum ada data yang dipilih
        removeButton.setVisible(false);

        // Listener tombol Add / Update
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    insertData();
                } else {
                    updateData();
                }
            }
        });

        // Listener tombol Remove (dengan prompt konfirmasi penghapusan)
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex >= 0) {
                    deleteData();
                }
            }
        });

        // Listener klik area panel untuk reset/batalkan seleksi tabel
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        // Listener saat baris di tabel diklik
        peopleMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedIndex = peopleMenu.getSelectedRow();

                if (selectedIndex >= 0) {
                    Person person = listPerson.get(selectedIndex);
                    idField.setText(person.getId());
                    namaField.setText(person.getNama());
                    tahunField.setText(person.getTahun());
                    kategoriField.setSelectedItem(person.getKategori());
                    emailField.setText(person.getEmail());

                    // ubah teks tombol Add menjadi Update
                    addButton.setText("Update");
                    // tampilkan tombol Remove
                    removeButton.setVisible(true);
                }
            }
        });
    }

    // Method untuk mengisi data dummy awal
    public void populateList() {
        listPerson.add(new Person("2511185", "Yusuf Willman", "2006", "Full-time", "yusufwllmn@gmail.com"));
        listPerson.add(new Person("2556323", "Hasbie Assyattar", "2007", "Part-time", "hasbie@gmail.com"));
        listPerson.add(new Person("2500002", "Wingko Prajna", "2007", "Full-time", "wing@gmail.com"));
        listPerson.add(new Person("2578363", "Faiz", "2006", "Contract", "faiz@gmail.com"));
        listPerson.add(new Person("2510731", "Zahra", "2007", "Internship", "zhra@gmail.com"));
    }

    // Method untuk membuat model data tabel
    public final DefaultTableModel setTable() {
        Object[] cols = {"Id", "Nama", "Tahun lahir", "Kategori", "Email"};
        DefaultTableModel temp = new DefaultTableModel(null, cols);

        for (int i = 0; i < listPerson.size(); i++) {
            Person person = listPerson.get(i);
            Object[] data = {
                    person.getId(),
                    person.getNama(),
                    person.getTahun(),
                    person.getKategori(),
                    person.getEmail()
            };
            temp.addRow(data);
        }

        return temp;
    }

    // Method untuk menambah data baru
    public void insertData() {
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String tahun = tahunField.getText().trim();
        String kategori = kategoriField.getSelectedItem() != null ? kategoriField.getSelectedItem().toString() : "";
        String email = emailField.getText().trim();

        // Validasi input kosong
        if (id.isEmpty() || nama.isEmpty() || tahun.isEmpty() || kategori.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tambah ke list
        listPerson.add(new Person(id, nama, tahun, kategori, email));

        // Refresh tabel
        peopleMenu.setModel(setTable());

        // Reset form
        clearForm();

        // Pesan sukses
        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method untuk mengubah data yang dipilih
    public void updateData() {
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String tahun = tahunField.getText().trim();
        String kategori = kategoriField.getSelectedItem() != null ? kategoriField.getSelectedItem().toString() : "";
        String email = emailField.getText().trim();

        // Validasi input kosong
        if (id.isEmpty() || nama.isEmpty() || tahun.isEmpty() || kategori.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Update data pada list
        Person person = listPerson.get(selectedIndex);
        person.setId(id);
        person.setNama(nama);
        person.setTahun(tahun);
        person.setKategori(kategori);
        person.setEmail(email);

        // Refresh tabel
        peopleMenu.setModel(setTable());

        // Reset form
        clearForm();

        // Pesan sukses
        JOptionPane.showMessageDialog(this, "Data berhasil diubah!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method untuk menghapus data dengan confirmation prompt
    public void deleteData() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            listPerson.remove(selectedIndex);
            peopleMenu.setModel(setTable());
            clearForm();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method untuk mereset form input dan status tombol
    public void clearForm() {
        idField.setText("");
        namaField.setText("");
        tahunField.setText("");
        if (kategoriField.getItemCount() > 0) {
            kategoriField.setSelectedIndex(0);
        }
        emailField.setText("");
        addButton.setText("Add");
        removeButton.setVisible(false);
        selectedIndex = -1;
    }
}
